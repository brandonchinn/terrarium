package com.quizlet.android.exampleapp;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.quizlet.android.terrarium.TerrariumFragmentObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

/**
 * Created by brandonchinn on 12/27/16.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = com.quizlet.android.terrarium.BuildConfig.class, sdk=23)
public class TerrariumDialogFragmentTest {
    static class TestObject implements TerrariumFragmentObject {
        final List<String> mMethodNames = new ArrayList<>();
        TestObject() {
            try {
                Method[] methods = Class.forName("com.quizlet.android.terrarium.TerrariumFragmentObject").getDeclaredMethods();
                for (Method method : methods) {
                    mMethodNames.add(method.getName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onAttach(Context context) {
            mMethodNames.remove((new Object(){}).getClass().getEnclosingMethod().getName());
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            mMethodNames.remove((new Object(){}).getClass().getEnclosingMethod().getName());
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            mMethodNames.remove((new Object(){}).getClass().getEnclosingMethod().getName());
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            mMethodNames.remove((new Object(){}).getClass().getEnclosingMethod().getName());
        }

        @Override
        public void onStart() {
            mMethodNames.remove((new Object(){}).getClass().getEnclosingMethod().getName());
        }

        @Override
        public void onResume() {
            mMethodNames.remove((new Object(){}).getClass().getEnclosingMethod().getName());
        }

        @Override
        public void onPause() {
            mMethodNames.remove((new Object(){}).getClass().getEnclosingMethod().getName());
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            mMethodNames.remove((new Object(){}).getClass().getEnclosingMethod().getName());
        }

        @Override
        public void onStop() {
            mMethodNames.remove((new Object(){}).getClass().getEnclosingMethod().getName());
        }

        @Override
        public void onDestroyView() {
            mMethodNames.remove((new Object(){}).getClass().getEnclosingMethod().getName());
        }

        @Override
        public void onDestroy() {
            mMethodNames.remove((new Object(){}).getClass().getEnclosingMethod().getName());
        }

        @Override
        public void onDetach() {
            mMethodNames.remove((new Object(){}).getClass().getEnclosingMethod().getName());
        }
    }

    @Test
    public void allFragmentMethodsGetCalled() {
        ExampleDialogFragment fragment = new ExampleDialogFragment();
        TerrariumFragmentObject object = Mockito.mock(TerrariumFragmentObject.class);
        fragment.addTerrariumActivityObject(object);
        TerrariumFragmentTest.TestObject testObject = new TerrariumFragmentTest.TestObject();
        fragment.addTerrariumActivityObject(testObject);

        Mockito.verify(object, never()).onAttach(Mockito.any(Context.class));
        Mockito.verify(object, never()).onCreate(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onViewCreated(Mockito.any(View.class), Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, never()).onStart();
        Mockito.verify(object, never()).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        ExampleActivity testActivity = Robolectric.setupActivity(ExampleActivity.class);
        FragmentManager fm = testActivity.getFragmentManager();
        fragment.show(fm, ExampleDialogFragment.TAG);
        // adding the fragment triggers onAttach, onStart and onResume
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onResume();

        Mockito.verify(object, never()).onCreate(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onViewCreated(Mockito.any(View.class), Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));

        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        Bundle savedInstanceState = Mockito.mock(Bundle.class);
        fragment.onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, never()).onViewCreated(Mockito.any(View.class), Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        View view = Mockito.mock(View.class);
        fragment.onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        fragment.onStart();
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();


        Intent intent = new Intent();
        fragment.onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        fragment.onResume();
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(2)).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        fragment.onPause();
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(2)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        fragment.onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(2)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        fragment.onStop();
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(2)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        fragment.onDestroyView();
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(2)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, times(1)).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        fragment.onDestroy();
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(2)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, times(1)).onDestroyView();
        Mockito.verify(object, times(1)).onDestroy();
        Mockito.verify(object, never()).onDetach();

        fragment.onDetach();
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(2)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, times(1)).onDestroyView();
        Mockito.verify(object, times(1)).onDestroy();
        Mockito.verify(object, times(1)).onDetach();
        assertEquals(0, testObject.mMethodNames.size());
    }

    @Test
    public void allSupportFragmentMethodsGetCalled() {
        ExampleSupportDialogFragment fragment = new ExampleSupportDialogFragment();
        TerrariumFragmentObject object = Mockito.mock(TerrariumFragmentObject.class);
        fragment.addTerrariumActivityObject(object);
        TerrariumFragmentTest.TestObject testObject = new TerrariumFragmentTest.TestObject();
        fragment.addTerrariumActivityObject(testObject);

        Mockito.verify(object, never()).onAttach(Mockito.any(Context.class));
        Mockito.verify(object, never()).onCreate(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onViewCreated(Mockito.any(View.class), Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, never()).onStart();
        Mockito.verify(object, never()).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        ExampleAppCompatActivity testActivity = Robolectric.setupActivity(ExampleAppCompatActivity.class);
        android.support.v4.app.FragmentManager fm = testActivity.getSupportFragmentManager();

        fragment.show(fm, ExampleSupportDialogFragment.TAG);
        // adding the fragment triggers onAttach, onStart and onResume
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onResume();

        Mockito.verify(object, never()).onCreate(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onViewCreated(Mockito.any(View.class), Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));

        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        Bundle savedInstanceState = Mockito.mock(Bundle.class);
        fragment.onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, never()).onViewCreated(Mockito.any(View.class), Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        View view = Mockito.mock(View.class);
        fragment.onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        fragment.onStart();
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();


        Intent intent = new Intent();
        fragment.onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        fragment.onResume();
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(2)).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        fragment.onPause();
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(2)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        fragment.onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(2)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        fragment.onStop();
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(2)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        fragment.onDestroyView();
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(2)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, times(1)).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        fragment.onDestroy();
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(2)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, times(1)).onDestroyView();
        Mockito.verify(object, times(1)).onDestroy();
        Mockito.verify(object, never()).onDetach();

        fragment.onDetach();
        Mockito.verify(object, times(1)).onAttach(testActivity);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(2)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, times(1)).onDestroyView();
        Mockito.verify(object, times(1)).onDestroy();
        Mockito.verify(object, times(1)).onDetach();
        assertEquals(0, testObject.mMethodNames.size());
    }
}
