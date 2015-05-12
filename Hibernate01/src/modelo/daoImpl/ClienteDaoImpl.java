/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.daoImpl;

import java.util.List;
import modelo.dao.ClienteDao;
import modelo.entidad.Cliente;
import modelo.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author WIEXME
 */
public class ClienteDaoImpl implements ClienteDao{

    @Override
    public List<Cliente> ListarCliente() {
        List<Cliente> lista = null;
        SessionFactory sf = null;
        Session session = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            Criteria criteria = session.createCriteria(Cliente.class); //Aqui hago un SELECT con CRITERIA
            lista = criteria.list();
            session.close();
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
            session.close();
        }
        return lista;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session =  sf.openSession();
            transaction = session.beginTransaction();
            session.save(cliente);
            transaction.commit();
            session.close();
            flat = true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            session.close();
            flat = false;
        }
        return flat;
    }

    @Override
    public boolean actualizarCliente(Cliente cliente) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session =  sf.openSession();
            transaction = session.beginTransaction();
            
            Cliente cUpdate = (Cliente)session.get(Cliente.class, cliente.getIdcliente());
            cUpdate.setIdcliente(cliente.getIdcliente());
            cUpdate.setNombres(cliente.getNombres());
            cUpdate.setApellidos(cliente.getApellidos());
            cUpdate.setDni(cliente.getDni());
            cUpdate.setSexo(cliente.getSexo());
            session.update(cUpdate);
            transaction.commit();
            session.close();
            flat = true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            session.close();
            flat = false;
        }
        return flat;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction transaction = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session =  sf.openSession();
            transaction = session.beginTransaction();
            
            Cliente cDelete = (Cliente)session.get(Cliente.class,cliente.getIdcliente());
            session.delete(cDelete);
            transaction.commit();
            session.close();
            flat = true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            session.close();
            flat = false;
        }
        return flat;
    }
    
}
