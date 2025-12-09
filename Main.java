import DSA.*;

public class Main {

    public static void main(String[] args) {
        Search s = new Search();
        int arr[] = new int[]{1,2,3,4,5};
        int index = s.Linearsearch(arr,5,6);
        if(index == -1){
            System.out.println("not found");
        }
        else{
            System.out.println("found");
        }
     
    }
}
