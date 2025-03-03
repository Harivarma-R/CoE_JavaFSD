import java.util.*;
public class MeetingRoomBookingSystem {
    public static void main(String[] args) {
        RoomScheduler scheduler = new RoomScheduler();
        
        scheduler.addMeetingRoom(new MeetingRoom("001", "Boardroom", 20, 
                new HashSet<>(Arrays.asList("PROJECTOR", "CONFERENCE_PHONE", "AIR_CONDITIONING"))));
        scheduler.addMeetingRoom(new MeetingRoom("002", "Strategy Room", 10, 
                new HashSet<>(Arrays.asList("WHITEBOARD", "AIR_CONDITIONING"))));

        scheduler.bookRoom("001", new HashSet<>(Arrays.asList("PROJECTOR", "CONFERENCE_PHONE")));
        scheduler.listAvailableRooms(new HashSet<>(Arrays.asList("AIR_CONDITIONING")));
    }
}
