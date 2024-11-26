package lab3.serializers;

import java.io.File;
import java.io.IOException;

public interface EntitySerializer<T> {
    // Метод для серіалізації об'єкта в файл
    void serialize(T object, String filePath) throws IOException;

    // Метод для десеріалізації об'єкта з файлу
    T deserialize(String filePath, Class<T> clazz) throws IOException;
}
