package com.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 두 점(node)와 가중치(weight)가 주어지고
 * 모든 컴퓨터를 연결하는 최소비용을 구하는 것이므로 MST
 * 
 * kruskal 알고리즘 구현 (3가지만 기억)
 * 1. makeSet() : 초기화
 * 2. findSet(a) : a의 대표 노드 반환
 * 3. union(a, b) : 노드 a와 b 연결
 * */
public class Q1922 {

	static class Edge {
		int start;
		int end;
		int weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}		
	}
	
	static int N, M, sum;
	static int[] parents;
	static ArrayList<Edge> edgeList = new ArrayList<>();
	
	public static void main(String[] args) {
		// input
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		parents = new int[N+1];		
		makeSet();
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			
			edgeList.add(new Edge(a, b, w));
		}
		
		// edgeList 간선 오름차순으로 정렬
		Collections.sort(edgeList, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
			
		});
		
		// union 진행
		Iterator<Edge> iter = edgeList.iterator();
		while(iter.hasNext()) {
			Edge e = iter.next();
			
			if(union(e.start, e.end)) {
				sum += e.weight;
			}
		}
		
		System.out.println(sum);
	}
	
	public static void makeSet() {
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(parents[a] == a)	return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int pa = findSet(a);
		int pb = findSet(b);
		
		// root가 다르면 합치기
		if(pa != pb) {
			parents[pb] = pa;
			return true;
		}
		
		return false;
	}

}
