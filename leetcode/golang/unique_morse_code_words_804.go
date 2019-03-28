package main

import(
	"fmt"
)

func main(){
	codes := []string{"msg","gin","zen","gig"}
	fmt.Println(uniqueMorseRepresentations(codes))
}

func uniqueMorseRepresentations(words []string) int{
	morse := []string{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."}
	codesMap := map[string]int{}
	for _, word := range words {
		temp := ""
		for _,w := range word{
			temp += morse[rune(w)-97]
		}  
		codesMap[temp] +=1
	}
	return len(codesMap)
}
