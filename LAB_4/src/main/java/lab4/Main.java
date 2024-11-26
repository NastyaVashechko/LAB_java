package lab4;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Customer customer1 = new Customer.Builder()
                    .setLastName("Doe")
                    .setFirstName("John")
                    .setDocumentId("AB1234567")
                    .setDateOfBirth(LocalDate.of(1990, 1, 1))
                    .build();
            System.out.println("User 1: " + customer1);
        } catch (IllegalArgumentException e) {
            System.err.println("Validation failed for User 1: " + e.getMessage());
        }

        try {
            Customer customer2 = new Customer.Builder()
                    .setLastName("Smith")
                    .setFirstName("Jane")
                    .setDocumentId("CD7890123")
                    .setDateOfBirth(LocalDate.of(1985, 3, 15))
                    .build();
            System.out.println("User 2: " + customer2);
        } catch (IllegalArgumentException e) {
            System.err.println("Validation failed for User 2: " + e.getMessage());
        }

        try {
            Customer invalidCustomer = new Customer.Builder()
                    .setLastName("!")
                    .setFirstName("A")
                    .setDocumentId("12345")
                    .setDateOfBirth(LocalDate.of(2025, 1, 1))
                    .build();
            System.out.println("Invalid User: " + invalidCustomer);
        } catch (IllegalArgumentException e) {
            System.err.println("Validation failed for invalidUser: " + e.getMessage());
        }
    }
}
