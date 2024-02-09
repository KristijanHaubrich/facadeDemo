package org.facade;

import org.facade.team_facade.Team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        try (
                BufferedReader stdIn =
                        new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("GAME START:");
            System.out.println("--------------------------------------------------");
            System.out.println("--------------------------------------------------");
            System.out.println("TEAM 1 NAME: ");
            String team1Name =  stdIn.readLine();
            System.out.println("--------------------------------------------------");
            System.out.println("--------------------------------------------------");
            System.out.println("TEAM 2 NAME: ");
            String team2Name =  stdIn.readLine();
            System.out.println("--------------------------------------------------");
            System.out.println("--------------------------------------------------");

            Team team1 = new Team(team1Name);
            Team team2 = new Team(team2Name);
            int round = 1;
            while (true){
                String pick = "no";
                System.out.println("ROUND " + round + ".");
                System.out.println("--------------------------------------------------");

                while(pick.equals("no")){
                    System.out.println(team1Name + " PICK ATTACKER (press l for light tank, m for medium tank or h for heavy tank):");
                    pick = stdIn.readLine();
                    if(pick.equals("l")) {
                        team1.shootWithLightTank(team2.getDefender());
                    }else if(pick.equals("m")){
                        team1.shootWithMediumTank(team2.getDefender());
                    }else if(pick.equals("h")){
                        team1.shootWithHeavyTank(team2.getDefender());
                    }else{
                        System.out.println("wrong input\n");
                        pick = "no";
                    }
                }
                pick = "no";
                if(team1.isTeamDestroyed() || team2.isTeamDestroyed()){
                    break;
                }

                while(pick.equals("no")){
                    System.out.println(team2Name + " PICK ATTACKER (press l for light tank, m for medium tank or h for heavy tank):");
                    pick = stdIn.readLine();
                    if(pick.equals("l")) {
                        team2.shootWithLightTank(team1.getDefender());
                    }else if(pick.equals("m")){
                        team2.shootWithMediumTank(team1.getDefender());
                    }else if(pick.equals("h")){
                        team2.shootWithHeavyTank(team1.getDefender());
                    }else{
                        System.out.println("wrong input\n");
                        pick = "no";
                    }
                }
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                System.out.println("RESULTS AFTER ROUND" + round + ":");
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                System.out.println(team1.toString());
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                System.out.println(team2.toString());
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                System.out.println("--------------------------------------------------");
                if(team1.isTeamDestroyed() || team2.isTeamDestroyed()){
                    break;
                }
                round++;
            }
            if(team1.isTeamDestroyed()) System.out.println("WINNER IS " + team2Name);
            else System.out.println("WINNER IS " + team1Name);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}