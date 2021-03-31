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

'I connect to the POS website with the correct login'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Connexion a POS'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'Click on the block \'Nouveau Panier\''
WebUI.waitForElementPresent(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Nouveau Panier'), 10)

WebUI.click(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Nouveau Panier'))

'Click on the block \'Vente Bundle\'\r\n'
WebUI.waitForElementPresent(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Vente bundle'), 3)

WebUI.scrollToElement(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Vente bundle'), 3)

WebUI.delay(0.500)

WebUI.click(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Vente bundle'), FailureHandling.STOP_ON_FAILURE)

'Click on the button titled \'Net\'\r\n'
WebUI.waitForElementPresent(findTestObject('Page d accueil POS-/Popin Categorie de Vente/Bouton Net'), 3)

WebUI.click(findTestObject('Page d accueil POS-/Popin Categorie de Vente/Bouton Net'))

'Click on the button titled \'Daily\''
WebUI.waitForElementPresent(findTestObject('Page d accueil POS-/Popin Categorie de Vente/Bouton Daily'), 3)

WebUI.click(findTestObject('Page d accueil POS-/Popin Categorie de Vente/Bouton Daily'))

'I see the purchase bundle page with article details\r\neg:\r\nLibellé: NET ONE DAY\r\nCode : Bundle_00023\r\nCode sage : MOBBUNDLE_00023'
WebUI.waitForElementPresent(findTestObject('Page Vente POS-/Champ Libelle'), 3)

WebUI.verifyElementAttributeValue(findTestObject('Page Vente POS-/Champ Libelle'), 'value', 'NET ONE DAY', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementAttributeValue(findTestObject('Page Vente POS-/Champ Code'), 'value', 'BUNDLE_00023', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementAttributeValue(findTestObject('Page Vente POS-/Champ Code Sage'), 'value', 'MOBBUNDLE_00023', 0, FailureHandling.CONTINUE_ON_FAILURE)

'Enter \'646441354165\' in field \'Réf Transaction\' then click on \r\nthe button \'Ajouter\''
WebUI.sendKeys(findTestObject('Page Vente POS-/Champ Ref Transaction'), '646441354165')

WebUI.delay(8)

'Click the button \'Ajouter\''
WebUI.click(findTestObject('Page Vente POS-/Bouton Ajouter'))

WebUI.delay(0.500)

'Verify if Bundle is added in the section \'PANIER EN COURS\''
WebUI.waitForElementPresent(findTestObject('Page Vente POS-/Produit ajouter en Panier en cours'), 3)

WebUI.verifyElementText(findTestObject('Page Vente POS-/Produit ajouter en Panier en cours'), 'NET ONE DAY\nBundle')

'Make a payment'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Payer en espèce'), [('montantAPayer') : montantAPayer
        , ('montantAPayerMGA') : montantAPayerMGA, ('montantInsufisantMGA') : montantInsufisantMGA], FailureHandling.CONTINUE_ON_FAILURE)

'Finalize the sale'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Finaliser la vente'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'Write the bill'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Editer facture'), [:], FailureHandling.CONTINUE_ON_FAILURE)

