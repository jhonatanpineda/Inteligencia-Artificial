package KnighMov;


public class KnightMov {

    public static void main(String[] args) {

        Solved sol = new Solved(8,1);
        /*System.out.println("Bfs Solution: ");
        sol.Bfs();*/
        
        System.out.println("Dfs Solution: ");
        sol.Dfs();
        
        /*System.out.println("Ucs Solution: ");
        sol.Ucs();*/
    }
}
