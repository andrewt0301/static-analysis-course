Lecture 14
---
# LLVM and Clang

## Lecture

Slides: [PDF](slides_14.pdf), [PPTX](slides_14.pptx)

Notes: [PDF](nodes_14.pdf)

#### Outline

* LLVM Project: history and architecture
* LLVM IR
* Clang: parser and static analysis tool
* Clang Static Analyzer and its symbolic execution engine
* Clang Extra Tools: Clang-Tidy

## Workshop

#### Outline

* Compiling/Installing LLVM
* Compiling C/C++ programs to executables and LLVM IR
* Exploring C/C++ programs with Clang (tokens, AST, call graph, CFG, exploded graph)
* Running Clang Static Analyzer
* Exploring Clang Static Analyzer and Clang-Tidy checks

#### Examples

* [test.c](
  https://github.com/andrewt0301/static-analysis-course/tree/main/docs/lectures/14/examples/test.c)

#### Tasks

##### Exploring `test.c`:

1. Dump tokens:
   ```bash
   clang -cc1 -dump-tokens test.c
   ```

2. Dump and view AST:
   ```bash
   clang -cc1 -ast-dump test.c
   clang -cc1 -ast-view test.c
   ```

3. Dump and view call graph:
   ```bash
   clang -cc1 -analyze -analyzer-checker="debug.DumpCallGraph" test.c
   clang -cc1 -analyze -analyzer-checker="debug.ViewCallGraph" test.c
   ```

4. View CFG and Exploded Graph:
   ```bash
   clang -cc1 -analyze -analyzer-checker="debug.ViewCFG" test.c
   clang -cc1 -analyze -analyzer-checker="debug.ViewExplodedGraph" test.c
   ```

## References

* [LLVM](https://en.wikipedia.org/wiki/LLVM) (Wikipedia)
* [Clang](https://en.wikipedia.org/wiki/Clang) (Wikipedia)
* [LLVM Web Site](https://llvm.org/)
* [LLVM Project](https://github.com/llvm/llvm-project) (GitHub)
* [Clang Static Analyzer - A Checker Developer's Guide](
  https://github.com/haoNoQ/clang-analyzer-guide/releases/download/v0.1/clang-analyzer-guide-v0.1.pdf)
* [[LLVM]](../../books.md#tool-books) Chapters 2, 3, 4, 5, 9, 10
* [LLVM Language Reference Manual](https://llvm.org/docs/LangRef.html)
