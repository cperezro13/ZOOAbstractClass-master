package zoologico;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class zoologico extends JFrame {

    private JDesktopPane desktopPane;
    private JTextArea mainOutputArea;
    private List<Jaula> jaulas;

    public zoologico() {
        setTitle("Zoológico - Interfaz de Documento Múltiple");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Asignar");

        JMenuItem menuItemHabitat = new JMenuItem("Asignar Hábitat");
        menuItemHabitat.addActionListener(e -> crearAsignacionHabitat());

        JMenuItem menuItemAlimento = new JMenuItem("Asignar Alimento");
        menuItemAlimento.addActionListener(e -> crearAsignacionAlimento());

        JMenuItem menuItemJaula = new JMenuItem("Asignar Jaula");
        menuItemJaula.addActionListener(e -> crearAsignacionJaula());

        menu.add(menuItemHabitat);
        menu.add(menuItemAlimento);
        menu.add(menuItemJaula);
        menuBar.add(menu);

        JButton cantarButton = new JButton("Cantar");
        cantarButton.addActionListener(e -> crearCantar());
        menuBar.add(cantarButton);

        setJMenuBar(menuBar);

        mainOutputArea = new JTextArea(10, 40);
        mainOutputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(mainOutputArea);
        scrollPane.setBounds(20, 20, 760, 100);
        desktopPane.add(scrollPane);

        jaulas = List.of(new Jaula("1"), new Jaula("2"), new Jaula("3"), new Jaula("4"));
    }

    private void crearAsignacionHabitat() {
        JInternalFrame internalFrame = new JInternalFrame("Asignar Hábitat", true, true, true, true);
        internalFrame.setSize(400, 300);
        internalFrame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JComboBox<Animales> animalesComboBox = new JComboBox<>(Animales.getListaAnimales().toArray(new Animales[0]));
        panel.add(new JLabel("Seleccione Animal:"));
        panel.add(animalesComboBox);

        JList<Habitat> habitatList = new JList<>(Habitat.getListaHabitats().toArray(new Habitat[0]));
        habitatList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.add(new JLabel("Seleccione Hábitat:"));
        panel.add(new JScrollPane(habitatList));

        JButton asignarButton = new JButton("Asignar Hábitat");
        asignarButton.addActionListener(e -> asignarHabitat((Animales) animalesComboBox.getSelectedItem(), habitatList.getSelectedValue()));

        panel.add(asignarButton);
        internalFrame.add(panel);
        desktopPane.add(internalFrame);
    }

    private void asignarHabitat(Animales animal, Habitat habitat) {
        if (animal != null && habitat != null) {
            animal.setHabitat(habitat);
            mainOutputArea.append(animal + " ha sido ubicado en " + habitat + "\n");
        }
    }

    private void crearAsignacionAlimento() {
        JInternalFrame internalFrame = new JInternalFrame("Asignar Alimento", true, true, true, true);
        internalFrame.setSize(400, 300);
        internalFrame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JComboBox<Animales> animalesComboBox = new JComboBox<>(Animales.getListaAnimales().toArray(new Animales[0]));
        panel.add(new JLabel("Seleccione Animal:"));
        panel.add(animalesComboBox);

        JComboBox<Alimento> alimentoComboBox = new JComboBox<>(Alimento.getListaAlimentos().toArray(new Alimento[0]));
        panel.add(new JLabel("Seleccione Alimento:"));
        panel.add(alimentoComboBox);

        JButton asignarButton = new JButton("Asignar Alimento");
        asignarButton.addActionListener(e -> asignarAlimento((Animales) animalesComboBox.getSelectedItem(), (Alimento) alimentoComboBox.getSelectedItem()));

        panel.add(asignarButton);
        internalFrame.add(panel);
        desktopPane.add(internalFrame);
    }

    private void asignarAlimento(Animales animal, Alimento alimento) {
        if (animal != null && alimento != null) {
            animal.setAlimento(alimento);
            mainOutputArea.append(animal + " ha sido alimentado con " + alimento + "\n");
        }
    }

    private void crearAsignacionJaula() {
        JInternalFrame internalFrame = new JInternalFrame("Asignar Jaula", true, true, true, true);
        internalFrame.setSize(400, 300);
        internalFrame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JComboBox<Animales> animalesComboBox = new JComboBox<>(Animales.getListaAnimales().toArray(new Animales[0]));
        panel.add(new JLabel("Seleccione Animal:"));
        panel.add(animalesComboBox);

        JComboBox<Jaula> jaulaComboBox = new JComboBox<>(jaulas.toArray(new Jaula[0]));
        panel.add(new JLabel("Seleccione Jaula:"));
        panel.add(jaulaComboBox);

        JButton asignarButton = new JButton("Asignar Jaula");
        asignarButton.addActionListener(e -> asignarJaula((Animales) animalesComboBox.getSelectedItem(), (Jaula) jaulaComboBox.getSelectedItem()));

        panel.add(asignarButton);
        internalFrame.add(panel);
        desktopPane.add(internalFrame);
    }

    private void asignarJaula(Animales animal, Jaula jaula) {
        if (animal != null && jaula != null) {
            jaula.setAnimal(animal);
            mainOutputArea.append(animal + " ha sido asignado a " + jaula + "\n");
        }
    }

    private void crearCantar() {
        JInternalFrame internalFrame = new JInternalFrame("Cantar", true, true, true, true);
        internalFrame.setSize(400, 300);
        internalFrame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JComboBox<Animales> animalesComboBox = new JComboBox<>(Animales.getListaAnimales().toArray(new Animales[0]));
        panel.add(new JLabel("Seleccione Animal:"));
        panel.add(animalesComboBox);

        JButton cantarButton = new JButton("Cantar");
        cantarButton.addActionListener(e -> cantar((Animales) animalesComboBox.getSelectedItem()));

        panel.add(cantarButton);
        internalFrame.add(panel);
        desktopPane.add(internalFrame);
    }

    private void cantar(Animales animal) {
        if (animal != null) {
            animal.cantar(100); // Número arbitrario para cantar
            mainOutputArea.append(animal + " está cantando.\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new zoologico().setVisible(true));
    }
}
