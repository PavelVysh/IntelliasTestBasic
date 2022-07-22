import java.util.ArrayList;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private int amountOfMoney;
    private ArrayList<Product> boughtProducts;

    public User(int id, String firstName, String lastName, int amountOfMoney) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
        boughtProducts = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", amountOfMoney=" + amountOfMoney +
                '}';
    }

    public void purchase(Product product) {
        boughtProducts.add(product);
    }

    public void printPurchases() {
        for (Product p : boughtProducts) {
            System.out.println(p);
        }
    }

    public boolean didBuyProduct(Product product) {
        return boughtProducts.contains(product);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }
}
