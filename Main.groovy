
Room startingRoom =  new Room(
    roomID: 1,
    title: "EastTowerRoom",
    description:'This is Room ET'
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

Map<Integer,Room> rooms = [1:startingRoom, 2:roomTwo, 3:roomThree, 4:roomFour, 5:roomFive]





Boolean keepPlaying = true
while (keepPlaying){
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        }

    println "Enter room number: "
    def userInput = br.readLine()

    if (userInput == 'q') {
        println "Quitting"
        keepPlaying = false
    }else if (userInput) {
        println "Choice cannot be blank. Please try again"
    }else if (userInput.isInput()) {
        println "Enter room number"
        else {
            Room room = rooms.get(userInput as Integer)

            if (room) {
                println "Welcome to " + room.title
                else {
                    println "Sorry, this room doesn't exist"
                }
            }
        }


    }