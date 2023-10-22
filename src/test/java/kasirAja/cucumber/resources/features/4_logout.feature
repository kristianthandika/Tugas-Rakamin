Feature: Logout

  Scenario: User Logout
    Given user sudah login
    When user akses sidebar menu
    And user klik tombol Logout
    Then User berhasil logout