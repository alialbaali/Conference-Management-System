package com.confy.app.list;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;

import com.confy.app.models.Conference;

public class ConferenceListAdapter extends ListAdapter<Conference, ConferenceItemViewHolder> {
    ItemListener listener;

    public ConferenceListAdapter(ItemListener listener) {
        super(new ConferenceItemDiffCallback());
        this.listener = listener;
    }

    @NonNull
    @Override
    public ConferenceItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ConferenceItemViewHolder.create(parent, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ConferenceItemViewHolder holder, int position) {
        Conference conference = getItem(position);
        holder.conference = conference;
        holder.bind(conference);
    }


    public interface ItemListener {
        void onClick(Conference conference);
    }


}
