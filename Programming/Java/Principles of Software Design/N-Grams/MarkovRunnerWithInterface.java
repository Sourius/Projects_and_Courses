
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*; 

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size) {
        markov.setTraining(text);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
            String st= markov.getRandomText(size);
            printOut(st);
        }
    }

    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setRandom(seed);
        markov.setTraining(text);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
            String st= markov.getRandomText(size);
            printOut(st);
        }
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 200;

        MarkovZero mz = new MarkovZero();
        runModel(mz, st, size);

        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size);

        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size);

        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size);

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

    public void testHashMap(){
        int order = 2;
        int seed = 42;
        int size = 50;
        String text = "yes-this-is-a-thin-pretty-pink-thistle";
        
        EfficientMarkovModel mv = new EfficientMarkovModel(2);
        runModel(mv,text, size, seed);
        mv.printHashMapInfo();
    }
    
    public void compareMethods(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        
        MarkovModel mv = new MarkovModel(2);
        EfficientMarkovModel emv = new EfficientMarkovModel(2);
        int seed = 42;
        long markovTime = 0;
        long efficientMarkovTime = 0;
        
        long start= System.nanoTime();
        for(int i = 0; i < 3 ; i++){
            runModel(mv, st, 1000, seed);
        }
        markovTime = System.nanoTime() - start;
        
        start = System.nanoTime();
        for(int i = 0; i < 3 ; i++){
            runModel(emv, st, 1000, seed);
        }
        efficientMarkovTime = System.nanoTime() - start;
        
        System.out.println("Markov time is "+markovTime);
        System.out.println("Efficient markov time is "+efficientMarkovTime);
    }
    
    public void testEfficientMarkovModel(){
        FileResource fr = new FileResource();
        String text = fr.asString();
        text = text.replace('\n', ' ');
        
        EfficientMarkovModel emv = new EfficientMarkovModel(5);
        int seed = 531;
        runModel(emv, text, 1000, seed);
        emv.printHashMapInfo();
    }
}
