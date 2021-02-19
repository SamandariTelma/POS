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
import java.text.DecimalFormat as DecimalFormat
import java.text.DecimalFormatSymbols as DecimalFormatSymbols

//Declaration du montant a payer
String montant = GlobalVariable.prixSN //ex '1 000 000'

int montantAPayer = montant.replaceAll('\\s', '').toInteger( //devient 1000000
    )

String montantAPayerMGA = GlobalVariable.prixSN + ' MGA'

String montantInsufisantMGA = formatNumber(montantAPayer - 1, false) + ' MGA' //devient 999 999 MGA

'Se connecter à POS'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Connexion a POS'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Nouveau Panier'), 10)

'Cliquer sur Nouveau panier'
WebUI.click(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Nouveau Panier'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Vente produit'), 3)

'Cliquer sur Vente produit'
WebUI.click(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Vente produit'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Page Vente POS-/Champ de saisie numero Imei ICCID EAN SN'), 3)

//RECHERCHE SN
'Renseigner le numéro de SN dans le champ IMEI/ICCID/EAN/SN '
WebUI.sendKeys(findTestObject('Page Vente POS-/Champ de saisie numero Imei ICCID EAN SN'), GlobalVariable.numeroSN)

'Cliquer sur le bouton Rechercher'
WebUI.click(findTestObject('Page Vente POS-/Bouton Loupe'))

WebUI.delay(1)

'Vérifier que les détails affichés correspondent à ceux de l\'article recherché\r\nLibellé, Code, Code Sage, Type de sérialisation'
WebUI.verifyElementAttributeValue(findTestObject('Page Vente POS-/Champ Libelle'), 'value', GlobalVariable.libelleSN, 3)

WebUI.verifyElementAttributeValue(findTestObject('Page Vente POS-/Champ Code'), 'value', GlobalVariable.codeArticleSN, 0)

WebUI.verifyElementAttributeValue(findTestObject('Page Vente POS-/Champ Code Sage'), 'value', GlobalVariable.codeSageSN, 
    0)

WebUI.verifyElementText(findTestObject('Page Vente POS-/Champ Type de serialisation'), 'SN')

WebUI.delay(8)

'Cliquer sur le bouton Ajouter'
WebUI.click(findTestObject('Page Vente POS-/Bouton Ajouter'))

'Vérifier que l article apparaît dans le panier en cours, affichage de la designation et du montant'
WebUI.verifyElementText(findTestObject('Page Vente POS-/Panier en cours/Designation 1ere ligne'), ((GlobalVariable.libelleSN + 
    ' (') + GlobalVariable.numeroSN) + ')\nArticle')

WebUI.verifyElementText(findTestObject('Page Vente POS-/Panier en cours/Montant 1ere ligne'), GlobalVariable.prixSN + ' MGA')

'Payer en espece'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Payer en espèce'), [('montantAPayer') : montantAPayer
        , ('montantAPayerMGA') : montantAPayerMGA, ('montantInsufisantMGA') : montantInsufisantMGA], FailureHandling.CONTINUE_ON_FAILURE)

'Finaliser la vente'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Finaliser la vente'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'Editer la facture'
WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Editer facture'), [:], FailureHandling.CONTINUE_ON_FAILURE) //ex: 1000000 devient 1.000.000
//ex: 1.000.000 devient 1 000 000

String formatNumber(def number, boolean withDecimals = true) {
    String format = withDecimals ? '#,###.00' : '#,###'

    DecimalFormat formatter = new DecimalFormat(format)

    formatter.setDecimalFormatSymbols(new DecimalFormatSymbols(new Locale('es')))

    number = formatter.format(number)

    number = number.replaceAll('\\.', ' ')

    return number
}

