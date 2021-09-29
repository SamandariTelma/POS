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

'Je clique sur le bouton Sortie de TR'
WebUI.click(findTestObject('Pages Gestion de stock/Page Sortie de stock/Bouton Sortie de transfert'))

'Affichage de la page recherche liste des transferts avec les champs : - Référence\r\n- dépôt d\'origine\r\n- dépôt destination\r\n- code sage\r\n- code article\r\n-  statut'
WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste TR (Reception)/Titre page'), 15, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Champ code sage'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Champ code article'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Champ réference'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Liste déroulante depot d origine'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Liste déroulante depot de destination'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Liste déroulante statut'), 
    3)

