/*
 Test Case: Withdraw Valid Amount

 Description:
 Verify that a customer can withdraw money
 and the account balance decreases correctly.
*/

// Open application

CustomKeywords.'common.BrowserActions.openApplication'()

// Login as Harry Potter

CustomKeywords.'bank.CustomerActions.loginAsCustomer'('Harry Potter')

// Prepare the account with a deposit

int depositAmount = 100

CustomKeywords.'bank.CustomerActions.depositMoney'(depositAmount)

// Read balance before withdrawal

int balanceBefore = WebUI.getText(
    findTestObject('Object Repository/Page_XYZ Bank/span_AccountBalance')
).trim().toInteger()

// Set withdrawal amount and calculate expected balance

int withdrawalAmount = 50

int expectedBalance = balanceBefore - withdrawalAmount

// Withdraw money

CustomKeywords.'bank.CustomerActions.withdrawMoney'(withdrawalAmount)

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

// Close application

CustomKeywords.'common.BrowserActions.closeApplication'()