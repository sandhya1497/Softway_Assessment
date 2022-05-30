package genericLib;

import java.io.FileInputStream;
import java.util.Properties;

public class Utility {
    public static String getpropertykeyvalue(String key)
    {
        Properties prop =null;
        try {

            FileInputStream ip=new FileInputStream("./src/main/resources/application.properties");
            prop=new Properties();
            prop.load(ip);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }

    public static String getElement(String key)
    {
        Properties prop =null;
        try {

            FileInputStream ip=new FileInputStream("./src/main/java/objectRepo/elements.properties");
            prop=new Properties();
            prop.load(ip);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}
