class NoBody {
    public static void main(String[] args) {
        int i, j;
        i = 100;
        j = 200;

        while (++i < --j)
            ; // No body for this loop

        System.out.println("Midpoint is " + i);
    }
}