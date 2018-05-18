package com.liam.justjava;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class MyTest extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_layout);
    }

    public static class MyView extends View {
        MyView(Context c, AttributeSet attrs) { super(c, attrs); }

        @Override
        public void onDraw(Canvas c) {
            super.onDraw(c);
        }
    }
}
