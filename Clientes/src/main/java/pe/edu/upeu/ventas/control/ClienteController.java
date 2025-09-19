package pe.edu.upeu.ventas.control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pe.edu.upeu.ventas.daoImpl.ClienteDaoImpl;
import pe.edu.upeu.ventas.model.Cliente;

public class ClienteController {
    @FXML private TableView<Cliente> tablaClientes;
    @FXML private TableColumn<Cliente, String> colNombre;
    @FXML private TableColumn<Cliente, String> colDni;
    @FXML private TableColumn<Cliente, String> colTelefono;
    @FXML private TableColumn<Cliente, String> colEmail;
    @FXML private TableColumn<Cliente, String> colDireccion;

    @FXML private TextField txtNombre;
    @FXML private TextField txtDni;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtEmail;
    @FXML private TextField txtDireccion;

    private final ClienteDaoImpl clienteDao = new ClienteDaoImpl();
    private ObservableList<Cliente> listaClientes;

    @FXML
    public void initialize() {
        listaClientes = FXCollections.observableArrayList(clienteDao.listarClientes());

        colNombre.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombre()));
        colDni.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDni()));
        colTelefono.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTelefono()));
        colEmail.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getEmail()));
        colDireccion.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDireccion()));

        tablaClientes.setItems(listaClientes);
    }

    @FXML
    private void agregarCliente() {
        Cliente cliente = new Cliente(
                listaClientes.size() + 1,
                txtNombre.getText(),
                txtDni.getText(),
                txtTelefono.getText(),
                txtEmail.getText(),
                txtDireccion.getText()
        );

        clienteDao.agregarCliente(cliente);
        listaClientes.setAll(clienteDao.listarClientes());

        txtNombre.clear();
        txtDni.clear();
        txtTelefono.clear();
        txtEmail.clear();
        txtDireccion.clear();
    }
}