package hashmap.implementacustomhashmap;

import java.util.LinkedList;

public class Main {
    public static class MyHashMap {
        // Define the HashMap size (number of buckets)
        private static final int SIZE = 16;

        // Define a bucket array of linked lists for separate chaining
        private LinkedList<Entry>[] table;


        // Entry class to represent key-value pairs
        static class Entry {
            int key;
            int value;

            Entry(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        // Constructor
        public MyHashMap() {
            table = new LinkedList[SIZE];
            for (int i = 0; i < SIZE; i++) {
                table[i] = new LinkedList<>();
            }
        }

        // Hash function to compute the index for a given key
        private int hash(int key) {
            return key % SIZE;
        }

        // Insert or update the key-value pair
        public void put(int key, int value) {
            int index = hash(key);
            LinkedList<Entry> bucket = table[index];

            // Check if the key already exists and update the value if so
            for (Entry entry : bucket) {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                }
            }

            // If the key doesn't exist, add a new entry
            bucket.add(new Entry(key, value));
        }

        // Retrieve the value for a given key
        public int get(int key) {
            int index = hash(key);
            LinkedList<Entry> bucket = table[index];

            // Search the linked list at the bucket index
            for (Entry entry : bucket) {
                if (entry.key == key) {
                    return entry.value;
                }
            }

            // Return -1 if the key doesn't exist
            return -1;
        }

        // Remove a key-value pair from the map
        public void remove(int key) {
            int index = hash(key);
            LinkedList<Entry> bucket = table[index];

            // Iterate through the linked list to find and remove the entry
            for (Entry entry : bucket) {
                if (entry.key == key) {
                    bucket.remove(entry);
                    return;
                }
            }
        }

        // Print the contents of the hash map for debugging
        public void printMap() {
            for (int i = 0; i < SIZE; i++) {
                System.out.print("Bucket " + i + ": ");
                for (Entry entry : table[i]) {
                    System.out.print("[" + entry.key + "->" + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        // put and get operations
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.put(16, 40);  // This will cause a collision with key 1

        System.out.println("Value for key 1: " + map.get(1));
        System.out.println("Value for key 2: " + map.get(2));
        System.out.println("Value for key 3: " + map.get(3));
        System.out.println("Value for key 16: " + map.get(16));
        System.out.println("Value for key 100: " + map.get(100));

        // Test remove operation
        map.remove(2);
        System.out.println("Value for key 2 after removal: " + map.get(2)); // Output: -1 (removed)

        // Print the contents of the map
        map.printMap();


    }


}
