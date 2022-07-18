package com.lhm.ex_0718;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class IntentActivity extends AppCompatActivity {

    Button btn_call, btn_sms,btn_camera, btn_gallery, btn_next, btn_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        btn_call = findViewById(R.id.btn_call);
        btn_sms = findViewById(R.id.btn_sms);
        btn_camera = findViewById(R.id.btn_camera);
        btn_gallery = findViewById(R.id.btn_gallery);
        btn_next = findViewById(R.id.btn_next);
        btn_link = findViewById(R.id.btn_link);



        btn_call.setOnClickListener(click);
        btn_sms.setOnClickListener(click);
        btn_camera.setOnClickListener(click);
        btn_gallery.setOnClickListener(click);
        btn_link.setOnClickListener(click);
        btn_next.setOnClickListener(click);


    }   //onCreate

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //화면 전환을 위해 반드시 필요한 클래스스
           Intent i = null;
           switch (view.getId()){
               case R.id.btn_call:
//                 i = new Intent(Intent.ACTION_DIAL);
//                 i.setData(Uri.parse("tel:010-1111-1111"));
//                 startActivity(i);

                   i = new Intent(Intent.ACTION_CALL);
                   i.setData(Uri.parse("tel:010-6600-7659"));
                   startActivity(i);
                   break;

               case R.id.btn_sms:
                   i = new Intent(Intent.ACTION_SENDTO);
                   i.setData(Uri.parse("smsto:010-2222-2222"));

                   //putExtra를 사용하면 내용을 지정할수 있다.
                   //putExtra를 사용하면 key와 value로 저장을 해야 하는데 key값은 sms_body로 고정한다.
                   i.putExtra("sms_body", "안녕");
                   startActivity(i);
                   break;

               case R.id.btn_camera:
                   //내장 카메라로 연결
                   i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                   startActivity(i);

                   //동영상 연결
                   i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                   startActivity(i);
                   break;


               case R.id.btn_gallery:
                   i  = new Intent(Intent.ACTION_GET_CONTENT);
                   i.setType("*/*");
                   startActivity(i);
                   break;

               case R.id.btn_link:
//                   i = new Intent(Intent.ACTION_VIEW); //actionView가 없어도 동작을 하지만 낮은버전 사용시
//                   i.setData(Uri.parse("https://naver.com"));     // 무조건 구글로 가는 버그 있음
//                   startActivity(i);

                   //플레이 스토어로 이동하는 법
                   i = new Intent(Intent.ACTION_VIEW);
                   i.setData(Uri.parse("market://details?id=com.lhm.ex_0718"));
                   startActivity(i);
                   break;


               case R.id.btn_next:
                   //다른 액티비티로 전환
                   i = new Intent(IntentActivity.this,IntentSubActivity.class);
                   startActivity(i);
                   break;


           }
        }
    };



}