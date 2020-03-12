package homeworks;
import java.util.Scanner;

public class Marubatsu {
  public static void main(String[] args) {
    String[] marks = {" ", "○", "x"};
    int[][] board = {{0,0,0}, {0,0,0}, {0,0,0}};
    for (int i=0; i<9; i++) {
      int player = i%2+1;
      put(marks, player, board);
      drawBoard(marks, board);
      if(judge(board)) {
        System.out.println(marks[player]+"の勝ちです");
        System.exit(0);
      }
    }
    System.out.println("あいこ");
  }
  public static void put(String[] marks, int player, int [][] board) {
    Scanner sc = new Scanner(System.in);
    System.out.println(marks[player]+"の番です");
    int x, y;
    do {
      System.out.println("横軸を入力してください");
      x = sc.nextInt();
      System.out.println("横軸を入力してください");
      y = sc.nextInt();
    } while (x<0 || x>2 || y<0 || y>2 || board[y][x]!=0);
    board[x][y] = player;
  }

  public static boolean judge (int[][] board) {
    for (int i=0; i<3; i++) {
      if(board[i][0]!=0 && board[i][0]==board[i][1] && board[i][0] == board[i][2]) {
        return true;
      }
      if(board[0][i]!=0 && board[0][i]==board[1][i] && board[0][1] == board[2][i]) {
        return true;
      }
    }
    if(board[0][0]!=0 && board[0][0]==board[1][1] && board[0][0] == board[2][2]) {
      return true;
    }
    if(board[2][0]!=0 && board[2][0]==board[1][1] && board[2][0] == board[0][2]) {
      return true;
    }
    return false;
  }
  public static void drawBoard(String[] marks, int[][] board)  {
    for(int i=0; i<3; i++) {
      System.out.print("|");
      for(int j=0; j<3; j++) {
        System.out.print(marks[board[i][j]]+"|");
      }
      System.out.println("");
    }
  }
}
