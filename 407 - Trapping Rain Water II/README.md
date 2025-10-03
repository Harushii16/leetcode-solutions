# LeetCode 407 - Trapping Rain Water II

## 📝 Problem Statement
Given an `m x n` integer matrix `heightMap` representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.

This is an extension of the classic **Trapping Rain Water (1D)** problem, but in **2D**.

---

## 🔍 Example

**Example 1:**
Input: heightMap = [
[1,4,3,1,3,2],
[3,2,1,3,2,4],
[2,3,3,2,3,1]
]
Output: 4

markdown
Copy code

**Example 2:**
Input: heightMap = [
[3,3,3,3,3],
[3,2,2,2,3],
[3,2,1,2,3],
[3,2,2,2,3],
[3,3,3,3,3]
]
Output: 10

yaml
Copy code

---

## ⚙️ Constraints
- `m == heightMap.length`
- `n == heightMap[i].length`
- `1 <= m, n <= 200`
- `0 <= heightMap[i][j] <= 2 * 10^4`
