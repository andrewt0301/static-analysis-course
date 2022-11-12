While Language Specification
--

## Syntactic Categories

| _P_      | Programs                |
| _V_      | Variable declarations   |
| _S_      | Statements              |
| _x_, _y_ | Variables               |
| _n_      | Numerals                |
| _a_      | Arithmetic expressions  |
| _b_      | Boolean expressions     |
| _opa_    | Arithmetic operators: `+`, `-`, `/`, `*`, `%` |
| _opb_    | Boolean operators: `and`, `or`, `xor` |
| _opr_    | Relational operators: `==`, `!=`, `<`, `>`, `<=`, `>=` |

# Abstract Syntax

Programs _P_:
* _S_

Variable declarations _V_:
* _V1_ `;` _V2_
* `var` _x_

Statements  _S_:
* `begin` _V_ `;` _S_ `end`
* _S1_ `;` _S2_
* `skip`
* `if` _b_ `then` _S1_ `else` _S2_
* `while` _b_ `do` _S_
* `write` _a_
* `write` _b_
* `read` _x_

Boolean expressions _b_:
* `true`
* `false`
* `(` _b_ `)`
* `not` _b_
* _b1_ _opb_ _b2_
* _a1_ _opr_ _a2_

Arithmetic expressions _a_:
* `(` _a_ `)`
* `-` _a_
* _x_
* _n_
* _a1_ _opa_ _a2_

# Example

Calculating Fibonacci number:

```
begin
  var x;
  var y;
  var z;
  read x;
  y := x;
  z := 1;
  while y > 1 do
    z = z * y;
    y = y - 1;
  end
  write y
```
