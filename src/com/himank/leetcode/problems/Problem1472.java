package com.himank.leetcode.problems;

import java.util.Stack;

public class Problem1472 {

    Stack<String> history;
    Stack<String> forward;

    public static void main(String[] args) {
//        Problem1472 browsingHistory = new Problem1472("leetcode.com");
//        browsingHistory.visit("google.com");                                // You are in "leetcode.com". Visit "google.com"
//        browsingHistory.visit("facebook.com");                              // You are in "google.com". Visit "facebook.com"
//        browsingHistory.visit("youtube.com");                               // You are in "facebook.com". Visit "youtube.com"
//        System.out.println("Back: " + browsingHistory.back(1));           // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
//        System.out.println("Back: " + browsingHistory.back(1));           // You are in "facebook.com", move back to "google.com" return "google.com"
//        System.out.println("Forward: " + browsingHistory.forward(1));     // You are in "google.com", move forward to "facebook.com" return "facebook.com"
//        browsingHistory.visit("linkedin.com");                              // You are in "facebook.com". Visit "linkedin.com"
//        System.out.println("Forward 2: " + browsingHistory.forward(2));   // You are in "linkedin.com", you cannot move forward any steps.
//        System.out.println("Back 2: " + browsingHistory.back(2));         // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
//        System.out.println("Back 7: " + browsingHistory.back(7));         // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"

        Problem1472 browsingHistory = new Problem1472("zav.com");
        browsingHistory.visit("kni.com");
        System.out.println("Back 7:" + browsingHistory.back(7));
        System.out.println("Back 7:" + browsingHistory.back(7));
        System.out.println("Forward 5:" + browsingHistory.forward(5));
        System.out.println("Forward 1:" + browsingHistory.forward(1));
        browsingHistory.visit("pwrrbnw.com");
        browsingHistory.visit("mosohif.com");
        System.out.println("Back 9:" + browsingHistory.back(9));



    }

    public Problem1472(String homepage) {
        history = new Stack<>();
        forward = new Stack<>();
        history.push(homepage);
    }

    public void visit(String url) {
        history.push(url);
        forward.removeAllElements();
    }

    public String back(int steps) {
        while (steps > 0 && history.size() > 1) {
            forward.push(history.pop());
            steps--;
        }
        return history.peek();
    }

    public String forward(int steps) {
        String url = history.peek();
        while (steps > 0 && forward.size() >= 1) {
            url = forward.pop();
            history.push(url);
            steps--;
        }
        return url;
    }
}
