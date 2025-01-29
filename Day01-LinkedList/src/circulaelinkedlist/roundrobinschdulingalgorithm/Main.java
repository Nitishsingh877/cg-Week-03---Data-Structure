package circulaelinkedlist.roundrobinschdulingalgorithm;
public class Main {

public static void main(String[] args) {


        ProcessList scheduler = new ProcessList();
        scheduler.addNewProcess(1,10,2);
        scheduler.addNewProcess(2,5,1);
        scheduler.addNewProcess(3,8,3);
        scheduler.displayProcess();

        int timeQuantum = 4;
        System.out.println("\nSimulator of round robin with time Quantum = "+timeQuantum);
        scheduler.simulate(timeQuantum);
        }
        }