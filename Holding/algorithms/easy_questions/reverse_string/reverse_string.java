package algorithms.easy_questions.reverse_string;

public class reverse_string {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            i++;
            j--;
        }
    }    
}

class test {
    public static void main(String[] args) {
        reverse_string obj = new reverse_string();
        
        // Example 1
        char[] s1 = {'h','e','l','l','o'};
        obj.reverseString(s1);
        System.out.println(s1);

        // Example 2
        char[] s2 = {'G','e','o','r','g','e'};
        obj.reverseString(s2);
        System.out.println(s2);
    }
}