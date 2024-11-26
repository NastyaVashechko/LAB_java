package lab4;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CustomerValidator {

    private static final Pattern DOCUMENT_ID_PATTERN = Pattern.compile("^[A-Z0-9]{8,10}$");

    public static List<String> validateAll(String lastName, String firstName, String documentId, LocalDate dateOfBirth) {
        List<String> errors = new ArrayList<>();

        errors.addAll(validateLastName(lastName));
        errors.addAll(validateFirstName(firstName));
        errors.addAll(validateDocumentId(documentId));
        errors.addAll(validateDateOfBirth(dateOfBirth));

        return errors;
    }

    public static List<String> validateLastName(String lastName) {
        List<String> errors = new ArrayList<>();
        if (lastName == null || lastName.trim().isEmpty()) {
            errors.add("Last name is invalid (value: '" + lastName + "'): cannot be empty.");
        }
        if (lastName != null && (lastName.length() < 2 || lastName.length() > 50)) {
            errors.add("Last name is invalid (value: '" + lastName + "'): must be between 2 and 50 characters.");
        }
        return errors;
    }

    public static List<String> validateFirstName(String firstName) {
        List<String> errors = new ArrayList<>();
        if (firstName == null || firstName.trim().isEmpty()) {
            errors.add("First name is invalid (value: '" + firstName + "'): cannot be empty.");
        }
        if (firstName != null && (firstName.length() < 2 || firstName.length() > 50)) {
            errors.add("First name is invalid (value: '" + firstName + "'): must be between 2 and 50 characters.");
        }
        return errors;
    }

    public static List<String> validateDocumentId(String documentId) {
        List<String> errors = new ArrayList<>();
        if (documentId == null || !DOCUMENT_ID_PATTERN.matcher(documentId).matches()) {
            errors.add("Document ID is invalid (value: '" + documentId + "'): must be 8-10 alphanumeric characters.");
        }
        return errors;
    }

    public static List<String> validateDateOfBirth(LocalDate dateOfBirth) {
        List<String> errors = new ArrayList<>();
        if (dateOfBirth == null || dateOfBirth.isAfter(LocalDate.now())) {
            errors.add("Date of birth is invalid (value: '" + dateOfBirth + "'): must be a date in the past.");
        }
        if (dateOfBirth != null && Period.between(dateOfBirth, LocalDate.now()).getYears() < 18) {
            errors.add("Date of birth is invalid (value: '" + dateOfBirth + "'): must indicate an age of 18 years or older.");
        }
        return errors;
    }
}
