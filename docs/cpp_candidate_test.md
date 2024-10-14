Test For Candidates (C++)
---

Our team works on a static-analysis engine based on [Clang Static Analyzer](https://clang-analyzer.llvm.org/).
One of the key requirements for a developer is to be familiar with the [Clang](https://clang.llvm.org/) infrastructure. 
The goal of this task is to evaluate skills in implementing checkers based on queries to the [Clang AST](https://clang.llvm.org/docs/IntroductionToTheClangAST.html).
The AST is typically examined with the help of [Clang AST Matchers](https://clang.llvm.org/docs/LibASTMatchersReference.html), which are widely used to implement various checkers.

# Task

You are requested to implement a simple checker for [Clang-Tidy](https://clang.llvm.org/extra/clang-tidy/).
It is a Clang-based tool that runs AST-based checks for C/C++ programs.
The checker must detect vulnerability [CWE-587](https://cwe.mitre.org/data/definitions/587.html) in C/C++ code.
Provide a brief description of the classes/modules you have added.
Provide an example that demonstrates how the checker works and an example of Clang-Tidy output.

## Vulnerability

[CWE-587](https://cwe.mitre.org/data/definitions/587.html) means that assigning
a constant address other than `NULL` or `0` to a pointer is considered a bad practice.
Using a fixed address is not portable, because that address may not be valid in all environments or platforms.

Cases of pointer initialization include:

1. Variable/field declaration with initialization.
2. Variable/field assignment.
3. Field initialization (in constructor initializer).
4. Passing a value to function/method/constructor/operator.
5. Initializing an array of pointers (bad value in initialization list).
6. Any other ideas?

## Implementation

1. Create a fork of the [LLVM](https://github.com/llvm/llvm-project) project at GitHub.
2. Clone and build the project (flag `-DLLVM_ENABLE_PROJECTS='clang;clang-tools-extra'` is needed to build Clang-Tidy).
3. Add a new checker to module `<llvm-project>/tree/main/clang-tools-extra/clang-tidy/misc`.
4. Add tests for the checker into folder `<llvm-project>/clang-tools-extra/test/clang-tidy/checkers/misc`.

## Code Quality Requirements

* The code must follow [LLVM Coding Standards](https://llvm.org/docs/CodingStandards.html).
* The code must obey clean-code best practices.
* Documentation is welcome.

## Results

* Please send us the link to your GitHub repository (LLVM fork) with the implementation of the checker.
* The repository should include an `.md` file with a brief description of the implemented checker.  

## Hints

* A checker template and all related files can be generated with a Python script (see the references). 
* A custom AST matcher may help simplify your code (see the reference and examples of existing matchers).
* The `EvaluateAsInt` method of the [Expr](https://clang.llvm.org/doxygen/classclang_1_1Expr.html)
  class can help to know the expression value (if it is constant).
* It can be useful to execute Clang matchers in `clang-query` before starting coding.  
* Build Clang (it takes time!) with this command (Linux), specify your installation folder:
  ```
  mkdir build
  cd build
  cmake \
    -DCMAKE_BUILD_TYPE=Release \
    -G"Unix Makefiles" \
    -DLLVM_ENABLE_PROJECTS='clang;clang-tools-extra' \
    -DLLVM_TARGETS_TO_BUILD="X86" \
    -DCMAKE_INSTALL_PREFIX=<your installation folder> \
    ../llvm
  make install -j4
  ```

## Useful Commands

View Clang AST:
```clang-check -ast-dump ./checkers/misc/no-recursion.cpp --```

View available Clang-Tidy checkers:
```clang-tidy -list-checks -checks=* | grep misc```

Run Clang-Tidy check:
```clang-tidy -checks=-*,misc-no-recursion ./no-recursion.cpp --```

Run Clang-Tidy tests:
```python3 check_clang_tidy.py ./checkers/misc/no-recursion.cpp misc-no-recursion ./tmp.cpp```

# References

* [Clang AST Matcher Reference](https://clang.llvm.org/docs/LibASTMatchersReference.html).
* [Clang AST Matcher Tutorial](https://clang.llvm.org/docs/LibASTMatchersTutorial.html).
* [Creating and Testing Clang-Tidy Checks](https://clang.llvm.org/extra/clang-tidy/Contributing.html#testing-checks).
* Michael Adams. [Lecture Slides for the Clang Libraries (LLVM/Clang 15)](
  https://ece.engr.uvic.ca/~frodo/cppbook/downloads/lecture_slides_for_the_clang_libraries-0.0.pdf).
* Stephen Kelly. Exploring Clang Tooling, Part 1: [Extending Clang-Tidy](
  https://devblogs.microsoft.com/cppblog/exploring-clang-tooling-part-1-extending-clang-tidy/).
* Stephen Kelly. Exploring Clang Tooling, Part 2: [Examining the Clang AST with clang-query](
  https://devblogs.microsoft.com/cppblog/exploring-clang-tooling-part-2-examining-the-clang-ast-with-clang-query/).
* Stephen Kelly. Exploring Clang Tooling, Part 3: [Rewriting Code with clang-tidy](
  https://devblogs.microsoft.com/cppblog/exploring-clang-tooling-part-3-rewriting-code-with-clang-tidy/).
* Artem Dergachev. [Clang Static Analyzer - A Checker Developer's Guide](
  https://github.com/haoNoQ/clang-analyzer-guide/releases/download/v0.1/clang-analyzer-guide-v0.1.pdf).
* Ivan Murashko. Clang Compiler Frontend: Get to grips with the internals of a C/C++ compiler frontend
  and create your own tools. 2024.
