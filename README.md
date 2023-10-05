To run all tests ``mvn clean test -Denv=DEV -Dlocale=EN``

To run one specific test `` mvn clean test -Denv=DEV -Dlocale=EN -Dtest={classname}#{testname}
``

To generate report ``mvn allure:report``