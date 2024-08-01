package zoologico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class zoologicoUI extends JFrame {
    
    private JComboBox<Alimento> alimentoComboBox;
    private JComboBox<Animales> animalesComboBox;
    private JList<Habitat> habitatList;
    private JTextArea outputArea;

    public zoologicoUI() {
        setTitle("Seleccionar Alimento y Hábitat para Animales");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear la lista de alimentos
        Alimento[] alimentos = {
            new Alimento("Carne"),
            new Alimento("Hierba"),
            new Alimento("Frutas"),
            new Alimento("Pescado")
        };
        
        alimentoComboBox = new JComboBox<>(alimentos);
        add(new JLabel("Seleccione Alimento:"));
        add(alimentoComboBox);

        // Crear la lista de animales
        Animales[] animales = {
            new Animales("León"),
            new Animales("Elefante"),
            new Animales("Mono"),
            new Animales("Pingüino")
        };
        
        animalesComboBox = new JComboBox<>(animales);
        add(new JLabel("Seleccione Animal:"));
        add(animalesComboBox);

        // Crear la lista de hábitats
        Habitat[] habitats = {
            new Habitat("Selva"),
            new Habitat("Desierto"),
            new Habitat("Sabana"),
            new Habitat("Antártida")
        };

        habitatList = new JList<>(habitats);
        habitatList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JLabel("Seleccione Hábitat:"));
        add(new JScrollPane(habitatList));

        JButton asignarButton = new JButton("Asignar Alimento y Hábitat");
        add(asignarButton);

        outputArea = new JTextArea(10, 40);
        add(new JScrollPane(outputArea));

        asignarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Alimento alimentoSeleccionado = (Alimento) alimentoComboBox.getSelectedItem();
                Animales animalSeleccionado = (Animales) animalesComboBox.getSelectedItem();
                Habitat habitatSeleccionado = habitatList.getSelectedValue();
                if (animalSeleccionado != null && alimentoSeleccionado != null && habitatSeleccionado != null) {
                    animalSeleccionado.setAlimento(alimentoSeleccionado);
                    animalSeleccionado.setHabitat(habitatSeleccionado);
                    outputArea.append(animalSeleccionado + " ha sido alimentado con " + alimentoSeleccionado + " y ubicado en " + habitatSeleccionado + "\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new zoologicoUI().setVisible(true);
            }
        });
    }
}
