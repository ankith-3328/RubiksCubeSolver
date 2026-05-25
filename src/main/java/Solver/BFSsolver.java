package Solver;

import Cube.Cube;

import java.util.*;

public class BFSsolver {

    static String[] MOVES = {
            "R", "R'",
            "L", "L'",
            "U", "U'",
            "D", "D'",
            "F", "F'",
            "B", "B'"
    };

    static class Node {

        Cube cube;
        String path;

        Node(Cube cube, String path) {
            this.cube = cube;
            this.path = path;
        }
    }

    public static String solve(Cube start) {

        Queue<Node> queue = new LinkedList<>();

        HashSet<String> visited = new HashSet<>();

        queue.add(new Node(start.copy(), ""));

        visited.add(start.encode());

        while(!queue.isEmpty()) {

            Node current = queue.poll();

            if(current.cube.isSolved()) {
                return current.path;
            }

            for(String move : MOVES) {

                Cube next = current.cube.copy();

                next.apply(move);

                String encoded = next.encode();

                if(!visited.contains(encoded)) {

                    visited.add(encoded);

                    String newPath;

                    if(current.path.isEmpty()) {
                        newPath = move;
                    }
                    else {
                        newPath = current.path + " " + move;
                    }

                    queue.add(new Node(next, newPath));
                }
            }
        }

        return "No solution found";
    }
}