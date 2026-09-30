class disjoint{
    List<Integer> parent;
    List<Integer> size;
    disjoint(int n)
    {
        parent=new ArrayList<>();
        size=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            parent.add(i);
            size.add(1);
        }
    }
    public int finduparent(int node)
    {
        if(parent.get(node)==node)
        {
            return node;
        }
        int a=finduparent(parent.get(node));
        parent.set(node,a);
        return a;
    }
    public void dis(int u,int v)
    {
        int fu=finduparent(u);
        int fv=finduparent(v);
        if(fv==fu) return;
        if(size.get(fu)<size.get(fv))
        {
            parent.set(fu,fv);
            size.set(fv,size.get(fu)+size.get(fv));
        }
        else
        {
            parent.set(fv,fu);
            size.set(fu,size.get(fu)+size.get(fv));
        }
    }

}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        disjoint ds=new disjoint(n);
        int lines=0;
        
        for(int i[]:connections)
        {
            int a=i[0];
            int b=i[1];
            if(ds.finduparent(a)!=ds.finduparent(b))
            {
                ds.dis(a,b);
            }
            else
            {
                lines++;
            }
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
          if(i==ds.finduparent(i))
          {
            count++;
          }
        }
        return lines >= count - 1 ? count - 1 : -1;

    }
}