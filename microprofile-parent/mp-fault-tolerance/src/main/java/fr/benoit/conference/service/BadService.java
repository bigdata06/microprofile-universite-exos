package fr.benoit.conference.service;

import java.util.Random;

import javax.enterprise.context.Dependent;

@Dependent
public class BadService {

	static public int nbFois =0;
	
	public int methodeSuperLongue() {
		int wait = new Random().nextInt(5)+1;
		try {
			Thread.sleep(wait * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return wait;
	}

	public int methodePasFiable() {
		int nb = new Random().nextInt(1000)/2;
		nbFois++;
		System.out.println("Appel n° " + nbFois + "  (" + nb + ")");
		if (nb < 400) {
			throw new IllegalArgumentException("Je n'y arrive pas");
		}
		return nb;
	}

}
