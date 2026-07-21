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

WebUI.openBrowser(null)

WebUI.navigateToUrl('https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login')

WebUI.click(findTestObject('Page_XYZ Bank/button_Bank Manager Login'))

WebUI.click(findTestObject('Page_XYZ Bank/button_Add Customer'))

WebUI.setText(findTestObject('Page_XYZ Bank/input_First Name'), 'John')

WebUI.setText(findTestObject('Page_XYZ Bank/input_Last Name'), 'Smith')

WebUI.setText(findTestObject('Page_XYZ Bank/input_Post Code'), '12345')

WebUI.click(findTestObject('Page_XYZ Bank/button_Add Customer_1'))

// Verify that the success alert appears

WebUI.verifyAlertPresent(5)

// Read the alert message

String alertText = WebUI.getAlertText()

// Verify the alert message

WebUI.verifyMatch(
	alertText,
	'Customer added successfully with customer id :.*',
	true
)

// Accept the alert

WebUI.acceptAlert()

// Close browser

WebUI.closeBrowser()

