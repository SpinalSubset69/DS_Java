package Stack;

public class App {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        stack.Push(3);
        stack.Push(2);
        stack.Push(1);
        stack.Push(6);
        stack.Push(8);

        stack.ShowStack();

        stack.Pop();
        System.out.println("\nStack after Pop();");
        stack.ShowStack();

        System.out.println("\nPeek of Stack: " + stack.Peek());
    }
}
