# my_workflow
The calculateGCContent method reads the FASTA file line by line, skipping any header lines (which start with ">"). 
For each non-header line, it counts the total number of nucleotides and the number of GC nucleotides and 
the countGC method counts the number of GC nucleotides in a given sequence.
Finally, the GC content is calculated as the ratio of GC nucleotides to total nucleotides multiplied by 100, and the result is returned as a percentage
