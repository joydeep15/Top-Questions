package string;

public class StringRotation {

    public static void main(String[] args) {
        String s1 = "joydeep";
        System.out.println(isRotated("b", "b"));

    }
    public static boolean isRotated(String s1, String s2){

        if (s1 == null ) {
            return false;
        }

        if (s1.length() < 2) {
            return s1.equals(s2);
        }

        String leftRotation = s1.substring(2) + s1.substring(0,2);
        String rightRotation = s1.substring(s1.length()-2) + s1.substring(0, s1.length()-2);


        return leftRotation.equals(s2) || rightRotation.equals(s2);
    }
}
