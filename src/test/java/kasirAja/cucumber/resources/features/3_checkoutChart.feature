Feature: Checkout barang di keranjang

  Background:
    Given User login
    And Add to chart

  Scenario: User checkout barang yang didalam chart/keranjang belanja
    Given User akses halaman chart
    When user klik tombol checkout
    And user menginputkan data
    And user klik tombol continue
    Then user klik tombol finish

