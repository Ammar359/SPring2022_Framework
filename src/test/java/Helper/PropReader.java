package Helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropReader {

    private String url = "";
    private String browser = "";
    private String version = "";
    private String sauceUser = "";
    private String sauceKey = "";
    private String os = "";
    private String runOn = "";

    public PropReader() {
        Properties prop = new Properties();
        try {
            InputStream is = new FileInputStream("Data.properties");

            prop.load(is);

            if (System.getProperty("browser") != null) {
                browser = System.getProperty("browser");
            } else {
                browser = prop.getProperty("browser");
            }

            if (System.getProperty("runOn") != null) {
                runOn = System.getProperty("runOn");
            } else {
                runOn = prop.getProperty("runOn");
            }

            url = prop.getProperty("url");
            // runOn = prop.getProperty("runOn");
            // browser = prop.getProperty("browser");
            version = prop.getProperty("version");

            sauceUser = prop.getProperty("sauceUser");
            sauceKey = prop.getProperty("sauceKey");
            os = prop.getProperty("os");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSauceUser() {return sauceUser;}

    public String getSauceKey() {return sauceKey;}

    public String getOs() {return os;}

    public String getBrowser() {return browser;}
    public String getVersion() {return version;}

    public String getRunOn() {return runOn;}




}