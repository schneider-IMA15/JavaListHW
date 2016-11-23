package at.fh.swengb.javalist.model;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import at.fh.swengb.javalist.R;
import at.fh.swengb.javalist.model.JavaMethod;
import at.fh.swengb.javalist.model.ShowMethActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<JavaMethod> listJavaMeth;
    private ListView myListView;
    private CustomAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listJavaMeth = new ArrayList<>();
        listJavaMeth.add(new JavaMethod("doHomework","does my Homework for me","Lukas Schneider","lukas.schneider@edu.fh-joanneum.at"));
        listJavaMeth.add(new JavaMethod("bakeCookies","most delicious Cookies","Vanessa Fortmüller","pinkunicorn123@gmx.at"));
        listJavaMeth.add(new JavaMethod("driveCar","wins Car race","Markus Wolf","BMWfreak1@aol.de"));
        listJavaMeth.add(new JavaMethod("skiDownhill","goes fast","Phil Göschl","philphilphil@sms.at"));
        listJavaMeth.add(new JavaMethod("matchClothing","finds the best combination","Elisabeth Fellner","elli@gmail.at"));

        myListView = (ListView) findViewById(R.id.myJavaList);

        myAdapter = new CustomAdapter(this, listJavaMeth);

        //myAdapter = new ArrayAdapter <JavaMethod>(this,R.layout.row_item_simple,R.id.textViewSimpleName,listJavaMeth);

        myListView.setAdapter(myAdapter);

        myListView.setOnItemClickListener(this);





    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        JavaMethod selectedMeth = listJavaMeth.get(i);
        Intent intent = new Intent(view.getContext(),ShowMethActivity.class);
        intent.putExtra("user",selectedMeth);
        startActivity(intent);
    }
}
