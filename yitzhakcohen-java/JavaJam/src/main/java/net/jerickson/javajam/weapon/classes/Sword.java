package net.jerickson.javajam.weapon.classes;

import java.util.Random;
import net.jerickson.javajam.weapon.Strikable;

/**
 *
 */
public abstract class Sword implements Strikable {

    private int dieFaces;
    private int numberOfDice;

    private Random rng = new Random();

    public Sword(int dieFaces, int numberOfDice) {
        this.numberOfDice = numberOfDice;
        this.dieFaces = dieFaces;
    }

	public int dealDamage() {
        int damage = 0;
        for(int i = 0; i < numberOfDice; i++) {
            damage += rng.nextInt(dieFaces) + 1;
        }

        return damage;
	}


}