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

// Open application

CustomKeywords.'common.BrowserActions.openApplication'()

// Open Bank Manager

CustomKeywords.'bank.ManagerActions.openBankManager'()

WebUI.click(findTestObject('Page_XYZ Bank/button_Customers'))

WebUI.setText(findTestObject('Page_XYZ Bank/input_Search Customer'), 'harry')

WebUI.verifyElementText(
	findTestObject('Object Repository/Page_XYZ Bank/cell_HarryFirstName'),
	'Harry'
)

WebUI.verifyElementText(
	findTestObject('Object Repository/Page_XYZ Bank/cell_HarryLastName'),
	'Potter'
)

// Close application

CustomKeywords.'common.BrowserActions.closeApplication'()