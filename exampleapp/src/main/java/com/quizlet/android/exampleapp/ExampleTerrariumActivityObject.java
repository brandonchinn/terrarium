package com.quizlet.android.exampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.quizlet.android.terrarium.TerrariumActivityObject;


/**
 * Created by brandonchinn on 12/22/16.
 */

public class ExampleTerrariumActivityObject implements TerrariumActivityObject {
    private static final String TAG = ExampleTerrariumActivityObject.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
    }

    @Override
    public void onRestart() {
        Log.i(TAG, "onRestart");
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
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onPostCreate");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i(TAG, "onRestoreInstanceState");
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
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
    }
}
