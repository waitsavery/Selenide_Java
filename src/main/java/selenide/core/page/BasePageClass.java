package selenide.core.page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import selenide.core.Constants;
import selenide.core.test.BaseTestClass;

public class BasePageClass extends Element{

	// **************************************************************************************************
	// * 								BASE PAGE CLASS FIElDS 											*
	// **************************************************************************************************
	long timeout = (long) 0.0;
	String message;
	public enum syncTypes {visible, hidden, enabled, disabled}

	// **************************************************************************************************
	// * 							BASE PAGE CLASS BUILD AREA 											*
	// **************************************************************************************************
	/**
	 * Dummy constructor
	 */
	public BasePageClass(){}
	/**
	 * @sumamry Constructor that builds the element class. Uses a BaseTestClass instance to define the driver to use to find elements
	 * @param 	btc - BaseTestClass, passed from the test level when a page class is instantiated
	 */
	public BasePageClass(BaseTestClass btc){}

	// **************************************************************************************************
	// * 								GETTERS AND SETTERS 											*
	// **************************************************************************************************

	// **************************************************************************************************
	// * 							BASE PAGE CLASS INTERACTIONS 										*
	// **************************************************************************************************
	//*******************************
	//*******************************
	//*				SET				*
	//*******************************
	//*******************************
	/**
	 * @summary syncs to the current element (textbox) to be visible, clears the element and sends a string of keys to set the value
	 * @param 	value - String, keys to set the value of the element
	 */
	public void set(String value){
		sync(syncTypes.visible);
		System.out.println("Sending keys ["+value+"] to element ["+getElementLocator()+"].");
		getElement().clear();
		getElement().sendKeys(value);
	}
	/**
	 * @summary sets the current element (textbox) and sets it's value
	 * @param 	element - WebElement, current element
	 * @param 	value - String, keys to set the value of the textbox
	 */
	public void set(WebElement element, String value){
		setElement(element);
		set(value);
	}
	/**
	 * @summary sets the current element (textbox) and sets it's value
	 * @param 	by - By, by-value with which to define the current element
	 * @param 	value - String, keys to set the value of the textbox
	 */
	public void set(By by, String value){
		setElement(by);
		set(value);
	}
	/**
	 * @summary sets the current driver and element (textbox) and sets it's value
	 * @param 	driver - WebDriver, current driver
	 * @param 	by - By, by-value to use to define the current element
	 * @param 	value - String, keys to set the value of the textbox
	 */
	public void set(WebDriver driver, By by, String value){
		setElementAndDriver(driver, by);
		set(value);
	}
	//*******************************
	//*******************************
	//*				CLICK			*
	//*******************************
	//*******************************
	/**
	 * @summary syncs to the element to be visible, then clicks the element
	 */
	public void click(){
		sync(syncTypes.visible);
		System.out.println("Clicking on element ["+getElementLocator()+"].");
		getElement().click();
	}
	/**
	 * @summary sets the current element then clicks it
	 * @param 	element - WebElement, current element
	 */
	public void click(WebElement element){
		setElement(element);
		click();
	}
	/**
	 * @summary sets the current element then clicks it
	 * @param 	by - By, by-value with which to define the current element
	 */
	public void click(By by){
		setElement(by);
		click();
	}
	/**
	 * @summary sets the current driver and element then clicks it
	 * @param 	driver - WebDriver, current driver
	 * @param 	by - By, by-value with which to define the current element
	 */
	public void click(WebDriver driver, By by){
		setElementAndDriver(driver, by);
		click();
	}	
	/**
	 * @summary intended to be intuitive for checkboxes, it uses the ckick() method to toggle a checkbox from it's current state 
	 */
	public void check(){
		click();
	}
	/**
	 * @summary intended to be intuitive for checkboxes, it uses the ckick() method to toggle a checkbox from it's current state
	 * @param 	element - WebElement, current element
	 */
	public void check(WebElement element){
		click(element);
	}
	/**
	 * @summary intended to be intuitive for checkboxes, it uses the ckick() method to toggle a checkbox from it's current state
	 * @param 	by - By, value with which to locate an element
	 */
	public void check(By by){
		click(by);
	}
	/**
	 * @summary intended to be intuitive for checkboxes, it uses the ckick() method to toggle a checkbox from it's current state
	 * @param 	driver - WebDriver, current driver
	 * @param 	by - By, value with which to locate an element
	 */
	public void check(WebDriver driver, By by){
		click(driver, by);
	}	
	/**
	 * @summary uses JavaScript to scroll an element into view and then click it
	 */
	public void jsClick() {
		JavascriptExecutor executor = (JavascriptExecutor) getElementDriver();
		executor.executeScript(
				"arguments[0].scrollIntoView(true);arguments[0].click();",
				getElement());
	}
	/**
	 * @summary sets the current element then uses JavaScript to scroll an element into view and then click it
	 * @param 	element - WebElement, current element
	 */
	public void jsClick(WebElement element) {
		setElement(element);
		jsClick();
	}
	/**
	 * @summary sets the current element then uses JavaScript to scroll an element into view and then click it
	 * @param 	by - By, value with which to locate an element
	 */
	public void jsClick(By by) {
		setElement(by);
		jsClick();
	}
	/**
	 * @summary sets the current driver and element then uses JavaScript to scroll an element into view and then click it
	 * @param 	driver - WebDriver, current driver
	 * @param 	by - By, value with which to locate an element
	 */
	public void jsClick(WebDriver driver, By by) {
		setElementAndDriver(driver, by);
		jsClick();
	}
	//*******************************
	//*******************************
	//*			HIGHLIGHT			*
	//*******************************
	//*******************************
	/**
	 * @summary - uses JavaScript to highlight an element
	 */
	public void highlight() {
		sync(syncTypes.visible);
		((JavascriptExecutor) getElementDriver()).executeScript(
				"arguments[0].style.border='3px solid red'", getElement());
	}
	/**
	 * @summary sets the current element then uses JavaScript to highlight an element
	 * @param 	element - WebElement, current element
	 */
	public void highlight(WebElement element) {
		setElement(element);
		highlight();
	}
	/**
	 * @summary sets the current element then uses JavaScript to highlight an element
	 * @param 	by - By,  by-value with which to define the current element
	 */
	public void highlight(By by) {
		setElement(by);
		highlight();
	}
	/**
	 * @summary sets the current driver and element then uses JavaScript to highlight an element
	 * @param 	driver - WebDriver, current driver
	 * @param 	by - By, by-value with which to define the current element
	 */
	public void highlight(WebDriver driver, By by) {
		setElementAndDriver(driver, by);
		highlight();
	}
	//*******************************
	//*******************************
	//*		SCROLL INTO VIEW		*
	//*******************************
	//*******************************
	/**
	 * @summary - uses JavaScript to scroll an element into view on the screen
	 */
	public void scrollIntoView() {
		((JavascriptExecutor) getElementDriver()).executeScript(
				"arguments[0].scrollIntoView(true);", getElement());
	}	
	/**
	 * @summary sets the current element then uses JavaScript to scroll an element into view on the screen
	 * @param 	element - WebElement, current element
	 */
	public void scrollIntoView(WebElement element) {
		setElement(element);
		scrollIntoView();
	}	
	/**
	 * @summary sets the current element then uses JavaScript to scroll an element into view on the screen
	 * @param 	by - By, by-value with which to define the current element
	 */
	public void scrollIntoView(By by) {
		setElement(by);
		scrollIntoView();
	}	
	/**
	 * @summary sets the current driver and element then uses JavaScript to scroll an element into view on the screen
	 * @param 	driver - WebDriver, current driver
	 * @param 	by - By, by-value with which to define the current element
	 */
	public void scrollIntoView(WebDriver driver, By by) {
		setElementAndDriver(driver, by);
		scrollIntoView();
	}
	
	//***************************
	//***************************
	//*			SYNCS			*
	//***************************
	//***************************
	/**
	 * @summary sets the WebDriver's ImplicitWait timeout determined by a user=defined timeout
	 * @param 	timeout - long, amount of time in seconds to wait for an element to be located should it not be immediately located
	 */
	private void setSyncTimeout(long timeout){
		this.timeout = timeout;
		getElementDriver().manage().timeouts().implicitlyWait(this.timeout, TimeUnit.SECONDS);
	}
	/**
	 * @summary resets the WebDriver's ImplicitWait timeout to the value found in the Constants.java file
	 */
	private void resetSyncTimeout(){
		this.timeout = (long) 0.0;
		getElementDriver().manage().timeouts().implicitlyWait(Constants.getImplicitWaitTimeout(), TimeUnit.SECONDS);
	}
	/**
	 * @summary outputs a list of valid syncs for reporting
	 * @param 	syncTypeArray - string array of valid sync types
	 * @return 	string, valid sync types
	 */
	private String outputValidSyncTypes(){
		String types = "";
		for(syncTypes type: syncTypes.values()){
			types += type.toString() + " ; ";
		}
		return types;
	}
	/**
	 * @summary Synchronizes to an element property which is determined by a user-defined parameter. 
	 * 			The duration of the sync is determined by the WebDriver's ImplicitWait timeout.
	 * 			Valid sync types: visible, hidden, enabled, disabled
	 * @param 	syncType - used to define the type of sync to perform
	 * @see 	https://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/WebElement.html#isDisplayed()
	 * @see 	https://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/WebElement.html#isEnabled()
	 * @return 	Boolean, true if the sync is successful, false otherwise
	 */
	public Boolean sync(syncTypes type){
		Boolean synced = false;
		String reportTimeout = "";
		if(timeout == 0.0) reportTimeout = String.valueOf(Constants.getImplicitWaitTimeout());
		System.out.println("Syncing to element ["+getElementLocator()+"] to be "+type.toString()+" within ["+reportTimeout+"] seconds.");
		switch (type) {
		case visible:
			synced = getElement().isDisplayed();
			break;
		case hidden:
			synced = !(getElement().isDisplayed());
			break;
		case enabled:
			synced = getElement().isEnabled();
			break;
		case disabled:
			synced = !(getElement().isEnabled());
			break;
		default:
			message = "The sync type ["+type.toString()+"] is not valid. Valid values are: ["+outputValidSyncTypes()+"]";
			System.out.println(message);
			break;
		}
		return synced;
	}
	
	/**
	 * @summary Synchronizes to an element property which is determined by a user-defined parameter.
	 * 			The duration of the sync is determined by user-defined parameter.
	 * @param 	syncType - String, type of sync to perform
	 * @param 	timeout - long, value to set for the ImplicitWait timeout
	 * @return 	Boolean, true if the sync is successful, false otherwise
	 */
	public Boolean sync(syncTypes syncType, long timeout){
		Boolean synced = false;
		setSyncTimeout(timeout);
		synced = sync(syncType);
		resetSyncTimeout();
		return synced;
	}
	/**
	 * @summary Synchronizes to an element property which is determined by a user-defined parameter.
	 * 			The duration of the sync is determined by user-defined parameter.
	 * 			If the sync fails, the test can fail if the user-defined parameter indicates it
	 * @param 	syncType - String, type of sync to perform
	 * @param 	timeout - long, value to set for the ImplicitWait timeout
	 * @param 	failOnFalse - Boolean, true if the test should fail on sync failure, false otherwise
	 * @return 	Boolean, true if the sync is successful, false otherwise
	 */
	public Boolean sync(syncTypes syncType, long timeout, Boolean failOnFalse){
		Boolean synced = false;
		setSyncTimeout(timeout);
		synced = sync(syncType);
		resetSyncTimeout();
		if(failOnFalse && !synced){
			message = "The element [" +getElementLocator()+ "] was not found to be [" +syncType+ "] after ["+String.valueOf(timeout)+"] seconds.";
			System.out.println(message);
			throw new RuntimeException(message);
		}else{
			return synced;	
		}
	}
	/**
	 * @summary Synchronizes to an element property which is determined by a user-defined parameter.
	 * 			The duration of the sync is determined by the ImplicitWait value in the Constants.java file.
	 * 			If the sync fails, the test can fail if the user-defined parameter indicates it
	 * @param 	syncType - String, type of sync to perform
	 * @param 	failOnFalse - Boolean, true if the test should fail on sync failure, false otherwise
	 * @return 	Boolean, true if the sync is successful, false otherwise
	 */
	public Boolean sync(syncTypes syncType, Boolean failOnFalse){
		Boolean synced = false;
		synced = sync(syncType);
		if(failOnFalse && !synced){
			message = "The element [" +getElementLocator()+ "] was not found to be [" +syncType+ "] after ["+String.valueOf(timeout)+"] seconds.";
			System.out.println(message);
			throw new RuntimeException(message);
		}else{
			return synced;	
		}
	}	
	/**
	 * @summary Sets the current element and synchronizes to an element property which is determined by a user-defined parameter.
	 * 			The duration of the sync is determined by the ImplicitWait value in the Constants.java file.
	 * @param 	element - WebElement, current element
	 * @param 	syncType - String, type of sync to perform
	 * @return 	Boolean, true if the sync is successful, false otherwise
	 */
	public Boolean sync(WebElement element, syncTypes syncType){
		setElement(element);
		return sync(syncType);
	}
	/**
	 * @summary Sets the current element and synchronizes to an element property which is determined by a user-defined parameter.
	 * 			The duration of the sync is determined by user-defined parameter.
	 * @param 	element - WebElement, current element
	 * @param 	syncType - String, type of sync to perform
	 * @param 	timeout - long, value to set for the ImplicitWait timeout
	 * @return 	Boolean, true if the sync is successful, false otherwise
	 */
	public Boolean sync(WebElement element, syncTypes syncType, long timeout){
		setElement(element);
		return sync(syncType, timeout);
	}
	/**
	 * @summary Sets the current element and synchronizes to an element property which is determined by a user-defined parameter.
	 * 			The duration of the sync is determined by user-defined parameter.
	 * 			If the sync fails, the test can fail if the user-defined parameter indicates it
	 * @param 	element - WebElement, current element
	 * @param 	syncType - String, type of sync to perform
	 * @param 	timeout - long, value to set for the ImplicitWait timeout
	 * @param 	failOnFalse - Boolean, true if the test should fail on sync failure, false otherwise
	 * @return 	Boolean, true if the sync is successful, false otherwise
	 */
	public Boolean sync(WebElement element, syncTypes syncType, long timeout, Boolean failOnFalse){
		setElement(element);
		return sync(syncType, timeout, failOnFalse);
	}
	/**
	 * @summary Sets the current element and synchronizes to an element property which is determined by a user-defined parameter.
	 * 			The duration of the sync is determined by the ImplicitWait value in the Constants.java file.
	 * 			If the sync fails, the test can fail if the user-defined parameter indicates it
	 * @param 	element - WebElement, current element
	 * @param 	syncType - String, type of sync to perform
	 * @param 	failOnFalse - Boolean, true if the test should fail on sync failure, false otherwise
	 * @return 	Boolean, true if the sync is successful, false otherwise
	 */
	public Boolean sync(WebElement element, syncTypes syncType, Boolean failOnFalse){
		setElement(element);
		return sync(syncType, failOnFalse);
	}	
	/**
	 * @summary Sets the current element and synchronizes to an element property which is determined by a user-defined parameter.
	 * 			The duration of the sync is determined by the ImplicitWait value in the Constants.java file.
	 * @param 	by - By,  by-value with which to define the current element 
	 * @param 	syncType - String, type of sync to perform
	 * @return	Boolean, true if the sync is successful, false otherwise
	 */
	public Boolean sync(By by, syncTypes syncType){
		setElement(by);
		return sync(syncType);
	}
	/**
	 * @summary Sets the current element and synchronizes to an element property which is determined by a user-defined parameter.
	 * 			The duration of the sync is determined by user-defined parameter.
	 * @param by - By,  by-value with which to define the current element 
	 * @param syncType - String, type of sync to perform
	 * @param timeout - long, value to set for the ImplicitWait timeout
	 * @return Boolean, true if the sync is successful, false otherwise
	 */
	public Boolean sync(By by, syncTypes syncType, long timeout){
		setElement(by);
		return sync(syncType, timeout);
	}
	/**
	 * @summary Sets the current element and synchronizes to an element property which is determined by a user-defined parameter.
	 * 			The duration of the sync is determined by user-defined parameter.
	 * 			If the sync fails, the test can fail if the user-defined parameter indicates it
	 * @param 	by - By,  by-value with which to define the current element 
	 * @param 	syncType - String, type of sync to perform
	 * @param 	timeout - long, value to set for the ImplicitWait timeout
	 * @param 	failOnFalse - Boolean, true if the test should fail on sync failure, false otherwise
	 * @return 	Boolean, true if the sync is successful, false otherwise
	 */
	public Boolean sync(By by, syncTypes syncType, long timeout, Boolean failOnFalse){
		setElement(by);
		return sync(syncType, timeout, failOnFalse);
	}
	/**
	 * @summary Sets the current element and synchronizes to an element property which is determined by a user-defined parameter.
	 * 			The duration of the sync is determined by the ImplicitWait value in the Constants.java file.
	 * 			If the sync fails, the test can fail if the user-defined parameter indicates it
	 * @param 	by - By,  by-value with which to define the current element 
	 * @param 	syncType - String, type of sync to perform
	 * @param 	failOnFalse - Boolean, true if the test should fail on sync failure, false otherwise
	 * @return 	Boolean, true if the sync is successful, false otherwise
	 */
	public Boolean sync(By by, syncTypes syncType, Boolean failOnFalse){
		setElement(by);
		return sync(syncType, failOnFalse);
	}
	
	/**
	 * @summary This uses the HTML DOM readyState property to wait until a page is
	 * 			finished loading. It will wait for the ready state to be either
	 * 			'interactive' or 'complete'.
	 * @version 12/16/2014
	 * @author 	Jessica Marshall
	 * @return 	True if the DOM is interactive or complete, false otherwise
	 * @throws InterruptedException 
	 */
	public boolean isDomInteractive() throws InterruptedException {
		Boolean isInteractive = true;
		int count = 0;
		Object obj = null;
		if(this.timeout == 0.0)setSyncTimeout(Constants.getPageLoadTimeout());
		do {
			// this returns a boolean
			obj = ((JavascriptExecutor) getElementDriver()).executeScript(
					"var result = document.readyState; return (result == 'complete' || result == 'interactive');");
			if (count == this.timeout){
				resetSyncTimeout();
				return false;
			}
			Thread.sleep(500);
			count++;
		} while (obj.equals(false));
		resetSyncTimeout();
		return isInteractive;
	}

	/**
	 * @summary Overloaded method - gives option of specifying a timeout. This uses the
	 * 			HTML DOM readyState property to wait until a page is finished loading. It
	 * 			will wait for the ready state to be either 'interactive' or 'complete'.
	 * @param 	timeout - int number seconds to wait for a page to finish
	 *            		loading before quitting
	 * @version 12/16/2014
	 * @author 	Jessica Marshall
	 * @return 	True if the DOM is interactive or complete, false otherwise
	 * @throws InterruptedException 
	 */
	public boolean isDomInteractive(int timeout) throws InterruptedException {
		Boolean interactive = false;
		setSyncTimeout(timeout);
		interactive = isDomInteractive();
		return interactive;
	}

	/**
	 * @summary A more strict version of isDomInteractive. This uses the HTML DOM
	 * 			readyState property to wait until a page is finished loading. It will
	 * 			wait for the ready state to be 'complete'.
	 * @version 12/16/2014
	 * @author 	Jessica Marshall
	 * @return 	True if the DOM is interactive or complete, false otherwise
	 * @throws InterruptedException 
	 */
	public boolean isDomComplete() throws InterruptedException {
		Boolean isComplete = true;
		int count = 0;
		Object obj = null;
		if(this.timeout == 0.0)setSyncTimeout(Constants.getPageLoadTimeout());
		do {
			// this returns a boolean
			obj = ((JavascriptExecutor) getElementDriver())
					.executeScript("var result = document.readyState; return (result == 'complete');");
			if (count == this.timeout){
				resetSyncTimeout();
				return false;
			}
			Thread.sleep(500);
			count++;
		} while (obj.equals(false));
		resetSyncTimeout();
		return isComplete;
	}

	/**
	 * @summary Overloaded method - gives option of specifying a timeout. A more strict
	 * 			version of isDomInteractive This uses the HTML DOM readyState property to
	 * 			wait until a page is finished loading. It will wait for the ready state
	 * 			to be 'complete'.
	 * @param 	timeout - int, number seconds to wait for a page to finish loaded before quiting
	 * @version 12/16/2014
	 * @author 	Jessica Marshall
	 * @return 	True if the DOM is interactive or complete, false otherwise
	 * @throws InterruptedException 
	 */
	public boolean isDomComplete(int timeout) throws InterruptedException {
		setSyncTimeout(timeout);
		return isDomComplete();
	}
	
	//*******************************************************************************************************
	//*******************************************************************************************************
	//*******************************************************************************************************
	//*											SELECTS CLASS												*
	//*******************************************************************************************************
	//*******************************************************************************************************
	//*******************************************************************************************************
	public class Selects{

		// **************************************************************************************************
		// * 								BASE PAGE CLASS FIElDS 											*
		// **************************************************************************************************
		Select select;

		// **************************************************************************************************
		// * 							BASE PAGE CLASS BUILD AREA 											*
		// **************************************************************************************************
		/**
		 * @summary constructor to build a Select element that sets the local Element as well as the local Select element
		 * @param selectElement - WebElement, current Select/Element
		 */
		public Selects(WebElement selectElement){
			setElement(selectElement);
			setSelectElement(getElement());
		}
		
		// **************************************************************************************************
		// * 							BASE PAGE CLASS INTERACTIONS 										*
		// **************************************************************************************************
		/**
		 * @summary sets the current Select element
		 * @param element - WebElement, current element
		 */
		private void setSelectElement(WebElement element){
			this.select = new Select(element);
		}
		/**
		 * @summary gets the curent Select element
		 * @return Select, current Select element
		 */
		private Select getSelectElement(){
			return this.select;
		}
		/**
		 * @summary gets all options of a Select element  and concatenates them into a String and returns them
		 * @return String, concatenated string of all options
		 */
		public String getAllOptionsAsString(){
			List<WebElement> options = getSelectElement().getOptions();
			String strOptions = "";
			syncSelected();
			for(WebElement option : options){
				strOptions += option.getText() + ";";
			}
			return strOptions;
		}
		/**
		 * @summary gets all selected options of a Select element and concatenates them into a String and returns them
		 * @return String, concatenated string of all selected options
		 */
		public String getAllSelectedOptionsAsString(){
			List<WebElement> options = getSelectElement().getAllSelectedOptions();
			String strOptions = "";
			syncSelected();
			for(WebElement option : options){
				strOptions += option.getText() + ";";
			}
			return strOptions;
		}
		/**
		 * @summary gets the selected option as a string
		 * @return String, selected option as a string
		 */
		public String getSelectedOptionAsString(){
			syncSelected();
			return getSelectElement().getFirstSelectedOption().getText();
		}
		/**
		 * @summary syncs to a Select element and selects an option by index
		 * @param index - int, index number to choose
		 */
		public void selectByIndex(int index){
			syncSelected();
			System.out.println("Selecting index ["+String.valueOf(index)+"] from element ["+getElementLocator()+"].");
			getSelectElement().selectByIndex(index);
		}
		/**
		 * @summary syncs to a Select element and selects an option by value
		 * @param value - String, value to choose
		 */
		public void selectByValue(String value){
			syncSelected();
			System.out.println("Selecting option with value ["+value+"] from element ["+getElementLocator()+"].");
			getSelectElement().selectByValue(value);
		}
		/**
		 * @summary syncs to a Select element and selects an option by visible text
		 * @param visibleText - String, text for which to search
		 */
		public void selectByVisibleText(String visibleText){
			syncSelected();
			System.out.println("Selecting option with visible text ["+visibleText+"] from element ["+getElementLocator()+"].");
			getSelectElement().selectByVisibleText(visibleText);
		}
		/**
		 * @summary syncs to a Select element and deselects all options
		 */
		public void deselectAllOptions(){
			syncSelected();
			System.out.println("Deselect all options/values from element ["+getElementLocator()+"].");
			getSelectElement().deselectAll();
		}
		/**
		 * @summary syncs to a Select element and deselects an option by index
		 * @param index - int, index of option to deselect
		 */
		public void deselectByIndex(int index){
			syncSelected();
			System.out.println("Deselect option with index ["+String.valueOf(index)+"] from element ["+getElementLocator()+"].");
			getSelectElement().deselectByIndex(index);
		}
		/**
		 * @summary syncs to a Select element and deselects an option by value
		 * @param value - String, value of the option to deselect
		 */
		public void deselectByValue(String value){
			syncSelected();
			System.out.println("Deselect option with value ["+value+"] from element ["+getElementLocator()+"].");
			getSelectElement().deselectByValue(value);
		}
		/**
		 * @summary syncs to a Select element and deselects an option by visible text
		 * @param visibleText - text by which to deselect an option
		 */
		public void deselectByVisibleText(String visibleText){
			syncSelected();
			System.out.println("Deselect option with visible text ["+visibleText+"] from element ["+getElementLocator()+"].");
			getSelectElement().deselectByVisibleText(visibleText);
		}
		
		//***********************************
		//***********************************
		//*			SELECT SYNCS			*
		//***********************************
		//***********************************
		/**
		 * @summary Synchronizes to an element to be selected. 
		 *			The duration of the sync is determined by the WebDriver's ImplicitWait timeout
		 * @see 	https://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/WebElement.html#isSelected()
		 * @return 	Boolean, true if the sync is successful, false otherwise
		 */
		public Boolean syncSelected(){
			Boolean synced = false;
			synced = getElement().isSelected();
			return synced;
		}
		/**
		 * @summary Synchronizes to an element to be selected. 
		 *			The duration of the sync is determined by the WebDriver's ImplicitWait timeout
		 * @param 	timeout - long, value to set for the ImplicitWait timeout
		 * @return 	Boolean, true if the sync is successful, false otherwise
		 */
		public Boolean syncSelected(long timeout){
			Boolean synced = false;
			setSyncTimeout(timeout);
			synced = syncSelected();
			resetSyncTimeout();
			return synced;
		}
		/**
		 * @summary Synchronizes to an element to be selected.
		 * 			The duration of the sync is determined by user-defined parameter.
		 * 			If the sync fails, the test can fail if the user-defined parameter indicates it
		 * @param 	timeout - long, value to set for the ImplicitWait timeout
		 * @param 	failOnFalse - Boolean, true if the test should fail on sync failure, false otherwise
		 * @return 	Boolean, true if the sync is successful, false otherwise
		 */
		public Boolean syncSelected(long timeout, Boolean failOnFalse){
			Boolean synced = false;
			synced = syncSelected(timeout);
			if(failOnFalse && !synced){
				message = "The element ["+getElementLocator()+"] was not found to have been selected after ["+String.valueOf(timeout)+"] seconds.";
				System.out.println(message);
				throw new RuntimeException(message);
			}else{
				return synced;
			}
		}
		/**
		 * @summary Synchronizes to an element to be selected.
		 * 			The duration of the sync is determined by the WebDriver's ImplicitWait timeout
		 * 			If the sync fails, the test can fail if the user-defined parameter indicates it
		 * @param 	failOnFalse - Boolean, true if the test should fail on sync failure, false otherwise
		 * @return  Boolean, true if the sync is successful, false otherwise
		 */
		public Boolean syncSelected(Boolean failOnFalse){
			Boolean synced = false;
			synced = syncSelected();
			if(failOnFalse && !synced){
				message = "The element ["+getElementLocator()+"] was not found to have been selected after ["+String.valueOf(Constants.getImplicitWaitTimeout())+"] seconds.";
				System.out.println(message);
				throw new RuntimeException(message);
			}else{
				return synced;
			}
		}
		/**
		 * @summary Sets the current element then synchronizes to an element to be selected. 
		 *			The duration of the sync is determined by the WebDriver's ImplicitWait timeout
		 * @param 	element - WebElement, current element
		 * @return  Boolean, true if the sync is successful, false otherwise
		 */
		public Boolean syncSelected(WebElement element){
			setElement(element);
			return syncSelected();
		}
		/**
		 * @summary Sets the current element then synchronizes to an element to be selected. 
		 *			The duration of the sync is determined by user-defined parameter.
		 * @param 	element - WebElement, current element
		 * @param 	timeout - long, value to set for the ImplicitWait timeout
		 * @return  Boolean, true if the sync is successful, false otherwise
		 */
		public Boolean syncSelected(WebElement element, long timeout){
			setElement(element);
			return syncSelected(timeout);
		}
		/**
		 * @summary Sets the current element then synchronizes to an element to be selected.
		 * 			The duration of the sync is determined by user-defined parameter.
		 * 			If the sync fails, the test can fail if the user-defined parameter indicates it
		 * @param 	element - WebElement, current element
		 * @param 	timeout - long, value to set for the ImplicitWait timeout
		 * @param 	failOnFalse - Boolean, true if the test should fail on sync failure, false otherwise
		 * @return  Boolean, true if the sync is successful, false otherwise
		 */
		public Boolean syncSelected(WebElement element, long timeout, Boolean failOnFalse){
			setElement(element);
			return syncSelected(timeout, failOnFalse);
		}
		/**
		 * @summary Sets the current element then Synchronizes to an element to be selected.
		 * 			The duration of the sync is determined by user-defined parameter.
		 * 			If the sync fails, the test can fail if the user-defined parameter indicates it
		 * @param 	element - WebElement, current element
		 * @param 	failOnFalse - Boolean, true if the test should fail on sync failure, false otherwise
		 * @return  Boolean, true if the sync is successful, false otherwise
		 */
		public Boolean syncSelected(WebElement element, Boolean failOnFalse){
			setElement(element);
			return syncSelected(failOnFalse);
		}
		/**
		 * @summary Sets the current element then synchronizes to an element to be selected. 
		 *			The duration of the sync is determined by the WebDriver's ImplicitWait timeout
		 * @param 	by - By, by-value with which to define the current element 
		 * @return  Boolean, true if the sync is successful, false otherwise
		 */
		public Boolean syncSelected(By by){
			setElement(by);
			return syncSelected();
		}
		/**
		 * @summary Sets the current element then synchronizes to an element to be selected. 
		 *			The duration of the sync is determined by user-defined parameter.
		 * @param 	by - By, by-value with which to define the current element
		 * @param 	timeout - long, value to set for the ImplicitWait timeout
		 * @return  Boolean, true if the sync is successful, false otherwise
		 */
		public Boolean syncSelected(By by, long timeout){
			setElement(by);
			return syncSelected(timeout);
		}
		/**
		 * @summary Sets the current element then synchronizes to an element to be selected.
		 * 			The duration of the sync is determined by user-defined parameter.
		 * 			If the sync fails, the test can fail if the user-defined parameter indicates it
		 * @param 	by - By, by-value with which to define the current element
		 * @param 	timeout - long, value to set for the ImplicitWait timeout
		 * @param 	failOnFalse - Boolean, true if the test should fail on sync failure, false otherwise
		 * @return  Boolean, true if the sync is successful, false otherwise
		 */
		public Boolean syncSelected(By by, long timeout, Boolean failOnFalse){
			setElement(by);
			return syncSelected(timeout, failOnFalse);
		}
		/**
		 * @summary Sets the current element then Synchronizes to an element to be selected.
		 * 			The duration of the sync is determined by user-defined parameter.
		 * 			If the sync fails, the test can fail if the user-defined parameter indicates it
		 * @param 	by - By, by-value with which to define the current element
		 * @param 	failOnFalse - Boolean, true if the test should fail on sync failure, false otherwise
		 * @return  Boolean, true if the sync is successful, false otherwise
		 */
		public Boolean syncSelected(By by, Boolean failOnFalse){
			setElement(by);
			return syncSelected(failOnFalse);
		}
	}
}
