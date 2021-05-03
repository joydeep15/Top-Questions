package string;

import org.junit.Assert;
import org.junit.Test;

public class Palindrome {

    @Test
    public void isPalindTest(){

        String a = "A man, a plan, a canal: Panama";
        Assert.assertTrue(isPalindrome(a));

    }

    public boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length()-1;

        while(start <= end){

            if(!isAlphanumeric(s.charAt(start))){
                start++;
            }else if(!isAlphanumeric(s.charAt(end))){
                end--;
            }else if( Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)) ){
                return false;
            }
            start++;
            end--;

        }

        return true;
    }

    public boolean isAlphanumeric(Character c){

        if(c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'){
            return true;
        }

        return false;

    }

}
