import java.util.HashMap;
import java.util.Map;

public class Memory {
    private static final int MEMORY_SIZE = 30000;
    private Map<Integer, Integer> memoryCells;
    private int memoryPointer;

    public Memory() {
        memoryCells = new HashMap<>();
        memoryPointer = 0;
    }

    public void incrementPointer() {
        memoryPointer = (memoryPointer + 1) % MEMORY_SIZE;
    }

    public void decrementPointer() {
        memoryPointer = (memoryPointer - 1 + MEMORY_SIZE) % MEMORY_SIZE;
    }

    public void incrementCell() {
        memoryCells.put(memoryPointer, getCurrentCell() + 1);
    }

    public void decrementCell() {
        memoryCells.put(memoryPointer, getCurrentCell() - 1);
    }

    public int getCurrentCell() {
        return memoryCells.getOrDefault(memoryPointer, 0);
    }

    public void setCurrentCell(int value) {
        memoryCells.put(memoryPointer, value);
    }

    public String getUsedMemoryState() {
        StringBuilder memoryState = new StringBuilder();
        memoryCells.forEach((key, value) -> memoryState.append(String.format("Cell %d: %02X\n", key, value & 0xFF)));
        return memoryState.length() > 0 ? memoryState.toString() : "No memory used.";
    }

    public void reset() {
        memoryCells.clear();
        memoryPointer = 0;
    }
}
