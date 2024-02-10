params.inputFile = "/mnt/c/Users/HP/_repos/my_research/my_workflow/miRNA_test.fa"

process calculateGCContent {
    input:
    file(inputFile) from params.inputFile

    output:
    file("gc_content.txt") into gcContent

    script:
    """
    java GCContentCalculator ${inputFile}
    """
}

workflow {
    calculateGCContent
}


