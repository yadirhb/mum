package prob2;

public abstract class Department {
	private StringQueue queue = new StringQueue();
	StringQueue getQueue() {
		return queue;
	}
	//implement

	public void addMessage(String msg){
		if(msg != null && !msg.isEmpty()) this.queue.enqueue(msg);
	}

	String nextMessage() {
		if(!this.queue.isEmpty()) {
			try {
				return this.queue.dequeue();
			} catch (EmptyQueueException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public abstract String getName();
}
