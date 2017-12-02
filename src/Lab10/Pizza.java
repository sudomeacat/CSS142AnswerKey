package Lab10;

@SuppressWarnings("ALL")
public class Pizza {
    private int size;
    private int num_meat_toppings;
    private int num_vegan_toppings;
    private boolean vegan_friendly;

    public Pizza() {
        this(1, false, 0, 0);
    }

    public Pizza(int size, boolean vegan_friendly, int num_meat_toppings, int num_vegan_toppings) {
        this.size = size;
        this.vegan_friendly = vegan_friendly;
        this.num_meat_toppings = num_meat_toppings;
        this.num_vegan_toppings = num_vegan_toppings;
    }

    public double calcCost() {
        double price = 0.0;
        switch (size) {
            case 0:
                price += 10;
                break;
            case 1:
                price += 12;
                break;
            case 2:
                price += 14;
                break;
        }

        price += vegan_friendly ? 2 : num_meat_toppings * 2;
        price += num_vegan_toppings;

        return price;
    }

    @Override
    public String toString() {
        return "Size: " + size + " || Vegan: " + (vegan_friendly ? "true" : "false") + " || meat topping: " +
                num_meat_toppings + " || vegan topping: " + num_vegan_toppings + " || Price: " + calcCost();
    }
}
