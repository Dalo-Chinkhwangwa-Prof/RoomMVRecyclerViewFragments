package com.americanairlines.myseventhappfrag.view;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.americanairlines.myseventhappfrag.R;
import com.americanairlines.myseventhappfrag.model.data.Guest;
import com.americanairlines.myseventhappfrag.presenter.HotelPresenterContract;
import com.americanairlines.myseventhappfrag.presenter.HotelPresenterContract.HotelPresenter;
import com.americanairlines.myseventhappfrag.presenter.HotelPresenterContract.HotelView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements HotelView {

    private HotelPresenter presenter;

    private GuestListFragment guestListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guestListFragment = (GuestListFragment) getSupportFragmentManager().finRdFragmentById(R.id.main_fragment);

        presenter = new com.americanairlines.myseventhappfrag.presenter.HotelPresenter(this);

        Guest g1 = new Guest("Dalo", "Room01", "https://avatars0.githubusercontent.com/u/47256641?s=400&u=fe496dc4ea2e44c277604b84a273a8128b856f1f&v=4");
        Guest g2 = new Guest("Sara", "Room21", "https://play-lh.googleusercontent.com/a-/AOh14GiPLvgx7aw8zBxRCt3fLhYeiGVkdBYqZ56Zk1VOhg=w96-h96-n-rw");
        Guest g3 = new Guest("Amber", "Room51", "https://play-lh.googleusercontent.com/a-/AOh14GiPLvgx7aw8zBxRCt3fLhYeiGVkdBYqZ56Zk1VOhg=w96-h96-n-rw");
        Guest g4 = new Guest("Victor", "Room101", "https://play-lh.googleusercontent.com/a-/AOh14GiPLvgx7aw8zBxRCt3fLhYeiGVkdBYqZ56Zk1VOhg=w96-h96-n-rw");

        presenter.checkInGuest(g1);
        presenter.checkInGuest(g2);
        presenter.checkInGuest(g3);
        presenter.checkInGuest(g4);

        presenter.getAllGuests();
    }

    @Override
    public void displayGuests(List<Guest> guestList) {
        guestListFragment.displayList(guestList);
    }

    @Override
    public void displaySuccess(String message) {

    }

    @Override
    public Context getContext() {
        return this;
    }
}