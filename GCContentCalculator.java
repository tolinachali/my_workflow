import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GCContentCalculator {

    public static void main(String[] args) {
        String filename = "/mnt/c/Users/HP/_repos/my_research/my_workflow/miRNA_test.fa"; // Path to your FASTA file
        
        try {
            double totalGCContent = calculateGCContent(filename);
            System.out.println("Total GC content: " + totalGCContent + "%");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double calculateGCContent(String filename) throws IOException {
        int totalNucleotides = 0;
        int gcCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(">")) { // Skip header lines
                    continue;
                }
                // Count nucleotides
                totalNucleotides += line.length();
                gcCount += countGC(line);
            }
        }

        // Calculate GC content
        return (double) gcCount / totalNucleotides * 100;
    }

    public static int countGC(String sequence) {
        int count = 0;
        for (char nucleotide : sequence.toCharArray()) {
            if (nucleotide == 'G' || nucleotide == 'C') {
                count++;
            }
        }
        return count;
    }
}

