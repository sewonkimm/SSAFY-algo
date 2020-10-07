import java.io.*;
import java.util.*;
 
public class algo_1008_boj5639_treeScan {
	
    static int arr[] = new int[10001];
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        
        Node root = new Node(N);
        
        //자바에는 EOF를 이런식으로 한다....슈레기...
        String str = null;
        while((str = br.readLine()) != null && str.length() != 0) {
        	N = Integer.parseInt(str);
        	root = insertNode(root, N);
        }
        postOrder(root);
    }
    
    //트리를 만들자
    public static class Node{
        Node left;
        Node right;
        int val; //숫자 값
        public Node(int v) {
            this.val = v;
        }
    }
    //노드추가해주자
    public static Node insertNode(Node node, int N) {
        Node current = null;
        if(node == null) {
            return new Node(N);
        }
        
        //크기에 따라 좌우로 나눠서 넣음
        if(node.val > N) { 
            current = insertNode(node.left, N);
            node.left = current;
        }else {
            current = insertNode(node.right, N);
            node.right = current;
        }
        return node;
    }
    
    //다시 그걸 후위순위로 돈다
    public static void postOrder(Node node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.val);
        }
    }
}