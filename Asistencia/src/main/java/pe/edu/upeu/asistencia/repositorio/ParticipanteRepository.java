package pe.edu.upeu.asistencia.repositorio;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import pe.edu.upeu.asistencia.enums.Carrera;
import pe.edu.upeu.asistencia.enums.TipoParticipante;
import pe.edu.upeu.asistencia.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public abstract class ParticipanteRepository {
   protected List<Cliente> clientes =new ArrayList<>();

   public List<Cliente> findAll(){
       clientes.add(new Cliente(
               new SimpleStringProperty("43631917"),
               new SimpleStringProperty("Juan"),
               new SimpleStringProperty("Apaza"),
               Carrera.SISTEMAS,
               TipoParticipante.ASISTENTE,
               new SimpleBooleanProperty(true)
                ));
       return clientes;
   }


}
