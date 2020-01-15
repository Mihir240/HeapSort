package sortingAl;
import java.util.Random;

public class HeapSort 
{
	public static <T extends Comparable<? super T>> void heapSort(T[] array)
	 {
		maxheap(array);
	   
		for(int i = (array.length-1); i >= 1; i--)
		{
		  T temp = array[i];
		  array[i] = array[0];
		  array[0] = temp;
		  heapify(array,0,i);	
		}
	 }
	 private static <T extends Comparable <? super T>> void maxheap(T [] array)
	 {
		 for(int h = (array.length/2); h>=0;h--)// start from the middle of the array and work your way upwards
		 {
			 heapify(array,h,array.length);
		 }
	 }
	 private static <T extends Comparable<? super T>> void heapify(T[] array,int n,int len)
	 {
		 int parent = n;
		 int lChild = 2*n+1;
		 int rChild = 2*n+2;
		 
		 // if there are no children for the parent
		 if(lChild >= len && rChild >= len)
		 {
			 return;
		 }
		 // if there is only the left child
		 else if(rChild >= len)
		 {
			 if(array[parent].compareTo(array[lChild]) == -1)
			 {
				swap(array,parent,lChild,len);
			 }
		 }
		 // if the parent is less than 
		 else if(array[parent].compareTo(array[lChild]) == -1 || array[parent].compareTo(array[rChild]) == -1 )	
		 {
			 if(array[lChild].compareTo(array[rChild])== 1)// if left child is bigger than the right child 
			 {
			       swap(array,parent,lChild,len);
			 }
			 
			 else if( array[lChild].compareTo(array[rChild])==0)// if both the children are equal to each other but are both greater than the parent
			 {
				 swap(array,parent,rChild,len);
			 }
			 else //  if the right child is bigger than the left child
			 {
				 swap(array,parent,rChild,len);
			 }
	     }
		 else 
		 {
			 return;
		 }
	 }
	 
	 private static<T extends Comparable<? super T>> void swap(T [] array,int p, int c, int len)
	 {
		 T temp =  array[p];
		 array[p] = array[c];
		 array[c] = temp;
		 heapify(array,c,len);
	 }
	 
	 public static void main(String [] args)
	 {
		 
	     int sum = 1000000;
	     Integer[] a = new Integer[sum];
	     Random rand = new Random(1);

	     for (int i = 0; i < a.length; ++i) {
	           a[i] = rand.nextInt(sum);
	     }

	     long start = System.currentTimeMillis();
	     heapSort(a);
	     long stop = System.currentTimeMillis();
	     System.out.print("select: " + (stop - start) + " ");
	     
	     for(Integer i: a)
			System.out.println(i); 
	 }

}
