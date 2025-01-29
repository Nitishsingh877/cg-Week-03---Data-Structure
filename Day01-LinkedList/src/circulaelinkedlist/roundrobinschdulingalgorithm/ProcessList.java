package circulaelinkedlist.roundrobinschdulingalgorithm;

public class ProcessList {
    private class ProcessNode{
        int processId, burstTime , turnAroundTime, remainingTime,waitingTime,priority;
        ProcessNode next;

        public ProcessNode(int processId, int priority, int burstTime) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.turnAroundTime = 0;
            this.remainingTime = burstTime;
            this.waitingTime =0;
            this.priority = priority;
        }
    }
    private ProcessNode head = null , tail = null;
    public void addNewProcess(int processId, int priority, int burstTime){
        ProcessNode newNode = new ProcessNode(processId, priority, burstTime);
        if(head == null){
            head = tail = newNode;
            tail.next = null;
        }
        else{
            tail.next = newNode;
            tail = newNode;
            tail.next = head;

        }
        System.out.println("process added !!!");
    }
    public void deleteProcess(int processId){
        if(head == null){
            System.out.println("empty cpu!!!");
            return;
        }
        // if process is at head
        if(head.processId == processId){
            // if there is only one node
            if(head == tail){
                head= null;
                tail = null;
            }
            else{
                head = head.next;
                tail.next = head;
            }
            System.out.println("Process with id "+processId+" deleted !!1");
            return;
        }
        ProcessNode temp = head;
        while(temp.next != head){
            if(temp.next.processId == processId){
                //if the node is at tail
                if(temp.next == tail){
                    tail = temp;
                }
                temp.next = temp.next.next;
                System.out.println("Process with id "+processId+" deleted !!1");

                return;
            }
            temp = temp.next;

        }

        System.out.println("No process found with process id = "+processId);
    }

    public void displayProcess(){
        if(head == null){
            System.out.println("No process in CPU !!!");
            return;
        }
        ProcessNode temp = head;
        do{
            System.out.println("ID=" + temp.processId + ", BurstTime=" + temp.burstTime + ", Priority=" + temp.priority);
            temp = temp.next;
        }
        while(temp != head);
    }

    public void simulate(int timeQuantum){
        if(head == null){
            System.out.println("No process to schedule !");
            return;
        }
        int totalProcess = 0, totalWaitingTime = 0, totalTurnAroundTime = 0;// all used for average calculation
        ProcessNode temp = head;
        do{
            totalProcess++;// this count of process is used for calculation of average
            temp = temp.next;

        }
        while(temp != head);
        int elapsedTime = 0;
        while(head != null){
            ProcessNode curr = head;
            boolean processCompletedInCycle = false;

            do{
                int executionTime = Math.min(timeQuantum, curr.remainingTime);
                curr.remainingTime -= executionTime;
                elapsedTime += executionTime;

                curr.turnAroundTime = elapsedTime;
                curr.waitingTime = curr.turnAroundTime - curr.burstTime;
                System.out.println("Executing Process ID=" + curr.processId + " for " + executionTime + " units");
                if (curr.remainingTime == 0) {
                    System.out.println("Process ID=" + curr.processId + " Completed.");
                    totalWaitingTime+= curr.waitingTime;
                    totalTurnAroundTime+= curr.turnAroundTime;
                    deleteProcess(curr.processId);// after the execution each node is deleted when their remaining time become 0
                    // it means the process does not have any remaining job
                    processCompletedInCycle = true;
                    break;
                }
                curr = curr.next;

            }
            while(curr != head);
            if(processCompletedInCycle){
                if(head == null){
                    break;
                }
            }
        }
        System.out.println("Average Waiting time "+(double)totalWaitingTime/totalProcess);
        System.out.println("Average turn around time "+(double)totalTurnAroundTime/totalProcess);
    }
}
