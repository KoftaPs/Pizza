
import com.mycompany.pizza.logger;
import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {

        logger l;

    public Pizza(logger logg) {
        this.l = logg;
    }
        
        
	private void handlePizza() {
            
                l.Log("Welcome",false);
                boolean exit = false;
                
                while(!exit)
                {
                    Scanner scan = new Scanner(System.in);
                  
                    l.Log("\nPlease enter the choice as 1 or 2\n1. Pan Pizza\n2. Deep Dish\n",false);
                    int doughType = scan.nextInt();
                    l.Log("Please enter 1, 2 or 3 for size \n1. Small\n2. Medium\n3. Large\n",false);
                    int pizzaSize = scan.nextInt();
                
                
                    // Creating a Dough
                    // it will throw exception if usre don't add right information
                    Dough d = null;
                    try {
                    	d = new Mixer().makePizzaDough(getDoughType(doughType), getPizzaSize(pizzaSize));
                    } catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
                    }
                
                    // Throwing a Dough to Pan
                    // it will throw exception if size not match
                    Pan p = null;
                    try {
                    p = new Pan(getPizzaSize(pizzaSize), PanType.Pan,d,new logger());
                } catch (Exception e) {
                 e.printStackTrace();
                }
                
        
                    try {
			p.throwDough(d);
                    } catch (Exception e) {
			e.printStackTrace();
                    }
                    ArrayList<Ingredient> ingredients = new ArrayList<>();
                    ingredients.add(new Ingredient(IngredientName.MozzeraellaCheese, 0.25, 500.0));
                    ingredients.add(new Ingredient(IngredientName.Flour, 0.02, 100));
                    ingredients.add(new Ingredient(IngredientName.Garlic, 0.002, 10));
                    ingredients.add(new Ingredient(IngredientName.Onion, 0.008, 100));
                    ingredients.add(new Ingredient(IngredientName.Oregano, 0.02, 100));
                    ingredients.add(new Ingredient(IngredientName.PizzaSouce, 0.02, 100));
                    ingredients.add(new Ingredient(IngredientName.Salt, 0.0002, 0.5));
                    ingredients.add(new Ingredient(IngredientName.Tomatoes, 0.02, 10));
                    ingredients.add(new Ingredient(IngredientName.Yeast, 0.02, 100));

                    try {
			p.addIngredients(ingredients);
                    } catch (Exception e) {
			e.printStackTrace();
                    }

                    l.Log("\nBaking your Pizza now",false);
                    p.bake();
                    l.Log("Pizza Bake Complete",false);
                    l.Log("Pizza Size is "+p.size,false);
                    l.Log("Pizza have total "+p.getNumberOfSlices()+" slices",false);
                    try {
			l.Log("Each Slice contains "+p.caloriesPerSlice()+" Calories",false);
			
                    }
                    catch(Exception e) {
			e.printStackTrace();
                    }
                
                    //saving order info to the (logs.txt) file.
                    String log_msg = p.getInfo();
                    l.Log(log_msg, true);
                    
                    
                    l.Log("\nHave a nice meal 😋\nDo u want to order something else or end: \n1.yes \n2.no (end)\n", false);
                    int ans = scan.nextInt();
                    
                    if(ans == 2)
                    {
                        exit = true;
                    }
                    else if(ans == 1)
                    {
          
                    }
                    
                }
            
	

	}

	private DoughType getDoughType(int t) {
		if (t == 1) {
			return DoughType.Pan;
		}
		return DoughType.DeepDish;
	}
	

	private PizzaSize getPizzaSize(int s) throws Exception {
		switch (s) {
		case 1:
			return PizzaSize.SMALL;
		case 2:
			return PizzaSize.Medium;
		case 3:
			return PizzaSize.Large;
		}
		throw new Exception("Size not found");
	}

	public static void main(String[] args) {
		new Pizza(new logger()).handlePizza();
	}

}
