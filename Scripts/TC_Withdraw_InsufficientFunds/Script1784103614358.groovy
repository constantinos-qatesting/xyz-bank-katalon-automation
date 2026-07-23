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
Test Case: Withdraw Insufficient Funds

Description:
Verify that a customer cannot withdraw more than the available balance
and that the account balance remains unchanged.
*/

// Open application

CustomKeywords.'common.BrowserActions.openApplication'()

// Login as Harry Potter

CustomKeywords.'bank.CustomerActions.loginAsCustomer'('Harry Potter')


// Prepare the account with a deposit

int depositAmount = 50

CustomKeywords.'bank.CustomerActions.depositMoney'(depositAmount)

// Read balance before withdrawal

int balanceBefore = WebUI.getText(
    findTestObject('Object Repository/Page_XYZ Bank/span_AccountBalance')
).trim().toInteger()

// Set withdrawal amount higher than the balance

int withdrawalAmount = 100

// Attempt withdrawal

CustomKeywords.'bank.CustomerActions.withdrawMoney'(withdrawalAmount)

// Verify failed withdrawal message

WebUI.verifyElementText(
    findTestObject('Object Repository/Page_XYZ Bank/span_TransactionFailed'),
    'Transaction Failed. You can not withdraw amount more than the balance.'
)

// Read balance after failed withdrawal

int balanceAfter = WebUI.getText(
    findTestObject('Object Repository/Page_XYZ Bank/span_AccountBalance')
).trim().toInteger()

// Verify balance remains unchanged

WebUI.verifyEqual(balanceAfter, balanceBefore)

// Close application

CustomKeywords.'common.BrowserActions.closeApplication'()