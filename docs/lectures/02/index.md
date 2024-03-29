Lecture 2
---
# Lexical Analysis

## Lecture

Slides: [PDF](slides_02.pdf), [PPTX](slides_02.pptx)

Notes: [PDF](nodes_02.pdf)

#### Outline

* Lexical analysis
* Lexemes and tokens
* Regular expressions
* Lexer generators

## Workshop

#### Outline

* Lexemes of While language
* Manual implementation of a lexer
* Lexer generator

#### While Language

_While_ is simple programming language described in the book
["Principles of Program Analysis"](../../books.md).
It will be used in the course to demonstrate implementations of various analysis techniques.
The language specification is [here](while.md). 

#### Examples

* [Hand-made While lexer](
  https://github.com/andrewt0301/static-analysis-course/tree/main/docs/lectures/02/examples/while_lexer)
* [JFlex-based While lexer](
  https://github.com/andrewt0301/static-analysis-course/tree/main/docs/lectures/02/examples/while_lexer_jflex)
* [ANTLR-based While lexer](
  https://github.com/andrewt0301/static-analysis-course/tree/main/docs/lectures/02/examples/while_lexer_antlr)

#### Tasks

* Compile and run the lexer examples.
* Extend all the lexers to support hexadecimal and binary numbers.
* Extend the hand-made lexer to support `_` in identifiers.
* Extend all the lexers to support comments: single-line (`//`) and multi-line (`/*`, `*/`).

## References

### Theory
* [Lexical analysis](https://en.wikipedia.org/wiki/Lexical_analysis) (Wikipedia)
* [[DRADON]](../../books.md#compiler-books) Chapter 3: Lexical Analysis
* [[PARR]](../../books.md#compiler-books) Chapter 2: Basic Parsing Patterns
* [[INTERP]](../../books.md#compiler-books) Chapter 4: Scanning 
* [[ANTLR]](../../books.md#tool-books) Chapter 5: Designing Grammars,
  Section 5.5 : Recognizing Common Lexical Structures

### Tools
* Online regular expression parser [regex101](https://regex101.com/)
* Parser (and lexer) generator [ANTLR](https://www.antlr.org/)
* Lexer generator [JFlex](https://www.jflex.de/)
* The Fast Lexical Analyzer [Flex](
  https://www.geeksforgeeks.org/flex-fast-lexical-analyzer-generator/)
* IntelliJ Platform Plugin SDK: [Lexer and Parser Definition]( 
  https://plugins.jetbrains.com/docs/intellij/lexer-and-parser-definition.html)
