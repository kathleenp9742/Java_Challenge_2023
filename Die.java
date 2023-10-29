import java.util.ArrayList;
public class Die {
    Integer rollNum;
    String dieColor;
    String dieName;
    boolean hasRolled;
    int sides;
    static int numDice = 0;
    public ArrayList<Integer> rollValueList; 
    String[] colors= {"Red", "Aqua", "Yellow", "Green", "Lavender"};
       public static void main(String[] args) {
            Die dieOne = new Die("Die 1 ");
            Die dieTwo = new Die(((int) (Math.random()*6) +1),"Die 2");
            System.out.println("Die 1 sides: " + dieOne.numSides());
            System.out.println("Die 1 rolled a " + dieOne.roll());
            System.out.println("Die 1 is " + dieOne.getDiceColor());
            System.out.println("Die 2 sides: " + dieTwo.numSides());
            System.out.println("Die 2 rolled a " + dieTwo.roll());
            System.out.println("Die 2 rolled a " + dieTwo.roll());
            dieTwo.readLastRoll();
            System.out.println("Die 2's roll values have a sum of " + dieTwo.sumAll());
            System.out.println("Die 2 is " + dieTwo.getDiceColor());
            Die dieThree = new Die("Die 3");
            System.out.println("Die 3 sides: " + dieThree.numSides());
            System.out.println("Die 3 is " + dieThree.getDiceColor());
            for(int i = 1; i<101; i++){ // rolls Die 3 100 times
                dieThree.roll();
            }
            dieThree.findRollValues();
            dieThree.readLastRoll();
            System.out.println("Die 3's roll values have a sum of " + dieThree.sumAll());
            System.out.println(getNumDie() + " dice have been rolled");
    }
    public Die(String name){ // Default die constructor creates N-sided die object and its roll value list
        this.dieName = name;
        sides = 6;
        numDice++;
        this.rollValueList = new ArrayList<>();
    }
    public Die(int N, String name){ // Die constructor creates N-sided die object and its roll value list
        this.sides = N;
        this.dieName = name;
        numDice++;
        this.rollValueList = new ArrayList<>(); 
    }
    public String getDieName(){ // returns the name of a die object
        return dieName;
    }
    
    public int numSides(){ // returns the number of sides of a die object
        return sides;
    }

    public int roll(){ // Returns the value of the die roll based on its number of sides
        rollNum = (int) ((Math.random()* numSides()) + 1);
        hasRolled = true;
        rollValueList.add(rollNum);
        return rollNum;
    }
    public void readLastRoll(){ // Prints the last roll value of the die object or -1 if the die hasn't been rolled yet
        if(hasRolled) {
            System.out.println(getDieName() + " last rolled " + rollNum);
        } else {
            System.out.println(-1);
        }
    }
    public static int getNumDie(){ // returns the total number of die objects that have been created
        return numDice;
    }
    public int sumAll() { // adds together the roll values of a die object
        int sum = 0;
        for (int i = 0; i < rollValueList.size(); i++) {
            sum += rollValueList.get(i);
        }
        return sum;
    }
    public void findRollValues(){ //Prints how many times each side of a 6-sided die has been rolled
        int oneValues = 0;
        int twoValues = 0; 
        int threeValues = 0;
        int fourValues = 0;
        int fiveValues = 0;
        int sixValues = 0;
        for(int i =0; i < rollValueList.size(); i++){
            if(rollValueList.get(i) == 1){
                oneValues++;
            } else if(rollValueList.get(i) == 2){
                twoValues++;
            } else if(rollValueList.get(i) == 3){
                threeValues++;
            } else if(rollValueList.get(i) == 4){
                fourValues++;
            } else if(rollValueList.get(i) == 5){
                fiveValues++;
            } else {
                sixValues++;
            } 
        }
        System.out.println(getDieName() + " rolled 1 " + oneValues + " times" );
        System.out.println(getDieName() + " rolled 2 " + twoValues + " times" );
        System.out.println(getDieName() + " rolled 3 " + threeValues + " times" );
        System.out.println(getDieName() + " rolled 4 " + fourValues + " times" );
        System.out.println(getDieName() + " rolled 5 " + fiveValues + " times" );
        System.out.println(getDieName() + " rolled 6 " + sixValues + " times" );
    }
    public String getDiceColor(){ // assigns a color from the colors Array to a die object
        return colors[((int) (Math.random()*colors.length-1) +1)];
    }
}
