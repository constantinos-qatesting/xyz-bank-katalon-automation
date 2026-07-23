package bank

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class CustomerActions {

    @Keyword
    def loginAsCustomer(String customerName) {

        // Click Customer Login

        WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_CustomerLogin'))

        // Select customer

        WebUI.selectOptionByLabel(
            findTestObject('Object Repository/Page_XYZ Bank/select_userSelect'),
            customerName,
            false
        )

        // Click Login

        WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_Login'))
		
		
    }
	
	@Keyword
	def depositMoney(int amount) {
	
		// Open Deposit form
	
		WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_Deposit'))
	
		// Enter deposit amount
	
		WebUI.setText(
			findTestObject('Object Repository/Page_XYZ Bank/input_WithdrawAmount'),
			amount.toString()
		)
	
		// Submit deposit
	
		WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_SubmitDeposit'))
	
		// Verify success message
	
		WebUI.verifyElementText(
			findTestObject('Object Repository/Page_XYZ Bank/span_DepositSuccessful'),
			'Deposit Successful'
		)
	}
	@Keyword
	def withdrawMoney(int amount) {
	
		// Open Withdraw form
	
		WebUI.click(
			findTestObject('Object Repository/Page_XYZ Bank/button_Withdraw')
		)
	
		// Enter withdrawal amount
	
		WebUI.setText(
			findTestObject('Object Repository/Page_XYZ Bank/input_WithdrawAmount'),
			amount.toString()
		)
	
		// Submit withdrawal
	
		WebUI.click(
			findTestObject('Object Repository/Page_XYZ Bank/button_SubmitWithdraw')
		)
	}
	
	
}