package sandbox.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class RecursiveTaskGenericDemo {

    public static void main(String[] args) {
        var pool = new ForkJoinPool();

        var nums = new double[5000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) (i % 2 == 0 ? i : -i);
        }

        var task = new RecursiveTaskGenericDemoAction(nums, 0, nums.length);

        pool.invoke(task);

        var summation = pool.invoke(task);

        System.out.println(String.format("Summation: %f", summation));
    }
}

class RecursiveTaskGenericDemoAction extends RecursiveTask<Double> {

    final int seqThreshold = 500;

    double[] data;

    int start;
    int end;

    public RecursiveTaskGenericDemoAction(double[] values, int s, int e) {
        data = values;
        start = s;
        end = e;
    }

    @Override
    protected Double compute() {
        double sum = 0;

        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        } else {
            int middle = (start + end) / 2;
            var taskA = new RecursiveTaskGenericDemoAction(data, start, middle);
            var taskB = new RecursiveTaskGenericDemoAction(data, middle, end);

// Option 1
            taskA.fork();
            taskB.fork();

            sum += taskA.join() + taskB.join();
// Option 2
//            taskA.fork();
//
//            sum += taskA.join() + taskB.invoke();
// Option 3
//            taskA.fork();
//
//            sum += taskA.join() + taskB.compute();
        }

        return sum;
    }

}
