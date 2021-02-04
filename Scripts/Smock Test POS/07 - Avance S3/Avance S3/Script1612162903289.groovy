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

int montantAPayer = 1000

String montantAPayerMGA = '1 000 MGA'

String montantInsufisantMGA = '999 MGA' //montant a payer -1

WebUI.deleteAllCookies()

WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Connexion a POS'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer sur nouveau panier'
WebUI.click(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Nouveau Panier'))

'Cliquer sur Avance S3\r\n'
WebUI.waitForElementPresent(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Avance S3'), 0)

'Cliquer sur vente Avance S3\r\n'
WebUI.scrollToElement(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Avance S3'), 0)

WebUI.click(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Avance S3'))

'Atterir sur la page d\'effectuation de vente avec le numéro de l\'id panier et le détails de l\'article. Exemple :\r\n\nLibellé : NET ONE DAY\r\n\nCode : Bundle_00023\r\n\nCode sage : MOBBUNDLE_00023\n"\r\n'
WebUI.waitForElementPresent(findTestObject('Page Vente POS-/Champ Libelle'), 0)

WebUI.verifyElementAttributeValue(findTestObject('Page Vente POS-/Champ Libelle'), 'value', 'Paiement avance S3', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementAttributeValue(findTestObject('Page Vente POS-/Champ Code'), 'value', 'AVANCE_MOBILE_S3', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementAttributeValue(findTestObject('Page Vente POS-/Champ Code Sage'), 'value', 'AVANCE_MOBILE_S3', 0, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(8)

'Vérifier que le bouton Ajouter n\'est pas cliquable'
WebUI.verifyElementNotClickable(findTestObject('Page Vente POS-/Bouton Ajouter'))

'Saisir la référence de la transaction '
WebUI.sendKeys(findTestObject('Page Vente POS-/Pour Avance S3/Champ Prix'), '1000,00')

'Vérifier que le bouton Ajouter devient cliquable'
WebUI.verifyElementClickable(findTestObject('Page Vente POS-/Bouton Ajouter'))

'Cliquer sur le bouton Ajouter'
WebUI.click(findTestObject('Page Vente POS-/Bouton Ajouter'))

'Vérifier que l article est ajouter dans le pannier en cours'
WebUI.waitForElementPresent(findTestObject('Page Vente POS-/Produit ajouter en Panier en cours'), 3)

'Vérifier que l article est ajouter dans le pannier en cours'
WebUI.verifyElementText(findTestObject('Page Vente POS-/Produit ajouter en Panier en cours'), 'Paiement avance S3\nAVANCE_MOBILE_S3')

'Effectuer le paiement'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Payer en espèce'), [('montantAPayer') : montantAPayer
        , ('montantAPayerMGA') : montantAPayerMGA, ('montantInsufisantMGA') : montantInsufisantMGA], FailureHandling.CONTINUE_ON_FAILURE)

'Finaliser la vente'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Finaliser la vente'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'Editer la facture'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Editer facture'), [:], FailureHandling.CONTINUE_ON_FAILURE)

