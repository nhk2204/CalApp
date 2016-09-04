package com.example.nhk2204.calapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editText1,editText2;
    double Answer;
    String ErrMsg="数字を入力してください。";
    boolean ErrBool =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button PlusB=(Button)findViewById(R.id.Plus);
        PlusB.setOnClickListener(this);

        Button MinusB=(Button)findViewById(R.id.Minus);
        MinusB.setOnClickListener(this);

        Button MultB=(Button)findViewById(R.id.Mult);
        MultB.setOnClickListener(this);

        Button DiviB=(Button)findViewById(R.id.Divi);
        DiviB.setOnClickListener(this);

        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v) {
        if(isNum(editText1.getText().toString())&&isNum(editText2.getText().toString())){
            String str = editText1.getText().toString();
            double i = Double.parseDouble(str);
            str = editText2.getText().toString();
            double j = Double.parseDouble(str);

            if(v.getId()==R.id.Plus){
                Answer=i+j;
            }else if(v.getId()==R.id.Minus){
                Answer=i-j;
            }else if(v.getId()==R.id.Mult){
                Answer=i*j;
            }else{
                if(j==0){
                    ErrMsg="割る数が０になっています。";
                    showAlertDialog();
                    ErrBool = true;
                }else{
                    Answer=i/j;
                }
            }
            if(ErrBool!=true) {
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("Answer", Answer);
                startActivity(intent);
            }
        }else{
            showAlertDialog();
        }
    }

    private void showAlertDialog(){
        AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("エラー");
        alertDialogBuilder.setMessage(ErrMsg);
        AlertDialog alertDialog=alertDialogBuilder.create();
        alertDialog.show();
    }

    static boolean isNum(String number){
        try{
            Double.parseDouble(number);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
