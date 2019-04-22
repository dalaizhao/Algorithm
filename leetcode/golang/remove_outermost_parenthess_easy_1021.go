package main

import(
    "fmt"
)

func removeOuterParentheses(S string) string {
    var c string
    counter := 0

    for _, v:= range S{
        if v == '('{
            counter++
        }else{
            counter--
        }
        if(counter == 0 && v == ')') || counter ==1 &&v == '('{

        }else{
            c = c+ string(v)
        }
    }
    return c
}

func main(){
    str := "()(()())"

}
