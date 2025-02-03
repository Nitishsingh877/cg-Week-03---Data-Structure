package linearsearch.specificword;

public class SpecificWordFounder {

    public  static String findSentenceContainingWords(String[] sentences, String word){
        for(String sentence: sentences){
            if(sentence.contains(word)){
                return sentence;
            }
        }
        return "Not Found!!!";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "This is the first sentence.",
                "The weather is nice today.",
                "I love programming in Java.",
                "Let's go for a walk in the park."
        };

        String word = "today";

        //method call
        String result = findSentenceContainingWords(sentences,word);
        System.out.println(result);
    }

}
