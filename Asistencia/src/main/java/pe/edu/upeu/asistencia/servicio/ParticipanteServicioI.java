package pe.edu.upeu.asistencia.servicio;

import pe.edu.upeu.asistencia.modelo.Cliente;

import java.util.List;

public interface ParticipanteServicioI {
    void save(Cliente cliente); //C
    List<Cliente> findAll(); //R
    Cliente update(Cliente cliente, int index); //U
    void delete(int index); //D

    Cliente findById(int index); //B

}
