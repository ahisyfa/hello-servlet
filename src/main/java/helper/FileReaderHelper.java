package helper;

import java.io.*;

/**
 * @author Ahmad Isyfalana Amin
 * @version $Id: FileReaderHelper.java, v 0.1 2020-03-21  21.13 Ahmad Isyfalana Amin Exp $
 */
public class FileReaderHelper {

    private static final String HTML_RESOURCE = "src/main/resources/html/";

    public static synchronized String getContent(String path) throws IOException {
        File file = new File(HTML_RESOURCE +  path);
        StringBuilder builder = new StringBuilder();

        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while ( (line = bufferedReader.readLine()) != null ) {
                builder.append(line + "\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

    public static synchronized String getContentWithoutNewLine(String path) throws IOException {
        File file = new File(HTML_RESOURCE +  path);
        StringBuilder builder = new StringBuilder();

        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while ( (line = bufferedReader.readLine()) != null ) {
                builder.append(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

}