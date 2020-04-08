
import java.util.*;

public class colllectors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> list = new LinkedList<>();
        int i = 0;

        while(sc.hasNext()) {
            int a = sc.nextInt();
            if( i % 2 == 0) {
                list.add(new Integer(a));

            }
            i++;
        }
        Integer element;
        while(((element = list.pollLast()) != null)) {
            System.out.println(element);
        }


    }


    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> finalset = new HashSet<>();
        for( T element : set1) {
            if(!set2.contains(element)) {
                finalset.add(element);
            }
        }
        for( T element : set2) {
            if(!set1.contains(element)) {
                finalset.add(element);
            }
        }

        return finalset;
    }






}
