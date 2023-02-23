package Game.Shields;

import Game.Shield;

public class Manlet implements Shield {

    String shieldName;

    private int damageThreshold;

    private boolean isImmovable;

    public Manlet(String shieldName, int damageThreshold, boolean isImmovable) {
        this.shieldName = shieldName;
        this.damageThreshold = damageThreshold;
        this.isImmovable = isImmovable;
    }

    public boolean isImmovable() {
        return isImmovable;
    }

    @Override
    public int shieldHealth() {
        return damageThreshold;
    }

    public int getDamageThreshold() {
        return damageThreshold;
    }

    @Override
    public String toString() {
        return "HandShield{" +
                "shieldName='" + shieldName + '\'' +
                ", damageTreshold=" + damageThreshold +
                '}';
    }
}
