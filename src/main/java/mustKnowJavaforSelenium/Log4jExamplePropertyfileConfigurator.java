package mustKnowJavaforSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jExamplePropertyfileConfigurator {

	
	public static Logger logger = Logger.getLogger(Log4jExamplePropertyfileConfigurator.class);
	
	public static void main(String[] args) throws FileNotFoundException {
		
//		FileInputStream inputStream = new FileInputStream("Log4j.properties");
//		PropertyConfigurator.configure(inputStream);
		PropertyConfigurator.configure("Log4j.properties");
		logger.debug("This is debug message");
		logger.info("This is info message");
		logger.warn("This is warning message");
		logger.error("This is error message");
		logger.fatal("This is fata error message");
		
		
	}

}
