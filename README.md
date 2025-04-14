# praktikum-pbo-m6

## Praktikum PBO M6

### Materi

Pada suatu hari seorang astep PBO bertanya kepada teman astepnya “Astep kamu tahu game feeding frenzy?”.Lalu ia menjawab bahwa dia tidak mengetahui game “feeding frenzy” itu seperti apa. Sang astep PBO merasa kasihan dan akhirnya ingin membantu teman astepnya untuk mengetahui game ini. Sekian cerita kisah nyata ini.

Buatlah game feeding frenzy sederhana 🐟

Tampilkan aquarium dengan ukuran 13x12 (termasuk border)

```

```

Pada awal permainan harus terdapat 10 ikan dengan jenis-jenis yang bervariasi pada map. Pada map harus terdapat 3 ikan small, 3 ikan medium, dan 4 ikan large. Dalam game ini terdapat 3 jenis ikan yaitu ikan small, medium, dan large. Lambangkan Ikan Small pada map sebagai “S”, ikan Medium sebagai “M”, dan ikan Large sebagai “L”. Pastikan bahwa tidak ada yang bertumpukan pada saat ikan spawn saja (ikan boleh bertumpukan setelah awal permainan). Player akan ditempatkan di koordinat 1,1 saat game dimulai dengan symbol “P” pada map.

Tujuan pada game ini sama seperti game feeding frenzy yaitu memakan ikan sebanyaknya. Player dapat memakan ikan apabila player dan ikan ada di koordinat yang sama.

Tabel Jenis - Jenis Ikan

| Jenis Ikan  | Symbol | Score | Persentase menggunakan Skill |
| ----------- | ------ | ----- | ---------------------------- |
| Ikan Small  | S      | 10    | 20%                          |
| Ikan Medium | M      | 20    | 30%                          |
| Ikan Large  | L      | 30    | 40%                          |

Player dapat bergerak dengan input “wasd”, bila player menginputkan “w” maka gerakkan player ke atas, “a” untuk gerakkan player ke kiri, “s” untuk gerakkan player ke bawah, dan “d” untuk gerakkan player ke kanan. Setiap kali player bergerak, tambahlah counter gerak ikan-ikan.

List Ikan\
Pada menu ini tampilkan semua Ikan yang berada pada map dengan format Jenis Ikan - (x,y).

```
===List Ikan===
1. Ikan Small - (3,3)
2. Ikan Small - (4,5)
3. Ikan Small - (6,9)
4. Ikan Medium - (4,4)
5. Ikan Medium - (2,9)
6. Ikan Medium - (4,2)
7. Ikan Large - (7,5)
8. Ikan Large - (10,10)
9. Ikan Large - (11,1)
10. Ikan Large - (3,6)
```

Sistem Gerak Ikan\
Ikan-ikan akan bergerak berdasarkan counter gerak milik player apabila counter gerak milik player sudah sesuai maka ikan akan bergerak sesuai tabel dibawah. Gerak dari jenis ikan Small akan bergerak hanya ke kiri / kanan, ikan Medium akan bergerak ke atas atau bawah, dan ikan Large akan bergerak random ke segala arah. Berilah pengecekan bahwa ikan-ikan tidak akan keluar dari map. Berikut merupakan ketentuan gerak ikan.

| Jenis Ikan  | Bergerak 1x setiap | Gerakan Ikan                                      |
| ----------- | ------------------ | ------------------------------------------------- |
| Ikan Small  | Player bergerak 5x | Gerak 1 ke Kiri / Kanan                           |
| Ikan Medium | Player bergerak 4x | Gerak 1 ke Atas / Bawah                           |
| Ikan Large  | Player bergerak 3x | Gerak 1 ke segala arah (atas, kiri, kanan, bawah) |

Sistem Makan Ikan\
Player dapat memakan ikan setiap kali letak koordinat player sama dengan letak koordinat milik ikan. Player pada saat level 1 hanya bisa memakan ikan Small saja. Pada saat level 2 player dapat memakan ikan Small dan ikan Medium. Pada saat level 3 player dapat memakan semua ikan pada map. Player hanya bisa menaikkan level dengan cara cheat level. Apabila saat player level 1 dan menabrak ikan yang tidak bisa dimakan olehnya, maka kurangilah nyawa sebanyak 1x. Setiap kali player memakan ikan maka tambahkan score player berdasarkan ikan yang dimakan. Jangan lupa untuk menyesuaikan list ikan dengan ikan yang terdapat dalam map apabila terdapat ikan yang dimakan oleh player.

### Tugas

<style>
    r { color: Red}
    g { color: Green}
    b { color: Blue}
    pu { color: Purple}
</style>

Buatlah game Ludo Sederhana🎲

Pada awal permainan tampilkanlah sebuah main menu seperti dibawah.

```
===Main Menu LUDO===
1. Play Game
2. History Game
3. Exit

>>
```

Play Game\
Pada menu ini pertama mintalah inputan untuk berapakah player yang akan bermain. Player yang akan bermain secara (co-op) itu berdasarkan input player. Apabila player input hanya 1 maka 3 player yang lain adalah bot. Jika player input 1 maka yang akan bermain “LUDO” akan 4 player. Pastikan input lebih dari 0 dan kurang dari 5. Tampilan awal map akan seperti dibawah berikut.

<r>[1#]</r>[&emsp;][&emsp;][&emsp;][&emsp;][&emsp;][&emsp;][&emsp;]<br>
[&emsp;][&emsp;][&emsp;][&emsp;][&emsp;][&emsp;][&emsp;]<g>[1#]</g><br>
<b>[1#]</b>[&emsp;][&emsp;][&emsp;][&emsp;][&emsp;][&emsp;][&emsp;]<br>
[&emsp;][&emsp;][&emsp;][&emsp;][&emsp;][&emsp;][&emsp;]<pu>[1#]</pu><br>

```
Turn : Player 1
Player 1 : 0
Player 2 : 0
Player 3 : 0
Player 4 : 0
====Play Menu====
1. Roll Dice
2. Power Up
3. Input Roll (CHEAT)
>> 1
```

Keterangan :

-   Pion warna Merah adalah Player 1 (P1).
-   Pion warna Hijau adalah Player 2 (P2).
-   Pion warna Biru adalah Player 3 (P3).
-   Pion warna Ungu adalah Player 4 (P4).
-   <r>[&emsp;]</r> yang berwarna merah adalah tempat player 1 menaruh pion
-   <g>[&emsp;]</g> yang berwarna hijau adalah tempat player 2 menaruh pion
-   <b>[&emsp;]</b> yang berwarna biru adalah tempat player 3 menaruh pion
-   <pu>[&emsp;]</pu> yang berwarna ungu adalah tempat player 4 menaruh pion
-   Dibawah baris “Turn: Player” merupakan keterangan berapa pion yang sudah berhasil mengitari 1 map

Pada awal permainan, untuk mengetahui siapa yang jalan pertama adalah randomlah angka 1-6 untuk masing-masing player. Kemudian player yang merandom angka paling tinggi maka akan jalan dahulu. Apabila terdapat angka tertinggi yang kembar maka randomlah ulang.

```

==Highest Roll==
Player 1 : 5
Player 2 : 2
Player 3 : 1
Player 4 : 5
=== Re Roll! ===
==Highest Roll==
Player 1 : 6
Player 2 : 3
Player 3 : 2
Player 4 : 4
Player who goes first : Player 1

```

Untuk sistem urutan bermain akan seperti contoh ini. Jika player 3 yang mendapatkan angka tertinggi maka setelah player 3 jalan, akan dilanjutkan dengan player 4. Jika player 4 yang mendapatkan angka tertinggi maka setelah player 4 jalan, akan dilanjutkan dengan player 1 dan seterusnya.

Setiap player akan memiki 4 pion yang terletak pada base masing-masing. Tujuan dari game ini adalah menjalankan 4 pion untuk mengitari 1 map ke base player itu sendiri

Player akan bermain dengan alur mengular dari kiri ke kanan. Berikut tampilan alur dari permainan game.

<r>[01]</r>[02][03][04][05][06][07][08]<br>
[16][15][14][13][12][11][10]<g>[09]</g><br>
<b>[17]</b>[18][19][20][21][22][23][24]<br>
[32][31][30][29][28][27][26]<pu>[25]</pu><br>

Roll Dice

```
Turn : Player 1
Player 1 : 0
Player 2 : 0
Player 3 : 0
Player 4 : 0
====Play Menu====
1. Roll Dice
2. Power Up
3. Input Roll (CHEAT)
>> 1
Player 1 rolls a 5
Who do you want to move?
1. 1#
2. 2# (Still in Base)
3. 3# (Still in Base)
4. 4# (Still in Base)
>> 2
Invalid Input! 2# is still in base!
>> 1
Move 1# 5 tiles ahead!
```

Pada menu ini player akan roll dadu (1-6), berilah keterangan saat player mana yang sedang roll dadu. Setelah dadu di roll maka pilih lah pion mana yang mau di gerakkan. Pion yang ada di base hanya bisa di pilih pada saat hasil roll adalah 6. Berilah juga keterangan sesuai dengan gambar di atas dan pengecekan apabila input yang dipilih oleh player adalah pilihan yang invalid.

Power Up\
Pada menu ini tampilkan menu power up yang terdapat 3 pilihan yaitu banana, shield, dan boost. Masing-masing power up memiliki fungsi yang berbeda.

```
==Power Up==
1. Banana
2. Shield
3. 2x Boost
>>
```

1. Banana\
   Apabila player memilih menu ini maka tampilkan pion yang ada dalam map. Player akan memilih pion yang letaknya pada map saja, apabila memilih pion yang berada pada base maka berilah pesan error. Fungsi dari power up “Banana” adalah untuk menaruh perangkap dibelakang pion tersebut jika belakang pion tersebut kosong. Apabila dibelakang pion tersebut ada pion lain maka berilah pesan error. Jika terdapat pion yang terkena perangkap banana maka pion yang terkena akan kembali ke base meskipun banana berasal dari player itu sendiri.

```

```

2. Shield\
   Apabila player memilih menu ini maka tampilkan pion yang ada dalam map. Player akan memilih pion yang letaknya pada map saja, apabila memilih pion yang berada pada base maka berilah pesan error. Fungsi power up “shield” adalah memberi perlindungan untuk 1 pion yang dipilih. Symbol pion akan berbeda apabila pion terdapat perlindungan (shield), [1#] -> [1$]. Jika pion terdapat perlindungan dan tertumpuk oleh pion lain maka kembalikan pion musuh ke posisi awal sebelum roll. Jika pion terkena banana saat ada perlindungan maka banana tersebut akan hilang dan perlindungan (shield) akan juga hilang. Kemudian kembalikan symbol pion ke bentuk asal lagi.

```

```

3. Boost\
   Apabila player memilih menu ini maka tampilkan pion yang ada dalam map. Player akan memilih pion yang letaknya pada map saja, apabila memilih pion yang berada pada base maka berilah pesan error. Fungsi power up “boost” maka player akan roll dice dan angka dice akan di kalikan 2. Power up ini hanya bisa digunakan 1x saat pada 1 turn player.

```

```

Input Roll (Cheats)\
Pada menu ini tampilkan list pion yang player miliki, kemudian setelah player memilih pion mintalah input untuk memasukan angka gerak pion tersebut. Berilah pengecekan apabila input angka hanya boleh dari 1-12 dan untuk pion yang di base hanya bisa dikeluarkan jika diinputkan angka 6.

BOT\
Bot pada game dapat melakukan semua yang dilakukan oleh player (selain input cheat). Apabila terdapat bot pada game maka randomlah perilaku bot dalam bermain game. Tampilan saat game terdapat bot adalah seperti berikut.

```

```

```

```

```

```

```

```

RULES

-   Player yang main pertama di tentukan berdasarkan roll terbesar oleh player
-   Untuk mengeluarkan pion dari base harus roll dice dengan angka 6
-   Saat player random roll dice, player dapat memilih pion mana yang akan bergerak.
-   Jika saat random dice adalah 6 maka player akan diberi kesempatan untuk bermain kembali sebanyak 1x.
-   Apabila pion player menumpuk pion lain (musuh atau milik sendiri) maka kembalikanlah pion yang ditumpuk ke base masing-masing.
-   Tempat base masing-masing player di symbol kan sebagai “[ ]” dengan warna player
-   Pion yang bergerak memiliki symbol Angka - # / “1#” dengan warna sesuai dengan player.
-   Masing-masing player atau bot memiliki 4 pion di base.
-   Untuk memenangkan game, 4 pion player harus mengitari 1 map sampai ke base player itu sendiri
-   Setiap player dapat menggunakan power up dengan jumlah tertentu. Power up Banana 3x, Shield 2x, dan boost 2x.

Game Over\
Game akan berakhir apabila terdapat 4 pion milik 1 player sudah mengitari 1 map sampai ke base milik player itu sendiri. Kemudian simpanlah nama-nama player dan pemenangnya untuk dimasukkan ke menu history game.

History Game\
Pada menu ini tampilkan history game yang sudah dimainkan. Format list history game akan sebagaiberikut.

```

```

Cheats (WAJIB DIKERJAKAN)\
Cheat yang harus dikerjakan adalah cheat input roll yang sudah dijelaskan diatas. Kemudian terdapat cheat kedua yaitu apabila player menginput “game over” maka player akan langsung berakhir dan buatlah player yang sedang dalam turn tersebut menjadi pemenangnya

Exit\
Apabila menu ini dipilih, exitlah program ini.

```

```
