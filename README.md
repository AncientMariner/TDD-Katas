TDD Katas
===================

### Roman Numerals Kata

Given a positive integer number (eg 42) determine 
its Roman numeral representation as a String (eg "XLII").
You cannot write numerals like IM for 999.
Wikipedia states "Modern Roman numerals are written by
expressing each digit separately starting with the
leftmost digit and skipping any digit with a value of zero."
    
| Trivial number |                           |               |   
|-------------|--------------|---------------|---------------|  
| 1 ->    "I" | 10 ->    "X" | 100 ->    "C" | 1000 ->    "M"
| 2 ->   "II" | 20 ->   "XX" | 200 ->   "CC" | 2000 ->   "MM"
| 3 ->  "III" | 30 ->  "XXX" | 300 ->  "CCC" | 3000 ->  "MMM"
| 4 ->   "IV" | 40 ->   "XL" | 400 ->   "CD" | 4000 -> "MMMM"
| 5 ->    "V" | 50 ->    "L" | 500 ->    "D" |
| 6 ->   "VI" | 60 ->   "LX" | 600 ->   "DC" |
| 7 ->  "VII" | 70 ->  "LXX" | 700 ->  "DCC" |
| 8 -> "VIII" | 80 -> "LXXX" | 800 -> "DCCC" |
| 9 ->   "IX" | 90 ->   "XC" | 900 ->   "CM" |

|Non-trivial number                                         |
|-----------------------------------------------------------|
| 1990 -> "MCMXC"  (1000 -> "M"  + 900 -> "CM" + 90 -> "XC")
| 2008 -> "MMVIII" (2000 -> "MM" + 8 -> "VIII")
|  99 -> "XCIX"   (90 -> "XC" + 9 -> "IX")
|  47 -> "XLVII"  (40 -> "XL" + 7 -> "VII")

---

### StringCalculator Kata

Adds **0**, **1**, **2** string parameters in string present together and returns its sum

---

### Anagrams

Write a program to generate all potential anagrams of an input string.
For example, the potential anagrams of **biro** are

    biro bior brio broi boir bori
    ibro ibor irbo irob iobr iorb
    rbio rboi ribo riob roib robi
    obir obri oibr oirb orbi orib

---

### The OddEven Kata
Write a program that prints numbers within specified range lets say 1 to 100.

* If number is odd print 'Odd' instead of the number.
* If number is even print 'Even' instead of number.
* Else print number [hint - if number is Prime].

---

### Count Coins
There are four types of common coins in US currency:

*    quarters (25 cents)
*    dimes (10 cents)
*    nickels (5 cents)
*    pennies (1 cent)

There are 6 ways to make change for 15 cents:

*    A dime and a nickel;
*    A dime and 5 pennies;
*    3 nickels;
*    2 nickels and 5 pennies;
*    A nickel and 10 pennies;
*    15 pennies.

How many ways are there to make change for a dollar using these common coins? (1 dollar = 100 cents).

---

###  Leap Year

*   Write a function that returns true or false depending on
whether its input integer is a leap year or not.
*   A leap year is defined as one that is divisible by 4,
but is not otherwise divisible by 100 unless it is
also divisble by 400.
*   For example, 2001 is a typical common year and 1996
is a typical leap year, whereas 1900 is an atypical
common year and 2000 is an atypical leap year.

---

###  ISBN - International Standard Book Number

* There are two ISBN standards: ISBN-10 and ISBN-13.
Support for ISBN-13 is essential, whereas support
for ISBN-10 is optional.
Here are some valid examples of each:

|__ISBN-10:    0471958697__
|----------------------------    
|                0 471 60695 2
|                0-470-84525-2
|                0-321-14653-0
|__ISBN-13:    9780470059029__
|               978 0 471 48648 0
|                978-0596809485
|                978-0-13-149505-0
|                978-0-262-13472-9

* ISBN-10 is made up of 9 digits plus a check digit (which
may be 'X') and ISBN-13 is made up of 12 digits plus a
check digit. Spaces and hyphens may be included in a code,
but are not significant. This means that 9780471486480 is
equivalent to 978-0-471-48648-0 and 978 0 471 48648 0.

* The check digit for ISBN-10 is calculated by multiplying
each digit by its position (i.e., 1 x 1st digit, 2 x 2nd
digit, etc.), summing these products together and taking
modulo 11 of the result (with 'X' being used if the result
is 10).

* The check digit for ISBN-13 is calculated by multiplying
each digit alternately by 1 or 3 (i.e., 1 x 1st digit,
3 x 2nd digit, 1 x 3rd digit, 3 x 4th digit, etc.), summing
these products together, taking modulo 10 of the result
and subtracting this value from 10, and then taking the
modulo 10 of the result again to produce a single digit.

---

### Calc Stats:

	Process a sequence of integer numbers
	to determine the following statistics:

		* minimum value
		* maximum value
		* number of elements in the sequence
		* average value

	For example: [6, 9, 15, -2, 92, 11]

		* minimum value = -2
		* maximum value = 92
		* number of elements in the sequence = 6
		* average value = 18.166666

---

### Game of Life :

	Write a program to calculate the next
	generation of Conway's game of life, given any starting
	position. You start with a two dimensional grid of cells,
	where each cell is either alive or dead. The grid is finite,
	and no life can exist off the edges. When calculating the
	next generation of the grid, follow these four rules:

	1. Any live cell with fewer than two live neighbours dies,
	   as if caused by underpopulation.
	2. Any live cell with more than three live neighbours dies,
	   as if by overcrowding.
	3. Any live cell with two or three live neighbours lives
	   on to the next generation.
	4. Any dead cell with exactly three live neighbours becomes
	   a live cell.

	Examples: * indicates live cell, . indicates dead cell

	Example input: (4 x 8 grid)
	4 8
	........
	....*...
	...**...
	........

	Example output:
	4 8
	........
	...**...
	...**...
	........

---
