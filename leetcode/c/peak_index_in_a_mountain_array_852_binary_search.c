#include<stdio.h>

int peakIndexInMountainArray(int* A, int ASize){
    int l = 0;
    int h = ASize;
    while(l<=h){
        int half = (l+h)/2;
        if(*(A+l) < *(A+half)){

        }
    }
}

int main(){
    int a[3] = {0,1,0};
    printf("%d \n", peakIndexInMountainArray(a , 3));
}
