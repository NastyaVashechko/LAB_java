package lab1;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Створення об'єкта Room з використанням патерну Builder
        Room room = new Room.Builder()
                .setType("Deluxe")
                .setBedCount(2)
                .setRoomNumber(101)
                .setAmenities("Wi-Fi, TV, Mini-bar")
                .build();

        // Створення об'єкта Customer
        Customer customer = new Customer("Іваненко", "Іван", "ID123456", LocalDate.of(1990, 5, 21));

        // Створення об'єкта Reservation
        Reservation reservation = new Reservation(room, customer, LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 7), 1000.0);

        // Вивід інформації про бронювання
        System.out.println(reservation);

        // Перевірка методів equals та hashCode
        Room sameRoom = new Room.Builder()
                .setType("Deluxe")
                .setBedCount(2)
                .setRoomNumber(101)
                .setAmenities("Wi-Fi, TV, Mini-bar")
                .build();

        System.out.println("room.equals(sameRoom): " + room.equals(sameRoom));
        System.out.println("room.hashCode() == sameRoom.hashCode(): " + (room.hashCode() == sameRoom.hashCode()));
    }
}
