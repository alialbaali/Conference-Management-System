package com.confy.app.list;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.confy.app.models.Conference;

public class ConferenceItemDiffCallback extends DiffUtil.ItemCallback<Conference> {

    @Override
    public boolean areItemsTheSame(@NonNull Conference oldItem, @NonNull Conference newItem) {
        return oldItem.id.equals(newItem.id);
    }

    @Override
    public boolean areContentsTheSame(@NonNull Conference oldItem, @NonNull Conference newItem) {
        return oldItem.equals(newItem);
    }
}
