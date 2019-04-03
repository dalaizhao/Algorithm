#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int* diStringMatch(char* S, int* returnSize){
    int len = strlen(S);
    int* ans = malloc((len+1)*sizeof(int));

    int* p =ans;
    int l = 0;
    int h = len;

    for(int i=0;i<len;++i,++p){
        if(S[i] == 'I') *p = l++;
        else *p = h--;
    }
    *p = l;

    *returnSize = len +1;

    return ans;
}

int main(){
    char s[4] ={'I','D','I','D'};
    int ret;
    int *p;
    p = diStringMatch(s,&ret);

    for(int i=0,len=sizeof(*p);i<len;i++){
        printf("p[%d] = %d \n",i,*(p+i));
    }
}
