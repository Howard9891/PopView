package com.iyuba.myapplication;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.mingyu.lib.Utils.DensityUtil;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;
import butterknife.Bind;
import butterknife.ButterKnife;
public class MainActivity extends AppCompatActivity {
    private RelativeLayout rl_topTobottom;
    private ListView listView;
    private RelativeLayout rl_main;
    private Toolbar toolbar;
    private int height;
    private PopupWindow popupWindow;
    private ListView lv_list;
    private RelativeLayout rl_list;
    private int listViewHeight;
    private Button btn_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.e("MainActivity", "oncreate");
        rl_main = (RelativeLayout) findViewById(R.id.main);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setNavigationIcon(R.mipmap.ic_keyboard_backspace_black_36dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        lv_list = (ListView) findViewById(R.id.lv_list);
        rl_list = (RelativeLayout) findViewById(R.id.rl_list);
        btn_click = (Button) findViewById(R.id.btn_click);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("MainActivity","dumingyu");
            }
        });
        rl_topTobottom = (RelativeLayout) findViewById(R.id.rl_topTobottom);
        rl_topTobottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = View.inflate(MainActivity.this, R.layout.item_popupwindow, null);
              /*  listView = (ListView) view.findViewById(R.id.listView);
                listView.setAdapter(new ExamItemAdapter(Data.getInstance().getDatas()));
                popupWindow = new PopupWindow(view,
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
                popupWindow.setFocusable(true);
                popupWindow.setTouchable(true);
                popupWindow.setAnimationStyle(R.style.pop_in);
                popupWindow.showAtLocation(toolbar, Gravity.TOP, 0, height);
                popupWindow.update();*/
                //
                lv_list.setAdapter(new ExamItemAdapter(Data.getInstance().getDatas()));
                rl_list.setVisibility(View.VISIBLE);
                //lv_list.startAnimation(getAnimationIn());
                proPertyAnimationIn();
            }
        });
        lv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                proPertyAnimationOut();
                Log.e("MainActivity","listView item click position>>>>"+position);
            }
        });
        rl_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               proPertyAnimationOut();
            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.e("MainActivity","onWindowFocusChanged");
        int toTobottom_height = rl_topTobottom.getHeight();
        int toolbar_height = toolbar.getHeight();
        height = toolbar_height + toTobottom_height + DensityUtil.getStatusBarHeight(this);
       // listViewHeight = lv_list.getHeight();
    }
    public Animation getAnimationIn() {

        Animation animation = new TranslateAnimation(0, 0, -600,listViewHeight);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.e("MainActivity", "animation start");
            }
            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animation.setDuration(500);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.start();
        return animation;
    }
    public Animation getAnimationOut(){
        Animation animation = new TranslateAnimation(0, 0, 0,-600);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.e("MainActivity", "animation start");
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animation.setDuration(500);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.start();
        return animation;
    }
    @Override
    public void onBackPressed() {
       // lv_list.startAnimation(getAnimationOut());
       // super.onBackPressed();

        proPertyAnimationOut();
    }

    public void proPertyAnimationIn(){
        Log.e("MainActivity","listViewHeight="+listViewHeight);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(lv_list,"translationY",-600,0);
        objectAnimator.setDuration(500);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
            @Override
            public void onAnimationEnd(Animator animation) {

            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        rl_list.setBackgroundColor(0xaaff6600);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.start();
    }
    public void proPertyAnimationOut(){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(lv_list,"translationY",0,-600);
        objectAnimator.setDuration(300);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }
            @Override
            public void onAnimationEnd(Animator animation) {
                rl_list.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        rl_list.setBackgroundColor(0xffffff);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.start();
    }
}
