package net.jerickson.javajam;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import net.jerickson.javajam.combatant.BubbaTheBruiser;
import net.jerickson.javajam.combatant.Fightable;
import net.jerickson.javajam.combatant.Link;
import net.jerickson.javajam.weapon.IceNedStarkSword;
import net.jerickson.javajam.weapon.MasterSword;
import net.jerickson.javajam.weapon.Strikable;

/**
 * FightingPit
 */
public class FightingPit {

    private static Fightable[] fighterOptions = {
        new BubbaTheBruiser(),
        new Link()
    };

    private static Strikable[] weaponOptions = {
        new MasterSword(),
        new IceNedStarkSword()
    };

    Scanner input;

    public FightingPit() {
        input = new Scanner(System.in);
    }

    public void run() {
        printGreeting();

        Fightable fighterOne = askUserForFighter();
        Strikable fighterOnesWeapon = askUserForWeapon();
        fighterOne.setWeapon(fighterOnesWeapon);

        System.out.println("Who dare be against this amazing fighter?!");
        System.out.println();

        Fightable fighterTwo = askUserForFighter();
        Strikable fighterTwosWeapon = askUserForWeapon();
        fighterTwo.setWeapon(fighterTwosWeapon);

        fight(fighterOne, fighterTwo);
    }

	private void fight(Fightable fighterOne, Fightable fighterTwo) {
        System.out.println("The carnage BEGINS!!!!!!!");
        System.out.println();

        while( !fighterOne.isDead() && !fighterTwo.isDead()) {
            try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				
            }
            
            System.out.println(fighterOne + " strikes with " + fighterOne.getWeapon());
            int damageDealt = fighterOne.dealDamage();
            System.out.println("A hit of " + damageDealt + " points!");
            int actualDamage = fighterTwo.takeDamage(damageDealt, fighterOne.getDamageType());
            if(actualDamage < damageDealt){
                System.out.println("But what moves! " + fighterTwo + " only took " + actualDamage);
            } else {
                System.out.println("Ouch! " + fighterTwo + " actually took " + actualDamage + " from that hit!");
            }
            System.out.println();

            try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				
            }
            
            System.out.println(fighterTwo + " strikes back with " + fighterTwo.getWeapon());
            damageDealt = fighterTwo.dealDamage();
            System.out.println("That took off " + damageDealt + " points!");
            actualDamage = fighterOne.takeDamage(damageDealt, fighterTwo.getDamageType());
            if(actualDamage < damageDealt){
                System.out.println("Amazing dodge! " + fighterOne + " only took " + actualDamage);
            } else {
                System.out.println("Crushing! " + fighterOne + " actually took " + actualDamage + " from that one!");
            }
            System.out.println();

            System.out.println("That leaves " + fighterOne + " with " + fighterOne.getHealth() +
                " and " + fighterTwo + " with " + fighterTwo.getHealth());
            System.out.println();
        }

        Fightable winner, loser;
        if(fighterOne.isDead()) {
            winner = fighterTwo;
            loser = fighterOne;
        } else {
            winner = fighterOne;
            loser = fighterTwo;
        }

        System.out.println("That means that " + loser + " is out of the fight!");
        System.out.println("The winner is " + winner.toString().toUpperCase() + "!");

        System.out.println();
	}

	private Fightable askUserForFighter() {
        while(true) {
            System.out.println();
            System.out.println("Choose a fighter!!");
            
            for(int i = 0; i < fighterOptions.length; i++) {
                System.out.println("" + i + ": " + fighterOptions[i]);
            }

            System.out.println("Who will you choose? ");
            String choice = input.nextLine();
            int index;
            try {
                index = Integer.parseInt(choice);
            } catch (NumberFormatException ex) {
                index = -1;
            }
            if(index >= 0 && index < fighterOptions.length) {
                return fighterOptions[index];
            } else {
                System.out.println("What are you? Daft? Pick a valid fighter!");
            }
        }
    }
    
    private Strikable askUserForWeapon() {
        while(true) {
            System.out.println();
            System.out.println("Choose a weapon!!");
            
            for(int i = 0; i < weaponOptions.length; i++) {
                System.out.println("" + i + ": " + weaponOptions[i]);
            }

            System.out.println("What will they fight with? ");
            String choice = input.nextLine();
            int index;
            try {
                index = Integer.parseInt(choice);
            } catch (NumberFormatException ex) {
                index = -1;
            }
            if(index >= 0 && index < weaponOptions.length) {
                return weaponOptions[index];
            } else {
                System.out.println("What are you? Daft? Pick an instrument of destruction!");
            }
        }
	}

	private void printGreeting() {
        System.out.println("Welcome to the fighting pit!");
        System.out.println("Today we'll see titans clash in the ultimate fighting arena!!!!!!!");
        System.out.println("So who will be the fighters today?");
        System.out.println();
    }
    
}