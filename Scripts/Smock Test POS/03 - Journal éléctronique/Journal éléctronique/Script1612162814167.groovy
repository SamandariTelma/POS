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
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.deleteAllCookies()

WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Connexion a POS'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer sur journal électronique'
WebUI.waitForElementPresent(findTestObject('Header POS-/Lien Journal Electronique'), 10)

WebUI.click(findTestObject('Header POS-/Lien Journal Electronique'), FailureHandling.STOP_ON_FAILURE)

'Choisir le shop SHOP TEST DSI'
WebUI.waitForElementPresent(findTestObject('Page Recherche de tickets (Journal Electronique)/Formulaire de recherche/Champ Shop'), 
    3)

WebUI.click(findTestObject('Page Recherche de tickets (Journal Electronique)/Formulaire de recherche/Champ Shop'))

WebUI.click(findTestObject('Page Recherche de tickets (Journal Electronique)/Formulaire de recherche/Option Shop - SHOP TEST DSI'))

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

'Choisir l opération Vente'
WebUI.click(findTestObject('Page Recherche de tickets (Journal Electronique)/Formulaire de recherche/Champ Operation'))

WebUI.click(findTestObject('Page Recherche de tickets (Journal Electronique)/Formulaire de recherche/Option Operation - Vente'))

WebUI.delay(4)

'Choisir le mode de règlement Espèce'
WebUI.click(findTestObject('Page Recherche de tickets (Journal Electronique)/Formulaire de recherche/Champ Mode de reglement'))

WebUI.click(findTestObject('Page Recherche de tickets (Journal Electronique)/Formulaire de recherche/Option Mode de reglement - Espece'))

WebUI.delay(1, FailureHandling.CONTINUE_ON_FAILURE)

'Choisir le statut Validé'
WebUI.click(findTestObject('Page Recherche de tickets (Journal Electronique)/Formulaire de recherche/Champ Statut'))

WebUI.click(findTestObject('Page Recherche de tickets (Journal Electronique)/Formulaire de recherche/Option Statut - Valide'))

WebUI.clearText(findTestObject('Page Recherche de tickets (Journal Electronique)/Formulaire de recherche/Champ Article libelle'))

'Saisir le libellé de l article NET ONE DAY'
WebUI.sendKeys(findTestObject('Page Recherche de tickets (Journal Electronique)/Formulaire de recherche/Champ Article libelle'), 
    'NET ONE DAY')

WebUI.click(findTestObject('Page Recherche de tickets (Journal Electronique)/Formulaire de recherche/Champ Date Debut'))

'Saisir la date de début'
WebUI.sendKeys(findTestObject('Page Recherche de tickets (Journal Electronique)/Formulaire de recherche/Champ Date Debut'), 
    Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Page Recherche de tickets (Journal Electronique)/Formulaire de recherche/Champ Date Debut'), 
    '01/12/2021')

'Valider la recherche'
WebUI.click(findTestObject('Page Recherche de tickets (Journal Electronique)/Formulaire de recherche/Bouton Rechercher'))

WebUI.waitForElementPresent(findTestObject('Page Recherche de tickets (Journal Electronique)/Resultat de la recherche/Titre page Resultat de la recherche'), 
    3)

//Récupération des éléments de chaque colonne du tableau
/*WebDriver driver = DriverFactory.getWebDriver()
TestObject to = findTestObject('Page Recherche de tickets (Journal Electronique)/Resultat de la recherche/Resultat colonne operation')
List<WebElement> colonne_Operation = driver.findElements(By.xpath(to.findPropertyValue('xpath')))*/
//Récupération des résultats pour la colonne Opération
'Vérifier que le résultat est conforme aux critères choisis'
List<WebElement> colonne_Operation = WebUiCommonHelper.findWebElements(findTestObject('Page Recherche de tickets (Journal Electronique)/Resultat de la recherche/Resultat colonne Operation'), 
    6)

for (def operation : colonne_Operation) {
    System.out.println(operation.getText())

    WebUI.verifyMatch(operation.getText(), 'Vente', false)
}

//Récupération des résultats pour la colonne Shop
List<WebElement> colonne_Shop = WebUiCommonHelper.findWebElements(findTestObject('Page Recherche de tickets (Journal Electronique)/Resultat de la recherche/Resultat colonne Shop'), 
    6)

for (def shop : colonne_Shop) {
    System.out.println(shop.getText())

    WebUI.verifyMatch(shop.getText(), 'SHOP TEST DSI', false)
}

//Récupération des résultats pour la colonne Statut
List<WebElement> colonne_Statut = WebUiCommonHelper.findWebElements(findTestObject('Page Recherche de tickets (Journal Electronique)/Resultat de la recherche/Resultat colonne Statut'), 
    6)

for (def statut : colonne_Statut) {
    System.out.println(statut.getText())

    WebUI.verifyMatch(statut.getText(), 'Validé', false)
}

//Récupération des résultats pour la colonne Article
List<WebElement> colonne_Article = WebUiCommonHelper.findWebElements(findTestObject('Page Recherche de tickets (Journal Electronique)/Resultat de la recherche/Resultat colonne Article'), 
    6)

for (def article : colonne_Article) {
    System.out.println(article.getText())

    WebUI.verifyMatch(article.getText(), 'NET ONE DAY', false)
}

'Cliquer sur le bouton Export'
WebUI.click(findTestObject('Page Recherche de tickets (Journal Electronique)/Resultat de la recherche/Bouton Export'))

WebUI.delay(2)

'Cliquer sur le bouton Export Avancé'
WebUI.click(findTestObject('Page Recherche de tickets (Journal Electronique)/Resultat de la recherche/Bouton Exprot Avancé'))

WebUI.delay(2, FailureHandling.CONTINUE_ON_FAILURE)

'Coché tous les options dans le popin export avancé'
WebUI.click(findTestObject('Page Recherche de tickets (Journal Electronique)/Resultat de la recherche/Popin Selection des donnes a exporter/Checkbox Informations generiques'))

WebUI.click(findTestObject('Page Recherche de tickets (Journal Electronique)/Resultat de la recherche/Popin Selection des donnes a exporter/Checkbox Details des paiements'))

WebUI.click(findTestObject('Page Recherche de tickets (Journal Electronique)/Resultat de la recherche/Popin Selection des donnes a exporter/Checkbox Details des articles'))

WebUI.click(findTestObject('Page Recherche de tickets (Journal Electronique)/Resultat de la recherche/Popin Selection des donnes a exporter/Bouton Confirmer'))

