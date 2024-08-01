package zoologico;

import java.util.ArrayList;
import java.util.List;

public class Alimento {
    private String nombre;

    public Alimento(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public static List<Alimento> getListaAlimentos() {
        List<Alimento> listaAlimentos = new ArrayList<>();
        listaAlimentos.add(new Alimento("Carne"));
        listaAlimentos.add(new Alimento("Hierba"));
        listaAlimentos.add(new Alimento("Frutas"));
        listaAlimentos.add(new Alimento("Pescado"));
        return listaAlimentos;
    }
}
