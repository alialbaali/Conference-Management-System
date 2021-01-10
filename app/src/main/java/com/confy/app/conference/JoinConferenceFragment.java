package com.confy.app.conference;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.confy.app.databinding.FragmentJoinConferenceBinding;

public class JoinConferenceFragment extends Fragment {
    FragmentJoinConferenceBinding binding;

    ConferenceViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentJoinConferenceBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(ConferenceViewModel.class);

        return binding.getRoot();
    }
}