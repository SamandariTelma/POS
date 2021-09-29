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

String dateEnvoi = "$dateEnvoi"

String referenceAR = "$referenceAR"

String nomTransporteur = "$nomTransporteur"

'Affichage : "Détails transport" avec les champs date d\'envoi, transporteur, référence AR, pièce justificative, numéro de voiture, nom du chauffeur détaillé lors de l\'envoie du transfert dans sortie TR'
WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-detait transporteur/Date d envoi'), 
    3)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-detait transporteur/Date d envoi'), 
    dateEnvoi)

'Affichage : "Détails transport" avec les champs date d\'envoi, transporteur, référence AR, pièce justificative, numéro de voiture, nom du chauffeur détaillé lors de l\'envoie du transfert dans sortie TR'
WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-detait transporteur/Reference AR'), 
    referenceAR)

'Affichage : "Détails transport" avec les champs date d\'envoi, transporteur, référence AR, pièce justificative, numéro de voiture, nom du chauffeur détaillé lors de l\'envoie du transfert dans sortie TR'
WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-detait transporteur/Transporteur'), 
    nomTransporteur)

