package com.wyx.demo.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.wyx.demo.R;


/**
 * @author : lls
 * time      : 2019/8/5
 * describe  :
 */
public class LauncherActivity extends AppCompatActivity implements Animation.AnimationListener {
    private ImageView mImageView;
    private ImageView mIconView;
    private TextView mTextView;

    private static final int ANIM_TIME = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initStartAnim();
    }

    private void initView() {
        mImageView = findViewById(R.id.iv_launcher_bg);
        mIconView = findViewById(R.id.iv_launcher_icon);
        mTextView = findViewById(R.id.iv_launcher_name);
    }

    private void initStartAnim() {
        // 渐变展示启动屏
        AlphaAnimation aa = new AlphaAnimation(0.4f, 1.0f);
        aa.setDuration(ANIM_TIME * 3);
        aa.setAnimationListener(this);
        mImageView.startAnimation(aa);

        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        sa.setDuration(ANIM_TIME);
        mIconView.startAnimation(sa);

        RotateAnimation ra = new RotateAnimation(180, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setDuration(ANIM_TIME);
        mTextView.startAnimation(ra);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Intent intent = new Intent(LauncherActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
