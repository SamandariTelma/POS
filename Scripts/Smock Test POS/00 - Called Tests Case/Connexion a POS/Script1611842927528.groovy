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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

//System. setProperty("webdriver.gecko.driver", "D:\\Utilisateurs\\samandari\\QA\\Outils\\geckodriver.exe")
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Ouvrir le navigateur'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.urlPreprod)

WebUI.waitForElementPresent(findTestObject('Page Login POS-/Champ de saisie identifiant'), 3)

'Saisir le bon identifiant'
WebUI.delay(0.500)

WebUI.setText(findTestObject('Page Login POS-/Champ de saisie identifiant'), GlobalVariable.loginUsername)

'Saisir le bon mot de passe'
WebUI.setText(findTestObject('Page Login POS-/Champ de saisie mot de passe'), GlobalVariable.loginPassword)

'Cliquer sur le bouton connecter'
WebUI.click(findTestObject('Page Login POS-/Bouton connecter'))

'Faire disparaitre les popups'
WebUI.delay(3)

//WebDriver mydriver =  DriverFactory.getWebDriver()
//mydriver.switchTo().alert().accept();
//WebUI.delay(10)
//'Verifier qu\' on est connecté'
//WebUI.waitForElementPresent(findTestObject('null'), 0)

/*
Robot rb = new Robot()

rb.keyPress(KeyEvent.VK_ENTER)

WebUI.delay(2)

rb.keyPress(KeyEvent.VK_ENTER)

WebUI.delay(2)
*/

//WebUI.waitForAlert(5)

//WebUI.verifyAlertPresent(5)

//WebUI.acceptAlert()

WebUI.delay(2)


