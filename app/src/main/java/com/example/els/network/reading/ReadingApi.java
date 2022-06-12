package com.example.els.network.reading;



import com.example.els.models.Api.ReadingAnswer;
import com.example.els.models.Api.ReadingLesson;
import com.example.els.models.Api.ReadingQuestion;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ReadingApi {

    @GET("readinglesson")
    Call<List<ReadingLesson>> getAllReadingLesson();

    @GET("readingquestion/")
    Call<List<ReadingQuestion>> getReadingQuestionByReadingLesson(@QueryMap Map<String, String> params);

    @GET("readinganswer/")
    Call<List<ReadingAnswer>> getReadingAnswerByReadingQuestion(@QueryMap Map<String, String> params);

    @GET("readinganswercorrect/")
    Call<List<ReadingAnswer>> getCorrectReadingAnswerByReadingQuestion(@QueryMap Map<String, String> params);
}
