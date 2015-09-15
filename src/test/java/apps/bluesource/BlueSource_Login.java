package apps.bluesource;

import org.testng.annotations.Test;

import selenide.apps.bluesource.employeesPage.EmployeesPage;
import selenide.apps.bluesource.loginPage.LoginPage;

public class BlueSource_Login extends selenide.core.test.BaseTestClass {
	public BlueSource_Login() {
	}

	@Test
	public void test() {

		LoginPage login = new LoginPage(getBaseTestClass());
		login.login();
		EmployeesPage employees = new EmployeesPage(getBaseTestClass());
	}
}