package doublylinkedlist.librarymangementsystem;

public class Book {
    private class BookNode{
        private String title;
        private String author;
        private String genre;
        private int bookId;
        private String availability;
        private BookNode next;
        private BookNode prev;

        public BookNode(String title, String author, String genre, int bookId, String availability) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.availability = availability;
            this.prev = null;
            this.next = null;

        }
    }
    private BookNode head;
    private BookNode tail;

    public Book(){
        this.head = null;
        this.tail = null;
    }

    public void addToStart(String title, String author, String genre, int bookId, String availability){
        BookNode newNode = new BookNode(title, author, genre, bookId, availability);
        if(head != null){
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        System.out.println("Added to start !!");
    }

    public void addToEnd(String title, String author, String genre, int bookId, String availability){
        BookNode newNode = new BookNode(title, author, genre, bookId, availability);
        if(head == null){
            head = newNode;
        }
        else{
            BookNode temp = head;
            while(temp.next != null){
                temp = temp.next;

            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        System.out.println("Added to end !!!");
    }
    public void addAtIndex(String title, String author, String genre, int bookId, String availability, int index){
        if(index == 0){
            addToStart(title, author, genre, bookId, availability);
            return;
        }
        BookNode newNode = new BookNode(title, author, genre, bookId, availability);

        BookNode temp = head;
        while(index > 1){
            if(temp == null){
                System.out.println("Out of index !!");
                return;
            }
            index--;
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next.prev = newNode;
        newNode.prev = temp;
        temp.next = newNode;
        System.out.println("Added at index "+index);
    }
    // Deleting a node using the book id
    public void deleteUsingBookId(int bookId){
        if(head == null){
            System.out.println("Empty list ");
            return;
        }
        // Delete the first node
        if(head.bookId == bookId){
            if(head.next != null){
                head.next.prev = null;

            }
            head = head.next;
            System.out.println("Delete the book node !!");
            return;
        }
        // Delete anywhere
        BookNode temp = head;
        while(temp.next != null && !(temp.next.bookId == bookId)){
            temp = temp.next;

        }
        if(temp.next == null){
            System.out.println("Book not found !! ");
            return;
        }
        // last node
        if(temp.next.next == null){
            temp.next = null;

        }
        else{
            temp.next.next.prev = temp;
            temp.next = temp.next.next;
        }
        System.out.println("Deleted the book !!");

    }
    public void searchBook(String bookTitle, String author){
        if(head == null){
            System.out.println("Empty list !!");
            return;
        }
        BookNode temp = head;
        do{
            if(temp.author.equals(author) || temp.title.equals(bookTitle)){
                System.out.println("Book id : "+temp.bookId+" book title : "+temp.title+" genre of book "+temp.genre+" author: "+temp.author+" availability of book "+temp.availability);
                return;
            }
            temp = temp.next;

        }
        while(temp != null);
        System.out.println("Book not found !!!");
    }

    public void updateAvailability(int bookId, String newAvailability){
        if(head == null){
            System.out.println("Empty list !!");
            return;
        }
        BookNode temp = head;
        do{
            if(temp.bookId == bookId){
                temp.availability = newAvailability;
                System.out.println("Updated !!!");
                return;
            }
            temp = temp.next;
        }
        while(temp != null);

        System.out.println("Book not found !!!!");
    }

    public void displayForward(){
        if(head == null){
            System.out.println("Empty list !!");
            return;
        }
        System.out.println("Book List in forward order : ");
        BookNode temp = head;
        do{
            System.out.println(temp.bookId+" "+temp.title);
            temp = temp.next;
        }
        while(temp != null);
    }

    public void displayBackward(){
        if(head == null){
            System.out.println("Empty list !!!");
            return;
        }
        BookNode temp = head;
        System.out.println("Book list in backward order : ");
        while(temp.next != null){
            temp = temp.next;

        }
        do{
            System.out.println(temp.bookId+" "+temp.title);
            temp = temp.prev;
        }
        while(temp != null);
    }
    private int countNodes(){
        int count = 0;
        BookNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        return  count;
    }
    public void getCount(){
        System.out.println("Number of books are "+countNodes());
    }





}

