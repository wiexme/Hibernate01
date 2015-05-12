/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import modelo.entidad.Cliente;

/**
 *
 * @author WIEXME
 */
public interface ClienteDao {
    public List<Cliente> ListarCliente();
    public boolean agregarCliente(Cliente cliente);
    public boolean actualizarCliente(Cliente cliente);
    public boolean eliminarCliente(Cliente cliente);
}
