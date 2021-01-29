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

'Cliquer sur le bouton Oui'
WebUI.click(findTestObject('Popin de Notification/Bouton Oui'))

'Vérifier l apparition du popin Recherche informations client'
WebUI.waitForElementPresent(findTestObject('Popin Recherche informations client/Popin Recherche informations client'), 0)

'Vérifier que le bouton Imprimer Facture n est pas cliquable'
WebUI.verifyElementNotClickable(findTestObject('Popin Recherche informations client/Bouton Imprimer Facture'))

'Saisir les infos du client'
WebUI.sendKeys(findTestObject('Popin Recherche informations client/Champ Nom'), 'RAVELOMANANTSOA')

WebUI.sendKeys(findTestObject('Popin Recherche informations client/Champ Prenom'), 'Samandari')

WebUI.sendKeys(findTestObject('Popin Recherche informations client/Champ Telephone'), '034 00 308 16')

WebUI.verifyElementAttributeValue(findTestObject('Popin Recherche informations client/Champ E-Mail'), 'value', 'samandari.ravelomanantsoa@telma.mg',
	0)

WebUI.sendKeys(findTestObject('Popin Recherche informations client/Champ Adresse'), 'Galaxy')

'Vérifier que le bouton Imprimer Facture devient cliquable'
WebUI.verifyElementClickable(findTestObject('Popin Recherche informations client/Bouton Imprimer Facture'))

'Cliquer sur le bouton Imprimer Facture'
WebUI.click(findTestObject('Popin Recherche informations client/Bouton Imprimer Facture'))
