<!---
The JavaScript code below is needed to support rendering of TeX formulas in GitHub Pages.

See this for kramdown:
https://mikelove.wordpress.com/2015/07/01/how-to-use-latex-math-in-rmd-to-display-properly-on-github-pages/
https://varunagrawal.github.io/2018/03/27/latex
https://stackoverflow.com/questions/26275645/how-to-support-latex-in-github-pages

This is a guideline to render formulas:
https://coderoad.ru/49970549/Проблема-рендеринга-некоторого-синтаксиса-latex-в-MathJax-с-Jekyll-на-github
-->
<script type="text/javascript" async
  src="https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.5/MathJax.js?config=TeX-AMS-MML_HTMLorMML">
  MathJax.Hub.Config({
    tex2jax: {
      inlineMath: [['$$','$$'], ['\\(','\\)']],
      processEscapes: true
    }
  });
</script>
 
<!--- The present text is based on https://uneex.ru/HSE/RatingFormula -->

# Grading System

## Final Grade

The final grade $$G$$ is composed of the grades
for __2 modules__ $$M_i$$ and __exam__ $$E$$:

$$G = 0.3 \cdot (M_1 + M_2) + 0.4 \cdot E$$

_If the final grade $$G$$ is unsatisfactory, then the exam must be retaken.
In situations, when it does not help because of low module grades $$M_i$$,
the decision about the final grade is done by the commission of faculty members,
who will hold the final exam._

## Module Grade

The module grade $$M$$ is calculated from __attendance__ $$A$$, __homeworks__ $$H$$, and __test__ $$T$$.
In addition, it is possible to earn __bonus points__ $$B$$ during workshops.

$$M = min(10, 0.10 \cdot A + 0.50 \cdot H + 0.40 \cdot T + B)$$

| Variable | Score | Description |
| $$A$$    | 10%   | Attendance. You need to attend more than 75% of classes to earn this point. |
| $$H$$    | 50%   | Homeworks. There are deadlines. Delays cause penalties: 25% for a week and 50% for large delays. |
| $$T$$    | 40%   | Test. |
| $$B$$    | +20%  | Bonus points given at workshops. |

#### Bonus Points: 2 points

$$B = 2 \cdot \frac{\sum_k W_n}{n}$$, where $$n$$ is the number of workshops.

| Variable | Score              | Description |
| $$W_n$$  | 1 point each class | Workshop activity: solving tasks, presenting, discussion participation |
