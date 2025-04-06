package circulaelinkedlist.taskscheduler;

public class Main {
    public static void main(String[] args) {
        TaskList scheduler = new TaskList();
        scheduler.addAtStart(1,"Task 1", "2", "2025-12-21");
        scheduler.addAtEnd(3, "Task 2 ", "3" , "2024-01-01");
        scheduler.addAtIndex(2, "Task 3", "4", "2025-01-12",1);

        scheduler.displayAll();
        System.out.println();

        scheduler.viewAndMoveCurrent();
        System.out.println();
        scheduler.viewAndMoveCurrent();


        System.out.println();
        scheduler.searchByPriority("2");

        scheduler.removeTask(2);
        System.out.println();
        scheduler.displayAll();
    }
}
