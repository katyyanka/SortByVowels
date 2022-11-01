import java.util.*;
public class SortByVowels {
    final static String ENGLISH_VOWELS = "euioa";
    final static String RUSSIAN_VOWELS = "еыаоэяию";

    public static void main(String[] args) {
        TreeSet<WordWithNumberOfVowels> wordWithNumberOfVowelsTreeSet = new TreeSet<>();
        String sentence = "asad aadfg yathg g raaaadgf";
        List<String> words = Arrays.stream(sentence.split(" ")).toList();
        System.out.println(words);
        for (String word: words) {
            wordWithNumberOfVowelsTreeSet.add(new WordWithNumberOfVowels(countVowels(word),word));
        }
        System.out.println(wordWithNumberOfVowelsTreeSet);
    }
    static class WordWithNumberOfVowels implements Comparable<WordWithNumberOfVowels>{
        int numberOfVowels;
        String word;
        public WordWithNumberOfVowels(int numberOfVowels, String word) {
            this.numberOfVowels = numberOfVowels;
            this.word = word;
        }

        @Override
        public String toString() {
            return "{" + numberOfVowels +
                    "," + word + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WordWithNumberOfVowels that = (WordWithNumberOfVowels) o;
            return numberOfVowels == that.numberOfVowels && Objects.equals(word, that.word);
        }

        @Override
        public int hashCode() {
            return Objects.hash(numberOfVowels, word);
        }

        @Override
        public int compareTo(WordWithNumberOfVowels o) {
            if (this.equals(o)) {
                return 0;
            }
            else if (this.numberOfVowels == o.numberOfVowels) {
                return -1;
            }
            return Integer.compare(this.numberOfVowels, o.numberOfVowels);
        }
    }
    static int countVowels(String word){
        int result = 0;
        char[] letters = word.toLowerCase().toCharArray();

        for (Character letter:letters) {
            if (ENGLISH_VOWELS.contains(letter.toString()) || RUSSIAN_VOWELS.contains(letter.toString())) {
                result++;
            }
        }
        return result;
    }
}
