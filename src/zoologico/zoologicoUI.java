package zoologico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

public class zoologicoUI extends JFrame {

    private JDesktopPane desktopPane;
    private JTextArea mainOutputArea;

    public zoologicoUI() {
        setTitle("Zoológico - Interfaz de Documento Múltiple");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");

        JMenuItem menuItemHabitat = new JMenuItem("Asignar Hábitat");
        menuItemHabitat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearAsignacionHabitat();
            }
        });

        JMenuItem menuItemAlimento = new JMenuItem("Asignar Alimento");
        menuItemAlimento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearAsignacionAlimento();
            }
        });

        menu.add(menuItemHabitat);
        menu.add(menuItemAlimento);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        mainOutputArea = new JTextArea(10, 40);
        mainOutputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(mainOutputArea);
        scrollPane.setBounds(20, 20, 760, 100);
        desktopPane.add(scrollPane);
    }

    private void crearAsignacionHabitat() {
        JInternalFrame internalFrame = new JInternalFrame("Asignar Hábitat", true, true, true, true);
        internalFrame.setSize(400, 300);
        internalFrame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Crear la lista de animales
        Animales[] animales = {
            new Animales("León"),
            new Animales("Elefante"),
            new Animales("Mono"),
            new Animales("Pingüino")
        };

        JComboBox<Animales> animalesComboBox = new JComboBox<>(animales);
        panel.add(new JLabel("Seleccione Animal:"));
        panel.add(animalesComboBox);

        // Crear la lista de hábitats
        Habitat[] habitats = {
            new Habitat("Selva"),
            new Habitat("Desierto"),
            new Habitat("Sabana"),
            new Habitat("Antártida")
        };

        JList<Habitat> habitatList = new JList<>(habitats);
        habitatList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.add(new JLabel("Seleccione Hábitat:"));
        panel.add(new JScrollPane(habitatList));

        JButton asignarButton = new JButton("Asignar Hábitat");
        panel.add(asignarButton);

        asignarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Animales animalSeleccionado = (Animales) animalesComboBox.getSelectedItem();
                Habitat habitatSeleccionado = habitatList.getSelectedValue();
                if (animalSeleccionado != null && habitatSeleccionado != null) {
                    animalSeleccionado.setHabitat(habitatSeleccionado);
                    mainOutputArea.append(animalSeleccionado + " ha sido ubicado en " + habitatSeleccionado + "\n");
                    internalFrame.dispose();
                }
            }
        });

        internalFrame.add(panel);
        desktopPane.add(internalFrame);
    }

    private void crearAsignacionAlimento() {
        JInternalFrame internalFrame = new JInternalFrame("Asignar Alimento", true, true, true, true);
        internalFrame.setSize(400, 300);
        internalFrame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Crear la lista de animales
        Animales[] animales = {
            new Animales("León"),
            new Animales("Elefante"),
            new Animales("Mono"),
            new Animales("Pingüino")
        };

        JComboBox<Animales> animalesComboBox = new JComboBox<>(animales);
        panel.add(new JLabel("Seleccione Animal:"));
        panel.add(animalesComboBox);

        // Crear la lista de alimentos
        Alimento[] alimentos = {
            new Alimento("Carne"),
            new Alimento("Hierba"),
            new Alimento("Frutas"),
            new Alimento("Pescado")
        };

        JComboBox<Alimento> alimentoComboBox = new JComboBox<>(alimentos);
        panel.add(new JLabel("Seleccione Alimento:"));
        panel.add(alimentoComboBox);

        JButton asignarButton = new JButton("Asignar Alimento");
        panel.add(asignarButton);

        asignarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Animales animalSeleccionado = (Animales) animalesComboBox.getSelectedItem();
                Alimento alimentoSeleccionado = (Alimento) alimentoComboBox.getSelectedItem();
                if (animalSeleccionado != null && alimentoSeleccionado != null) {
                    animalSeleccionado.setAlimento(alimentoSeleccionado);
                    mainOutputArea.append(animalSeleccionado + " ha sido alimentado con " + alimentoSeleccionado + "\n");
                    internalFrame.dispose();
                }
            }
        });

        internalFrame.add(panel);
        desktopPane.add(internalFrame);
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
