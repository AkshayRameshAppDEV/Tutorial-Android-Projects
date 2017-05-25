package com.example.android.contacts2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;

public class ContactActivity extends AppCompatActivity
{
    HashMap<Integer, String> contactList;
    String strFilename = "Contacts.txt";
    FileIO io;
    ListView contactView;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new BtnClickListener());

        contactView = (ListView)findViewById(R.id.id_contactList);
        io = new FileIO();
        contactList = io.readContacts(strFilename);
        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, contactList);
        contactView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    // Function to receive data from ContactDetailActivity.  If it had
    // not cancelled, get the data, and for now just put it in the
    // list.
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (resultCode == Activity.RESULT_OK)
        {
            Contact contact = (Contact) data.getSerializableExtra("new");
            contact.setId(contact.getNextID());
            contactList.put(contact.getId(), contact.toString());
            final StableArrayAdapter adapter = new StableArrayAdapter(this,
                    android.R.layout.simple_list_item_1, contactList);
            contactView.setAdapter(adapter);
            io.writeContacts(contactList, strFilename);
        }
    }
    private class StableArrayAdapter extends ArrayAdapter<String>
    {
        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  HashMap<Integer, String> objects)
        {
            super(context, textViewResourceId, (String[])objects.values().toArray(new String[0]));
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

    }

    private class BtnClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            Intent intent = new Intent(ContactActivity.this, ContactDetail.class);
            Contact contact = new Contact();
            intent.putExtra("contact", contact);
            intent.putExtra("mode", "new");
            ContactActivity.this.startActivityForResult(intent, 0);
        }
    }
}
