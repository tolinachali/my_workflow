# calculateGCContent
The calculateGCContent method reads the FASTA file line by line, skipping any header lines (which start with ">"). 
For each non-header line, it counts the total number of nucleotides and the number of GC nucleotides and 
the countGC method counts the number of GC nucleotides in a given sequence.
Finally, the GC content is calculated as the ratio of GC nucleotides to total nucleotides multiplied by 100, and the result is returned as a percentage

# Nextflow script for workflow 
Parameters have been defined for the input file paths. params.inputFasta is set to ./input.fasta.
The process named calculateGCContent takes an input FASTA file and generates an output file named gc_content.txt.
Within the process definition, a script block executes the Java program GCContentCalculator, passing the input FASTA file path (${inputFasta}) and directing the output to gc_content.txt.
