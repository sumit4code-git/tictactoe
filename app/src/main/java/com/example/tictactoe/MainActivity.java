package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityViewCommand;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;


public class MainActivity extends AppCompatActivity {
    //Player repersentation
    //0-X
    //1-O
    int activeplayer=0;
    boolean game=true;
    int c=0;
    LottieAnimationView lt;
    int[] gamestate={2, 2, 2, 2, 2, 2, 2, 2, 2};
    //game statemeaning
    //0-X,1-O,2-null
    int[][] winingposition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void playertap(View view)
    {
        ImageView img=(ImageView) view;//View is the Super Class of ImageView. you can draw all
        // android control event like as (Button, EditText,TextView, CheckBox) in view
        //ImageView you can draw an Image in imageView.//you can not directly add image on View but you can Typecast View to imageView
        int tappedimage=Integer.parseInt(img.getTag().toString());
        if(!game) {
            reset(view);
        }
        Log.v("myTag", "This is my message");
            if (gamestate[tappedimage] == 2) {
                gamestate[tappedimage] = activeplayer;

                if (activeplayer == 0) {
                    img.setRotationX(-2000f);
                    img.setImageResource(R.drawable.x);
                    activeplayer = 1;
                    TextView status=findViewById(R.id.status);
                    status.setText("\uD835\uDD46'\uD835\uDD64 \uD835\uDD65\uD835\uDD66\uD835\uDD63\uD835\uDD5F \uD835\uDD65\uD835\uDD60 \uD835\uDD61\uD835\uDD5D\uD835\uDD52\uD835\uDD6A");
                    c++;
                    img.animate().rotationXBy(2000f).setDuration(150);

                } else if(activeplayer==1){
                    img.setRotationY(-2000f);
                    img.setImageResource(R.drawable.o);
                    activeplayer = 0;
                    TextView status=findViewById(R.id.status);
                    status.setText("\uD835\uDD4F'\uD835\uDD64 \uD835\uDD65\uD835\uDD66\uD835\uDD63\uD835\uDD5F \uD835\uDD65\uD835\uDD60 \uD835\uDD61\uD835\uDD5D\uD835\uDD52\uD835\uDD6A");
                    c++;
                    img.animate().rotationYBy(2000f).setDuration(150);
                }

            }
            int i,j=0,found;
         //   found=winingposition[4][1];
        //TextView status=findViewById(R.id.status);
        //status.setText(found);

        for(i=0;i<8;i++)
        {
            Log.v("tag","value"+gamestate[i]);
            if(gamestate[winingposition[i][j]]==gamestate[winingposition[i][j+1]]&&gamestate[winingposition[i][j+1]]==gamestate[winingposition[i][j+2]])
            {
                found=gamestate[winingposition[i][j]];
                if(found==0)
                {
                    TextView status=findViewById(R.id.status);
                    status.setText("\uD835\uDD4F ℍ\uD835\uDD38\uD835\uDD4A \uD835\uDD4E\uD835\uDD46ℕ");
                    lt=findViewById(R.id.animationView);
                  lt.playAnimation();

                    lt.setRepeatCount(-8);
                   //int ntap= Integer.parseInt(img.getTag().toString());
                   //reset(view);

                    game=false;


                }
                if(found==1){
                    TextView status=findViewById(R.id.status);
                    status.setText("\uD835\uDD46 ℍ\uD835\uDD38\uD835\uDD4A \uD835\uDD4E\uD835\uDD46ℕ");
                    lt=findViewById(R.id.animationView);
                    lt.playAnimation();
                    lt.setRepeatCount(-8);

                  // int ntap= Integer.parseInt(img.getTag().toString());
                    //reset(view);
                    game=false;
                }
            }
        }
        if(c>=9&&game==true)
        {
            TextView status=findViewById(R.id.status);
            status.setText("\uD835\uDD44\uD835\uDD38\uD835\uDD4Bℂℍ \uD835\uDD3Bℝ\uD835\uDD38\uD835\uDD4E");
        }
  //      if(gamestate[tappedimage]==3)
    //{
      //  TextView status=findViewById(R.id.status);
        //status.setText("reset for another");
    //}

        }

public void reset(View view)
{
    TextView status=findViewById(R.id.status);
    status.setText("\uD835\uDD43\uD835\uDD3C\uD835\uDD4B'\uD835\uDD4A ℙ\uD835\uDD43\uD835\uDD38\uD835\uDD50");
    game=true;
    c=0;
    activeplayer=0;
    for(int i=0;i<9;i++)
        gamestate[i]=2;
    lt=findViewById(R.id.animationView);
    lt.clearAnimation();

//    lt.cancelAnimation();
    ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}