
import java.io.IOException;


public class streams2_0 {
    public static void main(String[] args) throws IOException {
        int b = System.in.read();
        int c = 0;

       while (b > 0 ) {
           c = System.in.read();
           if(b == 13 && c == 10) {


            } else {
                System.out.write(b);



            }
           b = c;


        }
        System.out.flush();

    }
}
