/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.List;
import modelo.dao.ClienteDao;
import modelo.daoImpl.ClienteDaoImpl;
import modelo.entidad.Cliente;

/**
 *
 * @author WIEXME
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.select();
//      main.Insert();
//        main.Update();
//        main.Delete();
    }
    public  void select(){
        ClienteDao clienteDao = new ClienteDaoImpl();
        List<Cliente> listar = clienteDao.ListarCliente();
        
        for (Cliente cliente : listar) {
            System.out.println("ID: "+cliente.getIdcliente()+
                               " NOMBRE: "+cliente.getNombres()+
                                " APELLIDO: "+cliente.getApellidos()+
                                " DNI: "+cliente.getDni()+
                                " SEXO: "+cliente.getSexo());
            
        }
    }
    
    public void Insert(){
        ClienteDao clienteDao = new ClienteDaoImpl();
        Cliente cliente = new Cliente();
        
        cliente.setIdcliente(3);
        cliente.setNombres("Mariela");
        cliente.setApellidos("Cardenas Solsol");
        cliente.setDni(77663344);
        cliente.setSexo("F");
        
        if (clienteDao.agregarCliente(cliente)) {
            System.out.println("Se agrego la cliente...");
            
        } else {
            System.out.println("No se agrego el cliente");
        }
    }
    
    public void Update(){
        ClienteDao clienteDao = new ClienteDaoImpl();
        Cliente cliente = new Cliente();
        
        cliente.setIdcliente(3);
        cliente.setNombres("Pilar");
        cliente.setApellidos("Panduro Lopez");
        cliente.setDni(55632353);
        cliente.setSexo("F");
        
        if (clienteDao.actualizarCliente(cliente)) {
            System.out.println("Se modifico la cliente...");
            
        } else {
            System.out.println("No se modifico el cliente");
        }
    }
    
    public void Delete(){
        ClienteDao clienteDao = new ClienteDaoImpl();
           Cliente cliente = new Cliente();
           cliente.setIdcliente(3);
        if (clienteDao.eliminarCliente(cliente)) {
            System.out.println("Se elimino el cliente...");
            
        } else {
            System.out.println("No se elimino el cliente");
        }
   }

}
