public class EpuzzleSearch extends Search{

    private int[][] target;

    /** @param tar */ 

    public EpuzzleSearch(int[][] tar){
        target = tar;
    }

    /**
     * accessor for target
     */
    public int[][] getTarget(){
        return target;
    }
}
