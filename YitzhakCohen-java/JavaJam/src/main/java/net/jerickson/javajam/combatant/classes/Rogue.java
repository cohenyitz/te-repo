package net.jerickson.javajam.combatant.classes;

import net.jerickson.javajam.weapon.DamageType;

/**
 * Rogue extends Fighter
 */
public class Rogue extends Fighter {

    public Rogue(int health, int damageModifier) {
        super(health, damageModifier);
    }

    public int takeDamage(int damage, DamageType type) {
        // Slippery Rouges can dodge a lot of damage
        // In fact, they dodge all beg hits over 20
        if(damage <= 20) {
            // And they even take half damage on top of that
            return super.takeDamage(damage / 2, type);
        }

        return 0;
    }
}