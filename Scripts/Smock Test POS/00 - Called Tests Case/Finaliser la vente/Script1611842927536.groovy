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

'Cliquer sur le bouton Terminer'
WebUI.waitForElementPresent(findTestObject('Page Resume de la transaction/Bouton Terminer'), 3)

WebUI.delay(2)

WebUI.click(findTestObject('Page Resume de la transaction/Bouton Terminer'))

'Vérifier la présence du popin Notification '
WebUI.waitForElementPresent(findTestObject('Popin de Notification/Popin Notification'), 3)

'Choisir Particulier puis cliquer '
WebUI.click(findTestObject('Popin de Notification/Bouton radio Particulier'))

'Cocher Par Email'
WebUI.click(findTestObject('Popin de Notification/Checkbox Par Email'))

'Vérifier l apparition du champ Email'
WebUI.waitForElementPresent(findTestObject('Popin de Notification/Champ Email'), 3)

'Saisir l email du client puis valider'
WebUI.sendKeys(findTestObject('Popin de Notification/Champ Email'), 'samandari.ravelomanantsoa@telma.mg')

WebUI.waitForElementClickable(findTestObject('Popin de Notification/Bouton Terminer'), 3)

WebUI.click(findTestObject('Popin de Notification/Bouton Terminer'))

'Vérifier la présence du popin Finalisaton de la transaction'
WebUI.waitForElementPresent(findTestObject('Popin Finalisation de la transaction/Popin Finalisation de la transaction'), 
    3)

'Récupérer la référence de la transaction'
String info = WebUI.getText(findTestObject('Popin Finalisation de la transaction/Reference de la transaction'))

//Récupérer seulement la reference de la transaction
GlobalVariable.referenceDeTransaction = (info[(info.lastIndexOf('transaction') + 13..info.lastIndexOf('est') - 2)])

System.out.println('ref transac = ' + GlobalVariable.referenceDeTransaction)

