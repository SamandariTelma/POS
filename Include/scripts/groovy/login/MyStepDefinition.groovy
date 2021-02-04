package login
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class MyStepDefinition {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I am on the Login Page")
	def I_am_on_the_Login_Page() {
		WebUI.openBrowser('', FailureHandling.STOP_ON_FAILURE)
		WebUI.navigateToUrl(GlobalVariable.urlPreprod, FailureHandling.STOP_ON_FAILURE)
	}

	@When("I send username (.*) and password (.*)")
	def I_send_username_and_password(String username, String password){
		WebUI.setText(findTestObject('Page Login POS-/Champ de saisie identifiant'), username, FailureHandling.STOP_ON_FAILURE)
		WebUI.setText(findTestObject('Page Login POS-/Champ de saisie mot de passe'), password, FailureHandling.STOP_ON_FAILURE)
	}

	@And("I click on the submit button")
	def I_click_on_the_submit_button() {
		WebUI.click(findTestObject('Page Login POS-/Bouton connecte' ), FailureHandling.STOP_ON_FAILURE)
	}

	@Then("I should be connected")
	def I_sould_be_connected() {
		WebUI.verifyMatch("ok", "ok", false, FailureHandling.STOP_ON_FAILURE)
	}
}