import com.google.common.io.Resources;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class Utils {
    public static String readFile(String fileName) throws IOException {
        return Resources.toString(Resources.getResource(fileName), StandardCharsets.UTF_8);
    }
}