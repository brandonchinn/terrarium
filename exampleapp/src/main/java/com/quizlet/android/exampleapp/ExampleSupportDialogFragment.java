package com.quizlet.android.exampleapp;

import android.content.Context;

import com.quizlet.android.terrarium.TerrariumFragmentObject;
import com.quizlet.android.terrarium.fragment.TerrariumSupportDialogFragment;

/**
 * Created by brandonchinn on 12/27/16.
 */

public class ExampleSupportDialogFragment extends TerrariumSupportDialogFragment {
    public static final String TAG = ExampleSupportDialogFragment.class.getSimpleName();
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
