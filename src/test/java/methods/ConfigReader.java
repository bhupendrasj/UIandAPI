package methods;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;

    static {
        try {
            FileInputStream fis =
                    new FileInputStream("src/test/resources/config/qa.properties");

            prop = new Properties();
            prop.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        if ("api.key".equals(key)) {
            String apiKey = System.getenv("API_KEY");
            if (apiKey == null || apiKey.trim().isEmpty()) {
                throw new IllegalStateException(
                        "Environment variable API_KEY is required for api.key");
            }
            return apiKey;
        }
        return prop.getProperty(key);
    }

    public static Properties getProperties() {
        return prop;
    }
}
