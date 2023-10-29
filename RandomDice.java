public class RandomDice{
    public static void main(String[]args){
        for(int i = 1; i < 21; i++ ){ // simulates rolling a 6-sided die twenty times
            System.out.println("Roll " + i + ": " + (int) ((Math.random()*6) +1));
        }
    }
}