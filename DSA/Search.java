package DSA;

import java.util.Arrays;
public class Search {

    public int Linearsearch(int arr[], int n, int k){
        for(int i = 0; i<n;++i){
            if(arr[i]==k){
               return i;
            }
        }
        return -1;
    }
    public int Binarysearch(int arr[], int n, int k){
        Arrays.sort(arr);
        int left = 0;
        int right = n-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == k){
                return mid;
            }
            else if(arr[mid] < k){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
    public int ternarysearch(int arr[], int n, int k){
        Arrays.sort(arr);
        int left = 0;
        int right = n-1;
        while(left <= right){
            int mid1 = left + (right - left)/3;
            int mid2 = right - (right - left)/3;
            if(arr[mid1] == k){
                return mid1;
            }
            else if(arr[mid2] == k){
                return mid2;
            }
            else if(k < arr[mid1]){
                right = mid1 - 1;
            }
            else if(k > arr[mid2]){
                left = mid2 + 1;
            }
            else{
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }
        return -1;
    }
    
}
