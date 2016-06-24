package com.example.jackie_zhang.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    long position;
    EditText etNewItem;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        text= getIntent().getStringExtra("text");
        position= getIntent().getLongExtra("position", 0);
        etNewItem = (EditText) findViewById(R.id.etNewItem);
        etNewItem.setText(text);
        etNewItem.setSelection(etNewItem.getText().length());
    }

    public void onSavedItem(View view) {

        text = etNewItem.getText().toString();
        Intent data = new Intent();
        data.putExtra("text",text);
        data.putExtra("position",position);
        setResult(RESULT_OK,data);
        this.finish();
    }
}
