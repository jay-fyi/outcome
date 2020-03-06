package outco.outcome.question.request_question;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 * Given a dictionary and an input src string, check if the input string can be formed as a
 * concatenation of the strings in the dictionary.
 *
 * For example, given the dictionary {"cat", "dog"}, check if the input "catdog" can be formed with the concatenation
 * of the words on the dictionary.


 Assumptions:
 - The dict words are unique.
 - you don’t have to use every single words to form the target
 - you might use the same word multiple times to form the target.


 The idea is to use:
 1. Two pointers technique
 2. When we find the current window's string that match a word in dict, then make a recursion call to check is that a possible way to form the target.

 */
class DictToFromTargetStr {

    private static Set<String> dictionary;

    public static boolean canConcatenateWords(Set<String> dict, String target) {
        if (target == null || target.isEmpty()) {
            return true;
        }
        dictionary = dict;
        return helper(target);
    }

    private static boolean helper(String target) {

        int startIdx = 0;
        int endIdx = 0;

        while(endIdx < target.length()){
            // expend the win
            endIdx++;

            // find the cur string from the startIdx that match a word in dict and make a recursion call.
            int tempEndIdx = endIdx;
            boolean isFound = false;
            while(tempEndIdx <= target.length()) {
                // check is the current word in the dict
                String curWinStr = target.substring(startIdx, tempEndIdx);
                if (dictionary.contains(curWinStr)) {
                    isFound = true;
                    if(helper(target.substring(tempEndIdx))){
                        return true;
                    }
                }
                tempEndIdx++;
            }

            if(!isFound){ // found nothing that match the word in dict
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Testing using the shortest str
        System.out.println(canConcatenateWords(new HashSet<>(Arrays.asList("aa","aaa","ab")), "aaab")); //true
        // Testing using the longest str
        System.out.println(canConcatenateWords(new HashSet<>(Arrays.asList("aa","aaa","b")), "aaab")); //true
        // Testing using the mid len str
        System.out.println(canConcatenateWords(new HashSet<>(Arrays.asList("aaa","aaaaa", "aaaaaaa", "b")), "aaaaab")); //true
        // Simple case
        System.out.println(canConcatenateWords(new HashSet<>(Arrays.asList("cat","dog")), "catdog")); //true
        // reverse match
        System.out.println(canConcatenateWords(new HashSet<>(Arrays.asList("cat","dog")), "dogcat")); //true
        // repeated match
        System.out.println(canConcatenateWords(new HashSet<>(Arrays.asList("cat","dog")), "dogcatcatdog")); //true

        // Not matching
        // Testing overlapped word
        System.out.println(canConcatenateWords(new HashSet<>(Arrays.asList("cat","tog")), "catog")); //false
        System.out.println(canConcatenateWords(new HashSet<>(Arrays.asList("cat","tog")), "ca")); //false
        System.out.println(canConcatenateWords(new HashSet<>(Arrays.asList("cat","dog")), "dog&cat")); //false
        System.out.println(canConcatenateWords(new HashSet<>(Arrays.asList("cat","dog", "and", "a", "parrot", "horse")), "ahorsedogsandacatandaparrot")); //false
    }

}
