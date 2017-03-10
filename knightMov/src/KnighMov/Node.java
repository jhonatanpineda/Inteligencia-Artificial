package KnighMov;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Node {

    private final List<Node> adj = new ArrayList();
    public int x;
    public int y;
    public String state;
    
    public int totalCost;
    public int cost;

    public Node(int x, int y) {
            totalCost = 0;
            this.x = x;
            this.y = y;
            this.state = "Unvisited";
    }

    public String getState() {
        return state;
    }

    boolean restriccion(Node adj) {
        if (x + 2 == adj.getx() && y + 1 == adj.gety()) {
            return true;
        }
        if (x + 1 == adj.getx() && y + 2 == adj.gety()) {
            return true;
        }
        if (x - 1 == adj.getx() && y + 2 == adj.gety()) {
            return true;
        }
        if (x - 2 == adj.getx() && y + 1 == adj.gety()) {
            return true;
        }
        if (x - 2 == adj.getx() && y - 1 == adj.gety()) {
            return true;
        }
        if (x - 1 == adj.getx() && y - 2 == adj.gety()) {
            return true;
        }
        if (x + 1 == adj.getx() && y - 2 == adj.gety()) {
            return true;
        }
        if (x == adj.getx() && y == adj.gety()) {
            return false;
        }
        return x + 2 == adj.getx() && y - 1 == adj.gety();
    }

    public void AddV(List<Node> adj) {

        for (Node n : adj) {
            if (restriccion(n)) {
                state = "Unvisited";
                this.cost = cost;
                this.totalCost = 1+cost;
                this.adj.add(n);
            }
        }

    }

    public List<Node> getAdj() {
        return adj;
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }
    

    @Override
    public String toString() {
        return "Node{" + "x=" + x + ", y=" + y + '}';
    }

}
