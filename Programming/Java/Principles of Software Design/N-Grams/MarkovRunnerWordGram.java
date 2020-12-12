/**
 * Write a description of class MarkovRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class MarkovRunnerWordGram {
    public void runModel(IMarkovModel markov, String text, int size){ 
        markov.setTraining(text); 
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runModel(IMarkovModel markov, String text, int size, int seed){ 
        markov.setRandom(seed);
        markov.setTraining(text); 
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runMarkov() { 
        FileResource fr = new FileResource(); 
        String st = fr.asString(); 
        st = st.replace('\n', ' ');
        int seed = 139;
        int size = 120;
        MarkovWordOne markovWord = new MarkovWordOne(); 
        runModel(markovWord, st, 120, seed); 
    }
    
    public void runMarkovTwo() { 
        FileResource fr = new FileResource(); 
        String st = fr.asString(); 
        st = st.replace('\n', ' ');
        int seed = 832;
        int size = 120;
        MarkovWordTwo markovWord = new MarkovWordTwo(); 
        runModel(markovWord, st, size, seed); 
    } 

    public void runMarkovWord() { 
        FileResource fr = new FileResource(); 
        String st = fr.asString(); 
        st = st.replace('\n', ' ');
        int seed = 844;
        int size = 120;
        MarkovWord markovWord = new MarkovWord(5); 
        runModel(markovWord, st, 120, seed); 
    }
    
    public void runEfficientMarkovWord() { 
        FileResource fr = new FileResource(); 
        String st = fr.asString(); 
        st = st.replace('\n', ' ');
        int order = 2;
        int seed = 65;
        int size = 120;
        EfficientMarkovWord markovWord = new EfficientMarkovWord(order); 
        runModel(markovWord, st, size, seed); 
        markovWord.printHashMapInfo();
    }
    
    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println(); 
                psize = 0;
            } 
        } 
        System.out.println("\n----------------------------------");
    } 

    public void testMarkovWordOne(){
        String text = "this is just a test yes this is a simple test";
        MarkovWordOne mwOne = new MarkovWordOne();
        runModel(mwOne, text, 200);
    }
    
    public void testHashMap(){
        EfficientMarkovWord emw = new EfficientMarkovWord(2);
        int seed = 42;
        String text = "this is a test yes this is really a test yes a test this is wow";
        int size = 50;
        runModel(emw, text, size, seed);
        emw.printHashMapInfo();
    }
    
    public void compareMethods(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        
        MarkovWord mw = new MarkovWord(2);
        EfficientMarkovWord emw = new EfficientMarkovWord(2);
        int seed = 42;
        int size = 100;
        long markovTime = 0;
        long efficientMarkovTime = 0;
        
        long start= System.nanoTime();
        for(int i = 0; i < 3 ; i++){
            runModel(mw, st, size, seed);
        }
        markovTime = System.nanoTime() - start;

        start = System.nanoTime();
        for(int i = 0; i < 3 ; i++){
            runModel(emw, st, size, seed);
        }
        efficientMarkovTime = System.nanoTime() - start;
        
        System.out.println("MarkovWord time is "+markovTime);
        System.out.println("EfficientMarkovWord time is "+efficientMarkovTime);
    }
}
