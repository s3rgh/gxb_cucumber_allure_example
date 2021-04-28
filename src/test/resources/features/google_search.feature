Feature: Тестовое задание №2
  Scenario: Поиск искомой строки в Google
    Given   Open start page "https://google.com"
    When    Page is opened
    And     Navigate to search line
    And     Enter your data "купить кофемашину bork c804"
    Then    Success reg message is displayed