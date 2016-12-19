package com.quizlet.android.terrarium.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.quizlet.android.terrarium.TerrariumActivityObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Forwards calls from lifecycle methods to the managed objects
 */

final class TerrariumActivityObjectManager implements TerrariumActivityObject {

    private final List<TerrariumActivityObject> mManagedObjects = new ArrayList<>();
    TerrariumActivityObjectManager() {}

    void addAll(List<TerrariumActivityObject> objects) {
        mManagedObjects.addAll(objects);
    }

    void add(TerrariumActivityObject object) {
        mManagedObjects.add(object);
    }

    boolean remove(TerrariumActivityObject object) {
        return mManagedObjects.remove(object);
    }

    void clear() {
        mManagedObjects.clear();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        for (TerrariumActivityObject object : mManagedObjects) {
            object.onCreate(savedInstanceState);
        }
    }

    @Override
    public void onRestart() {
        for (TerrariumActivityObject object : mManagedObjects) {
            object.onRestart();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (TerrariumActivityObject object : mManagedObjects) {
            object.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        for (TerrariumActivityObject object : mManagedObjects) {
            object.onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    public void onStart() {
        for (TerrariumActivityObject object : mManagedObjects) {
            object.onStart();
        }
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        for (TerrariumActivityObject object : mManagedObjects) {
            object.onPostCreate(savedInstanceState);
        }
    }

    @Override
    public void onResume() {
        for (TerrariumActivityObject object : mManagedObjects) {
            object.onResume();
        }
    }

    @Override
    public void onPause() {
        for (TerrariumActivityObject object : mManagedObjects) {
            object.onPause();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        for (TerrariumActivityObject object : mManagedObjects) {
            object.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onStop() {
        for (TerrariumActivityObject object : mManagedObjects) {
            object.onStop();
        }
    }

    @Override
    public void onDestroy() {
        for (TerrariumActivityObject object : mManagedObjects) {
            object.onDestroy();
        }
    }
}
