package com.quizlet.android.terrarium.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.quizlet.android.terrarium.TerrariumFragmentObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brandonchinn on 11/21/16.
 */

final class TerrariumFragmentObjectManager implements TerrariumFragmentObject {

    private final List<TerrariumFragmentObject> mManagedObjects = new ArrayList<>();

    void addAll(List<TerrariumFragmentObject> objects) {
        mManagedObjects.addAll(objects);
    }

    void add(TerrariumFragmentObject object) {
        mManagedObjects.add(object);
    }

    boolean remove(TerrariumFragmentObject object) {
        return mManagedObjects.remove(object);
    }

    void clear() {
        mManagedObjects.clear();
    }

    @Override
    public void onAttach(Context context) {
        for (TerrariumFragmentObject object : mManagedObjects) {
            object.onAttach(context);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        for (TerrariumFragmentObject object : mManagedObjects) {
            object.onCreate(savedInstanceState);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        for (TerrariumFragmentObject object : mManagedObjects) {
            object.onViewCreated(view, savedInstanceState);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (TerrariumFragmentObject object : mManagedObjects) {
            object.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onStart() {
        for (TerrariumFragmentObject object : mManagedObjects) {
            object.onStart();
        }
    }

    @Override
    public void onResume() {
        for (TerrariumFragmentObject object : mManagedObjects) {
            object.onResume();
        }
    }

    @Override
    public void onPause() {
        for (TerrariumFragmentObject object : mManagedObjects) {
            object.onPause();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        for (TerrariumFragmentObject object : mManagedObjects) {
            object.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onStop() {
        for (TerrariumFragmentObject object : mManagedObjects) {
            object.onStop();
        }
    }

    @Override
    public void onDestroy() {
        for (TerrariumFragmentObject object : mManagedObjects) {
            object.onDestroy();
        }
    }

    @Override
    public void onDestroyView() {
        for (TerrariumFragmentObject object : mManagedObjects) {
            object.onDestroyView();
        }
    }

    @Override
    public void onDetach() {
        for (TerrariumFragmentObject object : mManagedObjects) {
            object.onDetach();
        }
    }
}
