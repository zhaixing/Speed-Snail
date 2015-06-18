package com.example.snail;import java.security.PublicKey;

import android.R.integer;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

 

//新建一个类继承View

public class Drawl extends View{
	  static int upX;
	  static int upY;
	  static int downX;
	     static int downY;
	     static int moveX; 
	     static int moveY;
	  
    private Paint paint = null;
    //构造方法用于初始化Paint对象
    public Drawl(Context context) {
                 super(context);
                 paint = new Paint();
                 paint.setStrokeWidth(1);
                 paint.setAntiAlias(true);
                 paint.setColor(Color.BLACK);
                 paint.setStyle(Style.STROKE);
     }

     @Override
     protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
               // setWillNotDraw(false);

                canvas.drawLine(downX, downY, moveX, moveY, paint);
                
     }

     @Override
     public boolean onTouchEvent(MotionEvent event) {
                switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                        downX = (int) event.getX();
                        downY =(int)  event.getY();
                        invalidate();
                        break;
                case MotionEvent.ACTION_MOVE:
                        moveX = (int) event.getX();
                        moveY = (int) event.getY();
                        invalidate();
                        break;
               case MotionEvent.ACTION_UP:
                        upX = (int) event.getX();
                        upY = (int) event.getY();
                        invalidate();
                        break;
                }
               moveX = (int) event.getX();
               moveY = (int) event.getY();
               return true;
 }
   
   
     
}