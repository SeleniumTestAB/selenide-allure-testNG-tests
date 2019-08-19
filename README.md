# selenide-allure-testNG-tests
UI tests with selenide, allure and testNG in JAVA

Modify run either by commandline options like:

`-Dselenide.browser=chrome`

or testNG suites like:

`mvn clean test -DsuiteXmlFile=testng.xml`

following setup: `mvn clean test allure:serve`
will continously serve allure report under your IP at standard allure port.