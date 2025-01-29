package doublylinkedlist.moviemanagementsystem;

public class Main {
    public static void main(String[] args) {
        MovieList m1 = new MovieList();

        m1.addAtBeginning("rang de basanti", 2024,"nitish",4);
        m1.addAtBeginning("fdviubdv",2025,"jndvbf",1);



        m1.addAtEnd("vffd",2525,"sjhv",5);
        m1.addAtEnd("vjdsnv",2661,"dsjvkn",4);


        m1.addAtIndex("hbkn",2021,"ggggg",4,1);


        m1.delete("vffd");

        m1.search("ggggg", 4);
        m1.updateRating("hbkn",5);
        m1.displayForward();
        m1.displayBackward();





    }
}
