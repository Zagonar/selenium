$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("acceptanceTest.feature");
formatter.feature({
  "line": 1,
  "name": "acceptanceTest",
  "description": "",
  "id": "acceptancetest",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2488259706,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "check whether the sum of items in the bag is correct",
  "description": "",
  "id": "acceptancetest;check-whether-the-sum-of-items-in-the-bag-is-correct",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I navigate to \"https://www.yoox.com/it/uomo\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I go to item selection\u0027s page",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "I add two random prioducts to the bag",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I navigate to the bag",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I add one more instance of a product",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "The final price must be correct",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.yoox.com/it/uomo",
      "offset": 15
    }
  ],
  "location": "AcceptanceTestStepDefinition.java:21"
});
formatter.result({
  "duration": 2807489817,
  "status": "passed"
});
formatter.match({
  "location": "AcceptanceTestStepDefinition.java:26"
});
formatter.result({
  "duration": 3588203220,
  "status": "passed"
});
formatter.match({
  "location": "AcceptanceTestStepDefinition.java:36"
});
formatter.result({
  "duration": 9343633714,
  "status": "passed"
});
formatter.match({
  "location": "AcceptanceTestStepDefinition.java:46"
});
formatter.result({
  "duration": 1942110589,
  "status": "passed"
});
formatter.match({
  "location": "AcceptanceTestStepDefinition.java:52"
});
formatter.result({
  "duration": 1149952017,
  "status": "passed"
});
formatter.match({
  "location": "AcceptanceTestStepDefinition.java:62"
});
formatter.result({
  "duration": 174120294,
  "status": "passed"
});
formatter.after({
  "duration": 165689759,
  "status": "passed"
});
});