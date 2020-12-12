public class WordGram {
    private String[] myWords;
    private int myHash;

    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        return myWords.length;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < myWords.length; i++ ){
            sb.append(myWords[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if((o == null) || !(o instanceof WordGram))return false;
        WordGram wg = (WordGram) o;
        if(length() != wg.length()) return false;
        for(int i = 0; i < myWords.length; i++){
            if(!(myWords[i].equalsIgnoreCase(wg.wordAt(i)))) return false;
        }
        return true;
    }

    public WordGram shiftAdd(String word) { 
        String[] words = new String[length()];
        for(int i = 1; i < myWords.length; i++){
            words[i-1] = myWords[i];
        }
        words[myWords.length-1] = word;
        WordGram out =  new WordGram(words, 0, myWords.length);
        return out;
    }
    
    public int hashCode(){
        return toString().hashCode();
    }
}