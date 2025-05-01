package Soal3;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int row, col, guess;
        char yn;

        //menggunakan do while untuk setidaknya memainkan permainan sekali, lalu permainan akan dimainkan kembali jika user ingin mengulang. ditandakan dengan value yang diinput adalah y atau Y
        do{
            boolean main = true;
            System.out.println("========== PERMAINAN LOTRE GOSOK ==========");
            LotreBoard user = new LotreBoard();
            //selama variable main masih true, yaitu user belum terkena bom
            while (main) {
                user.displayBoard();
                System.out.print("Masukkan tebakan anda (baris): ");
                row = sc.nextInt();
                System.out.print("Masukkab tebakan anda (kolom): ");
                col = sc.nextInt();
                //value dari tebakan diperoleh dari hasil inputan row dan col yang dimasukkan ke parameter yang ada pada method guess
                boolean tebakan = user.guess(row, col);
                //sudah terkena bom atau tidaknya akan menghasilkan nilai true or false, yang dimana valuenya akan dimasukkan ke variable main
                main = tebakan;

                //jika tebakan adalah !tebakan = false, maka user terkena bom dan akan menampilkan display board yang terakhir
             if (!tebakan) {
                System.out.println("Permainan berakhir karena kena bom.");
                user.displayBoard();
            } else if (user.isGameOver()) { //jika semua board telah dibuka maka user menang dan juga akan menampilkan board terakhir
                main = false;
                System.out.println("Selamat! Anda telah membuka semua posisi aman.");
                user.displayBoard();
            }

            }

            System.out.println("Permainan berakhir.");
            System.out.print("Apakah anda ingin bermain lagi? (y/n)");
            yn = sc.next().charAt(0);
            sc.nextLine();
        }while(yn == 'Y' || yn == 'y');

    }
}
