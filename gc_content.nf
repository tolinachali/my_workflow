process calculateGCContent {
    input:
    file dnaSequence

    output:
    file 'gc_content.txt'

    script:
    """
    java -cp . GCContentCalculator ${dnaSequence} > gc_content.txt
    """
}

workflow {
    calculateGCContent('C:/Users/HP/_repos/my_research/input.txt')
}

