public student sort (student stud)
{
//    private double avg = 0;
    /* low  --> Starting index,  high  --> Ending index */
    quickSort(student[] array, int low, int high)
    {
        if (low.getRating() < high.getRating())
        {
            /* pi is partitioning index, arr[p] is now
               at right place */
            pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);  // Before pi
            quickSort(arr, pi + 1, high); // After pi
        }
    }
    quickSort(stud.getPriorityQueue(), 0, stud.getPriorityQueue.length());
}