public class QuickSort {
  static void quickSort(Order[] orders,int low,int high) {
    if (low>high) return;
    int pi = partition(orders, low, high);
    quickSort(orders, low, pi-1);
    quickSort(orders,pi+1,high);
  }

  static int partition(Order[] orders,int low,int high) {
    Order pivot = orders[low];
    int i=low,j=high;
    
    while (i<j) {
      while (orders[i].getTotalPrice() <= pivot.getTotalPrice() && i<high)
        i++;
      while (orders[j].getTotalPrice()>pivot.getTotalPrice() && j>low)
        j--;

      if (i<j)
        swap(orders,i,j);
    }

    swap(orders,low,j);
    return j;
  }

  static void swap(Order[] orders,int i,int j) {
    Order tmp = orders[i];
    orders[i] = orders[j];
    orders[j] = tmp;
  }
}
