package utlis;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ReadFromJson {

    private final ObjectMapper objectMapper;
    private final String filePath;

    public ReadFromJson(String filePath) {
        this.filePath = filePath;
        this.objectMapper = new ObjectMapper();
    }

    public String getDataFromJson(String key) {

        try {
            JsonNode rootNode = objectMapper.readTree(new File(filePath));
            String[] keys = key.split("\\.");

            JsonNode valueNode = rootNode;

            for (String k : keys) {
                valueNode = valueNode.path(k);
            }

            if (!valueNode.isMissingNode()) {
                return valueNode.asText();
            } else {
                System.out.println("Key not found in the JSON file: " + key);
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
