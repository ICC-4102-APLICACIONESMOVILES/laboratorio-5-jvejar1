package com.example.e440.functional_navdrawer;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import org.w3c.dom.Text;

import java.util.Date;

/**
 * Created by e440 on 09-04-18.
 */

@Entity
public class Form {

    @NonNull
    public int getFormId() {
        return formId;
    }

    public String getFormName() {
        return formName;
    }



    public String getFormCategory() {
        return formCategory;
    }

    public void setFormId(@NonNull int formId) {
        this.formId = formId;
    }

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int formId;

    public void setFormName(String formName) {
        this.formName = formName;
    }


    public void setFormCategory(String formCategory) {
        this.formCategory = formCategory;
    }

    private String formName;

    public String getFormDateText() {
        return formDateText;
    }

    public void setFormDateText(String formDateText) {
        this.formDateText = formDateText;
    }

    private String formDateText;
    private String formCategory;

    public Form() {

    }

    public String getFormComment() {
        return formComment;
    }

    public void setFormComment(String formComment) {
        this.formComment = formComment;
    }

    private String formComment;


}