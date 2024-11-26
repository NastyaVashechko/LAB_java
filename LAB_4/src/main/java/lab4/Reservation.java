package lab4;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Клас Reservation представляє бронювання номера.
 */
public class Reservation {
    private Room room;
    private Customer customer;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double payment;

    public Reservation(Room room, Customer customer, LocalDate checkInDate, LocalDate checkOutDate, double payment) {
        this.room = room;
        this.customer = customer;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "room=" + room +
                ", customer=" + customer +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", payment=" + payment +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Reservation reservation = (Reservation) obj;
        return Double.compare(reservation.payment, payment) == 0 &&
                room.equals(reservation.room) &&
                customer.equals(reservation.customer) &&
                checkInDate.equals(reservation.checkInDate) &&
                checkOutDate.equals(reservation.checkOutDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, customer, checkInDate, checkOutDate, payment);
    }

    // Геттери
    public Room getRoom() { return room; }
    public Customer getCustomer() { return customer; }
    public LocalDate getCheckInDate() { return checkInDate; }
    public LocalDate getCheckOutDate() { return checkOutDate; }
    public double getPayment() { return payment; }
}

