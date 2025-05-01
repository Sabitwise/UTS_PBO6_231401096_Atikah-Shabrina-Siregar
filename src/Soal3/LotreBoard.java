package Soal3;
import java.util.Random;

public class LotreBoard {
    char[][] board = new char[4][5]; //papan untuk menampilkan status
    boolean[][] revealed = new boolean[4][5]; //untuk melihat apakah sudah dibuka atau belum
    int[][] data = new int[4][5]; //menyimpan data asli kotak

    //contructor LotreBoard untuk generateBoard setiap kali user masuk ke putaran selanjutnya. sehingga tidak redundan dan masih bisa menggunakan fungsi yang sama
    public LotreBoard(){
        generateBoard();
    }

    //method untuk generate board dengan 4 baris dan 5 kolom dengan mengajak letak dari 2 bom di antara matriks tersebut
    public void generateBoard(){
        Random random = new Random();
        int bom = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 5; j++){
                board[i][j] = '*';
                revealed[i][j] = false;
                data[i][j] = 0;
            }
        }
        //selama bom masih di bawah 2, maka program masih bisa melakukan perulangan untuk meletekkan dua bom secara random di antara baris dan kolom
        while(bom < 2){
            int row = random.nextInt(4);
            int col = random.nextInt(5);
            if (data[row][col] == 0){
                data[row][col] = 1;
                bom++;
            }
        }
    }

    //method untuk menampilkan board
    public void displayBoard(){
        System.out.println("Tampilan papan:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                //kondisi jika tebakan tersebut adalah lokasi bom
                if (revealed[i][j]) {
                    if (data[i][j] == 1) {
                        board[i][j] = 'X';
                    } else {
                        //kondisi jika tebakan tersebut ternyata aman
                        board[i][j] = 'O';
                    }
                } else {
                    //kondisi jika belum ditebak oleh user
                    board[i][j] = '*';
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    //logika untuk menampilkan suatu teks apakah user berhasil menebak atau tidak
    public boolean guess(int row, int col){
        revealed[row][col] = true;
        if(data[row][col] == 1){
            System.out.println("Boom! Anda kalah. Silahkan main lagi.");
            return false;
        }
        System.out.println("Anda aman! Lanjutkan tebakan anda.");
        return true;
    }

    //perulangan dan kondisi untuk melihat apakah user sudah menang atau tidak. ditandakan dengan semua kolom yang aman telah dibuka
    public boolean isGameOver(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (data[i][j] == 0 && !revealed[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
