package com.example.sahil.reverseorderofwords;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.y;

public class MainActivity extends Activity {

    private EditText mStringEt;
    private TextView mRevTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStringEt = (EditText)findViewById(R.id.editText);
        mRevTv = (TextView)findViewById(R.id.textView);
    }

    public void reverseString(View view) {

        String string = " " + mStringEt.getText().toString();
        char[] array = new char[100];
        for(int i=0;i<string.length();i++)
            array[i]=string.charAt(i);
        Log.i("rev",String.valueOf(array));
        mRevTv.setText("");
        char subArray[] = new char[100];
        int len=0;
        for(int i=string.length()-1;i>=0;i--){
            if(array[i] != ' '){
                subArray[len++] = array[i];
            }
            else{
                for(int j=0;j<len/2;j++){
                    char temp = subArray[j];
                    subArray[j] = subArray[len-1-j];
                    subArray[len-j-1]=temp;
                }
                subArray[len] = ' ';
                subArray[len+1] = '\0';
                mRevTv.append(String.valueOf(subArray));
                len =0;
                subArray = new char[100];
            }
        }
    }
}
