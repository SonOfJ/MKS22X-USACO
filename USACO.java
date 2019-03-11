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
    int[][] lake = new int[R][C]; //Use 2D array to represent the lake.
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
  public static int silver(String filename) throws FileNotFoundException {
    File text = new File(filename);
    Scanner inf = new Scanner(text);
    String[] integers = inf.nextLine().split(""); //Give meaning to the integers in the first row.
    int N = Integer.parseInt(integers[0]);
    int M = Integer.parseInt(integers[1]);
    int T = Integer.parseInt(integers[2]);
    int[][] land = new int[N][M]; //Create the map.
    for (int i = 0; i < N, i = i + 1) {
      String[] row = inf.nextLine().split("");
      for (int j = 0; j < M; j = j + 1) {
        if (row[j].equals(".")) {
          land[i][j] = 0; //Open space.
        } else {
          land[i][j] = -1; //Trees.
        }
      }
    }
    String[] coordinates = inf.nextLine().split(""); //Coordinates for start and end locations.
    int R1 = Integer.parseInt(coordinates[0]) - 1; //Array coordinates start at 0.
    int C1 = Integer.parseInt(coordinates[1]) - 1;
    int R2 = Integer.parseInt(coordinates[2]) - 1;
    int C2 = Integer.parseInt(coordinates[3]) - 1;
    land[R1][C1] = 1; //First level.
    for (int i = 0; i < T; i = i + 1) {
      land = move(land); //Get the array that contains the levels of moves.
    }
    return land[R2][C2];
  }
  private static int[][] move(int[][] land) {
    int[] moves = {-1, 0, 1, 0, 0, -1, 0, 1}; //Coordinates for movement.
    int[][] move = new int[land.length][land[0].length];
    for (int i = 0; i < move.length; i = i + 1) {
      for (int j = 0; j < move[0].length; j = j + 1) {
        if (land[i][j] == -1) { //Hits a tree.
          move[i][j] = -1; //No more movement.
        } else {
          int level = 0; //Counter.
          for (int m = 0; m < 8; m = m + 2) {
            int rMove = i + moves[m]; //Vertical movement.
            int cMove = j + moves[m + 1]; //Horizontal movement.
            if (rMove >= 0 && cMove >= 0 && rMove < land.length && cMove < land[0].length && land[rMove][cMove] != -1) { //Does not go out of bounds and does not hit a tree.
              level = level + land[rMove][cMove];
            }
          }
          move[i][j] = level;
        }
      }
    }
    return move;
  }
}
