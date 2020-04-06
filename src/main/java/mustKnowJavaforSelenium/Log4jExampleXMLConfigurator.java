package mustKnowJavaforSelenium;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log4jExampleXMLConfigurator {

	
	public static Logger logger = Logger.getLogger(Log4jExampleXMLConfigurator.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DOMConfigurator.configure("Log4j.xml");
		
		logger.debug("This is debug message");
		logger.info("This is info message");
		logger.warn("This is warning message");
		logger.error("This is error message");
		logger.fatal("This is fatal error message");
		
	}

}
