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
        int [][] P1 = {
            {1,0,3},
            {4,2,6},
            {7,5,8}
        };
        int [][] P2 = {
            {4,1,3},
            {7,2,5},
            {0,8,6}
        };
        int [][] P3 = {
            {2,3,6},
            {1,5,8},
            {4,7,0}
        };
        SearchState initState = (SearchState) new EpuzzleState(P1);

        // Set off the search engine
        String res = searcher.runSearch(initState, "breadthFirst");

        // Print out the results
        System.out.println(res);
    }
    
}
