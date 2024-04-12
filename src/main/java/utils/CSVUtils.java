package utils;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CSVUtils {
//    Create a final variable to hold the comma separator since this value does not change.
    private static final char DEFAULT_SEPARATOR = ',';

//    Writer object represents the file to write to.
//    The next param is a list of String objects that represents the data to write to CSV format.
    public static void writeLine(Writer w, List<String> values) throws IOException {
        boolean first = true;
//        Use a StringBuilder to create the CSV string.
        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(DEFAULT_SEPARATOR);
            }
            sb.append(value);
            first = false;
        }
        sb.append("\n");
//        Append the string to the CSV file.
        w.append(sb.toString());
    }
}
