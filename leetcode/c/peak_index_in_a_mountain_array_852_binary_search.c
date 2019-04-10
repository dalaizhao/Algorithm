#include<stdio.h>

int peakIndexInMountainArray(int* A, int ASize){
    int l = 0;
    int h = ASize;
    while( l < h ){
        int half = (l+h) >> 1;

        if(*(A+half-1) > *(A + half) && *(A + half + 1 ) < *(A + half)){
            h = half;
            continue;
        }
        if( *(A + half -1 ) < *(A +half) && *(A + half +1) > *(A + half) ){
            l = half;
            continue;
        }
        return half;
    }
    return 0;
}
int main(){
    int a[3] = {0,1,0};
    printf("%d \n", peakIndexInMountainArray(a , 3));
}
