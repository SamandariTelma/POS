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
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

/*
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Connexion a POS'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'En tant que User connecté sur la preprod, je Clique sur gestion de stock > Sous-Menus SORTIE'
WebUI.waitForElementPresent(findTestObject('Menu POS-/Menu Gestion de stock/Menu Gestion de stock'), 30, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Menu POS-/Menu Gestion de stock/Menu Gestion de stock'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Menu POS-/Menu Gestion de stock/Sous menu sortie'), 5)

WebUI.click(findTestObject('Menu POS-/Menu Gestion de stock/Sous menu sortie'), FailureHandling.CONTINUE_ON_FAILURE)

'Affichage de la page choix de sortie de stock avec les boutons sortie transfert, sortie exceptionnelle, ordre de rapatriement'
WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page Sortie de stock/Bouton Sortie de transfert'), 30, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Sortie de stock/Bouton Sortie de transfert'), 0, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Sortie de stock/Bouton Sortie exeptionnelle'), 0)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Sortie de stock/Bouton Ordre de rapatriement'), 0)

WebUI.delay(0.500)

'Je clique sur Sortie Transfert '
WebUI.click(findTestObject('Pages Gestion de stock/Page Sortie de stock/Bouton Sortie de transfert'))

*/
WebUI.switchToWindowIndex(0)

'Je reviens dans le champ "Recherche liste des transferts"'
String referenceTR = WebUI.getText(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/File d ariane reference TR'))

WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/File d ariane Liste de TR'))

'Affichage pop-in : "Votre transfert sera annulé"'
WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Titre page'), 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Réference TR généré - 1ere ligne'), 
    3, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Réference TR généré - 1ere ligne'), 
    referenceTR, FailureHandling.STOP_ON_FAILURE)

'Vérifier que le statut du TR est generé et que seul les boutons action adequate sont activés'
WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Statut TR - 1ere ligne'), 
    'Généré', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton annuler - 1ere ligne'))

WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton envoyer - 1ere ligne'))

WebUI.verifyElementNotClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton livrer - 1ere ligne'))

WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton visualisier - 1ere ligne'))

WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton telecharger- 1ere ligne'))

'Je clique sur "X" (bouton d\'annulation) dans la colonne "Actions" pour annuler le transfert'
WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton annuler - 1ere ligne'))

'Je clique sur le bouton confirmer du popin'
WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin annulation TR/Titre popin annulation TR'), 
    5)

WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin annulation TR/Bouton confirmer'))

WebUI.delay(0.500)

'Je vérifie : - Le statut du référence qui devient "Annulé"\r\n- Bouton cliquable sur Action : Visualiser, Télécharger\r\n'
WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Réference TR généré - 1ere ligne'), 
    referenceTR, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Statut TR - 1ere ligne'), 
    'Annulé', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton annuler - 1ere ligne'))

WebUI.verifyElementNotClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton envoyer - 1ere ligne'))

WebUI.verifyElementNotClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton livrer - 1ere ligne'))

WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton visualisier - 1ere ligne'))

WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton telecharger- 1ere ligne'))

WebUI.callTestCase(findTestCase('Smock Test POS/13 - Gestion de stock/Sortie et reception de transfert/03 - Vérification statut article'), 
    [('statutAttendu') : 'DISPO', ('imei') : GlobalVariable.imei, ('depot') : GlobalVariable.depotEnvoyeur], FailureHandling.CONTINUE_ON_FAILURE)

