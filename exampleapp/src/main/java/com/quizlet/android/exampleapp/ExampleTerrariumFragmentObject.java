package com.quizlet.android.exampleapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.quizlet.android.terrarium.TerrariumFragmentObject;

/**
 * Created by brandonchinn on 12/22/16.
 */

public class ExampleTerrariumFragmentObject implements TerrariumFragmentObject {
    private static final String TAG = ExampleTerrariumFragmentObject.class.getSimpleName();

    @Override
    public void onAttach(Context context) {
        Log.i(TAG, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i(TAG, "onActivityResult");
    }

    @Override
    public void onStart() {
        Log.i(TAG, "onStart");
    }

    @Override
    public void onResume() {
        Log.i(TAG, "onResume");
    }

    @Override
    public void onPause() {
        Log.i(TAG, "onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    public void onStop() {
        Log.i(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        Log.i(TAG, "onDetach");
    }
}
