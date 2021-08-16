public class GroupSum {

    public static boolean groupSum(int[] ary, int target) {
        return groupSum(ary, 0, target);
    }

    public static boolean groupSum(int[] ary, int i, int target) {
        if(i == ary.length) {
            if(target == 0) {
                return true;
            } else {
                return false;
            }
        }

        if(groupSum(ary, i+1, target-ary[i])) {  // select ith element
            return true;
        }

        if(groupSum(ary, i+1, target)) {             //don't select ith select
            return true;
        }

        return false;
    }

    public static boolean groupSum2(int[] ary, int i, int target) {
        if(i == ary.length) {
            return target == 0;
        }

        return groupSum2(ary, i+1, target-ary[i]) || groupSum2(ary, i+1, target);

    }

}
