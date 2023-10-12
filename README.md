To run all tests ``mvn clean test``

To run one specific test `` mvn clean test-Dtest={classname}#{testname}
``

To generate report ``mvn allure:report``

Options for test run 
1. ``-Denv``, default value ``local``
2. ``-Dlocale``, default value ``en``
3. ``-Dbrowser``, default value ``chrome``
4. ``-Dheadless``, default value ``true``