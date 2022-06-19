
public class Person extends Thread{
	KtxReservationCallback callback;
	
	public void setCallback(KtxReservationCallback callback) {
		this.callback = callback;
	}
	
	public void run() {
		callback.updateSeat("asdf", 1);
	}
}
