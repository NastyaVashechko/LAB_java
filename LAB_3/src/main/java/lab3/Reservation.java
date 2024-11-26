package lab3;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.Objects;

public class Reservation {

    private final String reservationId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private final LocalDate checkInDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private final LocalDate checkOutDate;

    private final Customer customer;
    private final Room room;

    // Конструктор з анотацією для десеріалізації
    @JsonCreator
    public Reservation(
            @JsonProperty("reservationId") String reservationId,
            @JsonProperty("checkInDate") LocalDate checkInDate,
            @JsonProperty("checkOutDate") LocalDate checkOutDate,
            @JsonProperty("customer") Customer customer,
            @JsonProperty("room") Room room
    ) {
        this.reservationId = reservationId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.customer = customer;
        this.room = room;
    }

    public Reservation() {
        this.reservationId = null;
        this.checkInDate = null;
        this.checkOutDate = null;
        this.customer = null;
        this.room = null;
    }

    // Геттери
    public String getReservationId() { return reservationId; }
    public LocalDate getCheckInDate() { return checkInDate; }
    public LocalDate getCheckOutDate() { return checkOutDate; }
    public Customer getCustomer() { return customer; }
    public Room getRoom() { return room; }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", customer=" + customer +
                ", room=" + room +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(reservationId, that.reservationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId);
    }
}
