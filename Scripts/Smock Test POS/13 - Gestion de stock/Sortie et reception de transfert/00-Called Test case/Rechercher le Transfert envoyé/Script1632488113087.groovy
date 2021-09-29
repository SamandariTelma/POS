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

String referenceTR = "$referenceTR"

//String referenceTR = 'TRADV_SHOP_TEST24092021115659'
GlobalVariable.referenceTR = referenceTR

String statutARecherche = 'Envoyé'

WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Connexion a POS'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Smock Test POS/13 - Gestion de stock/Sortie et reception de transfert/00-Called Test case/Acceder a la page choix entree stock'), 
    [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Smock Test POS/13 - Gestion de stock/Sortie et reception de transfert/00-Called Test case/Acceder à la page liste de résultat de reception'), 
    [:], FailureHandling.CONTINUE_ON_FAILURE)

'Je recherche le réference du TR que je viens d\'envoyer'
WebUI.sendKeys(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Champ réference'), 
    referenceTR)

WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Bouton Rechercher'))

'Affichage du résultat correspondant avec le statut envoyé'
WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Réference TR généré - 1ere ligne'), 
    3)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Recherche liste TR (Reception)/Tableau de résultat/Réference TR généré - 1ere ligne'), 
    referenceTR)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Recherche liste TR (Reception)/Tableau de résultat/Statut TR - 1ere ligne'), 
    statutARecherche)

