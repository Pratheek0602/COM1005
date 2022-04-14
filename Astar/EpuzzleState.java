import java.util.*;

public class EpuzzleState extends SearchState {

    private int[][] puzzle = new int[3][3];

    public EpuzzleState(int[][] puzzle, int lc, int rc) {
        this.puzzle = puzzle;
        localCost = lc;
        estRemCost = rc + hamming();
    }

    public int[][] getPuzzle() {
        return puzzle;
    }

    public boolean goalPredicate(Search searcher) {
        EpuzzleSearch epuzzleSearch = (EpuzzleSearch) searcher;
        int[][] target = epuzzleSearch.getTarget();
        return Objects.deepEquals(target, puzzle);
    }

    private int manhattan() {
        int sum = 0;
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                if (puzzle[i][j] != 0) {

                    int targetRow = (puzzle[i][j] - 1) / puzzle.length; // expected row coordinate
                    int targetCol = (puzzle[i][j] - 1) % puzzle.length; // expected col coordinate

                    int distExpectRow = i - targetRow; // distance to expected row coordinate
                    int distExpectCol = j - targetCol; // distance to expected col coordinate

                    sum += Math.abs(distExpectRow) + Math.abs(distExpectCol);

                }

            }

        }
        return sum;

    }

    private int hamming() {
        int count = 0; // number of blocks out of place
        int expected = 0;
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                expected++;
                if (puzzle[i][j] != 0 && puzzle[i][j] != expected) { // count for blocks in wrong place
                    count++;
                }
            }
        }
        return count;

    }

    private EpuzzleState moveUp(int x, int y) {
        int[][] arr = new int[3][3];
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                arr[i][j] = puzzle[i][j];
            }
        }
        if (x > 0) {
            int temp = arr[x][y];
            arr[x][y] = arr[x - 1][y];
            arr[x - 1][y] = temp;
        }

        EpuzzleState epuzzleState = new EpuzzleState(arr,localCost,estRemCost);
        return epuzzleState;
    }

    private EpuzzleState moveDown(int x, int y) {
        int[][] arr = new int[3][3];
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                arr[i][j] = puzzle[i][j];
            }
        }
        if (x < 2) {
            int temp = arr[x][y];
            arr[x][y] = arr[x + 1][y];
            arr[x + 1][y] = temp;
        }

        EpuzzleState epuzzleState = new EpuzzleState(arr,localCost,estRemCost);
        return epuzzleState;
    }

    private EpuzzleState moveRight(int x, int y) {
        int[][] arr = new int[3][3];
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                arr[i][j] = puzzle[i][j];
            }
        }
        if (y < 2) {
            int temp = arr[x][y];
            arr[x][y] = arr[x][y + 1];
            arr[x][y + 1] = temp;

        }
        EpuzzleState epuzzleState = new EpuzzleState(arr,localCost,estRemCost);
        return epuzzleState;
    }

    private EpuzzleState moveLeft(int x, int y) {
        int[][] arr = new int[3][3];
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                arr[i][j] = puzzle[i][j];
            }
        }
        if (y > 0) {
            int temp = arr[x][y];
            arr[x][y] = arr[x][y - 1];
            arr[x][y - 1] = temp;
        }
        EpuzzleState epuzzleState = new EpuzzleState(arr,localCost,estRemCost);
        return epuzzleState;
    }

    public ArrayList<SearchState> getSuccessors(Search searcher) {

        ArrayList<EpuzzleState> epuzzleStatesList = new ArrayList<EpuzzleState>(); // the list of epuzzle states
        ArrayList<SearchState> searchStatesList = new ArrayList<SearchState>();

        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                if (puzzle[i][j] == 0) {

                    EpuzzleState moveDown = moveDown(i, j);
                    EpuzzleState moveUp = moveUp(i, j);
                    EpuzzleState moveRight = moveRight(i, j);
                    EpuzzleState moveLeft = moveLeft(i, j);

                    System.out.println("Hamming: "+hamming());
                    epuzzleStatesList.add(moveDown);
                    epuzzleStatesList.add(moveUp);
                    epuzzleStatesList.add(moveRight);
                    epuzzleStatesList.add(moveLeft);


                    
                }

            }
        }
        

        for (EpuzzleState es : epuzzleStatesList) {
            searchStatesList.add((SearchState) es);
        }

        return searchStatesList;
    }

    public boolean sameState(SearchState state) {
        EpuzzleState epuzzleState = (EpuzzleState) state;
        return Objects.deepEquals(puzzle, epuzzleState.getPuzzle());
    }

    /**
     * toString
     */

    public String toString() {
        String s = "\n";
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                s += "| " + puzzle[i][j] + " |";
            }
            s += "\n";
        }

        return s;
    }

}
