package zoologico;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
    private String nombre;

    public Habitat(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public static List<Habitat> getListaHabitats() {
        List<Habitat> listaHabitats = new ArrayList<>();
        listaHabitats.add(new Habitat("Selva"));
        listaHabitats.add(new Habitat("Desierto"));
        listaHabitats.add(new Habitat("Sabana"));
        listaHabitats.add(new Habitat("Antártida"));
        return listaHabitats;
    }
}
