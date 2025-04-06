package doublylinkedlist.undoredo;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        // Adding states
        editor.addState("Hello");
        editor.addState("Hello, World!");
        editor.addState("Hello, World! This is an editor.");
        editor.addState("Hello, World! This is an undo/redo system.");

        // Display current state
        editor.displayCurrentState(); // Last added state

        // Undo operations
        editor.undo();
        editor.undo();
        editor.displayCurrentState();

        // Redo operations
        editor.redo();
        editor.displayCurrentState();
    }
}
