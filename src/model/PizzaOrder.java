package model;

import java.util.ArrayList;

/**
 *
 * @author ashkan mohseni
 */
public class PizzaOrder {
    
    private int dippingType;
    private int dippingNum;
    private double dippingsCost;
    private int pizzaChoice;
    private int drinkType;
    private int drinkNum;
    private int pizzaNum;
    private double pizzaCost;
    private double drinksCost;
    private double toppingsCost;
    private PizzaSize size;
    private Drinks drinks;
    private Dippings dippings;
    private ArrayList<Toppings> toppingList = new ArrayList<>();
    private ArrayList<Drinks> drinkList = new ArrayList<>();
    private ArrayList<Dippings> dippingList = new ArrayList<>();
    double tax = 0.13;

    public PizzaOrder() {
    }

    public PizzaOrder(int pizzaSize, int pizzaNum, ArrayList<Toppings> topping, double toppingCalc,
            ArrayList<Drinks> drink, double drinkCalc, int drinkNum, int drinkType, 
            ArrayList<Dippings> dipping, double dippingCalc, int dippingNum, int dippingType) {
        
        setPizza(pizzaSize);
        setPizzaChoice(pizzaSize);
        setPizzaCost(pizzaNum);
        setPizzaNum(pizzaNum);
        setToppingList(topping);
        setToppingsCost(toppingCalc);
        setDrinkList(drink);
        setDrinksCost(drinkCalc);
        setDrinkNum(drinkNum);
        setDrinkType(drinkType);
        setDippingList(dipping);
        setDippingsCost(dippingCalc);
        setDippingNum(dippingNum);
        setDippingType(dippingType);
        
    }

    public void setPizzaCost(int pizzaNum) { 
        if (pizzaNum == -1) {
              this.pizzaCost = pizzaCost;
        } else {
        pizzaCost = pizzaNum * size.getPrice();
        }
    }

    public void setPizzaChoice(int pizzaChoice) {
        this.pizzaChoice = pizzaChoice;
    }

    public void setDrinksCost(double drinksCost) {
        this.drinksCost = drinksCost;
    }

    public void setToppingsCost(double toppingsCost) {
        this.toppingsCost = toppingsCost;
    }

    public ArrayList<Toppings> getToppingList() {
        return toppingList;
    }

    public void setPizza(int pizzaChoice) {
        if (pizzaChoice == -1) {
            this.pizzaChoice = pizzaChoice;
        } else{
        size = PizzaSize.values()[pizzaChoice];
        }
    }
    public void setDrinkType(int drinkType) {
        if (!(drinkType >=0) ) {
            this.drinkType = drinkType;
        } else{
        drinks = Drinks.values()[drinkType];
        }
    }
    
    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public void setDrinks(Drinks drinks) {
        this.drinks = drinks;
    }

    public void topping(Toppings topping) {
        toppingList.add(topping);
    }

    public void setToppingList(ArrayList<Toppings> toppingList) {
        this.toppingList = toppingList;
    }

    public void setDrinkList(ArrayList<Drinks> drinkList) {
        this.drinkList = drinkList;
    }

    public void drink(Drinks drinks) {
        drinkList.add(drinks);
    }

    public void setDrinkNum(int drinkNum) {
        this.drinkNum = drinkNum;
    }

    public void setPizzaNum(int pizzaNum) {
        this.pizzaNum = pizzaNum;
    }

    public void setPizzaCost(double pizzaCost) {
        this.pizzaCost = pizzaCost;
    }

    public ArrayList<Drinks> getDrinkList() {
        return drinkList;
    }

    public void setDippingType(int dippingType) {
               if (!(dippingType >=0) ) {
            this.dippingType = dippingType;
        } else{
        dippings = Dippings.values()[dippingType];
        }
    }

    public void setDippingNum(int dippingNum) {
        this.dippingNum = dippingNum;
    }

    public void setDippingsCost(double dippingsCost) {
        this.dippingsCost = dippingsCost;
    }

    public void setDippingList(ArrayList<Dippings> dippingList) {
        this.dippingList = dippingList;
    }

    public void setDippings(Dippings dippings) {
        dippingList.add(dippings);
    }

    public ArrayList<Dippings> getDippingList() {
        return dippingList;
    }
    

    /**
     * A method that calculates the toppings order and returns "toppingOrder"
     * variable
     *
     * @return toppingOrder - the sum of toppings
     */
    public String toppingOrder(int numberOfPizzas) {
        String toppingOrder = " ";
        for (int i = 0; i < toppingList.size(); i++) {
            toppingOrder += String.format("\t%n  \t%s %s%n\t%n", numberOfPizzas, toppingList.get(i));
        }

        return toppingOrder;
    }

    /**
     * A method that calculates the pizza order and returns "finalPizza"
     * variable
     *
     * @return finalPizza - the sum of pizza + toppings
     */
    public String PizzaOrder() {
        String PizzaTitle = " ";
        String pizzaOrder = " ";
        String toppingOrder = " ";

        if (size != null) {
            pizzaOrder += String.format("Pizzas:\t\t\t%40.2f%n\n  \t%s %s%n \nToppings:\t\t\t\t%32.2f%n",
                    pizzaCost, pizzaNum, PizzaSize.values()[pizzaChoice], toppingsCost);

            for (int i = 0; i < toppingList.size(); i++) {
                toppingOrder += String.format("\t%n  \t%s %s%n\t%n", pizzaNum, toppingList.get(i));
            }

        }
        String finalPizza = pizzaOrder + toppingOrder;
        return finalPizza;
    }

    /**
     * A method that calculates the Drinks ordered and returns "finalDrink"
     * variable
     *
     * @return finalDrink - the sum of drinks
     */
    public String DrinkOrder() {
        String drinksTitle = " ";
        String drinksOrder = " ";

        drinksTitle = String.format("Drinks:\t\t\t%40.2f%n ", drinksCost);

        for (int i = 0; i < drinkList.size(); i++) {
            drinksOrder += String.format("%n \t%s %s%n", drinkNum, drinkList.get(i));
        }
        String finalDrink = drinksTitle + drinksOrder;
        return finalDrink;
    }
    
    /**
     * A method that calculates the Dips ordered and returns "finalDip"
     * variable
     *
     * @return finalDip- the sum of dips
     */
        public String DippingsOrder() {
        String drppingsTitle = " ";
        String dippingsOrder = " ";

        drppingsTitle = String.format("\nDippings:\t\t\t%40.2f%n ", dippingsCost);

        for (int i = 0; i < dippingList.size(); i++) {
            dippingsOrder += String.format("%n \t%s %s%n", dippingNum, dippingList.get(i));
        }
        String finalDip = drppingsTitle + dippingsOrder;
        
        return finalDip;
    }
    
     /**
     * A method that calculates the subtotal + HST + Total  and returns "finalOrder"
     * variable
     *
     * @return finalOrder - subtotal + HST + Total 
     */
        public String FinalOrder() {
        String finalOrder = " ";
        double subtotal = pizzaCost + drinksCost + toppingsCost + dippingsCost;
        double HST = subtotal * tax;
        double total = subtotal + HST;
        
         finalOrder = String.format("\n===========================%n"
                  + "\nSubtotal:\t\t\t%32.2f%nHST:\t\t\t\t%40.2f%nTotal:\t\t\t%40.2f%n", subtotal, HST, total);
         
        return finalOrder;
    }
        
     /**
     * A method that checks the exceptions and return the finalPrint to be displayed
     *  in PizzeriaController
     *
     * @return finalPrint - the final print to be displayed
     */
    public String toString() {
        String finalPrint = " ";
        
        // when everything has been ordered
        if (pizzaChoice >= 0 && drinkType >= 0  && toppingsCost != 0 ) {
            finalPrint = PizzaOrder() + DrinkOrder()  + DippingsOrder() + FinalOrder();
        } 
        
        //when only pizza is being selected without topping
        else if (pizzaChoice >= 0 && toppingsCost ==0 && drinkType ==-1){
            finalPrint = "\t**ERROR**\nYou should at least choose one topping \nfor your pizza";
        }
        
        //when only topping is being selected without pizza
        else if (toppingsCost != 0 && pizzaChoice == -1  || drinkType>=1) {
            finalPrint = "\t**ERROR**\nYou should choose a pizza in order to \nadd toppings";
        }
        
        //  when pizza and drink are selected but not topping
         else if (toppingsCost == 0 && pizzaChoice != -1  && drinkType != -1  ) {
            finalPrint = "\t**ERROR**\nYou should at least choose one topping \nfor your pizza";
        }
        
         // Pizza exception
        else if (pizzaChoice >= 0  ) {
            finalPrint = PizzaOrder() + FinalOrder();
        } 
      
        // Drink Exception
        else if (drinkType >= 0 ) {
            finalPrint = DrinkOrder() + FinalOrder();
        } 
        
        else if(dippingType >= 0){
            finalPrint = DippingsOrder() + FinalOrder();
        }
        
        return finalPrint;
    }

}
