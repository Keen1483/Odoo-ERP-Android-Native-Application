package cm.keenndj.socsuba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class HostUrl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_url);
    }

    public void submitted(View view) {
        EditText hostEditText = (EditText) findViewById(R.id.host);
        String host = hostEditText.getText().toString();

        EditText portEditText = (EditText) findViewById(R.id.port);
        String port = (String) portEditText.getText().toString();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("host", host);
        intent.putExtra("port", port);
        startActivity(intent);
    }
}