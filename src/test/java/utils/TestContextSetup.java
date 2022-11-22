package utils;


import pages.PageObjectManager;
import stepDefinations.Hooks;

public class TestContextSetup {

    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;


    public TestContextSetup () throws Exception {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.webDriverManager());
        genericUtils = new GenericUtils(testBase.webDriverManager());
    }

}
