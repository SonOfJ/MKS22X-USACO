import java.io.*;
import java.util.*;
public class USACO {
  public static int bronze(String filename) throws FileNotFoundException{
    File text = new File(filename);
    Scanner inf = new Scanner(text); //Let's give meaning to the top four integers
    String[] integers = inf.nextLine().split(""); //Splits the first line at spaces.
    int R = Integer.parseInt(text.next()); //Number of rows.
    int C = Integer.parseInt(text.next()); //Number of columns.
    int E = Integer.parseInt(text.next()); //The elevation.
    int N = Integer.parseInt(text.next()); //Number of stomping instructions.
    int[][] lake = int[R][C]; //Use 2D array to represent the lake.
    Scanner brave = new Scanner(text); //Need a new scanner.
    brave.nextLine(); //Move on to the elevation values.
    for (int i = 0; i < R; i = i + 1) { //Add the elevation values.
      for (int j = 0; j < C; j = j + 1) {
        lake[i][j] = Integer.parseInt(text.next());
      }
      brave.nextLine();
    }
  }
  public static int silver(String filename);
}
