package adrian.views;

import adrian.logica.Logica;
import adrian.models.Partido;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Gestión de partidos");
        TableView tableViewPartidos = new TableView(Logica.getInstance().getPartidos());
        AnchorPane.setTopAnchor(tableViewPartidos,10d);
        AnchorPane.setLeftAnchor(tableViewPartidos,10d);
        AnchorPane.setRightAnchor(tableViewPartidos,10d);
        AnchorPane.setBottomAnchor(tableViewPartidos,50d);

        TableColumn<String, Partido> columna1 = new TableColumn<>("Equipo local");
        columna1.setCellValueFactory(new PropertyValueFactory<>("EquipoLocal"));
        columna1.prefWidthProperty().bind(tableViewPartidos.widthProperty().multiply(0.15));

        TableColumn<String, Partido> columna2 = new TableColumn<>("Equipo visitante");
        columna2.setCellValueFactory(new PropertyValueFactory<>("EquipoVisitante"));
        columna2.prefWidthProperty().bind(tableViewPartidos.widthProperty().multiply(0.15));

        TableColumn<String, Partido> columna3 = new TableColumn<>("Resultado local");
        columna3.setCellValueFactory(new PropertyValueFactory<>("ResultadoLocal"));
        columna3.prefWidthProperty().bind(tableViewPartidos.widthProperty().multiply(0.15));

        TableColumn<String, Partido> columna4 = new TableColumn<>("Resultado visitante");
        columna4.setCellValueFactory(new PropertyValueFactory<>("ResultadoVisitante"));
        columna4.prefWidthProperty().bind(tableViewPartidos.widthProperty().multiply(0.15));

        TableColumn<String, Partido> columna5 = new TableColumn<>("Division");
        columna5.setCellValueFactory(new PropertyValueFactory<>("Division"));
        columna5.prefWidthProperty().bind(tableViewPartidos.widthProperty().multiply(0.15));

        TableColumn<String, Partido> columna6 = new TableColumn<>("Fecha");
        columna6.setCellValueFactory(new PropertyValueFactory<>("Fecha"));
        columna6.prefWidthProperty().bind(tableViewPartidos.widthProperty().multiply(0.15));

        tableViewPartidos.getColumns().addAll(columna1, columna2, columna3, columna4, columna5, columna6);

        Button botonAñadir = new Button("Añadir");
        AnchorPane.setBottomAnchor(botonAñadir, 10d);
        AnchorPane.setLeftAnchor(botonAñadir, 10d);

        Button botonBorrar = new Button("Borrar");
        AnchorPane.setBottomAnchor(botonBorrar, 10d);
        AnchorPane.setLeftAnchor(botonBorrar, 70d);

        Button botonModificar = new Button("Modificar");
        AnchorPane.setBottomAnchor(botonModificar, 10d);
        AnchorPane.setLeftAnchor(botonModificar, 130d);

        botonAñadir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DialogoPartido dialogoPartido = new DialogoPartido();
                dialogoPartido.show();

            }
        });

        botonModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int indice = tableViewPartidos.getSelectionModel().getSelectedIndex();
                Partido partidoSeleccionado = Logica.getInstance().getPartidos().get(indice);
                DialogoPartido dialogoPartido = new DialogoPartido(partidoSeleccionado, indice);
                dialogoPartido.show();
            }
        });

        botonBorrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int indiceBorrar = tableViewPartidos.getSelectionModel().getSelectedIndex();
                if (indiceBorrar>=0)
                    Logica.getInstance().borrarPartido(indiceBorrar);
            }
        });

        AnchorPane anchorPane = new AnchorPane(tableViewPartidos, botonAñadir, botonModificar, botonBorrar);
        Scene scene = new Scene(anchorPane, 1000, 1000);
        stage.setScene(scene);
        stage.show();


    }
    public static void main(String[] args) {

        launch();
    }
}