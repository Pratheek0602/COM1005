import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

public class RunEpuzzleAStar {

    public static void main(String[] arg) {

        // int seed = 23456;
   
        
        // EpuzzGen gen = new EpuzzGen(seed);

        // generate puzzle providing difficulty
        // int d = 6;

        int[][] tarPuzzle = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 0 }
        };
        int[][] P1 = {
                { 1, 0, 3 },
                { 4, 2, 6 },
                { 7, 5, 8 }
        };
        int[][] P2 = {
                { 4, 1, 3 },
                { 7, 2, 5 },
                { 0, 8, 6 }
        };
        int[][] P3 = {
                { 2, 3, 6 },
                { 1, 5, 8 },
                { 4, 7, 0 }
        };


        EpuzzleSearch searcher = new EpuzzleSearch(tarPuzzle);

        //generates tree seeds and take average of run time
        for (int d = 6; d <= 12; d++) {
                double runtime = 0;
                for (int j = 0; j <= 3; j++) {
                        int seed = j*10+121;
                        EpuzzGen gen = new EpuzzGen(seed);
                        SearchState initState = (SearchState) new EpuzzleState(gen.puzzGen(d),"manhattan",1,0);
                        float res = searcher.runSearchE(initState, "breadthFirst");
                        runtime += res;
                        
                }
                double averageRuntime = runtime/3;
                System.out.println("The average efficiency for difficulty "+ d + " is: "+ averageRuntime + "\n");
        }
        

        // SearchState initState = (SearchState) new EpuzzleState(P3, "manhattan", 1, 0);
        // SearchState initState = (SearchState) new EpuzzleState(P1, "hamming", 1,0);
        // SearchState initState = (SearchState) new EpuzzleState(gen.puzzGen(d),"hamming",1,0);

        // String res_astar = searcher.runSearch(initState, "Astar");
        // String res_astar = searcher.runSearch(initState, "Astar");
        // float res_astar = searcher.runSearchE(initState, "breadthFirst");

        // System.out.println(res_astar); 

    }

}
