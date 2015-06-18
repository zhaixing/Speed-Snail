package com.example.snail;   
import java.util.Timer; 
import java.util.TimerTask;   

import com.example.ant.R;
import com.example.snail.Drawl;

import android.app.Activity; 
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle; 
import android.os.Handler;  
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;  
import android.widget.FrameLayout.LayoutParams;   
public class MainActivity3 extends Activity { 
	//ImageButton level0=null;
	ImageView trap0 = null;
	ImageView trap1 = null;
	ImageView trap2 = null;
	ImageView trap3 = null;
	ImageView food0 = null;
	ImageView home0 = null;
	@Override   
	protected void onPause() {     
		timer.cancel();      
		timetask.cancel();   
		super.onPause();   
		Music.stop(this);}  
	@Override   
	protected void onResume() {   
		timer=new Timer();    
		timetask=new TimerTask() {         
			@Override     
			public void run() {     
				// TODO Auto-generated method stub     
				handler.sendEmptyMessage(0);     
				}    
			};      
			timer.schedule(timetask, 20,20); 
		
	

  super.onResume();   
  Music.play(this,R.raw.background);
  }   
  private FrameLayout mainLayout;      
  private Timer timer;      
  private TimerTask timetask;     
  private Activity2 ball;      
  private Activity2[] balls=new Activity2[1];           
  private FrameLayout.LayoutParams ballLp;     
	private Drawl bDrawl;
  public void onCreate(Bundle savedInstanceState) {  
	  //FrameLayout fl=new FrameLayout(this);
	  super.onCreate(savedInstanceState); 
	  setContentView(R.layout.guanka3);
	  //�ϰ���
	  trap0=(ImageView)findViewById(R.id.trap0);
      
      MarginLayoutParams margin9 = new MarginLayoutParams(
    		  trap0.getLayoutParams());
      margin9.setMargins(50, 100, 0, 0);//����߾�400���أ����߾�10���ص�λ����ʾͼƬ
      FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(margin9);
      layoutParams9.height = 30;//����ͼƬ�ĸ߶�
      layoutParams9.width = 30; //����ͼƬ�Ŀ��
      trap0.setLayoutParams(layoutParams9);
      
      trap1=(ImageView)findViewById(R.id.trap1);
      
      MarginLayoutParams margin10 = new MarginLayoutParams(
    		  trap1.getLayoutParams());
      margin10.setMargins(50, 200, 0, 0);//����߾�400���أ����߾�10���ص�λ����ʾͼƬ
      FrameLayout.LayoutParams layoutParams10 = new FrameLayout.LayoutParams(margin10);
      layoutParams10.height = 30;//����ͼƬ�ĸ߶�
      layoutParams10.width = 30; //����ͼƬ�Ŀ��
      trap1.setLayoutParams(layoutParams10);
      
      
      trap2=(ImageView)findViewById(R.id.trap2);
      
      MarginLayoutParams margin11 = new MarginLayoutParams(
    		  trap2.getLayoutParams());
      margin11.setMargins(270, 100, 0, 0);//����߾�400���أ����߾�10���ص�λ����ʾͼƬ
      FrameLayout.LayoutParams layoutParams11 = new FrameLayout.LayoutParams(margin11);
      layoutParams11.height = 30;//����ͼƬ�ĸ߶�
      layoutParams11.width = 30; //����ͼƬ�Ŀ��
      trap2.setLayoutParams(layoutParams11);
      trap3=(ImageView)findViewById(R.id.trap3);
      
      MarginLayoutParams margin14 = new MarginLayoutParams(
    		  trap3.getLayoutParams());
      margin14.setMargins(270, 200, 0, 0);//����߾�400���أ����߾�10���ص�λ����ʾͼƬ
      FrameLayout.LayoutParams layoutParams14 = new FrameLayout.LayoutParams(margin14);
      layoutParams14.height = 30;//����ͼƬ�ĸ߶�
      layoutParams14.width = 30; //����ͼƬ�Ŀ��
      trap3.setLayoutParams(layoutParams14);
      //ʳ��
      food0 =(ImageView)findViewById(R.id.food0 );
      
      MarginLayoutParams margin12 = new MarginLayoutParams(
    		  food0.getLayoutParams());
      margin12.setMargins(100, 200, 0, 0);//����߾�400���أ����߾�10���ص�λ����ʾͼƬ
      FrameLayout.LayoutParams layoutParams12 = new FrameLayout.LayoutParams(margin12);
      layoutParams12.height = 30;//����ͼƬ�ĸ߶�
      layoutParams12.width = 30; //����ͼƬ�Ŀ��
      food0.setLayoutParams(layoutParams12);
      //����
      home0 =(ImageView)findViewById(R.id.home0 );
      
      MarginLayoutParams margin13 = new MarginLayoutParams(
    		  home0.getLayoutParams());
      margin13.setMargins(50, 300, 0, 0);//����߾�400���أ����߾�10���ص�λ����ʾͼƬ
      FrameLayout.LayoutParams layoutParams13 = new FrameLayout.LayoutParams(margin13);
      layoutParams13.height = 30;//����ͼƬ�ĸ߶�
      layoutParams13.width = 30; //����ͼƬ�Ŀ��
      home0.setLayoutParams(layoutParams13);
      
	  mainLayout=(FrameLayout) findViewById(R.id.mainlayout);
	  bDrawl=new Drawl(this);
	  mainLayout.addView(bDrawl);
	  //��view��ͼ�ŵ�Activity����ʾ
	  //setContentView(fl);  
	  
	           
	  for (int i = 0; i < balls.length; i++) {    
		  ball=new Activity2(this);    
		  balls[i]=ball;        
		  mainLayout.addView(ball,30,30);
		  //ball.setVisibility(View.INVISIBLE);

		  ballLp=(LayoutParams) ball.getLayoutParams();    
		  ballLp.leftMargin=((int)Math.random()*0);    
		  ballLp.topMargin=((int)Math.random()*0);      
		  }       
	  }     
  private final Handler handler=new Handler() {      
	  public void handleMessage(android.os.Message msg) {       
		  for (Activity2 ball : balls) {     
			  ball.move();  
			  //
			  if (ballLp.topMargin>100&&ballLp.topMargin<130&&ballLp.leftMargin>50&&ballLp.leftMargin<80) {    
				  //new AlertDialog.Builder(com.example.snail.MainActivity.this).setTitle("ɾ����ʾ��").setMessage("ȷ��ɾ�������ݣ�").setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
				  ball.x=0;
					ball.y=0;
					ballLp.topMargin=0;
					ballLp.leftMargin=0;  
				  AlertDialog.Builder builder  = new Builder(com.example.snail.MainActivity3.this);
					  builder.setTitle("�����ϰ�����������" ) ;
					  builder.setMessage("�Ƿ�Ҫ��������ȥ�أ�" ) ;
					  builder.setPositiveButton("��" ,  null );
					 
					  builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() { 
						  public void onClick(DialogInterface dialog, int which) { 
							  Intent intent=new Intent();
					        	intent.setClass(MainActivity3.this,MainActivity3.class);
					        	MainActivity3.this.finish(); 
					        	startActivity(intent);
							  //finish();
						  }
						  
					  });
					  builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() { 
						  public void onClick(DialogInterface dialog, int which) { 
							  Intent intent=new Intent();
					        	intent.setClass(MainActivity3.this,MainPage.class);
					        	startActivity(intent);
							  //finish();
						  }
						  
					  });
					 
					  builder.show();
	    		   } 
			  
			  if (ballLp.topMargin>200&&ballLp.topMargin<230&&ballLp.leftMargin>50&&ballLp.leftMargin<80) {    
				  //new AlertDialog.Builder(com.example.snail.MainActivity.this).setTitle("ɾ����ʾ��").setMessage("ȷ��ɾ�������ݣ�").setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
				  ball.x=0;
					ball.y=0;
					ballLp.topMargin=0;
					ballLp.leftMargin=0;  
				  AlertDialog.Builder builder  = new Builder(com.example.snail.MainActivity3.this);
					  builder.setTitle("�����ϰ�����������" ) ;
					  builder.setMessage("�Ƿ�Ҫ��������ȥ�أ�" ) ;
					  builder.setPositiveButton("��" ,  null );
					 
					  builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() { 
						  public void onClick(DialogInterface dialog, int which) { 
							  Intent intent=new Intent();
					        	intent.setClass(MainActivity3.this,MainActivity3.class);
					        	MainActivity3.this.finish(); 
					        	startActivity(intent);
							  //finish();
						  }
						  
					  });
					  builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() { 
						  public void onClick(DialogInterface dialog, int which) { 
							  Intent intent=new Intent();
					        	intent.setClass(MainActivity3.this,MainPage.class);
					        	startActivity(intent);
							  //finish();
						  }
						  
					  });
					 
					  builder.show();
	    		   } 
			  
			  if (ballLp.topMargin>100&&ballLp.topMargin<130&&ballLp.leftMargin>270&&ballLp.leftMargin<300) {    
				  //new AlertDialog.Builder(com.example.snail.MainActivity.this).setTitle("ɾ����ʾ��").setMessage("ȷ��ɾ�������ݣ�").setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
				  ball.x=0;
					ball.y=0;
					ballLp.topMargin=0;
					ballLp.leftMargin=0;  
				  AlertDialog.Builder builder  = new Builder(com.example.snail.MainActivity3.this);
					  builder.setTitle("�����ϰ�����������" ) ;
					  builder.setMessage("�Ƿ�Ҫ��������ȥ�أ�" ) ;
					  builder.setPositiveButton("��" ,  null );
					 
					  builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() { 
						  public void onClick(DialogInterface dialog, int which) { 
							  Intent intent=new Intent();
					        	intent.setClass(MainActivity3.this,MainActivity3.class);
					        	MainActivity3.this.finish(); 
					        	startActivity(intent);
							  //finish();
						  }
						  
					  });
					  builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() { 
						  public void onClick(DialogInterface dialog, int which) { 
							  Intent intent=new Intent();
					        	intent.setClass(MainActivity3.this,MainPage.class);
					        	startActivity(intent);
							  //finish();
						  }
						  
					  });
					 
					  builder.show();
	    		   } 
			  if (ballLp.topMargin>200&&ballLp.topMargin<230&&ballLp.leftMargin>270&&ballLp.leftMargin<300) {    
				  //new AlertDialog.Builder(com.example.snail.MainActivity.this).setTitle("ɾ����ʾ��").setMessage("ȷ��ɾ�������ݣ�").setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
				  ball.x=0;
					ball.y=0;
					ballLp.topMargin=0;
					ballLp.leftMargin=0;  
				  AlertDialog.Builder builder  = new Builder(com.example.snail.MainActivity3.this);
					  builder.setTitle("�����ϰ�����������" ) ;
					  builder.setMessage("�Ƿ�Ҫ��������ȥ�أ�" ) ;
					  builder.setPositiveButton("��" ,  null );
					 
					  builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() { 
						  public void onClick(DialogInterface dialog, int which) { 
							  Intent intent=new Intent();
					        	intent.setClass(MainActivity3.this,MainActivity3.class);
					        	MainActivity3.this.finish(); 
					        	startActivity(intent);
							  //finish();
						  }
						  
					  });
					  builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() { 
						  public void onClick(DialogInterface dialog, int which) { 
							  Intent intent=new Intent();
					        	intent.setClass(MainActivity3.this,MainPage.class);
					        	startActivity(intent);
							  //finish();
						  }
						  
					  });
					 
					  builder.show();
	    		   } 
			  if (ballLp.topMargin>300&&ballLp.topMargin<330&&ballLp.leftMargin>50&&ballLp.leftMargin<80) {
					ball.x=0;
					ball.y=0;
					ballLp.topMargin=0;
					ballLp.leftMargin=0;

				  AlertDialog.Builder builder  = new Builder(com.example.snail.MainActivity3.this);
				  builder.setTitle("��������������" ) ;
				  builder.setMessage("�Ƿ�Ҫ��������ȥ�أ�" ) ;
				  builder.setPositiveButton("��" ,  null );
				 
				  builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() { 
					  public void onClick(DialogInterface dialog, int which) { 
						  
						  MainActivity3.this.finish(); 
						  Intent intent=new Intent();
				        	intent.setClass(MainActivity3.this,MainActivity.class);
							  MainActivity3.this.finish(); 
				        	startActivity(intent);
						  //finish();
					  }
					  
				  });
				  builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() { 
					  public void onClick(DialogInterface dialog, int which) { 
						  Intent intent=new Intent();
				        	intent.setClass(MainActivity3.this,MainPage.class);
				        	startActivity(intent);
						  //finish();
					  }
					  
				  });
				  
				  builder.show();
			  }
			   
			  //
			  }       
		  };    
		  }; 
		  
		  
		  
		//�˳����ڵļ�ͣ�¼�
		  protected void dialog() { 
		        AlertDialog.Builder builder = new Builder(MainActivity3.this); 
		        builder.setMessage("ȷ��Ҫ�˳���?"); 
		        builder.setTitle("��ʾ"); 
		        builder.setPositiveButton("ȷ��", 
		                new android.content.DialogInterface.OnClickListener() { 
		                    @Override
		                    public void onClick(DialogInterface dialog, int which) { 
		                        dialog.dismiss(); 
		                        MainActivity3.this.finish(); 
		                      
		                    } 
		                }); 
		        builder.setNegativeButton("ȡ��", 
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