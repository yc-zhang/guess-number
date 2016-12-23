# Guess Number

### Introduction

We are going to use TDD to develop a simple guess number game with the following rules:

- While the game starts, the program will output a four digits number and each digit is unique like `9527`.
- Then the game will ask player to input the number, each digit is unique too, and reply prompts in format `xAxB`.
- If one digit of input number matches the **value and correct position**, count 1 for `A`.
- If a digit matches **value** only, count 1 for B.
- Print `Game Over` for 6 rounds if not matched and end the game.
- Print `Congratulations!` if matched and end the game.

### Example

#### Case 1
- Game generates number `1234`, the player input `1234`
- Output `4A0B`

#### Case 2
- Game generates number `1234`, the player input `4321`
- Output `0A4B`

#### Case 4
- Game generates number `1234`, the player input `9324`
- Output `1A2B`
