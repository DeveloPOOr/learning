import java.io.*;
import java.util.Objects;

public class serial {
    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] mas = null;
        try{
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            int a = ois.readInt();
            mas = new Animal[a];
            for(int i = 0; i < a; i++) {
                mas[i] = (Animal) ois.readObject();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return mas;
    }

}

class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
}