package mustKnowJavaforSelenium;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Log4jExampleBasicConfigurator {

	//creating logger object from Logger class without new keyword (in Factory design pattern)
	public static Logger logger = Logger.getLogger(Log4jExampleBasicConfigurator.class);
	
		public static void main(String[] args) {

		BasicConfigurator.configure();
		logger.debug("This is debug message");
		logger.info("This is info message");
		logger.warn("This is warning message");
		logger.error("This is error message");
		logger.fatal("This is fata error message");

	}

}
