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

###  Leap Year :

Write a function that returns true or false depending on
whether its input integer is a leap year or not.

A leap year is defined as one that is divisible by 4,
but is not otherwise divisible by 100 unless it is
also divisble by 400.

For example, 2001 is a typical common year and 1996
is a typical leap year, whereas 1900 is an atypical
common year and 2000 is an atypical leap year.

---
