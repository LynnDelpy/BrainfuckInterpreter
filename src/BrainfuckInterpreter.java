public class BrainfuckInterpreter {
    private Memory memory;
    private StringBuilder output;
    private InputHandler inputHandler;

    public BrainfuckInterpreter() {
        memory = new Memory();
        output = new StringBuilder();
        inputHandler = new InputHandler();
    }

    public String run(String code, String input) {
        char[] instructions = code.toCharArray();
        int codePointer = 0;
        inputHandler.setInput(input);

        while (codePointer < instructions.length) {
            char instruction = instructions[codePointer];
            switch (instruction) {
                case '>':
                    memory.incrementPointer();
                    break;
                case '<':
                    memory.decrementPointer();
                    break;
                case '+':
                    memory.incrementCell();
                    break;
                case '-':
                    memory.decrementCell();
                    break;
                case '.':
                    output.append((char) memory.getCurrentCell());
                    break;
                case ',':
                    memory.setCurrentCell(inputHandler.getNextInput());
                    break;
                case '[':
                    if (memory.getCurrentCell() == 0) {
                        codePointer = findLoopEnd(instructions, codePointer);
                    }
                    break;
                case ']':
                    if (memory.getCurrentCell() != 0) {
                        codePointer = findLoopStart(instructions, codePointer);
                    }
                    break;
            }
            codePointer++;
        }
        return output.toString();
    }

    private int findLoopEnd(char[] instructions, int codePointer) {
        int loop = 1;
        while (loop > 0) {
            codePointer++;
            if (instructions[codePointer] == '[') loop++;
            if (instructions[codePointer] == ']') loop--;
        }
        return codePointer;
    }

    private int findLoopStart(char[] instructions, int codePointer) {
        int loop = 1;
        while (loop > 0) {
            codePointer--;
            if (instructions[codePointer] == '[') loop--;
            if (instructions[codePointer] == ']') loop++;
        }
        return codePointer;
    }

    public String getMemoryState() {
        return memory.getUsedMemoryState();
    }

    public void reset() {
        memory.reset();
        output.setLength(0);
    }
}
