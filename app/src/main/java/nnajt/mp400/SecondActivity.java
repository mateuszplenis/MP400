package nnajt.mp400;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends ActionBarActivity {

    private EditText phoneNumberView;
    private EditText adresWWWView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle intentExtras = getIntent().getExtras();
        String username = intentExtras.getString("username");
        String password = intentExtras.getString("password");
        TextView helloView = (TextView)findViewById(R.id.hello);
        helloView.setText("Witaj " + username + "!");
        phoneNumberView = (EditText) findViewById(R.id.phoneNumber);
        adresWWWView = (EditText) findViewById(R.id.adresWWW);
    }

    public void dialClicked(View view) {
        String phoneNumber = phoneNumberView.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }

    public void wwwClicked(View view) {
        String adresWWW = adresWWWView.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://" + adresWWW));
        startActivity(intent);
    }
}
