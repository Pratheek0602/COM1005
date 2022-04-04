public class EpuzzleSearch extends Search{

    private int[][] target;

    /** @param tar */ 

    public EpuzzleSearch(int[][] tar){
        target = tar;
    }
    public EpuzzleSearch(int[] tarPuzzle) {
    }
    /**
     * accessor for target
     */
    public int[][] getTarget(){
        return target;
    }
}
