# Character Manager

## 1. Deskripsi Proyek

Character Manager adalah aplikasi sederhana berbasis Java yang digunakan untuk mengelola data karakter. Proyek ini menerapkan konsep Object-Oriented Programming (OOP), enkapsulasi, enum, ArrayList, dan Java Swing untuk menampilkan data karakter dalam bentuk GUI (Graphical User Interface).

Aplikasi ini memungkinkan pengguna melihat daftar karakter beserta informasi nama, tipe, level, HP, attack power, dan mana.

## 2. Struktur Folder

```text
CharacterManager/
├── README.md
└── src/
    ├── Main.java
    ├── model/
    │   ├── Character.java
    │   ├── CharacterType.java
    │   └── CharacterManager.java
    └── view/
        └── MainWindow.java
```

## 3. Teknologi yang Digunakan

- Bahasa pemrograman: Java
- GUI: Java Swing
- Koleksi data: ArrayList
- Konsep pemrograman: Object-Oriented Programming (OOP)
- IDE: Visual Studio Code

## 4. Fitur Program

1. Menambahkan karakter baru.
2. Menolak penambahan karakter dengan nama duplikat.
3. Mencari karakter berdasarkan nama.
4. Menghapus karakter berdasarkan nama.
5. Menghitung jumlah karakter.
6. Mengambil daftar karakter dalam bentuk salinan ArrayList.
7. Mencari karakter berdasarkan tipe.
8. Menghitung rata-rata level karakter.
9. Mencari karakter dengan attack power tertinggi menggunakan `findStrongest()`.
10. Menghitung jumlah karakter berdasarkan tipe menggunakan `countByType()`.
11. Menampilkan daftar karakter secara dinamis menggunakan Java Swing.

## 5. Penjelasan Class

### Character.java

Class `Character` digunakan untuk menyimpan informasi setiap karakter, yaitu ID, nama, tipe, level, HP, attack power, dan mana.

Atribut dibuat menggunakan modifier `private` untuk menerapkan enkapsulasi. Akses terhadap atribut dilakukan melalui getter dan setter.

Method `equals()` membandingkan karakter berdasarkan nama tanpa membedakan huruf besar dan kecil. Method `toString()` digunakan untuk menghasilkan informasi karakter yang dapat ditampilkan pada GUI.

### CharacterType.java

`CharacterType` merupakan enum yang menentukan tipe karakter. Tipe yang tersedia adalah:

- WARRIOR
- MAGE
- ARCHER
- HEALER

Penggunaan enum membuat tipe karakter lebih terstruktur dan menghindari penulisan tipe secara sembarangan.

### CharacterManager.java

Class `CharacterManager` bertanggung jawab mengelola kumpulan karakter menggunakan `ArrayList`.

Class ini menyediakan method untuk menambah, mencari, menghapus, menghitung, dan menampilkan karakter. Penambahan nama duplikat ditolak agar setiap nama karakter tetap unik.

Method `getAllCharacters()` mengembalikan salinan `ArrayList`, bukan daftar internal yang asli. Hal ini membantu menjaga enkapsulasi dan mencegah perubahan langsung pada struktur daftar internal.

### MainWindow.java

Class `MainWindow` berada di package `view` dan merupakan turunan dari `JFrame`.

Class ini menampilkan jendela aplikasi menggunakan Java Swing. Data karakter ditampilkan secara dinamis menggunakan perulangan `for`, sehingga jumlah komponen tampilan mengikuti jumlah karakter yang tersedia.

Tombol Refresh Data digunakan untuk memperbarui tampilan daftar karakter.

### Main.java

Class `Main` merupakan titik awal program. Method `main()` membuat objek `CharacterManager`, menambahkan data karakter contoh, dan membuka jendela aplikasi.

Pembuatan GUI dilakukan menggunakan `SwingUtilities.invokeLater()` agar kode pembuatan dan penampilan GUI dijalankan pada Event Dispatch Thread (EDT), sesuai praktik yang direkomendasikan untuk Swing.

## 6. Penjelasan Method Baru

### findStrongest()

Method `findStrongest()` digunakan untuk mencari karakter dengan nilai attack power tertinggi.

Method memeriksa setiap karakter dalam daftar dan membandingkan attack power-nya. Karakter dengan nilai tertinggi dikembalikan sebagai hasil.

Jika daftar karakter kosong, method mengembalikan `null`.

### countByType(CharacterType type)

Method `countByType()` digunakan untuk menghitung jumlah karakter yang memiliki tipe tertentu.

Method ini melakukan perulangan terhadap daftar karakter, kemudian menambahkan penghitung setiap kali tipe karakter sesuai dengan tipe yang dicari.

## 7. Alasan Menjaga Enkapsulasi

Enkapsulasi digunakan untuk melindungi data