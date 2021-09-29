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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement

//Declaration du montant du Bundle
int montantAPayer = 1000

String montantAPayerMGA = '1 000 MGA'

String montantInsufisantMGA = '999 MGA' //montant a payer -1

WebUI.deleteAllCookies()

'Connect to POS'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Connexion a POS'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Nouveau Panier'), 10)

'Verify Home page URL'
WebUI.verifyMatch('https://tapq404lv/pos/pos/activity', WebUI.getUrl(), false)

'Click on button Nouveau Panier'
WebUI.click(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Nouveau Panier'))

'Click on button Vente bundle'
WebUI.waitForElementPresent(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Vente bundle'), 3)

WebUI.scrollToElement(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Vente bundle'), 3)

WebUI.delay(0.500)

WebUI.click(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Vente bundle'), FailureHandling.STOP_ON_FAILURE)

'Verify that a popin titled Categorie de vente appear'
WebUI.waitForElementPresent(findTestObject('Page d accueil POS-/Popin Categorie de Vente/Titre popin'), 3)

WebUI.verifyElementPresent(findTestObject('Page d accueil POS-/Popin Categorie de Vente/Titre popin'), 3)

'Click on button Net'
WebUI.click(findTestObject('Page d accueil POS-/Popin Categorie de Vente/Bouton Net'))

'Click on button Daily'
WebUI.waitForElementPresent(findTestObject('Page d accueil POS-/Popin Categorie de Vente/Bouton Daily'), 3)

WebUI.click(findTestObject('Page d accueil POS-/Popin Categorie de Vente/Bouton Daily'))

'I see the purchase bundle page with article details\r\neg:\r\nLibellé: NET ONE DAY\r\nCode : Bundle_00023\r\nCode sage : MOBBUNDLE_00023\r\n'
WebUI.waitForElementPresent(findTestObject('Page Vente POS-/Champ Libelle'), 3)

WebUI.verifyElementAttributeValue(findTestObject('Page Vente POS-/Champ Libelle'), 'value', 'NET ONE DAY', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementAttributeValue(findTestObject('Page Vente POS-/Champ Code'), 'value', 'BUNDLE_00023', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementAttributeValue(findTestObject('Page Vente POS-/Champ Code Sage'), 'value', 'MOBBUNDLE_00023', 0, FailureHandling.CONTINUE_ON_FAILURE)

'Verify if the button "Ajouter" is not clickable'
WebUI.verifyElementNotClickable(findTestObject('Page Vente POS-/Bouton Ajouter'))

'Enter transaction reference'
WebUI.sendKeys(findTestObject('Page Vente POS-/Champ Ref Transaction'), '646441354165')

WebUI.delay(3)

'Verify if the button Ajouter become clickable'
WebUI.verifyElementClickable(findTestObject('Page Vente POS-/Bouton Ajouter'))

'Click on button Ajouter'
WebUI.click(findTestObject('Page Vente POS-/Bouton Ajouter'))

WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Page Vente POS-/Produit ajouter en Panier en cours'), 3)

'Verify if article is added in cart'
WebUI.verifyElementText(findTestObject('Page Vente POS-/Produit ajouter en Panier en cours'), 'NET ONE DAY\nBundle')

'Make payment'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Payer en espèce'), [('montantAPayer') : montantAPayer
        , ('montantAPayerMGA') : montantAPayerMGA, ('montantInsufisantMGA') : montantInsufisantMGA], FailureHandling.CONTINUE_ON_FAILURE)

'Finalize the sale'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Finaliser la vente'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'Edit bill'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Editer facture'), [:], FailureHandling.CONTINUE_ON_FAILURE)

