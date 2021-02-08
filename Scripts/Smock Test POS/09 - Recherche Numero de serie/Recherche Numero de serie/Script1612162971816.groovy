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
import org.openqa.selenium.Keys as Keys

'Se connecter à POS'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Connexion a POS'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Menu POS-/Menu Parametrage'), 3)

'Cliquer sur le menu Paramètrage '
WebUI.click(findTestObject('Menu POS-/Menu Parametrage'))

WebUI.waitForElementPresent(findTestObject('Menu POS-/Menu Parametrage'), 3)

'Cliquer sur le sous-menu numéro de série'
WebUI.click(findTestObject('Menu POS-/Sous menu Numros de serie'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Onglet ICCID'), 3)

//RECHERCHE des produits IMEI
'Dans l onglet IMEI, remplir les champs importants '
WebUI.delay(0.500)

WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), GlobalVariable.codeArticleIMEI)

WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Code Sage'), GlobalVariable.codeSageIMEI)

WebUI.delay(9)

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Autocomplete CodeSage'), 
    3)

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Autocomplete CodeSage'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Libelle dans champ Liste article'), 
    3)

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Libelle dans champ Liste article'), 
    GlobalVariable.libelleIMEI + '\ncancel')

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Statut'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox DISPO'), 3)

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox DISPO'))

WebUI.sendKeys(findTestObject('Element vide'), Keys.chord(Keys.ESCAPE))

WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ IMEI'), GlobalVariable.numeroIMEI)

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Bouton Rechercher'))

WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/Code Article premiere ligne'), 
    3)

'Vérifier que les résultats affichés dans le tableau corréspondent aux informations entrés'
WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/Code Article premiere ligne'), 
    GlobalVariable.codeArticleIMEI)

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/Code Sage premiere ligne'), 
    GlobalVariable.codeSageIMEI)

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/Libelle premiere ligne'), 
    GlobalVariable.libelleIMEI)

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/Montant premiere ligne'), 
    GlobalVariable.prixIMEI)

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/IMEI premiere ligne'), 
    GlobalVariable.numeroIMEI)

'Cliquer sur le bouton Reinitialiser'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Bouton Reinitialiser'))

'Vérifier que les champs se remettent à zéro '
WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), 
    'value', '', 3)

WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Code Sage'), 
    'value', '', 3)

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Statut'), 'Statut')

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Depot'), 'Dépôt')

WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ IMEI'), 
    'value', '', 3)

WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Carton'), 
    'value', '', 3)

WebUI.waitForElementVisible(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), 3)

'Remplir les champs par des infos incorrecxts'
WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), '88888')

WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Code Sage'), '88888')

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Statut'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox DISPO'), 3)

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox DISPO'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('Element vide'), Keys.chord(Keys.ESCAPE))

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Depot'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox SHOP TEST DSI'), 
    0)

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox SHOP TEST DSI'))

WebUI.sendKeys(findTestObject('Element vide'), Keys.chord(Keys.ESCAPE))

WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ IMEI'), '88888')

WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Carton'), '88888')

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Bouton Rechercher'))

WebUI.delay(0.500)

'Vérifier q aucun resultat s affiche'
WebUI.verifyElementNotPresent(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/Code Article premiere ligne'), 
    0)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/Code Sage premiere ligne'), 
    0)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/Libelle premiere ligne'), 
    0)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/Montant premiere ligne'), 
    0)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/IMEI/IMEI premiere ligne'), 
    0)

'Cliquer sur le bouton Reinitialiser'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Bouton Reinitialiser'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), 3)

//A supprimer quand le bug sera corrigé {
WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), Keys.chord(Keys.CONTROL, 
        'a'))

WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Code Sage'), Keys.chord(Keys.CONTROL, 
        'a'))

WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Code Sage'), Keys.chord(Keys.BACK_SPACE))

'Cliquer sur le bouton recherche'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Bouton Rechercher'))

'Vérifier que tous les résutats s affiche'
List<WebElement> liste_resultat = WebUiCommonHelper.findWebElements(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/Lignes de résultat'), 
    6)

System.out.println(liste_resultat.size() + ' Résultat IMEI')

String all_result_appear

if (liste_resultat.size() > 3) {
    all_result_appear = 'true'
} else {
    all_result_appear = 'false'
}

WebUI.verifyMatch(all_result_appear, 'true', false)

//RECHERCHE des produits SN
'Choisir l onglet SN'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Onglet SN'))

WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), 3)

'Remplir les champs importants '
WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), 3)

'Remplir les champs importants '
WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), GlobalVariable.codeArticleSN)

WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ CodeSage'), GlobalVariable.codeSageSN)

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Autocomplete CodeSage'), 
    3)

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Autocomplete CodeSage'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Libelle dans champ Liste article'), 
    3)

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Libelle dans champ Liste article'), 
    GlobalVariable.libelleSN + '\ncancel')

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Statut'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox DISPO'), 3)

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox DISPO'))

WebUI.sendKeys(findTestObject('Element vide'), Keys.chord(Keys.ESCAPE))

WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/SN/Champ SN'), GlobalVariable.numeroSN)

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Bouton Rechercher'))

WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/SN/Code Article premiere ligne'), 
    3)

'Vérifier que les résultats affichés dans le tableau corréspondent aux informations entrés'
WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/SN/Code Article premiere ligne'), 
    GlobalVariable.codeArticleSN)

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/SN/Code Sage premiere ligne'), 
    GlobalVariable.codeSageSN)

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/SN/Libelle premiere ligne'), 
    GlobalVariable.libelleSN)

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/SN/Montant premiere ligne'), 
    GlobalVariable.prixSN)

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/SN/SN premiere ligne'), GlobalVariable.numeroSN)

'Cliquer sur le bouton Reinitialiser'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Bouton Reinitialiser'))

'Vérifier que les champs se remettent à zéro '
WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), 
    'value', '', 3)

WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ CodeSage'), 
    'value', '', 3)

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Statut'), 'Statut')

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Depot'), 'Dépôt')

WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/SN/Champ SN'), 
    'value', '', 3)

WebUI.waitForElementVisible(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), 3)

'Remplir les champs par des infos incorrecxts'
WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), '88888')

WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ CodeSage'), '88888')

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Statut'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox DISPO'), 3)

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox DISPO'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('Element vide'), Keys.chord(Keys.ESCAPE))

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Depot'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox SHOP TEST DSI'), 
    0)

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox SHOP TEST DSI'))

WebUI.sendKeys(findTestObject('Element vide'), Keys.chord(Keys.ESCAPE))

WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/SN/Champ SN'), '88888')

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Bouton Rechercher'))

WebUI.delay(0.500)

'Vérifier q aucun resultat s affiche'
WebUI.verifyElementNotPresent(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/SN/Code Article premiere ligne'), 
    0)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/SN/Code Sage premiere ligne'), 
    0)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/SN/Libelle premiere ligne'), 
    0)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/SN/Montant premiere ligne'), 
    0)

WebUI.verifyElementNotPresent(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/SN/SN premiere ligne'), 
    0)

'Cliquer sur le bouton Reinitialiser'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Bouton Reinitialiser'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), 3)

//A supprimer quand le bug sera corrigé {
WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), Keys.chord(Keys.CONTROL, 
        'a'))

WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ CodeSage'), Keys.chord(Keys.CONTROL, 
        'a'))

WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ CodeSage'), Keys.chord(Keys.BACK_SPACE))

'Cliquer sur le bouton recherche'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Bouton Rechercher'))

'Vérifier que tous les résutats s affiche'
List<WebElement> liste_resultat_SN = WebUiCommonHelper.findWebElements(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/Lignes de résultat'), 
    6)

System.out.println(liste_resultat_SN.size() + ' Résultat SN')

String all_result_appear_SN

if (liste_resultat_SN.size() > 3) {
    all_result_appear_SN = 'true'
} else {
    all_result_appear_SN = 'false'
}

WebUI.verifyMatch(all_result_appear_SN, 'true', false)

//RECHERCHE des produits ICCID
'Choisir l onglet ICCID'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Onglet ICCID'))

WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), 3)

'Remplir les champs importants '

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), 3)

WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), GlobalVariable.codeArticleICCID)

WebUI.sendKeys(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ CodeSage'), GlobalVariable.codeSageICCID)

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Autocomplete CodeSage'), 
    3)

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Autocomplete CodeSage'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Libelle dans champ Liste article'), 
    3)

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Libelle dans champ Liste article'), 
    GlobalVariable.libelleICCID + '\ncancel')

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Statut'))

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox DISPO'), 3)

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Checkbox DISPO'))

WebUI.sendKeys(findTestObject('Element vide'), Keys.chord(Keys.ESCAPE))

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Bouton Rechercher'))

WebUI.delay(0.500)

WebUI.waitForElementPresent(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/ICCID/Code Article premiere ligne'), 
    3)

'Vérifier que les résultats affichés dans le tableau corréspondent aux informations entrés'
WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/ICCID/Code Article premiere ligne'), 
    GlobalVariable.codeArticleICCID)

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/ICCID/Code Sage premiere ligne'), 
    GlobalVariable.codeSageICCID)

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/ICCID/Libelle premiere ligne'), 
    GlobalVariable.libelleICCID)

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/ICCID/Montant premiere ligne'), 
    GlobalVariable.prixICCID)

'Cliquer sur le bouton Reinitialiser'
WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Bouton Reinitialiser'))

'Vérifier que les champs se remettent à zéro '
WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), 
    'value', '', 3)

WebUI.verifyElementAttributeValue(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ CodeSage'), 
    'value', '', 3)

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Statut'), 'Statut')

WebUI.verifyElementText(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Depot'), 'Dépôt')

WebUI.waitForElementVisible(findTestObject('Page Gestion des Numéros de Série-/Formulaire RECHERCHE/Champ Article'), 3)

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Bouton Rechercher'))

'Vérifier que tous les résutats s affiche'
List<WebElement> liste_resultat_ICCID = WebUiCommonHelper.findWebElements(findTestObject('Page Gestion des Numéros de Série-/Tableau de resultat/Lignes de résultat'), 
    6)

System.out.println(liste_resultat_ICCID.size() + ' Résultat ICCID')

String all_result_appear_ICCID

if (liste_resultat_ICCID.size() > 3) {
    all_result_appear_ICCID = 'true'
} else {
    all_result_appear_ICCID = 'false'
}

WebUI.verifyMatch(all_result_appear_ICCID, 'true', false)

WebUI.click(findTestObject('Page Gestion des Numéros de Série-/Bouton Export'))

