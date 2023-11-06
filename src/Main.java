

class Parser {
    // A static method that checks if a given string of brackets is balanced
    static String isBalanced(String s) {
        // Create a stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        // Loop through the characters in the input string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Check if the current character is an opening bracket
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c); // Push it onto the stack
            } else if (c == ')' || c == ']' || c == '}') {
                // Check if the current character is a closing bracket
                if (stack.isEmpty()) {
                    return "false"; // If there is no corresponding opening bracket, it's not balanced
                }
                char top = stack.pop(); // Pop the top bracket from the stack

                // Check if the current closing bracket matches the most recent opening bracket
                if ((c == ')' && top != '(')
                        || (c == ']' && top != '[')
                        || (c == '}' && top != '{')) {
                    return "false"; // If they don't match, it's not balanced
                }
            }
        }

        // After processing all characters, if the stack is empty, it's balanced; otherwise, it's not
        return stack.isEmpty() ? "true" : "false";
    }

    public static void main(String[] args) {
        String input = "{[()]}";
        System.out.println(isBalanced(input)); // Output should be "true"
    }
}
