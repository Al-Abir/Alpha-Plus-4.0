package Graph;

public class Disjoint {
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    // Initialize parent and rank arrays
    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0; // Initially, all ranks are 0
        }
    }

    // Find with path compression
    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]); // Path compression
    }

    // Union by rank
    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (parA != parB) { // Only union if they are in different sets
            if (rank[parA] > rank[parB]) {
                par[parB] = parA; // Attach parB's tree under parA
            } else if (rank[parA] < rank[parB]) {
                par[parA] = parB; // Attach parA's tree under parB
            } else {
                par[parB] = parA; // Attach one under the other and increase rank
                rank[parA]++;
            }
        }
    }

    public static void main(String[] args) {
        init();

        // Union operations
        union(1, 3);
        System.out.println("Parent of 3: " + find(3)); // Should print 1

        union(3, 4);
        System.out.println("Parent of 4: " + find(4)); // Should print 1
    }
}
