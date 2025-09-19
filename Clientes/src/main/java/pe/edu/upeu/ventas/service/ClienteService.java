package pe.edu.upeu.ventas.service;

import pe.edu.upeu.ventas.model.Cliente;

public class ClienteService {
    public boolean validarDni(String dni) {
        return dni != null && dni.matches("\\d{8}");
    }

    public boolean validarTelefono(String telefono) {
        return telefono != null && telefono.matches("\\d{9}");
    }

    public boolean validarCliente(Cliente cliente) {
        return cliente.getNombre() != null && !cliente.getNombre().isEmpty()
                && validarDni(cliente.getDni())
                && validarTelefono(cliente.getTelefono());
    }
}