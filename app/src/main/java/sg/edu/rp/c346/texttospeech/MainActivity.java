package sg.edu.rp.c346.texttospeech;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import java.util.Locale;

import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
    TextToSpeech t1;
    EditText ed1;
    Button b1;
    Button btnfav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.editText);
        b1 = (Button) findViewById(R.id.button);
        btnfav = (Button) findViewById(R.id.buttonFav);

        Intent intentReceived = getIntent();
//        String strWord = intentReceived.getStringExtra("word");
//        ed1.setText(strWord);

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);


                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = ed1.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        btnfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String et = ed1.getText().toString();
                Intent intent = new Intent(getBaseContext(), favWord.class);
                intent.putExtra("et", et);


                startActivity(intent);


            }
        });


//        spn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if(spn.getSelectedItem().toString().equalsIgnoreCase("korean")){
//                    t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//                        @Override
//                        public void onInit(int status) {
//                            if(status != TextToSpeech.ERROR) {
//                                t1.setLanguage(Locale.KOREAN);
//                            }
//                        }
//                    });
//                } else if (spn.getSelectedItem().toString().equalsIgnoreCase("UK")){
//                    t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//                        @Override
//                        public void onInit(int status) {
//                            if(status != TextToSpeech.ERROR) {
//                                t1.setLanguage(Locale.UK);
//                            }
//                        }
//                    });
//                }
//            }
//        });
    }

    public void onPause() {
        if (t1 != null) {
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }
}



