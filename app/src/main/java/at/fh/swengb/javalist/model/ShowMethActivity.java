package at.fh.swengb.javalist.model;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import at.fh.swengb.javalist.R;

/**
 * Created by Lukas Schneider on 23.11.2016.
 */

public class ShowMethActivity extends AppCompatActivity {
    private JavaMethod method;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user);

        Intent intent = getIntent();
        method = (JavaMethod) intent.getExtras().get("user");

        TextView viewMethName = (TextView) findViewById(R.id.textViewMethName);
        TextView viewDescription = (TextView) findViewById(R.id.textViewDescription);
        TextView viewCreator = (TextView) findViewById(R.id.textViewCreator);


        viewMethName.setText(method.getNameMethod());
        viewDescription.setText(method.getDescription());
        viewCreator.setText(method.getCreator());


    }

    public void contact(View view) {

        String uriText =
                "mailto:" + method.getContact() + "?subject=" + Uri.encode("Help me!") +
                        "&body=" + Uri.encode("Actually, I've got it :)");

        Uri uri = Uri.parse(uriText);

        Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
        sendIntent.setData(uri);
        startActivity(Intent.createChooser(sendIntent, "Send email"));

        //Uri number = Uri.parse("tel:"+method.getContact());
        //Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        //startActivity(callIntent);
    }
}
