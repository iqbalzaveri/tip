public class PowerSet {

    public static void main(String[] args) {
        int[] ary = {1, 2, 3};
        printPowerSet(ary);
        System.out.println("====");
        //printPowerSetFirstDontSelect(ary);
    }

    public static void printPowerSet(int[] ary) {
        int[] outputAry = new int[ary.length];
        printPowerSet(ary, 0, outputAry, 0);
    }

    public static void printPowerSetFirstDontSelect(int[] ary) {
        int[] outputAry = new int[ary.length];
        printPowerSet2(ary, 0, outputAry, 0);
    }

    public static void printPowerSet(int[] ary, int read, int[] outputAry, int write) {
        // base case; once we find the solution ie reach to the end of the input array; print the set
        if(read == ary.length) {
            //print the set
            System.out.print("{");
            for(int i=0; i < write; i++) {
                System.out.print(outputAry[i]);
                System.out.print(",");
            }
            System.out.println("}");
            return;
        }

        //recurse case
        // Select
        outputAry[write] = ary[read];
        printPowerSet(ary, read+1, outputAry, write + 1);

        //don't Select
        printPowerSet(ary, read+1, outputAry, write);
        return;
    }





    public static void printPowerSet2(int[] ary, int read, int[] outputAry, int write) {
        // base case; once we find the solution ie reach to the end of the input array; print the set
        if(read == ary.length) {
            //print the set
            System.out.print("{");
            for(int i=0; i < write; i++) {
                System.out.print(outputAry[i]);
                System.out.print(",");
            }
            System.out.println("}");
            return;
        }

        //recurse case

        //don't Select
        printPowerSet2(ary, read+1, outputAry, write);

        // Select
        outputAry[write] = ary[read];
        printPowerSet2(ary, read+1, outputAry, write + 1);

    }

}
