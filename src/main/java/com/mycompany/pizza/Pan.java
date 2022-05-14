import com.mycompany.pizza.logger;
import java.util.ArrayList;
import java.util.Random;

public class Pan {
	float totalCalories;
	PizzaSize size;
	PanType pan;
	Dough d;
	ArrayList<Ingredient> ingredients;
	ArrayList<PizzaSlice> pizzaSlices;
        logger l;
        
	
	public Pan(PizzaSize s,PanType p,Dough d,logger l) {
		this.size = s;
		this.pan = p;
                this.d = d;
		this.l = l;
	}
	public void throwDough(Dough d) throws Exception {
		if(d.size != this.size) {
			throw new Exception("Size not match");
		}
		this.d = d;
	}
	public void addIngredients(ArrayList<Ingredient> ings) throws Exception{
		this.countTotalCalories(ings);
		if(getTotalWeight(ings) > totalCalories) {
			throw new Exception("Weight exceed");
		}
		this.ingredients = ings;
		
		
		
	}
	public float caloriesPerSlice() throws Exception{
		if(pizzaSlices== null) {
			throw new Exception("No Slice is made yet");
		}
		return pizzaSlices.get(0).contentCalories;
	}
	
	private float getTotalWeight(ArrayList<Ingredient> ings) {
		float total = 0;
		for(Ingredient in: ings) {
			total += in.getWeight();
		}
		return total;
		
	}
	
	
	
	private PizzaSize getPanSize() {

            return this.size;
		
	}
	
	private PanType getPanType() {
	
            return  this.pan;
		
	}
	public void bake() {
		l.Log("Baking your Pizza :)",false);
		countTotalCalories(this.ingredients);
		makeSlices();
		
		
	}
	private void countTotalCalories(ArrayList<Ingredient> ings) {
		float total = 0;
               
		for(Ingredient in: ings) {
                   
			total += in.getCalories();
		}
		totalCalories = total;
	}
	
	private void makeSlices() {
		pizzaSlices = new ArrayList<>();
		int s = getNumberOfSlices();
		for(int i=0; i<s;i++) {
			pizzaSlices.add(new PizzaSlice(1,totalCalories/s));
		}
		
	}
	
	public int getNumberOfSlices() {
            int numberOfSlices = 0;
		if(PizzaSize.SMALL == size) {
			numberOfSlices =  4;
		}
		if(PizzaSize.Medium == size) {
			numberOfSlices = 6;
		}
                if(PizzaSize.Large == size)
                {
                    numberOfSlices = 8;
                }
		
                return  numberOfSlices;
	}
        
        
        public String getInfo()
        {
            String state ="Order Info:\n"+"1.PizzaSize: "+this.size+ ", 2.panType: "+this.pan+", "+"3.Dough type: "+this.d.doughType+", 4.Dough size: "+this.d.size+"\n\n";
            
            
            return state;
        }
	
	
	

}
