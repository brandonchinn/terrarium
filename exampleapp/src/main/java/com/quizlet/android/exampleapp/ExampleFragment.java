package com.quizlet.android.exampleapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.quizlet.android.terrarium.TerrariumFragmentObject;
import com.quizlet.android.terrarium.fragment.TerrariumFragment;

/**
 * Example Fragment
 */

public class ExampleFragment extends TerrariumFragment {
    public static final String TAG = ExampleFragment.class.getSimpleName();
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
