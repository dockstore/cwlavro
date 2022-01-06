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