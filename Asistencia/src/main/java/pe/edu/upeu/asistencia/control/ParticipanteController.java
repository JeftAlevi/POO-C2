package pe.edu.upeu.asistencia.control;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.asistencia.enums.Carrera;
import pe.edu.upeu.asistencia.enums.Facultad;
import pe.edu.upeu.asistencia.enums.TIpoParticipante;

@Controller
public class ParticipanteController {
    @FXML
    private ComboBox<Carrera> cbxCarrera;
    @FXML
    private ComboBox<TIpoParticipante> cbxTipoParticipante;
    @FXML
    public void initialize(){
        cbxCarrera.getItems().addAll(Carrera.values());
        cbxTipoParticipante.getItems().addAll(TIpoParticipante.values());

        cbxCarrera.getSelectionModel().selectLast();
        Carrera carrera = cbxCarrera.getSelectionModel().getSelectedItem();
        System.out.println(carrera.name());
    }
}
