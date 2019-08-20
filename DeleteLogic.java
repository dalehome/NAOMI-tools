public class DeleteLogic {

    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        for (int i = 0; i < 1000_000_000; i++) {
            delete(args);
        }
        long duration  = System.currentTimeMillis() - before;  
        System.out.println("\nTook " + duration + " ms");
    }

    private static void delete(String[] args) {
        int[] testValues = {3, 7, 0, 5 , 4, 2, 1};
           int dDay = 7;
           int offset = 4;
            if (args.length > 0 )
                offset = Integer.parseInt(args[0]);

            int director = (offset == 0) ? -dDay : offset / Math.abs(offset);

            int target = dDay - offset * director;  //int target = dDay - Math.abs(offset);
           /// System.out.println("Target " + target);
            

            for (int i : testValues) { // >=
                if (director * i  > director * target)  {
                     int z = (int)(Math.random() * 30); }
                    ///System.out.println(i + " will be deleted!");
            }
    }
}