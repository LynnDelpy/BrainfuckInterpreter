public class Memory {
    private static final int MEMORY_SIZE = 30000;
    private int[] memoryCells;
    private int memoryPointer;

    public Memory() {
        memoryCells = new int[MEMORY_SIZE];
        memoryPointer = 0;
    }

    public void incrementPointer() {
        memoryPointer = (memoryPointer + 1) % MEMORY_SIZE;
    }

    public void decrementPointer() {
        memoryPointer = (memoryPointer - 1 + MEMORY_SIZE) % MEMORY_SIZE;
    }

    public void incrementCell() {
        memoryCells[memoryPointer] = (memoryCells[memoryPointer] + 1) & 0xFF;
    }

    public void decrementCell() {
        memoryCells[memoryPointer] = (memoryCells[memoryPointer] - 1 + 256) & 0xFF;
    }

    public int getCurrentCell() {
        return memoryCells[memoryPointer];
    }

    public void setCurrentCell(int value) {
        memoryCells[memoryPointer] = value & 0xFF;
    }

    public String getUsedMemoryState() {
        StringBuilder memoryState = new StringBuilder();
        for (int i = 0; i < MEMORY_SIZE; i++) {
            if (memoryCells[i] != 0) {
                memoryState.append(String.format("Cell %d: %02X\n", i, memoryCells[i]));
            }
        }
        return memoryState.length() > 0 ? memoryState.toString() : "No memory used.";
    }

    public void reset() {
        memoryCells = new int[MEMORY_SIZE];
        memoryPointer = 0;
    }
}
