package lab3;

import lab3.serializers.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        try {
            // Створення об'єктів
            LocalDate birthDate1 = LocalDate.of(1990, 1, 1);
            LocalDate birthDate2 = LocalDate.of(1985, 3, 15);
            LocalDate birthDate3 = LocalDate.of(1995, 5, 20);

            Room room = new Room("R101", "Suite", 200.0);
            Customer customer = new Customer(
                    "C001", "John", "Doe", "john.doe@example.com", "123-456-7890",
                    birthDate1, "New York", Collections.emptyList()
            );
            Reservation reservation = new Reservation(
                    "RES001",
                    birthDate2, birthDate3, customer, room
            );

            // Файли
            String jsonPath = "reservation.json";
            String xmlPath = "reservation.xml";
            String yamlPath = "reservation.yaml";  // Переконайтесь, що шлях вірний

            // JSON Серіалізація
            JsonEntitySerializer<Reservation> jsonSerializer = new JsonEntitySerializer<>();
            jsonSerializer.serialize(reservation, jsonPath);
            System.out.println("JSON Serialized: " + jsonSerializer.deserialize(jsonPath, Reservation.class));

            // XML Серіалізація
            XmlEntitySerializer<Reservation> xmlSerializer = new XmlEntitySerializer<>();
            xmlSerializer.serialize(reservation, xmlPath);  // Передаємо шлях як String
            System.out.println("XML Serialized: " + xmlSerializer.deserialize(xmlPath, Reservation.class));

            // YAML Серіалізація
            YamlEntitySerializer<Reservation> yamlSerializer = new YamlEntitySerializer<>();
            yamlSerializer.serialize(reservation, yamlPath);  // Передаємо шлях як String
            System.out.println("YAML Serialized: " + yamlSerializer.deserialize(yamlPath, Reservation.class));

//            YamlEntitySerializer<Reservation> yamlSerializer = new YamlEntitySerializer<>();
//            Reservation deserializedUser = yamlSerializer.deserialize(yamlPath, Reservation.class);
//            System.out.println(deserializedUser);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
