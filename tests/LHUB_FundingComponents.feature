# language: en


@FUNDING-COMPONENTS
Feature: Funding Components Test cases
# NOTE: ONLY THE FIRST SCENARIO USES PATTERN "LHUB-T101"

  @LHUB-T101 @TestCaseId:LHUB-T101 @PRIORITY:1 @SMOKE @REGRESSION
  Scenario Outline: Create new Funding Component with new steps (USING PATTERNS)
    # Given LOGIN: Login To LHUB with following details "${env.url}" "${env.username}" and "${env.pwd}"
#    Given LOGIN: Login To LHUB "http://www.google.com"
    When LOGIN: Login To LHUB "asdasdasd"
    Given LOGIN: Login To LHUB "asdasdasd"

#    And: "HOME": Verify-Partial-Page-Title Text:"Dashboard |"
#    And: "HOME": Verify-Page-Title Text:"Dashboard | LHUB Admin Workbench"
#    And: "HOME": Verify-Page-Header-And-Partial-Page-Title Header-Text:"Dashboard" Title-Text:"Dashboard | LHUB"
#    And: "HOME": Verify-Page-Header-And-Page-Title Header-Text:"Dashboard" Title-Text:"Dashboard | LHUB Admin Workbench"
#    And: Funding Components Form: Fill -Prerequisite- section with "<code>","<desc>"
#    And: Funding Components Form: Fill -Criteria & rates- section with "<code>","<desc>"
#    And: Funding Components Create: Save and Confirm
#    Step: I wait for "10" seconds

    Examples: {'dataFile':'resources/data/lhub_fund_comp_data.csv', 'filter':'_ID==\"LHUB-T101\"'}

  @LHUB-T001 @TestCaseId:LHUB-T001 @PRIORITY:1 @SMOKE @REGRESSION @--OLD--
  Scenario Outline: Create new Funding Component
  Step: Login-Page: I login to LHUB with following details "${env.url}"
  Result: "Funding-Page": I verify I'm in "Funding" home page
  Step: Funding-Page: I navigate to Funding component
  Result: "FundingComp-Page": I verify I'm in "Funding Component" page
  Step: "FundingComp-Page": Menu: I click on "Create" button
  Result: "FundingCompCreate-Page": I verify I'm in "Funding Component Create" page
  Step: FundingCompCreate-Page: I fill following details "<code>","<desc>","<billing_name>","<gl_number>","<payment_mode>","<mandatory_supporting_documents>","<gst_applicable>","<supporting_documents>","<prerequisite_desc>","<prerequisite_sql_mode>","<prerequisite_formula>","<criteria_desc>","<criteria_sql_mode>","<criteria_formula>","<rate_sql_mode>","<rate_formula>"
  #    Result:

    Examples: {'dataFile':'resources/data/lhub_fund_comp_data.csv', 'filter':'_ID==\"LHUB-T001\" and _STATUS==\"yes\"'}

  @LHUB-T001 @TestCaseId:LHUB-T001 @PRIORITY:1 @SMOKE @REGRESSION @--OLD--
  Scenario Outline: Create new Funding Component
  Step: Login-Page: I login to LHUB with following details "${env.url}"
  Result: I verify I'm in "Funding" page
  Step: Funding-Page: I navigate to "Funding components" page
  Result: I verify I'm in "Funding/Funding Components" page
  Step: Menu: I click on "Create" button
  Result: I verify I'm in "Funding Components/Create" page
  Step: FundingComp "Create": I fill in Detail with following data "<fcCode>","<fcDescription>","<fcBillingName>","<fcPaymentModeOption>","<fcPaymentMode>","<fcGLNumber>","<mandatorySupportingDocument>","<fundingSupportingDocumentToAdd>","<GSTApplicable>","<gstCalculationBasisDefaultValue>"
  Step: FundingComp "Create": I fill in Prerequisite with data following "<prerequisiteDescription>","<prerequisiteSQLMode>","<prerequisiteData>"
  Step: FundingComp "Create": I fill in Criteria And Rate with data following "<criteriaData>"
  Step:  Footer: I click on "Save & confirm" button
  Result: I verify I'm in "Funding Components" page
  Result: I verify a Funding Component create successfully

    Examples: {'dataFile':'resources/data/FundingComponent.xlsx','sheetName':'FundingComponent', 'filter':'_ID==\"FC-01-01\"'}

  @LHUB-T002 @TestCaseId:LHUB-T001 @PRIORITY:1 @SMOKE @REGRESSION @--OLD--
  Scenario Outline: Edit Funding Component
  Step: Login-Page: I login to LHUB with following details "${env.url}"
  Result: I verify I'm in "Funding" page
  Step: Funding-Page: I navigate to "Funding components" page
  Result: I verify I'm in "Funding/Funding Component" page
  Step: I select an Item with name
  Step: Menu: I click on "Edit" button
  Result: I verify I'm in "Funding/Funding Components/Edit" page
  Step: FundingComp "Edit": I verify information is shown correctly with following data "<fcCode>","<fcDescription>","<fcBillingName>","<fcPaymentModeOption>","<fcPaymentMode>","<fcGLNumber>","<mandatorySupportingDocument>","<fundingSupportingDocumentToAdd>","<GSTApplicable>","<gstCalculationBasisDefaultValue>", "<prerequisiteDescription>","<prerequisiteSQLMode>","<prerequisiteData>", "<criteriaData>"
  Step: FundingComp "Edit": I fill in Detail with following data "<fcDescription>","<fcPaymentModeOption>","<fcPaymentMode>","<fcGLNumber>","<mandatorySupportingDocument>","<fundingSupportingDocumentToAdd>","<GSTApplicable>","<gstCalculationBasisDefaultValue>"
  Step: FundingComp "Edit": I fill in Prerequisite with data following "<prerequisiteDescription>","<prerequisiteSQLMode>","<prerequisiteData>"
  Step: FundingComp "Edit": I fill in Criteria And Rate with data following "<criteriaEditData>"
  Step: Footer: I click on "Save & confirm" button
  Result: I verify I'm in "Funding Components" page

    Examples: {'dataFile':'resources/data/FundingComponent.xlsx','sheetName':'FundingComponent', 'filter':'_ID==\"FC-Edit\"'}

  @LHUB-T003 @TestCaseId:LHUB-T001 @PRIORITY:2 @--OLD--
  Scenario Outline: Check invalid case when create new Funding Component
  Step: Login-Page: I login to LHUB with following details "${env.url}"
  Result: I verify I'm in "Funding" page
  Step: Funding-Page: I navigate to "Funding component" page
  Result: I verify I'm in "Funding/Funding Components" page
  Step: Menu: I click on "Create" button
  Result: I verify I'm in "Funding/Funding Components/Create" page
  Step: Footer: I click on "Save as draft" button
  Result: I verify error message is shown for mandatory fields
  Step: I fill in Prerequisite with invalid data following "<prerequisiteSQLMode>","<invalidData>"
  Result: I verify error message is shown with invalid formula
  Step: I fill in Criteria with invalid data following "<criteriaSLQMode>","<invalidData>"
  Result: I verify error message is shown with invalid formula
  Step: I fill in Rate with invalid data following "<rateSLQMode>","<invalidData>"
  Result: I verify error message is shown with invalid formula

    Examples: {'dataFile':'resources/data/FundingComponent.xlsx','sheetName':'FundingComponent', 'filter':'_ID==\"FC-create-invalid\"'}

  @LHUB-T001 @TestCaseId:LHUB-T001 @PRIORITY:1 @SMOKE @REGRESSION @--OLD--
  Scenario Outline: Create new Funding Component
    Step: LOGIN: Login To LHUB with following details "${env.url}" "username" and "password"    // Page Specific step
    Result: "HOME": Wait-And-Verify-Page-Header Text:"Dashboard Notification"                   // Common Step
    Result: "HOME": Wait-And-Verify-Page-Title Text:"Dashboard Notification"                    // Common Step
    Result: "HOME": Wait-And-Verify-Page-Header-And-Title Header-Text:"Dashboard Notification" Title-Text:"Dashboard Notification | LHUB"   // Common Step
    Step: MAIN-NAV: Navigate-To "Funding" Home Page
    Result: "FUNDING-HOME": Wait-And-Verify-Page-Header Text:"Funding"
    Step: "FUNDING-HOME": Navigate-To "Funding Components" Page


  Step: Login-To-LHUB-With-Following-Details "${env.url}" "username" and "password"           // Page Specific step
  Result: Wait-And-Verify-Page-Header Text:"Dashboard Notification" in "Home" Page            // Common Step
  Result: Wait-And-Verify-Page-Title Text:"Dashboard Notification" in "Home" Page             // Common Step
  Result: Wait-And-Verify-Page-Header-And-Title Header-Text:"Dashboard Notification" Title-Text:"Dashboard Notification | LHUB"  in "Home" Page   // Common Step
  Step: Main-Left-Nav: Click-On-Menu Text:"Funding"                                                           // Common Step
  Result: Wait-And-Verify-Page-Header Text:"Dashboard Notification" in "Funding Home" Page    // Common Step
  Step: Navigate-To "Funding Components" Page                                                 // Common Step
  Result: Wait-And-Verify-Page-Header Text:"Funding Components" in "Funding Components" Page
  Step: Top-Nav: Click-On-Button Text:"Create"
  # Step: Top-Nav: Select-Table-Row-And-Click-On-Button Row:"2" Button:"Activity Log"


  Given D36
