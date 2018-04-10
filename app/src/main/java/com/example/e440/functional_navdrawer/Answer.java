package com.example.e440.functional_navdrawer;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by e440 on 10-04-18.
 */

@Entity(foreignKeys = @ForeignKey(entity = Question.class,
        parentColumns = "questionId",
        childColumns = "questionId",
        onDelete = CASCADE))
public class Answer {
    @PrimaryKey(autoGenerate = true)
    int answerId;
    int questionId;
    String answerText;
}
