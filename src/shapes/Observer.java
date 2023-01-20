package shapes;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import frame.DrawingFrame;

public class Observer implements PropertyChangeListener{

	private int numberOfSelection;
	
	private boolean delete=false;
	private boolean update=false;
	
	private boolean moveForZ=false;

	
	public Observer() {
		
	}
	@Override
	public void propertyChange(PropertyChangeEvent a) {
		if(a.getPropertyName().equals("numberOfSelection")) {
				this.numberOfSelection=(int)(a.getNewValue());
		}

		if(this.numberOfSelection==1) {
			 delete=false;
			 update=false;
			 
			 moveForZ=false;

		}
		else if(this.numberOfSelection==2) {
			update=true;
			delete=true;
			
			moveForZ=true;

		}
		else if(this.numberOfSelection>1) {
			 delete=true;
			 update=false;
			 
			 moveForZ=false;

		}
		
		
	}
	public boolean isDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	public boolean isUpdate() {
		return update;
	}
	public void setUpdate(boolean update) {
		this.update = update;
	}
	public boolean isMoveForZ() {
		return moveForZ;
	}
	
		

}
