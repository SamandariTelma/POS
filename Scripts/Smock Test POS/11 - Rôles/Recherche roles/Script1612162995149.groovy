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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory

'Se connecter à POS'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Connexion a POS'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Menu POS-/Menu Parametrage'), 3)

'Cliquer sur Paramétrage'
WebUI.click(findTestObject('Menu POS-/Menu Parametrage'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Menu POS-/Sous menu Roles'), 3)

'Cliquer sur le menu Rôles'
WebUI.click(findTestObject('Menu POS-/Sous menu Roles'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page Gestion des rôles/Recherche Avancée/Champ Code'), 3)

'Saisir des informations incorrectes '
WebUI.sendKeys(findTestObject('Page Gestion des rôles/Recherche Avancée/Champ Code'), '6876847')

WebUI.sendKeys(findTestObject('Page Gestion des rôles/Recherche Avancée/Champ Libelle'), '6876847')

'Décocher la case à cocher Actif'
WebUI.click(findTestObject('Page Gestion des rôles/Recherche Avancée/Checkbox Actif'))

'Vérifier que le checbox n est pas coché'
WebUI.verifyElementNotChecked(findTestObject('Page Gestion des rôles/Recherche Avancée/Checkbox Actif (etat)'), 0)

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des rôles/Bouton Rechercher'))

'Vérifier q aucun résultat s affiche '
WebUI.verifyElementNotPresent(findTestObject('Page Gestion des rôles/Tableau de résultat/Code premiere ligne'), 3)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des rôles/Tableau de résultat/Libelle premiere ligne'), 3)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des rôles/Tableau de résultat/Actif premiere ligne'), 3)

WebUI.delay(3)

'Cliquer sur le bouton Réinitialiser'
WebUI.click(findTestObject('Page Gestion des rôles/Bouton Reinitialiser'))

'Vérifier que le champ code est vide'
WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des rôles/Recherche Avancée/Champ Code'), 'value', '', 0)

'Vérifier que le champ Libellé est vide'
WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des rôles/Recherche Avancée/Champ Libelle'), 'value', '', 
    0)

'Vérifier que le Checkbox Actif est coché'
WebUI.verifyElementChecked(findTestObject('Page Gestion des rôles/Recherche Avancée/Checkbox Actif (etat)'), 0)

'Saisir un code valide dans le champ Code'
WebUI.sendKeys(findTestObject('Page Gestion des rôles/Recherche Avancée/Champ Code'), 'ADV')

'Cliquer sur le case à cocher'
WebUI.click(findTestObject('Page Gestion des rôles/Recherche Avancée/Checkbox Actif'))

'Vérifier que le checkbox Actif est décoché'
WebUI.verifyElementNotChecked(findTestObject('Page Gestion des rôles/Recherche Avancée/Checkbox Actif (etat)'), 0)

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des rôles/Bouton Rechercher'))

WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Page Gestion des rôles/Tableau de résultat/Actif premiere ligne'), 3)

'Vérifier que les résultats adéquats au champ recherché apparaissent dans la liste des rôles'
WebUI.verifyElementText(findTestObject('Page Gestion des rôles/Tableau de résultat/Code premiere ligne'), 'ADV')

WebUI.verifyElementText(findTestObject('Page Gestion des rôles/Tableau de résultat/Libelle premiere ligne'), 'ADV')

WebUI.verifyElementText(findTestObject('Page Gestion des rôles/Tableau de résultat/Actif premiere ligne'), 'non')

'Laisser vide le champ Code'
WebUI.sendKeys(findTestObject('Page Gestion des rôles/Recherche Avancée/Champ Code'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Page Gestion des rôles/Recherche Avancée/Champ Code'), Keys.chord(Keys.BACK_SPACE))

'Saisir un libellé valide'
WebUI.sendKeys(findTestObject('Page Gestion des rôles/Recherche Avancée/Champ Libelle'), Keys.chord(Keys.CONTROL, 'a'))

'Saisir un libellé valide'
WebUI.sendKeys(findTestObject('Page Gestion des rôles/Recherche Avancée/Champ Libelle'), 'Vendeur')

'Cocher le checkbox Actif'
WebUI.click(findTestObject('Page Gestion des rôles/Recherche Avancée/Checkbox Actif'))

'Vérifier que le checkbox devient coché'
WebUI.verifyElementChecked(findTestObject('Page Gestion des rôles/Recherche Avancée/Checkbox Actif (etat)'), 0)

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des rôles/Bouton Rechercher'))

WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Page Gestion des rôles/Tableau de résultat/Actif premiere ligne'), 3)

'Vérifier que les résultats adéquats au champ recherché apparaissent dans la liste des rôles'
WebUI.verifyElementText(findTestObject('Page Gestion des rôles/Tableau de résultat/Code premiere ligne'), 'CTS')

WebUI.verifyElementText(findTestObject('Page Gestion des rôles/Tableau de résultat/Libelle premiere ligne'), 'Vendeur')

WebUI.verifyElementText(findTestObject('Page Gestion des rôles/Tableau de résultat/Actif premiere ligne'), 'oui')

WebUI.sendKeys(findTestObject('Page Gestion des rôles/Recherche Avancée/Champ Code'), 'admin')

'Remplir tous les champs par des valeurs correctes'
WebUI.sendKeys(findTestObject('Page Gestion des rôles/Recherche Avancée/Champ Libelle'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Page Gestion des rôles/Recherche Avancée/Champ Libelle'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Page Gestion des rôles/Recherche Avancée/Champ Libelle'), 'Administrateur')

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des rôles/Bouton Rechercher'))

WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Page Gestion des rôles/Tableau de résultat/Actif premiere ligne'), 3)

'Vérifier que les résultats adéquats au champ recherché apparaissent dans la liste des rôles'
WebUI.verifyElementText(findTestObject('Page Gestion des rôles/Tableau de résultat/Code premiere ligne'), 'admin')

WebUI.verifyElementText(findTestObject('Page Gestion des rôles/Tableau de résultat/Libelle premiere ligne'), 'Administrateur')

WebUI.verifyElementText(findTestObject('Page Gestion des rôles/Tableau de résultat/Actif premiere ligne'), 'oui')

'Laisser tous les champs vides'
WebUI.sendKeys(findTestObject('Page Gestion des rôles/Recherche Avancée/Champ Code'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Page Gestion des rôles/Recherche Avancée/Champ Code'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Page Gestion des rôles/Recherche Avancée/Champ Libelle'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Page Gestion des rôles/Recherche Avancée/Champ Libelle'), Keys.chord(Keys.BACK_SPACE))

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des rôles/Bouton Rechercher'))

WebUI.delay(0.500)

//Récupération des résultats pour la colonne Actif
'Vérifier que tous les résultats s affichent et le colonne Actif sont contient oui'
List<WebElement> colonne_Actif = WebUiCommonHelper.findWebElements(findTestObject('Page Gestion des rôles/Tableau de résultat/Colonne Actif'), 
    6)

WebUI.verifyGreaterThan(colonne_Actif.size(), 5)

for (def actif : colonne_Actif) {
    System.out.println(actif.getText())

    WebUI.verifyMatch(actif.getText(), 'oui', false)
}

