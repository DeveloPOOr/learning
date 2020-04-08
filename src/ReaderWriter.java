
import java.util.Locale;
import java.util.Scanner;

public class ReaderWriter {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
        double sum = 0;
        while (sc.hasNext()) {
            try{
                sum += Double.parseDouble(sc.next());
            }catch (NumberFormatException e){

            }

        }
        System.out.printf("%6f",sum);
    }
}
