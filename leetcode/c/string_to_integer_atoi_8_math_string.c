#include<stdio.h>
#include<limits.h>

int myAtoi(char* str){
    /*int flag = 1;
      long res = 0;

      if(str == NULL) return 0;
      while(*str == ' ' || *str == '\t') ++str;
      if(*str != '-' && *str != '+' && (*str < '0' || *str > '9')) return 0;
      if(*str == '-'){
      flag = -1;
      ++str;
      }else if(*str == '+'){
      flag = 1;
      ++str;
      }

      if(str == NULL) return 0;

      int cnt =0;
      while(*str){
      if(*str < '0' || *str > '9'){
      break;
      }
      res = res * 10 + *str - 0x30;
      ++str;
      ++cnt;
      }

      if(cnt > 10) return flag == 1 ? INT_MAX : INT_MIN;

      res *= flag;
      if(res > INT_MAX) return INT_MAX;
      if(res < INT_MIN) return INT_MIN;

      return (int)res;*/
    char* p = str;
    while (*p != '\0' && *p == ' ') ++p;

    int sign = 1;
    if (*p == '-') {
        ++p;
        sign = -1;
    } else if (*p == '+') {
        ++p;
    }

    int res = 0;
    while (*p != '\0') {
        if (*p < '0' || *p > '9') break;

        int d = *p - '0';
        // check overflow
        if (res > (INT_MAX-d)/10) return sign > 0 ? INT_MAX : INT_MIN;

        res = res*10 + d;
        ++p;
    }
    return sign*res;
}

int main(){
    char str[] = " -123 fd";
    printf("%d \n",myAtoi(str));
}
