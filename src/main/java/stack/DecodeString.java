package stack;


import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {

        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("3[a2[c]]"));
    }

        public String decodeString(String s) {

            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s.length(); i++){

                Character curr = s.charAt(i);
                if(curr.equals(']')){

                    StringBuilder sb = new StringBuilder();
                    while(!stack.peek().equals('[')){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    sb = sb.reverse();
                    //construct the integer
                    StringBuilder multiplier = new StringBuilder();
                    while((stack.peek() - '0') >= 0 &&
                            (stack.peek() - '0') <= 9){

                        multiplier.append(stack.pop());

                    }
                    multiplier = multiplier.reverse();

                    String res = mult(Integer.parseInt(multiplier.toString()),
                            sb.toString());
                    for(int j = 0; j < res.length(); j++){
                        stack.push(res.charAt(j));
                    }
                    continue;
                }

                stack.push(curr);
            }

            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }

            return sb.reverse().toString();


        }

        public String mult(int times, String str){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i < times; i++){
                sb.append(str);
            }

            return sb.toString();
        }



}
