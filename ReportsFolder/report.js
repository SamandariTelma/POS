$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Include/features/My feature.feature");
formatter.feature({
  "name": "Login POS",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Login with a valid credential",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "I am on the Login Page",
  "keyword": "Given "
});
formatter.step({
  "name": "I send username \u003cusername\u003e and password \u003cpassword\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "I click on the submit button",
  "keyword": "And "
});
formatter.step({
  "name": "I should be connected",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ]
    },
    {
      "cells": [
        "postest",
        "P@ssWord@2020*"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Login with a valid credential",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "I am on the Login Page",
  "keyword": "Given "
});
formatter.match({
  "location": "MyStepDefinition.I_am_on_the_Login_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I send username postest and password P@ssWord@2020*",
  "keyword": "When "
});
formatter.match({
  "location": "MyStepDefinition.I_send_username_and_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on the submit button",
  "keyword": "And "
});
formatter.match({
  "location": "MyStepDefinition.I_click_on_the_submit_button()"
});
formatter.result({
  "error_message": "com.kms.katalon.core.exception.StepFailedException: Unable to click on object\r\n\tat com.kms.katalon.core.webui.keyword.internal.WebUIKeywordMain.stepFailed(WebUIKeywordMain.groovy:64)\r\n\tat com.kms.katalon.core.webui.keyword.internal.WebUIKeywordMain.runKeyword(WebUIKeywordMain.groovy:26)\r\n\tat com.kms.katalon.core.webui.keyword.builtin.ClickKeyword.click(ClickKeyword.groovy:76)\r\n\tat com.kms.katalon.core.webui.keyword.builtin.ClickKeyword.execute(ClickKeyword.groovy:43)\r\n\tat com.kms.katalon.core.keyword.internal.KeywordExecutor.executeKeywordForPlatform(KeywordExecutor.groovy:73)\r\n\tat com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.click(WebUiBuiltInKeywords.groovy:605)\r\n\tat com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords$click$2.call(Unknown Source)\r\n\tat login.MyStepDefinition.I_click_on_the_submit_button(MyStepDefinition.groovy:65)\r\n\tat ✽.I click on the submit button(Include/features/My feature.feature:26)\r\nCaused by: java.lang.IllegalArgumentException: Object is null\r\n\tat com.kms.katalon.core.helper.KeywordHelper.checkTestObjectParameter(KeywordHelper.java:33)\r\n\tat com.kms.katalon.core.webui.keyword.builtin.ClickKeyword$_click_closure1.doCall(ClickKeyword.groovy:65)\r\n\tat com.kms.katalon.core.webui.keyword.builtin.ClickKeyword$_click_closure1.call(ClickKeyword.groovy)\r\n\tat com.kms.katalon.core.webui.keyword.internal.WebUIKeywordMain.runKeyword(WebUIKeywordMain.groovy:20)\r\n\tat com.kms.katalon.core.webui.keyword.builtin.ClickKeyword.click(ClickKeyword.groovy:76)\r\n\tat com.kms.katalon.core.webui.keyword.builtin.ClickKeyword.execute(ClickKeyword.groovy:43)\r\n\tat com.kms.katalon.core.keyword.internal.KeywordExecutor.executeKeywordForPlatform(KeywordExecutor.groovy:73)\r\n\tat com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.click(WebUiBuiltInKeywords.groovy:605)\r\n\tat com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords$click$2.call(Unknown Source)\r\n\tat login.MyStepDefinition.I_click_on_the_submit_button(MyStepDefinition.groovy:65)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:48)\r\n\tat cucumber.runtime.PickleStepDefinitionMatch.runStep(PickleStepDefinitionMatch.java:50)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:55)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:42)\r\n\tat cucumber.runner.PickleStepTestStep.run(PickleStepTestStep.java:53)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:47)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:44)\r\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:140)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:98)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:55)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat cucumber.api.junit.Cucumber$1.evaluate(Cucumber.java:107)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:115)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:105)\r\n\tat com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords$_runWithCucumberRunner_closure5.doCall(CucumberBuiltinKeywords.groovy:430)\r\n\tat com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords$_runWithCucumberRunner_closure5.doCall(CucumberBuiltinKeywords.groovy)\r\n\tat com.kms.katalon.core.keyword.internal.KeywordMain.runKeyword(KeywordMain.groovy:68)\r\n\tat com.kms.katalon.core.keyword.internal.KeywordMain$runKeyword.call(Unknown Source)\r\n\tat com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords.runWithCucumberRunner(CucumberBuiltinKeywords.groovy:427)\r\n\tat com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords$runWithCucumberRunner.call(Unknown Source)\r\n\tat New Test Case.run(New Test Case:18)\r\n\tat com.kms.katalon.core.main.ScriptEngine.run(ScriptEngine.java:194)\r\n\tat com.kms.katalon.core.main.ScriptEngine.runScriptAsRawText(ScriptEngine.java:119)\r\n\tat com.kms.katalon.core.main.TestCaseExecutor.runScript(TestCaseExecutor.java:339)\r\n\tat com.kms.katalon.core.main.TestCaseExecutor.doExecute(TestCaseExecutor.java:330)\r\n\tat com.kms.katalon.core.main.TestCaseExecutor.processExecutionPhase(TestCaseExecutor.java:309)\r\n\tat com.kms.katalon.core.main.TestCaseExecutor.accessMainPhase(TestCaseExecutor.java:301)\r\n\tat com.kms.katalon.core.main.TestCaseExecutor.execute(TestCaseExecutor.java:235)\r\n\tat com.kms.katalon.core.main.TestSuiteExecutor.accessTestCaseMainPhase(TestSuiteExecutor.java:191)\r\n\tat com.kms.katalon.core.main.TestSuiteExecutor.accessTestSuiteMainPhase(TestSuiteExecutor.java:141)\r\n\tat com.kms.katalon.core.main.TestSuiteExecutor.execute(TestSuiteExecutor.java:90)\r\n\tat com.kms.katalon.core.main.TestCaseMain.startTestSuite(TestCaseMain.java:157)\r\n\tat com.kms.katalon.core.main.TestCaseMain$startTestSuite$0.call(Unknown Source)\r\n\tat TempTestSuite1612256236476.run(TempTestSuite1612256236476.groovy:39)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "I should be connected",
  "keyword": "Then "
});
formatter.match({
  "location": "MyStepDefinition.I_sould_be_connected()"
});
formatter.result({
  "status": "skipped"
});
});