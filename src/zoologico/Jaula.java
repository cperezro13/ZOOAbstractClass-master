package zoologico;

public class Jaula {
    private String id;
    private Animales animal;

    public Jaula(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setAnimal(Animales animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Jaula " + id + (animal != null ? " - " + animal : " - Vacía");
    }
}
