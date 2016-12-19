package com.quizlet.android.terrarium.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.quizlet.android.terrarium.TerrariumFragmentObject;

import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

/**
 * Created by brandonchinn on 12/22/16.
 */

public class TerrariumFragmentObjectManagerTest {
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
    public void testFragmentObjectManagerCallsAllObjectMethods() {
        TerrariumFragmentObjectManager manager = new TerrariumFragmentObjectManager();
        TerrariumFragmentObject object = Mockito.mock(TerrariumFragmentObject.class);
        manager.add(object);
        TestObject testObject = new TestObject();
        manager.add(testObject);

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

        Context context = new Activity();
        manager.onAttach(context);
        Mockito.verify(object, times(1)).onAttach(context);
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

        Bundle savedInstanceState = new Bundle();
        manager.onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onAttach(context);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
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

        View view = new View(context);
        manager.onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(1)).onAttach(context);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, never()).onStart();
        Mockito.verify(object, never()).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        Intent intent = new Intent();
        manager.onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onAttach(context);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, never()).onStart();
        Mockito.verify(object, never()).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        manager.onStart();
        Mockito.verify(object, times(1)).onAttach(context);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, never()).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        manager.onResume();
        Mockito.verify(object, times(1)).onAttach(context);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        manager.onPause();
        Mockito.verify(object, times(1)).onAttach(context);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        manager.onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onAttach(context);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        manager.onStop();
        Mockito.verify(object, times(1)).onAttach(context);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, never()).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        manager.onDestroyView();
        Mockito.verify(object, times(1)).onAttach(context);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, times(1)).onDestroyView();
        Mockito.verify(object, never()).onDestroy();
        Mockito.verify(object, never()).onDetach();

        manager.onDestroy();
        Mockito.verify(object, times(1)).onAttach(context);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, times(1)).onDestroyView();
        Mockito.verify(object, times(1)).onDestroy();
        Mockito.verify(object, never()).onDetach();

        manager.onDetach();
        Mockito.verify(object, times(1)).onAttach(context);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onViewCreated(view, savedInstanceState);
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, times(1)).onDestroyView();
        Mockito.verify(object, times(1)).onDestroy();
        Mockito.verify(object, times(1)).onDetach();

        assertEquals(0, testObject.mMethodNames.size());
    }
}
