package sandbox.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class ForkJoinDemo {

    public static void main(String[] args) {
        var pool = new ForkJoinPool();

        var nums = new double[100000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }

        System.out.println("A portion of the original sequence:");

        for (int i = 0; i < 10; i++) {
            System.out.print(String.format("%f ", nums[i]));
        }

        System.out.println("\n");

        var task = new SqrtTransform(nums, 0, nums.length);

        pool.invoke(task);

        System.out.println("A portion of the transformed sequence (to four decimal places):");

        for (int i = 0; i < 10; i++) {
            System.out.print(String.format("%.4f ", nums[i]));
        }
    }
}

class SqrtTransform extends RecursiveAction {

    final int seqThreshold = 1000;

    double[] data;

    int start;
    int end;

    public SqrtTransform(double[] values, int s, int e) {
        data = values;
        start = s;
        end = e;
    }

    @Override
    protected void compute() {
        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        } else {
            int middle = (start + end) / 2;
            invokeAll(new SqrtTransform(data, start, middle),
                    new SqrtTransform(data, middle, end));
        }
    }

}
