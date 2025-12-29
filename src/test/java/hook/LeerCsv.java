package hook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LeerCsv {

    public static Map<String, String> readFirstRow(String path) {
        Map<String, String> data = new HashMap<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                		LeerCsv.class.getClassLoader().getResourceAsStream(path)))) {

            String headerLine = br.readLine();
            String dataLine = br.readLine();

            String[] headers = headerLine.split(";");
            String[] values = dataLine.split(";");

            for (int i = 0; i < headers.length; i++) {
                data.put(headers[i], values[i]);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error leyendo CSV: " + path, e);
        }

        return data;
    }
}