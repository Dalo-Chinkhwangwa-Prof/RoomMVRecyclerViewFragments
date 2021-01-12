package com.americanairlines.myseventhappfrag.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.americanairlines.myseventhappfrag.R;
import com.americanairlines.myseventhappfrag.model.data.Guest;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.GuestViewHolder> {

    private List<Guest> guestList;

    public GuestAdapter(List<Guest> guestList) {
        this.guestList = guestList;
    }

    public void updateGuests(List<Guest> guests){
        guestList = guests;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.guest_item_layout, parent, false);
        return new GuestViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestViewHolder holder, int position) {
        Guest currentGuest = guestList.get(position);
        holder.guestNameTextView.setText(currentGuest.getGuestName());
        holder.guestRoomTextView.setText(currentGuest.getRoomNumber());
    }

    @Override
    public int getItemCount() {
        return guestList.size();
    }

    class GuestViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.guest_name_textview)
        TextView guestNameTextView;

        @BindView(R.id.guest_room_textview)
        TextView guestRoomTextView;

        public GuestViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}








