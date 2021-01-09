package com.confy.app.conference;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.confy.app.databinding.FragmentCreateConferenceBinding;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateConferenceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateConferenceFragment extends Fragment {

    FragmentCreateConferenceBinding binding;

    ConferenceViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCreateConferenceBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(ConferenceViewModel.class);

        setupObservers();
        setupTextListeners();

        binding.btnCreate.setOnClickListener(view -> Snackbar.make(binding.getRoot(), "Creating Conference Button clicked", Snackbar.LENGTH_INDEFINITE)
                .show());


        return binding.getRoot();
    }


    private void setupObservers() {
        viewModel.getTitle().observe(getViewLifecycleOwner(), title ->
                binding.etTitle.setText(title)
        );

        viewModel.getDescription().observe(getViewLifecycleOwner(), description ->
                binding.etDescription.setText(description)
        );


    }

    private void setupTextListeners() {

        binding.etTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.setTitle(s.toString());
                binding.etTitle.setSelection(s.length());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.etDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.setDescription(s.toString());
                binding.etDescription.setSelection(s.length());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }
}
