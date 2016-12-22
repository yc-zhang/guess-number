# Guess Number

### Introduction

We are going to use TDD to develop a simple guess number game with the following rules:

- While the game starts, the program will output a four digits number like `9527`.
- Then the game will ask player to input the number, and reply prompts in format `xAxB`.
- If one digit of input number matches the **value and correct position**, count 1 for `A`.
- If a digit matches **value** only, count 1 for B.
- Print `Game Over` for 6 rounds if not matched and end the game.
- Print `Congratulations!` if matched and end the game.
