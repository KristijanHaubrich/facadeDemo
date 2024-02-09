package org.facade.shooting_result;

public class ShootingResult {
    private int dmg;
    private boolean isKill;
    private boolean isAlreadyDestroyed;
    public ShootingResult(int dmg, boolean isKill, boolean isAlreadyDestroyed){
        this.dmg = dmg;
        this.isKill = isKill;
        this.isAlreadyDestroyed = isAlreadyDestroyed;
    }
    public int getDmg() {
        return dmg;
    }
    public boolean getIsKill() {
        return isKill;
    }
    public boolean getIsAlreadyDestroyed() {
        return isAlreadyDestroyed;
    }
}
