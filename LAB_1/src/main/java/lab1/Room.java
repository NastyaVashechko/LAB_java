package lab1;

import java.util.Objects;

/**
 * Клас Room представляє номер готелю.
 */
public class Room {
    private String type;
    private int bedCount;
    private int roomNumber;
    private String amenities;

    // Патерн Builder для створення об'єктів Room
    public static class Builder {
        private String type;
        private int bedCount;
        private int roomNumber;
        private String amenities;

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setBedCount(int bedCount) {
            this.bedCount = bedCount;
            return this;
        }

        public Builder setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        public Builder setAmenities(String amenities) {
            this.amenities = amenities;
            return this;
        }

        public Room build() {
            return new Room(this);
        }
    }

    private Room(Builder builder) {
        this.type = builder.type;
        this.bedCount = builder.bedCount;
        this.roomNumber = builder.roomNumber;
        this.amenities = builder.amenities;
    }

    @Override
    public String toString() {
        return "Room{" +
                "type='" + type + '\'' +
                ", bedCount=" + bedCount +
                ", roomNumber=" + roomNumber +
                ", amenities='" + amenities + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Room room = (Room) obj;
        return bedCount == room.bedCount &&
                roomNumber == room.roomNumber &&
                type.equals(room.type) &&
                amenities.equals(room.amenities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, bedCount, roomNumber, amenities);
    }

    // Геттери
    public String getType() { return type; }
    public int getBedCount() { return bedCount; }
    public int getRoomNumber() { return roomNumber; }
    public String getAmenities() { return amenities; }
}

