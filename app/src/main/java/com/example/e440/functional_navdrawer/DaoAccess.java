package com.example.e440.functional_navdrawer;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by e440 on 09-04-18.
 */

@Dao
public interface DaoAccess {

    @Insert
    void insertOnlySingleForm (Form form);

    @Insert
    void insertMultipleForms (List<Form> formList);

    @Query("SELECT * FROM Form WHERE formId = :formId")
    Form fetchOneFormbyFormId (int formId);

    @Query("SELECT * FROM Form")
    Form[] fetchAllForms();

    @Query("DELETE from Form")
    void deleteAllForms ();



    @Update
    void updateForm (Form form);
    @Delete
    void deleteForm (Form form);




}
