Paper Reviews
---

This page contains review notes on research papers dedicated to static code analysis.
The main focus is static code analysis tools for C/C++ based on Clang and methods of static code analysis
such as symbolic execution and abstract interpretation.

#### 1. Pavel Mezhuev et al. [A dynamic algorithm for source code static analysis](https://ieeexplore.ieee.org/document/9693752). 2021.

The paper proposes an approach to static code analysis that helps achieve high performance.
Main ideas of the approach are:
(1) minimize the footprint of ASTs and CFGs in memory and free them (or their parts) as soon as possible;
(2) use function summaries;
(3) run analysis tasks in parallel.
The proposed analysis algorithm includes the following steps:
1. TUs are pre-parsed to build a map of functions (key is a function, value is the translation unit where it is defined).
2. TUs are placed into a priority queue.
