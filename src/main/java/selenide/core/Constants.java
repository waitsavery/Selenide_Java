package selenide.core;

public class Constants {
	//************
	//*	TIMEOUTS *
	//************
	//Define the value used to define the amount of time a WebDriver will search for a WebElement if it is not immediately located
	final static private long implicitWaitTimeout = (long) 10.0;
	//Define the value used to define the amount of time a WebDriver will wait for a given page to be completely loaded
	final static private long pageLoadTimeout = (long) 60.0;
	//Define the value used to define the amount of time a WebDriver will wait for a command from a test script
	final static private long scriptTimeout = (long) 20.0;
	//Define the value used to define a default test timeout
	final static private int defaultTestTimeout = 60;
	/**
	 * @summary returns the constant implicit wait timeout
	 * @return long, implicit wait timeout
	 */
	public static long getImplicitWaitTimeout(){return implicitWaitTimeout;}
	/**
	 * @summary returns the constant page load timeout
	 * @return long, page load timeout
	 */
	public static long getPageLoadTimeout(){return pageLoadTimeout;}
	/**
	 * @summary returns the constant script timeout
	 * @return long, script timeout
	 */
	public static long getScriptTimeout(){return scriptTimeout;}
	/**
	 * @summary returns the default test timeout
	 * @return int, default test timeout
	 */
	public static int getDefaultTestTimeout(){return defaultTestTimeout;}
	//********
	//*	URLS *
	//********
	//Define the BlueSource staging URL
	final static private String bluesource_stage="https://bluesourcestaging.herokuapp.com/login";
	/**
	 * @summary gets the URL of the application under test, determined by passing the application name and test environment
	 * @param application - String, application under test
	 * @param environment - String, test environment
	 * @return String, URL of the application under test
	 */
	public static String getURL(String application, String environment){
		String appEnv = application.toLowerCase().trim().replace(" ", "") + "_" + environment.toLowerCase().trim().replace(" ", "");
		String url;
		switch (appEnv) {
			case "bluesource_stage":
				url = bluesource_stage;
				break;
			default:
				String message = "A URL was not located for the application ["+application+"] and environment ["+environment+"].";
				System.out.println(message);
				throw new RuntimeException(message);
		}
		return url;
	}
	//***************
	//*	CREDENTIALS *
	//***************
	//Define the username for the company admin in the BlueSource staging environment
	final static private String bluesource_companyadmin_username="company.admin";
	//Define the password for the company admin in the BlueSource staging environment
	final static private String bluesource_companyadmin_password="test";
	/**
	 * @summary gets the credentials to be used in the application under test, determined by passing the application name and user role
	 * @param application - String, application under test
	 * @param role - String, user role to use for the test
	 * @return String[], 2-dimensional array containing:
	 * 					 credentials[0] -> username
	 * 					 credentials[1] -> password
	 */
	public static String[] getCredentials(String application, String role){
		String appRole = application.toLowerCase().trim().replace(" ", "") + "_" + role.toLowerCase().trim().replace(" ", "");
		String credentials[] = new String[2];
		switch (appRole) {
		case "bluesource_companyadmin":
			credentials[0] = bluesource_companyadmin_username;
			credentials[1] = bluesource_companyadmin_password;
			break;
		default:
			String message = "Credentials were not located for the application ["+application+"] and role ["+role+"].";
			System.out.println(message);
			throw new RuntimeException(message);
		}
		return credentials;
	}
}
