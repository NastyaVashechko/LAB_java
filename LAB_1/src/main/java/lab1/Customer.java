package lab1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Клас Customer представляє замовника, який бронює номер.
 */
public class Customer {
    private String lastName;
    private String firstName;
    private String documentId;
    private LocalDate dateOfBirth;

    public Customer(String lastName, String firstName, String documentId, LocalDate dateOfBirth) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.documentId = documentId;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", documentId='" + documentId + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return lastName.equals(customer.lastName) &&
                firstName.equals(customer.firstName) &&
                documentId.equals(customer.documentId) &&
                dateOfBirth.equals(customer.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, documentId, dateOfBirth);
    }

    // Геттери
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getDocumentId() { return documentId; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
}

