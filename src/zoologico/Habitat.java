package zoologico;

public class Habitat {
    private String nombre;

    public Habitat(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
