package com.laurens.androidarduino;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
//import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
//import java.io.*;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
public class Activity2 extends Activity {
	
	TextView myTextView;
	Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7;
	String server,urlSite;
	String ls1 = "Local Server";
	String ls2 = "Cloud Server";
	HttpClient httpclient;
	HttpPost httppost;
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity2);
        
        myTextView = (TextView)findViewById(R.id.tvWelcome);
        Intent i = getIntent();
        server = i.getStringExtra("server");
        myTextView.setText("Anda memilih server : " + server);
        
        if(ls1.equals(server)){
        	urlSite = "http://192.168.43.78/droidduino/index.php";
        }else
        if(ls2.equals(server)){
            urlSite = "http://renzcybermedia.16mb.com";
        }
        btn0 = (Button)findViewById(R.id.btn0);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        
        
        btn0.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				send("0",urlSite);
			}
		});
        
        btn1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				send("1",urlSite);
			}
		});
        
        btn2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				send("2",urlSite);
			}
		});
        
        btn3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				send("3",urlSite);
			}
		});
        
        btn4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				send("4",urlSite);
			}
		});
        
        btn5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				send("5",urlSite);
			}
		});
        
        btn6.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				send("6",urlSite);
			}
		});
        
        
        btn7.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		});
    }
	/*-------------------http client kaya code dibawah ini kah?----------------------------------*/
	void send(String x,String svr){
		httpclient = new DefaultHttpClient();
   	    httppost = new HttpPost(svr);
		try {
			   List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			   nameValuePairs.add(new BasicNameValuePair("aksi", x));
			   httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			   httpclient.execute(httppost);       			   	   
		  } catch (ClientProtocolException e) {
		  	   String ee = e.getMessage();
		  	   Toast.makeText(getApplicationContext(),ee,Toast.LENGTH_SHORT).show();
		  } catch (IOException e) {
			   String ee = e.getMessage();
			   Toast.makeText(getApplicationContext(),ee,Toast.LENGTH_SHORT).show();  
		  }
	}
}
