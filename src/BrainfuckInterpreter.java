import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BrainfuckInterpreter {
    private Memory memory;
    private StringBuilder output;
    private InputHandler inputHandler;
    private Map<Integer, Integer> bracketMap;

    public BrainfuckInterpreter() {
        memory = new Memory();
        output = new StringBuilder();
        inputHandler = new InputHandler();
        bracketMap = new HashMap<>();
    }

    public String run(String code, String input) {
        char[] instructions = code.toCharArray();
        buildBracketMap(instructions);
        int codePointer = 0;
        inputHandler.setInput(input);

        while (codePointer < instructions.length) {
            char instruction = instructions[codePointer];
            switch (instruction) {
                case '>':
                    memory.incrementPointer();
                    codePointer++;
                    break;
                case '<':
                    memory.decrementPointer();
                    codePointer++;
                    break;
                case '+':
                    memory.incrementCell();
                    codePointer++;
                    break;
                case '-':
                    memory.decrementCell();
                    codePointer++;
                    break;
                case '.':
                    output.append((char) memory.getCurrentCell());
                    codePointer++;
                    break;
                case ',':
                    memory.setCurrentCell(inputHandler.getNextInput());
                    codePointer++;
                    break;
                case '[':
                    if (memory.getCurrentCell() == 0) {
                        codePointer = bracketMap.get(codePointer) + 1;
                    } else {
                        codePointer++;
                    }
                    break;
                case ']':
                    if (memory.getCurrentCell() != 0) {
                        codePointer = bracketMap.get(codePointer);
                    } else {
                        codePointer++;
                    }
                    break;
                default:
                    codePointer++;
                    break;
            }
        }
        return output.toString();
    }

    private void buildBracketMap(char[] instructions) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < instructions.length; i++) {
            if (instructions[i] == '[') {
                stack.push(i);
            } else if (instructions[i] == ']') {
                int start = stack.pop();
                bracketMap.put(start, i);
                bracketMap.put(i, start);
            }
        }
    }

    public String getMemoryState() {
        return memory.getUsedMemoryState();
    }

    public void reset() {
        memory.reset();
        output.setLength(0);
        bracketMap.clear();
    }
}
