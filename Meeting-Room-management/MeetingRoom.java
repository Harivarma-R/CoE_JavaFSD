import java.util.*;

// Class representing a meeting room
class MeetingRoom {
    private String roomId;
    private String roomName;
    private int capacity;
    private Set<String> features;

    public MeetingRoom(String roomId, String roomName, int capacity, Set<String> features) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.capacity = capacity;
        this.features = features;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public Set<String> getFeatures() {
        return features;
    }

    @Override
    public String toString() {
        return roomName;
    }
}
