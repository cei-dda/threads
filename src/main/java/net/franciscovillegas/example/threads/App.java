package net.franciscovillegas.example.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 * 
 */
public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws InterruptedException {
		System.out.println("----> main");
		LOGGER.debug("This is the logger");
		Singleton.bla();
		System.out.println("after bla");
		SingletonCaller sc1 = new SingletonCaller("s1", 0L);
		SingletonCaller sc2 = new SingletonCaller("s2", 100L);
		
		sc1.start();
		sc2.start();
		while(true) {
			Thread.sleep(1000L);
		}
	}

}
