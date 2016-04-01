import java.util.*;
public class ParenDemo {
	public static void main(String[]args){
		String input = "()()(([[]]))";
		if(args.length > 0){
			input = args[0];
			System.out.println( isMatching(input)); 
		}else{
			System.out.println("Usage:"); 
			System.out.println("java ParenDemo \"text\""); 
		}

	}

	public static boolean isMatching(String input){
		MyStack<Character> openParens = new MyStack<Character>();
		for (char next : input.toCharArray()) {
			if(next == '(' || next == '[' || next == '<' || next == '{'){
				openParens.push(next);
			}
			if(next == ')' || next == ']' || next == '>' || next == '}'){
				try{
					char should = getMatch(next);
					if (openParens.pop() != should) {
						System.out.println("Mismatch");
						return false;
					}
				}catch (Exception e) {
					//tried to pop with nothing in the stack. or tried to close without an open
					System.out.println("Tried to close without an open");
					return false;
				}

			}
		}
		return openParens.isEmpty();
	}

	public static char getMatch(char c){
		char match = 0;
		if (c == '}') {
			match = '{';
		}if (c == '>') {
			match = '<';
		}if (c == ']') {
			match = '[';
		}if (c == ')') {
			match = '(';
		}
		return match;
	}
}