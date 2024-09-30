import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingBrainfuckInterpreterGUI extends JFrame implements BrainfuckInterpreterGUI {
    private JTextArea editorArea, outputArea, memoryArea;
    private JTextField inputField;
    private JButton runButton;
    private BrainfuckInterpreter interpreter;

    public SwingBrainfuckInterpreterGUI() {
        interpreter = new BrainfuckInterpreter();
        setTitle("Brainfuck Interpreter");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Editor area for writing Brainfuck code
        editorArea = new JTextArea(10, 40);
        JScrollPane editorScrollPane = new JScrollPane(editorArea);
        editorScrollPane.setBorder(BorderFactory.createTitledBorder("Brainfuck Editor"));

        // Input field
        inputField = new JTextField(20);
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input"));
        inputPanel.add(inputField);

        // Output area to display results
        outputArea = new JTextArea(5, 40);
        outputArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputArea);
        outputScrollPane.setBorder(BorderFactory.createTitledBorder("Output"));

        // Memory display area
        memoryArea = new JTextArea(5, 40);
        memoryArea.setEditable(false);
        JScrollPane memoryScrollPane = new JScrollPane(memoryArea);
        memoryScrollPane.setBorder(BorderFactory.createTitledBorder("Memory"));

        // Run button
        runButton = new JButton("Run");
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runBrainfuckCode();
            }
        });

        // Layout setup
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(editorScrollPane, BorderLayout.NORTH);
        topPanel.add(inputPanel, BorderLayout.SOUTH);

        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
        bottomPanel.add(outputScrollPane);
        bottomPanel.add(memoryScrollPane);

        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.CENTER);
        add(runButton, BorderLayout.SOUTH);
    }

    @Override
    public void runBrainfuckCode() {
        String code = editorArea.getText();
        String input = inputField.getText();
        resetInterpreter();  // Reset interpreter state for each run
        String output = interpreter.run(code, input);
        displayOutput(output);
        displayMemory(interpreter.getMemoryState());
    }

    @Override
    public void resetInterpreter() {
        interpreter.reset();
    }

    @Override
    public void displayOutput(String output) {
        outputArea.setText(output);
    }

    @Override
    public void displayMemory(String memoryState) {
        memoryArea.setText(memoryState);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingBrainfuckInterpreterGUI gui = new SwingBrainfuckInterpreterGUI();
            gui.setVisible(true);
        });
    }
}
