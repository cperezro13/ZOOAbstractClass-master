package zoologico;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class zoologicoUI extends JFrame {

    private JDesktopPane desktopPane;
    private JTextArea mainOutputArea;
    private List<Jaula> jaulas;

    public zoologicoUI() {
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

        // Inicializar lista de jaulas
        jaulas = List.of(new Jaula("1"), new Jaula("2"), new Jaula("3"), new Jaula("4"));
    }

    private void crearAsignacionHabitat() {
        JInternalFrame internalFrame = new JInternalFrame("Asignar Hábitat", true, true, true, true);
        internalFrame.setSize(400, 300);
        internalFrame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        List<Animales> listaAnimales = Animales.getListaAnimales();
        JComboBox<Animales> animalesComboBox = new JComboBox<>(listaAnimales.toArray(new Animales[0]));
        panel.add(new JLabel("Seleccione Animal:"));
        panel.add(animalesComboBox);

        List<Habitat> listaHabitats = Habitat.getListaHabitats();
        JList<Habitat> habitatList = new JList<>(listaHabitats.toArray(new Habitat[0]));
        habitatList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.add(new JLabel("Seleccione Hábitat:"));
        panel.add(new JScrollPane(habitatList));

        JButton asignarButton = new JButton("Asignar Hábitat");
        asignarButton.addActionListener(e -> {
            Animales animalSeleccionado = (Animales) animalesComboBox.getSelectedItem();
            Habitat habitatSeleccionado = habitatList.getSelectedValue();
            if (animalSeleccionado != null && habitatSeleccionado != null) {
                animalSeleccionado.setHabitat(habitatSeleccionado);
                mainOutputArea.append(animalSeleccionado + " ha sido ubicado en " + habitatSeleccionado + "\n");
                internalFrame.dispose();
            }
        });

        panel.add(asignarButton);
        internalFrame.add(panel);
        desktopPane.add(internalFrame);
    }

    private void crearAsignacionAlimento() {
        JInternalFrame internalFrame = new JInternalFrame("Asignar Alimento", true, true, true, true);
        internalFrame.setSize(400, 300);
        internalFrame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        List<Animales> listaAnimales = Animales.getListaAnimales();
        JComboBox<Animales> animalesComboBox = new JComboBox<>(listaAnimales.toArray(new Animales[0]));
        panel.add(new JLabel("Seleccione Animal:"));
        panel.add(animalesComboBox);

        List<Alimento> listaAlimentos = Alimento.getListaAlimentos();
        JComboBox<Alimento> alimentoComboBox = new JComboBox<>(listaAlimentos.toArray(new Alimento[0]));
        panel.add(new JLabel("Seleccione Alimento:"));
        panel.add(alimentoComboBox);

        JButton asignarButton = new JButton("Asignar Alimento");
        asignarButton.addActionListener(e -> {
            Animales animalSeleccionado = (Animales) animalesComboBox.getSelectedItem();
            Alimento alimentoSeleccionado = (Alimento) alimentoComboBox.getSelectedItem();
            if (animalSeleccionado != null && alimentoSeleccionado != null) {
                animalSeleccionado.setAlimento(alimentoSeleccionado);
                mainOutputArea.append(animalSeleccionado + " ha sido alimentado con " + alimentoSeleccionado + "\n");
                internalFrame.dispose();
            }
        });

        panel.add(asignarButton);
        internalFrame.add(panel);
        desktopPane.add(internalFrame);
    }

    private void crearAsignacionJaula() {
        JInternalFrame internalFrame = new JInternalFrame("Asignar Jaula", true, true, true, true);
        internalFrame.setSize(400, 300);
        internalFrame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        List<Animales> listaAnimales = Animales.getListaAnimales();
        JComboBox<Animales> animalesComboBox = new JComboBox<>(listaAnimales.toArray(new Animales[0]));
        panel.add(new JLabel("Seleccione Animal:"));
        panel.add(animalesComboBox);

        JComboBox<Jaula> jaulaComboBox = new JComboBox<>(jaulas.toArray(new Jaula[0]));
        panel.add(new JLabel("Seleccione Jaula:"));
        panel.add(jaulaComboBox);

        JButton asignarButton = new JButton("Asignar Jaula");
        asignarButton.addActionListener(e -> {
            Animales animalSeleccionado = (Animales) animalesComboBox.getSelectedItem();
            Jaula jaulaSeleccionada = (Jaula) jaulaComboBox.getSelectedItem();
            if (animalSeleccionado != null && jaulaSeleccionada != null) {
                jaulaSeleccionada.setAnimal(animalSeleccionado);
                mainOutputArea.append(animalSeleccionado + " ha sido asignado a " + jaulaSeleccionada + "\n");
                internalFrame.dispose();
            }
        });

        panel.add(asignarButton);
        internalFrame.add(panel);
        desktopPane.add(internalFrame);
    }

    private void crearCantar() {
        JInternalFrame internalFrame = new JInternalFrame("Cantar", true, true, true, true);
        internalFrame.setSize(400, 300);
        internalFrame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        List<Animales> listaAnimales = Animales.getListaAnimales();
        JComboBox<Animales> animalesComboBox = new JComboBox<>(listaAnimales.toArray(new Animales[0]));
        panel.add(new JLabel("Seleccione Animal:"));
        panel.add(animalesComboBox);

        JButton cantarButton = new JButton("Cantar");
        cantarButton.addActionListener(e -> {
            Animales animalSeleccionado = (Animales) animalesComboBox.getSelectedItem();
            if (animalSeleccionado != null) {
                animalSeleccionado.cantar(100); // Número arbitrario para cantar
                mainOutputArea.append(animalSeleccionado + " está cantando.\n");
                internalFrame.dispose();
            }
        });

        panel.add(cantarButton);
        internalFrame.add(panel);
        desktopPane.add(internalFrame);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new zoologicoUI().setVisible(true));
    }
}
