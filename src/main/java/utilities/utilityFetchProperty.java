package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class utilityFetchProperty {
    public static String fetchPropertyValue (String key) throws IOException {
        FileInputStream file = new FileInputStream("./src/test/resources/config/config.properties");
        Properties property = new Properties();
        property.load(file);
        return property.get(key).toString();
    }
}
