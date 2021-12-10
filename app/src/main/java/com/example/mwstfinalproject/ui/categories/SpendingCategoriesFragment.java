package com.example.mwstfinalproject.ui.categories;

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
import com.example.mwstfinalproject.databinding.FragmentSpendingCategoriesBinding;
import com.example.mwstfinalproject.ui.history.SpendingHistoryViewModel;

public class SpendingCategoriesFragment extends Fragment {

    private SpendingCategoriesViewModel spendingCategoriesViewModel;
    private FragmentSpendingCategoriesBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        spendingCategoriesViewModel =
                new ViewModelProvider(this).get(SpendingCategoriesViewModel.class);

        binding = FragmentSpendingCategoriesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}