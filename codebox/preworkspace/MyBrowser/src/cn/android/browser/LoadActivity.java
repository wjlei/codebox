package cn.android.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.TextView;




public class LoadActivity extends Activity {
     
     private static final int LOAD_DISPLAY_TIME = 1500;
     
     /** Called when the activity is first created. */
     @Override
     public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         
         getWindow().setFormat(PixelFormat.RGBA_8888);
         getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);
 
         setContentView(R.layout.load);
 
         new Handler().postDelayed(new Runnable() {
             public void run() {
                 /* Create an Intent that will start the Main WordPress Activity. */
                 Intent mainIntent = new Intent(LoadActivity.this, Main.class);
                 LoadActivity.this.startActivity(mainIntent);
                 LoadActivity.this.finish();
             }
         }, LOAD_DISPLAY_TIME); //1500 for release
 
     }
 }