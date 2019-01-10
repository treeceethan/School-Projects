package radix;

import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {
        // declare variables
        final int NEXT_LINE = 10;
        int counter = 0;
        int number = 1_000_000;
        int[] list = new int[1_000_000];

        //loads array with randomly generated numbers
        for (int i = 0; i < list.length; i++)
        {
            list[i] = (int) (Math.random() * number);
        }
        // get start time
        long startTime = System.currentTimeMillis();

        // pass parameters list and number to radix sort method
        radixSort(list, number);

        long endTime = System.currentTimeMillis();

        System.out.println("Time: " + time(startTime, endTime) +
                          " milliseconds to sort 1,000,000 randomly generated integers.");

        //prints array for fun
//        for(int i = 0; i < list.length; i++)
//        {
//            counter++;
//            System.out.print(list[i] + " ");
//
//            if((counter == NEXT_LINE))
//            {
//                counter = 0;
//                System.out.println();
//            }
//        }

    }
    // method that returns how long the sort took
    static long time(long start, long end)
    {
        long time = (end - start);
        return time;
    }

    // Radix sort data structure
    static void radixSort(int[] list, int maxNumber) {
        for (int order = 1; order < maxNumber; order *= 10) {
            @SuppressWarnings("unchecked")
            ArrayList<Integer>[] bucket = new ArrayList[10];

            for (int i = 0; i < bucket.length; i++)
            {
                bucket[i] = new java.util.ArrayList<>();
            }

            for (int i = 0; i < list.length; i++)
            {
                bucket[(list[i] / order) % 10].add(list[i]);
            }

            int k = 0;
            for (int i = 0; i < bucket.length; i++)
            {
                if (bucket[i] != null)
                {
                    for (int j = 0; j < bucket[i].size(); j++)
                        list[k++] = bucket[i].get(j);
                }
            }
        }
    }

}