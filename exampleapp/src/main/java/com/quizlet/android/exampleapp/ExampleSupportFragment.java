package com.quizlet.android.exampleapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.quizlet.android.terrarium.TerrariumFragmentObject;
import com.quizlet.android.terrarium.fragment.TerrariumSupportFragment;

/**
 * Created by brandonchinn on 12/23/16.
 */

public class ExampleSupportFragment extends TerrariumSupportFragment {
    public static final String TAG = ExampleSupportFragment.class.getSimpleName();
    ExampleTerrariumFragmentObject mExampleObject;

    void addTerrariumActivityObject(TerrariumFragmentObject object) {
        addTerrariumObject(object);
    }

    @Override
    public void onAttach(Context context) {
        mExampleObject = new ExampleTerrariumFragmentObject();
        addTerrariumActivityObject(mExampleObject);
        super.onAttach(context);
    }
}
