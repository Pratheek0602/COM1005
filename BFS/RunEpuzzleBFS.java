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
            {2,3,6},
            {1,5,8},
            {4,7,0}
        };
        SearchState initState = (SearchState) new EpuzzleState(initPuzzle);


        // Set off the search engine
        String res = searcher.runSearch(initState, "breadthFirst");
        // String res = searcher.runSearch(initState, "depthFirst");

        // Print out the results
        System.out.println(res);
    }
    
}
