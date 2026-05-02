package Utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    Properties prop;

    public ConfigReader() {
        try {
            prop = new Properties();

            InputStream input =
                    getClass()
                            .getClassLoader()
                            .getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException("KHÔNG TÌM THẤY FILE config.properties");
            }

            prop.load(input);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return prop.getProperty("url");
    }

    public String getInventoryUrl() {
        return prop.getProperty("inventoryUrl");
    }

    public String getUsername(){
        return prop.getProperty("username");
    }

    public String getPassword(){
        return prop.getProperty("password");
    }
}