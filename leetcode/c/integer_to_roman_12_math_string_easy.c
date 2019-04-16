#include<stdio.h>
#include<stdlib.h>

char* intToRoman(int num){
    int ct =0, qt,i,j;
    int nums[7] = {1,5,10,50,100,500,1000};
    char chars[8] = "IVXLCDM";

    char* r = (char*)malloc(sizeof(char)*100);
    char* head = r;
    for(i = 6;i>= 0;i--){
        ct = num /nums[i];
        num %= nums[i];
        if(ct > 0){
            if((nums[i] == 5 || nums[i] == 50 || nums[i] == 500) && num/nums[i-1]*nums[i-1] == nums[i]-nums[i-1]){
                *r++ = chars[i-1];
                *r++ = chars[i+1];
                num = num%nums[--i];
            }else if((nums[i] ==1 || nums[i] == 10 || nums[i] == 100) && ct*nums[i] == nums[i+1] - nums[i]){
                *r++ = chars[i];
                *r++ = chars[i+1];
            }else{
                int j;
                for(j = 0; j< ct;j++){
                    *r++ = chars[i];
                }
            }
        }
    }
    *r = '\0';
    return head;
}

int main(){
    int num = 56;
    printf("%s",intToRoman(num));
}
