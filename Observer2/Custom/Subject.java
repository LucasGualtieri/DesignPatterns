package Observer2.Custom;

public interface Subject {
	public void addObserver(Observer observer);
	public void removeObserver(Observer observer) throws IllegalArgumentException;
	public void notifyObservers(Object data);
} 
