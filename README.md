# qa-web-challenge-LAHIRUAUTO
Recruitment test for Lahiru Vikasitha (DUB)

## Introduction

- BDD : The tester can manually run the BDDTestRunner class by right click on the class.
- TDD : The tester can manually run the TDDTestRunner class by right click on the devtest.xml file.
- The changes  has been pushed to origin/master branch in the given git repo. 

The test scenario was automated on Ryanair IBE (https://www.ryanair.com/ie/en/) using Selenium WebDrive / JAVA / TestNG / Cucumber and Maven.

I have built a hybrid framework that supports both BDD and TDD approaches to show off. Page object model design pattern was used within the framework.


### BDD Framework

Cucumber and Gherkin were utilized in this framework to execute the test suite written in selenium / JAVA. I have been using TestNG and several other dependencies in order to enhance the BDD framework with cucumber and to support test report generation and hookers implementation.

#### Features

createBooking2ADT1CHD.feature file is created on the Feature package to include the given scenario. The relevant test was maintained in the pipeline within the scenario.

#### Step Definition

stepDefination file was maintained in the stepDefination package and the file includes all the Steps for the given test scenario. This is where the selenium / JAVA code is executed as required for the test scenario. Test data will be provided to the test script as a data table from the feature file.
Also the Hooker are maintained in this package and it's responsible for executing blocks of codes at the start and end of the scenario. These hookers are utilized to manage the browser instance, take screen captures, Generate the extent report and email it to relevant users. Etc…

#### Test Runner

BDDTestRunner class is responsible for starting the test scenario execution. This class is extended to AbstractTestNGCucumberTests class to get the TestNG support. Also, the @CucumberOptions annotation was utilized here to relate the feature file and step definition file. Also, the plugin related to the extent reporter is specified.
The tester can manually run the BDDTestRunner class by right click on the class. It will execute the given test scenarios and the report will be emailed to the specified email address in below code location.

stepDefinations (package)  → Hook (class) → afterScenario (method) → TestReportReceiverMailAddress (parameter)

Also, the reports and screen captures will be available in the Extent_Reports directory as well.

#### Pages

Page package is used to maintain all the page objects related to the web pages in the application. All the web elements and related functions are maintained within this package. Page factory utility was used to enhance the accessibility of the page objects though out the automated tests. This package was shared for both BDD and TDD frameworks in this specific case.

#### POM

POM.xml was utilized to maintain all the required dependencies through the maven repository. This file was shared for both BDD and TDD framework in this specific case.

### TDD Framework

TestNG framework was utilized in this framework to execute the test suite written in selenium / JAVA. I have been using several other dependencies in order to enhance the TDD framework with TestNG to support test report generation. TestNG annotations were highly utilized to execute a set of codes whenever required also this framework can be extended as a  Data-driven framework with the help of TestNG data providers. I have been feeding data through the testdata.xls sheet located in the Test Data directory utilizing the TestNG data provider.
Also, the TestNG listeners were utilized to listen to the execution results and perform actions based on the results like taking screen captures, etc…

#### Base

Browser_Base class is included in the Base package. It is responsible for managing all browser-related generic operations like Invoking the browser, Maintaining user profiles, setting up the URL, and at the end, deleting cookies and closing the browser. Etc…

#### Pages

Refer to the Pages in the BDD framework.

#### Utilities

This package is responsible for maintaining all the required utility functions like generic methods, Data providers, Listeners, Mail senders, and Zippers. Etc...

#### Test Runner

TDDTestRunner class is responsible for maintaining all the test cases as separate methods in the class. @Test annotation is used to specify the test cases. Required test data will be fed to the test cases through the TestNG data provider in this step while executing the test case.

#### devtest.xml

This file is given by TestNG exclusively to manipulate the test cases defined in the TDDTestRunner. In this specific case, we have only one test cases which I have run at the method level in this file. Also, there are plenty of parameters defined in this file that are required at the time of the test execution. These can be referred to as global parameters for the tests.
The tester can manually run the TDDTestRunner class by right click on the devtest.xml file. It will execute the given test scenario and the report will be emailed to the specified email address in below code location.

Utility (Package) → Utils (Class) → endSuite (method) → TestReportReceiverMailAddress (parameter)
Also, the reports and screen captures will be available in the Extent_Reports and Screen_Capture_Result directories as well. 
