package com.example.admin.dailythree;

public class Coding
{

    public static void main(String[] args) {

        fizzBuzz(20);
        System.out.println(isPalindrome("anitalavalatina"));
        System.out.println(reverse("hello"));
<<<<<<< HEAD
        findDuplicates("encyclopedia");
=======
>>>>>>> 3aa0259041be508c9c07810699dd5928f1f2ae4c
    }

    static boolean isPalindrome(String s) {
        int length = s.length();
        if (length < 2) return true;
        else return s.charAt(0) != s.charAt(length - 1) ? false :
                isPalindrome(s.substring(1, length - 1));
    }

    static void fizzBuzz(int number){
        for (int i = 1; i <= number; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println("FizzBuzz");
            }else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(String.valueOf(i));
            }
        }

    }

    static String reverse(String str) {
        if ((str == null) || (str.length() <= 1)) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
<<<<<<< HEAD

    static void findDuplicates(String s){
        String duplicate = "";
        int counter = 0;
        char [] charArray = s.toCharArray();


        for (int i = 0; i < s.length(); i++) {
            for (int j = i +1; j < s.length(); j++) {
                if (charArray[i] == charArray[j]) {
                    counter++;
                    System.out.println(charArray[j] +  " = " + counter);
                    break;
                }

            }
        }
    }
=======
>>>>>>> 3aa0259041be508c9c07810699dd5928f1f2ae4c
}
