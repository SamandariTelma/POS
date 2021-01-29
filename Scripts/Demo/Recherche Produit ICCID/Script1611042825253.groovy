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
import org.openqa.selenium.Keys as Keys
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper

'Se connecter à POS'
WebUI.callTestCase(findTestCase('Demo/Connexion a POS'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Menu POS-/Menu Parametrage'), 0)

'Cliquer sur le menu Parametrage'
WebUI.click(findTestObject('Menu POS-/Menu Parametrage'))

'Cliquer sur le sous menu Numeros de serie'
WebUI.click(findTestObject('Menu POS-/Sous menu Numros de serie'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Onglet ICCID'), 0)

'Choisir l\'onglet ICCID'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Onglet ICCID'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Statut'), 0)

'Cliquer sur le champ statut'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Statut'))

'Cocher l option DISPO dans le champ statut'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox DISPO'))

'Fermet l\'option dans le champ statut'
Robot rb = new Robot()

rb.keyPress(KeyEvent.VK_ESCAPE)

/*WebUI.delay(6, FailureHandling.STOP_ON_FAILURE)


WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Bouton Rechercher'))*/
//* Ou on utilise cette syntaxe
'Cliquer sur le bouton Rechercher'
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('Page Gestion des Numéros de Série-/Bouton Rechercher'), 
    30)

WebUI.executeJavaScript('arguments[0].click()', Arrays.asList(element))

'Recuperer le numero de l article'
String numeroArticle = WebUI.getText(findTestObject('Page Gestion des Numéros de Série-/Numero ICCID premire ligne'))

GlobalVariable.numeroArticle = numeroArticle

String montantArticle = WebUI.getText(findTestObject('Page Gestion des Numéros de Série-/Montant ICCID premiere ligne'))

GlobalVariable.montantArticle = montantArticle

System.out.println('Numero =' + GlobalVariable.numeroArticle)

System.out.println('Montant =' + GlobalVariable.montantArticle)

