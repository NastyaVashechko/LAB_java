package lab2;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReservationService {

    /**
     * Фільтрує список кімнат за типом та кількістю ліжок.
     *
     * @param rooms список усіх доступних кімнат
     * @param type тип кімнати для фільтрації
     * @param minBeds мінімальна кількість ліжок
     * @return список кімнат, що відповідають критеріям
     */
    public List<Room> filterRoomsByTypeAndBeds(List<Room> rooms, String type, int minBeds) {
        return rooms.stream()
                .filter(room -> room.getType().equalsIgnoreCase(type) && room.getBedCount() >= minBeds)
                .collect(Collectors.toList());
    }

    /**
     * Сортує список клієнтів за прізвищем.
     *
     * @param customers список клієнтів
     * @return відсортований список клієнтів
     */
    public List<Customer> sortCustomersByLastName(List<Customer> customers) {
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getLastName))
                .collect(Collectors.toList());
    }

    /**
     * Знаходить найближче бронювання для заданої кімнати.
     *
     * @param reservations список усіх бронювань
     * @param room кімната для пошуку
     * @return найближче бронювання, якщо знайдено
     */
    public Optional<Reservation> findNearestReservation(List<Reservation> reservations, Room room) {
        return reservations.stream()
                .filter(reservation -> reservation.getRoom().equals(room))
                .min(Comparator.comparing(Reservation::getCheckInDate));
    }
}
