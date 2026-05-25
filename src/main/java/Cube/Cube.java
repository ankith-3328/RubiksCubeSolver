package Cube;

import Moves.Moves;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cube {
    public char[][][] faces;
    public List<String> history;

    public Cube() {
        faces = new char[6][3][3];
        history = new ArrayList<>();

        char[] colors = {'W','Y','G','B','O','R'};

        for(int f=0; f<6; f++) {
            for(int r=0; r<3; r++) {
                for(int c=0; c<3; c++) {
                    faces[f][r][c] = colors[f];
                }
            }
        }
    }

    public void print() {
        // UP FACE
        for(int r = 0; r < 3; r++) {

            System.out.print("      ");

            for(int c = 0; c < 3; c++) {
                System.out.print(faces[0][r][c] + " ");
            }

            System.out.println();
        }

        System.out.println();

        // LEFT FRONT RIGHT BACK
        for(int r = 0; r < 3; r++) {

            // LEFT
            for(int c = 0; c < 3; c++) {
                System.out.print(faces[4][r][c] + " ");
            }

            // FRONT
            for(int c = 0; c < 3; c++) {
                System.out.print(faces[2][r][c] + " ");
            }

            // RIGHT
            for(int c = 0; c < 3; c++) {
                System.out.print(faces[5][r][c] + " ");
            }

            // BACK
            for(int c = 0; c < 3; c++) {
                System.out.print(faces[3][r][c] + " ");
            }

            System.out.println();
        }

        System.out.println();

        // DOWN FACE
        for(int r = 0; r < 3; r++) {

            System.out.print("      ");

            for(int c = 0; c < 3; c++) {
                System.out.print(faces[1][r][c] + " ");
            }

            System.out.println();
        }
    }

    public boolean isSolved() {

        for(int face = 0; face < 6; face++) {

            char color = faces[face][0][0];

            for(int row = 0; row < 3; row++) {
                for(int col = 0; col < 3; col++) {

                    if(faces[face][row][col] != color) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public void apply(String algorithm) {

        String[] moves = algorithm.trim().split("\\s+");

        for(String move : moves) {
            history.add(move);
        }

        Moves.executeMoves(this, moves);
    }

    public void scramble(int length) {

        String[] moves = {
                "R", "R'",
                "L", "L'",
                "U", "U'",
                "D", "D'",
                "F", "F'",
                "B", "B'"
        };

        Random random = new Random();

        StringBuilder sequence = new StringBuilder();

        for(int i = 0; i < length; i++) {

            String move = moves[random.nextInt(moves.length)];

            sequence.append(move);

            if(i != length - 1) {
                sequence.append(" ");
            }
        }

        String[] scramble = sequence.toString().trim().split("\\s+");

        for(String move : scramble){
            history.add(move);
        }

        Moves.executeMoves(this, scramble);
    }

    public void solve() {

        StringBuilder reverse = new StringBuilder();

        for(int i = history.size() - 1; i >= 0; i--) {

            String move = history.get(i);

            if(move.endsWith("'")) {
                move = move.substring(0, move.length() - 1);
            }
            else {
                move = move + "'";
            }

            reverse.append(move);

            if(i != 0) {
                reverse.append(" ");
            }
        }

        String[] scramble = reverse.toString().trim().split("\\s+");
        Moves.executeMoves(this, scramble);
        history.clear();
    }

    public Cube copy() {

        Cube newCube = new Cube();

        for(int f = 0; f < 6; f++) {
            for(int r = 0; r < 3; r++) {
                for(int c = 0; c < 3; c++) {

                    newCube.faces[f][r][c] = this.faces[f][r][c];
                }
            }
        }

        return newCube;
    }

    public String encode() {

        StringBuilder sb = new StringBuilder();

        for(int f = 0; f < 6; f++) {
            for(int r = 0; r < 3; r++) {
                for(int c = 0; c < 3; c++) {

                    sb.append(faces[f][r][c]);
                }
            }
        }

        return sb.toString();
    }
}
