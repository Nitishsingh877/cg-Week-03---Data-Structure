package circulaelinkedlist.onlineticketreservation;

public class TicketReservationSystem {
    private class TicketNode{
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        TicketNode next;

        public TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    private TicketNode head;
    private TicketNode tail;
    private int totalTickets;

    public TicketReservationSystem(){
        head = tail = null;
        totalTickets = 0;

    }
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = newTicket;
            tail = newTicket;
            newTicket.next = head; // Circular link
        } else {
            tail.next = newTicket;
            newTicket.next = head; // Circular link
            tail = newTicket;
        }
        totalTickets++;
        System.out.println("Ticket booked successfully! Ticket ID: " + ticketId);


    }


    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove!");
            return;
        }

        TicketNode temp = head;

        if (head.ticketId == ticketId) {
            if (head.next == head) {
                head = null;
            } else {
                while (temp.next != head) {
                    temp = temp.next;
                }
                head = head.next;
                temp.next = head;
            }
            totalTickets--;
            System.out.println("Ticket ID " + ticketId + " removed successfully.");
            return;
        }

        temp = head;
        while (temp.next != head) {
            if (temp.next.ticketId == ticketId) {
                temp.next = temp.next.next;
                totalTickets--;
                System.out.println("Ticket ID " + ticketId + " removed successfully.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Ticket ID " + ticketId + " not found.");
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked!");
            return;
        }

        TicketNode temp = head;
        System.out.println("Booked Tickets:");
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber +
                    ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTicket(int ticketId, String movieName) {
        if (head == null) {
            System.out.println("No tickets booked!");
            return;
        }

        TicketNode temp = head;
        do {
            if (temp.ticketId == ticketId || temp.movieName.equalsIgnoreCase(movieName)) {
                System.out.println("Found Ticket - ID: " + temp.ticketId + ", Customer: " + temp.customerName +
                        ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber +
                        ", Booking Time: " + temp.bookingTime);
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("No tickets found for ID: " + ticketId + " or Movie: " + movieName);
    }
    public int countTickets() {
        return totalTickets;
    }


}
