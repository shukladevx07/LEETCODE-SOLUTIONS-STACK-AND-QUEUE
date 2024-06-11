import java.util.Stack;

class CustomStack {
    private int maxSize;
    private Stack<Integer> stack;
    private int[] increments;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new Stack<>();
        this.increments = new int[maxSize];
    }

    public void push(int x) {
        if (stack.size() < maxSize) {
            stack.push(x);
        }
    }

    public int pop() {
        int index = stack.size() - 1;
        if (index < 0) {
            return -1;
        }
        if (index > 0) {
            increments[index - 1] += increments[index];
        }
        int result = stack.pop() + increments[index];
        increments[index] = 0;
        return result;
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, stack.size());
        if (limit > 0) {
            increments[limit - 1] += val;
        }
    }

}
