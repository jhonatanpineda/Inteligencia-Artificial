package KnighMov;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Solved {

    private final int n;
    private final int inicial;
    private final int[][] solve;
    private final Board tablero;

    private int size;

    public Solved(int n, int inicial) {
        this.size = 0;
        this.inicial = inicial;
        this.n = n;
        tablero = new Board(n);
        solve = new int[n][n];

    }

    @SuppressWarnings("empty-statement")
    public void Bfs() {

        List<Node> Nodes = tablero.Llenar();
        Queue<Node> queue = new LinkedList<>();
        Node root = Nodes.get(inicial);
        root.state = "Visited";
        queue.add(root);
        Load();

        while (!queue.isEmpty()) {
            Node r = queue.poll();
            r.state = "Visited";
            if (size == solve.length * solve.length) {
                return;
            }
            if (0 == (solve[r.y - 1][r.x - 1])) {
                size++;
                solve[r.y - 1][r.x - 1] = size;
            }
            System.out.println("BFS -->");
            View();
            for (Node hijo : r.getAdj()) {
                if (hijo.getState().equals("Unvisited")) {
                    for (Node tab : Nodes) {
                        if (hijo.getx() == tab.getx() && hijo.gety() == tab.gety()) {
                            queue.add(tab);;
                            break;
                        }
                    }
                    hijo.state = "Visited";
                }
            }
        }

    }

    public void Dfs() {

        List<Node> Nodes = tablero.Llenar();
        Stack<Node> stack = new Stack();
        Node root = Nodes.get(inicial);
        root.state = "Visited";
        stack.add(root);
        Load();

        while (!stack.isEmpty()) {
            Node r = stack.pop();
            if (size == solve.length * solve.length) {
                return;
            }
            if (0 == (solve[r.y - 1][r.x - 1])) {
                size++;
                solve[r.y - 1][r.x - 1] = size;
            }

            System.out.println("DFS -> ");
            View();
            
            for (Node hijo : r.getAdj()) {
                if ("Unvisited".equals(hijo.state)) {
                    for (Node tab : Nodes) {
                        if (hijo.getx() == tab.getx() && hijo.gety() == tab.gety()) {
                            stack.add(tab);
                            break;

                        }
                    }

                }
                hijo.state = "Visited";
            }
        }

    }
    
    @SuppressWarnings("empty-statement")
    public void Ucs() {

        List<Node> Nodes = tablero.Llenar();
        Comparator<Node> comparator = new CostComparator();
        PriorityQueue<Node> queue = new PriorityQueue<>(1, comparator);
        Node root = Nodes.get(inicial);
        root.state = "Visited";
        queue.add(root);
        Load();

        while (!queue.isEmpty()) {
            Node r = queue.poll();
            if (size == solve.length * solve.length) {
                return;
            }     
            if (0 == (solve[r.y - 1][r.x - 1])) {
                size++;
                solve[r.y - 1][r.x - 1] = size;
            }

            System.out.println("Ucs -->");
            View();
            
            for (Node hijo : r.getAdj()) {
                if (hijo.getState().equals("Unvisited")) {
                    for (Node tab : Nodes) {
                        if (hijo.getx() == tab.getx() && hijo.gety() == tab.gety()) {
                            queue.add(tab);;
                            break;
                        }
                    }
                    hijo.state = "Visited";
                }
            }
        }

    }

    private void Load() {
        for (int[] solve1 : solve) {
            for (int j = 0; j < solve.length; j++) {
                solve1[j] = 0;
            }
        }
    }

    private void View() {
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "|";
            for (int j = 0; j < n; j++) {
                if (solve[i][j] >= 0 && solve[i][j] <= 9) {
                    str += String.format("  %d |", solve[i][j]);
                } else {
                    str += String.format(" %d |", solve[i][j]);
                }
            }
            str += "\n";
        }
        System.out.print(str);
    }

}
