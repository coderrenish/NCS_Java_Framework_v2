@API
Feature: API Test

  @API-T001
    @TestCaseId:API-T001
    @REGRESSION
  Scenario: Testing api
  Step: I request api "api.reqResIn.get.getUsers"
  Step: I request api "api.reqResIn.get.getUsers" with data "{'name':'Renish','address':'23,Sample address, Brisbane, QLD'}"
  Result: I assert api response status code is "200"
  And: I assert api response has header "Content-Type"
  And: I assert api response has header "Content-Type" with value "application/json; charset=utf-8"