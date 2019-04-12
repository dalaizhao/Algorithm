#include<stdio.h>

int getSum(int a, int b){
    /*int c = 0;
    while(b != 0){
        c = ((a & b)<<1);
        a ^= b;
        b = c;
    }
    return a;*/
    return&a[(char*)b];
}

int main(){
    int a = -1;
    int b = -2;
    printf("%d \n",getSum(a,b));
}
