Feature: HepsiBurada Registering
@register
  Scenario: test
  Given Cliking all main page buttons
  When Clicking Rietumu Bank
  Then Check Rietumu Bank portfolio
  @register
  Scenario:Check make your order
    Given Open Services
    Then Press IT Audit
    When IT Audit opened make your order
  @register
  Scenario: Check all header links
    Given Open Services
    Given Open Clients
    Given Open References
    Given Open IT Experts
    Given Open Contacts
  @register
  Scenario:Check Contacts links
    Given Open Contact
    Given Press Facebook link
    Given Press Instagram link
    Given Press Linkedin link
  @register
  Scenario:Check all footer links
    Given Open Services footer
    Given Open Clients footer
    Given Open References footer
    Given Open IT Experts footer
    Given Open Contacts footer
  @register
  Scenario:Check Contact us sending question
    Given Open Contact
    Given Fill all forms
    Given Press send

    @register
  Scenario:Check Emails
    Given Open Outlook
    Given Fill login
    Given Fill password
    Given Delete message
