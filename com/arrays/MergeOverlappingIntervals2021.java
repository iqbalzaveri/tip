import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeOverlappingIntervals2021 {
  static class Interval {
    int start;
    int end;
    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public String toString() {
      return "[start=" + start + ", end=" + end + "]";
    }
  }

  public static void main(String[] args) {
    Interval int1 = new Interval(1, 3);
    Interval int2 = new Interval(2, 6);
    Interval int3 = new Interval(8, 10);
    Interval int4 = new Interval(2, 18);

    List<Interval> intervalList = new ArrayList<>();
    intervalList.add(int1);
    intervalList.add(int2);
    intervalList.add(int3);
    intervalList.add(int4);

    System.out.println("before merge:" + intervalList);
    List<Interval> mergedIntervalList = merge(intervalList);
    System.out.println("after merge:" + mergedIntervalList);


  }
  /* eg
  s - e
  1 - 3
  2 - 6
  8 - 10
  15 - 18
   */
  private static List<Interval> merge(List<Interval> intervalList) {
    List<Interval> resultIntervals = new ArrayList<>();
    //Collections.sort(intervalList, (intv1, intv2) -> { return intv1.start - intv2.start;});
    Collections.sort(intervalList, (intv1, intv2) -> intv1.start - intv2.start);

    Interval currIntv = intervalList.get(0);

    for(int i=1; i<intervalList.size(); i++) {
      Interval intv = intervalList.get(i);

      if(intv.start <= currIntv.end) {
        currIntv = new Interval(currIntv.start, Math.max(currIntv.end, intv.end));
      } else {
        resultIntervals.add(currIntv);
        currIntv = new Interval(intv.start, intv.end) ;
      }
    } // end of for loop
    resultIntervals.add(currIntv); //process the last element
    return resultIntervals;

  }


  static void printDuplicates(int[] arr) {

    for(int i=0; i<arr.length; i++) {

      // not seen
      if(arr[Math.abs(arr[i])-1] >= 0) { //not seen
        arr[arr[Math.abs(arr[i])-1]] = -arr[arr[Math.abs(arr[i])-1]]; //mark it as seen
      }else {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
    }
  }
}
