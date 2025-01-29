package singlylinkedlist.socialmediafreindconnection;

public class Main {
    public static void main(String[] args) {
        Social system = new Social();

        // Add users
        system.addUser(1, "siddhu", 25);
        system.addUser(2, "Yuvraj", 28);
        system.addUser(3, "Prinshu", 22);

        // Add friends
        system.addFriend(1, 2);
        system.addFriend(1, 3);
        system.addFriend(2, 3);

        // Display friends
        system.displayFriends(1);
        system.displayFriends(2);

        // Find mutual friends
        system.findMutualFriend(1, 2);

        // Remove a friend connection

        // Count friends
        system.countFriends(1);
    }
}
