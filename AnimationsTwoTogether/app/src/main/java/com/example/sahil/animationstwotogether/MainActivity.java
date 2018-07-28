package com.example.sahil.animationstwotogether;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView mImageBall;
    private Animation mAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageBall = (ImageView)findViewById(R.id.imageView);
        mAnim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.animate);
    }

    public void animationBall(View view) {
        mAnim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.animate);
        mImageBall.startAnimation(mAnim);
    }

    public void bounceBall(View view) {
        mAnim.setInterpolator(new BounceInterpolator());
        mImageBall.startAnimation(mAnim);
    }
}
