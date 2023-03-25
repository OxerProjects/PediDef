package com.example.pedidef;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CardAdaptor extends ArrayAdapter<Card> {

    // Constructor
    public CardAdaptor(Context context, List<Card> cards) {
        super(context, 0, cards);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflate the view if necessary
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card_view, parent, false);
        }

        // Get the data item for this position
        Card card = getItem(position);

        // Set the title and description of the card
        TextView titleTextView = convertView.findViewById(R.id.title);
        titleTextView.setText(card.getTitle());
        TextView descriptionTextView = convertView.findViewById(R.id.id);
        descriptionTextView.setText(card.getDescription());

        // Return the completed view
        return convertView;
    }

    @Override
    public Card getItem(int position) {
        return super.getItem(position);
    }
}




