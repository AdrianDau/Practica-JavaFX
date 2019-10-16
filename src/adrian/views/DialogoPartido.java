package adrian.views;

import adrian.utils.FechaUtil;
import adrian.logica.Logica;
import adrian.models.Partido;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.text.ParseException;
import java.util.Date;


public class DialogoPartido extends Stage {
    private TextField equipoLocalTf;
    private TextField equipoVisitanteTf;
    private TextField resultadoLocalTf;
    private TextField resultadoVisitanteTf;
    private TextField divisionTf;
    private TextField fechaTf;
    private Button botonAceptar;

    public DialogoPartido(){
        inicializarVista();
        botonAceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                addPartido();
            }
        });
    }

        public DialogoPartido(Partido partido, int posicion){
            inicializarVista();
            equipoLocalTf.setText(partido.getEquipoLocal());
            equipoVisitanteTf.setText(partido.getEquipoVisitante());
            resultadoLocalTf.setText(Integer.toString(partido.getResultadoLocal()));
            resultadoVisitanteTf.setText(Integer.toString(partido.getResultadoVisitante()));
            divisionTf.setText(Integer.toString(partido.getDivision()));

            botonAceptar.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    String equipoLocal = equipoLocalTf.getText();
                    String equipoVisitante = equipoVisitanteTf.getText();
                    int resultadoLocal = Integer.parseInt(resultadoLocalTf.getText());
                    int resultadoVisitante = Integer.parseInt(resultadoVisitanteTf.getText());
                    int division = Integer.parseInt(divisionTf.getText());

                    String fecha = fechaTf.getText();

                    try {
                        Date date = FechaUtil.convertirFecha(fecha);
                        Partido partidoP = new Partido(equipoLocal, equipoVisitante, resultadoLocal, resultadoVisitante, division, date);
                        Logica.getInstance().modificarPartido(partidoP, posicion);
                        close();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });

        }

        private void inicializarVista(){
            initModality(Modality.APPLICATION_MODAL);
            setTitle("Añadir partido");
            VBox vbox = new VBox();
            vbox.getChildren().add(new Label("Equipo Local:"));
            equipoLocalTf = new TextField();
            vbox.getChildren().add(equipoLocalTf);
            vbox.getChildren().add(new Label("Equipo Visitante:"));
            equipoVisitanteTf = new TextField();
            vbox.getChildren().add(equipoVisitanteTf);
            vbox.getChildren().add(new Label("Resultado Local:"));
            resultadoLocalTf = new TextField();
            vbox.getChildren().add(resultadoLocalTf);
            vbox.getChildren().add(new Label("Resultado Visitante:"));
            resultadoVisitanteTf = new TextField();
            vbox.getChildren().add(resultadoVisitanteTf);
            vbox.getChildren().add(new Label("Division:"));
            divisionTf = new TextField();
            vbox.getChildren().add(divisionTf);
            vbox.getChildren().add(new Label("Fecha: dd-mm-YYYY"));
            fechaTf = new TextField();
            vbox.getChildren().add(fechaTf);

            botonAceptar = new Button("Aceptar");

            vbox.setSpacing(10);

            vbox.getChildren().add(botonAceptar);
            Scene sceneDialog = new Scene(vbox, 300, 400);
            setScene(sceneDialog);
        }

        private void addPartido()
        {
            int resLocal = Integer.parseInt(resultadoLocalTf.getText());
            int resVisitante = Integer.parseInt(resultadoVisitanteTf.getText());
            int division = Integer.parseInt(divisionTf.getText());

            String fecha = fechaTf.getText();

            try {
                Date date = FechaUtil.convertirFecha(fecha);
                Partido partido = new Partido(equipoLocalTf.getText(), equipoVisitanteTf.getText(), resLocal, resVisitante, division, date);
                Logica.getInstance().addPartido(partido);
                close();
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }

    }

