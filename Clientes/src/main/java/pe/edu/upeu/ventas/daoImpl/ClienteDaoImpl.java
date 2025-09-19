package pe.edu.upeu.ventas.daoImpl;

import pe.edu.upeu.ventas.dao.ClienteDao;
import pe.edu.upeu.ventas.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {
    private final List<Cliente> clientes = new ArrayList<>();

    @Override
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == cliente.getId()) {
                clientes.set(i, cliente);
                break;
            }
        }
    }

    @Override
    public void eliminarCliente(int id) {
        clientes.removeIf(c -> c.getId() == id);
    }

    @Override
    public Cliente buscarClientePorId(int id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }
}