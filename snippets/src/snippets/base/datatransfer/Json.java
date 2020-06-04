package snippets.base.datatransfer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class Json {
    public static void run() throws IOException {
        InputStream input = Json.class.getResourceAsStream("book.json");
        ObjectMapper mapper = new ObjectMapper();
        // 反序列化时忽略不存在的JavaBean属性:
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Book book = mapper.readValue(input, Book.class);
        String json = mapper.writeValueAsString(book);
        System.out.println(json);
    }
}
