package KnighMov;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int n;

    public Board(int n) {
        this.n = n;
    }

    private List<Node> vecinos() {
        List<Node> veci = new ArrayList();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Node a = new Node(i + 1, j + 1);
                veci.add(a);
            }
        }
        return veci;
    }

    public List<Node> Llenar() {
        List<Node> Todo = new ArrayList();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<Node> adj = new ArrayList();
                Node a = new Node(1 + i, 1 + j);
                adj = vecinos();
                a.AddV(adj);
                Todo.add(a);
            }
        }
        return Todo;
    }

}
