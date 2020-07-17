//Cameron Roberts
//Prof.Salloum
//ProgAssign5:Huffman Algorithm

package huffman;


import java.util.PriorityQueue; 
import java.util.Scanner; 
import java.util.Comparator; 
  
class HuffmanPoint { 
  
    int charFrequency; 
    char c; 
  
    HuffmanPoint left; 
    HuffmanPoint right; 
} 
  

class MyComparator implements Comparator<HuffmanPoint> { 
    public int compare(HuffmanPoint x, HuffmanPoint y) 
    { 
  
        return x.charFrequency - y.charFrequency; 
    } 
} 
  
public class Huffman { 
  
    public static void printFunc(HuffmanPoint root, String s) 
    { 
  
        // base case; if the left and right are null 
        
        if (root.left 
                == null
            && root.right 
                   == null
            && Character.isLetter(root.c)) { 
  
            // c is the character in the node 
            System.out.println(root.c + ":" + s); 
  
            return; 
        } 
  
        
        printFunc(root.left, s + "0"); 
        printFunc(root.right, s + "1"); 
    } 
  
    // main function 
    public static void main(String[] args) 
    { 
  
        Scanner s = new Scanner(System.in); 
  
         
        int n = 26; 
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f', 'g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}; 
        int[] charfreq = { 85, 14, 22, 42,111, 22,20,61,75,1,13,40,24,67,75,19,1,76,19,1,76,63,93,27,9,25,1,20,1};
  
        
        PriorityQueue<HuffmanPoint> queue 
            = new PriorityQueue<HuffmanPoint>(n, new MyComparator()); 
  
        for (int i = 0; i < n; i++) { 
  
            // creating a HuffmanPoint object 
            //  add priority queue. 
            HuffmanPoint hn = new HuffmanPoint(); 
  
            hn.c = charArray[i]; 
            hn.charFrequency = charfreq[i]; 
  
            hn.left = null; 
            hn.right = null; 
  
            
            queue.add(hn); 
        } 
  
        // create a root node 
        HuffmanPoint root = null; 
  
   
        while (queue.size() > 1) { 
  
            // first min  
            HuffmanPoint x = queue.peek(); 
            queue.poll(); 
  
            // second min 
            HuffmanPoint y = queue.peek(); 
            queue.poll(); 
  
            // new node is equal 
            HuffmanPoint f = new HuffmanPoint(); 
  
             
            f.charFrequency = x.charFrequency + y.charFrequency; 
            f.c = '-'; 
  
            // first extracted node as left child. 
            f.left = x; 
 
            
            f.right = y; 
  
            
            root = f; 
  
            // add node to priority-queue. 
            queue.add(f); 
        } 
  
        System.out.println("Character:BinaryCode");
        System.out.println("----------------------");
        printFunc(root, ""); 
    } 
}