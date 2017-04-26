package sg.edu.rp.c346.texttospeech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class favWord extends AppCompatActivity {

    Button btnBack;
    ArrayList<String> alLv = new ArrayList<String>();
    ArrayAdapter<String> aaLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_word);

        btnBack = (Button) findViewById(R.id.buttonBack);
        ListView lvList = (ListView) findViewById(R.id.lvList);

        aaLv = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, alLv);

        Intent intentReceived = getIntent(); // return the intent that started the activity
        String strEt = intentReceived.getStringExtra("et");
        alLv.add(strEt);
        for(int i = 0;i < alLv.size(); i++){
            Log.d("Fav: ",alLv.get(i));
        }
        lvList.setAdapter(aaLv);


//        aaLv.notifyDataSetChanged();


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });


//        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Intent intentDetail = new Intent(getBaseContext(), MainActivity.class);
//                intentDetail.putExtra("word", position);
//
//
//            }
//        });


    }

}
