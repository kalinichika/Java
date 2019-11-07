package com.company;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Integer> l = new LinkedList<>();
        for(int i=0; i<9; i++){
            l.add(i);
        }


        Iterator<Integer> iter1 = l.iterator();
        Iterator<Integer> iter2 = l.iterator();
        while(iter2.hasNext()){
                iter1.next();
            if(iter2.hasNext()) {
                iter2.next();
            }
            if(iter2.hasNext()) {
                iter2.next();
            }
        }
        System.out.println(iter1.next()-1);
    }
}
