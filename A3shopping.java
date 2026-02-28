package payment;

// Parent class
class OnlinePayment {

    String transactionID;
    String paymentID;
    double amount;
    String customerCategory;

    // Constructor
    OnlinePayment(String tID, String pID, double amt, String category) {
        transactionID = tID;
        paymentID = pID;
        amount = amt;
        customerCategory = category;
    }

    // Method to apply discount (will be overridden)
    double applyDiscount() {
        return amount;
    }
}

// Child class UPI
class UPI extends OnlinePayment {

    UPI(String tID, String pID, double amt, String category) {
        super(tID, pID, amt, category);
    }

    // Overriding
    double applyDiscount() {
        return amount - (amount * 0.10); // 10% discount
    }
}

// Child class Credit Card
class CreditCard extends OnlinePayment {

    CreditCard(String tID, String pID, double amt, String category) {
        super(tID, pID, amt, category);
    }

    // Overriding
    double applyDiscount() {
        return amount - (amount * 0.05); // 5% discount
    }
}

// Child class Digital Wallet
class DigitalWallet extends OnlinePayment {

    DigitalWallet(String tID, String pID, double amt, String category) {
        super(tID, pID, amt, category);
    }

    // Overriding
    double applyDiscount() {
        return amount - (amount * 0.15); // 15% discount
    }
}

// Class for Method Overloading
class DiscountCalculator {

    // Overloading based on amount
    double calculate(double amount) {
        return amount * 0.10;
    }

    // Overloading based on customer category
    double calculate(double amount, String category) {

        if (category.equals("Premium"))
            return amount * 0.20;
        else
            return amount * 0.05;
    }
}

// Main class
public class PaymentSystem {

    public static void main(String[] args) {

        UPI u = new UPI("T101", "P101", 1000, "Premium");
        CreditCard c = new CreditCard("T102", "P102", 1000, "Regular");
        DigitalWallet d = new DigitalWallet("T103", "P103", 1000, "Premium");

        System.out.println("UPI Final Amount: " + u.applyDiscount());
        System.out.println("Credit Card Final Amount: " + c.applyDiscount());
        System.out.println("Digital Wallet Final Amount: " + d.applyDiscount());

        DiscountCalculator dc = new DiscountCalculator();

        System.out.println("Discount on Amount: " + dc.calculate(1000));
        System.out.println("Discount for Premium: " + dc.calculate(1000, "Premium"));
    }
}
