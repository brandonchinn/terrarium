package com.quizlet.android.exampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.quizlet.android.terrarium.TerrariumActivityObject;
import com.quizlet.android.terrarium.activity.TerrariumAppCompatActivity;

/**
 * Created by brandonchinn on 12/22/16.
 */

public class ExampleAppCompatActivity extends TerrariumAppCompatActivity {
    ExampleTerrariumActivityObject mExampleObject;

    void addTerrariumActivityObject(TerrariumActivityObject object) {
        addTerrariumObject(object);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mExampleObject = new ExampleTerrariumActivityObject();
        addTerrariumObject(mExampleObject);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onRestart() {
        super.onRestart();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
