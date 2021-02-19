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
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.Keys as Keys

//Declaration du montant du Bundle
int montantAPayer = 5794423

String montantAPayerMGA = '5 794 423 MGA'

String montantInsufisantMGA = '5 794 422 MGA'

WebUI.deleteAllCookies()

WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Connexion a POS'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Nouveau Panier'), 12)

WebUI.click(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Nouveau Panier'))

WebUI.waitForElementPresent(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Paiement Facture'), 3)

WebUI.delay(6)

WebUI.click(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Paiement Facture'))

WebUI.waitForElementPresent(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Champ numero facture'), 3)

WebUI.verifyElementNotClickable(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Bouton Recherche'))

WebUI.sendKeys(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Champ numero facture'), '1234')

WebUI.verifyElementClickable(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Bouton Recherche'))

WebUI.click(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Bouton Recherche'))

WebUI.waitForAlert(3)

WebUI.verifyAlertPresent(3)

String alertMessage = WebUI.getAlertText()

WebUI.verifyMatch(alertMessage, 'Element introuvable ou erreur lors de la recherche', false)

WebUI.acceptAlert()

WebUI.clearText(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Champ numero facture'))

WebUI.sendKeys(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Champ numero facture'), GlobalVariable.numeroFacture)

WebUI.click(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Bouton Recherche'))

WebUI.verifyElementText(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Resultat Numero Facture'), GlobalVariable.numeroFacture)

String montant = WebUI.getText(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Resultat Reste a payer'))

//Récuperer le montant reste à payer dans le résultat
GlobalVariable.resteAPayer = montant.substring(0, montant.indexOf('MGA') - 1)

System.out.println(GlobalVariable.resteAPayer)

WebUI.clearText(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Champ Montant a payer'))

WebUI.sendKeys(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Champ Montant a payer'), '1')

WebUI.click(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Checkbox'))

WebUI.click(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Bouton Ajouter au panier'))

WebUI.waitForElementPresent(findTestObject('Page Vente POS-/Produit ajouter en Panier en cours'), 3)

verifierPanierEnCours()

WebUI.click(findTestObject('Page Vente POS-/Bouton corbeille'))

WebUI.clearText(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Champ Montant a payer'))

WebUI.sendKeys(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Champ Montant a payer'), GlobalVariable.resteAPayer + 
    '01' //Méthode pour vérifier si le produit est ajouté en panier en cours
    )

WebUI.click(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Bouton Ajouter au panier'))

WebUI.waitForElementPresent(findTestObject('Page Vente POS-/Produit ajouter en Panier en cours'), 3)

verifierPanierEnCours()

WebUI.click(findTestObject('Page Vente POS-/Bouton corbeille'))

WebUI.clearText(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Champ Montant a payer'))

WebUI.sendKeys(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Champ Montant a payer'), GlobalVariable.resteAPayer + 
    '00' //Méthode pour vérifier si le produit est ajouté en panier en cours
    )

WebUI.click(findTestObject('Page Vente POS-/Pour Recherche Facture Uniquement/Bouton Ajouter au panier'))

WebUI.waitForElementPresent(findTestObject('Page Vente POS-/Produit ajouter en Panier en cours'), 3)

verifierPanierEnCours()

WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Payer en espèce'), [('montantAPayer') : montantAPayer
        , ('montantAPayerMGA') : montantAPayerMGA, ('montantInsufisantMGA') : montantInsufisantMGA], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Finaliser la vente'), [:], FailureHandling.CONTINUE_ON_FAILURE)

void verifierPanierEnCours() {
    String designation = WebUI.getText(findTestObject('Page Vente POS-/Produit ajouter en Panier en cours'))

    if (designation.contains(GlobalVariable.numeroFacture)) {
        WebUI.verifyMatch('numero de facture existant', 'numero de facture existant', false)
    } else {
        WebUI.verifyMatch('numero de facture existant', 'numero de facture inexistant', false)
    }
}

