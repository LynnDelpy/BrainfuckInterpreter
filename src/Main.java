public class Main {
    public static void main(String[] args) {
        SwingBrainfuckInterpreterGUI gui = new SwingBrainfuckInterpreterGUI();

        javax.swing.SwingUtilities.invokeLater(() -> {
            gui.setVisible(true);
        });
    }
}
