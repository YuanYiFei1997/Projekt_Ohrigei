package edu.dlufl.ohrigei.util

class RandomUtil {
    static int getNumber(int n){
        if(n<1){
            n=1;
        }
        if(n==1){
            return 1
        }
        else {
            n=n-1
            return 10*getNumber(n)
        }
    }
    static int getRandom(int x,int y){
        int random = (int)(Math.random()*(y-x))+x
        return random
    }
    static int getRandom(int length){
        int m = getNumber(length)
        int n = m*10-1;
        def random=(int)(Math.random()*(n-m))+m
        return random
    }
}
