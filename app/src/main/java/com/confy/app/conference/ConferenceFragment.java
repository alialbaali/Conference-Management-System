package com.confy.app.conference;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.confy.app.databinding.FragmentConferenceBinding;

public class ConferenceFragment extends Fragment {

    FragmentConferenceBinding binding;

    ConferenceViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentConferenceBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(ConferenceViewModel.class);
      //  binding.setViewModel(viewModel);
       // binding.setLifecycleOwner(getViewLifecycleOwner());



        return binding.getRoot();
    }
}
