1: Get Started

- Began creation of yo-yo judge helper
- Created UI, Clicker, and Player packages
- In the main class in the UI Package created the yo-yo judge method 
- In the score class in the Clicker Package created the score method
- Score method has two functionalities: awardClick(increment) and removeClick (decrement) 
- In start method in the main class, made it print a basic introductory statement and reference awardClick and removeClick methods


2: Basic Interaction
- Added additional functionalities:
    - Inputting a player's information: first name, last name, division, routine length, etc
    - Incrementing and decrementing for an undefined period of time - stop when user tells system to stop; Program returns final clicker score to user
    - Inputting and returning performance evals to user
- Functionalities that have yet to be added
    - Taking user inputted routine length and have that be the length of the "allowed clicking time" instead of simply having a infinite while loop
    - Returning error values when user input is wrong. i.e. inputting a number greater than 10 for performance evals, etc
    - After inputting j or f when clicking automatically returning to a new line after each key stroke instead of having to press the enter key
- Things that need to be fixed
    - Improve/write better code according to the 4 step design process
    - Using requires, effects, and modifies clauses