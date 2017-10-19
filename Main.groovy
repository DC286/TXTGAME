List Room = [Room1, Room2, Room3, Room4, Room5]
Room Room1 =  new Room(
    roomID: 1,
    roomName: "EastTowerRoom",
    roomDescription:'This is Room ET'
)

Room Room2 =  new Room (
    roomID: 2,
    roomName: "Barracks",
    roomDescription: 'This is Room B'
    )

Room  Room3 =  new Room (
    roomID: 3,
    roomName: "CentralTowerRoom",
    roomDescription: 'This is Room CT'
    )

Room  Room4 = new Room (
    roomID: 4,
    roomName: "WestTowerRoom",
    roomDescription: 'This is Room WT'
    )

Room  Room5= new Room (
    roomID: 5,
    roomName: "Cellar",
    roomDescription: 'This is the room below Room B'
    )

Map<Integer,Room> rooms = [1:Room1, 2:Room2, 3:Room4, 4:Room4, 5:Room5]





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
                print "Welcome to " + room.ID
                else {
                    println "Sorry, this room doesn't exist"
                }
            }
        }


    }