package lab3;

import java.util.Objects;

public class Room {
    private final String roomId;
    private final String type;
    private final double pricePerNight;

    public Room(String roomId, String type, double pricePerNight) {
        this.roomId = roomId;
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    public Room() {
        this.roomId = null;
        this.type = null;
        this.pricePerNight = 0.0;
    }

    public String getRoomId() { return roomId; }
    public String getType() { return type; }
    public double getPricePerNight() { return pricePerNight; }

    @Override
    public String toString() {
        return "Room{" +
                "roomId='" + roomId + '\'' +
                ", type='" + type + '\'' +
                ", pricePerNight=" + pricePerNight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(roomId, room.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId);
    }
}
