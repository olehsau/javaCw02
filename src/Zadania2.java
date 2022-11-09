import java.io.IOException;

public class Zadania2 {
    public static void main(String[] args) {

        ////difference between nested and inner class//////////////////////////////////////////////

        Car.CarManager manager = new Car.CarManager(); // we dont need to instantiate Car to instantiate CarManager
        manager.changeNumberOfCars(10);

        Car car1 = new Car("Skoda");
        Car car2 = new Car("BMW");

        Car.CarModifier modifier1 = car1.new CarModifier();
        modifier1.changeCarName("Skoda Octavia");

        ////max dimension///////////////////////////////////////////////////////////////////

        boolean[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][] arr = {{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{
                true
        }}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}};
        // 255 dimensions is max

    /*    boolean[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][] arr2 = {{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{
                true
        }}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}};
        // 256 causes error: array type has too many dimensions
    */

        ////Diamond problem solution////////////////////////////////////////////////////////////////////////////////////

        Smth smth = new Smth();
        System.out.println(smth.concatenate2IntsAnd2Strings(123,456,"Hello","world"));


        /////// zadanie NBA ///////////////////////////////////////////////////////////////
        NBA nba = new NBA();
        nba.PrintBestAndWorstTeam();

        ////////// zadanie IMIONA /////////////////////////
        System.out.println();
        System.out.println("Wszystkie imiona:");
        try {
            String[] names = Imiona.getAllNames();
            for (int i = 0; i < names.length; i++) {
                System.out.print(names[i]+",");
            }
            System.out.println("\nImiona i liczba pierwszych liter dla każdej litery:");
            Imiona.printNumberOfNamesForEveryFirstLetter();
            System.out.println("Liczba imion żenskich: "+Imiona.countFemaleNames());
            System.out.println("Liczba imion menskich: "+(names.length-Imiona.countFemaleNames()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
/* podpunkt 2
 There are 2 differences between static nested class and inner non-static class:
    1) Static nested class has access only to outer class static fields and methods.
    2) Static nested class can be instantiated without instantiation of outer class, and inner class cant.
*/
class Car{
    static int numberOfCars = 0;
    String carName;

    public Car(String name){
        this.carName = name;
        numberOfCars++;
        System.out.println("New car was created: "+name);
        System.out.println("Now there are cars: "+numberOfCars);
    }

    // static nested class
    public static class CarManager{
        public void changeNumberOfCars(int newNumberOfCars){
            numberOfCars = newNumberOfCars;
            //carName="Hyundai SantaFe"; //will cause error
            System.out.println("Now there are " + numberOfCars + " cars");
        }
    }

    // inner class
    public class CarModifier{
        public void changeCarName(String newCarName){
            System.out.println("Car "+carName+" is now: "+newCarName);
            carName = newCarName;
        }
    }
}


// Diamond problem solution (composition)

class StringHelper{
    public String concatenate(String a, String b){
        return a+b;
    }
}

class IntHelper{
    public int concatenate(int a, int b){
        int t=b;
        int n=1;
        while(t>=10){
            t=t/10;
            n++;
        }
        for(int i=0; i<n; i++){
            a=a*10;
        }
        return a+b;
    }
}

//class Smth extends IntHelper, StringHelper{}

class Smth{
    IntHelper intHelper = new IntHelper();
    StringHelper stringHelper = new StringHelper();

    // now we can use both "concatenate" methods without ambiguity
    // it is called "composition"

    public String concatenate2IntsAnd2Strings(int a, int b, String c, String d){
        return intHelper.concatenate(a,b)+stringHelper.concatenate(c,d);
    }
}