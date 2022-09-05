# MathCli

untuk belajara/tools matematika dasar

### Fitur utama saat ini

- [x] mengkonversi Operasi logika
- [ ] mencari akar akar persamaan kuadrat
- [ ] generate bilangan prima
<!-- - [ ]  -->

---

## How to use

- [Download](https://github.com/Muammarzaki/MathCli/releases) file excutable
- Install
- [Set environment variable](https://docs.oracle.com/en/database/oracle/machine-learning/oml4r/1.5.1/oread/creating-and-modifying-environment-variables-on-windows.html#GUID-DD6F9982-60D5-48F6-8270-A27EC53807D0) path dgn menambah path app disimpan

  `exp: C:/program files/mathcli/ `

- Cek di console atau cmd

```
   ~$ mathcli --version

   ~$ mathcli -h atau mathcli --help
```

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
  - memiliki parameter [ -v "string" atau --value "string" ]
  ```bash
    ~$ mathcli lgc --value "(~p&q)|(p#q)"
  ```

---

## Note

> :bulb: **tip:** untuk uninstall disarankan dgn hati hati jangan asal hapus file
