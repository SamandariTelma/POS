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

System.out.println('Dans New Test Case ' + GlobalVariable.numeroArticle)

System.out.println('Dans New Test Case ' + GlobalVariable.montantArticle)

'Se connecter a POS'
WebUI.callTestCase(findTestCase('Demo/Connexion a POS'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Nouveau Panier'), 0)

'Cliquer sur le bouton Nouveau Panier'
WebUI.click(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Nouveau Panier'))

'Cliquer sur le bouton Vente produit'
WebUI.waitForElementPresent(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Vente produit'), 0)

WebUI.click(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Vente produit'))

WebUI.delay(8)

'Dans le champ ICCID Saisir un numéro d article qui n existe pas'
WebUI.waitForElementPresent(findTestObject('Page Vente POS-/Champ de saisie numero Imei ICCID EAN SN'), 0)

WebUI.sendKeys(findTestObject('Page Vente POS-/Champ de saisie numero Imei ICCID EAN SN'), '6654482048692')

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer sur le bouton de recherche '
WebUI.click(findTestObject('Page Vente POS-/Bouton Loupe'))

WebUI.verifyElementText(findTestObject('Page Vente POS-/Tooltip info article non reference'), 'L\'article n\'a pas encore été référencé')

WebUI.clearText(findTestObject('Page Vente POS-/Champ de saisie numero Imei ICCID EAN SN'), FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer sur le bouton de recherche '
WebUI.click(findTestObject('Page Vente POS-/Bouton Loupe'))

'Saisir le numero de l article dans le champ ICCID'
WebUI.sendKeys(findTestObject('Page Vente POS-/Champ de saisie numero Imei ICCID EAN SN'), GlobalVariable.numeroArticle)

'Cliquer sur le bouton de recherche '
WebUI.click(findTestObject('Page Vente POS-/Bouton Loupe'))

WebUI.delay(2)

'Cliquer sur le bouton Ajouter'
WebUI.click(findTestObject('Page Vente POS-/Bouton Ajouter'))

WebUI.waitForElementPresent(findTestObject('Page Vente POS-/Numero de serie ajouter en Panier en cours'), 0)

System.out.println(WebUI.getText(findTestObject('Page Vente POS-/Numero de serie ajouter en Panier en cours')))

'Vérifier que le produit est bien ajouter dans le panier en cours'
WebUI.verifyElementText(findTestObject('Page Vente POS-/Numero de serie ajouter en Panier en cours'), ('(' + GlobalVariable.numeroArticle) + 
    ')')

'Cliquer sur le bouton Payer'
WebUI.waitForElementPresent(findTestObject('Page Vente POS-/Bouton Payer'), 0)

WebUI.click(findTestObject('Page Vente POS-/Bouton Payer'))

'Vérifier que le bouton Ajouter Paiement n est pas cliquable'
WebUI.verifyElementNotClickable(findTestObject('Page Encaissement-/Bouton Ajouter Paiement'))

//Convertir le montant récuperer en numérique
'Saisir un montant inférieur au montant de l article'
String prix = GlobalVariable.montantArticle

prix = prix.replaceAll('\\s', '')

int prixNum = prix.toInteger()

WebUI.sendKeys(findTestObject('Page Encaissement-/Champ Montant'), String.valueOf(prixNum - 1))

'Vérifier que le bouton Ajouter devient cliquable'
WebUI.verifyElementClickable(findTestObject('Page Encaissement-/Bouton Ajouter Paiement'))

'Cliquer sur le bouton Ajouter Paiement'
WebUI.click(findTestObject('Page Encaissement-/Bouton Ajouter Paiement'))

'Vérifier que le bouton Encaisser est non cliquable'
WebUI.verifyElementNotClickable(findTestObject('Page Encaissement-/Bouton Encaisser'))

'Ajouter un montant qui permet d obtenir le montant total'
WebUI.sendKeys(findTestObject('Page Encaissement-/Champ Montant'), '1')

WebUI.click(findTestObject('Page Encaissement-/Bouton Ajouter Paiement'))

/*
'Vérifier que le bouton Encaisser devient cliquable'
WebUI.verifyElementClickable(findTestObject('Page Encaissement-/Bouton Encaisser'))

WebUI.click(findTestObject('Page Encaissement-/Bouton Encaisser'))

'Vérifier l info de la transaction'
String info = WebUI.getText(findTestObject('Page Resume de la transaction/Info de la transaction'))

//Recuperer la référence de transaction
GlobalVariable.referenceDeTransaction = (info[(info.lastIndexOf('TRANSACTION') + 12..info.lastIndexOf('DU') - 2)])

System.out.println('Dans achat produit: ' + GlobalVariable.referenceDeTransaction)

'Cliquer sur le bouton Terminer'
WebUI.click(findTestObject('Page Resume de la transaction/Bouton Terminer'))

WebUI.delay(1)

WebUI.click(findTestObject('Popin de Notification/Bouton radio Particulier'))

WebUI.delay(1)

WebUI.click(findTestObject('Popin de Notification/Bouton Terminer'))

WebUI.delay(1)

WebUI.click(findTestObject('Popin de Notification/Bouton Non'))
*/
WebUI.delay(70000)

