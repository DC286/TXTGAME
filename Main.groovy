
Room startingRoom =  new Room(
    roomID: 1,
    title: "the ruins of Castle Hallworth",
    description: ''' You walk through the damaged gate. You look to your right and see stairs leading up. You look to you left and you see a door. '''
)

Room roomTwo =  new Room (
    roomID: 2,
    title: "Barracks",
    description: ''' You've entered the barracks. There's 5 rows of beds. There are corpse's laying in some and others are empty. In one bed lies a dented suit of armor. '''

    )

Room   roomThree =  new Room (
    roomID: 3,
    title: "CentralTowerRoom",
    description: ''' You walk in and see the remnants of a fight. There's a corpse with a missing head laying in the middle of the room. Clutched in its hand is a blood-stained sword. '''
    )

Room  roomFour = new Room (
    roomID: 4,
    title: "WestTowerRoom",
    description: ''' You walk in and see a large hole in the wall. There's dried blood splattered on the walls. Laying against an arrow loop on the left side of the room, there's a quiver containing 5 arrows and laying next to it, is a bow. '''
    )

Room  roomFive = new Room (
    roomID: 5,
    title: "Armory",
    description: ''' You enter the armory. There are empty weapon racks on both the right and left sides of the room. In front of you are two empty armor stands. In the between the two armor stands, hangs a cracked shield. '''
    )
Room roomSix = new Room (
        roomID: 6,
        title: "SouthTowerRoom",
        description: ''' You walk in and see that there's barely any damage done to the room. There're no bodies or blood. You look at the door behind you and pieces of broken wood nailed to the door. '''
)


startingRoom.connections = ['w':roomFour, 'e':roomThree]
roomTwo.connections = ['s':roomSix, 'n':roomThree]
roomThree.connections = ['s':roomSix, 'w':roomFour, 'se':roomTwo, 'n': roomFive]
roomFour.connections = ['e':roomThree]
roomFive.connections = ['s':roomThree]
roomSix.connections = ['n':roomThree, 'ne':roomTwo]

Boolean keepPlaying = true
Room currentRoom = startingRoom

while (keepPlaying) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
    println "This is the " + currentRoom.title
    println currentRoom.description
    println "Exits: " + currentRoom.connections.keySet()

    print "Enter the direction you want to go: "

    def userInput = br.readLine()
      if (userInput == 'q') {
          println "exiting game"
          keepPlaying = false


      } else {
          Room room = currentRoom.connections.get(userInput)
          if (room) {
              currentRoom = room
          }


      }






}




