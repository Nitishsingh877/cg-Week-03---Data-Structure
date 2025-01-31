package stackandqueue.circulartourproblem;
class Main {
    // Function to find the starting petrol pump index
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int start = 0, surplus = 0, deficit = 0;

        for (int i = 0; i < petrol.length; i++) {
            surplus += petrol[i] - distance[i];

            // If surplus becomes negative, reset the start point
            if (surplus < 0) {
                start = i + 1;  // Move to the next pump
                deficit += surplus;  // Store the shortage
                surplus = 0;
            }
        }

        // If the total petrol (surplus + deficit) is sufficient, return start index
        return (surplus + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};  // Petrol available at each pump
        int[] distance = {6, 5, 3, 5}; // Distance to the next pump

        int startIndex = findStartingPoint(petrol, distance);

        if (startIndex != -1) {
            System.out.println("The tour can be completed if started from pump index: " + startIndex);
        } else {
            System.out.println("No valid starting point exists.");
        }
    }
}

