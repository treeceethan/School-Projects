# Radix Sort

This project randomly generates 1,000,000 random numbers and loads them into in array. 
Using the Radix sort, it sorts the integers.

## Example Output



![Sample Output](README.jpg)

## Analysis Steps

After implementing the Radix sort, I just had to create an array list and load it with
random integers. I put the radix sort into it's own method that took in an array and 
the max amount of numbers possible. 

### Design

I used the main method to generate the numbers, load the array, create start and end time, and print the result.
I used 2 other methods as well, one for the time and one for the Radix sort.
```
for (int i = 0; i < list.length; i++)
  {
    list[i] = (int) (Math.random() * number);
  }
```
```
static long time(long start, long end){}
```
```
static void radixSort(int[] list, int maxNumber){}
```


## Testing
Testing was seeing how fast my computer could compute the program. The fastest time I had was 440ms.

