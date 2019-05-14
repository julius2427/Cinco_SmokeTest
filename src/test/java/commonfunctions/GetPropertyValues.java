package commonfunctions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class GetPropertyValues {
	static String result = "";
	static InputStream inputStream;
	static Properties prop;
	
	public static void getProperties() throws IOException {

		try {
			prop = new Properties();
			String propFileName = "config.properties";
			

//			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			inputStream = GetPropertyValues.class.getResourceAsStream(propFileName);
			  
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			Date time = new Date(System.currentTimeMillis());
 
			// get the property value and print it out
			String environment = prop.getProperty("environment");
			
//			String user = prop.getProperty("user");
//			String company1 = prop.getProperty("company1");
//			String company2 = prop.getProperty("company2");
//			String company3 = prop.getProperty("company3");
 
			result = "Environment= " + environment;
			System.out.println(result + "\nProgram Ran on " + time + " in environment " + environment);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
	}
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
		
}
