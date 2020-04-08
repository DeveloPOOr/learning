import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ju {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        byte[] s = "Ы".getBytes(StandardCharsets.UTF_8);
        for(byte byt : s){
            System.out.print(Byte.toUnsignedInt(byt) + " ");
        }
        byte[] D = inputStream.readAllBytes();
    }
}
