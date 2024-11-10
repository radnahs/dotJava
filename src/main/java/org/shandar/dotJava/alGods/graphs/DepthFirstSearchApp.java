/**
 *
 * <p>Project: dotJava </p>
 * <p>Package Name: org.shandar.dotJava.alGods.graphs </p>
 * <p>File Name: DepthFirstSearchApp.java</p>
 * <p>Create Date: 10-Nov-2024 </p>
 * <p>Create Time: 1:16:55 pm </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2024</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.shandar.dotJava.alGods.graphs;

/**
 * 
 */
public class DepthFirstSearchApp {

	public static void main(String[] args) {
		GraphDFS theGraphDFS = new GraphDFS();
		theGraphDFS.addVertex('A'); // 0 (start for dfs)
		theGraphDFS.addVertex('B'); // 1
		theGraphDFS.addVertex('C'); // 2
		theGraphDFS.addVertex('D'); // 3
		theGraphDFS.addVertex('E'); // 4
		theGraphDFS.addEdge(0, 1); // AB
		theGraphDFS.addEdge(1, 2); // BC
		theGraphDFS.addEdge(0, 3); // AD
		theGraphDFS.addEdge(3, 4); // DE
		System.out.print("Visits: ");
		theGraphDFS.dfs(); // depth-first search
		System.out.println();
	}

}

class StackDFS {

	private final int SIZE = 20;
	private int[] st;
	private int top;

	public StackDFS() {
		this.st = new int[SIZE];
		this.top = -1;
	}

	public void push(int j) {
		st[++top] = j;
	}

	public int pop() {
		return st[top--];
	}

	public int peek() {
		return st[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

}

class VertexDFS {

	public char label;
	public boolean wasVisited;

	public VertexDFS(char label) {
		this.label = label;
		this.wasVisited = false;
	}

}

class GraphDFS {

	private final int MAX_VERTICES = 20;
	private VertexDFS vertexDFSList[];
	private int adjacentMatrix[][];
	private int nVerts;
	private StackDFS theStackDFS;

	/**
	 * @param vertexDFSList
	 * @param adjacentMatrix
	 * @param nVerts
	 * @param theStackDFS
	 */
	public GraphDFS() {
		super();
		this.vertexDFSList = new VertexDFS[MAX_VERTICES];
		this.adjacentMatrix = new int[MAX_VERTICES][MAX_VERTICES];
		this.nVerts = 0;
		for (int j = 0; j < MAX_VERTICES; j++) {
			for (int k = 0; k < MAX_VERTICES; k++) {
				adjacentMatrix[j][k] = 0;
			}
		}
		this.theStackDFS = new StackDFS();
	}

	public void addVertex(char label) {
		vertexDFSList[nVerts++] = new VertexDFS(label);
	}

	public void addEdge(int start, int end) {
		adjacentMatrix[start][end] = 1;
		adjacentMatrix[end][start] = 1;
	}

	public void displayVertexDFS(int v) {
		System.out.println(vertexDFSList[v].label);
	}

	public void dfs() {
		vertexDFSList[0].wasVisited = true;
		displayVertexDFS(0);
		theStackDFS.push(0);
		while (!theStackDFS.isEmpty()) {
			int v = getAdjUnvisitedVertex(theStackDFS.peek());
			if (v == -1) {
				theStackDFS.pop();
			} else {
				vertexDFSList[v].wasVisited = true;
				displayVertexDFS(v);
				theStackDFS.push(v);
			}
		}

		for (int j = 0; j < nVerts; j++) {
			vertexDFSList[j].wasVisited = false;
		}
	}

	public int getAdjUnvisitedVertex(int v) {
		for (int j = 0; j < nVerts; j++) {
			if (adjacentMatrix[v][j] == 1 && vertexDFSList[j].wasVisited == false) {
				return j;
			}
		}
		return -1;
	}

}
