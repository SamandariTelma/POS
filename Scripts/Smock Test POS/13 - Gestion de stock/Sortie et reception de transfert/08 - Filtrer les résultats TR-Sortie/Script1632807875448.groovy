import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

String codeSageARecherche = "$codeSageARecherche"

String initialCodeSage = codeSageARecherche.substring(0, 6)

String resteCodeSage = codeSageARecherche.substring(6)

String statutGenere = 'Généré'

String statutAnnule = 'Annulé'

WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Connexion a POS'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Smock Test POS/13 - Gestion de stock/Sortie et reception de transfert/00-Called Test case/Acceder a la page choix sortie stock'), 
    [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Smock Test POS/13 - Gestion de stock/Sortie et reception de transfert/00-Called Test case/Acceder à la page liste de résultat de sortie'), 
    [:], FailureHandling.CONTINUE_ON_FAILURE)

'Je filtre par code sage article en Saisissant le début du code sage \r\n\r\nExemple : MOBKITPREPRAID\r\npuis rechercher'
WebUI.sendKeys(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Champ code sage'), 
    initialCodeSage)

WebUI.sendKeys(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Champ code sage'), 
    resteCodeSage)

WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Option codeSage'), 
    3)

WebUI.scrollToElement(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/option MOBKITPREPAID'), 
    0)

WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/option MOBKITPREPAID'))

/*
optionCodeSage = WebUiCommonHelper.findWebElements(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Option codeSage'), 
    5)


//CustomKeywords.'util.FindList.findOptionAndClick'(optionCodeSage, codeSageARecherche)

for (def option : optionCodeSage) {
    String codeSage = option.getText()

    println(codeSage)

    if (codeSage.equals(codeSageARecherche)) {
        option.click()
    }
}
*/
WebUI.verifyElementAttributeValue(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Champ code sage'), 
    'value', codeSageARecherche, 5)

WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Bouton Rechercher'))

WebUI.delay(1)

'Affichage d\'une liste déroulante commençant par le début du code sage saisie'
WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Réference TR généré - 1ere ligne'), 
    10)

'Visualiser le détail du TR'
WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton visualisier - 1ere ligne'))

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Visualusation detail reception/Titre page'), 10)

'Vérifier que le code sage correspond au code sage filtré'
WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Visualusation detail reception/Info code sage'), codeSageARecherche)

'Revenir sur le résultat du filtre en cliquant sur le fil d\'ariane Liste de transferts'
WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/File d ariane Liste de TR'))

'Je filtre le statut dans la liste déroulante : Généré'
WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Liste déroulante statut'))

WebUI.waitForElementVisible(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Option generé'), 
    3)

WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Option generé'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Bouton Rechercher'))

WebUI.delay(0.500)

statusResultColumn = WebUiCommonHelper.findWebElements(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Statut TR - 1ere ligne'), 
    5)

CustomKeywords.'util.FindList.verifyResultColumn'(statusResultColumn, statutGenere)

WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton visualisier - 1ere ligne'))

WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton telecharger- 1ere ligne'))

WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton annuler - 1ere ligne'))

WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton envoyer - 1ere ligne'))

WebUI.verifyElementNotClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton livrer - 1ere ligne'))

'Je filtre le statut dans la liste déroulante : Annulé'
WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Liste déroulante statut'))

WebUI.waitForElementVisible(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Option Annulé'), 
    3)

WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Option Annulé'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Bouton Rechercher'))

WebUI.delay(0.500)

statusResultColumn = WebUiCommonHelper.findWebElements(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Statut TR - 1ere ligne'), 
    5)

CustomKeywords.'util.FindList.verifyResultColumn'(statusResultColumn, statutAnnule)

WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton visualisier - 1ere ligne'))

WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton telecharger- 1ere ligne'))

WebUI.verifyElementNotClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton annuler - 1ere ligne'))

WebUI.verifyElementNotClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton envoyer - 1ere ligne'))

WebUI.verifyElementNotClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton livrer - 1ere ligne'))

