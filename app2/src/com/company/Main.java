package com.company;

import lombok.extern.slf4j.Slf4j;

import lombok.Getter;
import java.util.*;

@Getter
public class Main {

    String Name;

    private static int testTryFinally(int a){
        try{
            if(a==1){
                throw new Exception( "ццццц");
            }
            else{
                return a;
            }
        }
        catch(Exception error){
            System.out.println(error);
        }
        finally{
            return 2;
        }
    }

    public static void main(String[] args) {
        //System.out.println(testTryFinally(1));
        //System.out.println(testTryFinally(0));

        Set<Integer> s = new HashSet<>();
        List<Integer> l = new LinkedList<>();
        Iterator i = l.listIterator();

        for(int i=0; i<6; i++){
            l.add(i);
            s.add(i);
        }

        System.out.println(l);
        System.out.println(s);


    }
}
