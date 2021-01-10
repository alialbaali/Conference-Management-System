package com.confy.app.list;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.confy.app.databinding.ItemConferenceBinding;
import com.confy.app.models.Conference;

public class ConferenceItemViewHolder extends RecyclerView.ViewHolder {
    ItemConferenceBinding binding;
    ConferenceListAdapter.ItemListener listener;

    Conference conference;

    public ConferenceItemViewHolder(ItemConferenceBinding binding, ConferenceListAdapter.ItemListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;

        binding.getRoot().setOnClickListener(view ->
                listener.onClick(conference)
        );
    }

    public static ConferenceItemViewHolder create(ViewGroup parent, ConferenceListAdapter.ItemListener listener) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemConferenceBinding binding = ItemConferenceBinding.inflate(layoutInflater, parent, false);

        return new ConferenceItemViewHolder(binding, listener);
    }

    public void bind(Conference conference) {
        binding.setConference(conference);
        binding.executePendingBindings();
    }
}
