package com.quizlet.android.terrarium;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * Created by brandonchinn on 11/20/16.
 */

public interface TerrariumActivityObject {

    void onCreate(@Nullable Bundle savedInstanceState);

    void onRestart();

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onStart();

    void onPostCreate(@Nullable Bundle savedInstanceState);

    void onRestoreInstanceState(Bundle savedInstanceState);

    void onResume();

    void onPause();

    void onSaveInstanceState(Bundle outState);

    void onStop();

    void onDestroy();

    class Stub implements TerrariumActivityObject {
        private final WeakReference<Context> mContext;
        public Stub(Context context) {
            mContext = new WeakReference<>(context);
        }

        public Context getContext() {
            return mContext.get();
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {}

        @Override
        public void onRestart() {}

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {}

        @Override
        public void onStart() {}

        @Override
        public void onPostCreate(@Nullable Bundle savedInstanceState) {}

        @Override
        public void onRestoreInstanceState(Bundle savedInstanceState) {}

        @Override
        public void onResume() {}

        @Override
        public void onPause() {}

        @Override
        public void onSaveInstanceState(Bundle outState) {}

        @Override
        public void onStop() {}

        @Override
        public void onDestroy() {}
    }
}
