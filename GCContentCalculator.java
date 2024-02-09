import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GCContentCalculator {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java GCContentCalculator <path_to_fasta_file>");
            System.exit(1);
        }

        String fastaFilePath = args[0];
        try {
            double gcContent = calculateGCContent(fastaFilePath);
            System.out.println("GC content of the FASTA file is: " + gcContent + "%");
        } catch (IOException e) {
            System.err.println("Error reading the FASTA file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error calculating GC content: " + e.getMessage());
        }
    }

    public static double calculateGCContent(String fastaFilePath) throws IOException {
        int totalBases = 0;
        int gcCount = 0;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fastaFilePath))) {
            String line;
            boolean headerLine = true;

            while ((line = reader.readLine()) != null) {
                if (headerLine) {
                    headerLine = false;
                    continue;
                }

                for (char base : line.toCharArray()) {
                    if (isValidBase(base)) {
                        if (base == 'G' || base == 'C' || base == 'g' || base == 'c') {
                            gcCount++;
                        }
                        totalBases++;
                    } else {
                        throw new IllegalArgumentException("Invalid character in the FASTA file: " + base);
                    }
                }
            }
        }

        if (totalBases == 0) {
            throw new IllegalArgumentException("FASTA file is empty or in an incorrect format.");
        }

        return (double) gcCount / totalBases * 100.0;
    }

    private static boolean isValidBase(char base) {
        return base == 'A' || base == 'C' || base == 'G' || base == 'T' || base == 'a' || base == 'c' || base == 'g' || base == 't';
    }
}

