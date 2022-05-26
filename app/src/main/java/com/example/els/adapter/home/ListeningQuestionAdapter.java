package com.example.els.adapter.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.els.R;
import com.example.els.models.Api.ListeningQuestion;
import com.google.android.material.radiobutton.MaterialRadioButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ListeningQuestionAdapter extends RecyclerView.Adapter<ListeningQuestionAdapter.ViewHolder> {
    private final ArrayList<ListeningQuestion> listeningQuestions = new ArrayList<>();
    private Context context;

    public ListeningQuestionAdapter(Context context, List<ListeningQuestion> list) {
        this.listeningQuestions.addAll(list);
        this.context = context;
        Log.d("listening", "size nè" + String.valueOf(list.size()));
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listening_question, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListeningQuestion listeningQuestion = listeningQuestions.get(position);
        holder.lqHeader.setText(listeningQuestion.getContent());
        int answerIndex = getRandomNumber(1, 4);
        getAnswer(answerIndex, holder, listeningQuestion);
    }

    @Override
    public int getItemCount() {
        return listeningQuestions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView lqHeader;
        private final MaterialRadioButton materialRadioButton1;
        private final MaterialRadioButton materialRadioButton2;
        private final MaterialRadioButton materialRadioButton3;
        private final MaterialRadioButton materialRadioButton4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lqHeader = itemView.findViewById(R.id.item_lq_1);
            materialRadioButton1 = itemView.findViewById(R.id.lq_answer_1);
            materialRadioButton2 = itemView.findViewById(R.id.lq_answer_2);
            materialRadioButton3 = itemView.findViewById(R.id.lq_answer_3);
            materialRadioButton4 = itemView.findViewById(R.id.lq_answer_4);
        }
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void getAnswer(int answerIndex, ViewHolder holder, ListeningQuestion listeningQuestion) {
        switch (answerIndex){
            case 1:
                holder.materialRadioButton1.setText(listeningQuestion.getAnswer());

                randomRestOfAnswer(listeningQuestion, holder, answerIndex);
                break;
            case 2:
                holder.materialRadioButton2.setText(listeningQuestion.getAnswer());

                randomRestOfAnswer(listeningQuestion, holder, answerIndex);
                break;
            case 3:
                holder.materialRadioButton3.setText(listeningQuestion.getAnswer());

                randomRestOfAnswer(listeningQuestion, holder, answerIndex);
                break;
            case 4:
                holder.materialRadioButton4.setText(listeningQuestion.getAnswer());

                randomRestOfAnswer(listeningQuestion, holder, answerIndex);
                break;
        }
    }

    public void randomRestOfAnswer(ListeningQuestion listeningQuestion, ViewHolder holder, int answerIndex){
        String answer = "";
        String answer_term = "";
        int random;
        Random rand = new Random();
        for (int i = 1 ;i <= 4; i++) {
            do {
                do {
                    random = rand.nextInt(listeningQuestions.size());
                    answer_term = answer;
                    answer = listeningQuestions.get(random).getAnswer();
                } while (Objects.equals(answer_term, answer));
               if (i != answerIndex) {
                   switch (i) {
                       case 1:
                           holder.materialRadioButton1.setText(answer);
                           break;
                       case 2:
                           holder.materialRadioButton2.setText(answer);
                           break;
                       case 3:
                           holder.materialRadioButton3.setText(answer);
                           break;
                       case 4:
                           holder.materialRadioButton4.setText(answer);
                           break;
                   }
               }
            } while  (Objects.equals(listeningQuestions.get(random).getUuid(), listeningQuestion.getUuid()));
        }

    }
}
