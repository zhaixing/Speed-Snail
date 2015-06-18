package com.example.snail;


import java.io.IOException;

import com.example.ant.R;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainPage extends Activity {
    ImageButton mainpage_help=null;
    ImageButton mainpage_exit=null;
    ImageButton mainpage_start=null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
        mainpage_help=(ImageButton)findViewById(R.id.mainpage_help);
        mainpage_help.setOnClickListener(new OnClickListener(){
        
        @Override
        public void onClick(View v){
        	Intent intent=new Intent();
        	intent.setClass(MainPage.this,help.class);
        	startActivity(intent);
        
        }
        });
        mainpage_exit=(ImageButton)findViewById(R.id.mainpage_exit);
        mainpage_exit.setOnClickListener(new OnClickListener(){
        
        @Override
        public void onClick(View v){
        	System.exit(0);
        
        }
        });
        mainpage_start=(ImageButton)findViewById(R.id.mainpage_start);
        mainpage_start.setOnClickListener(new OnClickListener(){
        
        @Override
        public void onClick(View v){
        	Intent intent=new Intent();
        	intent.setClass(MainPage.this,levelshow.class);
        	startActivity(intent);
        
        }
        });
      
        
    }
    private MediaPlayer mMediaPlayer; 
    private void playLocalFile() {        
        mMediaPlayer = MediaPlayer.create(this,R.raw.clear);       
    try {    
        mMediaPlayer.prepare();       
    }   catch (IllegalStateException e) {                   
    }    catch (IOException e) { 
    }
    mMediaPlayer.start();        
    
   // mMediaPlayer.setOnCompletionListener(new OnCompletionListener() {                
     //   public void onCompletion(MediaPlayer mp) {                          
       //  }}); 
    }
    
    
    
    
    //实现按返回键退出android程序的的功能
    /*
    @Override  
    public boolean onKeyDown(int keyCode, KeyEvent event)  
    {  
        if (keyCode == KeyEvent.KEYCODE_BACK )  
        {  
            // 创建退出对话框  
            AlertDialog isExit = new AlertDialog.Builder(this).create();  
            // 设置对话框标题  
            isExit.setTitle("系统提示");  
            // 设置对话框消息  
            isExit.setMessage("确定要退出吗");  
            // 添加选择按钮并注册监听  
            isExit.setButton("确定", listener);  
            isExit.setButton2("取消", listener);  
            // 显示对话框  
            isExit.show();  
  
        }  
          
        return false;  
          
    }  
    //监听对话框里面的button点击事件  
    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener()  
    {  
        public void onClick(DialogInterface dialog, int which)  
        {  
            switch (which)  
            {  
            case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序  
                finish();  
                break;  
            case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框  
                break;  
            default:  
                break;  
            }  
        }  
    };  */  
    protected void dialog() { 
        AlertDialog.Builder builder = new Builder(MainPage.this); 
        builder.setMessage("确定要退出吗?"); 
        builder.setTitle("提示"); 
        builder.setPositiveButton("确认", 
                new android.content.DialogInterface.OnClickListener() { 
                    @Override
                    public void onClick(DialogInterface dialog, int which) { 
                        dialog.dismiss(); 
                        MainPage.this.finish(); 
                    } 
                }); 
        builder.setNegativeButton("取消", 
                new android.content.DialogInterface.OnClickListener() { 
                    @Override
                    public void onClick(DialogInterface dialog, int which) { 
                        dialog.dismiss(); 
                    } 
                }); 
        builder.create().show(); 
    } 
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { 
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) { 
            dialog(); 
            return false; 
        } 
        return false; 
    }
}


    

