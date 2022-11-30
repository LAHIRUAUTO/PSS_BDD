# qa-web-challenge-LAHIRUAUTO
Recruitment test for Lahiru Vikasitha (DUB)

## Introduction

- The tester can manually run the TestRunner.java class by right click on the class.
- The changes  has been pushed to origin/master branch in the given git repo.
- When run the test at first time the program tries to use existing google chrome user profile in the browser. below account can be used.
  - Email - Ryanairlahiru@gmail.com
  - Password - Ryanair@123
- Explicit wait time out is set to 30 seconds. Please be patient on some test steps. 
- Card details and passenger seats details provided through the Testdata.xls file. In case the selected seat is not available at the moment please update the Testdata.xls file with an available seats. 

The test scenario was automated on Ryanair IBE (https://www.ryanair.com/ie/en/) using Selenium WebDrive / JAVA / TestNG / Cucumber / Gherkin and Maven.

I have built the framework that supports BDD approaches. Page object model design pattern was used within the framework.


### BDD Framework

Cucumber and Gherkin were utilized in this framework to execute the test suite written in selenium / JAVA. I have been using TestNG and several other dependencies in order to enhance the BDD framework with cucumber and to support test report generation and hookers implementation.

#### Features

createBooking2ADT1CHD.feature file is created on the Feature package to include the given scenario. The relevant test data was maintained in the pipeline within the scenario and also the credit card details related test data were fed from the external Testdata.xls file with the help of jxl library.

#### Step Definition

stepDefination files was maintained in the stepDefination package and the file includes all the Steps for the given test scenario. There are 2 step definition files maintained for IBE flow and payment confirmation process. This is where the selenium / JAVA code is executed as required for the test scenario. Test data will be provided to the test script as a data table from the feature file.
Also the Hooker are maintained in this package and it's responsible for executing blocks of codes at the start and end of the scenario. take screen captures, Attach screen captures to the extent report and email it to relevant users. Etc…

#### Test Runner

TestRunner class is responsible for starting the test scenario execution. This class is extended to AbstractTestNGCucumberTests class to get the TestNG support. Also, the @CucumberOptions annotation was utilized here to relate the feature file and step definition file. Also, the plugin related to the extent reporter is specified.
The tester can manually run the TestRunner class by right click on the class. It will execute the given test scenarios and the report will be emailed to the specified email address in below code location.

Also, There is a FailureReRunner implemented to re run the failure test scenarios if any. FailureReRunner.java class can be executed manually by right click on the class and it will executed only the failed scenario. 

stepDefinations (package)  → Hook (class) → afterScenario (method) → TestReportReceiverMailAddress (parameter)

Also, the reports and screen captures will be available in the Extent_Reports directory as well.

#### Pages

Page package is used to maintain all the page objects related to the web pages in the application. All the web elements and related functions are maintained within this package. Page factory utility was used to enhance the accessibility of the page objects though out the automated tests. PageObjectManager.java class was utilized to initiate the webelements while executing the script.

#### Utils

This package is responsible for maintaining all the generic utilities and common functionalities across the project like, Browser initiations, File readers, Constructor injections, Email sevrvice, Zip util and general selenium functions Etc...

#### POM

POM.xml was utilized to maintain all the required dependencies through the maven repository. 

#### Test Data

Testdata.xls file includes credit card details and passenger seat details. these information will be fed to the test script with the help of jxl library. 