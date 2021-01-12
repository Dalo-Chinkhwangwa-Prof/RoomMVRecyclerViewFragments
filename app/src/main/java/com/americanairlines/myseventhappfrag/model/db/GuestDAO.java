package com.americanairlines.myseventhappfrag.model.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.americanairlines.myseventhappfrag.model.data.Guest;

import java.util.List;

@Dao
public interface GuestDAO {

    @Insert
    public void insertGuest(Guest... newGuest); //insertGuest(g1) or... insertGuest(g1, g2);

    @Delete
    public void checkoutGuest(Guest... oldGuest);

    @Query("SELECT * FROM Guest WHERE guest_id = :guestID")
    public Guest getGuest(int guestID);

    @Query("SELECT * FROM Guest")
    public List<Guest> getAllGuests();

    @Update
    public void updateGuest(Guest guest);
}














