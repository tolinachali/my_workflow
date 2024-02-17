#!/usr/bin/env nextflow

params.inputFasta = './input.fasta'

process calculateGCContent {
    input:
    file(inputFasta) from params.inputFasta

    output:
    file 'gc_content.txt'

    script:
    """
    java GCContentCalculator ${inputFasta} > gc_content.txt
    """
}

workflow {
    calculateGCContent
}

