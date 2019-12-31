
public class Palindrome {
    /**
     * convert a string to deque with same order of the string
     * @param word: input string
     * @return deque: deque with each character in the string
     */
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    /**
     * if the given word is a palindrome
     * @param word: input string
     * @return true if the word palindrome, false if the word is not palindrome
     */
    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        int index = word.length() / 2;  //number of times to check if two ends have equal character
        return isPalindromeHelper(deque, index);
    }

    /**
     * helper to isPalindrome method
     * @param deque: input string deque
     * @param index: number of times to check first and last character
     * @return true if the word palindrome, false if the word is not palindrome
     */
    private boolean isPalindromeHelper(Deque<Character> deque, int index) {
        //out of character to compare, left only one or zero character
        if (index == 0) {
            return true;
        }
        Character a = deque.removeFirst();  //get character from front
        Character b = deque.removeLast();   //get character from end

        if (a.equals(b)) {
            return isPalindromeHelper(deque, index - 1);
        } else {
            return false;
        }
    }

    /**
     * generalized isPalindrome according to the CharacterComparator
     * @param word: input word for test
     * @param cc: character comparator
     * @return true if the word palindrome, false if the word is not palindrome
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);
        int index = word.length() / 2;
        while (index != 0) {
            Character a = deque.removeFirst();
            Character b = deque.removeLast();
            if (!cc.equalChars(a, b)) {
                return false;
            }
            index--;
        }
        return true;
    }

}
