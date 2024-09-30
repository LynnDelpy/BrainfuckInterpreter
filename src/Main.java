public class Main {
    public static void main(String[] args) {
        // You can switch the GUI implementation here if needed
        SwingBrainfuckInterpreterGUI gui = new SwingBrainfuckInterpreterGUI();

        // Initialize and display the GUI
        javax.swing.SwingUtilities.invokeLater(() -> {
            gui.setVisible(true);
        });
    }
}
