

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
/*
Nearest Neighbor
Given a point P, and other N points in two dimensional space, find K points out of the N points
which are nearest to P.
* Distance between two points is measured by standard euclidean method.
(Hint: This problem can either be done with QuickSort partitioning, or can be done with Heaps.
Which one would you use? Why? Why not try both in your IDE and see the runtime for large
inputs?)
Interview time: 45 minutes
Solution: http://stackoverflow.com/questions/20398799/find-k-nearest-points-to-point-p-in-2-
dimensional-plane
 */

public class NearestNeighborPointWQuickSelect {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return x + ":" + y;
        }
    }

    static class DistanceComparator implements Comparator<Point> {
        Point c;

        DistanceComparator(Point c) {
            this.c = c;
        }

        public int compare(Point p1, Point p2) {
            return Integer.compare(NearestNeighborPointWQuickSelect.distance(p2, c), NearestNeighborPointWQuickSelect.distance(p1, c));
        }

    }

    public static void main(String args[]) throws Exception {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(30, 40);
        Point p3 = new Point(20, 30);
        Point p4 = new Point(15, 5);
        Point p5 = new Point(1, 4);

        Point c = new Point(15, 30);

        Point[] points = new Point[5];
        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
        points[3] = p4;
        points[4] = p5;

        int k = 3;
        List<Point> result = getKNearPoints(points, c, k);
        System.out.println("Result: " + result);

    }

    static List<Point> getKNearPoints(Point[] points, Point c, int k) {
        ArrayList<Point> result = new ArrayList<>(k);
        PriorityQueue<Point> queue = new PriorityQueue<>(k + 1, new DistanceComparator(c));
        for (Point p : points) {
            queue.offer(p);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        Iterator<Point> iter = queue.iterator();
        while (iter.hasNext()) {
            Point p = iter.next();
            result.add(p);
        }

        return result;
    }

    static int distance(Point p, Point c) {
        // return (p.x - c.x) * (p.x - c.x) + (p.y - c.y) * (p.y - c.y);
        int xDiff = (p.x - c.x);
        int yDiff = (p.y - c.y);
        return xDiff * xDiff + yDiff * yDiff;
    }

    private static List<Point> nearestKPoint_2(List<Point> list, final Point center, int k) {
        List<Point> ans = new ArrayList<>();
        Distance[] nums = new Distance[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new Distance(distance(center, list.get(i)), i);
        }
        quickSelect(nums, k);
        for (int i = 0; i < k; i++) {
            ans.add(list.get(nums[i].i));
        }
        return ans;
    }

    private static void quickSelect(Distance[] nums, int k) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int p = partition(nums, start, end);
            if (p == k) {
                return;
            } else if (p < k) {
                start = p + 1;
            } else {
                end = p - 1;
            }
        }
    }

    private static int partition(Distance[] nums, int start, int end) {
        Distance pivot = nums[start];
        int i = start, j = end + 1;
        while (true) {
            while (i < end && nums[++i].compareTo(pivot) < 0)
                ;
            while (j > start && nums[--j].compareTo(pivot) > 0)
                ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }

    private static void swap(Distance[] nums, int i, int j) {
        Distance tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

class Distance implements Comparable<Distance> {
    int d;
    int i;

    public Distance(int d, int i) {
        this.d = d;
        this.i = i;
    }

    @Override
    public int compareTo(Distance o) {
        return this.d - o.d;
    }
}