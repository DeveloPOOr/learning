import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Streams {
    public static void main(String[] args) throws IOException {
        InputStream stream;
        int result;
        stream = getStream( new byte[] { 0x33, 0x45, 0x01});

        result = checkSumOfStream(stream);
        System.out.print(result);
    }

    public static InputStream getStream(byte [] data)  {
        return new ByteArrayInputStream(data);
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int b;
        int c = 0;
        while ((b = inputStream.read()) > 0) {
            c = Integer.rotateLeft(c,1) ^b;
        }
        return c;
    }
}
