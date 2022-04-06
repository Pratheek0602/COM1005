
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

    ArrayList<EpuzzleState> epuzzleStatesList = new ArrayList<EpuzzleState>();

    private EpuzzleState MoveUp() {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                if (i > 0 && puzzle[i][j] == 0) {
                    int temp = puzzle[i][j];
                    puzzle[i][j] = puzzle[i - 1][j];
                    puzzle[i - 1][j] = temp;
                    EpuzzleState epuzzleState = new EpuzzleState(puzzle);
                    epuzzleStatesList.add(epuzzleState);
                }
            }
        }
        return null;

    }

    private EpuzzleState MoveDown() {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                if (i < 2 && puzzle[i][j] == 0) {
                    int temp = puzzle[i][j];
                    puzzle[i][j] = puzzle[i + 1][j];
                    puzzle[i + 1][j] = temp;
                    EpuzzleState epuzzleState = new EpuzzleState(puzzle);
                    epuzzleStatesList.add(epuzzleState);
                }
            }

        }
        return null;

    }

    private EpuzzleState MoveRight(int x, int y) {
        if (y < 2) {
            int temp = puzzle[x][y];
            puzzle[x][y] = puzzle[x][y + 1];
            puzzle[x][y + 1] = temp;
            EpuzzleState epuzzleState = new EpuzzleState(puzzle);
            epuzzleStatesList.add(epuzzleState);

        }
        return null;
    }

    private EpuzzleState MoveLeft() {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                if (j > 0 && puzzle[i][j] == 0) {
                    int temp = puzzle[i][j];
                    puzzle[i][j] = puzzle[i][j - 1];
                    puzzle[i][j - 1] = temp;
                    EpuzzleState epuzzleState = new EpuzzleState(puzzle);
                    epuzzleStatesList.add(epuzzleState);
                }
            }

        }
        return null;
    }

    /**
     * getSuccessors
     * 
     * @param searcher - the current search engine
     * 
     *                 method will return list of possible successors
     */

    public ArrayList<SearchState> getSuccessors(Search searcher) {
        // EpuzzleSearch epuzzleSearch = (EpuzzleSearch) searcher;
        // int[][] target = epuzzleSearch.getTarget();

        ArrayList<EpuzzleState> epuzzleStatesList = new ArrayList<EpuzzleState>(); // the list of jugs states
        ArrayList<SearchState> searchStatesList = new ArrayList<SearchState>();

        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                if (puzzle[i][j] == 0) {
                    MoveUp();
                    MoveDown();
                    MoveRight();
                    MoveLeft();
                    epuzzleStatesList.add(new EpuzzleState(puzzle));
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
     * sameState - do 2 JugsSearchNodes have the same state?
     * 
     * @param state second state
     */

    public boolean sameState(SearchState state) {
        EpuzzleState epuzzleState = (EpuzzleState) state;

        return (puzzle == epuzzleState.getPuzzle());
    }

    /**
     * toString
     */

    public String toString() {
        String str = "\n";
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                str += puzzle[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }

}
