import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleMenu {
    static ArrayList<User> userList = new ArrayList<>();
    static ArrayList<Product> productsList = new ArrayList<>();


    public static void main(String[] args) {
        initializeProducts();
        initializeUsers();

        Scanner scanner = new Scanner(System.in);
        int input;

        while(true) {
            printMenu(createMenu());
            input = scanner.nextInt();
            switch (input) {
                case 1: displayUsers();
                break;
                case 2: displayProducts();
                break;
                case 3: makePurchase();
                break;
                case 4: displayProductsByUser();
                break;
                case 5: displayUsersByProduct();
            }
        }


    }

    public static void printMenu(String[] menu) {
        for (String s : menu) {
            System.out.println(s);
        }
        System.out.printf("Enter number from 1 to %d\n",menu.length);
    }

    public static String[] createMenu(){
          return new String[]{
                  "1 = Display list of all users",
                  "2 = Display list of all products",
                  "3 = Make a purchase",
                  "4 = Display list of user products",
                  "5 = Display users by a bought product"};
    }

    public static void initializeUsers() {
       userList.add(new User(101,"Felix","Loginov",50000));
        userList.add(new User(102,"Tatiana","Soniachnikova",60000));
        userList.add(new User(103,"Taras","Shevchenko",750000));
    }

    public static void initializeProducts() {
        productsList.add(new Product(5171,"Sony", 10000));
        productsList.add(new Product(5271,"Philips", 15000));
        productsList.add(new Product(5371,"Samsung", 200000));
    }
    private static void displayUsers() {
        for (User u : userList) {
            System.out.println(u.toString());
        }
    }

    private static void displayProducts() {
        for (Product p :productsList) {
            System.out.println(p.toString());
        }
    }

    private static void makePurchase() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user ID");
        int userId = scanner.nextInt();
        System.out.println("Enter product ID");
        int productId = scanner.nextInt();
        for (Product p : productsList) {
            if (!(p.getId() == productId))continue;
            for (User s : userList) {
                if (s.getId() == userId){ s.setAmountOfMoney(s.getAmountOfMoney() - p.getPrice());
                    if(s.getAmountOfMoney() < 0){
                        System.out.println("Not enough money");
                        throw new RuntimeException();
                    }
                    s.purchase(p); //adding to purchased list of User
                    System.out.println("Purchase successful\n");
                    return;
                }
            }
        }
    }

    private static void displayProductsByUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user ID");
        int id = scanner.nextInt();
        for (User s : userList) {
            if (s.getId() == id) {
                s.printPurchases();
            }
        }
    }

    private static void displayUsersByProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product ID");
        int productId = scanner.nextInt();
        Product product = null;
        for (Product p : productsList) {
            if (p.getId() == productId) product = p;
        }
        for (User u : userList) {
            if(u.didBuyProduct(product)) System.out.println(u);
        }

    }
}
