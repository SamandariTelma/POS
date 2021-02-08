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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement

//WebUI.callTestCase(findTestCase('Smock Test POS/04 - Vente Produit/Prerequis-Recherche Produit'), [:], FailureHandling.CONTINUE_ON_FAILURE)
'Se connecter à POS'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Connexion a POS'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Menu POS-/Menu Parametrage'), 3)

'Cliquer sur le menu Parametrage'
WebUI.click(findTestObject('Menu POS-/Menu Parametrage'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.maximizeWindow()

WebUI.waitForElementPresent(findTestObject('Menu POS-/Sous menu Articles'), 3)

'Cliquer sur le sous menu Articles'
WebUI.click(findTestObject('Menu POS-/Sous menu Articles'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(0.500)

'Remplir les champs par des valeurs incorretes'
WebUI.waitForElementPresent(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Article'), 3)

WebUI.sendKeys(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Article'), '88888')

WebUI.sendKeys(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Libelle'), '88888')

WebUI.sendKeys(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ EAN'), '88888')

WebUI.sendKeys(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ IMEI ICCID SN'), '88888')

WebUI.click(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Entite juridique'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Option Telma SA'), 3)

WebUI.click(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Option Telma SA'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Element vide'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(6)

WebUI.waitForElementPresent(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Categorie'), 3)

WebUI.click(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Categorie'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Option Accessoires'), 
    3)

WebUI.click(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Option Accessoires'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Element vide'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Type'), 3)

WebUI.click(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Type'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Option Frais'), 3)

WebUI.click(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Option Frais'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Element vide'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Modele'), '88888')

WebUI.waitForElementPresent(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Techno'), 3)

WebUI.click(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Techno'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Option 2G'), 3)

WebUI.click(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Option 2G'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Element vide'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Actif'), 3)

WebUI.click(findTestObject('Element vide'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Actif'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Option Non'), 3)

WebUI.click(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Option Non'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Element vide'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Marque'), '88888')

WebUI.sendKeys(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ montant min'), '88888')

WebUI.sendKeys(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ montant max'), '88888')

WebUI.sendKeys(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Code SAGE'), '88888')

'Cliquer sur le bouton Recherche'
WebUI.click(findTestObject('Page Gestion des articles/Bouton Rechercher'))

WebUI.delay(0.500)

'Vérifier qu aucun résultat apparait dans le tableau'
WebUI.waitForElementPresent(findTestObject('Page Gestion des articles/Résultat Liste/Code article 1ere ligne'), 3)

'Vérifier qu aucun résultat apparait dans le tableau'
WebUI.verifyElementNotPresent(findTestObject('Page Gestion des articles/Résultat Liste/Code article 1ere ligne'), 3)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des articles/Résultat Liste/Code SAGE 1ere ligne'), 3)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des articles/Résultat Liste/EAN 1ere ligne'), 3)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des articles/Résultat Liste/Libelle 1ere ligne'), 3)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des articles/Résultat Liste/Entite Juridique 1ere ligne'), 3)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des articles/Résultat Liste/Prix de Vente 1ere ligne'), 3)

'Cliquer sur le bouton Réinitialiser'
WebUI.click(findTestObject('Page Gestion des articles/Bouton Reinitialiser'))

'Vérifier que tous les champs se remettent à leurs valeurs initial'
WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Article'), 
    'value', '', 3)

WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Libelle'), 
    'value', '', 3)

WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ EAN'), 'value', 
    '', 3)

WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ IMEI ICCID SN'), 
    'value', '', 3)

WebUI.verifyElementText(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Entite juridique'), 
    'Choisissez une entité juridique')

WebUI.verifyElementText(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Categorie'), 'Choisissez une catégorie')

WebUI.verifyElementText(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Type'), 'Choisissez un type')

WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Modele'), 
    'value', '', 3)

WebUI.verifyElementText(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Techno'), 'Choisissez un techno')

WebUI.verifyElementText(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Actif'), 'Oui')

WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Marque'), 
    'value', '', 3)

WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ montant min'), 
    'value', '0', 3)

WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ montant max'), 
    'value', '0', 3)

WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Code SAGE'), 
    'value', '', 3)

'Vérifier que tous les résutats s affiche'
List<WebElement> liste_resultat = WebUiCommonHelper.findWebElements(findTestObject('Page Gestion des articles/Résultat Liste/Colonne Entite Juridique'), 
    6)

System.out.println(liste_resultat.size() + ' Lignes')

WebUI.verifyGreaterThan(liste_resultat.size(), 3)

'Remplir les champs par des éléments valide'
WebUI.sendKeys(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Article'), GlobalVariable.codeArticleIMEI)

WebUI.sendKeys(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Libelle'), GlobalVariable.libelleIMEI)

WebUI.sendKeys(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Code SAGE'), GlobalVariable.codeSageIMEI)

'Cliquer sur le bouton rechercher'
WebUI.click(findTestObject('Page Gestion des articles/Bouton Rechercher'))

WebUI.delay(0.500)

'Vérifier que le résultat adéquat au champ recherché apparait dans la liste de résultat'
WebUI.waitForElementPresent(findTestObject('Page Gestion des articles/Résultat Liste/Code article 1ere ligne'), 3)

WebUI.verifyElementText(findTestObject('Page Gestion des articles/Résultat Liste/Code article 1ere ligne'), GlobalVariable.codeArticleIMEI)

WebUI.verifyElementText(findTestObject('Page Gestion des articles/Résultat Liste/Code SAGE 1ere ligne'), GlobalVariable.codeSageIMEI)

WebUI.verifyElementText(findTestObject('Page Gestion des articles/Résultat Liste/Libelle 1ere ligne'), GlobalVariable.libelleIMEI)

'Cliquer sur le bouton Réinitialiser'
WebUI.click(findTestObject('Page Gestion des articles/Bouton Reinitialiser'))

'Cliquer sur le champ Type'
WebUI.click(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Type'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Option Facture d abonnement'), 
    0)

'Choisir l option Facture d abonnement'
WebUI.click(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Option Facture d abonnement'), FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des articles/Bouton Rechercher'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Page Gestion des articles/Résultat Liste/Colonne Entite Juridique'), 0)

//Récupération des résultats pour la colonne Libelle
'Vérifier que la colonne libelle contient Facture d abonnement'
List<WebElement> colonne_Libelle = WebUiCommonHelper.findWebElements(findTestObject('Page Gestion des articles/Résultat Liste/Colonne Libelle'), 
    6)

for (def libelle : colonne_Libelle) {
    System.out.println(libelle.getText())

    WebUI.verifyMatch(libelle.getText(), '^Facture d\'abonnement.*', true)
}

'Cliquer sur le bouton Réinitialiser'
WebUI.click(findTestObject('Page Gestion des articles/Bouton Reinitialiser'))

'Cliquer sur le champ Entité Juridique'
WebUI.click(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Champ Entite juridique'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Option Telma SA'), 0)

'Choisir l option Telma SA'
WebUI.click(findTestObject('Page Gestion des articles/Formulaire Recherche avancée/Option Telma SA'), FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des articles/Bouton Rechercher'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Page Gestion des articles/Résultat Liste/Colonne Entite Juridique'), 0)

//Récupération des résultats pour la colonne Entité Juridique
'Vérifier que tous les résultats s affichent'
List<WebElement> colonne_Entite_Juridique = WebUiCommonHelper.findWebElements(findTestObject('Page Gestion des articles/Résultat Liste/Colonne Entite Juridique'), 
    6)

for (def entite : colonne_Entite_Juridique) {
    System.out.println(entite.getText())

    WebUI.verifyMatch(entite.getText(), 'Telma SA', false)
}

WebUI.click(findTestObject('Page Gestion des articles/Bouton Export'))

