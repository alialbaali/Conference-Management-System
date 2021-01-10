package com.confy.app.paper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;



import com.confy.app.databinding.FragmentPaperBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PaperFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaperFragment extends Fragment {
    FragmentPaperBinding binding;
    PaperViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPaperBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(PaperViewModel.class);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setViewModel(viewModel);



        return binding.getRoot();
    }
}