package com.akhil.clipbackgroundviewpager;

import android.annotation.TargetApi;
import android.graphics.drawable.ClipDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.akhil.clipbackgroundviewpager.adapter.CustomFragmentPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;
    int k = 100;
    ImageView img1, img2;
    private ViewPager mViewPager;
    private ClipDrawable mClipDrawable1;
    private ClipDrawable mClipDrawable2;
    private int mCurrentFragmentPosition;
    Boolean isGoingToRightPage;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ClipDrawable clip1, clip2Right, clip3Left, clip4, clip2Left, clip3Right;
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.vp_content);
        img1 = (ImageView) findViewById(R.id.iv_clip1);
        img2 = (ImageView) findViewById(R.id.iv_clip2);
        clip1 = new ClipDrawable(getDrawable(R.drawable.drawable1), Gravity.LEFT, ClipDrawable.HORIZONTAL);
        clip2Right = new ClipDrawable(getDrawable(R.drawable.drawable2), Gravity.RIGHT, ClipDrawable.HORIZONTAL);
        clip2Left = new ClipDrawable(getDrawable(R.drawable.drawable2_right), Gravity.LEFT, ClipDrawable.HORIZONTAL);
        clip3Left = new ClipDrawable(getDrawable(R.drawable.drawable3), Gravity.LEFT, ClipDrawable.HORIZONTAL);
        clip3Right = new ClipDrawable(getDrawable(R.drawable.drawable3_right), Gravity.RIGHT, ClipDrawable.HORIZONTAL);
        clip4 = new ClipDrawable(getDrawable(R.drawable.drawable4), Gravity.RIGHT, ClipDrawable.HORIZONTAL);


        clip1.setLevel(10000);
        clip2Right.setLevel(0);
        mClipDrawable1 = clip1;
        mClipDrawable2 = clip2Right;
        img1.setImageDrawable(mClipDrawable1);
        img2.setImageDrawable(mClipDrawable2);

        CustomFragmentPagerAdapter customFragmentPagerAdapter = new CustomFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(customFragmentPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("onPageScrolled-position-->" + position, positionOffsetPixels+"onPageScrolled-positionOffset-->" + positionOffset);
                if (positionOffset == 0) {
                    switch (position) {
                        case 0:
                            mClipDrawable1 = clip1;
                            mClipDrawable2 = clip2Right;
                            mClipDrawable1.setLevel(10000);
                            mClipDrawable2.setLevel(0);
                            break;
                        case 1:
                            mClipDrawable1 = clip1;
                            mClipDrawable2 = clip2Right;
                            mClipDrawable1.setLevel(0);
                            mClipDrawable2.setLevel(10000);
                            break;
                        case 2:
                            mClipDrawable1 = clip2Right;
                            mClipDrawable2 = clip3Left;
                            mClipDrawable1.setLevel(0);
                            mClipDrawable2.setLevel(10000);
                            break;
                    }
                    img1.setImageDrawable(mClipDrawable1);
                    img2.setImageDrawable(mClipDrawable2);
                } else {
                    if (isGoingToRightPage == null) {
                        isGoingToRightPage = position == mCurrentFragmentPosition;
                        Log.e("isGoingToRightPage","isGoingToRightPage"+isGoingToRightPage);
                        if (isGoingToRightPage) {
                            switch (position) {
                                case 0:
                                    mClipDrawable1 = clip1;
                                    mClipDrawable2 = clip2Right;
                                    mClipDrawable1.setLevel(10000);
                                    mClipDrawable2.setLevel(0);
                                    break;
                                case 1:
                                    mClipDrawable1 = clip2Left;
                                    mClipDrawable2 = clip3Right;
                                    mClipDrawable1.setLevel(10000);
                                    mClipDrawable2.setLevel(0);
                                    break;
                                case 2:
                                    mClipDrawable1 = clip3Right;
                                    mClipDrawable2 = clip2Left;
                                    mClipDrawable1.setLevel(10000);
                                    mClipDrawable2.setLevel(0);
                                    break;
                            }
                        } else {
                            switch (position) {
                                case 0:
                                    mClipDrawable1 = clip1;
                                    mClipDrawable2 = clip2Right;
                                    mClipDrawable1.setLevel(10000);
                                    mClipDrawable2.setLevel(0);
                                    break;
                                case 1:
                                    mClipDrawable1 = clip2Left;
                                    mClipDrawable2 = clip1;
                                    mClipDrawable1.setLevel(10000);
                                    mClipDrawable2.setLevel(0);
                                    break;
                                case 2:
                                    mClipDrawable1 = clip3Left;
                                    mClipDrawable2 = clip2Left;
                                    mClipDrawable1.setLevel(10000);
                                    mClipDrawable2.setLevel(0);
                                    break;
                            }
                        }
                        img1.setImageDrawable(mClipDrawable1);
                        img2.setImageDrawable(mClipDrawable2);
                    } else {
                        if (isGoingToRightPage) {
                            // user is going to the right page
                        } else {
                            // user is going to the left page
                        }

                    }
                    mClipDrawable1.setLevel((int) (10000 - (positionOffset * 10000)));
                    mClipDrawable2.setLevel((int) (0 + positionOffset * 10000));
                }
            }

            @Override
            public void onPageSelected(int position) {
                mCurrentFragmentPosition = position;
                isGoingToRightPage = null;
                Log.d("onPageSelected", "onPageSelected" + position);
                switch (position) {
                    case 0:
                        mClipDrawable1 = clip1;
                        mClipDrawable2 = clip2Right;
                        mClipDrawable1.setLevel(9000);
                        mClipDrawable2.setLevel(0);
                        break;
                    case 1:
                        mClipDrawable1 = clip2Left;
                        mClipDrawable2 = clip3Right;
                        mClipDrawable1.setLevel(9000);
                        mClipDrawable2.setLevel(0);
                        break;
                    case 2:
                        mClipDrawable1 = clip3Right;
                        mClipDrawable2 = clip2Left;
                        mClipDrawable1.setLevel(9000);
                        mClipDrawable2.setLevel(0);
                        break;

                }
                mClipDrawable1 = clip1;
                mClipDrawable2 = clip2Right;
                mClipDrawable1.setLevel(0);
                mClipDrawable2.setLevel(10000);
                img1.setImageDrawable(mClipDrawable1);
                img2.setImageDrawable(mClipDrawable2);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
//                switch (state) {
//                    case ViewPager.SCROLL_STATE_DRAGGING:
//                        Log.e("SCROLL_STATE_DRAGGING", "SCROLL_STATE_DRAGGING");
//                        break;
//                    case ViewPager.SCROLL_STATE_IDLE:
//                        Log.e("SCROLL_STATE_IDLE", "SCROLL_STATE_IDLE");
//                        break;
//                    case ViewPager.SCROLL_STATE_SETTLING:
//                        Log.e("SCROLL_STATE_SETTLING", "SCROLL_STATE_SETTLING");
//                        break;
//
//                }
            }
        });

//        mViewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
//            @Override
//            public void transformPage(View page, float position) {
//                Log.d("transformPage","transformPage-->"+position);
//            }
//        });

        mCurrentFragmentPosition = mViewPager.getCurrentItem();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
