package Moves;

import Cube.Cube;

public class Moves {
    public static void executeMoves(Cube cube, String[] moves) {

        for(String move : moves) {

            switch(move) {

                case "R":
                    R(cube);
                    break;

                case "R'":
                    R(cube);
                    R(cube);
                    R(cube);
                    break;

                case "L":
                    L(cube);
                    break;

                case "L'":
                    L(cube);
                    L(cube);
                    L(cube);
                    break;

                case "U":
                    U(cube);
                    break;

                case "U'":
                    U(cube);
                    U(cube);
                    U(cube);
                    break;

                case "D":
                    D(cube);
                    break;

                case "D'":
                    D(cube);
                    D(cube);
                    D(cube);
                    break;

                case "F":
                    F(cube);
                    break;

                case "F'":
                    F(cube);
                    F(cube);
                    F(cube);
                    break;

                case "B":
                    B(cube);
                    break;

                case "B'":
                    B(cube);
                    B(cube);
                    B(cube);
                    break;

                default:
                    System.out.println("Invalid move: " + move);
            }
        }
    }

    public static void rotateFaceClockwise(char[][] face) {

        char[][] temp = new char[3][3];

        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                temp[c][2 - r] = face[r][c];
            }
        }

        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                face[r][c] = temp[r][c];
            }
        }
    }

    // ==================== R ====================

    public static void R(Cube cube) {

        char[][][] f = cube.faces;

        rotateFaceClockwise(f[5]);

        char[] temp = new char[3];

        for(int i = 0; i < 3; i++) {
            temp[i] = f[0][i][2];
        }

        for(int i = 0; i < 3; i++) {
            f[0][i][2] = f[2][i][2];
        }

        for(int i = 0; i < 3; i++) {
            f[2][i][2] = f[1][i][2];
        }

        for(int i = 0; i < 3; i++) {
            f[1][i][2] = f[3][2 - i][0];
        }

        for(int i = 0; i < 3; i++) {
            f[3][2 - i][0] = temp[i];
        }
    }

    // ==================== L ====================

    public static void L(Cube cube) {

        char[][][] f = cube.faces;

        rotateFaceClockwise(f[4]);

        char[] temp = new char[3];

        for(int i = 0; i < 3; i++) {
            temp[i] = f[0][i][0];
        }

        for(int i = 0; i < 3; i++) {
            f[0][i][0] = f[3][2 - i][2];
        }

        for(int i = 0; i < 3; i++) {
            f[3][2 - i][2] = f[1][i][0];
        }

        for(int i = 0; i < 3; i++) {
            f[1][i][0] = f[2][i][0];
        }

        for(int i = 0; i < 3; i++) {
            f[2][i][0] = temp[i];
        }
    }

    // ==================== U ====================

    public static void U(Cube cube) {

        char[][][] f = cube.faces;

        rotateFaceClockwise(f[0]);

        char[] temp = new char[3];

        for(int i = 0; i < 3; i++) {
            temp[i] = f[2][0][i];
        }

        for(int i = 0; i < 3; i++) {
            f[2][0][i] = f[5][0][i];
        }

        for(int i = 0; i < 3; i++) {
            f[5][0][i] = f[3][0][i];
        }

        for(int i = 0; i < 3; i++) {
            f[3][0][i] = f[4][0][i];
        }

        for(int i = 0; i < 3; i++) {
            f[4][0][i] = temp[i];
        }
    }

    // ==================== D ====================

    public static void D(Cube cube) {

        char[][][] f = cube.faces;

        rotateFaceClockwise(f[1]);

        char[] temp = new char[3];

        for(int i = 0; i < 3; i++) {
            temp[i] = f[2][2][i];
        }

        for(int i = 0; i < 3; i++) {
            f[2][2][i] = f[4][2][i];
        }

        for(int i = 0; i < 3; i++) {
            f[4][2][i] = f[3][2][i];
        }

        for(int i = 0; i < 3; i++) {
            f[3][2][i] = f[5][2][i];
        }

        for(int i = 0; i < 3; i++) {
            f[5][2][i] = temp[i];
        }
    }

    // ==================== F ====================

    public static void F(Cube cube) {

        char[][][] f = cube.faces;

        rotateFaceClockwise(f[2]);

        char[] temp = new char[3];

        for(int i = 0; i < 3; i++) {
            temp[i] = f[0][2][i];
        }

        for(int i = 0; i < 3; i++) {
            f[0][2][i] = f[4][2 - i][2];
        }

        for(int i = 0; i < 3; i++) {
            f[4][i][2] = f[1][0][i];
        }

        for(int i = 0; i < 3; i++) {
            f[1][0][i] = f[5][2 - i][0];
        }

        for(int i = 0; i < 3; i++) {
            f[5][i][0] = temp[i];
        }
    }

    // ==================== B ====================

    public static void B(Cube cube) {

        char[][][] f = cube.faces;

        rotateFaceClockwise(f[3]);

        char[] temp = new char[3];

        for(int i = 0; i < 3; i++) {
            temp[i] = f[0][0][i];
        }

        for(int i = 0; i < 3; i++) {
            f[0][0][i] = f[5][i][2];
        }

        for(int i = 0; i < 3; i++) {
            f[5][i][2] = f[1][2][2 - i];
        }

        for(int i = 0; i < 3; i++) {
            f[1][2][i] = f[4][i][0];
        }

        for(int i = 0; i < 3; i++) {
            f[4][i][0] = temp[2 - i];
        }
    }
}
