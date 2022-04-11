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
        
        EpuzzleSearch searcher = new EpuzzleSearch (tarPuzzle);
        SearchState initState = (SearchState) new EpuzzleState(gen.puzzGen(d),0,0);

        String res_astar = searcher.runSearch(initState, "AStar");
        System.out.println(res_astar);

    }
    
}
