import java.io.*;
import java.util.*;
public class USACO {
  public static int bronze(String filename) throws FileNotFoundException{
    File text = new File(filename);
    Scanner inf = new Scanner(text); //Let's give meaning to the top four integers
    String[] integers = inf.nextLine().split(""); //Splits the first line at spaces.
    int R = Integer.parseInt(integers[0]); //Number of rows.
    int C = Integer.parseInt(integers[1]); //Number of columns.
    int E = Integer.parseInt(integers[2]); //The elevation.
    int N = Integer.parseInt(integers[3]); //Number of stomping instructions.
    int[][] lake = int[R][C]; //Use 2D array to represent the lake.
    Scanner brave = new Scanner(text); //Need a new scanner.
    brave.nextLine(); //Move on to the elevation values.
    for (int i = 0; i < R; i = i + 1) { //Add the elevation values.
      String[] row = inf.nextLine().split(""); //Time to make the rows.
      for (int j = 0; j < C; j = j + 1) {
        lake[i][j] = Integer.parseInt(row[j]); //Fill in the values.
      }
    }
    for (int i = 0; i < N; i = i + 1) { //Stomp instructions.
      String[] input = inf.nextLine().split(""); //Consider inputs.
      stomp(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])); //Stomp helper function.
    }
    return volume();
  }
  public static int silver(String filename);
}
