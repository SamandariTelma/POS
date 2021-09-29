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

'Je Prends le numéro de série dans le champ numéro de série pour chaque article à receptionner'
WebUI.click(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Bouton loupe'))

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin liste des numéros/id produit'), 
    3)

String imeiProduit = WebUI.getText(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin liste des numéros/id produit'), 
    FailureHandling.CONTINUE_ON_FAILURE)

println('IMEI :' + imeiProduit)

GlobalVariable.imei = imeiProduit

WebUI.click(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin liste des numéros/Bouton retour'))

'Je clique sur le nuage dans action pour réceptionner'
WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Bouton Action telecharger'), 
    3)

'Deux choix de réception apparaissent, \r\nPar carton : case mode saisie si numéro de carton à saisisser / mode saisie non coché => numéro carton avec liste déroulante\r\nPar produit : champ pour remplir l\'IMEI à recéptionner + case avarié si l\'article réceptionné est avarie et choix - ou + (pour ajouter ou supprimer un numéro de série)\r\n+ case pour import fichier'
WebUI.click(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Bouton Action telecharger'))

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Formulaire de saisie - IMEI/Checkbox Mode saisie'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Formulaire de saisie - IMEI/Checkbox Avarié - Par carton'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Formulaire de saisie - IMEI/Checkbox Avarié - Par produit'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Formulaire de saisie - IMEI/Checkbox Importer fichier'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Formulaire de saisie - IMEI/Liste deroulante Numéro carton'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Formulaire de saisie - IMEI/Champ numero imei'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Formulaire de saisie - IMEI/Bouton plus- Par carton'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Formulaire de saisie - IMEI/Bouton moins - Par carton'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Formulaire de saisie - IMEI/Bouton plus- Par produit'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Formulaire de saisie - IMEI/Bouton moins - Par produit'), 
    3)

WebUI.verifyElementNotChecked(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Formulaire de saisie - IMEI/Checkbox Mode saisie'), 
    3)

WebUI.verifyElementNotChecked(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Formulaire de saisie - IMEI/Checkbox Avarié - Par carton'), 
    3)

WebUI.verifyElementNotChecked(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Formulaire de saisie - IMEI/Checkbox Avarié - Par produit'), 
    3)

WebUI.verifyElementNotChecked(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Formulaire de saisie - IMEI/Checkbox Importer fichier'), 
    3)

WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Bouton Retour'))

WebUI.verifyElementNotClickable(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Bouton suivant'))

'Je saisis un numero de serie qui n\'existe pas'
WebUI.sendKeys(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Formulaire de saisie - IMEI/Champ numero imei'), 
    '100084486700123')

'Vérifier que le bouton suivant devient cliquable'
WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Bouton suivant'))

'Je clique sur le bouton suivant'
WebUI.click(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Bouton suivant'))

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Formulaire de saisie - IMEI/Bouton cloche rouge'), 
    10)

WebUI.verifyElementNotClickable(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Bouton suivant'))

WebUI.clearText(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Formulaire de saisie - IMEI/Champ numero imei'))

'Saisir l\'IMEI exacte'
WebUI.sendKeys(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Formulaire de saisie - IMEI/Champ numero imei'), 
    imeiProduit)

