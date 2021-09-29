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

/*
String codeSageRecherche = 'MOBKITPREPAID'

String codeSage1erLigne = 'MOBGSM VIDA S45 SMARTPHONE'

String code = 'SIM_TELMA'

String libelle = 'CARTE SIM'

String iccid = '356183940043841'

String quantite = '1'
*/
String codeSageRecherche = "$codeSage"

String code = "$codeArticle"

String libelle = "$libelle"

String quantite = "$quantite"

String codeSage1erLigne = GlobalVariable.codeSage1

'Vérifier que le bouton + est cliquable puis clique dessus'
WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page ordre de transfert/Bouton plus (Ajouter)'))

WebUI.click(findTestObject('Pages Gestion de stock/Page ordre de transfert/Bouton plus (Ajouter)'))

'Affichage d\'une pop-in "recherche article"  avec les champs :\r\n- libellé\r\n- code\r\n- code sage\r\n- quantité'
WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Titre popin'), 
    15, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Champ Code'), 
    0)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Champ Code Sage'), 
    0)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Champ Libellé'), 
    0)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Champ Quantité'), 
    0)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Champ Quantité'), 
    0)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Bouton Ajouter'), 
    0)

'Dans la pop-in, je saisis le début du code sage ou code '
WebUI.sendKeys(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Champ Code Sage'), 
    codeSageRecherche)

WebUI.waitForElementNotPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Bouton Ajouter'), 
    3)

'Affichage  liste déroulante commençant par le début du code sage / code saisi apparaissent'
WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Autocomplete Code sage'), 
    10)

WebUI.delay(2)

'Affichage  liste déroulante commençant par le début du code sage / code saisi apparaissent'
WebUI.click(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Autocomplete Code sage'), 
    FailureHandling.CONTINUE_ON_FAILURE)

/*
'Choisir l\'autocomplete'
autoCompleteCodeSage = WebUiCommonHelper.findWebElements(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Autocomplete Code sage'), 
    5)

WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Bouton Ajouter'), 
    3)


for (def codeSage : autoCompleteCodeSage) {
    String codeSageName = codeSage.getText()

    if (codeSageName.equals(codeSageRecherche)) {
        codeSage.click()
    }

}
*/
'Vérifier que les autres champs sont bien remplis par les caractéristiques du bien'
WebUI.verifyElementAttributeValue(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Champ Code Sage'), 
    'value', codeSageRecherche, 0)

WebUI.verifyElementAttributeValue(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Champ Libellé'), 
    'value', libelle, 0)

WebUI.verifyElementAttributeValue(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Champ Code'), 
    'value', code, 0)

'Cliquer sur le bouton Ajouter'
WebUI.click(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Bouton Ajouter'))

WebUI.delay(0.500)

'Vérifier l\'ajout du produit dans le tableau de la page ordre de transfert'
WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Tableau de produit ajouté/Info Code sage'), 
    3)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page ordre de transfert/Tableau de produit ajouté/Info Code sage - 2e ligne'), 
    codeSageRecherche)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page ordre de transfert/Tableau de produit ajouté/Info Code produit - 2e ligne'), 
    code)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page ordre de transfert/Tableau de produit ajouté/Info Quantité - 2e ligne'), 
    quantite)

'Cliquer sur le bouton supprimer'
WebUI.click(findTestObject('Pages Gestion de stock/Page ordre de transfert/Tableau de produit ajouté/Bouton supprimer'))

'Affichage d\'une pop-in "Votre réservation sur les articles sélectionnés est annulé"'
WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/warning bleu - Reservation annulé'), 
    3)

'Vérifier que l\'article n\'est plus présent dans la liste'
WebUI.verifyElementNotPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Tableau de produit ajouté/Info Code produit - 2e ligne'), 
    3)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page ordre de transfert/Tableau de produit ajouté/Info Code sage'), 
    codeSage1erLigne)

'Cliquer sur le bouton loupe et récuperer l\'Imei du produit'
WebUI.click(findTestObject('Pages Gestion de stock/Page ordre de transfert/Tableau de produit ajouté/Bouton loupe'))

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin liste des numéros/id produit'), 
    3)

String imeiProduit = WebUI.getText(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin liste des numéros/id produit'), 
    FailureHandling.CONTINUE_ON_FAILURE)

println('IMEI :' + imeiProduit)

GlobalVariable.imei = imeiProduit

WebUI.click(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin liste des numéros/Bouton retour'))

WebUI.callTestCase(findTestCase('Smock Test POS/13 - Gestion de stock/Sortie et reception de transfert/00-Called Test case/Reserver l article'), 
    [:], FailureHandling.CONTINUE_ON_FAILURE)

