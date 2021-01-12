package com.americanairlines.myseventhappfrag.model.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.americanairlines.myseventhappfrag.model.data.Guest;

@Database(version = 1, entities = {Guest.class})
public abstract class HotelDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "hotel.db";
    public abstract GuestDAO getGuestDAO();
}
