1.Test execution

    maven executable and java8 are required, this is a maven project that is run from the main directory of the project

    to run all tests in chrome:
    mvn clean test -Dcucumber.options="--tags @RUNNABLE"

    to run all tests in firefox:
    mvn clean test -Dcucumber.options="--tags @RUNNABLE" -Dbrowser=FF

    substitute "--tags @RUNNABLE" by "--tags @UI" or "--tags @API" to run specifically ui or api tests

2.Known issues

    The test scenario "every component has at least analytics data" fails, as this condition is not fulfilled for all
    components in the API

    The framework has been tested in LINUX and CHROME 56.0.2924.87 with 64 bits linux chromedriver 28.0 / FIREFOX 49.0
    Has code for support of windows, but has not been tested because of lack of availability of a suitable environment