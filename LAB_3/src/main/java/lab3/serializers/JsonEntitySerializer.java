package lab3.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;

public class JsonEntitySerializer<T> implements EntitySerializer<T> {
    private final ObjectMapper mapper;

    public JsonEntitySerializer() {
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());  // Реєструємо модуль для Java 8 типів дат
    }

    @Override
    public void serialize(T object, String filePath) throws IOException {
        File file = new File(filePath);  // Створення об'єкта File
        if (!file.exists()) {
            file.createNewFile();  // Якщо файл не існує, створюємо його
        }
        // Записуємо об'єкт у файл
        mapper.writeValue(file, object);
    }

    @Override
    public T deserialize(String filePath, Class<T> clazz) throws IOException {
        return mapper.readValue(new File(filePath), clazz);  // Читаємо з файлу
    }
}
