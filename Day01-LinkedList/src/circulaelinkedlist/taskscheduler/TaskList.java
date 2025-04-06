package circulaelinkedlist.taskscheduler;

public class TaskList {
    public class TaskNode{
        int taskId;
        private String taskName;
        private String priority;
        private String dueDate;
        private TaskNode next;

        public TaskNode(int taskId, String taskName, String priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
            this.next = null;
        }
    }
    private TaskNode head;
    private TaskNode current;
    public TaskList(){
        this.head = null;
        this.current = null;

    }
    public void addAtStart(int taskId, String taskName, String priority, String dueDate) {

        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            head.next = head;

        } else {
            TaskNode temp = head;
            while (temp.next != head)
                temp = temp.next;
            newNode.next = head;
            head = newNode;
            temp.next = head;
        }
        System.out.println("Task Added at beginning");
    }
        public void addAtEnd(int taskId, String taskName, String priority, String dueDate ){
            TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
            if(head == null){
                head = newNode;
                head.next  = head;

            }
            else{
                TaskNode temp = head;
                while(temp.next != head){
                    temp = temp.next;

                }
                temp.next = newNode;
                newNode.next = head;

            }
            System.out.println("Added at end");
        }

    public void addAtIndex(int taskId, String taskName, String priority, String dueDate, int index){
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if(index == 0){
            addAtStart(taskId, taskName, priority, dueDate);
            return;
        }
        TaskNode temp = head;
        while(index-- > 1){
            temp = temp.next;

            if(temp == head){
                System.out.println("Index out of bound");
                return;
            }

        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Added at index "+index);
    }

    public void removeTask(int taskId){
        if(head == null){
            System.out.println("Empty list !!");
            return;
        }
        if(head.taskId == taskId) {
            if (head.next == head) {
                head = null;
                return;
            }
            else {
                TaskNode temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                head = head.next;
                temp.next = head;

            }
            System.out.println("Deleted node with task id " + taskId);
            return;
        }

        // deleting the node other that the starting node
        TaskNode temp = head;
        while(temp.next != null){
            if(temp.next.taskId == taskId){

                temp.next = temp.next.next;
                System.out.println("Deleted node with task id "+taskId);
                return;
            }
            temp = temp.next;
        }
        // if task not found in the list

        System.out.println("Task ID not found!!");

    }
    public void viewAndMoveCurrent(){
        if(head == null){
            System.out.println("List id empty !!1");
            return;
        }
        if(current == null){
            current = head;

        }
        System.out.println("Current Task: ID=" + current.taskId + ", Name=" + current.taskName + ", Priority=" + current.priority + ", Due Date=" + current.dueDate);
        current = current.next;


    }

    public void displayAll(){
        if(head == null){
            System.out.println("Empty task !!");
            return;
        }
        TaskNode temp = head;
        System.out.println("Tasks in the list ");
        do {
            System.out.println("ID=" + temp.taskId + ", Name=" + temp.taskName +
                    ", Priority=" + temp.priority + ", Due Date=" + temp.dueDate);
            temp = temp.next;
        }
        while(temp != head);
    }

    public void searchByPriority(String priority){
        if(head == null){
            System.out.println("Empty List !!");
            return;
        }
        TaskNode temp = head;
        boolean flag = false;
        do {

            if(temp.priority.equals(priority)){
                System.out.println("Task found: ID=" + temp.taskId + ", Name=" + temp.taskName +
                        ", Priority=" + temp.priority + ", Due Date=" + temp.dueDate);
                flag = true;

            }
            temp = temp.next;
        }
        while(temp != head);

        if(!flag){
            System.out.println("No task found with priority "+priority);
        }
    }



}

