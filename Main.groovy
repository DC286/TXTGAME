MainPlayer MainPlayer = new MainPlayer(
        health: 100,
        remainingHealth: 100,
        multiplier: 5,

)
Npc Survivor = new Npc (
        name: "Haven",
        health: 25,
        isAggressive: false,
        multiplier: 0,
        AttackNumber: 0,
        living: true,
        TotalDamage: 0
)
Room startingRoom =  new Room (
    roomID: 1,
    title: "The ruins of Castle Hallsworth",
    description:  "You walk through the damaged gate. You look to your right and see stairs leading up. You look to you left and you see a door. In front of you, you see a man in torn up armor with blood stains leaning against the wall.",
    npc: Survivor
)

Npc goblin = new Npc (
        name: "Grendal",
        health: 65,
        isAggressive: true,
        multiplier: 3,
        AttackNumber:  0,
        living: true,
        TotalDamage: 0
)
Room roomTwo =  new Room (
    roomID: 2,
    title: "Barracks",
    description:  "You've entered the barracks. There's 5 rows of beds. There are corpse's laying in some and others are empty. A jackal and a goblin appear from the beds.",
    npc: goblin
    )
Npc Jackal = new Npc (
        name: "Heathen",
        health: 80,
        isAggressive: true,
        multiplier: 3,
        AttackNumber: 0,
        living: true,
        TotalDamage: 0
)
Room roomThree =  new Room (
    roomID: 3,
    title: "CentralTowerRoom",
    description: "You walk in and see the remnants of a fight. There's a corpse with a missing head laying in the middle of the room. Clutched in its hand is a blood-stained sword.",
    npc: Jackal
    )
Npc  CrazedSoldier  = new Npc (
        name: "Captain Lance",
        health: 85,
        isAggressive: true,
        multiplier: 2,
        AttackNumber: 0,
        living: true,
        TotalDamage: 0
)
Room roomFour = new Room (
    roomID: 4,
    title: "WestTowerRoom",
    description: "You walk in and see a large hole in the wall. There's dried blood splattered on the walls. Laying against an arrow loop on the left side of the room, there's a quiver containing 5 arrows and laying next to it, is a bow.",
    npc: CrazedSoldier
    )

Npc Bandit = new Npc (
        name: "Castile",
        health: 100,
        isAggressive: true,
        multiplier: 3,
        AttackNumber: 0,
        living: true,
        TotalDamage: 0
)
Room roomFive = new Room (
    roomID: 5,
    title: "Armory",
    description: "You enter the armory. There are empty weapon racks on both the right and left sides of the room. In front of you are two empty armor stands. In the between the two armor stands, hangs a cracked shield.",
     npc: Bandit
    )
Npc Ogre = new Npc (
        name: "Ogar",
        health: 100,
        isAggressive: true,
        multiplier: 5,
        AttackNumber: 0,
        living: true,
        TotalDamage: 0
)
Room roomSix = new Room (
        roomID: 6,
        title: "SouthTowerRoom",
        description: "You walk in and see that there's barely any damage done to the room. There're no bodies or blood. You look at the door behind you and pieces of broken wood nailed to the door. ",
        npc: Ogre
        )


List<Npc> npcs = [Ogre,Jackal,goblin,Survivor,CrazedSoldier,Bandit]

Integer count = 0
npcs.each {
    if (it.isAggressive) {
        count ++
    }
}


startingRoom.connections = ['West Watch Tower Room':roomFour, 'Officers Quarters':roomThree]
roomTwo.connections = ['Southern Watch Tower Room':roomSix, 'Officers Quarters':roomThree]
roomThree.connections = ['Southern Watch Tower Room':roomSix, 'West Watch Tower Room':roomFour, 'Barracks':roomTwo, 'Armory': roomFive]
roomFour.connections = ['Officers Quarters':roomThree]
roomFive.connections = ['Officers Quarters':roomThree]
roomSix.connections = ['Officers Quarters':roomThree, 'Barracks':roomTwo]





Boolean keepPlaying = true
Room currentRoom = startingRoom
Scanner scanner = new Scanner (System.in)
Room previousRoom = startingRoom
Integer Deathsofnpcs = 0

while (keepPlaying) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in))


if (MainPlayer.health == 100) {
    println "You're at full health"
} else {
    println "You're at " + MainPlayer.health + "of health"
}

if (currentRoom.npc.AttackNumber == 1) {
    println "${currentRoom.npc.name} has attacked ${currentRoom.npc.AttackNumber} time!"
} else if (currentRoom.npc.AttackNumber > 1) {
        println "${currentRoom.npc.name} has attacked ${currentRoom.npc.AttackNumber} times!"
    }
if (currentRoom.npc.TotalDamage > 0) {
    println "You lost ${currentRoom.npc.TotalDamage} health here"
} else if (currentRoom.npc.TotalDamage < 0) {
    println "You gained ${currentRoom.npc.TotalDamage * -1} health here"
}

if (!currentRoom.npc.isAggressive){
 }else if (currentRoom.npc.isAggressive && currentRoom.npc.living) {
    def keepFighting = true
    while (currentRoom.npc.living && MainPlayer.health > 0 && keepFighting) {
        Random rand = new Random()
        int max = 10
        def randomIntegerList = []
        (1..5).each {
            randomIntegerList << rand.nextInt(max) + 1
        }
        if (randomIntegerList[0] % 2 == 1) {
            MainPlayer.health = MainPlayer.health - (randomIntegerList[1] * currentRoom.npc.multiplier)
            currentRoom.npc.TotalDamage = currentRoom.npc.TotalDamage + (randomIntegerList[1] * currentRoom.npc.multiplier)
            currentRoom.npc.AttackNumber++
            if (MainPlayer.health <= 0) {
                println currentRoom.npc.name + "attacked"
                println "You've been slain by " + currentRoom.npc.name
                keepPlaying = false
                keepFighting = false
            } else {
                println currentRoom.npc.name + " attacked. Your health is now at " + MainPlayer.health
                print "Press any key  to move on..."
                scanner.nextLine()
                println()
            }
            MainPlayer.remainingHealth = MainPlayer.health
        } else if (randomIntegerList[0] % 2 == 0) {
            boolean keepGivenChoice = true
            while (keepGivenChoice) {
                print "Do you wish to run[r] or to fight[f]?: "
                def userInput = br.readLine()
                if (userInput == "f") {
                    keepGivenChoice = false
                    currentRoom.npc.health = currentRoom.npc.health - (randomIntegerList[1] * MainPlayer.multiplier)
                    println "You've inflicted ${randomIntegerList[1] * MainPlayer.multiplier} on ${currentRoom.npc.name}"
                    if (currentRoom.npc.health <= 0) {
                        println "You've slain " + currentRoom.npc.name
                        currentRoom.npc.living = false


                    } else {
                        println currentRoom.npc.name + "'s health is " + currentRoom.npc.health
                    }
                    print "Press any key to move on"
                    scanner.nextLine()
                    println()
                    if (MainPlayer.health == 100) {
                        println "You're at full health"

                        println "You've acquired health"
                        MainPlayer.health = MainPlayer.health + (randomIntegerList[2] * player.multiplier)
                        if (MainPlayer.health > 100) {
                            MainPlayer.health = 100
                        }
                        println "You have ${Mainplayer.health} out of 100 health"

                        currentRoom.npc.TotalDamage = currentRoom.npc.TotalDamage + (MainPlayer.remainingHealth - MainPlayer.health)

                        print "Press any key to move on"
                        scanner.nextLine()
                        println()

                    }
                } else if (userInput == "r") {
                    keepGivenChoice = false
                    println "You've decided to run."
                    currentRoom = previousRoom
                    println currentRoom.description
                    keepFighting = false
                    print "Press any key to move on"
                    scanner.nextLine()
                    println()
                } else if (userInput == "q") {
                    keepGivenChoice = false
                    keepFighting = false
                    keepPlaying = false
                    println "Quitting..."
                }
            }
        }
    }
    if (!currentRoom.npc.living) {
        println currentRoom.npc.name + "is dead"
    }
}else {
    println currentRoom.npc.name + "is dead"
}
    if (!keepPlaying) {
}else if (Deathsofnpcs == count) {
    println()
    println "You've defeated ${currentRoom.npc.name}!"
    println()
    print "Press any key to move on"
    scanner.nextLine()
    keepPlaying = false

} else {
    println "You've entered " + currentRoom.title
    println currentRoom.description
    println "Rooms: " + currentRoom.connections.keySet()
    print "Which room would you like to enter?  "
    def userInput = br.readLine()
    if (userInput== 'q') {
    println "Quitting game"
    keepPlaying = false
    } else {
        Room room = currentRoom.connections.get(userInput)
        if (room) {
            currentRoom = room
        }
    }
}

}




