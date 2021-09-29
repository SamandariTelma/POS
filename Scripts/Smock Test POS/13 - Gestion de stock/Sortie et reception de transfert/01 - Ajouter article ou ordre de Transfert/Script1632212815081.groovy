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
String codeSageRecherche = 'MOBGSM VIDA S45 SMARTPHONE'

String code = 'TERMINAL-00040'

String libelle = 'GSM TELMA F1XS4G'

String imei = '100000000012345'

String quantite = '1'
*/
String codeSageRecherche = "$codeSage"

String code = "$codeArticle"

String libelle = "$libelle"

String quantite = "$quantite"

//----------------------------------
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Connexion a POS'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'En tant que User connecté sur la preprod, je Clique sur gestion de stock > Sous-Menus SORTIE'
WebUI.waitForElementPresent(findTestObject('Menu POS-/Menu Gestion de stock/Menu Gestion de stock'), 30, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Menu POS-/Menu Gestion de stock/Menu Gestion de stock'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Menu POS-/Menu Gestion de stock/Sous menu sortie'), 5)

WebUI.click(findTestObject('Menu POS-/Menu Gestion de stock/Sous menu sortie'), FailureHandling.CONTINUE_ON_FAILURE)

'Affichage de la page choix de sortie de stock avec les boutons sortie transfert, sortie exceptionnelle, ordre de rapatriement'
WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page Sortie de stock/Bouton Sortie de transfert'), 30, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(0.500)

'Je clique sur Sortie Transfert '
WebUI.click(findTestObject('Pages Gestion de stock/Page Sortie de stock/Bouton Sortie de transfert'))

'Affichage de la page recherche liste des transferts avec :\r\n- les champs Référence\r\n- dépôt d\'origine\r\n- dépôt destination\r\n- code sage\r\n- code article, statut \r\n- bouton "ajouter"'
WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Titre page'), 15, FailureHandling.STOP_ON_FAILURE)

'Dans les champs de recherche, je clique sur "Ajouter" '
WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Bouton ajouter'))

'Affichage de la page "ordre de transfert" avec les champs : \r\n- dépôt d\'origine\r\n- dépôt de destination\r\n- type\r\n- motif du TR\r\n-bouton "+" cliquable pour ajout d\'artcile à transférer'
WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Titre page'), 15, FailureHandling.STOP_ON_FAILURE)

'Je Choisis le dépôt d\'origine Exemple : SHOP TEST DSI'
WebUI.click(findTestObject('Pages Gestion de stock/Page ordre de transfert/Liste déroulante depot d origine'))

WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Option depot SHOP TEST DSI'), 
    0)

WebUI.scrollToElement(findTestObject('Pages Gestion de stock/Page ordre de transfert/Option depot SHOP TEST DSI'), 0)

WebUI.click(findTestObject('Pages Gestion de stock/Page ordre de transfert/Option depot SHOP TEST DSI'), FailureHandling.CONTINUE_ON_FAILURE)

'Je choisis le dépôt de destination Exemple : ADV_SHOP_TEST'
WebUI.click(findTestObject('Pages Gestion de stock/Page ordre de transfert/Liste déroulante depot de destination'))

'Le dépôt d\'origine choisi ne devrait plus apparaître dans la liste déroulante du dépôt de destination'
WebUI.verifyElementNotPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Option depot SHOP TEST DSI'), 
    0)

WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Option depot ADV SHOP TEST'), 
    0)

WebUI.scrollToElement(findTestObject('Pages Gestion de stock/Page ordre de transfert/Option depot ADV SHOP TEST'), 0)

WebUI.click(findTestObject('Pages Gestion de stock/Page ordre de transfert/Option depot ADV SHOP TEST'), FailureHandling.CONTINUE_ON_FAILURE)

'Je choisis le type ex : Appro Exceptionnel'
WebUI.click(findTestObject('Pages Gestion de stock/Page ordre de transfert/Liste déroulante Type'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Option Appro Exceptionnel'), 
    0)

WebUI.scrollToElement(findTestObject('Pages Gestion de stock/Page ordre de transfert/Option Appro Exceptionnel'), 0)

WebUI.click(findTestObject('Pages Gestion de stock/Page ordre de transfert/Option Appro Exceptionnel'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('Pages Gestion de stock/Page ordre de transfert/Champ texte Motif du TR'), 'TEST')

'Vérifier que le bouton + est cliquable'
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

'Dans le pop-in,  j\'insère  la quantité à transférer sans remplir les autres champs \r\nJe clique sur Ajouter'
WebUI.sendKeys(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Champ Quantité'), 
    quantite)

WebUI.click(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Bouton Ajouter'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/warning orange - Article vide'), 
    3)

'Dans la pop-in, je saisis le début du code sage ou code '
WebUI.sendKeys(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin Recherche Article/Champ Code Sage'), 
    codeSageRecherche)

//WebUI.delay(3)
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

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page ordre de transfert/Tableau de produit ajouté/Info Code sage'), 
    codeSageRecherche)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page ordre de transfert/Tableau de produit ajouté/Info Code produit'), 
    code)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page ordre de transfert/Tableau de produit ajouté/Info Quantité'), 
    quantite)

