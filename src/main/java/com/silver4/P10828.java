package com.silver4;

import java.io.*;
import java.util.StringTokenizer;

public class P10828 {
    static MyStack stack;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        stack = new MyStack(len);
        for (int i = 0 ; i < len ; i++) operateInStack(br.readLine());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void operateInStack(String op) {
        StringTokenizer st = new StringTokenizer(op);
        op = st.nextToken();
        if (op.contains("push")) {
            stack.push(Integer.parseInt(st.nextToken()));
            return;
        }

        switch (op) {
            case "pop":
                sb.append(stack.pop()).append("\n");
                break;
            case "empty":
                sb.append(stack.empty()).append("\n");
                break;
            case "size":
                sb.append(stack.size()).append("\n");
                break;
            case "top":
                sb.append(stack.top()).append("\n");
                break;
        }
    }

    static class MyStack {
        private final int[] elements;
        int pointer;
        MyStack(int capacity) {
            elements = new int[capacity];
            pointer = 0;
        }

        void push(int num) {
            elements[pointer++] = num;
        }

        int pop() {
            int ret;
            if (pointer == 0) {
                ret = empty() == 1 ? -1 : elements[pointer];
            } else {
                ret = elements[--pointer];
            }
            elements[pointer] = 0;
            return ret;
        }

        int top() {
            if (pointer == 0) {
                return empty() == 1 ? -1 : elements[pointer];
            }
            return elements[pointer - 1];
        }

        int empty() {
            return pointer == 0 && elements[pointer] == 0 ? 1 : 0;
        }

        int size() {
            int cnt = 0;
            for (int element : elements) {
                if (element == 0) break;
                cnt++;
            }
            return cnt;
        }
    }
}
