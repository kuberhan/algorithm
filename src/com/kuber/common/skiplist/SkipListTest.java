package com.kuber.common.skiplist;

import org.junit.Test;

public class SkipListTest {

    @Test
    public void test1(){
        SkipList<String> list = new SkipList<>();
        System.out.println(list);
        System.out.println("添加数据：");
        list.put(6, "！！！");
        list.put(1, "Ni Wenhan");
        list.put(2, "make");
        list.put(3, "SkipList");
        list.put(1, "kuber");
        list.put(4, "come true");
        list.put(5, "successfully");
        System.out.println("遍历表：");
        System.out.println(list);
        System.out.println("表长为："+list.size());
    }
}
