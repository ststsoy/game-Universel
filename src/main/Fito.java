package main;

public class Fito {
    public static void main (String[] args) {
        System.out.println (nub(0));

    }

    private static boolean nub(int h) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int low = 0;
        int higth = arr.length-1;
        while (low < higth) {
            int mid = (low + higth) / 2;
            if (h == arr[mid]) {
                return true;
            } else {
                if (h < arr[mid]) {
                    higth = mid;
                } else {
                    low = mid + 1;
            }

        }
    }

         return false;
    }
}
