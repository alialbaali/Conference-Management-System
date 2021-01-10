package com.confy.app.conference;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.confy.app.databinding.FragmentCreateConferenceBinding;

public class CreateConferenceFragment extends Fragment {

    FragmentCreateConferenceBinding binding;

    CreateConferenceViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCreateConferenceBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(CreateConferenceViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());

        binding.btnCreate.setOnClickListener(view ->
                viewModel.createConference()
        );

        return binding.getRoot();
    }

}
