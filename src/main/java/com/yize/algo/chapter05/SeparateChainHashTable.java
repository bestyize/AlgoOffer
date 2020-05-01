package com.yize.algo.chapter05;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.LinkedList;
import java.util.List;

/**
 * 散列表的实现常常也叫做散列(hashing)。散列是一种用于以常数平均时间执行插入，
 * 删除和查找的技术。但是任何需要排序信息的操作都不会被支持
 * ***************************************************************************************************************
 * 理想的散列表式一个包含一些项的具有固定大小的数组。查找操作通常是对项的某个部分（即数据域进行的）
 * 这部分就叫做关键字(key)。例如项可以由一个一个串（它作为关键字）和其他的一些数据域组成，我们把表的大小
 * 记作tablesize,并将其理解为散列数据结构的一部分，而不仅仅式浮动于全局的某个变量。通常习惯的让表从0到tablesize-1变化。
 * 每个关键字被映射到[0,TableSize-1]区间中的某个数，并被放置到适当的单元。这个映射就叫做散列函数，
 * 理想情况下它应该计算简单，并且应该保证任何两个不同的关键字映射到不同的单元，不过这是不可能的，因为单元的数目是有限的
 * 而关键字是用不完的，因此我们寻找一个散列函数，该函数要在单元之间均匀的分配关键字
 ******************************************************************************************************************
 * 如果当一个元素被插入时与一个已经插入的元素散列到相同的值，那么就产生一个冲突，解决冲突的方法有几种：
 * 分离链接法和开放定址法。
 * 分离链接法：
 *      其做法时将散列到同一个值的所有元素保留到一个表中
 *      为了执行依次查找，我们采用散列函数来确定究竟遍历哪个链表。然后我们在被确定的链表中执行一次查找
 *      为了执行insert，我们检查相应的链表看看该元素是否位于适当的位置（如果允许插入重复元，那么通常要留出一个额外的域）
 *      如果这个元素是一个新元素，那么它将被插入到链表的前端，这不仅仅是因为方便，还因为新插入的元素最有可能不久被访问
 *******************************************************************************************************************
 **/
public class SeparateChainHashTable<T> {
    private static final int DEFAULT_TABLE_SIZE=101;
    private List<T>[] theLists;
    private int currentSize;

    public SeparateChainHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }
    public SeparateChainHashTable(int size) {
        theLists=new LinkedList[nextPrime(size)];
        for(int i=0;i<theLists.length;i++){
            theLists[i]=new LinkedList<>();
        }
    }

    public void insert(T x){
        List<T> partList=theLists[myhash(x)];
        if(!partList.contains(x)){
            partList.add(x);
            if(++currentSize>theLists.length){
                rehash();
            }
        }
    }

    public void remove(T x){
        List<T> partList=theLists[myhash(x)];
        if(partList.contains(x)){
           partList.remove(x);
           currentSize--;
        }
    }

    public boolean contains(T x){
        List<T> partList=theLists[myhash(x)];
        return partList.contains(x);
    }

    public void makeEmpty(){
        for(int i=0;i<theLists.length;i++){
            theLists[i].clear();
        }
        currentSize=0;
    }

    private int myhash(T x){
        int hashVal=x.hashCode();
        hashVal%=theLists.length;
        if(hashVal<0){
            hashVal+=theLists.length;
        }
        return hashVal;
    }

    private void rehash(){
        List<T>[] oldList=theLists;
        theLists=new List[nextPrime(2*theLists.length)];
        for(int i=0;i<theLists.length;i++){
            theLists[i]=new LinkedList<>();
        }
        currentSize=0;
        for(int i=0;i<oldList.length;i++){
            for(T item:oldList[i]){
                insert(item);
            }
        }
    }


    private static int nextPrime(int n){
        return 0;
    }

    private static boolean isPrime(int n){
        return true;
    }
}
