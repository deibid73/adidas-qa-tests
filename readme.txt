1.Test execution

    maven executable and java8 are required, this is a maven project that is run from the main directory of the project

    to run all tests in chrome:

    mvn clean test -Dcucumber.options="--tags @RUNNABLE"

    to run all tests in firefox:

    mvn clean test -Dcucumber.options="--tags @RUNNABLE" -Dbrowser=FF

    substitute "--tags @RUNNABLE" by "--tags @UI" or "--tags @API" to run specifically ui or api tests

2.Results Report
 
    After running the test build the test results report will be in:

	target/cucumber-html-reports/index.html

3.Known issues

    The test scenario "every component has at least analytics data" fails, as this condition is not fulfilled for all
    components in the API

4.Compatibility

    The framework has been tested in LINUX, WINDOWS10 and CHROME 56.0.2924.87 with 64 bits linux chromedriver 28.0 
    and 32 bits Windows chromedriver 34.0 / FIREFOX 49.0

