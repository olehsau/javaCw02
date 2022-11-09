import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class Imiona {
    public static String[] getAllNames() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/resources/imiona.txt"));
        // counting number of names first
        int n=0;
        while (reader.readLine() != null){
            n++;
        }
        String[] names = new String[n];
        String line;
        int i=0;
        reader = new BufferedReader(new FileReader("src/resources/imiona.txt"));
        while((line=reader.readLine()) != null){
            names[i] = line;
            i++;
        }
        return names;
    }

    public static void printNumberOfNamesForEveryFirstLetter() throws IOException {
        String[] names = Imiona.getAllNames();
        HashMap<Character,Integer> firstLetterAndCount = new HashMap<Character,Integer>();
        for (int i=0; i<names.length; i++){
            if(firstLetterAndCount.get(names[i].charAt(0))==null){
                firstLetterAndCount.put(names[i].charAt(0),1);
            }
            else {
                firstLetterAndCount.put(names[i].charAt(0),firstLetterAndCount.get(names[i].charAt(0))+1);
            }
        }
        firstLetterAndCount.forEach((key,value)-> System.out.println(key+": "+firstLetterAndCount.get(key)));
    }

    public static int countFemaleNames() throws IOException {
        String[] names = Imiona.getAllNames();
        int n=0;
        for (int i = 0; i < names.length; i++) {
            if(names[i].charAt(names[i].length()-1)=='a'){
                n++;
            }
        }
        return n;
    }
}
