package com.americanairlines.myseventhappfrag.presenter;

import android.content.Context;

import com.americanairlines.myseventhappfrag.model.data.Guest;

import java.util.List;

public interface HotelPresenterContract {

    interface HotelPresenter{
        void checkInGuest(Guest guest);
        void checkOutGuest(Guest guest);
        void getAllGuests();
    }

    interface HotelView {
        void displayGuests(List<Guest> guestList);
        void displaySuccess(String message);
        Context getContext();
    }

}
