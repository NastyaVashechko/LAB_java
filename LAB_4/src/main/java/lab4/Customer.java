package lab4;

import java.time.LocalDate;
import java.util.List;

public class Customer {
    private String lastName;
    private String firstName;
    private String documentId;
    private LocalDate dateOfBirth;

    private Customer(Builder builder) {
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.documentId = builder.documentId;
        this.dateOfBirth = builder.dateOfBirth;
    }

    public static class Builder {
        private String lastName;
        private String firstName;
        private String documentId;
        private LocalDate dateOfBirth;

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setDocumentId(String documentId) {
            this.documentId = documentId;
            return this;
        }

        public Builder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Customer build() {
            List<String> errors = CustomerValidator.validateAll(lastName, firstName, documentId, dateOfBirth);
            if (!errors.isEmpty()) {
                throw new IllegalArgumentException("Validation failed: " + String.join("; ", errors));
            }
            return new Customer(this);
        }
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
}
