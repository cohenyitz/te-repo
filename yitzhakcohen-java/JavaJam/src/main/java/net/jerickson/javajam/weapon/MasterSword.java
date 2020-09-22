package net.jerickson.javajam.weapon;

import net.jerickson.javajam.weapon.classes.Sword;

public class MasterSword extends Sword {

    public MasterSword() {
        super(8, 2);
    }

    public String toString() {
        return "The Master Sword";
    }

    public DamageType getDamageType() {
        return DamageType.SLASHING;
    }
}