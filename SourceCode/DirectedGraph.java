import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class DirectedGraph extends Graph {

	public LinkedList<Vertex> tList;
    public LinkedList<Vertex>[] adj;
    public Vertex[] vertList;
    
	 public DirectedGraph(BufferedReader reader) throws IOException
	    {
	        String line;
	        line = reader.readLine();
	        V = Integer.parseInt(line);
	        line = reader.readLine();
	        E = Integer.parseInt(line);
	        adj =  new LinkedList[V];
	        vertList = new Vertex[V];
	    	tList = new LinkedList<Vertex>();
	        for (int v = 0; v < V; v++) {
	            adj[v] = new LinkedList<Vertex>();
	            vertList[v] = new Vertex(v);
	        }
	        while ((line = reader.readLine()) != null) {
	            int tempV1, tempV2;
	              StringTokenizer st = new StringTokenizer(line, " ");
	              tempV1 = Integer.parseInt(st.nextToken());
	              tempV2 = Integer.parseInt(st.nextToken());
	              addEdge(tempV1, tempV2);
	        }
	    }

    public void addEdge(int v, int w) {
    	E++;
        adj[v].add(new Vertex(w));
   }
    
    public String tostring()
    {
        String s = new String();
        s = "There are "+V+" vertices and "+E+" edges\n";
        for(int i=0;i<V;i++)
        {
            s = s+i+": ";
            for(int j = 0; j<adj[i].size();j++)
            {
                s = s+adj[i].get(j).getKey()+" ";
            }
            s = s+"\n";
            
        }
        return s;
    }

    public void printPath(int s, int v)
    {
 	   if (vertList[v].getKey() == s)
 		   System.out.print(s + ", ");
 	   else if (vertList[v].getParent() == null)
 		   System.out.println("No path from " + s + " to " + vertList[v].getKey() + " exists.");
 	   else
 	   {			  
 		   printPath(s, vertList[v].getParent().getKey());
 		   System.out.print(vertList[v].getKey() + ", ");
 	   }
    }

    public void DFS ()
    {
 	   int time = 0;
 	   for (int i = 0; i < V; i++)
 	   {
 		   if (vertList[i].getColor().equals("white"))
 			   DFSVisit(vertList[i], time);
 	   }
    }
    
    public void DFSVisit(Vertex u, int time)
    {
 	   time++;
 	   u.setDistance(time);
 	   u.setColor("gray");
 	   for (int j = 0; j < adj[u.getKey()].size(); j++)
 	   {
 		   if (adj[u.getKey()].get(j).getColor().equals("white"))
 		   {
 			   	 adj[u.getKey()].get(j).setParent(u);
 		   		DFSVisit(adj[u.getKey()].get(j), time);
 		   }
 	   }
 	   u.setColor("black");
 	   time++;
 	   u.setFTime(time);
   		vertList[u.getKey()] = u;
   		
   		    	//	System.out.print(u.getKey() + " ");
   		    		
   		boolean isThere = false;
    	for (int i = 0; i < tList.size(); i++)
    	{
    		if (tList.size() > 0 && u.getKey() == tList.get(i).getKey())
    		{
    			tList.remove(i);
    			tList.push(u);
    			isThere = true;
    		}
    		
    	}
    	if (!isThere)
    	{

    		tList.push(u);

    		
    	}
    }
    public LinkedList<Vertex> topologicalSort()
    {
    	DFS();

    	return tList;
    }
   
    void topologicalSortUtil(int v, boolean visited[], LinkedList<Vertex> stack)
		{
		visited[v] = true;
		Vertex i;
		Iterator<Vertex> it = adj[v].iterator();
		while (it.hasNext())
		{
			i = it.next();
			if (!visited[i.getKey()])
			topologicalSortUtil(i.getKey(), visited, stack);
		}
		stack.push(new Vertex(v));
		}
    
    public LinkedList<Vertex> topologiclSort()
    {
    	DFS();
    	LinkedList<Vertex> stack = new LinkedList<Vertex>();
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
 
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);
        return stack;
    }
	
	
}
