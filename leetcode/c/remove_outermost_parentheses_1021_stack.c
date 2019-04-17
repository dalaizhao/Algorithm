#include<stdio.h>
#include<stdlib.h>

char* removeOuterParenthess(char* S){
    if(S == NULL) return S;
    char* stack = (char*)calloc(1000,sizeof(char));
    char* head = (char*)calloc(1000,sizeof(char));

    char* r = head;
    int idx = 0;
    while(*S != '\0'){
        if(*S == '(' && *(stack + idx) == 0){
            *(stack+idx) = *S;
            idx++;
            S++;
        }else if(*S == ')' && *(stack + idx -1) == '('){
            S++;
            idx--;
        }else{
            *r++ = *S;
        }
    }
    r = '\0';
    return head;
}

int main(){
    char chars[11] = "(()())(())";
    printf("%s",removeOuterParenthess(chars));
}
