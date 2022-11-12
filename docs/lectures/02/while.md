While Language Specification
--

## Syntactic Categories

| _Name_   | _Meaning_               |
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



```
s ::= x

```

Abstract syntax


a	::=	x | n | a1 opa a2 | a1 opbt a2
b	::=	true | false | not b | b1 opb 2 | a1 opr a2
S	::=	x := a | skip | S1;S2 | if b then S1 else S2 | while b do S |
write a | write b | read x | call p(x, y)
D	::=	proc p(val x, res y) is S end
P	::=	S | begin D ; S end
V	::=	var x | V;V
S	::=	... | begin V;S end | if b then S1 else S2 fi | while b do S od

# Extended Syntax



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
end
```

