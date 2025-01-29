package singlylinkedlist.inventorymangementsystem;

public class Inventory {
    public class InventoryNode{
        private String itemName;
        private int itemID;
        private int quantity;
        private int price;
        InventoryNode next;

        public InventoryNode(String itemName, int itemID, int quantity, int price) {
            this.itemName = itemName;
            this.itemID = itemID;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }
    public static InventoryNode head;
    public static InventoryNode tail;

    public void addAtBeginning( String itemName, int itemID, int quantity, int price){
        InventoryNode newNode = new InventoryNode(itemName, itemID, quantity, price);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addAtLast( String itemName, int itemID, int quantity, int price){
        InventoryNode newNode = new InventoryNode(itemName, itemID, quantity, price);
        if(tail == null || head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addAtIndex( String itemName, int itemID, int quantity, int price,int index){
        if(index == 0){
            addAtBeginning(itemName, itemID, quantity, price);
            return;
        }
        InventoryNode newNode = new InventoryNode(itemName, itemID, quantity, price);
        InventoryNode temp = head;

        while (index>1){
            if(temp == null){
                System.out.println("index out of bound");
                return;
            }
            temp = temp.next;
            index--;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("at index " + index);

        }

        public void delete(int itemID){
        if(head == null){
            System.out.println("empty list");
            return;
        }
        //head me ho tb
            if(head.itemID == itemID){
                head = head.next;
                System.out.println("deleted at head");
                return;
            }

            InventoryNode temp = head;
            while (temp.next != null && temp.next.itemID != itemID){
                temp = temp.next;
            }
            if(temp.next == null){
                System.out.println("item id not found");
                return;
            }
            temp.next = temp.next.next;
            System.out.println("deleted");
        }

        public void search(int itemID, String itemName) {
            InventoryNode temp = head;
            if (temp == null) {
                System.out.println("empty list");
                return;
            }
            while (temp != null) {
                if (temp.itemID == itemID || temp.itemName.equals(itemName)) {
                    System.out.println("item found");
                    return;
                }
                temp = temp.next;
            }
            System.out.println("item not found!!!");
        }

        //calculate total price
        private double calculateTotal(){
            double total = 0;
            InventoryNode temp = head;
            do {
                total+= (temp.price * temp.quantity);
                temp= temp.next;
            }
            while(temp != null);
            return total;
        }
    public void totalValue(){
        System.out.println("total value of inventory = "+calculateTotal());
    }

    private InventoryNode mergeSort(InventoryNode head, boolean sortByName){
        if(head  == null || head.next == null){
            return  head;
        }
        InventoryNode middle = getMiddle(head);
        InventoryNode middleNext = middle.next;
        middle.next = null;

        InventoryNode left = mergeSort(middle, sortByName);
        InventoryNode right = mergeSort(middleNext, sortByName);

        return merge(left, right, sortByName);
    }
    private InventoryNode merge(InventoryNode left, InventoryNode right , boolean sortByName){
        if(left == null) return right;
        if(right == null) return left;

        if((sortByName && left.itemName.compareTo(right.itemName) < 0  || (!sortByName && left.price <= right.price))){

            left.next = merge(left.next, right, sortByName);
            return left;

        }
        else{
            right.next = merge(left, right.next, sortByName);
            return right;
        }
    }
    public void sortInventory(boolean sortByName){
        head = mergeSort(head, sortByName);
    }
    private InventoryNode getMiddle(InventoryNode head){

        InventoryNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }




    public  void print(){
        InventoryNode temp = head;
        while (temp != null){
            System.out.println("item name is " + temp.itemName + " item id is " + temp.itemID);
            temp = temp.next;
        }
    }
}
