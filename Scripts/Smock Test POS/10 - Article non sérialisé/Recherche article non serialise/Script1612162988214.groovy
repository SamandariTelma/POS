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

String depot_a_rechercher

String code_article_a_rechercher

String code_sage_a_rechercher

String libelle_a_rechercher

String statut_a_rechercher

'Se connecter à POS'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Connexion a POS'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Menu POS-/Menu Parametrage'), 3)

'Cliquer sur le menu Paramétrage'
WebUI.click(findTestObject('Menu POS-/Menu Parametrage'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Menu POS-/Sous menu Article non sérialisé'), 3)

'Cliquer le sous menu Article non sérialisé'
WebUI.click(findTestObject('Menu POS-/Sous menu Article non sérialisé'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(2)

WebUI.waitForElementPresent(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Champ Depot'), 
    3)

'Cliquer sur le champ Choisir votre Dépôt'
WebUI.click(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Champ Depot'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Option SHOP TEST DSI'), 
    3)

'Cliquer sur l option SHOP TEST DSI'
WebUI.click(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Option SHOP TEST DSI'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(6)

WebUI.waitForElementVisible(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Champ Statut'), 
    0)

'Cliquer le champ Choisissez un statut'
WebUI.click(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Champ Statut'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Option statut DISPO'), 
    3)

'Choisir l option DISPO'
WebUI.click(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Option statut DISPO'), FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des articles non sérialisé/Bouton Rechercher'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(0.500)
//Récupération des résultats pour la colonne Dépôt
'Vérifier que la colonne dépôt contient uniquement le résultat SHOP TEST DSI'
List<WebElement> colonne_Depot = WebUiCommonHelper.findWebElements(findTestObject('Page Gestion des articles non sérialisé/Résultat Liste/Colonne Depot'), 
    6)

for (def depot : colonne_Depot) {
    System.out.println(depot.getText())

    WebUI.verifyMatch(depot.getText(), 'SHOP TEST DSI', false)
}

//Récupération des résultats pour la colonne Statut
'Vérifier que la colonne statut contient uniquement le résultat DISPO'
List<WebElement> colonne_Statut = WebUiCommonHelper.findWebElements(findTestObject('Page Gestion des articles non sérialisé/Résultat Liste/Colonne Statut'), 
    6)

for (def statut : colonne_Statut) {
    System.out.println(statut.getText())

    WebUI.verifyMatch(statut.getText(), 'DISPO', false)
}

'Recupérer les infos à rechercher par la suite'
depot_a_rechercher = WebUI.getText(findTestObject('Page Gestion des articles non sérialisé/Résultat Liste/Depot 1ere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

code_article_a_rechercher = WebUI.getText(findTestObject('Page Gestion des articles non sérialisé/Résultat Liste/Code article 1ere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

code_sage_a_rechercher = WebUI.getText(findTestObject('Page Gestion des articles non sérialisé/Résultat Liste/Code SAGE 1ere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

libelle_a_rechercher = WebUI.getText(findTestObject('Page Gestion des articles non sérialisé/Résultat Liste/Libelle 1ere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

statut_a_rechercher = WebUI.getText(findTestObject('Page Gestion des articles non sérialisé/Résultat Liste/Statut 1ere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer le bouton Réinitialiser'
WebUI.click(findTestObject('Page Gestion des articles non sérialisé/Bouton Reinitialiser'))

'Remplir les champs par des infos incorrectes'
WebUI.sendKeys(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Champ Article'), '849465')

WebUI.sendKeys(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Champ Code SAGE'), '849465')

WebUI.click(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Champ Depot'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Option SHOP TEST DSI'), 
    3)

WebUI.click(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Option SHOP TEST DSI'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Champ Statut'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Option statut DISPO'), 
    3)

WebUI.click(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Option statut DISPO'), FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des articles non sérialisé/Bouton Rechercher'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(0.500)

'Vérifier q aucun résultat s affiche sur la liste'
WebUI.verifyElementNotPresent(findTestObject('Page Gestion des articles non sérialisé/Résultat Liste/Depot 1ere ligne'), 
    3)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des articles non sérialisé/Résultat Liste/Code article 1ere ligne'), 
    3)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des articles non sérialisé/Résultat Liste/Code SAGE 1ere ligne'), 
    3)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des articles non sérialisé/Résultat Liste/Libelle 1ere ligne'), 
    3)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des articles non sérialisé/Résultat Liste/Statut 1ere ligne'), 
    3)

'Cliquer sur le bouton Réinitialiser'
WebUI.click(findTestObject('Page Gestion des articles non sérialisé/Bouton Reinitialiser'))

'Vérifier que tous les champs sont remis à leurs états initial'
WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Champ Article'), 
    'value', '', 0)

WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Champ Code SAGE'), 
    'value', '', 0)

WebUI.verifyElementText(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Champ Depot'), 'Choisissez votre Dépôt')

WebUI.verifyElementText(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Champ Statut'), 'Tous')

List<WebElement> colonne_Statut2 = WebUiCommonHelper.findWebElements(findTestObject('Page Gestion des articles non sérialisé/Résultat Liste/Colonne Statut'), 
    6)

'Vérifier que la liste affiche tous les résultats '
WebUI.verifyGreaterThan(colonne_Statut2.size, 1)

'Saisir un code article valide'
WebUI.sendKeys(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Champ Article'), code_article_a_rechercher)

'Saisir un code sage article valide'
WebUI.sendKeys(findTestObject('Page Gestion des articles non sérialisé/Formulaire Recherche/Champ Code SAGE'), code_sage_a_rechercher)

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des articles non sérialisé/Bouton Rechercher'))

WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Page Gestion des articles non sérialisé/Résultat Liste/Depot 1ere ligne'), 0)

'Vérifier que les résultats adéquats au champ recherché apparaissent dans la liste article non sérialisé'
WebUI.verifyElementText(findTestObject('Page Gestion des articles non sérialisé/Résultat Liste/Depot 1ere ligne'), depot_a_rechercher)

WebUI.verifyElementText(findTestObject('Page Gestion des articles non sérialisé/Résultat Liste/Code article 1ere ligne'), 
    code_article_a_rechercher)

WebUI.verifyElementText(findTestObject('Page Gestion des articles non sérialisé/Résultat Liste/Code SAGE 1ere ligne'), code_sage_a_rechercher)

WebUI.verifyElementText(findTestObject('Page Gestion des articles non sérialisé/Résultat Liste/Libelle 1ere ligne'), libelle_a_rechercher)

WebUI.verifyElementText(findTestObject('Page Gestion des articles non sérialisé/Résultat Liste/Colonne Statut'), statut_a_rechercher)

