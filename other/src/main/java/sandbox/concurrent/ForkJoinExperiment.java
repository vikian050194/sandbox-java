package sandbox.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class ForkJoinExperiment {

    public static void main(String[] args) {
        var pLevel = 4;
        int threshold = 1000;

        long beginT;
        long endT;

        var pool = new ForkJoinPool(pLevel);

        var nums = new double[1000000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }

        var task = new ForkJoinExperimentTransform(nums, 0, nums.length, threshold);

        beginT = System.nanoTime();

//        pool.invoke(task);
        pool.execute(task);

        while (!task.isDone()) {
            System.out.println(pool);
        }

        endT = System.nanoTime();

        System.out.println(String.format("Level of parallelism: %d", pLevel));
        System.out.println(String.format("Sequential threshold: %d", threshold));
        System.out.println(String.format("Elapsed time: %d ns, %f s", endT - beginT, (endT - beginT) / 1000000000.0));
    }
}

class ForkJoinExperimentTransform extends RecursiveAction {

    int seqThreshold;

    double[] data;

    int start;
    int end;

    public ForkJoinExperimentTransform(double[] values, int s, int e, int t) {
        data = values;
        start = s;
        end = e;
        seqThreshold = t;
    }

    @Override
    protected void compute() {
        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                if (data[i] % 2 == 0) {
                    data[i] = Math.sqrt(data[i]);
                } else {
                    data[i] = Math.cbrt(data[i]);
                }
            }
        } else {
            int middle = (start + end) / 2;
            invokeAll(new ForkJoinExperimentTransform(data, start, middle, seqThreshold), new ForkJoinExperimentTransform(data, middle, end, seqThreshold));
        }
    }

}
