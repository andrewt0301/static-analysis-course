Paper Reviews
---

This page contains review notes on research papers dedicated to static code analysis.
The main focus is static code analysis tools for C/C++ based on Clang and methods of static code analysis
such as symbolic execution and abstract interpretation.

##### 1. Pavel Mezhuev et al. [A dynamic algorithm for source code static analysis](https://ieeexplore.ieee.org/document/9693752). 2021.

The paper proposes an approach to static code analysis that
enables cross-translation-unit (CTU) analysis and helps achieve high performance.
Main ideas of the approach are:
(1) minimize the memory footprint of TU data structures (AST/CFG/etc.) and free them (or their parts) as soon as possible;
(2) use function summaries;
(3) run analysis tasks in parallel.
The proposed analysis algorithm includes the following steps:
1. TUs are pre-parsed to build a map of functions (key is a function, value is the translation unit where it is defined).
2. TUs are placed into a priority queue, from which they are picked and processed by a thread pool.
3. Each TU is parsed by Clang to build AST and CFG, which are then converted into custom CFG and AST. These custom data
structures store only information required for analysis and allow releasing objects that are no longer needed.
4. AST checks are run for the TU.
5. The data-flow engine analyzes each function in the TU starting from the call graph leaves. If a function contains
calls to functions that have not been yet analyzed, it cannot be analyzed and is put in the pending list.
If the ananalyzed function is defined in another TU, the priority of this TU in the queue is increased. 
6. The data-flow analysis engine traverses the CFG of the function in the backward order and applies data-flow checkers
to each CFG element.
7. Checkers annotate CFG elements with information about events (e.g. variable read/write, pointer dereference,
memory allocation/free, division, etc.), which are reachable from a corresponding program point. Different checkers
collect information about different events and use different propagation rules (e.g. an event must occur in all paths or any path).
8. Data-flow analysis produces a summary of the function that contains the following information:
