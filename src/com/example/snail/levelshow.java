package com.example.snail;


import com.example.ant.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;


public class levelshow extends Activity {
	ImageButton level0=null;
	ImageButton level1=null;
	ImageButton level2=null;
	ImageButton level3=null;
	int screenWidth;//屏幕宽度 
	int screenHeight;//屏幕高度 
	int xdzuo;//xiangduizuo
	int xdgao;//相对高
	int xxdzuo;//想相对左
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level);
        level0=(ImageButton)findViewById(R.id.level0);
        
        //获取屏幕的宽度高度
WindowManager windowManager = getWindowManager();   
        
        Display display = windowManager.getDefaultDisplay();   
          
        screenWidth = display.getWidth();   
          
        screenHeight = display.getHeight(); 
        
        xdzuo=(screenWidth-screenHeight/2)/2;
        xdgao=(screenHeight-screenHeight/2)/3;
        xxdzuo=xdzuo*2+screenHeight/2;
        MarginLayoutParams margin9 = new MarginLayoutParams(
        		level0.getLayoutParams());
        margin9.setMargins(xdzuo, xdgao, 0, 0);//在左边距400像素，顶边距10像素的位置显示图片
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(margin9);
        //layoutParams9.height = 200;//设置图片的高度
        //layoutParams9.width = 200; //设置图片的宽度

        layoutParams9.height =screenHeight/2;
        layoutParams9.width = screenHeight/2;

        level0.setLayoutParams(layoutParams9);
        
        level1=(ImageButton)findViewById(R.id.level1);
        level1=(ImageButton)findViewById(R.id.level1);
        MarginLayoutParams margin1 = new MarginLayoutParams(
        		level1.getLayoutParams());
        margin1.setMargins(xxdzuo+xdzuo, xdgao, 0, 0);//在左边距400像素，顶边距10像素的位置显示图片
        RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(margin1);
        layoutParams1.height = screenHeight/2;//设置图片的高度
        layoutParams1.width = screenHeight/2; //设置图片的宽度
        level1.setLayoutParams(layoutParams1);
        
        level2=(ImageButton)findViewById(R.id.level2);
        level2=(ImageButton)findViewById(R.id.level2);
        MarginLayoutParams margin2 = new MarginLayoutParams(
        		level2.getLayoutParams());
        margin2.setMargins(2*xxdzuo+xdzuo, xdgao, 0, 0);//在左边距400像素，顶边距10像素的位置显示图片
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(margin2);
        layoutParams2.height = screenHeight/2;//设置图片的高度
        layoutParams2.width = screenHeight/2; //设置图片的宽度
        level2.setLayoutParams(layoutParams2);
        
        level3=(ImageButton)findViewById(R.id.level3);
        level3=(ImageButton)findViewById(R.id.level3);
        MarginLayoutParams margin3 = new MarginLayoutParams(
        		level3.getLayoutParams());
        margin3.setMargins(3*xxdzuo+xdzuo, xdgao, 0, 0);//在左边距400像素，顶边距10像素的位置显示图片
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(margin3);
        layoutParams3.height = screenHeight/2;//设置图片的高度
        layoutParams3.width = screenHeight/2; //设置图片的宽度
        level3.setLayoutParams(layoutParams3);
        
        
        level0.setOnClickListener(new OnClickListener(){
        
        @Override
        public void onClick(View v){
        	Intent intent=new Intent();
        	intent.setClass(levelshow.this,MainActivity1.class);
        	startActivity(intent);
        
        }
        });
        
        
        level1.setOnClickListener(new OnClickListener(){
            
            @Override
            public void onClick(View v){
            	Intent intent=new Intent();
            	intent.setClass(levelshow.this,MainActivity2.class);
            	startActivity(intent);
            
            }
            });
       level2.setOnClickListener(new OnClickListener(){
            
            @Override
            public void onClick(View v){
            	Intent intent=new Intent();
            	intent.setClass(levelshow.this,MainActivity.class);
            	startActivity(intent);
            
            }
            });
       
       level3.setOnClickListener(new OnClickListener(){
           
           @Override
           public void onClick(View v){
           	Intent intent=new Intent();
           	intent.setClass(levelshow.this,MainActivity3.class);
           	startActivity(intent);
           
           }
           });
        }
    
    
    

   
    
    
}
