package com.nisum.activitiesandcommunication;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText mTextField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("************* onCreate **************");
        mTextField = (EditText)findViewById(R.id.editText);
    }

    // Fragment
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        System.out.println("************* onSaveInstanceState **************"+mTextField.getText().toString());
//        outState.putString("TextFieldData",mTextField.getText().toString());
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        System.out.println("************* onRestoreInstanceState **************"+savedInstanceState.getString("TextFieldData"));
//        mTextField.setText(savedInstanceState.getString("TextFieldData"));
//    }

    @Override
    protected void onStart() {
        System.out.println("************* onStart **************");
        super.onStart();
    }

    @Override
    protected void onResume() {
        System.out.println("************* onResume **************");
        super.onResume();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Explict intent
                /*Intent i = new Intent(MainActivity.this,MainActivityTwo.class);

                Bundle bundle = new Bundle();
                //bundle.putString("EditTextValue",mTextField.getText().toString());

                myCustomData customData = new myCustomData(mTextField.getText().toString());
                bundle.putParcelable("myData",customData);

                i.putExtras(bundle);
                System.out.println("************* Data in first screen **************"+customData.textValue);
                startActivity(i);*/

                //implict intent
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,111);


                //finish();

                // Launch my firstactivity
                // from first activity i launch second activity
                // first activity is going to background  ( onpause will get called )
                // passed some data from first to second
                // second on create, on resume
                // on second, user clicked on close button -> he is calling finish
                // on second on pause and on destroy
                // the first screen on resume, beacuse he has not mentioned finish before calling startactivity


                // there is need that first activity want to know the status/data from the second activity
                // data we want from second to first, in such situtaiton we use startActivityForResult
                // startActivityForResult you can use any (implict or explict)

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println("************* onActivityResult ************** requestCode "+requestCode+ " resultCode "+resultCode );
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onPause() {
        System.out.println("************* onPause **************");
        super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println("************* onStop **************");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.println("************* onDestroy **************");
        super.onDestroy();
    }
}
