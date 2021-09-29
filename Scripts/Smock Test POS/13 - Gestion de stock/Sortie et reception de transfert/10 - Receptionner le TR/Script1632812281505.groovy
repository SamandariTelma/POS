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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String referenceTR = "$referenceTR"

//String referenceTR = 'TRADV_SHOP_TEST27092021115665'
String DateTR = "$DateTR"

String DepotEnvoyeur = "$DepotEnvoyeur"

String DepotReceveur = "$DepotReceveur"

String CodeProduit = "$CodeProduit"

String CodeSage = "$CodeSage"

String Quantite = "$Quantite"

WebUI.callTestCase(findTestCase('Smock Test POS/13 - Gestion de stock/Sortie et reception de transfert/00-Called Test case/Rechercher le Transfert envoyé'), 
    [('referenceTR') : referenceTR], FailureHandling.CONTINUE_ON_FAILURE)

'Je clique sur le nuage pour réceptionner les articles transférés'
WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste TR (Reception)/Tableau de résultat/Bouton Receptionner- 1ere ligne'))

'Affichage de la page "INFO TR" avec :\r\n- date du TR\r\n- référence TR\r\n- dépôt envoyeur\r\n- dépôt receveur.'
WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Titre page'), 15, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Label date TR'), 3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Label Reference TR'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Label Depôt envoyeur'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Label Depôt receveur'), 
    3)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Date TR'), DateTR)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Reference TR'), referenceTR)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Depôt Envoyeur'), DepotEnvoyeur)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Depôt receveur'), DepotReceveur)

'Affichage "Réception" avec les :\r\n- code produit\r\n- code sage\r\n- quantité\r\n- numéro de série (avec loupe pour visualisation du numéro de série) \r\n- nuage dans le champ "Action"'
WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Code produit - 1ere ligne'), 
    CodeProduit)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Code Sage - 1ere ligne'), 
    CodeSage)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Quantite - 1ere ligne'), 
    '1')

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Bouton visualisation Num serie - 1ere ligne'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Bouton Action telecharger'), 
    3)

'Affichage des 3 Onglets: Réception, Autre Arcticle et Détail Transport'
WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Onglet Reception'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Onglet Reception'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-detait transporteur/Onglet detait transport'), 
    3)

'Cliquer sur l\'onglet Autre Article'
WebUI.click(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Autre Article/Onglet Autre Article'))

WebUI.delay(0.500)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Autre Article/Liste deroulante Code Article'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Autre Article/Bouton radio Articles'), 
    3)

WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Autre Article/Bouton radio cartons'), 
    3)

WebUI.click(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-detait transporteur/Onglet detait transport'))

WebUI.callTestCase(findTestCase('Smock Test POS/13 - Gestion de stock/Sortie et reception de transfert/00-Called Test case/Vérification onglet Detail Transport'), 
    [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Onglet Reception'))

WebUI.delay(0.500)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page Entrée de stock/Page Info TR/Tableau de Reception/Onglet-Reception/Code Sage - 1ere ligne'), 
    CodeSage)

WebUI.callTestCase(findTestCase('Smock Test POS/13 - Gestion de stock/Sortie et reception de transfert/00-Called Test case/Saisie IMEI produit à receptionner'), 
    [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Smock Test POS/13 - Gestion de stock/Sortie et reception de transfert/00-Called Test case/Enregistrement reception'), 
    [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Smock Test POS/13 - Gestion de stock/Sortie et reception de transfert/03 - Vérification statut article'), 
    [('statutAttendu') : 'DISPO', ('imei') : GlobalVariable.imei, ('depot') : GlobalVariable.depotReceveur], FailureHandling.CONTINUE_ON_FAILURE)

