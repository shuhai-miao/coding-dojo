# Overview

This page curates the findings from public domain about 4 rules of simple design and Conway's Game of Life. 

The one constant in software development is that things are going to change and a simple design is one that is easy to change.

# 4 Rules of Simple Design

Originally codified by Kent Beck in the late 90’s, these rules outline some fundamental concepts around software design. It can guide us as we make our small, code level refactoring.

1. Tests Pass

First of all, if you can’t verify that your system works, it doesn’t really matter how great your design is. Tests build a safety nets for refactoring. 

2. Expresses Intent

We spend much more time in reading code than writing code. Readability is one of the most important qualities of a codebase. 

- [Write code for humans, not for computers](https://metalblueberry.github.io/post/blog/2020-06-14_write_code_for_humans_not_for_computers/)
*Any fool can write code that a computer can understand. Good programmers write code that humans can understand. (Martin Fowler, 2008.)*

*Always code as if the guy who ends up maintaining your code will be a violent psychopath who knows where you live. ( John F. Woods, 1991)*

3. No Duplication (DRY - Don’t Repeat Yourself)

*“Every piece of knowledge should have one and only one representation.” - The Pragmatic Programmer by Dave Thomas and Andy Hunt*

We tend to think of duplication at a code level. In addition to look for code duplication, it’s more important to ask ourself whether or not the duplication wee see is an example of core knowledge in the system. 

- A good way to detect knowledge duplication is to ask what happens if we want to change something.
    - What effort is required?
    - How many places will we need to look at and change?
- We can also approach this as a naming problem: a lack of effectively expressing our intent. When encountering poor names, we often can find a missing abstraction by thinking about what the poorly-named variables represent.

4. Small

- Do I have any code that is no longer used?
- Do I have any duplicate abstractions?
- Have I extracted too far?

An important thing to realize about these rules is that they iterate over each other. Frequently, fixing a naming issue will uncover some duplication. Eliminating that duplication will then reveal some expressiveness that can be improved.

https://d33wubrfki0l68.cloudfront.net/0f6d2341d67720f972cba8352b22fc9566dfedfe/6a201/images/age_old_battle/virtuous_cycle.png

# Conway’s Game Of Life

Conway’s Game of Life (GoL) is what is known as a zero-player game based on a cellular automaton, where a world with live and dead cells evolves through a series of generations based on the following rules:

1. Any live cell with fewer than two live neighbors dies as if caused by **underpopulation**.
2. Any live cell with two or three live neighbors **lives on to the next generation.**
3. Any live cell with more than three live neighbors dies, as if by **overpopulation**.
4. Any dead cell with exactly three live neighbors becomes a live cell, as if by **reproduction**.

Each cell can have up to 8 neighbors and each tick of the game (the program) goes over each cell and calculates whether it will alive or dead in the next generation. 

- [PlayGameOfLife](https://playgameoflife.com/)

## Possible takeaway:

- [Test names should influence object’s API](https://articles.coreyhaines.com/posts/test-names-should-influence-design)
    - Think of the test as the first consumer of the component, interacting with the object the same way as the rest of the system.
    - Think about letting the code in the test be a mirror of the test description.
- Duplication of Knowledge
    - A good way to detect knowledge duplication is to ask what happens if we want to change something.
        - What effort is required?
        - How many places will we need to look at and change?
    - We can also approach this as a naming problem: a lack of effectively expressing our intent. When encountering poor names, we often can find a missing abstraction by thinking about what the poorly-named variables represent.
- Testing State vs Testing Behavior
    - state-focused: We are doing something, then checking what, if any, state change occurred.
    - behavior-focuses: Think about what behaviors you expect and have our tests center around those.
        - Building our system in a behavior-focused way is about only building the things that are absolutely needed and only at the time they are needed.
        - When I think there is something I want to build, I ask myself a simple question: “What behavior of my system requires this?”
        - Once I answer that question, I move to building that behavior.
- Breaking Abstraction level
- Naive duplication
    - The Don't Repeat Yourself, or DRY, principle states:
        
        > Every piece of knowledge has one and only one representation
        > 
        - Just looking at code that appears similar and combining them misses the point of the DRY principle.
    - One good technique to keep from mistaking similar-looking code as actual knowledge duplication is to explicitly name the concepts before you try to eliminate the duplication.
- [Procedural Polymorphism](https://8thlight.com/insights/procedural-polymorphism)
    - Polymorphism is about being able to call a method/send a message to an object and have more than one possible behavior.
    - Procedural Polymorphism
        - IF statements (or other branching constructs)
        - leads to tightly-coupled code, joining these often unrelated behaviors together.
    - Type-Based Polymorphism (OOP)
        - use different types for the different branches.
        - The general approach is to analyze what the branching condition is, identify the concepts, and reify them into first-class concepts in our system.
- Making Assumptions about usage
    - Inside-out development
        Do we need this abstraction? We start somewhere in our domain, making a very large assumption that the abstractions we are building will be needed sometime.
    - Outside-in development
        Use influences structure and design for value.
        So many answers not just disappear but never come up when building abstractions and behaviors through actual usage.
        

# References

- [Four rules of simple design](https://martinfowler.com/bliki/BeckDesignRules.html)
- [The Four Elements of Simple Design](https://blog.jbrains.ca/permalink/the-four-elements-of-simple-design)
- [Conway’s Game Of Life Start Code (Java version)](https://www.geeksforgeeks.org/program-for-conways-game-of-life/#)
- [PlayGameOfLife](https://playgameoflife.com/)
- [Write code for humans, not for computers](https://metalblueberry.github.io/post/blog/2020-06-14_write_code_for_humans_not_for_computers/)
- [Knowledge Sharing](https://abseil.io/resources/swe-book/html/ch03.html)
    - Book: Software Engineering at Google
