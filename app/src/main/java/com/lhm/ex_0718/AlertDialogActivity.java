package com.lhm.ex_0718;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {

    Button btn_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        btn_show = findViewById(R.id.btn_show);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(AlertDialogActivity.this);

                dialog.setTitle("카카오톡");
                dialog.setMessage("평가부탁");

                //다이얼로그에 버튼 추가


                dialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogActivity.this,
                                "평가예정임", Toast.LENGTH_SHORT).show();
                    }
                });



                dialog.setNeutralButton("나중에", null);

                //다이아로그가 뒤로가거나 빈공간 터치로 사라지는것을 방지
                dialog.setCancelable(false);

                //앱을 종료할때 예 아니오 둘중 하나는 눌러야하니까 사라지게 방지하는 작업을 할수 있지 않을까


                dialog.show();

            }
        });

    }   //onCreate

    //메서드 같은 경우 밖에다 만들어야 한다. (함수는 함수 안에 만들지 못하기 때문)
    //생명주기에 관련된 메서드도 밖에다 작성을 해야한다.


    @Override
    public void onBackPressed() {
        //뒤로가기 버튼을 누르면 호출되는 메서드
//        super.onBackPressed();
        AlertDialog.Builder dialog = new AlertDialog.Builder(AlertDialogActivity.this);
        dialog.setTitle("앱 제목");
        dialog.setMessage("종료 하시겠습니까?");

        dialog.setPositiveButton("아니오",null);
        dialog.setNegativeButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        dialog.show();

    }//onBackPressed



}
