package com.example.e440.functional_navdrawer;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by e440 on 10-04-18.
 */
@Dao
public interface QuestionDao {

    @Insert
    void insertOnlySingleQuestion (Question question);
    @Insert
    void insertMultipleQuestions (List<Question> questionList);
    @Query("SELECT * FROM Form WHERE questionId = :questionId")
    Form fetchOneQuestionbyQuestionId (int questionId);

    @Query("SELECT * FROM Question")
    Form[] fetchAllQuestions();


    @Update
    void updateQuestion (Question question);
    @Delete
    void deleteQuestion (Question question);


}