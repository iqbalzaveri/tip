package com.recursion;

public class SubSetInt {



  //static ArrayList<int[]> result = new ArrayList<>();
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] ary = {1,2,3};
    int[] result = new int[3];
    powerSet(ary, 0, result, 0, 5);
  }

  public static void printSubSet2(int[] ary, int read, int[] subSet, int write) {
    if(read==ary.length) {
      System.out.print("{");
      //Print output array subset
      for(int index = 0; index<write; index++) {
        System.out.print(subSet[index]);
        if (index + 1 != write) {
          System.out.print(",");
        }
      }
      System.out.print("}");
      System.out.println();
      //Arrays.fill(subSet, 0);
      return;
    }

    printSubSet2(ary, read+1, subSet, write); //don't select
    subSet[write] = ary[read]; //select
    printSubSet2(ary, read+1, subSet, write+1);



  }

  //
  // public static void printSubSet(int[] ary, int read, int[] subSet, int write) {
  //       if(read == ary.length) { // end of ary
  //         System.out.print("{");
  //         for(int index=0; index<write; index++) {
  //           System.out.print(subSet[index]);
  //           if(index+1 != write)
  //             System.out.print(",");
  //         }
  //
  //         System.out.println("}");
  //         return;
  //       }
  //
  //       printSubSet(ary, read+1, subSet, write); // don't select
  //       subSet[write] = ary[read]; // select
  //       printSubSet(ary, read+1, subSet, write+1);
  //
  // }



  public static void powerSet(int[] ary, int i, int[] result, int j, int target) {
    if(i == ary.length && target==0) {
      System.out.print("{");
      for(int index=0; index<j; index++) {
        System.out.print(result[index]);
        if(index+1 != j)
        System.out.print(",");
      }
      System.out.println("}");
      return;
    } else if(i == ary.length) {
      return;
    }

    powerSet(ary, i+1, result, j, target); //don't select
    result[j] = ary[i]; //select
    powerSet(ary, i+1, result, j+1, target-ary[i]);


  }


  public static boolean groupSum(int[] ary, int i, int target) {
    if(i == ary.length) {
        if(target==0) return true;
        else
            return false;
        //return (target==0);

    }

    return groupSum(ary, i+1, target)  //don't select
       || groupSum(ary, i+1, target-ary[i]); //select


  }




}
