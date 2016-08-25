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
public class SingletonCaller extends Thread {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SingletonCaller.class);

	private String threadName;
	private Long wait;

	private Singleton singleton;

	public SingletonCaller(String threadName, Long wait) {
		this.threadName = threadName;
		this.wait = wait;
	}

	public Singleton getSingleton() {
		return singleton;
	}

	public void setSingleton(Singleton singleton) {
		this.singleton = singleton;
	}

	// NUNCA LLAMAR A ESTE METODO DIRECTAMENTE CUANDO SE QUIERE
	// TRABAJAR CON HILOS (EXCEPCION: TEST UNITARIOS)
	@Override
	public void run() {

		LOGGER.debug("{} trying to have an instance of Singleton", threadName);

		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage(), e);
		}

		this.singleton = Singleton.getInstance();
		LOGGER.debug("{} Have instance of Singleton. \n\t My singleton instance is: {}",
				new Object[] { threadName, this.singleton });
		while(true) {
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
