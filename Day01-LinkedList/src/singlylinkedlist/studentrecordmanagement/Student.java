package singlylinkedlist.studentrecordmanagement;

public class Student {
    //Student Class
    private class StudentNode {
        int rollNumber;
        String name;
        int age;
        String grade;
        StudentNode next;
        //Constructor
        public StudentNode(int rollNumber, String name, int age, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }


    public static StudentNode head;
    public static StudentNode tail;
    public  static  int size;

//    public Student(){
//        this.head = null;
//    }


    //add first

    public  void addFirst(int rollNumber,String name, int age, String grade){
        StudentNode newStudent = new StudentNode(rollNumber,name,age,grade);
        if(head == null){
            head =tail = newStudent;
            return;
        }
        newStudent.next = head;
        head = newStudent;
    }

    //addlast

    public  void addAtLast(int rollNumber,String name, int age, String grade) {
        StudentNode newStudent = new StudentNode(rollNumber,name,age,grade);
        if(head == null || tail == null) {
            head = tail = newStudent;
        }
        tail.next = newStudent;
        tail = newStudent;
    }
    //add at between
    public void addAtBetween(int rollNumber,String name, int age, String grade,int index) {
        StudentNode newStudent = new StudentNode(rollNumber,name,age,grade);

        if(index == 0){
            addFirst(rollNumber,name,age,grade);
            return;
        }
        StudentNode temp = head;
        while (index>1){
            if(temp == null){
                System.out.println("index out of bound");
                return;
            }
            temp = temp.next;
            index--;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
        System.out.println("added at index " + index);
    }

    public void delete(int rollNumber){
        if(head == null){
            System.out.println("empty list");
            return;
        }// case 1 head
        if(head.rollNumber == rollNumber){
            head = head.next;
            System.out.println("deleted");
            return;
        }
        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber){
            temp = temp.next;
        }
        if(temp.next == null){
            System.out.println("roll number not found");
            return;
        }
        temp.next = temp.next.next;
        System.out.println("deleted");

    }

    //roll number search

    public  void  search(int rollNumber){
        StudentNode temp = head;
        while (temp !=  null){
            if(temp.rollNumber == rollNumber){
                System.out.println("Student found!! Name is " +temp.name );
                return;
            }
            temp = temp.next;
        }
        System.out.println("student not found");
    }


    //print
    public void displayDetails(){
        StudentNode temp = head;
        while (temp!= null){
            System.out.println("roll number: " + temp.rollNumber + " ,name is :" + temp.name + " , age : "+  temp.age + " , Grade is " + temp.grade);
            temp = temp.next;
        }

    }

    public void updateGrade(int rollNumber, String newGrade){
        StudentNode temp = head;
        while (temp != null){
            if(temp.rollNumber == rollNumber){
                temp.grade = newGrade;
                System.out.println("updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }
}
