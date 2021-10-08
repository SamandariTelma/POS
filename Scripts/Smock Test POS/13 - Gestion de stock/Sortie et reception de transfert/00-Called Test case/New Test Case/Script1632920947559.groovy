import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String depotOrigine="${depotOrigine}"

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
WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Titre page'), 
    15, FailureHandling.STOP_ON_FAILURE)

'Dans les champs de recherche, je clique sur "Ajouter" '
WebUI.click(findTestObject('Pages Gestion de stock/Page Recherche liste transfert (Sortie)/Formulaire de recherche/Bouton ajouter'))

'Affichage de la page "ordre de transfert" avec les champs : \r\n- dépôt d\'origine\r\n- dépôt de destination\r\n- type\r\n- motif du TR\r\n-bouton "+" cliquable pour ajout d\'artcile à transférer'
WebUI.waitForElementPresent(findTestObject('Pages Gestion de stock/Page ordre de transfert/Titre page'), 15, FailureHandling.STOP_ON_FAILURE)

'Je Choisis le dépôt d\'origine Exemple : SHOP TEST DSI'
WebUI.click(findTestObject('Pages Gestion de stock/Page ordre de transfert/Liste déroulante depot d origine'))

'Choisir l\'autocomplete'
autoDepot = WebUiCommonHelper.findWebElements(findTestObject('Pages Gestion de stock/Page ordre de transfert/Option Liste depot d origine'), 
    5)

CustomKeywords.'util.FindList.findOptionAndClick'(autoDepot, depotOrigine)

