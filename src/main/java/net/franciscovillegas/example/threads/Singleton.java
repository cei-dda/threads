/**
 * 
 */
package net.franciscovillegas.example.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author "fvillegas ()"
 *
 */
public class Singleton {

	private static final Logger LOGGER = LoggerFactory.getLogger(Singleton.class);

	private static final Object keyGetInstance = new Object();

	private static Singleton instance;// = new Singleton();

	static {
		instance = new Singleton();
	}
	
	public static void bla() {
		System.out.println("bla--->");
	}

	public static Singleton getInstance() {
//		synchronized (keyGetInstance) {

			Singleton.bla();

			LOGGER.debug("Instance is: {}", instance);

			if (instance == null) {
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					LOGGER.error(e.getMessage(), e);
				}
				instance = new Singleton();
//			}

		}
		return instance;
	}

	private Singleton() {

		super();
		System.out.println("-----> Singleton");
	}

	public void doSomething() {
		LOGGER.debug("----> :)");
	}
}
