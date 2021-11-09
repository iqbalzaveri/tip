import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

class Skyline {

    public List<List<Integer>> getSkyline(int[][] buildings) {

        CriticalPoint[] criticalPoints = new CriticalPoint[buildings.length * 2];
        // 2D array contains start and end and the height ex: [[0,2,3],[2,5,3]]
        int index = 0;
        for (int row = 0; row < buildings.length; row++) {
            int start = buildings[row][0]; // Start
            int end = buildings[row][1]; // End
            int height = buildings[row][2]; // Height

            criticalPoints[index] = new CriticalPoint(start, height, true);
            criticalPoints[index + 1] = new CriticalPoint(end, height, false);
            index = index + 2;
        }

        // nlogn operation
        Arrays.sort(criticalPoints);

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(0, 1);
        List<List<Integer>> skylinePoints = new ArrayList<>();
        int prevht = 0;
        for (CriticalPoint criticalPoint : criticalPoints) {
            List<Integer> skylinePoint = new ArrayList<>();

            if (criticalPoint.isBuildingStart) {
                addToQueue(treeMap, criticalPoint.height);
            } else { //if it is end of building then decrement or remove the height from map.
                removeFromQueue(treeMap, criticalPoint.height);
            }
            int currentHt = treeMap.lastKey();
            if (prevht != treeMap.lastKey()) {
                skylinePoint.add(criticalPoint.x);
                skylinePoint.add(currentHt);
                skylinePoints.add(skylinePoint);
                prevht = currentHt;
            }


        }

        return skylinePoints;
    }

    private void removeFromQueue(TreeMap<Integer, Integer> queue, int height) {
        queue.compute(height, (key, value) -> {
            if (value == 1) {
                return null;
            }
            return value - 1;
        });
    }

    private void addToQueue(TreeMap<Integer, Integer> queue, int height) {
        queue.compute(height, (key, value) -> {
            if (value != null) {
                return value + 1;
            }
            return 1;
        });
    }

    static class CriticalPoint implements Comparable<CriticalPoint> {
        int x;
        boolean isBuildingStart;
        int height;

        CriticalPoint(int x, int height, boolean isBuildingStart) {
            this.x = x;
            this.height = height;
            this.isBuildingStart = isBuildingStart;
        }

        @Override
        public int compareTo(CriticalPoint secondPoint) {
            CriticalPoint firstPoint = this;
            // Scenario where X are not equal
            if (firstPoint.x != secondPoint.x) {
                return firstPoint.x - secondPoint.x;
            }
            // Scenarios where X is equal
            if (firstPoint.isBuildingStart != secondPoint.isBuildingStart) {
                return firstPoint.isBuildingStart ? -1 : 1;
            }
            // Scenario where X is equal and isBuildingStart booleans are same
            if (firstPoint.isBuildingStart) {
                return secondPoint.height - firstPoint.height;
            } else {
                return firstPoint.height - secondPoint.height;
            }
        }
    }
}

