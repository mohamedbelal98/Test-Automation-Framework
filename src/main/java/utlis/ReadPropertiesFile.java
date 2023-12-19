package utlis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

    private final Properties properties;

    public ReadPropertiesFile(String filePath) {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBrowserType() {
        return properties.getProperty("browserType");
    }

}