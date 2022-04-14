import java.util.*;
public class RunEpuzzleAStar {
    public static void main(String[] arg) {

        int seed = 23456;
        EpuzzGen gen = new EpuzzGen(seed);

        // generate puzzle providing difficulty
        int d = 6;

        int [][] tarPuzzle = {
            {1,2,3},
            {4,5,6},
            {7,8,0}
        };
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
        
        EpuzzleSearch searcher = new EpuzzleSearch (tarPuzzle);
        // SearchState initState = (SearchState) new EpuzzleState(gen.puzzGen(d),1,0);
        SearchState initState = (SearchState) new EpuzzleState(P1,1,0);
        // SearchState initState = (SearchState) new EpuzzleState(P2,1,0);
        // SearchState initState = (SearchState) new EpuzzleState(P3,1,0);

        String res_astar = searcher.runSearch(initState, "Astar");
        System.out.println(res_astar);

    }
    
}
