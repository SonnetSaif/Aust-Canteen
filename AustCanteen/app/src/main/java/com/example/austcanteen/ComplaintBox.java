package com.example.austcanteen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ComplaintBox extends AppCompatActivity {

    private EditText mComplaintSubjectET;
    private EditText mComplaintDescET;
    private Button mComplaintBtn;
    private DatabaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_box);
        myDB = new DatabaseHelper(ComplaintBox.this);

        mComplaintBtn = (Button) findViewById(R.id.complaintSubmitBtn);
        mComplaintSubjectET = (EditText) findViewById(R.id.complaintSubjectET);
        mComplaintDescET = (EditText) findViewById(R.id.complaintDescET);

        addComplaint();
    }

    private void addComplaint(){
        mComplaintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mComplaintSubjectET.getText().length() > 0 && mComplaintDescET.getText().length() > 0) {

                    boolean isInserted = myDB.insertComplaint(mComplaintSubjectET.getText().toString(), mComplaintDescET.getText().toString());
                    if (isInserted) {
                        Toast.makeText(ComplaintBox.this, "Complaint Inserted", Toast.LENGTH_SHORT).show();
                        finish();
                    } else
                        Toast.makeText(ComplaintBox.this, "Complaint Not Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(ComplaintBox.this, "Fill Up the Fields", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
