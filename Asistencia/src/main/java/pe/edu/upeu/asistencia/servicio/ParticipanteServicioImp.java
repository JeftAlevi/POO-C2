package pe.edu.upeu.asistencia.servicio;

import org.springframework.stereotype.Service;
import pe.edu.upeu.asistencia.modelo.Cliente;
import pe.edu.upeu.asistencia.repositorio.ParticipanteRepository;
import java.util.List;

@Service
public class ParticipanteServicioImp extends ParticipanteRepository
        implements ParticipanteServicioI {
    @Override
    public void save(Cliente cliente) {
        clientes.add(cliente);
    }
    @Override
    public Cliente update(Cliente cliente, int index) {
        return clientes.set(index, cliente);
    }
    @Override
    public void delete(int index) {
        clientes.remove(index);
    }
    @Override
    public Cliente findById(int index) {
        return clientes.get(index);
    }

    @Override
    public List<Cliente> findAll(){
        if(clientes.isEmpty()){
            return super.findAll();
        }
        return clientes;
    }
}
