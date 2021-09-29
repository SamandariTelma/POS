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

WebUI.callTestCase(findTestCase('Smock Test POS/13 - Gestion de stock/Sortie et reception de transfert/00-Called Test case/Rechercher le Transfert envoyé'), 
    [('referenceTR') : GlobalVariable.referenceTR], FailureHandling.CONTINUE_ON_FAILURE)

String referenceTR = "$referenceTR"

'Je clique sur "X" (bouton d\'annulation) dans la colonne "Actions" pour annuler le transfert'
WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste TR (Reception)/Tableau de résultat/Bouton annuler - 1ere ligne'))

'Je clique sur le bouton confirmer du popin'
WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin annulation TR/Titre popin annulation TR'), 
    5)

WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin annulation TR/Bouton confirmer'))

WebUI.delay(0.500)

'Je vérifie que le TR est disparu du résultat du tableau\r\n'
WebUI.verifyElementNotPresent(findTestObject('Pages Gestion de stock/Page Recherche liste TR (Reception)/Tableau de résultat/Réference TR généré - 1ere ligne'), 
    3, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Smock Test POS/13 - Gestion de stock/Sortie et reception de transfert/03 - Vérification statut article'), 
    [('statutAttendu') : 'DISPO', ('imei') : GlobalVariable.imei, ('depot') : GlobalVariable.depotEnvoyeur], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Smock Test POS/13 - Gestion de stock/Sortie et reception de transfert/00-Called Test case/Rechercher le Transfert annulé'), 
    [('referenceTR') : GlobalVariable.referenceTR], FailureHandling.CONTINUE_ON_FAILURE)

