package singlylinkedlist.inventorymangementsystem;

public class Main {
    public static void main(String[] args) {
        Inventory s1 = new Inventory();

        s1.addAtBeginning("oreo",101,5,10);
        s1.addAtBeginning("kitkat",102,5,5);

        s1.addAtLast("shake",103,5,50);

        s1.addAtIndex("abc",104,5,10,1);

        s1.delete(104);
        s1.search(104,"abc");

        s1.totalValue();
        s1.sortInventory(false);

        s1.print();
    }
}
