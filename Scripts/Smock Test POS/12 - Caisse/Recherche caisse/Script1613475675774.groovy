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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

'Se connecter à POS'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Connexion a POS'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Menu POS-/Menu Parametrage'), 10)

'Cliquer sur le menu Paramétrage'
WebUI.click(findTestObject('Menu POS-/Menu Parametrage'))

WebUI.waitForElementPresent(findTestObject('Menu POS-/Sous menu Caisses'), 3)

'Cliquer sur le sous menu Caisses'
WebUI.click(findTestObject('Menu POS-/Sous menu Caisses'))

WebUI.delay(1)

WebUI.waitForElementPresent(findTestObject('Page Gestion des caisses/Formulaire de recherche/Champ Reference'), 3)

'Remplir les champs par des valeurs incorrectes'
WebUI.sendKeys(findTestObject('Page Gestion des caisses/Formulaire de recherche/Champ Reference'), 'blabla')

WebUI.sendKeys(findTestObject('Page Gestion des caisses/Formulaire de recherche/Champ Libelle'), 'blabla')

WebUI.click(findTestObject('Page Gestion des caisses/Formulaire de recherche/Champ Shop associe'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des caisses/Formulaire de recherche/Option Shop test DSI'), 0)

WebUI.click(findTestObject('Page Gestion des caisses/Formulaire de recherche/Option Shop test DSI'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(0.500)

WebUI.click(findTestObject('Page Gestion des caisses/Formulaire de recherche/Champ Etat Actif'))

WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Page Gestion des caisses/Formulaire de recherche/Option Non'), 3)

WebUI.click(findTestObject('Page Gestion des caisses/Formulaire de recherche/Option Non'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(0.500)

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des caisses/Formulaire de recherche/Bouton Recherche'))

WebUI.delay(1)

'Vérifieur qu aucun résultat s affiche'
WebUI.verifyElementNotPresent(findTestObject('Page Gestion des caisses/Tableau de resultat/Reference 1ere ligne'), 3)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des caisses/Tableau de resultat/Libelle 1ere ligne'), 3)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des caisses/Tableau de resultat/Etat Actif 1ere ligne'), 3)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des caisses/Tableau de resultat/Shop 1ere ligne'), 3)

'Cliquer sur le bouton Réinitialiser'
WebUI.click(findTestObject('Page Gestion des caisses/Formulaire de recherche/Reinitialiser'))

'Vérifier que les valeurs des champs sont réinitialiser avec leur valeur par défaut'
WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des caisses/Formulaire de recherche/Champ Reference'), 'value', 
    '', 3)

WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des caisses/Formulaire de recherche/Champ Libelle'), 'value', 
    '', 3)

WebUI.verifyElementText(findTestObject('Page Gestion des caisses/Formulaire de recherche/Champ Shop associe'), 'Shop associé')

WebUI.verifyElementText(findTestObject('Page Gestion des caisses/Formulaire de recherche/Champ Etat Actif'), 'Oui')

'Récuperer le résultat à recherher '
String reference = WebUI.getText(findTestObject('Page Gestion des caisses/Tableau de resultat/Reference 1ere ligne'))

String libelle = WebUI.getText(findTestObject('Page Gestion des caisses/Tableau de resultat/Libelle 1ere ligne'))

String etat = WebUI.getText(findTestObject('Page Gestion des caisses/Tableau de resultat/Etat Actif 1ere ligne'))

String shop = WebUI.getText(findTestObject('Page Gestion des caisses/Tableau de resultat/Shop 1ere ligne'))

'Saisir la référence caisse exacte'
WebUI.sendKeys(findTestObject('Page Gestion des caisses/Formulaire de recherche/Champ Reference'), reference)

'Saisir le libellé caisse exacte'
WebUI.sendKeys(findTestObject('Page Gestion des caisses/Formulaire de recherche/Champ Libelle'), libelle)

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des caisses/Formulaire de recherche/Bouton Recherche'))

WebUI.delay(1)

WebUI.waitForElementPresent(findTestObject('Page Gestion des caisses/Tableau de resultat/Reference 1ere ligne'), 10)

'Vérifier que les résultats adéquats au champ recherché apparaissent dans la liste caisses'
WebUI.verifyElementText(findTestObject('Page Gestion des caisses/Tableau de resultat/Reference 1ere ligne'), reference)

WebUI.verifyElementText(findTestObject('Page Gestion des caisses/Tableau de resultat/Libelle 1ere ligne'), libelle)

WebUI.verifyElementText(findTestObject('Page Gestion des caisses/Tableau de resultat/Etat Actif 1ere ligne'), etat)

WebUI.verifyElementText(findTestObject('Page Gestion des caisses/Tableau de resultat/Shop 1ere ligne'), shop)

'Cliquer sur le bouton Réinitialiser'
WebUI.click(findTestObject('Page Gestion des caisses/Formulaire de recherche/Reinitialiser'))

'Cliquer sur le champ Shop associé'
WebUI.click(findTestObject('Page Gestion des caisses/Formulaire de recherche/Champ Shop associe'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des caisses/Formulaire de recherche/Option Shop test DSI'), 3)

'Choisir l option Shop test DSI'
WebUI.click(findTestObject('Page Gestion des caisses/Formulaire de recherche/Option Shop test DSI'), FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des caisses/Formulaire de recherche/Bouton Recherche'))

WebUI.delay(1)

WebUI.waitForElementPresent(findTestObject('Page Gestion des caisses/Tableau de resultat/Reference 1ere ligne'), 10)

List<WebElement> colonne_Shop = WebUiCommonHelper.findWebElements(findTestObject('Page Gestion des caisses/Tableau de resultat/Colonne Shop'), 
    6)

'Vérifier que les caisses attachées au shop apparaissent dans la liste caisses\r\n'
for (def nomShop : colonne_Shop) {
    System.out.println(nomShop.getText())

    WebUI.verifyMatch(nomShop.getText(), 'SHOP TEST DSI', false)
}

'Cliquer sur le bouton Réinitialiser'
WebUI.click(findTestObject('Page Gestion des caisses/Formulaire de recherche/Reinitialiser'), FailureHandling.CONTINUE_ON_FAILURE)

'Saisir une référence de caisse'
WebUI.sendKeys(findTestObject('Page Gestion des caisses/Formulaire de recherche/Champ Reference'), reference)

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des caisses/Formulaire de recherche/Bouton Recherche'))

WebUI.delay(1)

WebUI.waitForElementPresent(findTestObject('Page Gestion des caisses/Tableau de resultat/Reference 1ere ligne'), 10)

'Vérifier que le résultat apparait en fonction de la référence saisie'
WebUI.verifyElementText(findTestObject('Page Gestion des caisses/Tableau de resultat/Reference 1ere ligne'), reference)

WebUI.verifyElementText(findTestObject('Page Gestion des caisses/Tableau de resultat/Libelle 1ere ligne'), libelle)

WebUI.verifyElementText(findTestObject('Page Gestion des caisses/Tableau de resultat/Etat Actif 1ere ligne'), etat)

WebUI.verifyElementText(findTestObject('Page Gestion des caisses/Tableau de resultat/Shop 1ere ligne'), shop)

'Cliquer sur le bouton Réinitialiser'
WebUI.click(findTestObject('Page Gestion des caisses/Formulaire de recherche/Reinitialiser'))

WebUI.delay(1)

'Saisir un libellé de caisse'
WebUI.sendKeys(findTestObject('Page Gestion des caisses/Formulaire de recherche/Champ Libelle'), libelle)

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des caisses/Formulaire de recherche/Bouton Recherche'))

WebUI.delay(1)

WebUI.waitForElementPresent(findTestObject('Page Gestion des caisses/Tableau de resultat/Reference 1ere ligne'), 10)

'Vérifier que le résultat apparait en fonction du libellé saisi'
WebUI.verifyElementText(findTestObject('Page Gestion des caisses/Tableau de resultat/Reference 1ere ligne'), reference)

WebUI.verifyElementText(findTestObject('Page Gestion des caisses/Tableau de resultat/Libelle 1ere ligne'), libelle)

WebUI.verifyElementText(findTestObject('Page Gestion des caisses/Tableau de resultat/Etat Actif 1ere ligne'), etat)

WebUI.verifyElementText(findTestObject('Page Gestion des caisses/Tableau de resultat/Shop 1ere ligne'), shop)

'Effacer le libellé saisi'
WebUI.sendKeys(findTestObject('Page Gestion des caisses/Formulaire de recherche/Champ Libelle'), Keys.chord(Keys.CONTROL, 
        'a'))

WebUI.sendKeys(findTestObject('Page Gestion des caisses/Formulaire de recherche/Champ Libelle'), Keys.chord(Keys.BACK_SPACE))

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des caisses/Formulaire de recherche/Bouton Recherche'))

WebUI.delay(1)

WebUI.waitForElementPresent(findTestObject('Page Gestion des caisses/Tableau de resultat/Reference 1ere ligne'), 10)

'Vérifier que tous les résultats s affichent'
List<WebElement> colonne_Reference = WebUiCommonHelper.findWebElements(findTestObject('Page Gestion des caisses/Tableau de resultat/Colonne Reference'), 
    6)

WebUI.verifyGreaterThan(colonne_Reference.size(), 5)

