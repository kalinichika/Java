package com.company;

import java.util.*;

class CommonOfTwoList {
    private List<Integer> _l1;
    private List<Integer> _l2;

    public CommonOfTwoList(List<Integer> l1, List<Integer> l2) {
        _l1 = new ArrayList<Integer>(l1);
        _l2 = new ArrayList<Integer>(l2);
    }

    public void InitLists() {
        this._l1.add(10);
        this._l1.add(11);
        this._l1.add(12);
        this._l1.add(13);

        this._l2.add(16);
        this._l2.add(17);
        this._l2.add(18);

        for(int i = 0; i < 5; ++i) {
            this._l1.add(i);
            this._l2.add(i);
        }

    }

    public int searchCommonElement1() {
        ListIterator iter1 = this._l1.listIterator();

        while(iter1.hasNext()) {
            Integer i = (Integer)iter1.next();
            ListIterator iter2 = this._l2.listIterator();

            while(iter2.hasNext()) {
                if (i == iter2.next()) {
                    return iter2.previousIndex();
                }
            }
        }

        return -1;
    }

    public int searchCommonElement2() {
        int result = -1;
        Set<Integer> set1 = new HashSet(this._l1);
        ListIterator<Integer> iter2 = this._l2.listIterator();
        int i = -1;

        while(iter2.hasNext()) {
            ++i;
            if (set1.contains(iter2.next())) {
                result = i;
                break;
            }
        }

        return result;
    }

    public int searchCommonElement3() {
        int sizeDiff = this._l1.size() - this._l2.size();
        int absSizeDiff = Math.abs(this._l1.size() - this._l2.size());
        return sizeDiff > 0 ? this._searchCommonElement3(this._l1.listIterator(absSizeDiff), this._l2.listIterator()) : absSizeDiff + this._searchCommonElement3(this._l1.listIterator(), this._l2.listIterator(absSizeDiff));
    }

    public int _searchCommonElement3(ListIterator<Integer> iter1, ListIterator<Integer> iter2) {
        int result = -1;
        int i = -1;

        while(iter1.hasNext() && iter2.hasNext()) {
            ++i;
            if (iter1.next() == iter2.next()) {
                result = i;
                break;
            }
        }

        return result;
    }

    public static void main(java.lang.String[] args) {

        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();

        CommonOfTwoList test = new CommonOfTwoList(l1,l2);
        test.InitLists();

        System.out.print("search_1 (simple method) = ");
        System.out.println(test.searchCommonElement1());

        System.out.print("search_2 (with hash_set) = ");
        System.out.println(test.searchCommonElement2());

        System.out.print("search_3 (with length)   = ");
        System.out.println(test.searchCommonElement3());
    }
}

