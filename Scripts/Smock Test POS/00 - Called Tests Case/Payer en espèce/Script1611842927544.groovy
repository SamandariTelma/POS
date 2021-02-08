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

'Cliquer sur le bouton Payer'
WebUI.click(findTestObject('Page Vente POS-/Bouton Payer'))

'Vérifier que le bouton Ajouter Payement n est pas cliquable'
WebUI.waitForElementPresent(findTestObject('Page Encaissement-/Bouton Ajouter Paiement'), 0)

WebUI.verifyElementNotClickable(findTestObject('Page Encaissement-/Bouton Ajouter Paiement'))

'Saisir un montant inférieur au montant du produit'
WebUI.sendKeys(findTestObject('Page Encaissement-/Champ Montant'), Integer.toString(montantAPayer - 1))

'Vérifier que le bouton Ajouter Paiement devient cliquable'
WebUI.verifyElementClickable(findTestObject('Page Encaissement-/Bouton Ajouter Paiement'))

'Cliquer sur le bouton Ajouter Paiement'
WebUI.click(findTestObject('Page Encaissement-/Bouton Ajouter Paiement'))

'Vérifier que le montant ajouté apparaît dans la liste des paiements'
WebUI.waitForElementPresent(findTestObject('Page Encaissement-/Mode de paiement dans la liste de paiement'), 0)

WebUI.verifyElementText(findTestObject('Page Encaissement-/Mode de paiement dans la liste de paiement'), 'Espèces')

WebUI.verifyElementText(findTestObject('Page Encaissement-/Montant dans la liste de paiement'), montantInsufisantMGA)

'Vérifier que le bouton Encaisser est grisé'
WebUI.verifyElementNotClickable(findTestObject('Page Encaissement-/Bouton Encaisser'))

'Supprimer le montant dans la liste des paiements'
WebUI.click(findTestObject('Page Encaissement-/Bouton Clear avec icon croix rouge'))

'Saisir a nouveau un montant valide'
WebUI.sendKeys(findTestObject('Page Encaissement-/Champ Montant'), Integer.toString(montantAPayer))

'Cliquer sur le bouton Payer'
WebUI.click(findTestObject('Page Encaissement-/Bouton Ajouter Paiement'))

'Vérifier que le montant ajouté apparaît dans la liste des paiements'
WebUI.verifyElementText(findTestObject('Page Encaissement-/Mode de paiement dans la liste de paiement'), 'Espèces')

WebUI.waitForElementPresent(findTestObject('Page Encaissement-/Montant dans la liste de paiement'), 0)

WebUI.verifyElementText(findTestObject('Page Encaissement-/Montant dans la liste de paiement'), montantAPayerMGA)

'Vérifier que le bouton Encaisser devient cliquable'
WebUI.verifyElementClickable(findTestObject('Page Encaissement-/Bouton Encaisser'))

'Supprimer le montant dans la liste des paiements'
WebUI.click(findTestObject('Page Encaissement-/Bouton Clear avec icon croix rouge'))

'Choisir l onglet MVola'
WebUI.click(findTestObject('Page Encaissement-/Onglet MVola'))

WebUI.delay(0.500)

'Entrer un numéro de téléphone non valide et un montant qui dépasse le montant voulu'
WebUI.sendKeys(findTestObject('Page Encaissement-/Champ Numero MVola'), ' 0030816')

WebUI.sendKeys(findTestObject('Page Encaissement-/Champ Montant'), Integer.toString(montantAPayer + 1))

'Vérifier qu un message d erreur apparaît en bas du champ'
WebUI.waitForElementPresent(findTestObject('Page Encaissement-/Message d erreur montant MVola'), 3)

WebUI.verifyElementText(findTestObject('Page Encaissement-/Message d erreur montant MVola'), 'Le montant MVola doit être inférieur ou égal au reste à payer.')

'Vérifier que le bouton Ajouter Paiement n est pas cliquable'
WebUI.verifyElementNotClickable(findTestObject('Page Encaissement-/Bouton Ajouter Paiement'))

'Supprimer le montant de la liste'
WebUI.clearText(findTestObject('Page Encaissement-/Champ Montant'))

'Saisir à nouveau un montant inférieur'
WebUI.sendKeys(findTestObject('Page Encaissement-/Champ Montant'), Integer.toString(montantAPayer - 1))

'Vérifier que le bouton Ajouter Paiement devient cliquable'
WebUI.verifyElementClickable(findTestObject('Page Encaissement-/Bouton Ajouter Paiement'))

'Ciquer sur le bouton Ajouter Paiement'
WebUI.click(findTestObject('Page Encaissement-/Bouton Ajouter Paiement'))

'Vérifier que le montant apparaît dans la liste des paiements'
WebUI.waitForElementPresent(findTestObject('Page Encaissement-/Mode de paiement dans la liste de paiement'), 0)

WebUI.verifyElementText(findTestObject('Page Encaissement-/Mode de paiement dans la liste de paiement'), 'Mvola (0340030816)')

WebUI.verifyElementText(findTestObject('Page Encaissement-/Montant dans la liste de paiement'), montantInsufisantMGA)

'Vérifier que le bouton Encaisser n est pas cliquable'
WebUI.verifyElementNotClickable(findTestObject('Page Encaissement-/Bouton Encaisser'))

'Supprimer le montant de la liste'
WebUI.click(findTestObject('Page Encaissement-/Bouton Clear avec icon croix rouge'))

'Choisir l onglet Chèques'
WebUI.click(findTestObject('Page Encaissement-/Onglet Cheques'))

'Remplir les champs correctement'
WebUI.sendKeys(findTestObject('Page Encaissement-/Champ Reference cheque'), '5465464')

WebUI.click(findTestObject('Page Encaissement-/Champ de selection Banque'))

WebUI.click(findTestObject('Page Encaissement-/Option Banque BMOI'))

'Saisir un montant supérieur au montant voulu'
WebUI.sendKeys(findTestObject('Page Encaissement-/Champ Montant'), Integer.toString(montantAPayer) + '.01' //ex: 1000.001
    )

'Vérifier qu un message d erreur apparait en bas du champ'
WebUI.waitForElementPresent(findTestObject('Page Encaissement-/Message d erreur montant Cheque'), 0)

WebUI.verifyElementText(findTestObject('Page Encaissement-/Message d erreur montant Cheque'), 'Le montant Chèque doit être inférieur ou égal au reste à payer.')

'Vérifier que le bouton Ajouter Paiement n est pas cliquable'
WebUI.verifyElementNotClickable(findTestObject('Page Encaissement-/Bouton Ajouter Paiement'), FailureHandling.CONTINUE_ON_FAILURE)

'Supprimer le montant de la liste des paiements puis ajouter un montant insuffisant'
WebUI.clearText(findTestObject('Page Encaissement-/Champ Montant'))

WebUI.sendKeys(findTestObject('Page Encaissement-/Champ Montant'), Integer.toString(montantAPayer - 1) + '.00' //ex: 999.00
    )

WebUI.click(findTestObject('Page Encaissement-/Bouton Ajouter Paiement'))

'Vérifier que le montant apparaît dans la liste des paiements'
WebUI.waitForElementPresent(findTestObject('Page Encaissement-/Mode de paiement dans la liste de paiement'), 0)

WebUI.verifyElementText(findTestObject('Page Encaissement-/Mode de paiement dans la liste de paiement'), 'Chèque (5465464)')

WebUI.verifyElementText(findTestObject('Page Encaissement-/Montant dans la liste de paiement'), montantInsufisantMGA)

'Vérifier que le bouton Encaisser n est pas cliquable'
WebUI.verifyElementNotClickable(findTestObject('Page Encaissement-/Bouton Encaisser'))

'Cliquer sur le bouton Modifier'
WebUI.click(findTestObject('Page Encaissement-/Bouton Modifier'))

'Cliquer sur le bouton Payer'
WebUI.verifyElementPresent(findTestObject('Page Vente POS-/Bouton Payer'), 0)

WebUI.click(findTestObject('Page Vente POS-/Bouton Payer'))

'Supprimer le montant de la liste'
WebUI.waitForElementPresent(findTestObject('Page Encaissement-/Bouton Ajouter Paiement'), 0)

WebUI.click(findTestObject('Page Encaissement-/Bouton Clear avec icon croix rouge'))

'Saisir un montant'
WebUI.sendKeys(findTestObject('Page Encaissement-/Champ Montant'), Integer.toString(montantAPayer))

'Cliquer sur le bouton Ajouter Paiement'
WebUI.click(findTestObject('Page Encaissement-/Bouton Ajouter Paiement'))

'Vérifier que le bouton Encaisser devient cliquable '
WebUI.verifyElementClickable(findTestObject('Page Encaissement-/Bouton Encaisser'))

'Cliquer sur le bouton Encaisser'
WebUI.click(findTestObject('Page Encaissement-/Bouton Encaisser'))

