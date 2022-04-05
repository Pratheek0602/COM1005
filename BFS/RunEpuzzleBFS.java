import java.util.*;
public class RunEpuzzleBFS {

    public static void main(String[] arg) {

        // Goal state (target)
        int [][] tarPuzzle = {
            {1,2,3},
            {4,5,6},
            {7,8,0}
        };
        EpuzzleSearch searcher = new EpuzzleSearch(tarPuzzle);

        // Define the start initial state 
        int [][] initPuzzle = {
            {1,0,3},
            {4,2,6},
            {7,5,8}
        };
        SearchState initState = (SearchState) new EpuzzleState(initPuzzle);


        // Set off the search engine
        String res = searcher.runSearch(initState, "breadthFirst");

        // Print out the results
        System.out.println(res);
    }
    
}
