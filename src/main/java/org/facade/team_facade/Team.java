package org.facade.team_facade;

import org.facade.model.tanks.HeavyTank;
import org.facade.model.tanks.LightTank;
import org.facade.model.tanks.MediumTank;
import org.facade.tank.Tank;

import java.util.*;

public class Team {
    String name;
    LightTank lightTank = new LightTank();
    MediumTank mediumTank = new MediumTank();
    HeavyTank heavyTank = new HeavyTank();

    public Team(String name){this.name = name;}

    private int getCurrentTeamHP(){return this.lightTank.currentHP() + this.mediumTank.currentHP() + this.heavyTank.currentHP();}

    public Tank getDefender(){
        int number =  new Random().nextInt(31);
        if(number < 11){
            if(!this.lightTank.isDestroyed()) return this.lightTank;
            else if(this.lightTank.isDestroyed() && !this.mediumTank.isDestroyed()) return this.mediumTank;
            else return this.heavyTank;
        }else if(number < 20){
            if(!this.mediumTank.isDestroyed()) return this.mediumTank;
            else if(this.mediumTank.isDestroyed() && !this.lightTank.isDestroyed()) return this.lightTank;
            else return this.heavyTank;
        }
        else{
            if(!this.heavyTank.isDestroyed()) return this.heavyTank;
            else if(this.heavyTank.isDestroyed() && !this.mediumTank.isDestroyed()) return this.mediumTank;
            else return this.lightTank;
        }
    }

    public boolean isTeamDestroyed(){
        return this.lightTank.isDestroyed() && this.mediumTank.isDestroyed() && this.heavyTank.isDestroyed();
    }

    public boolean isLightDestroyed(){return this.lightTank.isDestroyed();}
    public boolean isMediumDestroyed(){return this.mediumTank.isDestroyed();}
    public boolean isHeavyDestroyed(){return this.heavyTank.isDestroyed();}
    public void shootWithLightTank(Tank tank){ this.lightTank.shoot(tank); }
    public void shootWithMediumTank(Tank tank){ this.mediumTank.shoot(tank); }
    public void shootWithHeavyTank(Tank tank){this.heavyTank.shoot(tank);}

    @Override
    public String toString(){return "TEAM "+ this.name + ":\nHP LEFT:" + getCurrentTeamHP() + "\n--------------------------------------------------\n" + this.lightTank.toString() + "--------------------------------------------------\n" + this.mediumTank.toString() + "--------------------------------------------------\n" + this.heavyTank.toString();}



}
