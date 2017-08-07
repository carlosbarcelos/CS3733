package quiz3.move;

import quiz3.model.Model;

public class ModifyValue implements IMove {

	Model model;
	int oldValue;
	int newValue;
	
	public ModifyValue (Model m, int newValue) {
		this.model = m;
		this.newValue = newValue;
	}
	
	public boolean execute() {
		oldValue = model.getFahrenheit();
		model.setTemperature(newValue);
		return true;
	}

	public boolean undo() {
		model.setTemperature(oldValue);
		return true;
	}

}
