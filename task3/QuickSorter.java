package HW02.task3;

public class QuickSorter implements Sorter{

    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
        
    }

    private  void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    public  void quickSort(int[] arr,int low,int high){
        int i,j,temp;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        temp = arr[low];
        while (i<j) {
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            if (i<j) {
                swap(i, j);
            }
 
        }
        swap(i, low);
        quickSort(arr, low, j-1);
        quickSort(arr, j+1, high);
    }
 

    @Override
    public void sort() {
        quickSort(a, 0, a.length-1);
    }

    private String plan = "";

    @Override
    public String getPlan() {
        return this.plan;
    }
    
}