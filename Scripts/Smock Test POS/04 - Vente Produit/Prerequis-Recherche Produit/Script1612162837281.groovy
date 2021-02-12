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
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper

WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Connexion a POS'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer sur le menu Parametrage'
WebUI.waitForElementPresent(findTestObject('Menu POS-/Menu Parametrage'), 3)

WebUI.click(findTestObject('Menu POS-/Menu Parametrage'))

WebUI.waitForElementPresent(findTestObject('Menu POS-/Sous menu Numros de serie'), 3)

//RECHERCHE IMEI
'Cliquer sur le sous menu Numéros de série'
WebUI.click(findTestObject('Menu POS-/Sous menu Numros de serie'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Onglet ICCID'), 3)

'Cliquer sur le champ Statut dans IMEI'
WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Statut'), 3)

'Cliquer sur le champ Statut dans IMEI'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Statut'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox DISPO'), 3)

'Choisir DISPO'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox DISPO'))

WebUI.sendKeys(findTestObject('Element vide'), Keys.chord(Keys.ESCAPE))

'Cliquer sur le champ Dépôt'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Depot'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox SHOP TEST DSI'), 
    3)

'Choisir SHOP TEST DSI'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox SHOP TEST DSI'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('Element vide'), Keys.chord(Keys.ESCAPE))

WebUI.delay(6)

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Bouton Rechercher'))

WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/IMEI premiere ligne'), 
    3)

'Récupérer les résultat relatif a l IMEI'
GlobalVariable.numeroIMEI = WebUI.getText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/IMEI premiere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

GlobalVariable.prixIMEI = WebUI.getText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/Montant premiere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

GlobalVariable.libelleIMEI = WebUI.getText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/Libelle premiere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

GlobalVariable.codeSageIMEI = WebUI.getText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/Code Sage premiere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

GlobalVariable.codeArticleIMEI = WebUI.getText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/Code Article premiere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

System.out.println('IMEI: ' + GlobalVariable.numeroIMEI)

System.out.println('Code Article: ' + GlobalVariable.codeArticleIMEI)

System.out.println('Libellé: ' + GlobalVariable.libelleIMEI)

System.out.println('Code Sage: ' + GlobalVariable.codeSageIMEI)

System.out.println('Prix: ' + GlobalVariable.prixIMEI)

//RECHERCHE SN
'Choisir  l onglet SN'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Onglet SN'))

WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Statut'), 3)

'Cliquer sur le champ Statut dans SN'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Statut'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox DISPO'), 3)

'Choisir DISPO'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox DISPO'))

WebUI.sendKeys(findTestObject('Element vide'), Keys.chord(Keys.ESCAPE))

'Cliquer sur le champ Dépôt'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Depot'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox SHOP TEST DSI'), 
    3)

'Choisir SHOP TEST DSI'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox SHOP TEST DSI'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('Element vide'), Keys.chord(Keys.ESCAPE))

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Bouton Rechercher'))

WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/SN/SN premiere ligne'), 
    3)

'Récupérer les résultat relatif a SN'
GlobalVariable.numeroSN = WebUI.getText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/SN/SN premiere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

GlobalVariable.prixSN = WebUI.getText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/SN/Montant premiere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

GlobalVariable.libelleSN = WebUI.getText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/SN/Libelle premiere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

GlobalVariable.codeSageSN = WebUI.getText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/SN/Code Sage premiere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

GlobalVariable.codeArticleSN = WebUI.getText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/SN/Code Article premiere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

System.out.println('SN: ' + GlobalVariable.numeroSN)

System.out.println('Code Article: ' + GlobalVariable.codeArticleSN)

System.out.println('Libellé: ' + GlobalVariable.libelleSN)

System.out.println('Code Sage: ' + GlobalVariable.codeSageSN)

System.out.println('Prix: ' + GlobalVariable.prixSN)

//RECHERCHE ICCID
'Choisir  l onglet ICCID'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Onglet ICCID'))

WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Statut'), 3)

'Cliquer sur le champ Statut dans ICCID'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Statut'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox DISPO'), 3)

'Choisir DISPO'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox DISPO'))

WebUI.sendKeys(findTestObject('Element vide'), Keys.chord(Keys.ESCAPE))

'Cliquer sur le champ Dépôt'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Depot'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox SHOP TEST DSI'), 
    3)

'Choisir SHOP TEST DSI'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox SHOP TEST DSI'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('Element vide'), Keys.chord(Keys.ESCAPE))

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Bouton Rechercher'))

WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/ICCID/ICCID premiere ligne'), 
    3)

'Récupérer les résultat relatif a ICCID'
GlobalVariable.numeroICCID = WebUI.getText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/ICCID/ICCID premiere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

GlobalVariable.prixICCID = WebUI.getText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/ICCID/Montant premiere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

GlobalVariable.libelleICCID = WebUI.getText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/ICCID/Libelle premiere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

GlobalVariable.codeSageICCID = WebUI.getText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/ICCID/Code Sage premiere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

GlobalVariable.codeArticleICCID = WebUI.getText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/ICCID/Code Article premiere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

System.out.println('ICCID: ' + GlobalVariable.numeroICCID)

System.out.println('Code Article: ' + GlobalVariable.codeArticleICCID)

System.out.println('Libellé: ' + GlobalVariable.libelleICCID)

System.out.println('Code Sage: ' + GlobalVariable.codeSageICCID)

System.out.println('Prix: ' + GlobalVariable.prixICCID)

