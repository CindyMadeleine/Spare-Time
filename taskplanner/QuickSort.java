public class QuickSort{
      private Task[] tasklist;    
      private int nrOfTasks;

      /**
      * Check if tasklist is not set or the length is zero.
      * Set amount of task to tasklist.length and start with quicksort.
      * @param tasklist: The list of task you want to sort.
      **/
    public void sort(Task[] tasklist) {
            // check for empty or null array
            if (tasklist ==null || tasklist.length==0){
                    return;
            }

            this.tasklist = tasklist;
            nrOfTasks = tasklist.length;
            quicksort(0, nrOfTasks - 1);
    }

    /**
    *   Sorts each task based on their earliest ending time. 
    *   
    * Start with setting i equal to low and j equal to high. Second the pivotTask to the task between
    * high and low. The method then calculate when the earliest end time of pivot task earliest is. 
    *
    * The method then sorts by recursion until the both task i have greater earliest end time than 
    * task j. When performing sorting the method first compare all the task from low to pivot task
    * until a task that has later end time than pivot is reached. This is performed by increasing i.
    * Secondly the recursion compare all the task from high to pivot task  until a task that have
    * earlier end time than pivot is reached. This is performed by increasing j. If task i has ends
    * earlier or equal to task j, j and i is swapped and both i and j is increased. 
    *
    * The method perform quicksort again if the task we started to sort on ends earlier than the last
    * indeks we performed sorting on and/or the task we started to sort on ends later than the first 
    * indeks we performed sorting on. The methods recursiv calls ends when neither of these cases are 
    * satisfied.
    * @param low: index to the task you want to start to sort on.
    * @param high: index to the task you want to start to sort on.
    **/
    private void quicksort(int low, int high) {
        int i = low, j = high;
        Task pivotTask = tasklist[low + (high-low)/2];
        int pivot = pivotTask.earlieststart + pivotTask.estimatedTime; //The earliest end of pivotTask
        while (i <= j) {
                while (tasklist[i].earlieststart + tasklist[i].estimatedTime < pivot) {
                        i++;
                }
                while (tasklist[j].earlieststart + tasklist[j].estimatedTime > pivot) {
                        j--;
                }

                if (i <= j) {
                        swap(i, j);
                        i++;
                        j--;
                }
        }
        // Recursion
        if (low < j)
                quicksort(low, j);
        if (i < high)
                quicksort(i, high);
    }

    /** 
    *   Swap tasks at position i and j in the tasklist.
    *   @param i : Task index in tasklist
    *   @param j : Task index in tasklist
    **/
    private void swap(int i, int j) {
        Task temp = tasklist[i];
        tasklist[i] = tasklist[j];
        tasklist[j] = temp;
    }
}