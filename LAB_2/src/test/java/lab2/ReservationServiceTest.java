package lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class ReservationServiceTest {

    private ReservationService service;
    private List<Room> rooms;
    private List<Reservation> reservations;

    @BeforeEach
    void setUp() {
        // Створення замовників
        Customer customer1 = new Customer("Іваненко", "Іван", "ID123456", LocalDate.of(1990, 5, 21));
        Customer customer2 = new Customer("Петренко", "Петро", "ID654321", LocalDate.of(1985, 8, 10));

        // Додаємо замовників до списку
        List<Customer> customers = Arrays.asList(customer1, customer2);

        // Ініціалізація сервісу з передачею списку замовників
        service = new ReservationService(customers);

        // Створення кімнат
        Room room1 = new Room.Builder().setType("Deluxe").setBedCount(2).setRoomNumber(101).setAmenities("Wi-Fi").build();
        Room room2 = new Room.Builder().setType("Standard").setBedCount(1).setRoomNumber(102).setAmenities("Wi-Fi").build();
        Room room3 = new Room.Builder().setType("Deluxe").setBedCount(3).setRoomNumber(103).setAmenities("TV").build();

        rooms = Arrays.asList(room1, room2, room3);

        // Створення бронювань
        reservations = Arrays.asList(
                new Reservation(room1, customer1, LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 7), 1000.0),
                new Reservation(room3, customer2, LocalDate.of(2024, 7, 5), LocalDate.of(2024, 7, 10), 800.0)
        );
    }

    @Test
    void testFilterRoomsByTypeAndBeds() {
        List<Room> filteredRooms = service.filterRoomsByTypeAndBeds(rooms, "Deluxe", 2);
        assertEquals(2, filteredRooms.size(), "Повинно знайти 2 кімнати типу Deluxe з мінімум 2 ліжками.");
        assertTrue(filteredRooms.contains(rooms.get(0)), "Список повинен містити room1.");
        assertTrue(filteredRooms.contains(rooms.get(2)), "Список повинен містити room3.");
    }

    @Test
    void testSortCustomersByLastName() {
        // Отримуємо відсортований список замовників, що зберігаються в сервісі
        List<Customer> sortedCustomers = service.sortCustomersByLastName();
        assertEquals(2, sortedCustomers.size(), "Список клієнтів повинен містити 2 елементи.");
        assertEquals("Іваненко", sortedCustomers.get(0).getLastName(), "Перший клієнт повинен бути 'Іваненко'.");
        assertEquals("Петренко", sortedCustomers.get(1).getLastName(), "Другий клієнт повинен бути 'Петренко'.");
    }

    @Test
    void testFindNearestReservation() {
        Room targetRoom = rooms.get(0); // room1 з номером 101
        Optional<Reservation> nearestReservation = service.findNearestReservation(reservations, targetRoom);

        assertTrue(nearestReservation.isPresent(), "Повинно бути знайдено найближче бронювання для room1.");
        assertEquals(LocalDate.of(2024, 6, 1), nearestReservation.get().getCheckInDate(),
                "Дата заїзду найближчого бронювання для room1 повинна бути 2024-06-01.");
    }

    @Test
    void testFindNearestReservationNotFound() {
        Room targetRoom = rooms.get(1); // room2 з номером 102, для якого немає бронювання
        Optional<Reservation> nearestReservation = service.findNearestReservation(reservations, targetRoom);

        assertTrue(nearestReservation.isEmpty(), "Для room2 не повинно бути знайдено бронювань.");
    }
}
