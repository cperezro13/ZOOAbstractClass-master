package zoologico;

public class Alimento {
    private String nombre;

    public Alimento(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
