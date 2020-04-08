import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {
    private byte[] mas;
    public AsciiCharSequence(byte[ ] as){
        this.mas = as.clone();
    }

    @Override
    public char charAt(int i) {

        return (char) mas[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        byte[] j = Arrays.copyOfRange(mas, i, i1);
        AsciiCharSequence ans = new AsciiCharSequence(j);

        return ans;
    }

    @Override
    public int length() {
        return mas.length;
    }

    @Override
    public String toString() {
        String ans = new String(mas);



        return ans;
    }
}


class Main {

    public static void main(String[] args) {

        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность - " + answer.toString());//Hello!
        System.out.println("Размер её - " + answer.length());//6
        System.out.println("Символ под № 1 - " + answer.charAt(1));//e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5));//ello
//проверка на нарушение инкапсуляции private поля
        System.out.println(answer.toString());//Hello!
        example[0] = 74;
        System.out.println(answer.toString());//Hello!
    }

}






