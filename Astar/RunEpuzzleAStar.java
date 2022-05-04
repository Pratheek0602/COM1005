import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

public class RunEpuzzleAStar {

        public static void main(String[] arg) {

                // generate puzzle providing difficulty
                int d = 6;

                // Goal state (target)
                int[][] tarPuzzle = {
                                { 1, 2, 3 },
                                { 4, 5, 6 },
                                { 7, 8, 0 }
                };

                EpuzzleSearch searcher = new EpuzzleSearch(tarPuzzle);

                // generates three seeds and take average of runtime
                double runtime = 0;
                for (int j = 0; j <= 3; j++) {
                        int seed = j * 10 + 121;
                        EpuzzGen gen = new EpuzzGen(seed);
                        SearchState initState = (SearchState) new EpuzzleState(gen.puzzGen(d), "manhattan", 1, 0);
                        float res = searcher.runSearchE(initState, "Astar");
                        runtime += res;

                }
                double averageRuntime = runtime / 3;
                System.out.println("The average efficiency for difficulty " + d + " is: " + averageRuntime + "\n");

        }

}
