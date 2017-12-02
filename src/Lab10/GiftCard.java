package Lab10;

@SuppressWarnings("ALL")
public class GiftCard {
    private double current_balance;

    // Default constructor
    public GiftCard() {
        this (0.0);
    }
    
    // Constructor
    public GiftCard(double balance) {
        current_balance = balance;
    }
     
    public void setBalance(double balance) {
        current_balance = balance;
        System.out.printf("Starting balance is: " + "%.2f  ", current_balance);
    }
    
    public void deduct(double amount) {
        current_balance = current_balance - amount;
        if(current_balance <= 0) {
            System.out.printf("You don't have enough money!");
        }
       
        else {
            System.out.printf("Current balance after $" + "%.2f " + " withdrawal is: $ " + "%.2f ", amount, current_balance);
        }
        
    }

    //an example method that needs instance data to be declared first
    public void resetToZero() {
        current_balance = 0;
        System.out.println("rester to zero: " + current_balance + "\n");
    }
    
    public void report() {
        System.out.printf( "%.2f" + "\n", current_balance);
    }
    
    public static void main(String[] args) {
        GiftCard card1 = new GiftCard();
        
        card1.setBalance(50);
        
        System.out.print("card1 value is :");
        card1.report();
        
        GiftCard card2 = new GiftCard();
        
        card2.setBalance(100);
        System.out.print("card2 value is :");
        card2.report();
        
        card2.deduct(101);
        System.out.println(" After deducting $101, card2's new balance is :");
        card2.report();
        
        card1.deduct(12.50);
        System.out.println(" After deducting $12.50, card1's new balance is :");
        card1.report();
        
        card1.resetToZero();
        card1.report();
        card2.resetToZero();
        card2.report();
        
        // User defined constructor
        GiftCard card3 = new GiftCard(5000);
        System.out.println("\nSetting the new balance to 7500.99 ");
        card3.setBalance(7500.99);
       
        
    }

}
