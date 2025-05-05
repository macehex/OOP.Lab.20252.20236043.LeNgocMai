import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args){
        //String
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        for(int i =0 ; i<65536;i++){
            s += r.nextInt(2);
        }
        System.out.println("Time for String concat: " + (System.currentTimeMillis() - start) + "ms");

        //String builder
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for(int i =0; i< 65536;i++){

            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        System.out.println("Time for StringBuilder: " + (System.currentTimeMillis() - start) + "ms");
        //String buffer
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sbuff = new StringBuffer();
        for(int i =0; i< 65536;i++){

            sbuff.append(r.nextInt(2));
        }

        System.out.println("Time for StringBuffer: " + (System.currentTimeMillis() - start) + "ms");

    }
}