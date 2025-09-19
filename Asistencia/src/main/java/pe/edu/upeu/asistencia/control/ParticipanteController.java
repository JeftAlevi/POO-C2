package pe.edu.upeu.asistencia.control;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.asistencia.enums.Carrera;
import pe.edu.upeu.asistencia.enums.TipoParticipante;
import pe.edu.upeu.asistencia.modelo.Cliente;
import pe.edu.upeu.asistencia.servicio.ParticipanteServicioI;

@Controller
public class ParticipanteController {

    @FXML
    private ComboBox<Carrera> cbxCarrera;

    @FXML
    private ComboBox<TipoParticipante> cbxTipoParticipante;

    @FXML
    private TextField txtNombres,  txtApellidos, txtDni;
    @FXML
    private TableView<Cliente> tableRegPart;
    ObservableList<Cliente> clientes;
    @Autowired
    ParticipanteServicioI ps;
    TableColumn<Cliente, String> dniCol, nombreCol, apellidoCol, carreraCol, tipoParticipanteCol;
    TableColumn<Cliente, Void> opcCol;
    int indexEdit=-1;
    @FXML
    public void initialize(){
        cbxCarrera.getItems().addAll(Carrera.values());
        cbxTipoParticipante.getItems().addAll(TipoParticipante.values());
        cbxCarrera.getSelectionModel().select(4);
        Carrera carrera = cbxCarrera.getSelectionModel().getSelectedItem();
        System.out.println(carrera.name());
        definirColumnas();
        listarPartipantes();
    }
    public void limpiarFormulario(){
        txtNombres.setText("");
        txtApellidos.setText("");
        txtDni.setText("");
        cbxCarrera.getSelectionModel().clearSelection();
        cbxTipoParticipante.getSelectionModel().clearSelection();
    }
    @FXML
    public void registrarParticipante(){
        Cliente p = new Cliente();

        p.setDni(new SimpleStringProperty(txtDni.getText()));
        p.setNombre(new SimpleStringProperty(txtNombres.getText()));
        p.setApellidos(new SimpleStringProperty(txtApellidos.getText()));
        p.setCarrera(cbxCarrera.getSelectionModel().getSelectedItem());
        p.setTipoParticipante(cbxTipoParticipante.getSelectionModel().getSelectedItem());
        if(indexEdit==-1){
            ps.save(p);
        }else{
            ps.update(p,indexEdit);
            indexEdit=-1;
        }

        limpiarFormulario();
        listarPartipantes();
    }
    public void definirColumnas(){
        dniCol = new TableColumn<>("DNI");
        nombreCol = new TableColumn<>("Nombre");
        apellidoCol = new TableColumn<>("Apellido");
        carreraCol = new TableColumn<>("Carrera");
        tipoParticipanteCol = new TableColumn<>("Tipo Participante");
        opcCol=new TableColumn<>("Opciones");
        opcCol.setPrefWidth(200);
        tableRegPart.getColumns().addAll(dniCol, nombreCol, apellidoCol, carreraCol, tipoParticipanteCol, opcCol);
    }
    public void listarPartipantes(){
        dniCol.setCellValueFactory(cellData -> cellData.getValue().getDni());
        nombreCol.setCellValueFactory(cellData -> cellData.getValue().getNombre());
        apellidoCol.setCellValueFactory(cellData->cellData.getValue().getApellidos());
        carreraCol.setCellValueFactory(
                cellData->new SimpleStringProperty(cellData.getValue().getCarrera().toString())
        );
        tipoParticipanteCol.setCellValueFactory(
                cellData->new SimpleStringProperty(cellData.getValue().getTipoParticipante().toString())
        );
        agregarAccionesButton();
        clientes = FXCollections.observableList(ps.findAll());
        tableRegPart.setItems(clientes);
    }
    public void eliminarPartipantes(int index){
        ps.delete(index);
        listarPartipantes();
    }
    public void editarPartipante(Cliente p, int index){
        txtDni.setText(p.getDni().getValue());
        txtNombres.setText(p.getNombre().getValue());
        txtApellidos.setText(p.getApellidos().getValue());
        cbxTipoParticipante.getSelectionModel().select(p.getTipoParticipante());
        cbxCarrera.getSelectionModel().select(p.getCarrera());
        indexEdit=index;
    }

    public void agregarAccionesButton(){
        Callback<TableColumn<Cliente, Void>, TableCell<Cliente, Void>>
                cellFactory = param -> new TableCell<>(){
            private final Button btnEdit = new Button("Editar");
            private final Button btnDelet = new Button("Eliminar");
            {
                btnEdit.setOnAction(event -> {
                    Cliente p =getTableView().getItems().get(getIndex());
                    editarPartipante(p, getIndex());
                });
                btnDelet.setOnAction(event -> {
                    eliminarPartipantes(getIndex());
                });
            }
            @Override
            public void updateItem(Void item, boolean empty){
                super.updateItem(item, empty);
                if(empty){  setGraphic(null);  }else {
                    HBox hbox = new HBox(btnEdit, btnDelet);
                    hbox.setSpacing(10);
                    setGraphic(hbox);
                }
            }
        };
        opcCol.setCellFactory(cellFactory);
    }



}
