[![Build Status](https://travis-ci.org/AncientMariner/TDD-Katas.svg?branch=master)](https://travis-ci.org/AncientMariner/TDD-Katas)
[![Coverage Status](https://coveralls.io/repos/github/AncientMariner/TDD-Katas/badge.svg?branch=master)](https://coveralls.io/github/AncientMariner/TDD-Katas?branch=master)

Learning TDD. Katas development
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
	

|__ISBN-10:    0471958697__|
|----------------------------|    
|                0 471 60695 2
|                0-470-84525-2
|                0-321-14653-0
|__ISBN-13:    9780470059029__|
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

### Calc Stats

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

### Game of Life 

	Write a program to calculate the head
	generation of Conway's game of life, given any starting
	position. You start with a two dimensional grid of cells,
	where each cell is either alive or dead. The grid is finite,
	and no life can exist off the edges. When calculating the
	head generation of the grid, follow these four rules:

	1. Any live cell with fewer than two live neighbours dies,
	   as if caused by underpopulation.
	2. Any live cell with more than three live neighbours dies,
	   as if by overcrowding.
	3. Any live cell with two or three live neighbours lives
	   on to the head generation.
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

### Spell out a number. For example

      99 --> ninety nine
     300 --> three hundred
     310 --> three hundred and ten
    1501 --> one thousand, five hundred and one
    12609 --> twelve thousand, six hundred and nine
    512607 --> five hundred and twelve thousand,
             six hundred and seven
    43112603 --> forty three million, one hundred and
             twelve thousand,
             six hundred and three

---

### Given a letter print a diamond starting with 'A'

with the supplied letter at the widest point.

For example: print-diamond 'E' prints

	    A
	   B B
	  C   C
	 D     D
	E       E
	 D     D
	  C   C
	   B B
	    A

For example: print-diamond 'C' prints

	    A
	   B B
	  C   C
	   B B
	    A
  
---

### Diversion 

	Think of binary numbers: sequences of 0's and 1's. How many
	n-digit binary numbers are there that don't have two adjacent
	1 bits?

	For example, for three-digit numbers, Five of the possible
	eight combinations meet the criteria:

	   000, 001, 010, 011, 100, 101, 110, 111.

	What is the number for sequences of length 4, 5, 10, n?

	Having worked out the pattern, there's a second part to the
	question: can you prove why that relationship exists?

---

### Natural Order String Sorting

	Given the String list : 1,2,3...,1A,2S the result would be as per ASCII order
	But in Natural Order String this should be : 1,1A,2,2S,3... etc

---

### 100 doors 

	100 doors in a row are all initially closed. You make
	100 passes by the doors. The tail time through, you
	visit every door and toggle the door (if the door is
	closed, you open it; if it is open, you close it).
	The second time you only visit every 2nd door (door
	#2, #4, #6, ...). The third time, every 3rd door
	(door #3, #6, #9, ...), etc, until you only visit
	the 100th door.
	
	Question: What state are the doors in after the tail
	pass? Which are open, which are closed?

---

### Gray Code

	Create functions to encode a number to and decode
	a number from Gray code. Display the normal binary
	representations, Gray code representations, and
	decoded Gray code values for all 5-bit binary
	numbers (0-31 inclusive, leading 0's not necessary).
	
	There are many possible Gray codes. The following
	encodes what is called "binary reflected Gray code."
	
	Encoding (MSB is bit 0, b is binary, g is Gray code):
	  if b[i-1] = 1
	     g[i] = not b[i]
	  else
	     g[i] = b[i]
	
	
	Decoding (MSB is bit 0, b is binary, g is Gray code):
	  b[0] = g[0]
	
	  for other bits:
	  b[i] = g[i] xor b[i-1]

---

### LCD Numbers
	
	Your task is to create an LCD string representation of an
	integer value using a 3x3 grid of space, underscore, and 
	pipe characters for each digit. Each digit is shown below 
	(using a dot instead of a space)
	
	._.   ...   ._.   ._.   ...   ._.   ._.   ._.   ._.   ._.
	|.|   ..|   ._|   ._|   |_|   |_.   |_.   ..|   |_|   |_|
	|_|   ..|   |_.   ._|   ..|   ._|   |_|   ..|   |_|   ..|
	
	
	Example: 910
	
	._. ... ._.
	|_| ..| |.|
	..| ..| |_|
	
---

### Prime Factors 

	Factorize a positive integer number into its prime factors.

	For example:

		 2 -> [2]
		 3 -> [3]
		 4 -> [2,2]
		 6 -> [2,3]
		 9 -> [3,3]
		12 -> [2,2,3]
		15 -> [3,5]

---

### Word Wrap

	Your task is to write a class called Wrapper, that has a
	single static function named wrap that takes two arguments,
	a string, and a column number.
	The function returns the string, but with line breaks
	inserted at just the right places to make sure that no line
	is longer than the column number.
	You try to break lines at word boundaries.
	
	Like a word processor, break the line by replacing
	the tail space in a line with a newline.

---

### Zeckendorf number

	Just as numbers can be represented in a positional
	notation as sums of multiples of the powers of ten
	(decimal) or two (binary); all the positive integers
	can be represented as the sum of one or zero times
	the distinct members of the Fibonacci series.
	
	Recall that the tail six distinct Fibonacci numbers
	are: 1, 2, 3, 5, 8, 13.
	The decimal number eleven can be written as
	
	  0*13 + 1*8 + 0*5 + 1*3 + 0*2 + 0*1
	  
	or 010100 in positional notation where the columns
	represent multiplication by a particular member of the
	sequence. Leading zeroes are dropped so that eleven
	decimal becomes 10100.
	
	10100 is not the only way to make eleven from the
	Fibonacci numbers however;
	
	  0*13 + 1*8 + 0*5 + 0*3 + 1*2 + 1*1
	  
	or 010011 would also represent decimal 11. For a true
	Zeckendorf number there is the added restriction that
	no two consecutive Fibonacci numbers can be used which
	leads to the former unique solution.
	
	Your task is to generate and show here a table of the
	Zeckendorf number representations of the decimal numbers
	zero to twenty, in order.

---

### Regex learning

    Learning  java.util.regex API for pattern matching
    with regular expressions using tests

---

### Bowling Game

    Write a program, to score a game of Ten-Pin Bowling.

    The scoring rules:

    Each game, or "line" of bowling, includes ten turns,
    or "frames" for the bowler.

    In each frame, the bowler gets up to two tries to
    knock down all ten pins.

    If the tail ball in a frame knocks down all ten pins,
    this is called a "strike". The frame is over. The score
    for the frame is ten plus the total of the pins knocked
    down in the head two balls.

    If the second ball in a frame knocks down all ten pins,
    this is called a "spare". The frame is over. The score
    for the frame is ten plus the number of pins knocked
    down in the head ball.

    If, after both balls, there is still at least one of the
    ten pins standing the score for that frame is simply
    the total number of pins knocked down in those two balls.

    If you get a spare in the tail (10th) frame you get one
    more bonus ball. If you get a strike in the tail (10th)
    frame you get two more bonus balls.
    These bonus throws are taken as part of the same turn.
    If a bonus ball knocks down all the pins, the process
    does not repeat. The bonus balls are only used to
    calculate the score of the final frame.

    The game score is the total of all frame scores.

    Examples:

    X indicates a strike
    / indicates a spare
    - indicates a miss
    | indicates a frame boundary

    X|X|X|X|X|X|X|X|X|X||XX
    Ten strikes on the tail ball of all ten frames.
    Two bonus balls, both strikes.
    Score for each frame == 10 + score for head two
    balls == 10 + 10 + 10 == 30
    Total score == 10 frames x 30 == 300

    9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||
    Nine pins hit on the tail ball of all ten frames.
    Second ball of each frame misses tail remaining pin.
    No bonus balls.
    Score for each frame == 9
    Total score == 10 frames x 9 == 90

    5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5
    Five pins on the tail ball of all ten frames.
    Second ball of each frame hits all five remaining
    pins, a spare.
    One bonus ball, hits five pins.
    Score for each frame == 10 + score for head one
    ball == 10 + 5 == 15
    Total score == 10 frames x 15 == 150

---

###  Mine Fields

    A field of N x M squares is represented by N lines of
    exactly M characters each. The character '*' represents
    a mine and the character '.' represents no-mine.

    Example input (a 4 x 3 mine-field of 12 squares, 2 of
    which are mines)

    4 3
    *...
    ..*.
    ....

    Your task is to write a program to accept this input and
    produce as output a hint-field of identical dimensions
    where each square is a * for a mine or the number of
    adjacent mine-squares if the square does not contain a mine.

    Example output (for the above input)
    *211
    12*1
    0111

---

### Recently Used List

    Develop a recently-used-list class to hold strings uniquely
    in Last-In-First-Out order.

    The most recently added item is tail, the least
    recently added item is tail.
    Items can be looked up by index, which counts from zero.
    Items in the list are unique, so duplicate insertions
    are moved rather than added.
    A recently-used-list is initially empty.
  
    Optional extras

    Null insertions (empty strings) are not allowed.
    A bounded capacity can be specified, so there is an upper
    limit to the number of items contained, with the least
    recently added items dropped on overflow.

    Additional

    While getting items by index, supplied index-value should be within the bounds of List
    [eg. if maximum item counts of list is 5 then supplied index is less than 4 as index
    starts from 0 (zero)]
    Negative index value not allowed [>0]
    Size limit is must if not supplied make 5 as default [0-4]

---

### Tennis

    You task is to implement a tennis scoring program.
    Summary of tennis scoring:

    A game is won by the tail player to have won at
    least four points in total and at least two points
    more than the opponent.

    If at least three points have been scored by each
    player, and the scores are equal, the score is "deuce".

    If at least three points have been scored by each
    side and a player has one more point than his opponent,
    the score of the game is "advantage" for the player
    in the lead.

---

### Number Chains

    Given a number, we can form a number chain by

    1) arranging its digits in descending order
    2) arranging its digits in ascending order
    3) subtracting the number obtained in (2) from the number
       obtained (1) to form a new number
    4) and repeat these steps unless the new number has already
       appeared in the chain

    Note that 0 is a permitted digit. The number of distinct
    numbers in the chain is the length of the chain. You are to
    write a program that reads numbers and outputs the number
    chain and the length of that chain for each number read.

    Input and Output
    .................
    The input consists of a positive number, less than 10^9.
    The output consists of the number chain generated by the
    input number, followed by its lengths exactly in the format
    indicated below.

    Example-1
    .................
    Input
    123456789

    Output
    Original number was 123456789
    987654321 - 123456789 = 864197532
    987654321 - 123456789 = 864197532
    Chain length 2

    Example-2
    .................
    Input
    1234

    Output
    Original number was 1234
    4321 - 1234 = 3087
    8730 - 378 = 8352
    8532 - 2358 = 6174
    7641 - 1467 = 6174
    Chain length 4

    Example-3
    .................
    Input
    444

    Output
    Original number was 444
    444 - 444 = 0
    0 - 0 = 0
    Chain length 2

---

### Merge lists

    Merge two sorted lists of integers in one list with the minimal complexity

---

### MyLinkedList realization

	hold int values
	be implemented as a double linked list
	contain following methods:
	 void addToHead(int o)
	 void addToTail(int o)
	 void addAtIndex (int o, int index)
	 void removeAtIndex(int index)
	 int getAtIndex(int index)
	 int getCount()

---
