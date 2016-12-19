package com.quizlet.android.terrarium.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.quizlet.android.terrarium.TerrariumActivityObject;

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

public class TerrariumActivityObjectManagerTest {

    /**
     * used to validate that all methods in TerrariumActivityObject get called at least once
     */
    static class TestObject implements TerrariumActivityObject {
        final List<String> mMethodNames = new ArrayList<>();
        TestObject() {
            try {
                Method[] methods = Class.forName("com.quizlet.android.terrarium.TerrariumActivityObject").getDeclaredMethods();
                for (Method method : methods) {
                    mMethodNames.add(method.getName());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            mMethodNames.remove((new Object(){}).getClass().getEnclosingMethod().getName());
        }

        @Override
        public void onRestart() {
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
        public void onPostCreate(@Nullable Bundle savedInstanceState) {
            mMethodNames.remove((new Object(){}).getClass().getEnclosingMethod().getName());
        }

        @Override
        public void onRestoreInstanceState(Bundle savedInstanceState) {
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
        public void onDestroy() {
            mMethodNames.remove((new Object(){}).getClass().getEnclosingMethod().getName());
        }
    }

    @Test
    public void testActivityObjectManagerCallsAllObjectMethods() {
        TerrariumActivityObjectManager manager = new TerrariumActivityObjectManager();
        TerrariumActivityObject object = Mockito.mock(TerrariumActivityObject.class);
        manager.add(object);
        TestObject testObject = new TestObject();
        manager.add(testObject);

        Mockito.verify(object, never()).onCreate(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStart();
        Mockito.verify(object, never()).onPostCreate(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        Bundle savedInstanceState = Mockito.mock(Bundle.class);
        manager.onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, never()).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStart();
        Mockito.verify(object, never()).onPostCreate(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        manager.onRestart();
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStart();
        Mockito.verify(object, never()).onPostCreate(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        Intent intent = Mockito.mock(Intent.class);
        manager.onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onRestart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStart();
        Mockito.verify(object, never()).onPostCreate(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        manager.onRestoreInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onRestart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onRestoreInstanceState(savedInstanceState);
        Mockito.verify(object, never()).onStart();
        Mockito.verify(object, never()).onPostCreate(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        manager.onStart();
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onRestart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onRestoreInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, never()).onPostCreate(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        manager.onPostCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onRestart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onRestoreInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(savedInstanceState);
        Mockito.verify(object, never()).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        manager.onResume();
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onRestart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onRestoreInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        manager.onPause();
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onRestart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onRestoreInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        manager.onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onRestart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onRestoreInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        manager.onStop();
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onRestart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onRestoreInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, never()).onDestroy();

        manager.onDestroy();
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onRestart();
        Mockito.verify(object, times(1)).onActivityResult(1, 2, intent);
        Mockito.verify(object, times(1)).onRestoreInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(savedInstanceState);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, times(1)).onDestroy();

        assertEquals(0, testObject.mMethodNames.size());
    }
}
