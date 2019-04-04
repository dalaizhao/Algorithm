#include<stdio.h>
#include<stdlib.h>

int minDeletionSize(char** A, int ASize) {
    int j = 0;
    int sum = 0;
    while(*(*(A)+j) != 0){
        for(int i = 1; i < ASize; i++){
            if(*(*(A + i) + j) < *(*(A + i -1) + j)){
                sum++;
                break;
            }
        }
        j++;
    }
    return sum;
}

int main(){
    //char c[3][3] = {'c','b','a','d','a','f','g','h','i'};
    char *c [3] = {"cba","daf","ghi"};
    char **p = NULL;
    p = (char **)malloc(sizeof(char *) *3);
    for(int i=0; i<3;i++){
        p[i]=c[i];
    }
   /* for(int i=0 ;i < 3;i++){
        for (int j=0;j<3;j++){
            printf("%c" , *(*(p+i)+j));
        }
    }*/
    //printf("%ld \n ,%ld\n" , sizeof(char *),sizeof(char));
    printf("%d \n" , minDeletionSize(p , 3));
    free(p);
}
