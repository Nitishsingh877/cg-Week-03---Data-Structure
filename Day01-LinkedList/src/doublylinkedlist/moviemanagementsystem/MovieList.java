package doublylinkedlist.moviemanagementsystem;

public class MovieList {
    private class MovieNode {
        String movieTitle;
        int YORelease;
        String director;
        int rating;

        MovieNode next;
        MovieNode prev;

        public MovieNode(String movieTitle, int YORelease, String director, int rating) {
            this.movieTitle = movieTitle;
            this.YORelease = YORelease;
            this.director = director;
            this.rating = rating;
            this.next = null;
            this.prev = null;
        }
    }
        private MovieNode head;
        private MovieNode tail;
        public MovieList(){
            this.head = null;
            this.tail = null;
        }

    public void addAtBeginning(String movieTitle, int YORelease, String director, int rating) {
        MovieNode newMovie = new MovieNode(movieTitle, YORelease, director, rating);
        if(head == null || tail ==null) {
            head =tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
        }head = newMovie;
        System.out.println("added at the start!!");
    }

    public void addAtEnd(String movieTitle, int YORelease, String director, int rating){
        MovieNode newMovie = new MovieNode(movieTitle, YORelease, director, rating);

        if(head == null || tail == null){
            head = tail = newMovie;
        }else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
        System.out.println("added at end");
    }

    public void addAtIndex(String movieTitle, int YORelease, String director, int rating,int index){
            if(index == 0){
                addAtBeginning(movieTitle, YORelease, director, rating);
                return;
            }
            MovieNode newNode = new MovieNode(movieTitle, YORelease, director, rating);

            MovieNode temp = head;
            while (index>1){
                if(temp == null){
                    System.out.println("out of index");
                    return;
                }
                index--;
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next.prev = temp;
            newNode.prev = temp;
            temp.next = newNode;

        System.out.println("added at index "+ index);
    }


    public  void delete(String movieTitle){
            if(head == null){
                System.out.println("empty list !!1");
                return;
            }
            // case1 : delete first node
        if(head.movieTitle.equals(movieTitle)){
            if(head.next != null){
                head.next.prev = null;
            }
            head = head.next;
            System.out.println("deleted 1");
            return;
        }
        //case 2 at middle
        MovieNode temp = head;
        while (temp.next != null && !temp.next.movieTitle.equals(movieTitle)){
            temp = temp.next;
        }

        if(temp.next == null){
            System.out.println("movie not found");
            return;
        }

        //if node is at last
        if(temp.next.next == null){
            temp.next = null;
        }else {
            temp.next.next.prev = temp;
            temp.next = temp.next.next;
        }
        System.out.println("deleted!!");
    }

    public void search(String director, double rating){
            MovieNode temp = head;
            while (temp != null){
                if(temp.director.equals(director) || temp.rating == rating){
                    System.out.println("movie title " + temp.movieTitle + " director  is " + temp.director + " is found.");
                    return;
                }
                else {
                    temp = temp.next;
                }
            }
        System.out.println("movie not found!");
    }
    public void displayForward(){
            MovieNode temp = head;
        System.out.println("movie list in forward :");
        while (temp != null){
            System.out.println(temp.movieTitle + " " + temp.director);
            temp = temp.next;

        }
    }

    public void displayBackward(){
            if(head == null){
                System.out.println("empty list");
                return;
            }
            MovieNode temp = head;
        System.out.println("list in backward :");
        while (temp.next != null)
            temp = temp.next;
        while (temp != null){
            System.out.println(temp.movieTitle + " "+ temp.director);
            temp = temp.prev;
        }
    }
    public void updateRating(String movieTitle, int newRating){
        MovieNode temp = head;
        while(temp != null){
            if(temp.movieTitle.equals(movieTitle)){
                temp.rating = newRating;
                System.out.println("Updated !!1" +" new rating is "+ temp.rating);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found !!!");
    }
}


