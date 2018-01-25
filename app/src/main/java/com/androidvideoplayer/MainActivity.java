package com.androidvideoplayer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.nostra13.universalimageloader.utils.L;
import com.squareup.picasso.Picasso;

import com.androidvideoplayer.R;
import com.google.android.gms.ads.InterstitialAd;

import com.google.android.gms.common.api.GoogleApiClient;


import butterknife.BindView;
import butterknife.ButterKnife;

import static com.androidvideoplayer.R.id.menuAddBottom;
import static com.androidvideoplayer.R.id.menuAddLeft;
import static com.androidvideoplayer.R.id.menuAddRight;
import static com.androidvideoplayer.R.id.menuAddTop;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    MediaController mediaController;
    private InterstitialAd mInterstitialAd;
    LinearLayout buttonContainer1;
    Button btnStartDemo1;
    Animation downntoup;

    ImageView addleft1;
    ImageView addRight1;
    ImageView addBottom1;
    ImageView addLeftLShapedOne1;
    ImageView addLeftLShapedTwo1;
    ImageView addBottomLShapedOne1;
    ImageView addBottomLShapedTwo1;
    ImageView addTop1;


    @BindView(R.id.video)
    VideoView videoView;
    @BindView(R.id.addLeft)
    ImageView addLeft;
    @BindView(R.id.addTop)
    ImageView addTop;
    @BindView(R.id.addBottom)
    ImageView addBottom;
    @BindView(R.id.addRight)
    ImageView addRight;
    @BindView(R.id.addLeftLShapedOne)
    ImageView addLeftLShapedOne;
    @BindView(R.id.addLeftLShapedTwo)
    ImageView addLeftLShapedTwo;
    @BindView(R.id.addBottomLShapedOne)
    ImageView addBottomLShapedOne;
    @BindView(R.id.addBottomLShapedTwo)
    ImageView addBottomLShapedTwo;
    @BindView(R.id.rootVerticalContainer)
    LinearLayout rootVerticalContainer;
    @BindView(R.id.rootHorizontalContainer)
    LinearLayout rootHorizontalContainer;
    @BindView(R.id.rootParent)
    LinearLayout rootParent;
    @BindView(R.id.buttonContainer)
    LinearLayout buttonContainer;
    @BindView(R.id.btnStartDemo)
    Button btnStartDemo;

    String uriPath = "android.resource://com.androidvideoplayer/" + R.raw.androidvideo;
    ;
    int currentPosition = 0;
    boolean isCurrAddInDisplay = false;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //Set On Click Listeners
        setOnClickListeners();

        //Initial States Of Screen
        initialStatesOfScreen();


        btnStartDemo1 = (Button) findViewById(R.id.btnStartDemo);
        buttonContainer1 = (LinearLayout) findViewById(R.id.buttonContainer);
        downntoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        btnStartDemo1.setAnimation(downntoup);


        addleft1 = (ImageView) findViewById(R.id.addLeft);
        Picasso.with(getApplicationContext()).load("https://i.pinimg.com/236x/23/eb/60/23eb6067855364ecaf67df72b40b9926--sports-banners-web-banners.jpg").into(addleft1);

        addRight1 = (ImageView) findViewById(R.id.addRight);
        Picasso.with(getApplicationContext()).load("https://i.pinimg.com/236x/31/03/78/3103788484ed719191009bd6b283540a--design-display-ad-design.jpg").into(addRight1);

        addBottom1 = (ImageView) findViewById(R.id.addBottom);
        Picasso.with(getApplicationContext()).load("https://infiniteingenuity.files.wordpress.com/2015/03/leaderboard.jpg").into(addBottom1);

        addLeftLShapedOne1 = (ImageView) findViewById(R.id.addLeftLShapedOne);
        Picasso.with(getApplicationContext()).load("http://tadsapp1.cloudapp.net/tAdsServer/PoisAdt/getAsset?id=A100014").into(addLeftLShapedOne1);

        addLeftLShapedTwo1 = (ImageView) findViewById(R.id.addLeftLShapedTwo);
        Picasso.with(getApplicationContext()).load("https://infiniteingenuity.files.wordpress.com/2015/03/skyscraper.jpg").into(addLeftLShapedTwo1);

        addBottomLShapedOne1 = (ImageView) findViewById(R.id.addBottomLShapedOne);
        Picasso.with(getApplicationContext()).load("http://baltimoresocial.com/wp-content/uploads/2014/11/nike-banner-ad.jpg").into(addBottomLShapedOne1);

        addBottomLShapedTwo1 = (ImageView) findViewById(R.id.addBottomLShapedTwo);
        Picasso.with(getApplicationContext()).load("https://infiniteingenuity.files.wordpress.com/2015/03/leaderboard.jpg").into(addBottomLShapedTwo1);


        addTop1 = (ImageView) findViewById(R.id.addTop);
        Picasso.with(getApplicationContext()).load("http://myntra.myntassets.com/images/banners/1395060395-Brand-Day_Puma_TNB.jpg").into(addTop1);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.


    }

    @Override
    protected void onStart() {
        super.onStart();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.
        // ATTENTION: This was auto-generated to implement the App Indexing API.

    }


    @Override
    protected void onResume() {
        super.onResume();

        if (currentPosition != 0) {
            videoView.resume();
            videoView.seekTo(currentPosition);
            videoView.start();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        videoView.pause();
        outState.putInt("position", currentPosition);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause();
        currentPosition = videoView.getCurrentPosition();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            int position = savedInstanceState.getInt("position");
            videoView.resume();
            videoView.seekTo(currentPosition);
            videoView.start();
        }

    }


    public void startTimerForBottomAddShape() {
        if (isCurrAddInDisplay == false) {

            new CountDownTimer(10000, 1000) {
                // 10000 milli seconds is total time,
                // 1000 milli seconds is time interval
                AdvertisementOperation adv;

                public void onTick(long millisUntilFinished) {


                    adv = new AdvertisementOperation(VisibilityOperation.menuAddBottom);
                    adv.setAddVisibility();
                    isCurrAddInDisplay = true;

                }

                public void onFinish() {
                    isCurrAddInDisplay = false;
                    adv = new AdvertisementOperation(VisibilityOperation.onlyVideo);
                    adv.setAddVisibility();

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startTimerForTopAddShape();


                        }
                    }, 10000);


                }
            }.start();
        }
    }


    private void startTimerForTopAddShape() {

        if (isCurrAddInDisplay == false) {

            new CountDownTimer(10000, 1000) {
                // 10000 milli seconds is total time,
                // 1000 milli seconds is time interval
                AdvertisementOperation adv;


                public void onTick(long millisUntilFinished) {
                    adv = new AdvertisementOperation(VisibilityOperation.menuAddTop);
                    adv.setAddVisibility();
                    isCurrAddInDisplay = true;
                }

                public void onFinish() {
                    isCurrAddInDisplay = false;
                    adv = new AdvertisementOperation(VisibilityOperation.onlyVideo);
                    adv.setAddVisibility();


                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startTimerForLeftAddShape();
                        }
                    }, 10000);

                }
            }.start();
        }

    }


    private void startTimerForLeftAddShape() {
        if (isCurrAddInDisplay == false) {
            new CountDownTimer(10000, 1000) {
                // 10000 milli seconds is total time,
                // 1000 milli seconds is time interval

                AdvertisementOperation adv;

                public void onTick(long millisUntilFinished) {

                    adv = new AdvertisementOperation(VisibilityOperation.menuAddLeft);
                    adv.setAddVisibility();
                    isCurrAddInDisplay = true;
                }

                public void onFinish() {
                    isCurrAddInDisplay = false;
                    adv = new AdvertisementOperation(VisibilityOperation.onlyVideo);
                    adv.setAddVisibility();

                }
            }.start();
        }
    }

    private void startTimerForRightAddShape() {
        if (isCurrAddInDisplay == false) {

            new CountDownTimer(10000, 1000) {
                // 10000 milli seconds is total time,
                // 1000 milli seconds is time interval

                AdvertisementOperation adv;

                public void onTick(long millisUntilFinished) {
                    adv = new AdvertisementOperation(VisibilityOperation.menuAddRight);
                    adv.setAddVisibility();
                    isCurrAddInDisplay = true;
                }

                public void onFinish() {
                    isCurrAddInDisplay = false;
                    adv = new AdvertisementOperation(VisibilityOperation.onlyVideo);
                    adv.setAddVisibility();
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startTimerForBottomAddShape();
                        }
                    }, 10000);

                }
            }.start();
        }

    }


    private void startTimerForLShape() {
        if (isCurrAddInDisplay == false) {
            new CountDownTimer(10000, 1000) {
                // 10000 milli seconds is total time,
                // 1000 milli seconds is time interval

                //the time is in miliseconds

                AdvertisementOperation adv;

                public void onTick(long millisUntilFinished) {

                    if (millisUntilFinished <= 5000) {
                        adv = new AdvertisementOperation(VisibilityOperation.menuAddLTwo);
                        adv.setAddVisibility();
                        isCurrAddInDisplay = true;
                    } else if ((millisUntilFinished <= 10000)) {
                        adv = new AdvertisementOperation(VisibilityOperation.menuAddLOne);
                        adv.setAddVisibility();
                        isCurrAddInDisplay = true;
                    }
                }

                public void onFinish() {
                    isCurrAddInDisplay = false;
                    adv = new AdvertisementOperation(VisibilityOperation.onlyVideo);
                    adv.setAddVisibility();

                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startTimerForRightAddShape();
                        }
                    }, 10000);

                }

            }.start();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnStartDemo:
                startDemo();
                break;

            case R.id.addLeft:
                addClick(Uri.parse("http://www.nike.com/in/en_gb/"));
                break;

            case R.id.addRight:
                addClick(Uri.parse("http://www.nike.com/in/en_gb/"));
                break;

            case R.id.addTop:
                addClick(Uri.parse("https://in.puma.com/?mktID=PL:Brand%20Marketing:Puma.com-CatchAllPage:India-en&plinkID=Brand"));
                break;

            case R.id.addBottom:
                addClick(Uri.parse("https://in.puma.com/?mktID=PL:Brand%20Marketing:Puma.com-CatchAllPage:India-en&plinkID=Brand"));
                break;

            case R.id.addLeftLShapedOne:
                addClick(Uri.parse("https://www.playclubsport.com"));
                break;

            case R.id.addLeftLShapedTwo:
                addClick(Uri.parse("https://www.mcdonaldsindia.com/"));
                break;

            case R.id.addBottomLShapedOne:
                addClick(Uri.parse("https://www.playclubsport.com"));
                break;

            case R.id.addBottomLShapedTwo:
                addClick(Uri.parse("https://www.mcdonaldsindia.com/"));
                break;

        }
    }


    private void startDemo() {
        AdvertisementOperation adv = new AdvertisementOperation(VisibilityOperation.onlyVideo);
        adv.setAddVisibility();
        startVideo();


        enbleadds();


    }


    private void addClick(Uri add) {
        Intent intent = new Intent(Intent.ACTION_VIEW, add);
        startActivity(intent);
    }

    private void startVideo() {
        //Creating MediaController
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        //specify the location of media file
        Uri vv = Uri.parse(uriPath);

        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(vv);
        videoView.requestFocus();
        videoView.start();
    }

    private void setOnClickListeners() {
        addLeft.setOnClickListener(this);
        addTop.setOnClickListener(this);
        addBottom.setOnClickListener(this);
        addRight.setOnClickListener(this);
        btnStartDemo.setOnClickListener(this);
        addLeftLShapedOne.setOnClickListener(this);
        addLeftLShapedTwo.setOnClickListener(this);
        addBottomLShapedOne.setOnClickListener(this);
        addBottomLShapedTwo.setOnClickListener(this);
    }


    private void initialStatesOfScreen() {
        buttonContainer.setVisibility(View.VISIBLE);
        rootVerticalContainer.setVisibility(View.GONE);

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public enum VisibilityOperation {
        menuAddRight,
        menuAddBottom,
        menuAddLeft,
        menuAddTop,
        menuAddLOne,
        menuAddLTwo,
        startDemo,
        onlyVideo
    }


    public class AdvertisementOperation {
        VisibilityOperation operation;

        public AdvertisementOperation(VisibilityOperation operation) {
            this.operation = operation;
        }

        public void setAddVisibility() {

            switch (operation) {

                case menuAddRight:
                    addleft1.setVisibility(View.GONE);
                    addTop1.setVisibility(View.GONE);
                    addBottom1.setVisibility(View.GONE);
                    addRight1.setVisibility(View.VISIBLE);
                    addLeftLShapedOne1.setVisibility(View.GONE);
                    addLeftLShapedTwo1.setVisibility(View.GONE);
                    addBottomLShapedOne1.setVisibility(View.GONE);
                    addBottomLShapedTwo1.setVisibility(View.GONE);
                    break;

                case menuAddBottom:
                    addleft1.setVisibility(View.GONE);
                    addTop1.setVisibility(View.GONE);
                    addBottom1.setVisibility(View.VISIBLE);
                    addRight1.setVisibility(View.GONE);
                    addLeftLShapedOne1.setVisibility(View.GONE);
                    addLeftLShapedTwo1.setVisibility(View.GONE);
                    addBottomLShapedOne1.setVisibility(View.GONE);
                    addBottomLShapedTwo1.setVisibility(View.GONE);
                    break;

                case menuAddLeft:
                    addleft1.setVisibility(View.VISIBLE);
                    addTop1.setVisibility(View.GONE);
                    addBottom1.setVisibility(View.GONE);
                    addRight1.setVisibility(View.GONE);
                    addLeftLShapedOne1.setVisibility(View.GONE);
                    addLeftLShapedTwo1.setVisibility(View.GONE);
                    addBottomLShapedOne1.setVisibility(View.GONE);
                    addBottomLShapedTwo1.setVisibility(View.GONE);
                    break;

                case menuAddTop:
                    addleft1.setVisibility(View.GONE);
                    addTop1.setVisibility(View.VISIBLE);
                    addBottom1.setVisibility(View.GONE);
                    addRight1.setVisibility(View.GONE);
                    addLeftLShapedOne1.setVisibility(View.GONE);
                    addLeftLShapedTwo1.setVisibility(View.GONE);
                    addBottomLShapedOne1.setVisibility(View.GONE);
                    addBottomLShapedTwo1.setVisibility(View.GONE);
                    break;

                case menuAddLOne:
                    addleft1.setVisibility(View.GONE);
                    addTop1.setVisibility(View.GONE);
                    addBottom1.setVisibility(View.GONE);
                    addRight1.setVisibility(View.GONE);
                    addLeftLShapedOne1.setVisibility(View.GONE);
                    addLeftLShapedTwo1.setVisibility(View.VISIBLE);
                    addBottomLShapedOne1.setVisibility(View.GONE);
                    addBottomLShapedTwo1.setVisibility(View.VISIBLE);
                    break;


                case menuAddLTwo:
                    addleft1.setVisibility(View.GONE);
                    addTop1.setVisibility(View.GONE);
                    addBottom1.setVisibility(View.GONE);
                    addRight1.setVisibility(View.GONE);
                    addLeftLShapedOne1.setVisibility(View.VISIBLE);
                    addLeftLShapedTwo1.setVisibility(View.GONE);
                    addBottomLShapedOne1.setVisibility(View.VISIBLE);
                    addBottomLShapedTwo1.setVisibility(View.GONE);
                    break;

                case startDemo:
                    addleft1.setVisibility(View.GONE);
                    addTop1.setVisibility(View.GONE);
                    addBottom1.setVisibility(View.GONE);
                    addRight1.setVisibility(View.VISIBLE);
                    buttonContainer.setVisibility(View.GONE);
                    rootVerticalContainer.setVisibility(View.VISIBLE);
                    addLeftLShapedOne1.setVisibility(View.GONE);
                    addLeftLShapedTwo1.setVisibility(View.GONE);
                    addBottomLShapedOne1.setVisibility(View.GONE);
                    addBottomLShapedTwo1.setVisibility(View.GONE);
                    break;

                case onlyVideo:
                    addleft1.setVisibility(View.GONE);
                    addTop1.setVisibility(View.GONE);
                    addBottom1.setVisibility(View.GONE);
                    addRight1.setVisibility(View.GONE);
                    buttonContainer.setVisibility(View.GONE);
                    rootVerticalContainer.setVisibility(View.VISIBLE);
                    addLeftLShapedOne1.setVisibility(View.GONE);
                    addLeftLShapedTwo1.setVisibility(View.GONE);
                    addBottomLShapedOne1.setVisibility(View.GONE);
                    addBottomLShapedTwo1.setVisibility(View.GONE);
                    break;

            }
        }
    }

    public void enbleadds() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startTimerForBottomAddShape();
            }
        }, 5000);

    }
}