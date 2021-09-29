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

String codeSage = "$codeSage"

String codeArticle = "$codeProduit"

String depotOrigine = "$depotOrigine"

String depotDestination = "$depotDestination"

String type = "$type"

String motif = "$motif"

WebUI.callTestCase(findTestCase('Smock Test POS/13 - Gestion de stock/Sortie et reception de transfert/00-Called Test case/Rechercher le Transfert envoyé'), 
    [('referenceTR') : referenceTR], FailureHandling.CONTINUE_ON_FAILURE)

'Je clique sur "Télécharger" dans le champ action'
WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste TR (Reception)/Tableau de résultat/Bouton telecharger- 1ere ligne'))

WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)

'Je clique sur la référence des transferts dans liste des transferts'
WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste TR (Reception)/Tableau de résultat/Réference TR généré - 1ere ligne'))

WebUI.delay(0.500)

'Affichage  détails de l\'article transferé (dépôt d\'origine, dépôt de destination, type, code produit, numéro de série)'
WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Titre page'), 3)

WebUI.verifyElementAttributeValue(findTestObject('Pages Gestion de stock/Page ordre de transfert/Champ desactivé - depot d origine'), 
    'value', depotOrigine, 3)

WebUI.verifyElementAttributeValue(findTestObject('Pages Gestion de stock/Page ordre de transfert/Champ desactivé - depot de destination'), 
    'value', depotDestination, 3)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page ordre de transfert/Champ desactivé - type'), type)

WebUI.verifyElementAttributeValue(findTestObject('Pages Gestion de stock/Page ordre de transfert/Champ texte Motif du TR'), 
    'value', motif, 3)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page ordre de transfert/Tableau de produit ajouté/Page detail ordre TR/code produit'), 
    codeArticle)

WebUI.verifyElementText(findTestObject('Pages Gestion de stock/Page ordre de transfert/Tableau de produit ajouté/Page detail ordre TR/code sage'),
    codeSage)

'Le bouton supprimer n\'est pas cliquable'
WebUI.verifyElementNotClickable(findTestObject('Pages Gestion de stock/Page ordre de transfert/Tableau de produit ajouté/Page detail ordre TR/Bouton supprimer'))

'Je clique sur le bouton Annuler'
WebUI.click(findTestObject('Pages Gestion de stock/Page ordre de transfert/Bouton annuler'))

'Affichage pop-in notification :\r\n"Voulez-vous annuler le TR?" '
WebUI.verifyElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin annulation/Titre popin'), 
    3)

'Je clique sur Retour'
WebUI.click(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin annulation/Bouton retour'))

'pop-in se retire\r\nJe reste sur la page "ordre de transfert" qui affiche le détail de l\'article transféré (dépôt d\'origine, dépôt de destination, type, code produit, numéro de série)'
WebUI.verifyElementNotPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Popin annulation/Titre popin'), 3)

