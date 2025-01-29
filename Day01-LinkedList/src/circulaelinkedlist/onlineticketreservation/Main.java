package circulaelinkedlist.onlineticketreservation;

public class Main {
    public static void main(String[] args) {
        TicketReservationSystem hall = new TicketReservationSystem();

        hall.addTicket(101, "Alice", "Avengers", "A10", "10:00 AM");
        hall.addTicket(102, "Bob", "Batman", "B12", "2:00 PM");
        hall.addTicket(103, "Charlie", "Avengers", "C15", "6:00 PM");

        hall.displayTickets();

        hall.searchTicket(102, "Avengers");
        hall.searchTicket(105, "Batman");
        hall.searchTicket(110, "Spiderman");

        hall.removeTicket(102);
        hall.displayTickets();

        System.out.println("Total Tickets Booked: " + hall.countTickets());
    }
}
