import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.text.SimpleDateFormat as SimpleDateFormat
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

String curentDate = new SimpleDateFormat('d').format(Calendar.getInstance().getTime())

/*
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
*/
'Ajouter un article '
WebUI.callTestCase(findTestCase('Smock Test POS/13 - Gestion de stock/Sortie et reception de transfert/01 - Ajouter article ou ordre de Transfert'), 
    [('codeSage') : GlobalVariable.codeSage1, ('codeArticle') : GlobalVariable.codeArticle1, ('libelle') : GlobalVariable.libelle1
        , ('quantite') : '1'], FailureHandling.CONTINUE_ON_FAILURE)

'Enregistrer l\'article ajouter'
WebUI.callTestCase(findTestCase('Smock Test POS/13 - Gestion de stock/Sortie et reception de transfert/00-Called Test case/Reserver l article'), 
    [:], FailureHandling.CONTINUE_ON_FAILURE)

'Cliquer sur le bouton loupe et récuperer l\'Imei du produit'
WebUI.click(findTestObject('Pages Gestion de stock/Page ordre de transfert/Tableau de produit ajouté/Bouton loupe'))

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin liste des numéros/id produit'), 
    3)

String imeiProduit = WebUI.getText(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin liste des numéros/id produit'), 
    FailureHandling.CONTINUE_ON_FAILURE)

println('IMEI :' + imeiProduit)

GlobalVariable.imei = imeiProduit

WebUI.click(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin liste des numéros/Bouton retour'))

'Je reviens dans le champ "Recherche liste des transferts"'
String referenceTR = WebUI.getText(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/File d ariane reference TR'))

GlobalVariable.referenceTR = referenceTR

WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/File d ariane Liste de TR'))

'Affichage de la page liste transfert'
WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Titre page'), 
    10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Réference TR généré - 1ere ligne'), 
    3, FailureHandling.STOP_ON_FAILURE)

/*WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Réference TR généré - 1ere ligne'), 
    referenceTR, FailureHandling.STOP_ON_FAILURE)*/
'Vérifier que le statut du TR est generé et que seul les boutons action adequate sont activés'
WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Statut TR - 1ere ligne'), 
    'Généré', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton annuler - 1ere ligne'))

WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton envoyer - 1ere ligne'))

WebUI.verifyElementNotClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton livrer - 1ere ligne'))

WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton visualisier - 1ere ligne'))

WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton telecharger- 1ere ligne'))

'Affichage  pop-in : "Informations sur le transporteur"  \r\n\r\nDans pop-in :\r\n- champs date d\'envoi\r\n- menu déroulante transporteur (DHl, Interne Telma, Colis express)\r\n- référence AR\r\n- pièce justificative'
WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Bouton envoyer - 1ere ligne'))

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Titre popin'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Champ date d envoi'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Bouton calendrier'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Liste deroulante transporteur'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Champ reference AR'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Champ piece justificative'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Bouton import PJ'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Champ num voiture'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Champ nom chauffeur'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Bouton Annuler'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Bouton Valider'), 
    3)

'Le bouton "valideré est grisé'
WebUI.verifyElementNotClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Bouton Valider'), 
    FailureHandling.CONTINUE_ON_FAILURE)

'Je remplis les champs dans la pop-in :\r\n- Je clique sur l\'icône calendrier dans le champ date d\'envoi \r\n- Je choisis une date\r\n\r\n'
WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Bouton calendrier'))

WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/calendirer'), 
    3)

joursDuCalendrier = WebUiCommonHelper.findWebElements(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/JoursCalendrier'), 
    5)

for (def jours : joursDuCalendrier) {
    String jourCal = jours.getText()

    if (jourCal.equals(curentDate)) {
        jours.click()

        break
    }
}

'Je choisis un transporteur ex: Interne TELMA'
WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Liste deroulante transporteur'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Option INTERNE TELMA'), 
    3)

WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Option INTERNE TELMA'))

'Je remplis le champ reference AR'
WebUI.sendKeys(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Champ reference AR'), 
    'REF AR')

'Le bouton Valider devient cliquable'
WebUI.verifyElementClickable(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Bouton Valider'))

'Le bouton Valider devient cliquable'
WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Bouton Valider'))

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/warning rouge - PJ vide'), 
    3)

WebUI.uploadFile(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Champ import PJ type file'), 
    'D:\\Utilisateurs\\samandari\\QA\\PROJET AUTOMATISATION\\POS WEB\\POS\\Include\\img\\PJ.PNG')

'Je clique sur le bouton valider'
WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Popin Info transporteur/Bouton Valider'))

//Récuperer la date d'envoi
GlobalVariable.dateEnvoi = new SimpleDateFormat('M/d/yyyy').format(Calendar.getInstance().getTime())

'Je vérifie que la référence transferée ne devrait plus apparaître dans la liste des transferts dans sortie transfert'
String referenceTR2 = WebUI.getText(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Tableau de résultat/Réference TR généré - 1ere ligne'), 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyNotMatch(referenceTR, referenceTR2, false)

'Je vérifie que le Statut article "ALLOUE TR" qui devient Statut "EN TRANSIT/A LIVRER'
WebUI.callTestCase(findTestCase('Smock Test POS/13 - Gestion de stock/Sortie et reception de transfert/03 - Vérification statut article'), 
    [('statutAttendu') : 'En transit/A livrer', ('imei') : GlobalVariable.imei, ('depot') : GlobalVariable.depotEnvoyeur], 
    FailureHandling.CONTINUE_ON_FAILURE)

