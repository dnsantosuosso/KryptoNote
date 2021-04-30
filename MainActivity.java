package com.example.kryptonote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onEncrypt(View v) {
        EditText keyView = (EditText) findViewById(R.id.key);
        String kS = keyView.getText().toString();

        EditText dataView = (EditText) findViewById(R.id.data);
        String dS = dataView.getText().toString();


        try{
            KryptoNoteActivity kn = new KryptoNoteActivity(kS);
            String result = kn.encrypt(dS);

            ((TextView) findViewById(R.id.data)).setText(result);
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }


    }
    public void onDecrypt(View v) {
        EditText keyView = (EditText) findViewById(R.id.key);
        String kS = keyView.getText().toString();

        EditText dataView = (EditText) findViewById(R.id.data);
        String dS = dataView.getText().toString();


        try{
            KryptoNoteActivity kn = new KryptoNoteActivity(kS);
            String result = kn.decrypt(dS);

            ((TextView) findViewById(R.id.data)).setText(result);
        }
        catch (Exception e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
    public void onSave(View v) throws IOException {
        try {
            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileWriter fw = new FileWriter(file);
            fw.write(((EditText) findViewById(R.id.data)).getText().toString());
            fw.close();
            Toast.makeText(this, "Note Saved.", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void onLoad(View v) {
        try {
            String name = ((EditText) findViewById(R.id.file)).getText().toString();
            File dir = this.getFilesDir();
            File file = new File(dir, name);
            FileReader fr = new FileReader(file);
            String show = "";

            for (int c = fr.read(); c != -1; c = fr.read())
            {
                show += (char) c;
            }
            fr.close();
            ((EditText) findViewById(R.id.data)).setText(show);

            Toast.makeText(this, "Note Loaded.", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }


}