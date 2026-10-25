# tugas1-fittrack 
Remedial

Muhammad Fahril Khalifi
250810701100002
Praktikum Pemrograman Berorientasi Objek

# deskripsi singkat
FitTrack adalah gym kecil dengan sekitar 150 member aktif yang selama ini mencatat data member di buku tulis. Program ini adalah langkah awal digitalisasi pendataan member berbasis Java yang berjalan di satu komputer tanpa database. Fokusnya memastikan data yang masuk selalu valid, misalnya nomor telepon yang salah format tidak lagi lolos tersimpan.

# fitur utama:
- Menyimpan data member: nama, nomor telepon, tanggal daftar, dan jenis paket.
- Menolak nama yang kosong atau hanya berisi spasi.
- Menolak nomor telepon yang tidak diawali 0, berisi bukan angka, atau kurang dari 10 digit.
- Hanya menerima paket Basic, Premium, atau VIP.
- Menampilkan pesan yang menjelaskan alasan ketika data ditolak, dan data lama tetap aman.
- Tetap bisa membuat member walaupun ada data yang salah, dengan nilai default yang aman.
- Menampilkan seluruh daftar member dalam format yang rapi dan berlabel.

## konsep OOP yang diterapkan

Project **FitTrack** menerapkan beberapa konsep dasar *Object-Oriented Programming* (OOP) menggunakan Java.

| Konsep | Implementasi | Penjelasan |
|--------|---------------|------------|
| **Class & Object** | `Member`, `TesFitTrack` | Class `Member` digunakan sebagai blueprint untuk membuat objek yang menyimpan data setiap member. |
| **Encapsulation** | Atribut `private`, getter, dan setter | Melindungi atribut dari akses langsung serta mengontrol perubahan data melalui method. |
| **Validasi Data** | `setNama()`, `setNoTelepon()`, `setTanggalDaftar()`, `setJenisPaket()` | Memastikan data yang dimasukkan sesuai aturan. Validasi dipusatkan pada setter untuk menghindari duplikasi kode (*DRY Principle*). |
| **Constructor** | `Member(String, String, String, String)` | Menginisialisasi atribut objek melalui setter agar proses validasi tetap dijalankan. |
| **Constructor Overloading** | Constructor dengan 3 dan 4 parameter | Memungkinkan pembuatan objek dengan jumlah parameter berbeda. |
| **Constructor Chaining** | `this(...)` | Memanggil constructor lain dalam class yang sama untuk menghindari pengulangan kode dan menetapkan paket default `Basic`. |
| **Method Overriding** | `@Override toString()` | Mengubah representasi teks objek agar informasi member ditampilkan dengan format yang mudah dibaca. |
| **Array of Objects** | `daftarMember` pada `TesFitTrack` | Menyimpan beberapa objek `Member` dalam satu array. |
| **Perulangan `for`** | `main()` pada `TesFitTrack` | Mengakses dan menampilkan seluruh objek member secara berurutan tanpa menulis kode berulang. |
| **Konstanta (`final`)** | Deklarasi konstanta pada `Member` | Menyimpan nilai tetap agar tidak menggunakan *magic number* atau *magic string* secara berulang. |

## ringkasan implementasi

melalui penerapan konsep-konsep tersebut, FitTrack dikembangkan dengan memperhatikan beberapa prinsip pemrograman:

- **Encapsulation:** Menjaga keamanan dan konsistensi data melalui pembatasan akses atribut.
- **Code Reusability:** Memanfaatkan constructor chaining untuk menggunakan kembali logika inisialisasi.
- **DRY (Don't Repeat Yourself):** Mengurangi duplikasi kode dengan memusatkan validasi pada setter.
- **Maintainability:** Mempermudah pengembangan dan pemeliharaan kode melalui penggunaan konstanta dan struktur class yang terorganisasi.
- **Object Management:** Mengelola banyak objek menggunakan array dan perulangan.

> **Progress Day 9:** Implementasi array of objects dan perulangan `for` untuk menyimpan serta menampilkan data member pada class `TesFitTrack`.