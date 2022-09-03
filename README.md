# MathCli

untuk belajara/tools matematika dasar

---

### Fitur utama saat ini

- mengkonversi Operasi logika

---

### How to use

- Download file excutable
- Install
- Set pada environment variable path dgn menambah path app disimpan

  > contoh :
  > C:/program files/mathcli/

- Cek di console atau cmds

  > ~$ mathcli --version
  >
  > ~$ mathcli -h atau mathcli --help

---

### Mengakses fitur

Fitur apapun diakses mulai dengan **mathcli** diikuti fitur

**logika cli**

- Opertor logika yg digunakan

  - [ & ] > dan
  - [ | ] > atau
  - [ - ] > implikasi
  - [ # ] > biimplikasi

- diakses dgn cara:
  - dipangil dengan **lgc**
  - memiliki parameter <-v <string> atau --value <string>>
    > contoh
    > ~$ mathcli lgc --value "(~p&q)|(p#q)"
