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

'En tant que User connecté sur la preprod, je Clique sur gestion de stock > Sous-Menus ENTREE'
WebUI.waitForElementPresent(findTestObject('Menu POS-/Menu Gestion de stock/Menu Gestion de stock'), 30, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Menu POS-/Menu Gestion de stock/Menu Gestion de stock'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Menu POS-/Menu Gestion de stock/Sous menu entree'), 5)

WebUI.click(findTestObject('Menu POS-/Menu Gestion de stock/Sous menu entree'), FailureHandling.CONTINUE_ON_FAILURE)

'Affichage de la page choix de l\'entrée de stock :- les boutons Réception P/O\r\n- Réception TR\r\n- Entrée exceptionnelle\r\n- ordre de rapatriement'
WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Bouton Reception TR'), 30, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(0.500)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Titre page'), 3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Bouton Reception PO'), 3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Bouton Reception TR'), 3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Bouton Entree exceptionnelle'), 3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Sortie de stock/Bouton Ordre de rapatriement'), 3)

