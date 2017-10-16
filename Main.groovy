List Room = [Room1, Room2, Room3, Room4, Room5]
Room room1 =  Room{
    RoomID = [1]
    RoonName = [EastTowerRoom]
    RoomDescription = ('This is Room ET')

}
Room room2 =  Room{
    RoomID = [2]
    RoomName = [Barracks]
    RoomDescription = ('This is Room B')
}
Room  room3 =  Room{
    RoomID = [3]
    RoomName = [CentralTowerRoom]
    roomDescription = ('This is Room CT')
}
Room  room4 = Room{
    RoomID = [4]
    RoomName = [WestTowerRoom]
    RoomDescription = ('This is Room WT')
}
Room  Room5= Room{
    roomID = [5]
    RoomName = [Cellar]
    RoomDescription = ('This is the room below Room B')
}
Map<Integer,Room> rooms = [1:Room1, 2:Room2, 3:Room4, 4:Room4, 5:Room5]





Boolean keepPlaying = true
while (keepPlaying) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
    print "Enter room number: "
    def userIntput = br.readLine()

    if (userInput == 'q'){
    } else if (userInput) {
        println "User's choice can't be blank. Please try again"
    } else {
        if (userIntput.Integer()) {
            println "Please enter Room Number"
        } else {
            Room room = room1.get(userInput as Integer)

            if (room) {
                println "Welcome to " + room.ID

                 {
                 else  println ("Sorry, this room does not exist")
                }
            }


        }
    }
}