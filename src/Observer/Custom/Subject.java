package src.Observer.Custom;

public interface Subject {
	public void addObserver(Observer observer);
	public void removeObserver(Observer observer) throws IllegalArgumentException;
	public void notifyObservers(Object data);
} 

// This is supposed to help avoiding to make notifications when the state changes more frequently then the observer need to be updated
// This how the "Observer CLASS" is implemented in the deprecated java native class 
//setChanged() { changed = true }
//
//notifyObservers(Object arg) {
//	if (changed) {
//		for (every observer on the list) {
//			 call update (this, arg);
//		}
//		changed = false
//	} 
//}
//
//notifyObservers() { notifyObservers(null) }
