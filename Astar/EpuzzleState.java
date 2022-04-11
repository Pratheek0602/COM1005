import java.util.*;

public class EpuzzleState extends SearchState {

    private int[][] puzzle = new int[3][3];

    public EpuzzleState(int[][] puzzle, int lc, int rc){
        this.puzzle = puzzle;
        localCost = lc;
        estRemCost = rc;
    }

    public int[][] getPuzzle(){
        return puzzle;
    }

    public boolean goalPredicate(Search searcher) {
        EpuzzleSearch epuzzleSearch = (EpuzzleSearch) searcher;
        int[][] target = epuzzleSearch.getTarget(); 
        return Objects.deepEquals(target, puzzle);
    }


    public int manhattan(){
        int sum = 0;    // number of blocks out of place
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                if(puzzle[i][j] != 0 && puzzle[i][j] != i + 1); // count for blocks in wrong place
                sum += sum.getestRemCost(puzzle[i][j]);
                ;  
            } 
        }
        return sum;

    }

    public int hamming(){
        int count = 0;    // number of blocks out of place
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle.length; j++) {
                if(puzzle[i][j] != 0 && puzzle[i][j] != i + 1); // count for blocks in wrong place
                count++;  
            } 
        }
        return count;

    }



    public ArrayList<SearchState> getSuccessors(Search searcher) {

        ArrayList<EpuzzleState> epuzzleStatesList = new ArrayList<EpuzzleState>(); // the list of epuzzle states
        ArrayList<SearchState> searchStatesList = new ArrayList<SearchState>();








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
        
    }

  
    
}
