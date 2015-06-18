package com.example.snail;  
import com.example.ant.R;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context; 
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView; 
//import android.widget.RelativeLayout;  
import android.widget.FrameLayout.LayoutParams;   
public class Activity2 extends ImageView {  
public int lax;
public int lay;
public int lbx;
public int lby;
private static int iscolloction;
public static boolean lineWidthRect(int x1, int y1, int x2, int y2, int x, int y, int width, int height)
{
		double a =(double) ((y1 - y2)) / (double) ((x1 - x2));  	     
		double b =y1 - a * x1;
		if (x1 < x2)
		{
			for (int i =x1; i <= x2; i++)
			{  	     
				int tempY =(int) (a * i + b);
				if (intersectRect(i, tempY, 1, 1, x, y, width, height)) 
				{
		  		 //if ((x<i&&i<x+width)&&(tempY>y&&tempY<y+height)) {
			  		 iscolloction=1;
			  		 return true;
			  	}
			}
		} 
		else if (x1 > x2) 
		{
		  	   for (int i =x1; i >= x2; i--) 
		  	   {
		  		   int tempY =(int) (a * i + b);  	     
			  	   if (intersectRect(i, tempY, 1, 1, x, y, width, height)) 
			  	   {
			  		   iscolloction=2;
			  		   return true;
			  	   }  	     
		  	   }
	  	     
	  	 } 
		else 
		{
		  	   if (y1 <= y2) 
		  	   {
		  		   for (int i =y1; i < y2; i++)
		  		   {
		  			   if (intersectRect(x1, i, 1, 1, x, y, width, height)) 
		  			   {
				  		   return true;
				  	   }
		  		   }
		  	   } 
		  	   else 
		  	   {
		  		   for (int i =y2; i > y2; i--)
		  		   {	     
		  			   if (intersectRect(x1, i, 1, 1, x, y, width, height)) 
		  			   {
	  	       			   return true;
	  	       		   }
		  		   }
	  	       }
		  }
		return false;
}
	 //检查点是不是在矩形里面
      private static boolean intersectRect(int i, int tempY, int j, int k, int x,
			int y, int width, int height) {
		// TODO Auto-generated method stub
    	  if((x<i&&i<x+width)&&(tempY>y&&tempY<y+height))
    	  {return true;}
    	  else
		return false;
    	 
	}
      ////////////////////交换函数
      public static void swap (float x2, float y2) {      
	        float temp = x2;  
	        x2 = y2;  
	        y2 = temp;  
	    }; 
	    ///////////////////////交换函数结束
	static  float x=0;    
      static  float y=0;  //x,y代表速度
       private  FrameLayout.LayoutParams rllp;  
       public Activity2(Context context) {       
    	   super(context);    
    	   x=(float)1;   
    	   y=(float)1;       
    	   
    	   
    	   }    
       
       public void move(){   
    	   rllp=(LayoutParams) getLayoutParams(); 
    	  
    	   rllp.leftMargin+=(float)x;   
    	   rllp.topMargin+=(float)y;   
    	
    	   //检测碰撞可用的
    	  /* if(lineWidthRect(Drawl.downX, Drawl.downY,Drawl. moveX, Drawl.moveY,rllp.leftMargin,rllp.topMargin,20,20))
    	   {
    		   x=-x;  
    		   y=-y;
    	   }*/
    	   
    	   //碰撞检测函数
    	   lax=Drawl.downX;
		   lay=Drawl.downY;
		   lbx=Drawl.moveX;
		   lby=Drawl.moveY;
		   /*
		   if(lax-lbx==lay-lby)
		   {x=-x;y=-y;}
		   if(lax-lbx==-lay+lby)
		   {x=-x;y=-y;}*/
		   if(lax!=lbx)
		   {
			   float k ;
			   k=(lay-lby)/(lax-lbx);
			   if(lineWidthRect(Drawl.downX,Drawl.downY,Drawl.moveX,Drawl.moveY,rllp.leftMargin,rllp.topMargin,20,20))
			   {
				   if(k==1||k==-1)
				   {x=-x;y=-y;}
				   
				   if(k>1||k<-1)
				   {
					   x=-x;
					   y=y;
				   }
				   else
				   {
					   x=x;
					   y=-y;
				   }
			   }
		   }
		  /* else{
			   x=-x;
			   y=y;
		   }
			*/   
		   /*
		   float k ;
		   k=(lay-lby)/(lax-lbx);
		   if(lineWidthRect(Drawl.downX,Drawl.downY,Drawl.moveX,Drawl.moveY,rllp.leftMargin,rllp.topMargin,20,20))
		   {
			   if(k>1||k<-1)
			   {
				   x=-x;
				   y=y;
			   }
			   else
			   {
				   x=x;
				   y=-y;
			   }
			   
			   
		   }*/
    	  /* if(lineWidthRect(Drawl.downX,Drawl.downY,Drawl.moveX,Drawl.moveY,rllp.leftMargin,rllp.topMargin,20,20))
    	   {
    		     //45度到145度
    		   if((lby-lay>lbx-lax)||(lay-lby>lax-lbx)||(lby-lay>lax-lbx)||(lay-lby>lbx-lax))
    		   {
    			   x=-x;
    			   y=y;
    					   
    		   }
    		   //-45度到45度
    		   else //if((lby-lay<lbx-lax)||(lay-lby<lax-lbx)||(lby-lay<lax-lbx)||(lay-lby<lbx-lax))
    			   {
    				   x=x;
    				   y=-y;
    				   if(lineWidthRect(Drawl.downX,Drawl.downY,Drawl.moveX,Drawl.moveY,rllp.leftMargin,rllp.topMargin,20,20))
    				   {
    					   x=x;y=y;
    				   }
    			   }
    	   }*/
    	   /*if((lby-lay>lbx-lax)||(lay-lby>lax-lbx)||(lby-lay>lax-lbx)||(lay-lby>lbx-lax))
		   {
    		   if(lineWidthRect(Drawl.downX,Drawl.downY,Drawl.moveX,Drawl.moveY,rllp.leftMargin,rllp.topMargin,20,20))
    		   {x=-x;
			   y=y;}
			   					   
		   }
    	   else //if((lby-lay<lbx-lax)||(lay-lby<lax-lbx)||(lby-lay<lax-lbx)||(lay-lby<lbx-lax))
    	   {
    		   if(lineWidthRect(Drawl.downX,Drawl.downY,Drawl.moveX,Drawl.moveY,rllp.leftMargin,rllp.topMargin,20,20))
			   {
				   x=x;y=-y;
			   }
    	   }
    	   */
    	   
    		  
    	
    	   ///////////////检测碰撞结束
    	   //if(Drawl.downX>Drawl.moveX&&Drawl.downY<Drawl.moveY)

		   /*  if(lax>lbx&&lay<lby)
		   {
    		   if(lineWidthRect(Drawl.downX, Drawl.downY,Drawl. moveX, Drawl.moveY,rllp.leftMargin,rllp.topMargin,20,20))
    		   {
        		   //x=-x;  
        		   //y=-y;
    			   x=-x;
    			   y=-y;
        	   }
		   }*/
		/*   if(lineWidthRect(Drawl.downX, Drawl.downY,Drawl. moveX, Drawl.moveY,rllp.leftMargin,rllp.topMargin,20,20))
		   {
			   if((lby-lay<lbx-lax)||(lay-lby<lax-lbx))//1线是在1象限的0-45度角里面
			   {
			   
				   if(x>0&&y>0)//速度是右下方向
				   {
					   x=x;y=1;
				   }
				   else if(x<0&&y>0)//左下方向
				   {x=1;y=-y;}
				   else if(x>0&&y<0)//右上
				   {x=1;y=-y;}
				   else if(x<0&&y<0)//左上
				   {x=x;y=1;}
				   else//x方向或者y方向有一个是0的情况
				   {
					   swap(x,y);
					   
				   }
			   }
			   else if((lby-lay>lbx-lax)||(lay-lby>lax-lbx))//2线是在1象限的45-90度角里面
			   {
			   
				   if(x>0&&y>0)//速度是右下方向
				   {
					   x=1;y=y;
				   }
				   else if(x<0&&y>0)//左下方向
				   {x=-x;y=1;}
				   else if(x>0&&y<0)//右上
				   {x=-x;y=1;}
				   else if(x<0&&y<0)//左上
				   {x=1;y=y;}
				   else//x方向或者y方向有一个是0的情况
				   {
					   swap(x,y);
				   }
			   }
			   else if((lby-lay>lax-lbx)||(lay-lby>lbx-lax))//3线是在1象限的90-145度角里面
			   {
			   
				   if(x>0&&y>0)//速度是右下方向
				   {
					   x=-x;y=1;
				   }
				   else if(x<0&&y>0)//左下方向
				   {x=1;y=y;}
				   else if(x>0&&y<0)//右上
				   {x=1;y=y;}
				   else if(x<0&&y<0)//左上
				   {x=-x;y=1;}
				   else//x方向或者y方向有一个是0的情况
				   {
					   swap(x,y);
					   x=-x;
					   y=-y;
					   x=x+1;
					   y=y+1;
				   }
			   }
			   else if((lby-lay<lax-lbx)||(lay-lby<lbx-lax))//4线是在1象限的145-180度角里面
			   {
			   
				   if(x>0&&y>0)//速度是右下方向
				   {
					   x=1;y=-y;
				   }
				   else if(x<0&&y>0)//左下方向
				   {x=x;y=1;}
				   else if(x>0&&y<0)//右上
				   {x=x;y=1;}
				   else if(x<0&&y<0)//左上
				   { x=1;y=-y;}
				   else//x方向或者y方向有一个是0的情况
				   {
					   swap(x,y);
					   x=-x;
					   y=-y;
					   x=x+1;
					   y=y+1;
				   }
			   }
		   }*/
		   
		   
		   
		   //碰撞之后蜗牛的图片实现头部调转
    	   if(x>0&&y>0)
    	   {
	    	   if(rllp.leftMargin%29==1||rllp.leftMargin%29==2||rllp.leftMargin%29==3||rllp.leftMargin%29==4||rllp.leftMargin%29==5||rllp.leftMargin%29==6||rllp.leftMargin%29==7||rllp.leftMargin%29==8||rllp.leftMargin%29==9||rllp.leftMargin%29==10||rllp.leftMargin%29==11||rllp.leftMargin%29==12||rllp.leftMargin%29==13)
	    	   {
	    		  
	        	   setImageResource(R.drawable.shift1);      
	    	   }
	    	   else
	    	   {
	    		   setImageResource(R.drawable.shift11);      
	    	   }
    	   }
    	   else if(x>0&&y<0)
    	   {
    		   if(rllp.leftMargin%29==1||rllp.leftMargin%29==2||rllp.leftMargin%29==3||rllp.leftMargin%29==4||rllp.leftMargin%29==5||rllp.leftMargin%29==6||rllp.leftMargin%29==7||rllp.leftMargin%29==8||rllp.leftMargin%29==9||rllp.leftMargin%29==10||rllp.leftMargin%29==11||rllp.leftMargin%29==12||rllp.leftMargin%29==13)
	    	   {
	    		  
	        	   setImageResource(R.drawable.shift4);      
	    	   }
	    	   else
	    	   {
	    		   setImageResource(R.drawable.shift44);      
	    	   } 
    	   }
    	   else if(x<0&&y<0)
    	   {
    		   if(rllp.leftMargin%29==1||rllp.leftMargin%29==2||rllp.leftMargin%29==3||rllp.leftMargin%29==4||rllp.leftMargin%29==5||rllp.leftMargin%29==6||rllp.leftMargin%29==7||rllp.leftMargin%29==8||rllp.leftMargin%29==9||rllp.leftMargin%29==10||rllp.leftMargin%29==11||rllp.leftMargin%29==12||rllp.leftMargin%29==13)
	    	   {
	    		  
	        	   setImageResource(R.drawable.shift3);      
	    	   }
	    	   else
	    	   {
	    		   setImageResource(R.drawable.shift33);      
	    	   }
    	   }
    	   else if(x<0&&y>0)
    	   {
    		   if(rllp.leftMargin%29==1||rllp.leftMargin%29==2||rllp.leftMargin%29==3||rllp.leftMargin%29==4||rllp.leftMargin%29==5||rllp.leftMargin%29==6||rllp.leftMargin%29==7||rllp.leftMargin%29==8||rllp.leftMargin%29==9||rllp.leftMargin%29==10||rllp.leftMargin%29==11||rllp.leftMargin%29==12||rllp.leftMargin%29==13)
	    	   {
	    		  
	        	   setImageResource(R.drawable.shift2);      
	    	   }
	    	   else
	    	   {
	    		   setImageResource(R.drawable.shift22);      
	    	   }
    	   }
    	   if (rllp.leftMargin<0) {    
    		   x=Math.abs(x);   
    		   
    		   }    
    	   if (rllp.leftMargin>getParentWidth()-getWidth()) {    
    		   x=-Math.abs(x);   
    		   
    		   }    
    	   if (rllp.topMargin<0) {    
    		   y=Math.abs(y);   
    		  
    		   }    
    	   if (rllp.topMargin>getParentHeight()-getHeight()) {    
    		   y=-Math.abs(y);   
    		  
    		   } 
    	   //障碍物
    	   /*
    	   if (rllp.topMargin>50&&rllp.topMargin<80&&rllp.leftMargin>50&&rllp.leftMargin<80) {    
    		   Builder dlg=new Builder(null);
    		   dlg.setTitle("Error");
    		   dlg.setMessage("Unknown error.");
    		   dlg.show();
    		   
    		   } 
    	  
    	   if (rllp.topMargin>100&&rllp.topMargin<130&&rllp.leftMargin>100&&rllp.leftMargin<130) {    
    		   y=-Math.abs(y); 
    		   
    		   } 
    	   if (rllp.topMargin>150&&rllp.topMargin<180&&rllp.leftMargin>150&&rllp.leftMargin<180) {    
    		   y=-Math.abs(y); 
    		   
    		   } 
    	   if (rllp.topMargin>100&&rllp.topMargin<130&&rllp.leftMargin>200&&rllp.leftMargin<230) {    
    		   y=-Math.abs(y); 
    		   
    		   } 
    	   if (rllp.topMargin>250&&rllp.topMargin<280&&rllp.leftMargin>250&&rllp.leftMargin<280) {    
    		   y=-Math.abs(y); 
    		   
    		   }
    		   */
    	   setLayoutParams(rllp);   
    	   }     
       private float getParentWidth(){   
    	   return ((FrameLayout)getParent()).getWidth();      
    	   }   
       private float getParentHeight(){   
    	   return ((FrameLayout)getParent()).getHeight();    
    	   }  
       }
