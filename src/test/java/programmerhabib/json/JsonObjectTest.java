package programmerhabib.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JsonObjectTest {

    @Test
    void createJson() throws JsonProcessingException {
        Map<String, Object> person = Map.of(
                "firstName", "Septiadi",
                "lastName", "Habib",
                "age",29,
                "married", true,
                "address", Map.of(
                        "street", "Jl. Utama Sukaraya",
                        "city", "Cikarang",
                        "country", "Indonesia"
                )
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);
    }

    @Test
    void readJson() throws JsonProcessingException {
        String json = """
                {
                  "firstName": "Septiadi",
                  "address": {
                    "city": "Cikarang",
                    "street": "Jl. Utama Sukaraya",
                    "country": "Indonesia"
                  },
                  "lastName": "Habib",
                  "age": 29,
                  "married": true
                }
                                
                """;
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> person = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });

        Assertions.assertEquals("Septiadi", person.get("firstName"));
        Assertions.assertEquals("Habib", person.get("lastName"));
    }
}
