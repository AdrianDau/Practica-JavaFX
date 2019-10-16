package adrian.logica;

import adrian.models.Partido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Logica {
    private static Logica INSTANCE = null;

    private ObservableList<Partido> partidos;

    private Logica()
    {
        partidos = FXCollections.observableArrayList();
    }

    public static Logica getInstance() {
        if (INSTANCE == null)
            INSTANCE = new Logica();

        return INSTANCE;
    }

    public void addPartido(Partido partido){
        partidos.add(partido);
    }

    public ObservableList<Partido> getPartidos(){
        return partidos;
    }

    public void borrarPartido(int indiceBorrar){
        partidos.remove(indiceBorrar);
    }

    public void modificarPartido(Partido partidoP, int posicion){
        partidos.set(posicion, partidoP);
    }
}
