package main

import (
	"fmt"
)

func main(){
	arr := []int{3,1,2,4}
	fmt.Println(sortArrayByParity(arr))
}

func sortArrayByParity(A []int) []int {
	if len(A) <= 1 {
		return A
	}
	for i := 1; i < len(A); i++ {
		if A[i] % 2 == 0 {
			temp := i
			for j := i-1 ; j>=0 ; j--{
				if A[j] % 2 != 0{
					temp = j
				}
			}
			A[i], A[temp] = A[temp], A[i]
		}
	}
	return A
}
