cwlVersion: v1.0
class: CommandLineTool
id: foobar
inputs:
  filesA:
    type: File[]
    inputBinding:
      prefix: -A
      position: 1

  filesB:
    type:
      type: array
      items: Directory
      inputBinding:
        prefix: -B=
        separate: false
    inputBinding:
      position: 2
#!/usr/bin/env cwl-runner

class: CommandLineTool
id: "BAMStats"
label: "BAMStats tool"
cwlVersion: v1.0

requirements:
  - class: DockerRequirement
    dockerPull: "quay.io/collaboratory/dockstore-tool-bamstats:1.25-6_1.0"

hints:
  - class: ResourceRequirement
    coresMin: 1
    ramMin: 4092
    outdirMin: 512000

inputs:
  mem_gb:
    type: int
    default: 4
    inputBinding:
      position: 1

  bam_input:
    type: File
    format: "http://edamontology.org/format_2572"
    inputBinding:
      position: 2

outputs:
  bamstats_report:
    type: File
    format: "http://edamontology.org/format_3615"
    outputBinding:
      glob: bamstats_report.zip

baseCommand: ["bash", "/usr/local/bin/bamstats"]

  filesC:
    type: boolean[]
    inputBinding:
      prefix: -C=
      itemSeparator: ","
      separate: false
      position: 4

  filesD:
      type: File
      inputBinding:
        prefix: -C=
        itemSeparator: ","
        separate: false
        position: 4

outputs: []
baseCommand: echo