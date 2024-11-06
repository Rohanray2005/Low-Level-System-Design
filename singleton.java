

public Class SingleTonInstance {
	
}

// lazy loading
public class SingleTonClass {
	private static SingleTonInstance instance;

	private SingleTonClass(){};

	public static SingleTonInstance getInstance() {
		if(instance == null) {
			instance = new SingleTonInstance();
		}
		return instance;
	}
}

// prev way is not thread safe as two threads may enter the getInstance method together
// and cause multiple new instances to be created. To Avoid this, we can make getInstance 
// Thread safe 
public class SingleTonClassThreadSafeSyncronized {
	private static SingleTonInstance instance;

	private SingleTonClass(){};

	public static SingleTonInstance syncronized getInstance() {
		if(instance == null) {
			instance = new SingleTonInstance();
		}
		return instance;
	}
}

public class SingleTonClassEagerInitalization {
	private static SingleTonInstance instance = new SingleTonInstance();

	private SingleTonClass(){};

	public static SingleTonInstance getInstance() {
		return instance;
	}
}

// Double-checked locking works by:

// Checking if the instance is null before entering a synchronized block (the first check).
// If it’s null, synchronizing on a block to ensure only one thread can create the instance.
// Checking again inside the synchronized block (the second check) to 
// make sure no other thread has created the instance in the meantime.

public class SingleTonClassDoubleCheckVolatile {
	private static volatile SingleTonInstance instance = new SingleTonInstance();

	private SingleTonClass(){};

	public static SingleTonInstance getInstance() {
		if(instance == null){
			syncronized(SingleTonClassDoubleCheckVolatile.class){
				if (instance == null) {  // Second check (with locking)
                    instance = new SingleTonInstance();
                }
			}
		}
		return instance;
	}
}

// using static block
public class Singleton {
    private static Singleton instance;

    static {
        try {
            instance = new Singleton();
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while creating singleton instance");
        }
    }

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }
}


public static void main(Strings[] args) {

}