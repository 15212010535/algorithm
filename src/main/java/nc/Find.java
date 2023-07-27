package nc;

/**
 * 二维数组中的查找
 */
public class Find {
    public static boolean Find(int target, int[][] array) {
        // write code here
        if(array.length==0||array[0].length==0){
            return false;
        }
        int i=0;
        int j=array[0].length-1;
        while(i<array.length&&j>=0){
            int num=array[i][j];
            if(num<target){
                i++;
            }else if(num>target){
                j--;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Find(15, new int[][]{{1, 2, 8, 9}, {
                2, 4, 9, 12
        }, {
                4, 7, 10, 13
        }, {
                6, 8, 11, 15
        }}));
    }
}
