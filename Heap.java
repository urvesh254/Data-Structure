/*
	Note: Before add or delete the element make sure the array is in max heap form.
 */

import java.util.*;

public class Heap 
{

	// Normal method O(n*log n) time for convert array to Heap
	private static void convertHeap(int[] arr){
		int len=arr.length;

		for(int i=len/2-1;i>0;i--){
			int parent=(i-1)/2;
			int min=i;

			while(parent>=0){
				if(arr[min]>arr[parent]){
					min=parent;
				}
				if(parent==0)
					break;
				parent=(parent-1)/2;
			}

			if(min!=i){
				arr[min]=arr[min]^arr[i];
				arr[i]=arr[min]^arr[i];
				arr[min]=arr[min]^arr[i];
			}
		}
	}

	private static void heapify(int[] arr,int i,int len){
		int left=2*i+1;
		int right=2*i+2;
		int max=i;

		if(left<len && arr[max]<arr[left])
			max=left;
		if(right<len && arr[max]<arr[right])
			max=right;

		if(max!=i){
			swap(arr,max,i);

			heapify(arr,max,len);
		}
	}

	public static void heapify(int[] arr){
		int len=arr.length;

		for(int i=len/2-1;i>=0;i--){
			heapify(arr,i,len);
		}
	}

	// HeapSort logic
	private static void heapSort(int[] arr){
		// convertHeap(arr);
		int len=arr.length;

		heapify(arr);

		for(int i=len-1;i>0;i--){
			swap(arr,0,i);

			heapify(arr,0,i);
		}

	}

	private static void swap(int[] arr,int i,int j){
		arr[i]=arr[i]^arr[j];
		arr[j]=arr[i]^arr[j];
		arr[i]=arr[i]^arr[j];
	}

	// Add element in heap
	private static int[] add(int temp[],int data){
		int arr[] = new int[temp.length+1];
		int len=arr.length-1;

		for(int i=0;i<len;i++)
			arr[i]=temp[i];
		arr[len]=data;

		int parent=(len-1)/2;
		int min=len;

		while(parent>=0){
			if(arr[min]>arr[parent]){
				arr[min]=arr[min]^arr[parent];
				arr[parent]=arr[min]^arr[parent];
				arr[min]=arr[min]^arr[parent];
				min=parent;
			}else{
				break;
			}

			if(parent==0)
				break;
			parent=(parent-1)/2;
		}

		return arr;
	}

	// Delete element from heap
	private static int[] delete(int arr[]){
		int len=arr.length-1;
		int i=0,left,right,min=0;
		
		arr[len]=arr[len]^arr[0];
		arr[0]=arr[len]^arr[0];
		arr[len]=arr[len]^arr[0];

		heapify(arr,0,len);

		return Arrays.copyOfRange(arr,0,arr.length-1);
	}
}
