# LeetCode 3100 - Water Bottles II

## 📝 Problem Statement

You are given two integers:

- `numBottles` → the number of **full water bottles** you initially have.  
- `numExchange` → the number of **empty bottles required** to exchange for **1 full bottle**.

You can perform the following actions:

1. **Drink** a full bottle → it becomes an empty bottle.  
2. **Exchange** `numExchange` empty bottles for 1 full bottle.  
   - After each exchange, the value of `numExchange` increases by 1.  
   - You cannot perform multiple exchanges at the same `numExchange` value.

Return the **maximum number of bottles you can drink** in total.

---

## 🔹 Example 1
**Input:**  
numBottles = 13, numExchange = 6

makefile
Copy code

**Output:**  
15

yaml
Copy code

---

## 🔹 Example 2
**Input:**  
numBottles = 10, numExchange = 3

makefile
Copy code

**Output:**  
13

yaml
Copy code

---

## ✅ Constraints
- 1 ≤ `numBottles` ≤ 100  
- 1 ≤ `numExchange` ≤ 100  
