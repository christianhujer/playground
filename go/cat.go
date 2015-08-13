package main

import (
    "fmt"
    "io"
    "os"
)

var errors int

func main() {
    catFilesOrStdin(os.Args[1:])
    os.Exit(getExitValue())
}

func getExitValue() int {
    if (hadErrors()) {
        return 1
    } else {
        return 0
    }
}

func hadErrors() bool {
    return errors > 0
}

func catFilesOrStdin(files []string) {
    if len(files) > 0 {
        catFiles(files)
    } else {
        catStream(os.Stdin)
    }
}

func catFiles(files []string) {
    for _,file := range files {
        catFile(file)
    }
}

func catFile(file string) {
    stream, err := os.Open(file)
    if err != nil {
        fmt.Fprintln(os.Stderr, err)
        errors++
        return
    }
    defer stream.Close()
    catStream(stream)
}

func catStream(stream *os.File) {
    _, err := io.Copy(os.Stdout, stream)
    if err != nil {
        fmt.Fprintln(os.Stderr, err)
        errors++
    }
}
