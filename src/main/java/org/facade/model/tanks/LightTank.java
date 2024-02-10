package org.facade.model.tanks;

import org.facade.granate.Granate;
import org.facade.model.granates.LightTankGranate;
import org.facade.shooting_result.ShootingResult;
import org.facade.tank.Tank;

public class LightTank implements Tank {
    private Granate granate;
    private int hitPoints;
    private int armor;
    private int dmg;
    private int kills;
    public LightTank(){
        this.granate = new LightTankGranate();
        this.hitPoints = 1250;
        this.armor = 100;
        this.dmg = 0;
        this.kills = 0;
    }
    @Override
    public void shoot(Tank tank) {
       ShootingResult shootingResult = tank.inflictDMG(this.granate);
       if(shootingResult.getIsAlreadyDestroyed()) System.out.println("You are shooting dead tank!!");
       else if(shootingResult.getDmg() == 0) System.out.println("NO PENETRATION");
       else{
           System.out.println("PENETRATION");
           if(shootingResult.getIsKill()){
               System.out.println("+1KILL");
               this.kills += 1;
           }
           System.out.println("+" + shootingResult.getDmg() + "DMG");
           this.dmg += shootingResult.getDmg();
       }
    }
    @Override
    public int currentHP() {
        return hitPoints;
    }
    @Override
    public ShootingResult inflictDMG(Granate granate) {
        //already destroyed
        if(isDestroyed()) return new ShootingResult(0,false,true);
        //kill
        else if(granate.getPenetrarion() > this.armor){
            if(this.hitPoints - granate.getDmg() <= 0){
                int damage = 0;
                if(this.hitPoints-granate.getDmg() == 0) damage += granate.getDmg();
                else damage += this.hitPoints;
                this.hitPoints = 0;
                return new ShootingResult(damage,true,false);
            }
            this.hitPoints = this.hitPoints - granate.getDmg();
            return new ShootingResult(granate.getDmg(), false,false);

        } else return new ShootingResult(0,false,false); //just dealing damage
    }
    @Override
    public boolean isDestroyed(){
        return hitPoints <= 0;
    }
    @Override
    public int getDMG() {
        return this.dmg;
    }
    @Override
    public int getKills() {
        return this.kills;
    }

    @Override
    public String toString(){
        return "LIGHT TANK:\nhp:" + this.hitPoints + "\ndmg:" + this.dmg+ "\nkills:" + this.kills + "\n";
    }
}
