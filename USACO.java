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
    return volume(lake, E);
  }
  private static void stomp(int r, int c, int n, int[][] lake) {
    int peak = lake[r][c]; //Represents the highest point.
    for (int i = r - 1; i < r + 2; i = i + 1) { //Find the highest point.
      for (int j = c - 1; j < c + 2; j = j + 1) {
        if (lake[i][j] > peak) {
          peak = lake[i][j];
        }
      }
    }
    for (int i = 0; i < r + 2; i = i + 1) { //Do the stomping.
      for (int j = 0; j < c + 2; j = j + 1) {
        if (peak - n < lake[i][j]) {
          lake[i][j] = peak - n;
        }
      }
    }
  }
  private static int volume(int[][] lake, int E) {
    int depth = 0; //Represents total depth of lake.
    for (int i = 0; i < lake.length; i = i + 1) {
      for (int j = 0; j < lake[0].length; j = j + 1) {
        if (lake[i][j] < E) { //If the bottom is lower than the elevation.
          depth = depth - lake[i][j] + E; //Add to the total depth.
        }
      }
    }
    return depth * 72 * 72;
  }
  public static int silver(String filename);
}
