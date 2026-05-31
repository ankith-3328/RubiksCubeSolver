package Solver;

import Cube.Cube;

import java.util.*;

public class IDDFSsolver {

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

        int depthLimit = 0;

        while(true) {

            HashSet<String> visited = new HashSet<>();

            String result = depthLimitedSearch(
                    new Node(start.copy(), ""),
                    depthLimit,
                    visited
            );

            if(result != null) {
                return result;
            }

            depthLimit++;
        }
    }

    private static String depthLimitedSearch(
            Node current,
            int depth,
            HashSet<String> visited
    ) {

        String encoded = current.cube.encode();

        visited.add(encoded);

        if(current.cube.isSolved()) {
            return current.path;
        }

        if(depth == 0) {
            return null;
        }

        for(String move : MOVES) {

            Cube next = current.cube.copy();

            next.apply(move);

            String nextEncoded = next.encode();

            if(!visited.contains(nextEncoded)) {

                String newPath;

                if(current.path.isEmpty()) {
                    newPath = move;
                }
                else {
                    newPath = current.path + " " + move;
                }

                String result = depthLimitedSearch(
                        new Node(next, newPath),
                        depth - 1,
                        visited
                );

                if(result != null) {
                    return result;
                }
            }
        }

        visited.remove(encoded);

        return null;
    }
}