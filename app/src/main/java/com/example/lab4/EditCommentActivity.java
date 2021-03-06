package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.util.StringJoiner;
import java.util.function.Supplier;

public class EditCommentActivity extends AppCompatActivity {
    private TextInputEditText commentText;
    private Button saveButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_comment);

        commentText = this.findViewById(R.id.commentEditText);
        saveButton = this.findViewById(R.id.commentSaveButton);
        cancelButton = this.findViewById(R.id.commentCancelButton);

        ListenerFactory factory = ListenerFactory.getInstance();
        cancelButton.setOnClickListener(factory.createCancelButtonListener(this));
        Supplier<String> newValue = () -> {
            StringJoiner joiner = new StringJoiner(", ");
            joiner.add(commentText.getText());
            return joiner.toString();
        };
        saveButton.setOnClickListener(factory.createSaveButtonListener(this, "comment", newValue));
    }

}