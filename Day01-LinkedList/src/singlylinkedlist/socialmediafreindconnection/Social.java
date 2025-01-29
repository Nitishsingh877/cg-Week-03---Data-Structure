package singlylinkedlist.socialmediafreindconnection;

public class Social{
    private class UserNode {
        int userId;
        String name;
        int age;
        FriendNode friends;
        UserNode next;

        public UserNode(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.friends = null;
            this.next = null;
        }
    }
    private class FriendNode{
        int friendId;
        FriendNode next;

        public FriendNode(int friendId) {
            this.next = null;
            this.friendId = friendId;
        }
    }
    UserNode head;
    public Social(){
        this.head = null;
    }

    // Adding user to the end of the user list
    public void addUser(int userId, String name, int age){
        UserNode newUser = new UserNode(userId, name, age);
        if(head == null){
            head = newUser;
        }
        else{
            UserNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }


    // get user node using the user id
    //find friend using userid.
    private UserNode findUserById(int id){

        UserNode temp = head;
        while(temp != null){
            if(temp.userId == id){
                return temp;
            }
            temp = temp.next;

        }
        return  null;
    }

    // get user node using the user name
    private UserNode findUserByName(String name){
        UserNode temp = head;
        while(temp != null){
            if(temp.name.equals(name)){
                return temp;
            }
            temp = temp.next;

        }
        return  null;
    }

    // Adding two friends i.e adding the user inside other's friend list
    public void addFriend(int userId1, int userId2){
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);


        if(user1 == null || user2 == null){
            System.out.println("User is not available");
            return;
        }

        addToFriendList(user1,userId2);
        addToFriendList(user2,userId1);
        System.out.println("Friends added !!");

    }

    //Adding the friend id to the user friend list
    private void addToFriendList(UserNode user, int friendId){

        FriendNode newFriend = new FriendNode(friendId);
        if(user.friends == null){
            user.friends = newFriend;

        }
        else{
            FriendNode temp = user.friends;
            while(temp.next != null)
                temp = temp.next;
            temp.next = newFriend;
        }

    }

    // Removing two friends ie removing one from other's friend list
    public void removeFriend(int userId1, int userId2){
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if(user1 == null || user2 == null ){
            System.out.println("User not available !!");
        }

        removeFromFriendList(user1,userId2);
        removeFromFriendList(user2,userId1);
        System.out.println("Friend removed !!!");

    }

    //Removing the friend id from the user friend list
    private void removeFromFriendList(UserNode user, int friendId){
        if(user.friends == null) return;
        if(user.friends.friendId == friendId){
            user.friends = user.friends.next;
            return;
        }
        FriendNode temp = user.friends;
        while(temp.next != null && temp.next.friendId != friendId){
            temp = temp.next;

        }
        if(temp.next != null) {
            temp.next = temp.next.next;
        }
    }


    //Finding mutual friend of two users
    public void findMutualFriend(int userId1, int userId2){
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if(user1 == null || user2 == null){
            System.out.println("User not available");
            return;
        }
        FriendNode friend1 = user1.friends;
        FriendNode friend2 = user2.friends;
        while(friend1 != null){
            while(friend2 != null){
                if(friend1.friendId == friend2.friendId){
                    System.out.println("Mutual Friend ID: " + friend1.friendId);

                }
                friend2 = friend2.next;
            }
            friend1 = friend1.next;
        }
    }

    // Display all the friends
    public void displayFriends(int userId){
        UserNode user = findUserById(userId);
        if(user == null){
            System.out.println("User does not exists ");
            return;

        }
        FriendNode temp = user.friends;
        System.out.print("Friends of userId "+userId+" are :");
        while(temp != null){
            System.out.print(temp.friendId+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Count the friends
    public void countFriends(int userId){
        UserNode user = findUserById(userId);
        if(user == null){
            System.out.println("User does not exists ");
            return;

        }
        int count = 0;
        FriendNode temp = user.friends;
//        System.out.println("Friends of userId : "+userId+" are :");
        while(temp != null){
//            System.out.print(temp.friendId+" ");
            count++;
            temp = temp.next;
        }
        System.out.println("Count of friends are : "+count);
    }
}

