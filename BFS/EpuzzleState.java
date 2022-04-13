
import java.util.*;

public class EpuzzleState extends SearchState {

    private int[][] puzzle = new int[3][3];

    /**
     * constructor
     * 
     * @param puzzle content of puzzle
     */

    public EpuzzleState(int[][] puzzle) {
        this.puzzle = puzzle;
    }

    public int[][] getPuzzle() {
        return puzzle;
    }

    /**
     * goalPredicate
     * 
     * @param searcher - the current search engine
     * 
     *                 method will check whether this state matched the target
     *                 (goal) state as provided by the search engine instance
     */

    public boolean goalPredicate(Search searcher) {
        EpuzzleSearch epuzzleSearch = (EpuzzleSearch) searcher;
        int[][] target = epuzzleSearch.getTarget();
        return Objects.deepEquals(target, puzzle);
    }

    // private int [][] copyPuzzle(){
    //     int[][] arr = new int[3][3];
    //     for (int i = 0; i < puzzle.length; i++) {
    //         for (int j = 0; j < puzzle[i].length; j++) {
    //             arr[i][j] = puzzle[i][j];
    //         }
    //     }

    // }

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

        EpuzzleState epuzzleState = new EpuzzleState(arr);
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

        EpuzzleState epuzzleState = new EpuzzleState(arr);
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
        EpuzzleState epuzzleState = new EpuzzleState(arr);
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
        EpuzzleState epuzzleState = new EpuzzleState(arr);
        return epuzzleState;
    }

    /**
     * getSuccessors
     * 
     * @param searcher - the current search engine
     * 
     *                 method will return list of possible successors
     */

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

                    epuzzleStatesList.add(moveDown);
                    epuzzleStatesList.add(moveUp);
                    epuzzleStatesList.add(moveRight);
                    epuzzleStatesList.add(moveLeft);
                }

            }
        }

        // cast the epuzzle states as search states in searchStatesList

        for (EpuzzleState es : epuzzleStatesList) {
            searchStatesList.add((SearchState) es);
        }

        return searchStatesList;
    }

    /**
     * @param state second state
     */

    public boolean sameState(SearchState state) {
        EpuzzleState epuzzleState = (EpuzzleState) state;
        return Objects.deepEquals(puzzle, epuzzleState.getPuzzle());
    }

    /**
     * toString
     */

    public String toString() {
        String str = "\n";
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                str += "| " + puzzle[i][j] + " |";
            }
            str += "\n";
        }
        return str;
    }

}
