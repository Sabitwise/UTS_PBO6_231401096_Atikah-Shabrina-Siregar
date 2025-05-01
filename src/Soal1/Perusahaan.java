package Soal1;
import java.util.Scanner;
public class Perusahaan {
    public static void main(String[] args){
        int option;
        int option2;
        boolean option3 = true;
        int idKaryawan;
        //perulangan agar user masih dapat menggunakan fitur selama option3 itu true. dinyatakan false jika user input pilihan ke 6
        while(option3 = true){
        Scanner sc = new Scanner(System.in);
        //menampilkan pilihan fitur yang dapat digunakan oleh user
        System.out.println("SISTEM MANAJEMEN KARYAWAN");
        System.out.println("1. Tambah Karyawan");
        System.out.println("2. Hapus Karyawan");
        System.out.println("3. Ubah Settingan Karyawan");
        System.out.println("4. Tampilkan Semua Karyawan");
        System.out.println("5. Mencari karyawan berdasarkan ID");
        System.out.println("6. Keluar");
        System.out.print("Masukkan pilihan : ");
        option = sc.nextInt();
        //switch case, fitur dapat diutilisasi berdasarkan pilihan fitur yang dipilih oleh user
        switch(option) {
            case 1:
                System.out.println("Tambah Karyawan");
                System.out.print("Masukkan ID: ");
                idKaryawan = sc.nextInt();
                sc.nextLine();
                System.out.print("Masukkan nama: ");
                String nama = sc.nextLine();
                System.out.print("Masukkan posisi: ");
                String posisi = sc.nextLine();
                System.out.print("Masukkan gaji: ");
                double gaji = sc.nextDouble();
                //data yang telah diinput akan dimasukkan ke array karyawan. "new" karena setiap karyawan baru yang iinputkan memiliki informasi yang berbeda, sehingga data baru karyawan jg akan disimpan di array karyawan yang baru
                Karyawan.addKaryawan(new Karyawan(idKaryawan, nama, posisi, gaji));
                System.out.println("Berhasil ditambahkan.");
                break;
            case 2:
                System.out.println("Hapus Karyawan Berdasarkan ID");
                System.out.print("Masukkan ID Karyawan: ");
                idKaryawan = sc.nextInt();
                //delete karyawan berdasarkan id yang diinput
                Karyawan.deleteKaryawan(idKaryawan);
                break;
            case 3:
                System.out.println("Ubah Karyawan berdasarkan ID");
                System.out.print("Masukkan ID Karyawan: ");
                idKaryawan = sc.nextInt();
                //untuk memastikan bahwa daftar data karyawan yang ingin diubah itu ada pada array karyawan
                Karyawan karyawanDitemukan = null;
                for (Karyawan k : Karyawan.daftarKaryawan) {
                    if (k.ID == idKaryawan) {
                        karyawanDitemukan = k;
                        break;
                    }
                }
                if (karyawanDitemukan == null) {
                    System.out.println("Karyawan tidak ditemukan.");
                    return;
                }
                //user dapat memilih data karyawan apa yang ingin diubah
                System.out.println("1. Nama Karyawan");
                System.out.println("2. ID Karyawan");
                System.out.println("3. Posisi Karyawan");
                System.out.println("4. Gaji Karyawan");
                System.out.print("Pilih yang mau diganti: ");
                option2 = sc.nextInt();
                sc.nextLine();
                //setiap fitur yang dipilih, user akan memasukkan value yang baru dan program akan memanggil method pada class karyawan
                if (option2 == 1) {
                    System.out.print("Masukkan nama baru: ");
                    String newName = sc.nextLine();
                    karyawanDitemukan.ubahNama(karyawanDitemukan, newName);
                } else if (option2 == 2) {
                    System.out.print("Masukkan ID baru: ");
                    int newID = sc.nextInt();
                    sc.nextLine();
                    karyawanDitemukan.ubahID(karyawanDitemukan, newID);
                } else if (option2 == 3) {
                    System.out.print("Masukkan posisi baru: ");
                    String newPosisi = sc.nextLine();
                    karyawanDitemukan.ubahPosisi(karyawanDitemukan, newPosisi);
                } else if (option2 == 4) {
                    System.out.print("Masukkan gaji baru: ");
                    double newGaji = sc.nextDouble();
                    sc.nextLine();
                    karyawanDitemukan.ubahGaji(karyawanDitemukan, newGaji);
                } else {
                    System.out.println("Tidak sesuai opsi.");
                }
                break;
            //digunakan untuk menampilkan semua karyawan dengan memanggil method printAllKaryawan
            case 4:
                System.out.println("Tampilkan semua karyawan");
                Karyawan.printAllKaryawan();
                break;
            case 5:
                //id yang diinput user akan dimasukkan ke method searchKaryawan
                System.out.println("Cari Karyawan Berdasarkan ID");
                System.out.print("Masukkan ID Karyawan: ");
                idKaryawan = sc.nextInt();
                Karyawan.searchKaryawan(idKaryawan);
                break;
            case 6:
                System.out.println("Terima kasih.");
                option3 = false;
                break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
