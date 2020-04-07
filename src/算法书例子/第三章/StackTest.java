package 算法书例子.第三章;

import org.junit.Test;

import java.util.Stack;

public class StackTest {

    public boolean isLegal(String expression) {
        Stack<Character> stack = new Stack<Character>();
        char[] ch = expression.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char currCh = ch[i];
            switch (currCh) {
                case '(':
                    stack.push('(');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return false;
                    break;
                case '/':
                    if (i < ch.length - 1 && ch[i + 1] == '*') {
                        stack.push('/');
                        stack.push('*');
                    }
                    break;
                case '*':
                    if ((i < ch.length - 1 && ch[i + 1] == '/')
                            && (stack.size() < 2 || (stack.pop() != '*' || stack
                            .pop() != '/'))) {
                        System.out.print("illigal character" + "");
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(isLegal("{()()(){()}}"));
    }

}
