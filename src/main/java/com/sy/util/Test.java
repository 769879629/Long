package com.sy.util;

public class Test {

    public static void main(String[] args) {

        Integer i =1;
        changeInteger(i);
        System.out.println(i);



        String str = "s1";
        changeString(str);
        System.out.println(str);

        StringBuilder sb = new StringBuilder("1");
        changeStringBuilder(sb);
        System.out.println(sb);

        changeStringBuilder2(sb);
        System.out.println(sb);



    }
    public static void changeInteger(int i){
        i=2;

    }
    public static void changeString(String str){
        str="s2";
    }

    public static void changeStringBuilder(StringBuilder sb){
        sb.append("2");
    }
    public static void changeStringBuilder2(StringBuilder sb){
        sb=new StringBuilder();
        sb.append("2");
    }
}
