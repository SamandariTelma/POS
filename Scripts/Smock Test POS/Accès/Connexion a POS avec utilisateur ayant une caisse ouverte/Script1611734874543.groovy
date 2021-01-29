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

WebUI.callTestCase(findTestCase('Smock Test POS/00 - Called Tests Case/Ouvrir le navigateur'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.urlPreprod)

WebUI.waitForElementPresent(findTestObject('Page Login POS-/Champ de saisie identifiant'), 3)

'Vérifier que le bouton Connecter n est pas cliquable'
WebUI.verifyElementNotClickable(findTestObject('Page Login POS-/Bouton connecter'))

'Saisir le bon identifiant'
WebUI.setText(findTestObject('Page Login POS-/Champ de saisie identifiant'), GlobalVariable.loginUsernameOpenedCaisse)

'Saisir le mauvais mot de passe'
WebUI.setText(findTestObject('Page Login POS-/Champ de saisie mot de passe'), 'Abla4564654@+')

'Vérifier que le bouton Connecter devient cliquable'
WebUI.verifyElementClickable(findTestObject('Page Login POS-/Bouton connecter'))

'Cliquer sur le bouton connecter'
WebUI.click(findTestObject('Page Login POS-/Bouton connecter'))

WebUI.waitForAlert(3)

'Vérifier l apparition d un alerte'
WebUI.verifyAlertPresent(0)

'Vérifier le message affiché'
msg_echec_connexion = WebUI.getAlertText()

WebUI.verifyMatch(msg_echec_connexion, 'Login ou mot de passe incorrect', false)

WebUI.acceptAlert()

'Saisir le bon identifiant'
WebUI.setText(findTestObject('Page Login POS-/Champ de saisie identifiant'), GlobalVariable.loginUsernameOpenedCaisse)

'Saisir le bon mot de passe'
WebUI.setText(findTestObject('Page Login POS-/Champ de saisie mot de passe'), GlobalVariable.loginPasswordOpenedCaisse)

'Cliquer sur le bouton connecter'
WebUI.click(findTestObject('Page Login POS-/Bouton connecter'))

WebUI.delay(3)

WebUI.waitForAlert(5)

WebUI.verifyAlertPresent(5)

/*
Robot rb = new Robot()

rb.keyPress(KeyEvent.VK_ENTER)

WebUI.delay(2)

rb.keyPress(KeyEvent.VK_ENTER)

WebUI.delay(2)
*/
WebUI.acceptAlert()

WebUI.delay(2)

'Vérifier que l utilsateur est connecté et attérit sur la page d acceuil'
WebUI.comment('Vérification des éléments de la Home Page n ayant pas une caisse ouverte')

WebUI.waitForElementPresent(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Nouveau Panier'), 5)

'Vérifier l affichage du Bouton Ouvrir/Fermer TS'
WebUI.verifyElementPresent(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Nouveau Panier'), 3)

'Vérifier la présence du Bouton Mes Activités'
WebUI.verifyElementPresent(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton S3'), 0)

'Vérifier la présence du Bouton Mes résultats'
WebUI.verifyElementPresent(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton WebMSA'), 0)

'Vérifier la présence du Bouton Mes résultats'
WebUI.verifyElementPresent(findTestObject('Page d accueil POS-/Si caisse ouvert/Bouton Operation MVola'), 0)

'Vérifier que les éléments de la Home page ayant un caisse ouvert ne s affichent pas'
WebUI.comment('Vérification de l\'absence des éléments de la Home Page ayant une caisse ouverte')

WebUI.verifyElementNotPresent(findTestObject('Page d accueil POS-/Si caisse fermé/Bouton Caisse'), 0)

WebUI.verifyElementNotPresent(findTestObject('Page d accueil POS-/Si caisse fermé/Bouton Mes Activites'), 0)

WebUI.verifyElementNotPresent(findTestObject('Page d accueil POS-/Si caisse fermé/Bouton Mes resultats'), 0)

WebUI.verifyElementNotPresent(findTestObject('Page d accueil POS-/Si caisse fermé/Bouton Ouvrir Fermer TS'), 0)

'Cliquer sur le bouton Mon Compte'
WebUI.click(findTestObject('Header POS-/Bouton Mon Compte'))

WebUI.waitForElementVisible(findTestObject('Header POS-/Bouton Deconnexion'), 3)

'Cliquer sur le bouton Deconnexion'
WebUI.click(findTestObject('Header POS-/Bouton Deconnexion'), FailureHandling.CONTINUE_ON_FAILURE)

'Vérifier que l utilisateur est deconnecté et voit les éléments de la page login'
WebUI.waitForElementPresent(findTestObject('Page Login POS-/Bouton connecter'), 5)

WebUI.verifyElementPresent(findTestObject('Page Login POS-/Champ de saisie identifiant'), 0)

WebUI.verifyElementPresent(findTestObject('Page Login POS-/Champ de saisie mot de passe'), 0)

WebUI.verifyElementPresent(findTestObject('Page Login POS-/Bouton connecter'), 0)

WebUI.verifyElementNotClickable(findTestObject('Page Login POS-/Bouton connecter'))

