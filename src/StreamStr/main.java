package StreamStr;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = "";

            text = sc.nextLine();


        System.out.println(text);
        List<String> list = Arrays.asList(text.toLowerCase().split("[\\p{Punct}\\s]+"));
        Map<String, Long> counted = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        counted.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .sorted(Comparator.comparing((Map.Entry<String, Long> entry) -> entry.getValue()).reversed()).forEach(x -> System.out.println(x.getKey()));




    }
}
