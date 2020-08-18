package com.ssafy;

import java.io.*;
import java.util.*;

public class networkTest {

	static int V,E;
	static Edge[] edgeList;
	static int[] parents;
	static class Edge {
		int start;
		int end;
		int weight;
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        int from, to, weight;
        
        edgeList = new Edge[E]; //
        parents = new int[V+1]; //컴퓨터수만큼
        for(int i=0;i<E;i++) {
        	st = new StringTokenizer(br.readLine()," ");
        	
        	from = Integer.parseInt(st.nextToken());
        	to = Integer.parseInt(st.nextToken());
        	weight = Integer.parseInt(st.nextToken());
        	
        	edgeList[i] = new Edge(from ,to, weight);
        }
        
        //정렬해주자
        Arrays.sort(edgeList,new Comparator<Edge>(){
			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.weight - o2.weight;
			}
        });
        make();
        int sum = 0;
        for(int i=0;i<E;i++) {
        	if(union(edgeList[i].start,edgeList[i].end))
        		sum += edgeList[i].weight;
        }
        System.out.println(sum);
	}
	
	public static void make() {
		for(int i=0;i<=V;i++) {
			parents[i] = i;
		}
	}
	public static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	public static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
}
