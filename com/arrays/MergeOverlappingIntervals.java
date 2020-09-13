class Interval {
  int start; //epoch seconds
  int end;
  //consgtructor
} 

class MergeOverlappingIntervals {
  p s v main(String args[]) {
    Interval inv1 = new Interval(2,5);
    Interval inv2 = new Interval(2,3);
    Interval inv3 = new Interval(6,8);
    Interval inv4 = new Interval(7,10);
    
    /* 
    o/p 
    2,5
    6,10
    */
    
    List<Interval> intervals = new ArrayList<Interval>();
    intervals.add(inv1); //add others
    
    List<Interval> mergedIntervals = mergeIntervals(intervals);
    
  }
  
  static List<Interval> mergeIntervals(List<Interval> intervals) {
    //sort the interval
    Collections.sort(intervals, (a, b) -> a.start - b.start);
    List<Interval> resultIntervals = new ArrayList<Interval>();
    
    Interval mergedInterval = intervals.get(0);  //merged Interval
    for(int i=1; i<interval.size(); i++) {
      Interval currInterval = interval.get(i);
      if(currInterval.start <= mergedInterval.end) {
          //if there is an overlap with curr Interval
          mergedInterval = new Interval(mergedInterval.start, Math.max(mergedInterval.end, currInterval.end));
      } else {
        //if there is not an overlap with curr Interval
        resultIntervals.add(mergedInterval);
        mergedInterval = new Interval(currInterval.start, currInterval.end);
      }
    } // end of for loop
    resultIntervals.add(mergedInterval); //process last
    
    return resultIntervals;
  
  
  }

}
