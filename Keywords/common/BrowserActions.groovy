package common

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

class BrowserActions {

    @Keyword
    def openApplication() {

        // Open browser

        WebUI.openBrowser('')

        // Navigate to application

        WebUI.navigateToUrl(GlobalVariable.BASE_URL)
    }

    @Keyword
    def closeApplication() {

        // Close browser

        WebUI.closeBrowser()
    }
}