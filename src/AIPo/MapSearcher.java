package AIPo;
import java.util.ArrayList;
import java.util.List;
import map.*;

public class MapSearcher {
	
	private int canwalk[]={0,1,2,3,51,52,53,54,55,88};//可用走的属性
    public static int[][] maps=new int[37][37];
    // 四个方向
    
    public static final int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0},{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    ArrayList<Integer> x=new ArrayList<>();
	ArrayList<Integer> y=new ArrayList<>();
    public static final int step = 100;

    private ArrayList<Node> openList = new ArrayList<Node>();
    private ArrayList<Node> closeList = new ArrayList<Node>();

    
    public void setMaps(int[][] maps){
    	for(int i=0;i<maps.length;i++){
    		for(int j=0;j<maps[0].length;j++){
    		this.maps[i][j]=maps[i][j];
    		}
    	}
    }
    
    
    public Node findMinFNodeInOpneList() {
        Node tempNode = openList.get(0);
        for (Node node : openList) {
            if (node.F < tempNode.F) {
                tempNode = node;
            }
        }
        return tempNode;
    }

    public ArrayList<Node> findNeighborNodes(Node currentNode) {
        ArrayList<Node> arrayList = new ArrayList<Node>();
        // 只考虑上下左右，不考虑斜对角
        for (int i = 0; i < 8; i++) {
            int newX = currentNode.x + direct[i][0];
            int newY = currentNode.y + direct[i][1];
            if(i<4){
            if (canReach(newX, newY) && !exists(openList, newX, newY))
                arrayList.add(new Node(newX, newY));
        }else{
        	if(canReach1(newX, newY,i) && !exists(openList, newX, newY)){
        		arrayList.add(new Node(newX, newY));
        	}
        }
        }
        return arrayList;
        
        
    }
    public boolean canReach1(int x, int y,int q) {
    	boolean t1=false,t2=false,t3=false,t4=false;
        if (x >= 0 && x < maps.length && y >= 0 && y < maps[0].length) {
        	
        	for(int i:canwalk){
        		if(maps[x][y]==i){
        			t1=true;
        		}
        	}
        	if(q==4){
        		for(int i:canwalk){
            		if(maps[x-1][y]==i){
            			t2=true;
            		}
            		if(maps[x][y-1]==i){
            			t3=true;
            		}
            	}
        	}
        	if(q==5){
        		for(int i:canwalk){
            		if(maps[x+1][y]==i){
            			t2=true;
            		}
            		if(maps[x][y+1]==i){
            			t3=true;
            		}
            	}
        	}
        	if(q==6){
        		for(int i:canwalk){
            		if(maps[x-1][y]==i){
            			t2=true;
            		}
            		if(maps[x][y+1]==i){
            			t3=true;
            		}
            	}
        	}
        	if(q==7){
        		for(int i:canwalk){
            		if(maps[x+1][y]==i){
            			t2=true;
            		}
            		if(maps[x][y-1]==i){
            			t3=true;
            		}
            	}
        	}
        	
        }
        if(t1 && t2 && t3){
        	return true;
        }
        return false;
    }

    public boolean canReach(int x, int y) {
    	boolean t1=false,t2=false,t3=false,t4=false;
        if (x >= 0 && x < maps.length && y >= 0 && y < maps[0].length) {
        	
        	for(int i:canwalk){
        		if(maps[x][y]==i){
        			t1=true;
        		}
        		
        		
        	}
        }
        if(t1){
        	return true;
        }
        return false;
    }

    public Node findPath(Node startNode, Node endNode) {

        // 把起点加入 open list
        openList.add(startNode);

        while (openList.size() > 0) {
            // 遍历 open list ，查找 F值最小的节点，把它作为当前要处理的节点
            Node currentNode = findMinFNodeInOpneList();
            // 从open list中移除
            openList.remove(currentNode);
            // 把这个节点移到 close list
            closeList.add(currentNode);

            ArrayList<Node> neighborNodes = findNeighborNodes(currentNode);
            for (Node node : neighborNodes) {
                //当前节点的相邻界节点已经在开放链表中
                if (exists(openList, node)) {
                    foundPoint(currentNode, node);
                } else {
                    notFoundPoint(currentNode, endNode, node);
                }
            }
            //终点在开放链表中，则找到路径
            if (find(openList, endNode) != null) {
                return find(openList, endNode);
            }
        }

        return find(openList, endNode);
    }

    private void foundPoint(Node tempStart, Node node) {
        int G = calcG(tempStart, node);
        //途径当前节点tempStart到达该节点node的距离G更小时，更新F
        if (G < node.G) {
            node.parent = tempStart;
            node.G = G;
            node.calcF();
        }
    }

    private void notFoundPoint(Node tempStart, Node end, Node node) {
        node.parent = tempStart;
        node.G = calcG(tempStart, node);
        node.H = calcH(end, node);
        node.calcF();
        openList.add(node);
    }

    private int calcG(Node start, Node node) {
        int G = step;
        int parentG = node.parent != null ? node.parent.G : 0;
        return G + parentG;
    }

    private int calcH(Node end, Node node) {
        int step = Math.abs(node.x - end.x) + Math.abs(node.y - end.y);
        return step * step;
    }
    
    public void findpath(){
    	x.clear();
    	y.clear();
    	int[][] point={{4,4},{18,4},{18,32},{4,32},{4,18},{32,18},{32,32}};
    	for(int j=0;j<point.length-1;j++){
    	Node startNode = new Node(point[j][0], point[j][1]);
        Node endNode = new Node(point[j+1][0], point[j+1][1]);
        Node parent = new MapSearcher().findPath(startNode, endNode);
        ArrayList<Node> arrayList = parent != null ? getPaths(parent) : null;
        patha(arrayList);
    	}
    }
    public void patha(ArrayList<Node> arrayList) {
    	
    	for(int i=arrayList.size()-1;i>=0;i--) {
            x.add(arrayList.get(i).x);
            y.add(arrayList.get(i).y);
        }
    }
    public int[][] getpath(){
    	int[][] rt=new int[x.size()][2];
    	for(int q=0;q<x.size();q++){
    		rt[q][0]=x.get(q);
    		rt[q][1]=y.get(q);
    	}
    	return rt;
    }
    public void display(){
    	for(int q=0;q<x.size();q++){
    		System.out.print(x.get(q)+","+y.get(q)+"=>");
    		
    	}
    }

    public static void main(String[] args) {
        //定点:起点终点
    	fb fb=new fb();
    	fb.test();
    	maps=fb.jz;
    	MapSearcher m=new MapSearcher();
    	Node startNode = new Node(20, 24);
        Node endNode = new Node(90, 20);
        Node parent = new MapSearcher().findPath(startNode, endNode);
        
        ArrayList<Node> arrayList = parent != null ? getPaths(parent) : null;
        m.geta(parent);
        printPaths(arrayList);
        int size=arrayList.size();
//        String[] a=(String[])arrayList.toArray(new String[size]);
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (i == 0)
                System.out.print(arrayList.get(i));
            else{
            	int a=arrayList.get(i).x;
                System.out.print(a + "->");
            }
        }
//        Node startNode = new Node(20, 24);
//        Node endNode = new Node(90, 20);
//        //尝试寻找最短路径
//        Node parent = new MapSearcher().findPath(startNode, endNode);
//        
//        printMap(maps);
//
//        ArrayList<Node> arrayList = parent != null ? getPaths(parent) : null;
//
//        printPaths(arrayList);

    }

    private static void printMap(int[][] maps) {

        for (int i = 0; i < maps[0].length; i++) {
            System.out.print("\t" + i + ",");
        }
        System.out.print("\n-----------------------------------------\n");
        int count = 0;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                if (j == 0)
                    System.out.print(count++ + "|\t");
                System.out.print(maps[i][j] + ",\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    ArrayList<Integer> ax=new ArrayList<>();
    ArrayList<Integer> ay=new ArrayList<>();
    //从终点开始沿着路径退回起点
    private static ArrayList<Node> getPaths(Node endNode) {
        ArrayList<Node> arrayList = new ArrayList<Node>();
        Node pre = endNode;
        while (pre != null) {
            arrayList.add(new Node(pre.x, pre.y));
            
            pre = pre.parent;
        }
        return arrayList;
    }
    public void geta(Node pre){
    	
    }
    private void getPaths1(Node endNode) {
        ArrayList<Node> arrayList = new ArrayList<Node>();
        Node pre = endNode;
        while (pre != null) {
        	ax.add(pre.x);
            ay.add(pre.y);
            pre = pre.parent;
        }
        
    }
    public static void printPaths(ArrayList<Node> arrayList) {
        // 地图形式
        for (int i = 0; i < maps[0].length; i++) {
            System.out.print("\t" + i + ",");
        }
        System.out.print("\n-----------------------------------------\n");
        int count = 0;

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                if (j == 0)
                    System.out.print(count++ + "|\t");
                if (exists(arrayList, i, j)) {
                    System.out.print("@,\t");
                } else {
                    System.out.print(maps[i][j] + ",\t");
                }

            }
            System.out.println();
        }
        System.out.println();
        // 路径形式
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (i == 0)
                System.out.print(arrayList.get(i));
            else
                System.out.print(arrayList.get(i) + "->");
        }
        System.out.println();
    }

    public static Node find(List<Node> maps, Node point) {
        for (Node n : maps)
            if ((n.x == point.x) && (n.y == point.y)) {
                return n;
                
            }
        return null;
    }

    public static boolean exists(List<Node> maps, Node node) {
        for (Node n : maps) {
            if ((n.x == node.x) && (n.y == node.y)) {
                return true;
            }
        }
        return false;
    }

    public static boolean exists(List<Node> maps, int x, int y) {
        for (Node n : maps) {
            if ((n.x == x) && (n.y == y)) {
                return true;
            }
        }
        return false;
    }


}

class Node {
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x;
    public int y;

    public int F;
    public int G;
    public int H;

    public void calcF() {
        this.F = this.G + this.H;
    }

    public Node parent;

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
