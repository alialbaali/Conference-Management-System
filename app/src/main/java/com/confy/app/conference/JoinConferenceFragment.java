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
import com.confy.app.databinding.FragmentJoinConferenceBinding;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JoinConferenceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JoinConferenceFragment extends Fragment {
    FragmentJoinConferenceBinding binding;

    ConferenceViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentJoinConferenceBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(ConferenceViewModel.class);

        setupObservers();
        setupTextListeners();

        binding.btnJoin.setOnClickListener(view -> Snackbar.make(binding.getRoot(), "Creating Conference Button clicked", Snackbar.LENGTH_INDEFINITE)
                .show());


        return binding.getRoot();
    }
    private void setupObservers() {
        viewModel.getInvitationLink().observe(getViewLifecycleOwner(), InvitationLink ->
                binding.etInvitationLink.setText(InvitationLink)
        );



    }

    private void setupTextListeners() {

        binding.etInvitationLink.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.setInvitationLink(s.toString());
                binding.etInvitationLink.setSelection(s.length());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }



}