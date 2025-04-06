package singlylinkedlist.studentrecordmanagement;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.addFirst(1,"nitish",20,"A");
        student.addFirst(3,"nitffvish",20,"A");

        student.addAtLast(2,"singh",20,"c");

        student.addAtBetween(52,"nitish",20,"B",2);

        student.delete(5);
        student.delete(3);

        student.search(5);
        student.search(52);

        student.updateGrade(52, "a");

        student.displayDetails();
    }


}
