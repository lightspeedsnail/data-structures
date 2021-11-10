package com.company;

import java.util.Arrays;

public class segmenttree
{
    int[] vals;
    int n ;
    int[] tree;
    public void constructSegment(int[] tree) {
        n = tree.length;
        this.tree = tree;
        int size = (int) Math.ceil(Math.log(n)/ Math.log(2));
        size = 2*(int) Math.pow(2 , size)-1;
        vals = new int[size];
        populate(0,n-1,tree,0);
        System.out.println(Arrays.toString(vals));
    }
    private int populate( int l , int r , int[] parentvals , int valp) {
        if(l == r) {
            vals[valp] = parentvals[l];
            System.out.println(vals[valp]+"  "+l+" \n ");
            return vals[valp];
        }
        int mid = l+(r-l)/2;
        vals[valp] = populate(l , mid , parentvals, valp*2+1)+populate(mid+1 , r, parentvals, valp*2+2);
        return vals[valp];
    }
    public int gets(int start , int end) {
        return getsum(0 , start , end , 0 , n-1 );
    }
    private int getsum(int po , int ml , int mr , int l, int r) {
        if(ml <= l && mr >= r) {
            return vals[po];
        }
        if( r < ml || l > mr) { // no over lap
            return 0;
        }
        int mid = l+(r-l)/2;
        return getsum((po*2)+1,ml , mr , l , mid)+getsum((po*2)+2,ml , mr , mid+1 , r);
    }
    public void update(int val , int index) {
        int diff = val - tree[index];
        updte(diff , index , 0 , n-1 , 0);

    }
    private void updte(int val , int index , int sl , int sr , int pos)
    {
        if(sl > index || sr < index)
        {
            return;
        }
        vals[pos] += val;
        if(sl != sr)
        {
            int mid = sl+ ( sr-sl )/2;
            updte(val , index , sl , mid , 2*pos+1);
            updte(val , index , mid+1 , sr , 2*pos+2);
        }
    }
}
