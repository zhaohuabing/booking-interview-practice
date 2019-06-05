package com.zhaohuabing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Write a function to test if the given set of brackets are balanced or not. e.g. {{}}{)([][]
 * 
<p>Algorithm:<br>
1) Declare a character stack S.<br>
2) Now traverse the expression string exp.<br>
a) If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.<br>
b) If the current character is a closing bracket (‘)’ or ‘}’ or ‘]‘) then pop from stack and if the popped character is the matching starting bracket then fine else parenthesis are not balanced.<br>
3) After complete traversal, if there is some starting bracket left in stack then “not balanced”<br><br><br>
Time Complexity: O(n)<br>
Space: O(n) for stack.</p>
 */
public class BracketMatch {
    public static boolean isMatch(String s) {
        char[] bracketStarts = new char[] {'[', '{', '(', '<'};
        char[] bracketEndings = new char[] {']', '}', ')', '>'};

        Set<Character> bracketStartSet = new HashSet<Character>();
        for (int i = 0; i < bracketStarts.length; i++) {
            bracketStartSet.add(bracketStarts[i]);
        }

        Set<Character> bracketEndSet = new HashSet<Character>();
        for (int i = 0; i < bracketEndings.length; i++) {
            bracketEndSet.add(bracketEndings[i]);
        }

        Map<Character, Character> bracketMap = new HashMap<Character, Character>();
        for (int i = 0; i < bracketStarts.length; i++) {
            bracketMap.put(bracketStarts[i], bracketEndings[i]);
        }

        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (bracketStartSet.contains(chars[i])) {
                stack.push(chars[i]);
            } else if (bracketEndSet.contains(chars[i])) {
                char start = stack.pop();
                if (bracketMap.get(start) != chars[i]) {
                    return false;
                }
            }
        }

        if (stack.size() > 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(BracketMatch.isMatch("(((({}))))"));
        System.out.println(BracketMatch.isMatch("((((sdfasdfafda{}))))"));
        System.out.println(BracketMatch.isMatch("((((sdfasdfafda{})))])"));
        System.out.println(BracketMatch.isMatch("((((sdfasdfafda{})))"));
    }
}
