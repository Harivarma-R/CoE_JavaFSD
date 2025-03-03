import java.util.*;
class RoomScheduler {
    private Map<String, MeetingRoom> meetingRooms;

    public RoomScheduler() {
        this.meetingRooms = new HashMap<>();
    }

    // Add a new meeting room to the scheduler
    public void addMeetingRoom(MeetingRoom room) {
        meetingRooms.put(room.getRoomId(), room);
        System.out.println("Room added: " + room.getRoomName() + ", ID: " + room.getRoomId());
    }

    // Book a room if it meets the required features
    public void bookRoom(String roomId, Set<String> requiredFeatures) {
        MeetingRoom room = meetingRooms.get(roomId);
        if (room != null && room.getFeatures().containsAll(requiredFeatures)) {
            System.out.println("Room " + roomId + " booked successfully.");
        } else {
            System.out.println("Room " + roomId + " does not meet the required features.");
        }
    }

    // List available rooms that match all the specified features
    public void listAvailableRooms(Set<String> requiredFeatures) {
        List<String> availableRooms = new ArrayList<>();
        for (MeetingRoom room : meetingRooms.values()) {
            if (room.getFeatures().containsAll(requiredFeatures)) {
                availableRooms.add(room.getRoomName());
            }
        }
        System.out.println("Available rooms with " + requiredFeatures + ": " + availableRooms);
    }
}
