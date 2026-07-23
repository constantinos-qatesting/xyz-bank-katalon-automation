package bank

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class ManagerActions {

    @Keyword
    def openBankManager() {

        // Open Bank Manager page

        WebUI.click(
            findTestObject('Object Repository/Page_XYZ Bank/button_Bank Manager Login')
        )
    }
	@Keyword
	def addCustomer(
		String firstName,
		String lastName,
		String postCode
	) {
	
		// Open Add Customer page
	
		WebUI.click(
			findTestObject('Object Repository/Page_XYZ Bank/button_Add Customer')
		)
	
		// Enter first name
	
		WebUI.setText(
			findTestObject('Object Repository/Page_XYZ Bank/input_First Name'),
			firstName
		)
	
		// Enter last name
	
		WebUI.setText(
			findTestObject('Object Repository/Page_XYZ Bank/input_Last Name'),
			lastName
		)
	
		// Enter post code
	
		WebUI.setText(
			findTestObject('Object Repository/Page_XYZ Bank/input_Post Code'),
			postCode
		)
	
		// Submit new customer
	
		WebUI.click(
			findTestObject('Object Repository/Page_XYZ Bank/button_Add Customer_1')
		)
	}
	@Keyword
	def openAccount(String customerName, String currency) {
	
		// Open Account page
	
		WebUI.click(
			findTestObject('Object Repository/Page_XYZ Bank/button_Open Account')
		)
	
		// Select customer
	
		WebUI.selectOptionByLabel(
			findTestObject('Object Repository/Page_XYZ Bank/select_userSelect'),
			customerName,
			false
		)
	
		// Select currency
	
		WebUI.selectOptionByLabel(
			findTestObject('Object Repository/Page_XYZ Bank/select_currency'),
			currency,
			false
		)
	
		// Submit account creation
	
		WebUI.click(
			findTestObject('Object Repository/Page_XYZ Bank/button_Process')
		)
	}
}