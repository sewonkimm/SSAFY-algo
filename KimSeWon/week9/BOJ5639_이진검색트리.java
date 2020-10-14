package com.week9;

import java.util.Scanner;

public class BOJ5639_이진검색트리 {
	
	static class Node {
		private Node Left, Right;
		private int data;
		
		Node(int i){
			Left = null;
			Right = null;
			data = i;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Node root = new Node(n);
		
		while(sc.hasNext()) {
			n = sc.nextInt();
			root = insertNode(root, n);
		}
		
		postOrder(root);
		sc.close();
	}
	
	public static Node insertNode(Node node, int n) {
		if(node == null) {
			return new Node(n);
		}
		
		Node cur = null;
		if(node.data > n) {	// 왼쪽에 저장
			cur = insertNode(node.Left, n);
			node.Left = cur;
		}
		else {	// 오른쪽에 저장
			cur = insertNode(node.Right, n);
			node.Right = cur;
		}
		return node;
	}
	
	public static void postOrder(Node node) {
		if(node != null) {
			postOrder(node.Left);
			postOrder(node.Right);
			System.out.println(node.data);
		}
	}
	
}
