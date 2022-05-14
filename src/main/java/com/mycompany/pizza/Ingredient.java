
public class Ingredient {
	IngredientName name;
	double weight;
	double calories;
	
	public Ingredient(IngredientName name, double d, double e) {
		this.name = name;
		this.weight = d;
		this.calories = e;
	}
	
	public void setName(IngredientName name) {
		this.name = name;
	}
	public IngredientName getName() {
		return name;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public double getWeight() {
		return weight;
	}
	public void setCalories(float calories) {
		this.calories = calories;
	}
	public double getCalories() {
		return this.calories;
	}
	
	public String toString() {
		return "Name: "+this.name+"\tWeight: "+this.weight+"\tCalories:"+this.calories;
	}
	
	

}
