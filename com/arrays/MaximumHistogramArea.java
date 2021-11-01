import java.util.Stack;

public class MaximumHistogramArea {
    int maxArea = 0;
    Stack<Integer> stack = new Stack<Integer>();

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        int previousBarHeight = 0;
        for (int i = 0; i < heights.length; i++) {

            if (heights[i] >= previousBarHeight) {
                previousBarHeight = heights[i];
            } else {
                startPopping(heights, heights[i], i);
            }
            stack.push(i);
        }

        startPopping(heights, 0, heights.length);
        return maxArea;
    }

    private void startPopping(int[] heights, int nextHeight, int nextIndex) {
        while (!stack.isEmpty() && nextHeight <= heights[stack.peek()]) {
            int index = stack.pop();
            int area = 0;
            if (stack.isEmpty()) {
                area = heights[index] * (nextIndex);
            } else {
                area = heights[index] * (nextIndex - stack.peek() - 1);
            }
            if (maxArea < area) {
                maxArea = area;
            }
        }

    }
}
