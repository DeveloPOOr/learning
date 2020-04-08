import java.util.Scanner;

public class lesson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       /* int value = sc.nextInt();
        BigInteger factorial = BigInteger.ONE;
        for(int i = 1; i <= value; i++){
            BigInteger ram = BigInteger.valueOf(i);
            factorial = factorial.multiply(ram);

        }



        int[] a1 = {6};
        int[] a2 = {1, 3};
        int[] mas = new int[a1.length + a2.length];

        for (int i = 0, k = 0 , j = 0; j < a1.length + a2.length  ; j++) {
            if( k == a2.length || (i!= a1.length && a1[i] <= a2[k] ) ) {
                mas[j] = a1[i];
                i++;
            }else {
                if (i == a1.length || (k!= a2.length && a2[k] < a1[i])){
                mas[j] = a2[k];
                k++;}
            }

        }
        System.out.println(Arrays.toString(mas));
        */

       StringBuilder sb = new StringBuilder();

        String [] roles= {
                "Городничий","Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String [] textlines={"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

        for (int i = 0; i < roles.length; i ++) {
           sb.append(roles[i] + ":\n");
           for (int j = 0; j < textlines.length; j++) {
               if (textlines[j].startsWith(roles[i] + ":")) {
                   sb.append((j+1) + ") " + textlines[j].substring(roles[i].length()+2) + "\n");
               }
           }
            sb.append("\n");
       }
       String ans = sb.toString();
        System.out.println();

    }
}


