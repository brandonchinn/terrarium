package com.quizlet.android.terrarium.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.quizlet.android.terrarium.TerrariumActivityObject;

import java.util.List;


/**
 * Created by brandonchinn on 11/20/16.
 */

public class TerrariumAppCompatActivity extends AppCompatActivity {
    private final TerrariumActivityObjectManager mActivityObjectManager = new TerrariumActivityObjectManager();

    /**
     * Adds a lifecycle managed object to the list
     * NOTE: Should be called before your super.onCreate() to receive all lifecycle callbacks
     * @param objects
     */
    protected void addTerrariumObjects(List<TerrariumActivityObject> objects) {
        mActivityObjectManager.addAll(objects);
    }

    /**
     * Adds a lifecycle managed object to the list
     * NOTE: Should be called before your super.onCreate()
     * @param object
     */
    protected void addTerrariumObject(TerrariumActivityObject object) {
        mActivityObjectManager.add(object);
    }

    protected boolean removeTerrariumObject(TerrariumActivityObject object) {
        return mActivityObjectManager.remove(object);
    }

    protected void clearTerrariumObjects() {
        mActivityObjectManager.clear();
    }

    @CallSuper
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityObjectManager.onCreate(savedInstanceState);
    }

    @CallSuper
    @Override
    protected void onRestart() {
        super.onRestart();
        mActivityObjectManager.onRestart();
    }

    @CallSuper
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mActivityObjectManager.onActivityResult(requestCode, resultCode, data);
    }

    @CallSuper
    @Override
    protected void onStart() {
        super.onStart();
        mActivityObjectManager.onStart();
    }

    @CallSuper
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActivityObjectManager.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mActivityObjectManager.onRestoreInstanceState(savedInstanceState);
    }

    @CallSuper
    @Override
    protected void onResume() {
        super.onResume();
        mActivityObjectManager.onResume();
    }

    @CallSuper
    @Override
    protected void onPause() {
        super.onPause();
        mActivityObjectManager.onPause();
    }

    @CallSuper
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mActivityObjectManager.onSaveInstanceState(outState);
    }

    @CallSuper
    @Override
    protected void onStop() {
        super.onStop();
        mActivityObjectManager.onStop();
    }

    @CallSuper
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivityObjectManager.onDestroy();
    }
}
