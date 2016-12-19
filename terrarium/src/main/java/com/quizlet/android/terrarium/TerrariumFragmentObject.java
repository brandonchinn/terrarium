package com.quizlet.android.terrarium;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import java.lang.ref.WeakReference;

/**
 * Created by brandonchinn on 11/21/16.
 */

public interface TerrariumFragmentObject {

    void onAttach(Context context);

    void onCreate(@Nullable Bundle savedInstanceState);

    void onViewCreated(View view, @Nullable Bundle savedInstanceState);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onStart();

    void onResume();

    void onPause();

    void onSaveInstanceState(Bundle outState);

    void onStop();

    void onDestroyView();

    void onDestroy();

    void onDetach();

    /**
     * Stubs out all interface methods
     */
    class Stub implements TerrariumFragmentObject {
        private WeakReference<Context> mContext;

        public Context getContext() {
            return mContext.get();
        }

        @Override
        public void onAttach(Context context) {
            mContext = new WeakReference<>(context);
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {}

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {}

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {}

        @Override
        public void onStart() {}

        @Override
        public void onResume() {}

        @Override
        public void onPause() {}

        @Override
        public void onSaveInstanceState(Bundle outState) {}

        @Override
        public void onStop() {}

        @Override
        public void onDestroyView() {}

        @Override
        public void onDestroy() {}

        @Override
        public void onDetach() {}
    }
}
