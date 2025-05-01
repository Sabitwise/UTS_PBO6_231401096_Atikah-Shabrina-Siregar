package Soal2;

import Soal1.Karyawan;
//mengimport fitur arraylist pada java
import java.util.ArrayList;

public class Vehicle {
    String jenisKendaraan;
    int durasi;
    int biaya;

    //membauat array dengan variable kendaraan
    static ArrayList<Vehicle> kendaraan = new ArrayList<>();

    //constructor Vehicle dimana jenis kendaraan yang diinput user di main program akan dimasukkan ke value jeniskendaraan di atribut
    public Vehicle(String jenisKendaraan){
        this.jenisKendaraan = jenisKendaraan;
    }

    //menghitung biaya parkir dengan overload. int durasi berlaku jika user ingin memasukkan secara manual, dan parameter jamMasuk dan jamKeluar berlaku jika user ingin memasukkan durasi berdasarkan jam
    public void hitungDurasi(int durasi){
        this.durasi = durasi;
    }

    public void hitungDurasi(int jamMasuk, int jamKeluar){
        this.durasi = jamKeluar - jamMasuk;
    }

    //biaya parkir perjam berdasarkan kendaraan
    public void biayaParkirKendaraan(Vehicle vehicle){
        if(vehicle.jenisKendaraan.equalsIgnoreCase("Motor")){
            biaya = 3000;
        }else if(vehicle.jenisKendaraan.equalsIgnoreCase("Mobil")){
            biaya = 5000;
        }else if(vehicle.jenisKendaraan.equalsIgnoreCase("Truk")){
            biaya = 10000;
        }else{
            System.out.println("Tidak valid.");
        }
    }

    //menghitung biaya parkir
    public double totalBiayaParkir(){
        double total;
        if(durasi > 5){
            total = (biaya * durasi) - ((biaya * durasi) * 0.1);
        }else {
            total = biaya * durasi;
        }
        return total;
    }

    //menampilkan rincian parkir dari setiap jenis kendaraan yang diinput oleh user
    public void printRincianParkir(){
        System.out.println("RINCIAN PARKIR");
        System.out.println("Jenis Kendaraan: " + jenisKendaraan);
        System.out.println("Lama Parkir: " + durasi + " jam");
        System.out.println("Total biaya parkir: " + totalBiayaParkir());
    }

    //total biaya dari setiap kendaraan (yang ada pada array) akan dilooping dan ditotalkan biaya semua kendaraan
    public static void totalAkhirBiaya(){
        int totalBiaya = 0;
        for(Vehicle v : kendaraan){
            totalBiaya += v.totalBiayaParkir();
        }
        //print jumlah kendaraan yang masuk berdasarkan size array kendaraan dan total biaya
        System.out.println("========== RINGKASAN ==========");
        System.out.println("Jumlah kendaraan masuk : " + kendaraan.size());
        System.out.println("Total semua biaya parkir: Rp" + totalBiaya);
    }

}
