package pe.edu.upeu.ventas.dao;

import pe.edu.upeu.ventas.model.Cliente;
import java.util.List;

public interface ClienteDao {
    void agregarCliente(Cliente cliente);
    void actualizarCliente(Cliente cliente);
    void eliminarCliente(int id);
    Cliente buscarClientePorId(int id);
    List<Cliente> listarClientes();
}