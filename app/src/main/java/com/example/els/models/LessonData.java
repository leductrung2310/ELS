package com.example.els.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LessonData {
    public List<Lesson> listeningLessons = new ArrayList<>(Arrays.asList(
            new Lesson(1, "Family life", 12, true),
            new Lesson(2, "Children's life", 1, true),
            new Lesson(3, "Friends", 3, true),
            new Lesson(4, "Live in the wild", 6, true),
            new Lesson(5, "Movies you will love", 7, true),
            new Lesson(6, "Way back home", 8, false),
            new Lesson(7, "Go to university", 10, false),
            new Lesson(8, "See strangers in the night club iss greater than anything else!", 9, false),
            new Lesson(9, "Movies you will love", 20, false),
            new Lesson(10, "Youth and friend", 16, false),
            new Lesson(11, "Youth and friend 2", 16, false)
            ));

    public List<Lesson> readingLessons = new ArrayList<>(Arrays.asList(
            new Lesson(1, "Work from home", 12, false),
            new Lesson(2, "The daily beauty", 10, true),
            new Lesson(3, "Environment", 30, true),
            new Lesson(4, "Live in the wild", 6, false),
            new Lesson(5, "Movies you will love", 8, true),
            new Lesson(6, "Today show", 8, false),
            new Lesson(7, "How to be good at Math", 9, false),
            new Lesson(8, "Love at office", 9, false),
            new Lesson(9, "talk to anybody", 25, false)
    ));

    public List<Lesson> speakingLessons = new ArrayList<>(Arrays.asList(
            new Lesson(1, "Good night", 12, false),
            new Lesson(2, "Leisure activity", 4, false),
            new Lesson(3, "Talk about your family", 3, false),
            new Lesson(4, "Live in the wild", 6, false),
            new Lesson(5, "Movies you will love", 7, false),
            new Lesson(6, "Talk to celebrity", 20, false),
            new Lesson(7, "How to be good at Math", 10, false),
            new Lesson(8, "Love at office", 10, false),
            new Lesson(9, "talk to anybody", 20, false),
            new Lesson(10, "Youth and friend", 17, false),
            new Lesson(11, "Youth and friend 2", 14, false),
            new Lesson(12, "Happy birthday", 17, false)
    ));

    public List<Lesson> writingLessons = new ArrayList<>(Arrays.asList(
            new Lesson(1, "Good night", 12, true),
            new Lesson(2, "Leisure activity", 4, true),
            new Lesson(3, "Talk about your family", 3, true),
            new Lesson(4, "Live in the wild", 6, true),
            new Lesson(5, "Movies you will love", 7, true),
            new Lesson(6, "Talk to celebrity", 9, true),
            new Lesson(7, "How to be good at Math", 10, true),
            new Lesson(8, "Love at office", 9, true)
    ));
}
