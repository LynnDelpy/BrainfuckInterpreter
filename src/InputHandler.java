public class InputHandler {
    private String input;
    private int inputPointer;

    public InputHandler() {
        input = "";
        inputPointer = 0;
    }

    public void setInput(String input) {
        this.input = input;
        this.inputPointer = 0;
    }

    public int getNextInput() {
        if (inputPointer < input.length()) {
            return input.charAt(inputPointer++);
        } else {
            return 0;  // EOF behavior
        }
    }
}
