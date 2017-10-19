package com.kdh2017.oneto25;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    AdView adView;

    TextView text;
    Button[] btns = new Button[25];

    int cnt = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adView = (AdView)findViewById(R.id.adview);

        //광고요청자 객체 만들기
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        text = (TextView)findViewById(R.id.text1);

        Random rnd = new Random();
        int[] arr = new int[25];
        for(int i = 0; i < 25; i++) {
            arr[i] = rnd.nextInt(25) + 1;
            for(int k = 0; k <i; k++) {
                if(arr[i] ==arr[k]) {
                    i--;
                    break;
                }
            }
        }

        for(int i = 0; i < 25; i++) {
            btns[i] = (Button) findViewById(R.id.btn01 + i);
            btns[i].setText(arr[i]+"");
            btns[i].setTag(arr[i]);
        }
    }  //onCreate mathod...
    //onClick속성이 부여된 View가 클릭되면 자동으로 실행되는 메소드
    //강제규칙 1. public 2. void 3. onClick속성에 작성한 이름과 같아야 함. 4. 파라미터 : View Type 1개만 사용가능
    public void clickBtn(View v) {

        Button btn = null;

        if(v instanceof Button) btn = (Button)v;

        //Click된 v(Button)에 써있는 글씨 얻어오기

        String s = btn.getText().toString();

        //얻어온 글씨를 정수형으로 변환
        int num = Integer.parseInt(s);

        // 얻어온 글씨가 눌러야할 cnt번호와 같은지 비교..
        if(num == cnt) {
            btn.setVisibility(View.INVISIBLE);
            text.setText(cnt+"");
            cnt++;
        }
        if(cnt > 25) text.setText("Clear");
    }

} // mainActivity class...
