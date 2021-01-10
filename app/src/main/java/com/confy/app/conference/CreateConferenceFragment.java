package com.confy.app.conference;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.confy.app.BaseBottomSheetDialogFragment;
import com.confy.app.R;
import com.confy.app.databinding.FragmentCreateConferenceBinding;
import com.google.android.material.snackbar.Snackbar;

public class CreateConferenceFragment extends BaseBottomSheetDialogFragment {

    private FragmentCreateConferenceBinding binding;

    private CreateConferenceViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCreateConferenceBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(CreateConferenceViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());

        binding.btnCreate.setOnClickListener(view -> {
                    String title = binding.etTitle.toString();
                    String description = binding.etDescription.toString();

                    if (title.isEmpty()) {
                        binding.tilTitle.setError(getString(R.string.empty_title));
                    }
                    if (description.isEmpty()) {
                        binding.tilDescription.setError(getString(R.string.empty_description));
                    }

                    if (!title.isEmpty() && !description.isEmpty())
                        viewModel.createConference();
                }
        );

        viewModel.getError().observe(getViewLifecycleOwner(), error -> {
            if (!error.isEmpty()) {
                Snackbar.make(binding.getRoot(), error, Snackbar.LENGTH_SHORT);
            }
        });
        viewModel.getShouldNavigate().observe(getViewLifecycleOwner(), shouldNavigate -> {
                    if (shouldNavigate) {
                
                    }
                }
        );

        return binding.getRoot();
    }

}
