package com.example.els.viewmodel.home;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.els.models.Api.ReadingAnswer;
import com.example.els.models.Api.ReadingFirebase;
import com.example.els.models.Api.ReadingLesson;
import com.example.els.models.Api.ReadingQuestion;
import com.example.els.network.reading.ReadingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadingViewModel extends ViewModel {
//    private final LessonData lessonData = new LessonData();
//
//    // Done reading lessons
//    private MutableLiveData<ArrayList<Lesson>> _doneReadingLessons;
//
//    public MutableLiveData<ArrayList<Lesson>> getDoneReadingLessons() {
//        if (_doneReadingLessons == null) _doneReadingLessons = new MutableLiveData<>();
//        loadDoneLessons();
//        return _doneReadingLessons;
//    }
//
//    public void loadDoneLessons() {
//        ArrayList<Lesson> temp = new ArrayList<>();
//        for (int i = 0; i < lessonData.readingLessons.size(); i++) {
//            if (lessonData.readingLessons.get(i).getState()) {
//                temp.add(lessonData.readingLessons.get(i));
//            }
//        }
//        _doneReadingLessons.setValue(temp);
//    }
//
//    // Undone listening lessons
//    private MutableLiveData<ArrayList<Lesson>> _undoneReadingLessons;
//
//    public LiveData<ArrayList<Lesson>> getUndoneReadingLessons() {
//        if (_undoneReadingLessons == null) _undoneReadingLessons = new MutableLiveData<>();
//        loadUndoneLessons();
//        return _undoneReadingLessons;
//    }
//
//    public void loadUndoneLessons() {
//        ArrayList<Lesson> temp = new ArrayList<>();
//        for (int i = 0; i < lessonData.readingLessons.size(); i++) {
//            if (!lessonData.readingLessons.get(i).getState()) {
//                temp.add(lessonData.readingLessons.get(i));
//            }
//        }
//        _undoneReadingLessons.setValue(temp);
//    }
//
//    // Total duration
//    private final MutableLiveData<Integer> _totalDuration = new MutableLiveData<>(0);
//
//    public LiveData<Integer> getTotalDuration() {
//        int total = 0;
//        for (int i = 0; i < lessonData.readingLessons.size(); i++) {
//            total += lessonData.readingLessons.get(i).getDuration();
//        }
//        _totalDuration.setValue(total);
//        return _totalDuration;
//    }
//
//    // Number of lessons
//    private final MutableLiveData<Integer> _totalLessons = new MutableLiveData<>(0);
//
//    public LiveData<Integer> getTotalLessons() {
//        _totalLessons.setValue(lessonData.readingLessons.size());
//        return _totalLessons;
//    }
//
//    // Complete percentage
//    private final MutableLiveData<Integer> _completePercentage = new MutableLiveData<>(0);
//
//    public LiveData<Integer> getCompletePercentage() {
//        int count = 0;
//        for (int i = 0; i < lessonData.readingLessons.size(); i++) {
//            if (lessonData.readingLessons.get(i).getState()) {
//                count++;
//            }
//        }
//        double percentage = ((double) count / (double) lessonData.readingLessons.size() * 100);
//        int percent = (int) percentage;
//        _completePercentage.setValue(percent);
//        return _completePercentage;
//    }

    private ReadingRepository readingRepository;
    private MutableLiveData<List<ReadingLesson>> readingLessonLiveData;
    private MutableLiveData<ArrayList<ReadingFirebase>> doneReadingLessonFromFirebase;
    private MutableLiveData<ArrayList<ReadingLesson>> undoneReadingLesson;
    private MutableLiveData<ArrayList<ReadingLesson>> doneReadingLesson;
    private MutableLiveData<String> content;
    private MutableLiveData<String> image;
    private int position;
    private ReadingLesson readingLesson;
    private MutableLiveData<List<ReadingQuestion>> readingQuestionsLiveDate;
    private MutableLiveData<List<ReadingAnswer>> readingAnswerLiveData;
    private ReadingQuestion readingQuestion;


    public ReadingViewModel() {
        readingRepository = new ReadingRepository();
        readingLessonLiveData = new MutableLiveData<>();
        doneReadingLessonFromFirebase = new MutableLiveData<>();
        undoneReadingLesson = new MutableLiveData<>();
        doneReadingLesson = new MutableLiveData<>();
        content = new MutableLiveData<>();
        image = new MutableLiveData<>();
        readingLesson = new ReadingLesson();
        readingQuestionsLiveDate = new MutableLiveData<>();
        readingAnswerLiveData = new MutableLiveData<>();
        readingQuestion = new ReadingQuestion();
    }

    public void getAllReadingLesson() {
        readingRepository.getAllReadingLesson(new ReadingRepository.GetAllReadingLesson() {
            @Override
            public void onCallBackResponse(ArrayList<ReadingLesson> readingLessons) {
                Log.d("reading lesson", "call back co gia tri");
                readingLessonLiveData.setValue(readingLessons);
                getDoneListeningFromFireStore();
            }

            @Override
            public void onCallBackFailure(ArrayList<ReadingLesson> readingLessons) {
                Log.d("reading lesson", "call back khong co gia tri");
                readingLessonLiveData.setValue(readingLessons);
            }
        });
    }

    public void getDoneListeningFromFireStore() {
        readingRepository.getDoneReadingLessonFromFirestore(new ReadingRepository.GetDoneListeningFromFirestore() {
            @Override
            public void onCallBackResponse(ArrayList<ReadingFirebase> readingFirebases) {
                doneReadingLessonFromFirebase.setValue(readingFirebases);
                setUpDoneReadingLessonFromFirebase(readingFirebases);
            }

            @Override
            public void onCallBackFailure(ArrayList<ReadingFirebase> readingFirebases) {

            }
        });
    }

    public void setUpDoneReadingLessonFromFirebase(ArrayList<ReadingFirebase> readingFirebases) {
        ArrayList<ReadingLesson> _done = new ArrayList<>();
        if (readingFirebases.size() == Objects.requireNonNull(readingLessonLiveData.getValue()).size()) {
            doneReadingLesson.setValue((ArrayList<ReadingLesson>) readingLessonLiveData.getValue());
            undoneReadingLesson.setValue(new ArrayList<>());
        } else if (readingFirebases.size() == 0) {
            undoneReadingLesson.setValue((ArrayList<ReadingLesson>) readingLessonLiveData.getValue());
            doneReadingLesson.setValue(new ArrayList<>());
        } else {
            for (int i = 0; i < Objects.requireNonNull(readingLessonLiveData.getValue()).size(); i++) {
                for (int j = 0; j < readingFirebases.size(); j++) {
                    if (!Objects.equals(readingLessonLiveData.getValue().get(i).getUuid(), readingFirebases.get(j).getId())) {
                        Log.d("reading lesson", "add undone");
                    } else {
                        Log.d("listening", "add done");
                        _done.add(readingLessonLiveData.getValue().get(i));
                    }
                }
            }
            doneReadingLesson.setValue(_done);
            ArrayList<ReadingLesson> _unDone = new ArrayList<>(readingLessonLiveData.getValue());
            _unDone.removeAll(_done);
            undoneReadingLesson.setValue(_unDone);
            Log.d("listening", String.valueOf(doneReadingLesson.getValue().size()));
            Log.d("listening", String.valueOf(undoneReadingLesson.getValue().size()));
        }
    }

    public void getReadingQuestionByReadingLesson(String id) {
        readingRepository.getReadingQuestionByReadingLesson(id, new ReadingRepository.GetReadingQuestionByReadingLesson() {
            @Override
            public void onCallBackResponse(ArrayList<ReadingQuestion> readingLessons) {
                readingQuestionsLiveDate.setValue(readingLessons);
            }

            @Override
            public void onCallBackFailure(ArrayList<ReadingQuestion> readingLessons) {
                readingQuestionsLiveDate.setValue(readingLessons);
            }
        });
    }

    public void getReadingAnswerByReadingQuestion(String id) {
        readingRepository.getReadingAnswerByReadingQuestion(id, new ReadingRepository.GetReadingAnswerByReadingQuestion() {
            @Override
            public void onCallBackResponse(ArrayList<ReadingAnswer> readingLessons) {
                readingAnswerLiveData.setValue(readingLessons);
            }

            @Override
            public void onCallBackFailure(ArrayList<ReadingAnswer> readingLessons) {
                readingAnswerLiveData.setValue(readingLessons);
            }
        });
    }

    public void getCorrectReadingAnswerByReadingQuestion(String id) {
        readingRepository.getCorrectReadingAnswerByReadingQuestion(id, new ReadingRepository.GetReadingAnswerByReadingQuestion() {
            @Override
            public void onCallBackResponse(ArrayList<ReadingAnswer> readingLessons) {
                readingAnswerLiveData.setValue(readingLessons);
            }

            @Override
            public void onCallBackFailure(ArrayList<ReadingAnswer> readingLessons) {
                readingAnswerLiveData.setValue(readingLessons);
            }
        });
    }

    //pushDoneLessonToFirestore
    public void pushDoneReadingLessonToFirestore(int score) {
        ReadingFirebase readingFirebase = new ReadingFirebase(undoneReadingLesson.getValue().get(position).getUuid(), Integer.toString(score));
        readingRepository.pushDoneReadingLessonFromFirestore(readingFirebase);
    }

    public MutableLiveData<List<ReadingLesson>> getReadingLessonLiveData() {
        return readingLessonLiveData;
    }

    public void setReadingLessonLiveData(List<ReadingLesson> readingLessonLiveData) {
        this.readingLessonLiveData.setValue(readingLessonLiveData);
    }

    public MutableLiveData<ArrayList<ReadingFirebase>> getDoneReadingLessonFromFirebase() {
        return doneReadingLessonFromFirebase;
    }

    public void setDoneReadingLessonFromFirebase(ArrayList<ReadingFirebase> doneReadingLessonFromFirebase) {
        this.doneReadingLessonFromFirebase.setValue(doneReadingLessonFromFirebase);
    }

    public MutableLiveData<ArrayList<ReadingLesson>> getUndoneReadingLesson() {
        return undoneReadingLesson;
    }

    public void setUndoneReadingLesson(ArrayList<ReadingLesson> undoneReadingLesson) {
        this.undoneReadingLesson.setValue(undoneReadingLesson);
    }

    public MutableLiveData<ArrayList<ReadingLesson>> getDoneReadingLesson() {
        return doneReadingLesson;
    }

    public void setDoneReadingLesson(ArrayList<ReadingLesson> doneReadingLesson) {
        this.doneReadingLesson.setValue(doneReadingLesson);
    }

    public MutableLiveData<String> getContent() {
        return content;
    }

    public void setContent(MutableLiveData<String> content) {
        this.content = content;
    }

    public MutableLiveData<String> getImage() {
        return image;
    }

    public void setImage(MutableLiveData<String> image) {
        this.image = image;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ReadingLesson getReadingLesson() {
        return readingLesson;
    }

    public void setReadingLesson(ReadingLesson readingLesson) {
        this.readingLesson = readingLesson;
    }

    public MutableLiveData<List<ReadingQuestion>> getReadingQuestionsLiveDate() {
        return readingQuestionsLiveDate;
    }

    public void setReadingQuestionsLiveDate(MutableLiveData<List<ReadingQuestion>> readingQuestionsLiveDate) {
        this.readingQuestionsLiveDate = readingQuestionsLiveDate;
    }

    public MutableLiveData<List<ReadingAnswer>> getReadingAnswerLiveData() {
        return readingAnswerLiveData;
    }

    public void setReadingAnswerLiveData(MutableLiveData<List<ReadingAnswer>> readingAnswerLiveData) {
        this.readingAnswerLiveData = readingAnswerLiveData;
    }


    public ReadingQuestion getReadingQuestion() {
        return readingQuestion;
    }

    public void setReadingQuestion(ReadingQuestion readingQuestion) {
        this.readingQuestion = readingQuestion;
    }


}
