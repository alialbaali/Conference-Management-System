package com.confy.app.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.confy.app.databinding.FragmentConferenceListBinding;
import com.confy.app.models.Conference;

public class ConferenceListFragment extends Fragment implements ConferenceListAdapter.ItemListener {
    FragmentConferenceListBinding binding;
    ConferenceListViewModel viewModel;
    ConferenceListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentConferenceListBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        viewModel = new ViewModelProvider(this).get(ConferenceListViewModel.class);
        adapter = new ConferenceListAdapter(this);


        setupObservers();
        setupListeners();

        return binding.getRoot();
    }


    private void setupObservers() {
        viewModel.getConferences().observe(getViewLifecycleOwner(), conferences -> {
            adapter.submitList(conferences);
        });
    }

    private void setupListeners() {
        binding.fab.setOnClickListener(view ->
                NavHostFragment.findNavController(this)
                        .navigate(ConferenceListFragmentDirections
                                .actionConferenceListFragmentToCreateConferenceFragment()
                        )
        );
    }

    @Override
    public void onClick(Conference conference) {
        NavHostFragment.findNavController(this);
//                .navigate();
    }

}