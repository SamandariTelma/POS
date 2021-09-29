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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

String imei = "$imei"

String statutAttendu = "$statutAttendu"

String depot = "$depot"

/*
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Connexion a POS'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Menu POS-/Menu Parametrage'), 3)

'Je clique sur "Paramétrage" dans le menu principal puis sur "numéro de série" '
WebUI.click(findTestObject('Menu POS-/Menu Parametrage'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Menu POS-/Sous menu Numros de serie'), 3)

WebUI.click(findTestObject('Menu POS-/Sous menu Numros de serie'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForPageLoad(3)
*/
//Navigation dans un nouvelle onglet
String currentPage = WebUI.getUrl()

int currentTab = WebUI.getWindowIndex()

WebDriver driver = DriverFactory.getWebDriver()

JavascriptExecutor js = ((driver) as JavascriptExecutor)

js.executeScript('window.open();')

WebUI.switchToWindowIndex(currentTab + 1)

WebUI.navigateToUrl(currentPage)

//------------------------------------
'Je clique sur "Paramétrage" dans le menu principal puis sur "numéro de série" '
WebUI.click(findTestObject('Menu POS-/Menu Parametrage'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Menu POS-/Sous menu Numros de serie'), 3)

WebUI.click(findTestObject('Menu POS-/Sous menu Numros de serie'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Titre page'), 10)

'Je recherche l\'imei du produit enregistré dans le trasfert'
WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ IMEI'), imei)

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Bouton Rechercher'))

WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/IMEI premiere ligne'), 
    7)

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/IMEI premiere ligne'), 
    imei)

'Dans IMEI/SN/ICCID/FMC, affichage statut de l\'article ajouté qui est passé de Dispo  au statut "ALLOUE TR"'
WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/Statut premiere ligne'), 
    statutAttendu)

'Vérifier que le dépôt est correspond au dépôt de l\'article'
WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/Dépôt premiere ligne'), 
    depot)

WebUI.closeWindowIndex(1)

