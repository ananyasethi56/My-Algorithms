import java.util.*;
import java.io.*;
public class Dijkastra
{
    static final int v=9;
    int minDist(int dist[],boolean visited[])
    {
        int min=Integer.MAX_VALUE, min_index=-1;
        for(int i=0;i<v;i++)
        {
            if(visited[i]==false && dist[i]<min)
            {
                min=dist[i];
                min_index=i;
            }
        }
        return min_index;
    }
   void printSolution(int dist[], int n)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < v; i++)
            System.out.println(i+" tt "+dist[i]);
    }
 
     void shortestpath(int graph[][],int src)
    {
       boolean visited[]=new boolean[v];
       int dist[]=new int[v];
       for(int i=0;i<v;i++)
       {
           dist[i]=Integer.MAX_VALUE;
           visited[i]=false;
       }
      dist[src]=0;
      for(int count=0;count<v-1;count++)
      {
          int u=minDist(dist,visited);
          visited[u]=true;
          for(int i=0;i<v;i++)
          {
              if(!visited[i] && dist[u]!=Integer.MAX_VALUE && graph[u][i]!=0 
              && dist[u]+graph[u][i]<dist[i])
              {
                  dist[i]=dist[u]+graph[u][i];
              }
          }
      }
       printSolution(dist, v);
    }
    public static void main(String arr[])
    {
        /* Let us create the example graph discussed above */
       int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                  {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                  {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0}
                                 };
        Dijkastra t = new Dijkastra();
        t.shortestpath(graph, 0);
    }


}