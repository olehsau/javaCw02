import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class NBA {
    public void PrintBestAndWorstTeam(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/resources/teamsEast.txt"));
            String line;
            int nEast=0;
            int nWest=0;
            while((line = reader.readLine()) != null){
                nEast++;
            }
            reader = new BufferedReader(new FileReader("src/resources/teamsWest.txt"));
            while((line = reader.readLine()) != null){
                nWest++;
            }
            String[][] table = new String[nEast+nWest-2][7]; // how is this possible in runtime?? nEast and nWest are unknown during compilation :/
            //now reading
            reader = new BufferedReader(new FileReader("src/resources/teamsEast.txt"));
            reader.readLine(); // skip header
            for(int i=0; i<nEast-1; i++){
                line = reader.readLine();
                table[i] = line.split(";");
            }
            reader = new BufferedReader(new FileReader("src/resources/teamsWest.txt"));
            reader.readLine(); // skip header
            for(int i=nEast-1; i<nEast+nWest-2; i++){
                line = reader.readLine();
                table[i] = line.split(";");
            }
            //find max wins and loses
            int maxWins=-1;
            int maxLoses=-1;
            for(int i=0;i<nEast+nWest-2; i++){
                if(stringToInt(table[i][2])>maxWins){
                    maxWins = stringToInt(table[i][2]);
                }
                if(stringToInt(table[i][3])>maxLoses){
                    maxLoses = stringToInt(table[i][3]);
                }
            }
            //then find all teams with these numbers of wins and loses
            System.out.println("Best teams, which have number of victories:"+maxWins);
            for(int i=0;i<nEast+nWest-2; i++){
                if(stringToInt(table[i][2])==maxWins){
                    System.out.println(table[i][1]);
                }
            }
            System.out.println("Worst teams, which have number of loses:"+maxLoses);
            for(int i=0;i<nEast+nWest-2; i++){
                if(stringToInt(table[i][3])==maxLoses){
                    System.out.println(table[i][1]);
                }
            }
        }
        catch(IOException e){
            System.err.println("IOException!!!!!!!!!!!!! (file not found or read error)");
        }
    }

    public int stringToInt(String input){
        try{
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e){
            return -1;
        }
    }
}
