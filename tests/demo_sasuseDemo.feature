@DEMO
Feature: This is a test feature file

  @DEMO-TST-01
    @TestCaseId:DEMO-TST-01
    @PRIORITY:1
    @SIT @UAT2 @SMOKE @REGRESSION
  Scenario: Test scenario using Globals, static data & Environment Variable (without writing any Step definitions)
      # ${env.url} - Environment variable is wrapped with "${" and "}"
      # Static data "secret_sauce" is added directly
      # Locator name is mentioned as "loc.login.input.password"
    Step: I open the web browser with "${env.url}"
    And: I fill "standard_user" into "loc.demo.login.input.username"
    And: I fill "secret_sauce" into "loc.demo.login.input.password"
    And: I click on "loc.demo.login.button.login"
    Result: I assert text present in page "Swag Labs"
    And: I assert "loc.demo.home.text.logo" text is "Swag Labs"


  @DEMO-TST-02
    @TestCaseId:DEMO-TST-02
    @PRIORITY:2
  Scenario Outline: Test scenario using Test Data directly, Environment Variable, Encrypted Password & Globals (without writing any Step definitions)
  Step: I open the web browser with "${env.url}"
  And: I fill "${username}" into "loc.demo.login.input.username"
  And: I fill "<password>" into "loc.demo.login.input.password"
  And: I click on "loc.demo.login.button.login"
  Result: I assert text present in page "Products"
  And: I take screenshot
#  And: Utils: Encrypt password "secret_sauce"
    # NOTE: Last step "Utils: Encrypt password "secret_sauce" can be used to get the generated encrypted password in comments / run log.
    Examples:
    | username      | password                       |
    | standard_user | pwd.YzJWamNtVjBYM05oZFdObA==   |
    | standard_user | pwd.YzJWamNtVjBYM05oZFdObA==   |


  @DEMO-TST-03
    @TestCaseId:DEMO-TST-03
    @PRIORITY:3
    @SIT @UAT @SMOKE @REGRESSION @LICENSE-A
  Scenario Outline: Test scenario using Test Data file, Environment Variable & Globals (without writing any Step definitions)
    # Login Page
  Step: I open the web browser with "${env.url}"
  And: I fill "<username>" into "loc.demo.login.input.username"
  And: I fill "<password>" into "loc.demo.login.input.password"
  And: I click on "loc.demo.login.button.login"
  Result: I assert text present in page "Swag Labs"
  And: I take screenshot

  Examples: {'dataFile':'resources/data/demo_test_data.csv', 'filter':'_ID==\"DEMO-TST-03\" and _ENV==\"${env.code}\" and _STATUS==\"yes\"'}
#    Examples: {'dataFile':'resources/data/testdata.csv', 'filter':'_ID==\"TST_1\"'}
#    Examples: {'dataFile':'resources/data/demo_test_data.xlsx','sheetName':'DEMO', 'filter':'_ID==\"DEMO-TST-03\" and _STATUS==\"yes\" and _INSTANCE==1'}
#    Examples: {'dataFile':'resources/data/demo_test_data.xlsx','sheetName':'${env.code}', 'filter':'_ID==\"DEMO-TST-03\" and _INSTANCE==1 and _STATUS==\"yes\"'}
#    Examples: {'dataFile':'resources/data/demo_test_data.xlsx','sheetName':'DEMO', 'filter':'_ID==\"DEMO-TST-03\" and _ENV==\"${env.code}\" and _INSTANCE==1 and _STATUS==\"yes\"'}

  @DEMO-TST-04
    @TestCaseId:DEMO-TST-04
    @PRIORITY:4
    @SIT
    @dependent:TST-03
    @SMOKE
  Scenario Outline: Test scenario using Step Definition
  Step: Login: I login to SauseDemo using "${env.url}", "<username>" and "<password>"
  Result: Home: I verify I'm in homepage
#  Step: TEST: I test "<cardYear>"
#    Examples: {'dataFile':'resources/data/demo_test_data.xlsx','sheetName':'${env.code}', 'filter':'_ID==\"TST-04\" and _STATUS==\"yes\" and _INSTANCE==1'}
    Examples: {'dataFile':'resources/data/demo_test_data.csv', 'filter':'_ID==\"DEMO-TST-04\" and _STATUS==\"yes\"'}


  @DEMO-TST-05
    @TestCaseId:DEMO-TST-05
    @PRIORITY:5
  Scenario Outline: Test scenario using Actions (without writing any Step definitions)
    Step: "Login": "I login to SauseDemo" -action/s:"{open} the {browser} with {${env.url}},{input}{<username>}{in}{Username},{input}{<password>}{in}{Password},{click}{Login}{button}"
    Result: "Home": "I verify I'm in homepage" -action/s:"{verify}{text}{Products}{present}{in}{page}"
    Examples: {'dataFile':'resources/data/demo_test_data.csv', 'filter':'_ID==\"DEMO-TST-05\" and _STATUS==\"yes\"'}

#      Examples: {'dataFile':'resources/data/demo_test_data.xlsx','sheetName':'${env.code}', 'filter':'_ID==\"DEMO-TST-05\" and _STATUS==\"yes\"  and _USER==\"${env.user}\" and _INSTANCE==1'}



  @TRAINING-01
  Scenario: Test scenario to login to Sause Demo website
  Step: I open the web browser with "${env.url}"
   And: I wait for page to load
   And: I input "${env.username}" into "loc.training.login.input.username"
   And: I input "secret_sauce" into "loc.training.login.input.password"
   And: I click on "loc.login.button.login"
   And: I wait for page to load
  Result: I assert text present in page "Products"
#   And: I wait for "10" seconds





  @DEMO-TST-04-1
    @TestCaseId:DEMO-TST-04-1
    @PRIORITY:6
    @SIT
    @SMOKE
  Scenario Outline: Test scenario using Step Definition with new Web
    Given I login to SauseDemo using "${env.url}", "<username>" and "<password>"
    Then I Verify "Homepage" page header text is "Products"
    Then I Verify "Homepage" page title text is "Swag Labs"
    * I wait for "5" seconds

#    Examples: {'dataFile':'resources/data/demo_test_data.xlsx','sheetName':'${env.code}', 'filter':'_ID==\"TST-04\" and _STATUS==\"yes\" and _INSTANCE==1'}
    Examples: {'dataFile':'resources/data/demo_test_data.csv', 'filter':'_ID==\"DEMO-TST-04\" and _STATUS==\"yes\"'}



