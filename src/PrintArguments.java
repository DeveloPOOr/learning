import java.util.Arrays;

public class PrintArguments {
    public static void main(String[] args) {

             char b  = '\\';
             int num = b;
             num+=32;
             char h = (char) num;

             int value = Integer.bitCount(-8);



            String text = "Madam, I'm Adam!";
            text = text.replaceAll("[^a-zA-Z0-9]","");   // это жоска
            StringBuilder sb = new StringBuilder(text);
            sb = sb.reverse();
            String ans1 = new String(sb);
            boolean ans = text.equalsIgnoreCase(ans1);

            byte[] mas = {101, 102};


        System.out.println() ;

    }
    public static int flipBit(int value, int bitIndex) {
        int bit = 1 << (bitIndex-1);
        if ( (value | bit) == (value ^ bit)){
            value += bit;
        }else{
            value -= bit;
        }
        return value;
    }
}

