package com.example.mwstfinalproject.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mwstfinalproject.R;
import com.example.mwstfinalproject.databinding.FragmentSpendingHistoryBinding;

public class SpendingHistoryFragment extends Fragment {

    private SpendingHistoryViewModel spendingHistoryViewModel;
    private FragmentSpendingHistoryBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        spendingHistoryViewModel =
                new ViewModelProvider(this).get(SpendingHistoryViewModel.class);

        binding = FragmentSpendingHistoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}