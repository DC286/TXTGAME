
Room startingRoom =  new Room(
    roomID: 1,
    title: "CastleEntrance",
    description:'This is CE'
)

Room roomTwo =  new Room (
    roomID: 2,
    title: "Barracks",
    description: 'This is Room B'
    )

Room   roomThree =  new Room (
    roomID: 3,
    title: "CentralTowerRoom",
    description: 'This is Room CT'
    )

Room  roomFour = new Room (
    roomID: 4,
    title: "WestTowerRoom",
    description: 'This is Room WT'
    )

Room  roomFive = new Room (
    roomID: 5,
    title: "Cellar",
    description: 'This is the room below Room B'
    )
Room roomSix = new Room (
        roomID: 6,
        title: "SouthTowerRoom",
        description: "Top floor of the East Tower"
)
Map<Integer,Room> rooms = [1:startingRoom, 2:roomTwo, 3:roomThree, 4:roomFour, 5:roomFive, 6:roomSix]


startingRoom.connections = ['e':CentralTowerRoom, 'w':WestTowerRoom]
roomTwo.connections = ['s':EastTowerRoom, 'n':CentralTowerRoom]
roomThree.connections = ['s':SouthTowerRoom, 'w':WestTowerRoom, 'se':Barracks]
roomFour.connections = ['e':CentralTowerRoom, 's':CastleEntrance]
roomFive.connections = ['s':WestTowerRoom]
roomSix.connections = ['n':CenctralTowerRoom, 'ne':Barracks]


Boolean keepPlaying = true
while (keepPlaying){
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in))

        }

    println "Enter room number: "
    def userInput = br.readLine()

    if (userInput == 'q') {
        println "Quitting"
        keepPlaying = false
    } else if (!userInput) {
        println "Choice cannot be blank. Please try again"
    } else if (userInput.isInput())
        println "Enter room number"
 else {
    Room room = room.get(UserInput as Integer)

    if (room){
        println "This Room doesn't exist"
    }
}


