import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/*
 Test Case: Withdraw Valid Amount
 
 Description:
 Verify that a customer can withdraw money
 and the account balance decreases correctly.
 */
 
 // Open browser
 
 WebUI.openBrowser('')
 
 // Go to application
 
 WebUI.navigateToUrl(GlobalVariable.BASE_URL)
 
 // Login as Harry Potter
 
 WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_CustomerLogin'))
 
 WebUI.selectOptionByLabel(
	 findTestObject('Object Repository/Page_XYZ Bank/select_userSelect'),
	 'Harry Potter',
	 false
 )
 
 WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_Login'))
 
 // Prepare the account with a deposit
 
 int depositAmount = 100
 
 WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_Deposit'))
 
 WebUI.setText(
	 findTestObject('Object Repository/Page_XYZ Bank/input_WithdrawAmount'),
	 depositAmount.toString()
 )
 
 WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_SubmitDeposit'))
 
 // Verify deposit message
 
 WebUI.verifyElementText(
	 findTestObject('Object Repository/Page_XYZ Bank/span_DepositSuccessful'),
	 'Deposit Successful'
 )
 
 // Read balance before withdrawal
 
 int balanceBefore = WebUI.getText(
	 findTestObject('Object Repository/Page_XYZ Bank/span_AccountBalance')
 ).trim().toInteger()
 
 // Calculate expected balance
 
 int withdrawalAmount = 50
 
 int expectedBalance = balanceBefore - withdrawalAmount
 
 // Open withdrawal form
 
 WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_Withdraw'))
 
 // Enter withdrawal amount
 
 WebUI.setText(
	 findTestObject('Object Repository/Page_XYZ Bank/input_WithdrawAmount'),
	 withdrawalAmount.toString()
 )
 
 // Submit withdrawal
 
 WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_SubmitWithdraw'))
 
 // Verify successful withdrawal message
 
 WebUI.verifyElementText(
	 findTestObject('Object Repository/Page_XYZ Bank/span_TransactionSuccessful'),
	 'Transaction successful'
 )
 
 // Read balance after withdrawal
 
 int balanceAfter = WebUI.getText(
	 findTestObject('Object Repository/Page_XYZ Bank/span_AccountBalance')
 ).trim().toInteger()
 
 // Verify balance decreased correctly
 
 WebUI.verifyEqual(balanceAfter, expectedBalance)
 
 // Close browser
 
 WebUI.closeBrowser()