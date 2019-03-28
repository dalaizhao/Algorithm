package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println("vim-go")
	arr := []string{"test.email+alex@leetcode.com","test.e.maob.cathy@lecode.com","testemail+david@lee.tcode.com"}
	ret := numUniqueEmails(arr)
	fmt.Println(ret)
}

func numUniqueEmails(emails []string) int {
	seen := make(map[string]bool)

	for _, email := range emails{
		comp := strings.Split(email, "@")
		comp[0] = strings.Replace(comp[0], ".", "" ,-1)
		comp[0] = strings.Split(comp[0], "+")[0]
		seen[strings.Join(comp, "")] =true
	}
	return len(seen)
}
