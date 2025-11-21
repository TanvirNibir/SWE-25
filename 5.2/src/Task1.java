class TicketReservation {
    private int availableSeats;

    public TicketReservation(int seats) {
        this.availableSeats = seats;
    }

    public boolean reserve(String customer, int tickets) {
        synchronized (this) {
            if (availableSeats == 0) {
                System.out.println(customer + " couldn't reserve " + tickets + " tickets.");
                return false;
            }
            int allocated = Math.min(tickets, availableSeats);
            availableSeats -= allocated;
            System.out.println(customer + " reserved " + allocated + " tickets.");
            return true;
        }
    }
}

class Customer implements Runnable {
    private TicketReservation reservation;
    private String customerName;
    private int tickets;

    public Customer(TicketReservation reservation, String customerName, int tickets) {
        this.reservation = reservation;
        this.customerName = customerName;
        this.tickets = tickets;
    }

    @Override
    public void run() {
        reservation.reserve(customerName, tickets);
    }
}

public class Task1 {
    public static void main(String[] args) {
        TicketReservation reservation = new TicketReservation(10);

        Thread[] customers = new Thread[15];
        int[] ticketsRequest = {1, 2, 2, 3, 1, 2, 1, 1, 3, 3, 2, 4, 1, 4, 3};

        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Thread(new Customer(reservation, "Customer " + (i + 1), ticketsRequest[i]));
            customers[i].start();
        }

        for (Thread t : customers) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}