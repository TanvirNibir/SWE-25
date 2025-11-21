import java.io.*;
import java.net.*;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        String urlString = "https://users.metropolia.fi/~jarkkov/temploki.csv";
        String targetDate = "01.01.2023";
        String targetColumn = "UlkoTalo";

        try {
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            String[] headers = null;
            int columnIndex = -1;
            double sum = 0;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                if (headers == null) {
                    headers = line.split(";");
                    for (int i = 0; i < headers.length; i++) {
                        if (headers[i].equalsIgnoreCase(targetColumn)) {
                            columnIndex = i;
                            break;
                        }
                    }
                } else {
                    String[] values = line.split(";");
                    if (values[0].startsWith(targetDate)) {
                        String tempStr = values[columnIndex].replace(",", ".");
                        sum += Double.parseDouble(tempStr);
                        count++;
                    }
                }
            }

            reader.close();
            if (count > 0) {
                System.out.printf("Average '%s' temperature on %s: %.2f°C%n", targetColumn, targetDate, sum / count);
            } else {
                System.out.println("No data found for the specified date.");
            }

        } catch (IOException e) {
            System.err.println("Error reading CSV: " + e.getMessage());
        }
    }
}