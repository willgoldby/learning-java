import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.random.RandomGenerator;

public class Solution {

  // Add constants for particle types here.
  public static final int EMPTY = 0;
  public static final int METAL = 1;
  public static final int SAND = 2;
  public static final int WATER = 3;

  public static final String[] NAMES = { "Empty", "Metal", "Sand", "Water", };

  // Do not add any more fields as part of Lab 5.
  private int[][] grid;
  private SandDisplayInterface display;
  private RandomGenerator random;

  /**
   * Constructor.
   *
   * @param display The display to use for this run
   * @param random  The random number generator to use to pick random points
   */
  public Solution(SandDisplayInterface display, RandomGenerator random) {
    this.display = display;
    this.random = random;
    this.grid = new int[display.getNumRows()][display.getNumColumns()];
  }

  /**
   * Called when the user clicks on a location.
   *
   * @param row
   * @param col
   * @param tool
   */
  private void locationClicked(int row, int col, int tool) {
    grid[row][col] = tool;
  }

  /** Copies each element of grid into the display. */
  // updateDispay is repeatedly called.
  public void updateDisplay() {
    // Clicking 'Empty' sets all indices to 0.
    if (display.getTool() == EMPTY) {
      for (int rowValue = 0; rowValue < display.getNumRows(); rowValue++) {
        for (int colValue = 0; colValue < display.getNumColumns(); colValue++) {
          grid[rowValue][colValue] = 0;
        }
      }
    }
    // Change color at each indice based on the value in the indice.
    for (int rowValue = 0; rowValue < display.getNumRows(); rowValue++) {
      for (int colValue = 0; colValue < display.getNumColumns(); colValue++) {
        switch (grid[rowValue][colValue]) {
          case 0:
            Color black = new Color(0, 0, 0);
            display.setColor(rowValue, colValue, black);
            break;
          case 1:
            Color grey = new Color(192, 192, 192);
            display.setColor(rowValue, colValue, grey);
            break;
          case 2:
            Color yellow = new Color(255, 255, 0);
            display.setColor(rowValue, colValue, yellow);
            break;
          case 3:
            Color blue = new Color(0, 0, 255);
            display.setColor(rowValue, colValue, blue);
            break;
        }
      }
    }
  }

  /** Called repeatedly. Causes one random particle to maybe do something. */
  public void step() {
    // TODO: Populate this method in step 6 and beyond.
    // pick a random position within the grid
    // if position contains sand and the space below is empty
    // move the sand down one row.
    RandomGenerator randoNumbers = new RandomGenerator(display.getNumRows() - 1, display.getNumColumns() - 1);
    Point randomPoint1 = randoNumbers.getRandomPoint();
    if ((grid[randomPoint1.row][randomPoint1.column]) == 3 && (grid[randomPoint1.row + 1][randomPoint1.column] == 2)){
      grid[randomPoint1.row][randomPoint1.column] = 2;
      grid[randomPoint1.row + 1][randomPoint1.column] = 3; 
    }

    // Checks if cell is sand and then moves the cell if there's nothing below it.
    if ((grid[randomPoint1.row][randomPoint1.column] == 2) && (grid[randomPoint1.row + 1][randomPoint1.column] == 0)
        && (randomPoint1.row + 1 <= display.getNumRows())) {
      grid[randomPoint1.row][randomPoint1.column] = 0;
      grid[randomPoint1.row + 1][randomPoint1.column] = 2;
    } // End bracket for sand.
    // Checks if cell is water.
    else if ((grid[randomPoint1.row][randomPoint1.column] == 3)){
      // get random direction.
      int direction = randoNumbers.getRandomDirection();
      // If direction is 0, have water flow like the sand.
      if (direction == 0){
        if ((grid[randomPoint1.row + 1][randomPoint1.column] == 0)
        && (randomPoint1.row + 1 <= display.getNumRows())){
      grid[randomPoint1.row][randomPoint1.column] = 0;
      grid[randomPoint1.row + 1][randomPoint1.column] = 3;
        } // End bracket for moving water down one row.
      } // End bracket for checking if direction is 0.
      // Move water to the right.
      // Move water particle to the right if direction is 1.
      else if (direction == 1){
        if ((grid[randomPoint1.row][randomPoint1.column + 1] == 0) && 
          (randomPoint1.column + 1 <= display.getNumColumns()) &&
          (grid[randomPoint1.row + 1][randomPoint1.column] == 1 || 
          grid[randomPoint1.row + 1][randomPoint1.column] == 2 ||
          grid[randomPoint1.row + 1][randomPoint1.column] == 3)){
            grid[randomPoint1.row][randomPoint1.column] = 0;
            grid[randomPoint1.row][randomPoint1.column + 1] = 3;
          } // End bracket for water moving to the right.
      }
      // Move water to the left if direction is 2.
      else if (direction == 2) {
        // Make sure there's nothing to the left.
        if((grid[randomPoint1.row][randomPoint1.column - 1] == 0) &&
          // Make sure you're within bounds of display.
          (randomPoint1.column - 1 >= display.getNumColumns()) &&
          (grid[randomPoint1.row - 1][randomPoint1.column] == 1 || 
            grid[randomPoint1.row - 1][randomPoint1.column] == 2 ||
            grid[randomPoint1.row - 1][randomPoint1.column] == 3)){
              grid[randomPoint1.row][randomPoint1.column] = 0;
              grid[randomPoint1.row][randomPoint1.column - 1] = 3;
            }
      }
    } // End bracket for water.
  } // End bracket for step()
    //     get random number that represents direction
    //     if (random number is 0) {
    //       water falls like sand unless it would 
    //       hit sand or metal

    //     if (random number is 1){
    //       water paricle moves to the right
    //     } 
    //     if (random number is 2){
    //       water paricle moves to the left
    //     }

    // The behavior of water is a bit different than sand. In the step method,
    // implement the following behavior: when the randomly selected cell contains
    // water, use RandomGenerator to getRandomDirection. If the direction is 0,
    // water falls like sand (unless it would hit sand or metal) but if the
    // direction is 1, the water particle moves to the right (if possible) and if
    // the direction is 2, the water particle moves to the left (if possible).

    // This means that water will (with time) flow off a horizontal surface of metal
    // or sand.

    // Test this behavior out in the UI. Make sure that water flows (more or less)
    // realistically.

    // Before continuing, take a look at your step method and see if you can
    // organize your code to minimize duplication.


  /********************************************************************/
  /********************************************************************/
  /**
   * DO NOT MODIFY
   *
   * <p>
   * The rest of this file is UI and testing infrastructure. Do not modify as part
   * of pre-GDA Lab
   * 5.
   */
  /********************************************************************/
  /********************************************************************/

  private static class Point {
    private int row;
    private int column;

    public Point(int row, int column) {
      this.row = row;
      this.column = column;
    }

    public int getRow() {
      return row;
    }

    public int getColumn() {
      return column;
    }
  }

  /**
   * Special random number generating class to help get consistent results for
   * testing.
   *
   * <p>
   * Please use getRandomPoint to get an arbitrary point on the grid to evaluate.
   *
   * <p>
   * When dealing with water, please use getRandomDirection.
   */
  public static class RandomGenerator {
    private static Random randomNumberGeneratorForPoints;
    private static Random randomNumberGeneratorForDirections;
    private int numRows;
    private int numCols;

    public RandomGenerator(int seed, int numRows, int numCols) {
      randomNumberGeneratorForPoints = new Random(seed);
      randomNumberGeneratorForDirections = new Random(seed);
      this.numRows = numRows;
      this.numCols = numCols;
    }

    public RandomGenerator(int numRows, int numCols) {
      randomNumberGeneratorForPoints = new Random();
      randomNumberGeneratorForDirections = new Random();
      this.numRows = numRows;
      this.numCols = numCols;
    }

    public Point getRandomPoint() {
      return new Point(
          randomNumberGeneratorForPoints.nextInt(numRows),
          randomNumberGeneratorForPoints.nextInt(numCols));
    }

    /**
     * Method that returns a random direction.
     *
     * @return an int indicating the direction of movement: 0: Indicating the water
     *         should attempt
     *         to move down 1: Indicating the water should attempt to move right 2:
     *         Indicating the water
     *         should attempt to move left
     */
    public int getRandomDirection() {
      return randomNumberGeneratorForDirections.nextInt(3);
    }
  }

  public static void main(String[] args) {
    // Test mode, read the input, run the simulation and print the result
    Scanner in = new Scanner(System.in);
    int numRows = in.nextInt();
    int numCols = in.nextInt();
    int iterations = in.nextInt();
    Solution lab = new Solution(new NullDisplay(numRows, numCols), new RandomGenerator(0, numRows, numCols));
    lab.readGridValues(in);
    lab.runNTimes(iterations);
    lab.printGrid();
  }

  /**
   * Read a grid set up from the input scanner.
   *
   * @param in
   */
  private void readGridValues(Scanner in) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        grid[i][j] = in.nextInt();
      }
    }
  }

  /** Output the current status of the grid for testing purposes. */
  private void printGrid() {
    for (int i = 0; i < grid.length; i++) {
      System.out.println(Arrays.toString(grid[i]));
    }
  }

  /** Runner that advances the display a determinate number of times. */
  private void runNTimes(int times) {
    for (int i = 0; i < times; i++) {
      runOneTime();
    }
  }

  /** Runner that controls the window until it is closed. */
  public void run() {
    while (true) {
      runOneTime();
    }
  }

  /**
   * Runs one iteration of the display. Note that one iteration may call step
   * repeatedly depending
   * on the speed of the UI.
   */
  private void runOneTime() {
    for (int i = 0; i < display.getSpeed(); i++) {
      step();
    }
    updateDisplay();
    display.repaint();
    display.pause(1); // Wait for redrawing and for mouse
    int[] mouseLoc = display.getMouseLocation();
    if (mouseLoc != null) { // Test if mouse clicked
      locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
    }
  }

  /**
   * An implementation of the SandDisplayInterface that doesn't display anything.
   * Used for testing.
   */
  static class NullDisplay implements SandDisplayInterface {
    private int numRows;
    private int numCols;

    public NullDisplay(int numRows, int numCols) {
      this.numRows = numRows;
      this.numCols = numCols;
    }

    public void pause(int milliseconds) {
    }

    public int getNumRows() {
      return numRows;
    }

    public int getNumColumns() {
      return numCols;
    }

    public int[] getMouseLocation() {
      return null;
    }

    public int getTool() {
      return 0;
    }

    public void setColor(int row, int col, Color color) {
    }

    public int getSpeed() {
      return 1;
    }

    public void repaint() {
    }
  }

  /** Interface for the UI of the SandLab. */
  public interface SandDisplayInterface {
    public void repaint();

    public void pause(int milliseconds);

    public int[] getMouseLocation();

    public int getNumRows();

    public int getNumColumns();

    public void setColor(int row, int col, Color color);

    public int getSpeed();

    public int getTool();
  }
}
