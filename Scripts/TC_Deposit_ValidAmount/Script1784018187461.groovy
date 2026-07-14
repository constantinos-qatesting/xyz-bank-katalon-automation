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
 Test Case: Deposit Valid Amount
 
 Description:
 Verify that a customer can deposit money
 and the account balance is updated correctly.
 */
 
 // Open browser
 
 WebUI.openBrowser('')
 
 // Go to application
 
 WebUI.navigateToUrl(GlobalVariable.BASE_URL)
 
 // Login as Harry Potter
 
 WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_Customer Login'))
 
 WebUI.selectOptionByLabel(
	 findTestObject('Object Repository/Page_XYZ Bank/select_userSelect'),
	 'Harry Potter',
	 false
 )
 
 WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_Login'))
 
 // Read current balance before deposit
 
 int balanceBefore = WebUI.getText(
	 findTestObject('Object Repository/Page_XYZ Bank/span_AccountBalance')
 ).trim().toInteger()
 
 // Deposit amount for this test
 
 int depositAmount = 100
 
 // Calculate expected balance
 
 int expectedBalance = balanceBefore + depositAmount
 
 // Open Deposit page
 
 WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_Deposit'))
 
 // Enter deposit amount
 
 WebUI.setText(
	 findTestObject('Object Repository/Page_XYZ Bank/input_amount'),
	 depositAmount.toString()
 )
 
 // Submit deposit
 
 WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_SubmitDeposit'))
 
 // Verify success message
 
 WebUI.verifyElementText(
	 findTestObject('Object Repository/Page_XYZ Bank/span_Deposit Successful'),
	 'Deposit Successful'
 )
 
 // Read balance after deposit
 
 int balanceAfter = WebUI.getText(
	 findTestObject('Object Repository/Page_XYZ Bank/span_AccountBalance')
 ).trim().toInteger()
 
 // Verify the balance increased correctly
 
 WebUI.verifyEqual(balanceAfter, expectedBalance)
 
 // Close browser
 
 WebUI.closeBrowser()