package com.nilhcem.droidconit.data.app.model;

import android.support.annotation.NonNull;

public enum Room {

    NONE(0, ""),
    SALA_500(1, "Sala 500"),
    LONDRA_210(2, "Sala Londra"),
    MADRID_120(3, "Sala Madrid"),
    PARIGI_75(4, "Sala Parigi");

    public final int id;
    public final String name;

    Room(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Room getFromId(int id) {
        for (Room room : Room.values()) {
            if (room.id == id) {
                return room;
            }
        }
        return NONE;
    }

    public static Room getFromName(@NonNull String name) {
        for (Room room : Room.values()) {
            if (name.equals(room.name)) {
                return room;
            }
        }
        return NONE;
    }
}
