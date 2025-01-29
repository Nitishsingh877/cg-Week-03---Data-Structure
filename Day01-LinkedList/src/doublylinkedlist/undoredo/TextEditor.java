package doublylinkedlist.undoredo;

public class TextEditor {
    private class TextState{
        private String content;
        TextState next, prev;
        TextState(String content){
            this.content = content;
            this.next = this.prev = null;
        }
    }
    private TextState head,tail, current;
    private int history = 0;
    private int maxHistory = 10;

    public TextEditor(){
        head =tail =current =  null;
    }
    public void addState(String content){
        TextState newState = new TextState(content);

        if(current != null){
            current.next = newState;
            newState.prev = current;

        }
        else{
            head = newState;
        }
        current = newState;
        tail = newState;

        history++;
        if(history> maxHistory){
            head = head.next;
            if(head != null) head.prev = null;
            history--;
        }

    }

    public void undo(){
        if(current != null && current.prev != null){
            current = current.prev;
            System.out.println("Undo "+current.content);
        }
        else{
            System.out.println("Nothing to undo !");
        }
    }

    public void redo(){
        if(current != null && current.next != null){
            current = current.next;
            System.out.println("Redo "+current.content);
        }
        else
            System.out.println("Nothing to redo !");
    }

    public void displayCurrentState(){
        if(current != null){
            System.out.println("current state : "+current.content);
        }
        else
            System.out.println("No text available ");
    }



}





