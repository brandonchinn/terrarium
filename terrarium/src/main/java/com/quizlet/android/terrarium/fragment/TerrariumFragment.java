package com.quizlet.android.terrarium.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.view.View;

import com.quizlet.android.terrarium.TerrariumFragmentObject;

import java.util.List;

/**
 * Created by brandonchinn on 12/19/16.
 */

public class TerrariumFragment extends Fragment {

    private final TerrariumFragmentObjectManager mFragmentObjectManager = new TerrariumFragmentObjectManager();

    /**
     * Adds a lifecycle managed object to the list
     * NOTE: Should be called before your super.onAttach()
     * @param objects
     */
    protected void addTerrariumObjects(List<TerrariumFragmentObject> objects) {
        mFragmentObjectManager.addAll(objects);
    }

    /**
     * Adds a lifecycle managed object to the list
     * NOTE: Should be called before your super.onAttach()
     * @param object
     */
    protected void addTerrariumObject(TerrariumFragmentObject object) {
        mFragmentObjectManager.add(object);
    }

    protected boolean removeTerrariumObject(TerrariumFragmentObject object) {
        return mFragmentObjectManager.remove(object);
    }

    protected void clearTerrariumObjects() {
        mFragmentObjectManager.clear();
    }

    @CallSuper
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mFragmentObjectManager.onAttach(context);
    }

    @CallSuper
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentObjectManager.onCreate(savedInstanceState);
    }

    @CallSuper
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentObjectManager.onViewCreated(view, savedInstanceState);
    }

    @CallSuper
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mFragmentObjectManager.onActivityResult(requestCode, resultCode, data);
    }

    @CallSuper
    @Override
    public void onStart() {
        super.onStart();
        mFragmentObjectManager.onStart();
    }

    @CallSuper
    @Override
    public void onResume() {
        super.onResume();
        mFragmentObjectManager.onResume();
    }

    @CallSuper
    @Override
    public void onPause() {
        super.onPause();
        mFragmentObjectManager.onPause();
    }

    @CallSuper
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mFragmentObjectManager.onSaveInstanceState(outState);
    }

    @CallSuper
    @Override
    public void onStop() {
        super.onStop();
        mFragmentObjectManager.onStop();
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mFragmentObjectManager.onDestroyView();
    }

    @CallSuper
    @Override
    public void onDestroy() {
        super.onDestroy();
        mFragmentObjectManager.onDestroy();
    }

    @CallSuper
    @Override
    public void onDetach() {
        super.onDetach();
        mFragmentObjectManager.onDetach();
    }
}
