package com.example.android.contacts2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class ContactDetail extends AppCompatActivity
{

    EditText ctlFirstname;
    EditText ctlLastname;
    EditText ctlPhone;
    EditText ctlEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        ctlFirstname = (EditText)findViewById(R.id.idFirstName);
        ctlLastname = (EditText)findViewById(R.id.idLastName);
        ctlPhone = (EditText)findViewById(R.id.idPhone);
        ctlEmail = (EditText)findViewById(R.id.idEmail);

        if (intent != null)
        {
            String mode = intent.getStringExtra("mode");
            Contact contact = (Contact)intent.getSerializableExtra("contact");
            if (mode == "new")
            {

            }
            else if (mode == "mod")
            {

            }
        }
    }
    public void btnSaveClick(View view)
    {
        Contact contact = new Contact();
        contact.setFirstName(ctlFirstname.getText().toString());
        contact.setLastName(ctlLastname.getText().toString());
        contact.setPhone(ctlPhone.getText().toString());
        contact.setEmail(ctlEmail.getText().toString());
        Intent intent = new Intent();
        intent.putExtra("new", contact);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void btnCancelClick(View view)
    {
        Intent intent = new Intent();
        intent.putExtra("cancel", "");
        setResult(Activity.RESULT_CANCELED, intent);
        finish();
    }

}
