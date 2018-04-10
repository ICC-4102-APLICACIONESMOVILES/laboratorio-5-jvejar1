package com.example.e440.functional_navdrawer;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import static android.arch.persistence.room.ForeignKey.CASCADE;
/**
 * Created by e440 on 10-04-18.
 */

@Entity(foreignKeys = @ForeignKey(entity = Form.class,
        parentColumns = "formId",
        childColumns = "formId",
        onDelete = CASCADE))
public class Question {
    public int getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getQuestionType() {
        return questionType;
    }

    public int getFormId() {
        return formId;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @PrimaryKey(autoGenerate = true)
    private int questionId;
    private String questionText;
    private String questionType;
    private int formId;
}
