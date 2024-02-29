public class NoChange {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        System.out.println("Showing inital values of array:");
        for (int x : nums) {
            System.out.print(x + " ");
            x = x * 10; // no effect on nums
        }

        System.out.println();
        System.out.println("Values of array after attempting to change each element");

        for (int x : nums)
            System.out.print(x + " ");

        System.out.println();
        System.out.println("Notice that we did not change anything in the array.");
    }
}
