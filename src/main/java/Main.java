import Cube.Cube;
import Solver.BFSsolver;
import Solver.IDDFSsolver;

public class Main {
    static void main() {
//        Cube cube = new Cube();
//        String algorithm = "F R U' D B' R' U B' U' R' F'";
//        cube.apply(algorithm);
//        cube.scramble(50);
//        cube.print();
//        System.out.println(cube.history);
//
//        cube.solve();
//        cube.print();
//        System.out.println(cube.history);

        Cube cube = new Cube();
        cube.scramble(8);
        cube.print();
        System.out.println(cube.history);
        System.out.println();

        String algorithm = IDDFSsolver.solve(cube);
        System.out.println(algorithm);
        cube.apply(algorithm);
        cube.print();
    }
}
