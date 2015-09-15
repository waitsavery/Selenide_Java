package selenide.core.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenide.core.test.BaseTestClass;

public class Element {
	// ******************
	// * ELEMENT FIElDS *
	// ******************
	// Define a base element from which all extending classes will inherit
	private WebElement element;
	// Define a base driver from which all extending classes will inherit. Will
	// be define the same driver as that used by the test
	private WebDriver elementDriver;
	// Define a BaseTestClass object which is passed from the test level when a
	// page class is instantiated
	public BaseTestClass btc;

	// **********************
	// * ELEMENT BUILD AREA *
	// **********************
	/**
	 * Dummy constructor
	 */
	public Element() {
	}

	/**
	 * Constructor that builds the element class. Uses a BaseTestClass instance
	 * to define the driver to use to find elements
	 * 
	 * @param btc
	 *            - BaseTestClass, passed from the test level when a page class
	 *            is instantiated
	 */
	public Element(BaseTestClass btc) {
		System.out.println("Entering BaseTestClass");
		this.btc = btc;
		setElementDriver(btc.getDriver());
	}

	// ***********************
	// * GETTERS AND SETTERS *
	// ***********************
	//
	// Define getter/setter for the local driver
	/**
	 * @summary sets the local driver
	 * @param driver
	 *            - WebDriver, local driver
	 */
	private void setElementDriver(WebDriver driver) {
		this.elementDriver = driver;
	}

	/**
	 * @Summary gets the local driver
	 * @return WebDriver, local driver
	 */
	public WebDriver getElementDriver() {
		return this.elementDriver;
	}

	// Define getter/setter for the element
	/**
	 * @summary sets the element to be used by subsequent Element-class methods
	 * @param element
	 *            - WebElement, used to define the current element
	 */
	public void setElement(WebElement element) {
		this.element = element;
	}

	/**
	 * @summary overloaded method, uses the local driver to set the element to
	 *          be used by subsequent Element-class methods
	 * @param by
	 *            - By, used to define the current element
	 */
	public void setElement(By by) {
		this.element = getElementDriver().findElement(by);
	}

	/**
	 * @summary overloaded method, sets the local driver which is used to set
	 *          the element to be used by subsequent Element-class methods
	 * @param driver
	 *            - WebDriver, used to define the local driver
	 * @param by
	 *            - By, used to define the current element
	 * @return
	 */
	public void setElementAndDriver(WebDriver driver, By by) {
		setElementDriver(driver);
		setElement(by);
	}

	public WebElement getElement() {
		return this.element;
	}

	public void setElementBaseTestClass(BaseTestClass btc) {
		this.btc = btc;
		setElementDriver(btc.getDriver());
	}

	// ************************
	// * ELEMENT INTERACTIONS *
	// ************************
	public String getElementLocator() {
		return "@FindBy: " + getElementLocatorBy() + " = " + getElementLocatorUsing();
	}

	private String getElementLocatorBy() {
		return getElement().toString().split("->")[1].split(":")[0].trim();
	}

	private String getElementLocatorUsing() {
		return getElement().toString().split("->")[1].split(":")[1].trim();
	}

	public boolean elementWired() {
		return (getElement() != null);
	}
}
