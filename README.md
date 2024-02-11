# FACADE DESIGN PATTERN - TANK GAME EXAMPLE
## INTRODUCTION
This project is made for demostrating facade design pattern. Facade design pattern is a structural design pattern that provides a simplified interface to a complex system of classes, interfaces, or subsystems. It encapsulates the complexities of the subsystems and provides a unified interface to interact with them. This pattern promotes loose coupling between the client code and the subsystems, making the code more maintainable and easier to understand.

### 2 Key components of the Facade pattern:
- Facade: This is the central class that provides a simplified interface to the client to access the subsystem or a group of subsystems. The facade delegates client requests to the appropriate objects within the subsystem.
- Subsystem classes: These are the individual classes or components that represent the complex subsystem. They contain the implementation details and functionality that are hidden behind the facade

## PROJECT DETAILS
This project represent simple tank game. It has two interfaces. One interface is called [Tank](src/main/java/org/facade/tank/Tank.java) and represents all tanks. Second interface is called [Granate](src/main/java/org/facade/granate/Granate.java)  and represent all granates.
3 classes that implement **Tank** interface and 3 classes that implement **Granate** interface are created:

### 3 classes of tanks:
- [LightTank](src/main/java/org/facade/model/tanks/LightTank.java)
- [MediumTank](src/main/java/org/facade/model/tanks/MediumTank.java)
- [HeavyTank](src/main/java/org/facade/model/tanks/HeavyTank.java)

### 3 classes of granates:
- [LightTankGranate](src/main/java/org/facade/model/granates/LightTankGranate.java)
- [MediumTankGranate](src/main/java/org/facade/model/granates/MediumTankGranate.java)
- [HeavyTankGranate](src/main/java/org/facade/model/granates/HeavyTankGranate.java)  

Each tank and granate have their own implementation of their interface. 

There is also one class that represents results of trying to shoot one tank. It is important for delivering info to tank who shooted if he penetrated and/or killed tank. Class is called [Shooting Result](src/main/java/org/facade/shooting_result/ShootingResult.java). 

## TEAM FACADE
Finally, we have [Team](src/main/java/org/facade/team_facade/Team.java) class that represents facade. This class is using all funcionalities of subclasses (all tank classes) to deliver functions that are easy to use in game driver (**Main**). Team class has instances of all 3 types of tanks.
### Methods of team class:
- int getCurrentTeamHP() - returns current team HP
- Tank getDefender() - returns random tank to defend team from attack
- boolean isTeamDestroyed() - returns true if team is destroyed
- boolean isLightDestroyed() - returns true if light tank in team is destroyed
- boolean isMediunDestroyed() - returns true if medium tank in team is destroyed
- boolean isHeavyDestroyed() - returns true if heavy tank in team is destroyed
- void shootWithLightTank(Tank tank) - light tank of team attempt to shoot defender tank that is referenced as an argument of function
- void shootWithMediumTank(Tank tank) - medium tank of team attempt to shoot defender tank that is referenced as an argument of function
- void shootWithHeavyTank(Tank tank) - heavy tank of team attempt to shoot defender tank that is referenced as an argument of function
- String toString() - returns string info about current team state

## Rules of the game
Rules are very simple. There are 2 teams. Each team have one chance in each round to inflict damage to enemy team. Through console team can decide with which tank they want to shoot. Enemy team with **getDefender()** method gets their random defender for that round. After each round results of each team are displayed.
When all tanks of one team are destroyed winner is announced. Driver class is called [Main](src/main/java/org/facade/Main.java).
