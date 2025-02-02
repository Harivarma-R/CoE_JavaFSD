import java.io.*;
import java.util.*;

public class LogFileAnalyzer {
    public void analyzeLogFile(String inputFile, String outputFile, List<String> keywords) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        Map<String, Integer> keywordCounts = new HashMap<>();

        for (String keyword : keywords) {
            keywordCounts.put(keyword, 0);
        }
        String line;
        while ((line = reader.readLine()) != null) {
            for (String keyword : keywords) {
                if (line.contains(keyword)) {
                    keywordCounts.put(keyword, keywordCounts.get(keyword) + 1);
                }
            }
        }
        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write("Log File Analysis Results:\n");
        for (String keyword : keywords) {
            writer.write(keyword + ": " + keywordCounts.get(keyword) + " occurrences\n");
        }

        writer.close();

        System.out.println("Log file analysis complete. Results written to " + outputFile);
    }

    public static void main(String[] args) {
        LogFileAnalyzer analyzer = new LogFileAnalyzer();
        
        List<String> keywords = Arrays.asList("ERROR", "WARNING", "INFO");

        try {
            analyzer.analyzeLogFile("input_log.txt", "output_analysis.txt", keywords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
