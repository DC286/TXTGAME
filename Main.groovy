
Room startingRoom =  new Room(
    roomID: 1,
    title: "The ruins of Hallsworth",

    description: ''''You walk through the damaged gate. You look to your right and you see stairs lead up. You look to you left and you see a door.'''
)

Room roomTwo =  new Room (
    roomID: 2,
    title: "Barracks",
    description: ''' You've entered the barracks. There's 5 rows of beds. There's corpse's laying in some and in others are empty. In one bed lies a dented suit of armor.'''

    )

Room   roomThree =  new Room (
    roomID: 3,
    title: "CentralTowerRoom",
    description: '''You walk in and see what looks like the remains of a fight. There's a corpse with a missing head laying in the middle of the room. In the corpse's hand is a blood-stained sword.'''
    )

Room  roomFour = new Room (
    roomID: 4,
    title: "WestTowerRoom",
    description: '''You walk in and see a big hole in the wall. There's dried blood along the walls. In front of one of the arrow loops There is quiver with 5 arrows remaining and a bow.'''
    )

Room  roomFive = new Room (
    roomID: 5,
    title: "Armory",
    description: '''You enter the armory. You see empty racks that used to have weapons. On the wall in front of you there is a cracked shield'''
    )
Room roomSix = new Room (
        roomID: 6,
        title: "SouthTowerRoom",
        description: '''You walk in see that there's barely any damage to the room and no gore or blood.'''
)


startingRoom.connections = ['e':roomThree, 'w':roomFour]
roomTwo.connections = ['s':roomSix, 'n':roomThree]
roomThree.connections = ['s':roomSix, 'w':roomFour, 'se':roomTwo]
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




