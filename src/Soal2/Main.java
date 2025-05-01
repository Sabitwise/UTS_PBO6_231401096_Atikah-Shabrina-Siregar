package Soal2;
import Soal1.Karyawan;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String transportation;
        int total = 0;
        int option, durasi, jamMasuk, jamKeluar;
        boolean option2;
        //akan dilakukan perulangan minimal sekali selama option2 itu true. dikatakan false jika tidak ada lagi kendaraan yang akan diinput oleh user
        do {
            System.out.println("MANAJEMEN PARKIR");
            System.out.println("Pilih jenis transportasi");
            System.out.println("1. Mobil");
            System.out.println("2. Motor");
            System.out.println("3. Truk");
            System.out.print("Input dalam teks: ");
            transportation = sc.nextLine();
            //jenis kendaraan yang diinput oleh user akan dimasukkan ke parameter method dari Vehicle
            Vehicle vehicle = new Vehicle(transportation);

            //kondisi untuk melihat apakah kendaraan sudah sesuai dengan ketiga kendaraan tersebut atau tidak. ignore case, yang berarti tidak melihat besar kecilnya huruf selagi jenis kendaraannya tetap sama
            if (!(transportation.equalsIgnoreCase("Mobil") ||
                    transportation.equalsIgnoreCase("Motor") ||
                    transportation.equalsIgnoreCase("Truk"))) {
                System.out.println("Jenis kendaraan tidak valid. Silakan coba lagi.");
                break;
            }

            //user memilih cara perhitungan durasi
            System.out.println("======================");
            System.out.println("1. Manual");
            System.out.println("2. Waktu masuk & waktu keluar");
            System.out.print("Pilih opsi durasi: ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Masukkan waktu durasi (dalam jam): ");
                    durasi = sc.nextInt();
                    vehicle.hitungDurasi(durasi);
                    break;
                case 2:
                    //user akan input jam masuk dan jam keluar yang akan dimasukkan ke method hitungDurasi dengan dua parameter
                    System.out.print("Masukkan jam masuk (WIB): ");
                    jamMasuk = sc.nextInt();
                    System.out.print("Masukkan jam keluar (WIB): ");
                    jamKeluar = sc.nextInt();
                    vehicle.hitungDurasi(jamMasuk, jamKeluar);
                    break;
                    //jika user tidak memilih angka di antara kedua opsi di atas, maka pilihannya tidak valid
                default:
                    System.out.println("Pilihan tidak valid");
            }
            //menghitung biaya parkir kendaraan dan print rincian parkir dari hasil inputan user dan perhitungan method
            vehicle.biayaParkirKendaraan(vehicle);
            vehicle.printRincianParkir();
            Vehicle.kendaraan.add(vehicle);
            System.out.print("Ingin memasukkan kendaraan yang lain? (y/n): ");
            sc.nextLine();
            //kondisi dimana ketika user input selain karakter y, maka option2 akan bernilai false dan perulangan akan berhenti atau tidak ada lagi kendaraan yang akan diinput
            String repeat = sc.nextLine();
            if(repeat.equalsIgnoreCase("y")){
                option2 = true;
            }else{
                option2 = false;
            }
        }while (option2);

        //setelah semua data setiap kendaraan disimpan di dalam array, total biaya akan dihitung dengan method totalAkhirBiaya
        Vehicle.totalAkhirBiaya();
    }
}
