import java.util.*;

class Point {
    int x,y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

     public String toString() {
        return "x: " + x + " y: " + y;
    }
}

class DistanceComparator implements Comparator<Point> {
    Point c;
    DistanceComparator(Point c) {
        this.c = c;
    }
    public int compare(Point p1,Point p2) {
        return Integer.compare(distance(p2,c), distance(p1, c));
    }
    static int distance(Point p, Point c) {
        int xDiff = p.x - c.x;
        int yDiff = p.y - c.y;
        return xDiff * xDiff + yDiff * yDiff;
    }
}



public class NearestNeighborPoint {


    public static void main(String[] args) {
        Point p1 = new Point(1,2);
        Point p2 = new Point(30,40);
        Point p3 = new Point(20,30);
        Point p4 = new Point(15,5);
        Point p5 = new Point(1,4);

        Point c = new Point(15, 30);

        Point[] points = new Point[5];
        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
        points[3] = p4;
        points[4] = p5;

        int k = 3;
        List<Point> result = getKNearPoints(points, c, 3);
        System.out.println("Result: " + result);
    }

    static List<Point> getKNearPoints(Point[] points, Point c, int k) {
        PriorityQueue<Point> pQueue = new PriorityQueue<>(k+1, new DistanceComparator(c));
        for(Point p : points) {
            pQueue.offer(p);    // log k
            if(pQueue.size() > k) {
                pQueue.poll();   // log k
            }
        }
        //upto this point O(p log k + log k) => O(p log k)

        List<Point> result = new ArrayList<Point>();
        Iterator<Point> iter = pQueue.iterator();
        while(iter.hasNext()) { // O(k)
            Point p = iter.next();
            result.add(p);
        }
        // O(p log k + k) or O(p log k)
        return result;
    }
}
