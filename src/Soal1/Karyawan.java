package Soal1;

//mengimport fitur arraylist pada java
import java.util.ArrayList;

public class Karyawan {
    int ID;
    String Nama;
    String Posisi;
    double Gaji;

    //constructor yang digunakan untuk menginisialisasi value dari suatu objek
    public Karyawan(int ID, String Nama, String Posisi, double Gaji){
        //this.ID -> yang ada pada atribut, akan terisi dengan nilai ID yang diinput oleh user pada main program
        this.ID = ID;
        this.Nama = Nama;
        this.Posisi = Posisi;
        this.Gaji = Gaji;
    }

    //array untuk menyimpan data data karyawan
    static ArrayList<Karyawan> daftarKaryawan = new ArrayList<>();

    //method untuk menambahkan daftar karyawan
    public static void addKaryawan(Karyawan karyawan){
        //kondisi untuk memastikan bahwa tidak ada ID yang duplikat dan gaji bernilai negatif
        if (isDuplicateID(karyawan.ID)) {
            System.out.println("Proses gagal. ID " + karyawan.ID + " sudah digunakan. Silahkan input kembali");
        } else if (karyawan.Gaji < 0) {
            System.out.println("Proses gagal. Gaji tidak boleh negatif. Silahkan input kembali");
        } else {
            //jika sudah melewati dua kondisi di atas, karyawan akan ditambahkan
            daftarKaryawan.add(karyawan);
            System.out.println("Proses berhasil. Karyawan telah ditambahkan.");
        }

    }

    //method untuk menghapus karyawan
    public static void deleteKaryawan(int id){
        Karyawan karyawanDelete = null;
        for (Karyawan k : daftarKaryawan) {
            //jika idnya sesuai dengan id yang diinput user, maka nilai dari data karyawan tersebut menjadi null
            if (k.ID == id) {
                karyawanDelete = k;
                break;
            }
        }

        //output untuk memberikan statement apakah data sudah berhasil dihapus atau tidak berdasarkan null atau tidaknya variable karyawanDelete
        if (karyawanDelete != null) {
            daftarKaryawan.remove(karyawanDelete);
            System.out.println("Karyawan telah berhasil dihapus.");
        } else {
            System.out.println("Karyawan tidak ditemukan. Penghapusan gagal.");
        }
    }

    //method untuk mengubah ID
    public void ubahID(Karyawan karyawan, int newID){
        //memastikan bahwa id tidak duplikat, jika kondisi pertama tdk terpenuhi, maka ID berhasil diganti
        if (isDuplicateID(newID)) {
            System.out.println("Proses gagal. ID " + newID + " sudah digunakan. Silahkan input kembali");
        } else {
            karyawan.ID = newID;
            System.out.println("Proses berhasil. ID telah diubah");
        }
    }

    //method untuk mengubah nama. nama karyawan yang lama akan diganti dengan value baru (parameter newNama)
    public void ubahNama(Karyawan karyawan, String newNama){
        karyawan.Nama = newNama;
        System.out.println("Nama berhasil diubah.");
    }

    public void ubahPosisi(Karyawan karyawan, String newPosisi){
        karyawan.Posisi = newPosisi;
        System.out.println("Posisi berhasil diubah.");
    }

    //method untuk mengubah gaji
    public void ubahGaji(Karyawan karyawan, double newGaji){
        //memastikantbahwa gaji tidak negatif, dan jika kondisi pertama tdk terpenuhi maka value dari variable gaji akan bernilai newGaji
        if (newGaji < 0) {
            System.out.println("Gagal mengubah gaji. Gaji tidak boleh negatif.");
        } else {
            karyawan.Gaji = newGaji;
            System.out.println("Gaji berhasil diubah.");
        }
    }

    //method untuk menampilkan seluruh data daftar karyawan
    public static void printAllKaryawan(){
        if(daftarKaryawan.isEmpty()){
            System.out.println("Belum ada daftar karyawan");
        }else{
            for(Karyawan karyawan : daftarKaryawan){
                System.out.println("=============================");
                System.out.println("ID: " + karyawan.ID);
                System.out.println("Nama: " + karyawan.Nama);
                System.out.println("Posisi: " + karyawan.Posisi);
                System.out.println("Gaji: " + karyawan.Gaji);
                System.out.println("=============================");
            }
        }
    }

    //method private untuk melihat apakah id yang iinput user duplikat atau tidak
    private static boolean isDuplicateID(int id){
        for (Karyawan k : daftarKaryawan){
            if (k.ID == id){
                return true;
            }
        }
        return false;
    }

    //method untuk mencari karyawan dengan set value "ditemukan" menjadi false. jika id yang iinput user itu ada dengan id yang ada pada daftar karyawan, maka value 'ditemukan' diupdate menjadi true
    public static void searchKaryawan(int id) {
        boolean ditemukan = false;
        for (Karyawan k : daftarKaryawan) {
            if (k.ID == id) {
                System.out.println("=============================");
                System.out.println("ID: " + k.ID);
                System.out.println("Nama: " + k.Nama);
                System.out.println("Posisi: " + k.Posisi);
                System.out.println("Gaji: " + k.Gaji);
                System.out.println("=============================");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Data karyawan tidak ditemukan.");
        }
    }
}


