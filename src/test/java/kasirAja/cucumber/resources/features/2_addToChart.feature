Feature: Menambahkan barang ke Chart

  Scenario: User menambahkan barang ke dalam keranjang belanja
    Given user berhasil login
    When user akses halaman product
    And user klik tombol add to chart
    Then barang berhasil masuk keranjang