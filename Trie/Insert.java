package Trie;

public class Insert {

    // Make the Node class static to avoid static context issues
    public static class Node {
        Node[] children = new Node[26]; // Corrected type: array of Nodes
        boolean eow = false; // End of word flag

        Node() {
            // Initialize all children to null
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node(); // Root of the Trie

    // Method to insert a word into the Trie
    public static void insert(String word) {
        Node curr = root; // Start from the root
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a'; // Calculate index for character
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node(); // Create a new Node if null
            }
            curr = curr.children[idx]; // Move to the next level
        }
        curr.eow = true; // Mark the end of the word
    }

    public static boolean search(String key){
        Node curr = root;
        for(int i=0; i<key.length();i++){
            int idx = key.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr= curr.children[idx];
        }
        return curr.eow==true;
    }

    public static boolean wordBreak(String key){
        if(key.length()==0){
            return true;
        }
        for(int i =1; i<=key.length(); i++)
        {
            if(search(key.substring(0,i))&& wordBreak(key.substring(i))){
                return true;
            }
        
        }
        return false;
    }

    public static void main(String[] args) {
        String words[] = {"i", "like", "sam", "samsung", "mobile","ice"};

        // Insert all words into the Trie
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println("Words inserted into the Trie successfully!");
        System.out.println(search("any"));


        String key  = "ilikesamsung";
        System.out.println(wordBreak(key));
    }
}
