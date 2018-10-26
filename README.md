# Personal Project
:arrow_forward: Please refer to [edX][1] for description and instructions.

[1]: https://edge.edx.org/courses/course-v1:UBC+CPSC210+2018W1/courseware/a4d49b3ef5fa4fe2bd9496e76d72dc48/e2887456a15a48dbb040ecdac313168f/1?activate_block_id=block-v1%3AUBC%2BCPSC210%2B2018W1%2Btype%40vertical%2Bblock%40ff793bbcd5544e82bb5052f0dffe5d71


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

3: Abstraction and Testing
- Cleaned up code and added requires,effects,modifies statements to methods
- Added data analysis class which analyzes the clicker data for a given player
- Only method in data analysis currently determines fire and tilt sections of routine
- Was going to add timing element; however cannot implement effectively until I have a UI: would need a-synchronous code
- Things which have yet to be implemented:
    - More data analysis features which can be implemented without a GUI:
        - Clicks per second based off of the pre-selected routine length value (wildcard, prelim, semi, 2-minute, final)
    - Clicker
        - reset clicker values by hitting reset button
    - Interfaces for wildcard, prelim, semi, 2-minute, final

4: Types, Interfaces, and Saving
- Added additional data analysis features (CPS, CR, ClicksIfPerfect, etc)
- Added save and load feature for individual players:
    - Everytime you save a new player, a new CSV file will be created
    - Can overwrite that player by saving on top of it
    - can read a player from memory if that player is in memory
- Things which have yet to be implemented:
    - Data analysis features:
        - clicks per second if perfect
        - Weighting function for evals and clickers (60%/40%)
    - Adding exceptions for all eval scores (out of 10)/ tell judge to input a different score
    - Create a list of player's/competition roster class which extends player (add multiple players to a single list)

5: Abstracts and Extends
- Added wildcard, prelim, semi, two minute, and final classes which extends player and playerDataAnalysis
- Cleaned up code and made everything streamline
- Added more tests
- Things which have yet to be implemented
    - Adding exceptions for all eval scores (out of 10)/ tell judge to input a different score
    - Adding exceptions for everything
    - Creating a list of player's/competition
    - Aggregate and database functions

6: Robustness
- Added exceptions
- Created competition class which allows the user(judge) to score multiple players sequentially
- Refractored getters and setters and overall codebase to make it more streamline - more helper functiosn!
- What still need to be done:
    - Debug competiton class, add read functionality
    - Inter player data analysis/ competition analysis class
    - Double click
    - Tests for exceptions
    - Fill in test gaps - get a code coverage report somehow