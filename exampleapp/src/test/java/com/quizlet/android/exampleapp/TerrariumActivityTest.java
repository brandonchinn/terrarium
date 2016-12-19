package com.quizlet.android.exampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.quizlet.android.terrarium.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = com.quizlet.android.terrarium.BuildConfig.class, sdk=23)
public class TerrariumActivityTest {
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
    public void allActivityMethodsGetCalled() throws Exception {
        ActivityController<ExampleActivity> activityController = Robolectric.buildActivity(ExampleActivity.class);
        TerrariumActivityObject object = Mockito.mock(TerrariumActivityObject.class);
        activityController.get().addTerrariumActivityObject(object);
        TestObject testObject = new TestObject();
        activityController.get().addTerrariumActivityObject(testObject);
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

        Bundle savedInstanceState = new Bundle();
        activityController.create(savedInstanceState);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, never()).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStart();
        Mockito.verify(object, never()).onPostCreate(savedInstanceState);
        Mockito.verify(object, never()).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        activityController.start();
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, never()).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, never()).onPostCreate(savedInstanceState);
        Mockito.verify(object, never()).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        activityController.postCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, never()).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(savedInstanceState);
        Mockito.verify(object, never()).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        activityController.resume();
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, never()).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(savedInstanceState);
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        activityController.pause();
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, never()).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(savedInstanceState);
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        Bundle outBundle = new Bundle();
        activityController.saveInstanceState(outBundle);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, never()).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(savedInstanceState);
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(outBundle);
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        activityController.stop();
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, never()).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(savedInstanceState);
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(outBundle);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, never()).onDestroy();

        activityController.restart();
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(savedInstanceState);
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(outBundle);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, never()).onDestroy();

        activityController.destroy();
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(savedInstanceState);
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(outBundle);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, times(1)).onDestroy();

        Intent activityResultIntent = new Intent();
        activityController.get().onActivityResult(1, 1, activityResultIntent);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onRestart();
        Mockito.verify(object, times(1)).onActivityResult(1, 1, activityResultIntent);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(savedInstanceState);
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(outBundle);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, times(1)).onDestroy();

        Bundle restoreBundle = new Bundle();
        activityController.get().onRestoreInstanceState(restoreBundle);
        Mockito.verify(object, times(1)).onCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onRestart();
        Mockito.verify(object, times(1)).onActivityResult(1, 1, activityResultIntent);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(savedInstanceState);
        Mockito.verify(object, times(1)).onRestoreInstanceState(restoreBundle);
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(outBundle);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, times(1)).onDestroy();

        assertEquals(0, testObject.mMethodNames.size());
    }

    @Test
    public void allAppCompatActivityMethodsGetCalled() throws Exception {
        ActivityController<ExampleAppCompatActivity> activityController = Robolectric.buildActivity(ExampleAppCompatActivity.class);
        TerrariumActivityObject object = Mockito.mock(TerrariumActivityObject.class);
        activityController.get().addTerrariumActivityObject(object);
        TestObject testObject = new TestObject();
        activityController.get().addTerrariumActivityObject(testObject);
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

        Bundle testBundle = new Bundle();
        activityController.create(testBundle);
        Mockito.verify(object, times(1)).onCreate(testBundle);
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

        activityController.start();
        Mockito.verify(object, times(1)).onCreate(testBundle);
        Mockito.verify(object, never()).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, never()).onPostCreate(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        activityController.postCreate(testBundle);
        Mockito.verify(object, times(1)).onCreate(testBundle);
        Mockito.verify(object, never()).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(testBundle);
        Mockito.verify(object, never()).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        activityController.resume();
        Mockito.verify(object, times(1)).onCreate(testBundle);
        Mockito.verify(object, never()).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(testBundle);
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, never()).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        activityController.pause();
        Mockito.verify(object, times(1)).onCreate(testBundle);
        Mockito.verify(object, never()).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(testBundle);
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, never()).onSaveInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        Bundle outBundle = new Bundle();
        activityController.saveInstanceState(outBundle);
        Mockito.verify(object, times(1)).onCreate(testBundle);
        Mockito.verify(object, never()).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(testBundle);
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(outBundle);
        Mockito.verify(object, never()).onStop();
        Mockito.verify(object, never()).onDestroy();

        activityController.stop();
        Mockito.verify(object, times(1)).onCreate(testBundle);
        Mockito.verify(object, never()).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, times(1)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(testBundle);
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(outBundle);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, never()).onDestroy();

        activityController.restart();
        Mockito.verify(object, times(1)).onCreate(testBundle);
        Mockito.verify(object, times(1)).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(testBundle);
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(outBundle);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, never()).onDestroy();

        activityController.destroy();
        Mockito.verify(object, times(1)).onCreate(testBundle);
        Mockito.verify(object, times(1)).onRestart();
        Mockito.verify(object, never()).onActivityResult(Mockito.anyInt(), Mockito.anyInt(), Mockito.any(Intent.class));
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(testBundle);
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(outBundle);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, times(1)).onDestroy();

        Intent activityResultIntent = new Intent();
        activityController.get().onActivityResult(1, 1, activityResultIntent);
        Mockito.verify(object, times(1)).onCreate(testBundle);
        Mockito.verify(object, times(1)).onRestart();
        Mockito.verify(object, times(1)).onActivityResult(1, 1, activityResultIntent);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(testBundle);
        Mockito.verify(object, never()).onRestoreInstanceState(Mockito.any(Bundle.class));
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(outBundle);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, times(1)).onDestroy();

        Bundle restoreBundle = new Bundle();
        activityController.get().onRestoreInstanceState(restoreBundle);
        Mockito.verify(object, times(1)).onCreate(testBundle);
        Mockito.verify(object, times(1)).onRestart();
        Mockito.verify(object, times(1)).onActivityResult(1, 1, activityResultIntent);
        Mockito.verify(object, times(2)).onStart();
        Mockito.verify(object, times(1)).onPostCreate(testBundle);
        Mockito.verify(object, times(1)).onRestoreInstanceState(restoreBundle);
        Mockito.verify(object, times(1)).onResume();
        Mockito.verify(object, times(1)).onPause();
        Mockito.verify(object, times(1)).onSaveInstanceState(outBundle);
        Mockito.verify(object, times(1)).onStop();
        Mockito.verify(object, times(1)).onDestroy();

        assertEquals(0, testObject.mMethodNames.size());
    }
}