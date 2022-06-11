package com.example.els.view.games;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.els.R;
import com.example.els.adapter.HistoryAdapter;
import com.example.els.databinding.FragmentPlayHistoryBinding;
import com.example.els.models.games.History;
import com.example.els.viewmodel.games.HistoryViewModel;

import java.util.ArrayList;

public class PlayHistoryFragment extends Fragment {
    private FragmentPlayHistoryBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPlayHistoryBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize history view model
        HistoryViewModel historyViewModel = new ViewModelProvider(requireActivity()).get(HistoryViewModel.class);

        // Fetch data when the user get into the history fragment
        historyViewModel.fetchHistories();

        historyViewModel.histories().observe(getViewLifecycleOwner(), this::setupHistoryRecyclerView);

        binding.backButton.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_playHistoryFragment_to_gamesFragment));
    }

    public void setupHistoryRecyclerView(ArrayList<History> histories) {
        RecyclerView recyclerView = binding.historyRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        HistoryAdapter adapter = new HistoryAdapter(histories);
        recyclerView.setAdapter(adapter);
    }
}