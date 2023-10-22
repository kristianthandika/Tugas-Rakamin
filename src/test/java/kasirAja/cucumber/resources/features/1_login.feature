#noinspection CucumberUndefinedStep
Feature: Login

  Scenario: User Login menggunakan kredensial yang valid
    Given login page
    When input valid username
    And input valid password
    And Kemudian user klik tombol login
    Then User berhasil login masuk ke dashboard

  Scenario: User Login menggunakan kredensial yang tidak valid
    Given login page
    When input valid username
    And input password invalid
    And Kemudian user klik tombol login
    Then Tampil error message
