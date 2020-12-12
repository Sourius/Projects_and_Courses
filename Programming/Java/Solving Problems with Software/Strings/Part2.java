
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    private String dna[] = {
        "gtcgttgtattctgaccgtgggttgatcttgccacagctgcttaagcccttggtccgctcctaaaccgttttgcatacgaagccagtagccttggtacca",
        "tactacttaggcttctatgtattgagctatttcacttttcctccagtggtcactagtggggcggccgtggcgacgcgttggtgggctctcaagacttgtg",
        "tgggcacgaagctgggatgagttaggacagtccctgcctcattcagaactaatccagacaggcctactgttctcttgaagtttatcatttcccgagatag",
        "aggaaccaaaatgcgccaagatcgatgctttctactaaccctagattattggagcgcctacccgataggcacaaaatccctaatcgtatcggtgtacacg",
        "ATGGGTTAAGTC"
    };
    public String createDNAString(int n){
        return dna[n];
    }
    public boolean isValidGene(String gene){
        return gene.length() % 3 == 0;
    }
    public String findSimpleGene(String dna, String startCodon, String endCodon){
        String gene = "";
        String lowerCaseDNA = dna.toLowerCase();
        int startIndex, endIndex;
        
        //find index of ATG
        startIndex = lowerCaseDNA.indexOf(startCodon.toLowerCase());
        //if there is ATG 
        if(startIndex != -1){
            // find index of TAA
            endIndex = lowerCaseDNA.indexOf(endCodon.toLowerCase(), startIndex+3); 
            // if there is TAA return the string between ATG and TAA
            if(endIndex != -1){
                gene = dna.substring(startIndex, endIndex+3);
                if(!isValidGene(gene)){
                    return "";
                }
            }
        }
        return gene;   
    }
    public void testSimpleGene(){
        String dna;
        for(int i = 0; i < 5; i++){
            dna = createDNAString(i);
            System.out.println("Dna string: "+dna);
            System.out.println("Gene: "+findSimpleGene(dna,"atg","taa"));
        }
    }
}
