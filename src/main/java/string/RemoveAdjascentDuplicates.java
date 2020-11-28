package string;

public class RemoveAdjascentDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("acbbcddc"));
    }

    public static String removeDuplicates(String t) {
        return removeDuplicates(new StringBuilder(t), 1);
    }

    private static String removeDuplicates(StringBuilder sb, int index) {

        if (index >= sb.length()) {
            return sb.toString();
        }

        if ((index - 1) >= 0 && sb.charAt(index - 1) == sb.charAt(index)) {
            removeAdjacent(sb, sb.charAt(index - 1), index - 1);
            index = index - 1;
            return removeDuplicates(sb, index);
        }
        return removeDuplicates(sb, index + 1);
    }

    private static void removeAdjacent(StringBuilder sb, char ch, int index) {

        if (index < 0 || index > sb.length()) {
            return;
        }

        if (sb.length() > 0 && index < sb.length() && sb.charAt(index) == ch) {
            sb.deleteCharAt(index);
            removeAdjacent(sb, ch, index);
        }

        index++;
        // find new adj charecters
        if (index + 1 < sb.length()) {
            if (sb.charAt(index) == sb.charAt(index + 1)) {
                removeAdjacent(sb, sb.charAt(index), index);
            }else {
                removeAdjacent(sb, '\0', index);
            }
        }
    }
}
