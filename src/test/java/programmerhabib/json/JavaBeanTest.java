package programmerhabib.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JavaBeanTest {

    @Test
    void createJsonFromObject() throws JsonProcessingException {
        Person person = new Person();
        person.setId("1");
        person.setName("Habib");
        person.setHobbies(List.of("Coding", "Gaming"));

        Address address = new Address();
        address.setStreet("Jl. Utama Sukaraya");
        address.setCity("Cikarang");
        address.setCountry("Indonesia");
        person.setAddress(address);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);
    }

    @Test
    void readObjectFromJson() throws JsonProcessingException {
        String json = """
                  {
                  "id": "1",
                  "name": "Habib",
                  "hobbies": [
                    "Coding",
                    "Gaming"
                  ],
                  "address": {
                    "street": "Jl. Utama Sukaraya",
                    "city": "Cikarang",
                    "country": "Indonesia"
                  }
                }             
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(json, Person.class);

        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals("Habib", person.getName());
        Assertions.assertEquals("Jl. Utama Sukaraya", person.getAddress().getStreet());
        Assertions.assertEquals("Cikarang", person.getAddress().getCity());
        Assertions.assertEquals("Indonesia", person.getAddress().getCountry());
    }
}
