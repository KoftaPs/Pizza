
public class PizzaSlice {
	int capacity;
	float contentCalories;
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public float getContentCalories() {
		return contentCalories;
	}

	public void setContentCalories(float contentCalories) {
		this.contentCalories = contentCalories;
	}

	public PizzaSlice(int capacity,float contentCalories) {
		this.capacity = capacity;
		this.contentCalories = contentCalories;
	}
	public String toString() {
		return "Capacity :"+capacity+"\tContent Calories: "+contentCalories;
	}
	

}
