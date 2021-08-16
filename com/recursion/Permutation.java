import java.util.Arrays;

public class Permutation {
    // T = O(n!)
    public static void main(String[] args) {
        int[] ary = {5, 6, 7};
        perm(ary);

    }

    private static void perm(int[] ary) {
        perm(ary, 0);
    }
    private static void perm(int[] ary, int i) {
        if(i==ary.length) {
            System.out.println(Arrays.toString(ary));
            return;
        }

        for(int j=i; j<ary.length; j++) {
            swap(ary, i, j);
            perm(ary, i+1);
            swap(ary, i, j); // backtracking
        }

    }

    static void swap(int[] ary, int x, int y) {
        int temp = ary[x];
        ary[x] = ary[y];
        ary[y] = temp;
    }
}
