# Rubik's Cube Solver

A simple Java-based Rubik's Cube simulator and solver.

## Features

- 3x3 Rubik's Cube representation
- Basic cube moves:
    - `R`, `L`, `U`, `D`, `F`, `B`
    - Prime moves (`R'`, `L'`, etc.)
- Cube scrambling
- Cube state printing
- BFS-based solver
- Move history tracking

## Project Structure

```text
src/main/java/
├── Main.java
├── Cube/
│   └── Cube.java
├── Moves/
│   └── Moves.java
└── Solver/
    └── BFSsolver.java
```

## Requirements

- Java 25
- Maven

## Run the Project

Clone the repository:

```bash
git clone <your-repo-url>
cd RubiksCube
```

Compile and run:

```bash
mvn compile
mvn exec:java -Dexec.mainClass=Main
```

## Example

```java
Cube cube = new Cube();

cube.scramble(5);
cube.print();

String solution = BFSsolver.solve(cube);

System.out.println(solution);

cube.apply(solution);
cube.print();
```

## Notes

- The BFS solver works well for small scrambles.
- Large scramble depths may become slow due to the exponential search space.