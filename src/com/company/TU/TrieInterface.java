package com.company.TU;

public class TrieInterface {
    public static void main(String[] args) {
       /* Trie trie = new Trie();
        String keys[] = {"the", "a", "there",
                "answer", "any", "by",
                "bye", "their"};
        for (int i = 0; i <keys.length ; i++) {
            trie.insert(keys[i]);
        }
        check(trie,keys);
        trie.remove("there");
        check(trie,keys);*/
    }

    static void check(Trie trie,String[] keys){
        for (int i = 0; i <keys.length ; i++) {
            if(trie.search(keys[i])){
                System.out.println(i + " "+ "found");
            }else{
                System.out.println(i + " "+ "not found");
            }
        }
    }
}
