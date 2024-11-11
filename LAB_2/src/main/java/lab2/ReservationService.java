package lab2;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReservationService {

    // Список замовників, які керують бронюванням
    private final List<Customer> customers;

    /**
     * Конструктор для ReservationService, приймає список замовників.
     *
     * @param customers список замовників, які керують бронюванням.
     * @throws IllegalArgumentException якщо список замовників є null
     */
    public ReservationService(List<Customer> customers) {
        if (customers == null) {
            throw new IllegalArgumentException("Customer list cannot be null");
        }
        this.customers = customers;
    }

    /**
     * Повертає список усіх замовників.
     *
     * @return список замовників.
     */
    public List<Customer> getCustomers() {
        return customers;
    }

    /**
     * Додає замовника до списку замовників.
     *
     * @param customer замовник, якого потрібно додати.
     * @throws IllegalArgumentException якщо замовник є null
     */
    public void addCustomer(Customer customer) {
        if (customer != null) {
            this.customers.add(customer);
        } else {
            throw new IllegalArgumentException("Customer cannot be null");
        }
    }

    /**
     * Видаляє замовника зі списку замовників.
     *
     * @param customer замовник, якого потрібно видалити.
     * @throws IllegalArgumentException якщо замовник є null
     */
    public void removeCustomer(Customer customer) {
        if (customer != null) {
            this.customers.remove(customer);
        } else {
            throw new IllegalArgumentException("Customer cannot be null");
        }
    }

    /**
     * Фільтрує список кімнат за типом і кількістю ліжок.
     *
     * @param rooms список усіх доступних кімнат
     * @param type тип кімнати для фільтрації
     * @param minBeds мінімальна кількість ліжок
     * @return список кімнат, що відповідають заданим критеріям
     */
    public List<Room> filterRoomsByTypeAndBeds(List<Room> rooms, String type, int minBeds) {
        return rooms.stream()
                .filter(room -> room.getType().equalsIgnoreCase(type) && room.getBedCount() >= minBeds)
                .collect(Collectors.toList());
    }

    /**
     * Сортує список замовників за прізвищем в алфавітному порядку.
     *
     * @return відсортований список замовників
     */
    public List<Customer> sortCustomersByLastName() {
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getLastName))
                .collect(Collectors.toList());
    }

    /**
     * Знаходить найближче бронювання для вказаної кімнати.
     *
     * @param reservations список усіх бронювань
     * @param room кімната, для якої потрібно знайти найближче бронювання
     * @return найближче бронювання, якщо знайдено
     */
    public Optional<Reservation> findNearestReservation(List<Reservation> reservations, Room room) {
        return reservations.stream()
                .filter(reservation -> reservation.getRoom().equals(room))
                .min(Comparator.comparing(Reservation::getCheckInDate));
    }
}
