package zoologico;

public class Animales extends Zoo {
    
    String nombre;
    Alimento alimento;
    Habitat habitat;

    public Animales(String nombre) {
        this.nombre = nombre;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    @Override
    public double cantar(double num) {
        double canto = Math.sqrt(num);
        System.out.println(nombre + " cantando... " + canto);
        return canto;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
