package com.americanairlines.myseventhappfrag.presenter;

import androidx.room.Room;

import com.americanairlines.myseventhappfrag.model.data.Guest;
import com.americanairlines.myseventhappfrag.model.db.HotelDatabase;
import com.americanairlines.myseventhappfrag.presenter.HotelPresenterContract.HotelView;

import static com.americanairlines.myseventhappfrag.model.db.HotelDatabase.DATABASE_NAME;

public class HotelPresenter implements HotelPresenterContract.HotelPresenter {

    private HotelView view;

    private HotelDatabase hotelDatabase;


    public HotelPresenter(HotelView view) {
        this.view = view;
        hotelDatabase = Room.databaseBuilder(
                view.getContext(),
                HotelDatabase.class,
                DATABASE_NAME
        ).build();
    }

    @Override
    public void checkInGuest(Guest guest) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                hotelDatabase.getGuestDAO().insertGuest(guest);
                view.displaySuccess("Guest checked in!");
            }
        }.start();
    }

    @Override
    public void checkOutGuest(Guest guest) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                hotelDatabase.getGuestDAO().checkoutGuest(guest);
                view.displaySuccess("Guest checked out! - Must leave by 11:00am");
            }
        }.start();
    }

    @Override
    public void getAllGuests() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                view.displayGuests(hotelDatabase.getGuestDAO().getAllGuests());
            }
        }.start();
    }
}
















