package com.example.els.view.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.els.R;
import com.example.els.databinding.FragmentLessonDetailBinding;
import com.example.els.models.Api.Listening;
import com.example.els.models.Api.ListeningQuestion;
import com.example.els.viewmodel.home.ListeningViewModel;

import java.util.List;

public class LessonDetailFragment extends Fragment {
    private ListeningViewModel listeningViewModel;
    private FragmentLessonDetailBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLessonDetailBinding.inflate(inflater, container, false);
        listeningViewModel = new ViewModelProvider(requireActivity()).get(ListeningViewModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setObserver();

        // Handle back event
        binding.backBtn.setOnClickListener(this::onBackButtonPressed);
        binding.startButton.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.action_lessonDetailFragment_to_listeningQuestionFragment));

        listeningViewModel.getAnswerMap().clear();
    }

    private void setObserver() {
        //Observer of title, content, set list question of lesson - it set value when I click the lesson;
        final Observer<List<Listening>> listObserver = data -> {
            Log.d("listening", String.valueOf(listeningViewModel.getPosition()));
            listeningViewModel.getDataListeningQuestionByLesson(data.get(listeningViewModel.getPosition()).getUuid());
            listeningViewModel.setTitle(data.get(listeningViewModel.getPosition()).getTitle());
            listeningViewModel.setContent(data.get(listeningViewModel.getPosition()).getContent());
            listeningViewModel.setImage(data.get(listeningViewModel.getPosition()).getImage());
            listeningViewModel.setListening(data.get(listeningViewModel.getPosition()));
        };
        listeningViewModel.getUnDoneListening().observe(getViewLifecycleOwner(), listObserver);

        //Observer of list question of lesson
        final Observer<List<ListeningQuestion>> listQuestionObserver = data -> binding.gifEmpty.setVisibility(View.GONE);
        listeningViewModel.getListeningQuestionLiveData().observe(getViewLifecycleOwner(), listQuestionObserver);

        //Observer of title - auto set when I click the lesson.
        final Observer<String> titleObserver = binding.title::setText;
        this.listeningViewModel.getTitle().observe(getViewLifecycleOwner(), titleObserver);

        //Observer of content - auto set when I click the lesson.
        final Observer<String> contentObserver = binding.content::setText;
        this.listeningViewModel.getContent().observe(getViewLifecycleOwner(), contentObserver);


        //Observer of image - auto set when I click the lesson.
        final Observer<String> imageObserver = s -> Glide.with(this).load(s).into(binding.lessonImage);
        this.listeningViewModel.getImage().observe(getViewLifecycleOwner(), imageObserver);
    }

    public void onBackButtonPressed(View view) {
        Navigation.findNavController(view).navigate(R.id.action_lessonDetailFragment_to_skillsFragment);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}