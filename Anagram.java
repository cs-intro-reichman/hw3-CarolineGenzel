import java.util.Random;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
        str2 = preProcess(str2);
        int count1=0;
		int count2=0;
		for(int i=0;i< str1.length();i++){
			if (str2.indexOf(str1.charAt(i))!= -1) {
				count1++;
		
			}
		}
		for(int i=0;i< str2.length();i++){
			if (str1.indexOf(str2.charAt(i))!= -1) {
				count2++;
			}
		}
		
           
        return (count1==str1.length() && count2 ==str2.length());
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		
		String wordEnd="";
		for (int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			if ((current >= 'A' && current <= 'Z') || (current >= 'a' && current <= 'z') || current== ' ' ) {
				wordEnd += current;
			}
		}
		return wordEnd.toLowerCase();
	}
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String s = preProcess(str);
        String result = "";
        String temp="";
        int length = s.length();
        for (int i=0; i<length; i++){
            int index = new Random().nextInt(s.length());
         temp += s.charAt(index);
         s = s.substring(0, index) + s.substring(index+1);
         result += temp;
         temp = "";
        }
        return result;
	}
}