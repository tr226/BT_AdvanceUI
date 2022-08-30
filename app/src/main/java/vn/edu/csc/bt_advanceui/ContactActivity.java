package vn.edu.csc.bt_advanceui;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity implements ContactAdapter.OnClick {

    ArrayList<Contact> contacts;
    ContactAdapter contactAdapter;
    RecyclerView rvContacts;

    Toolbar toolbar;
    int position;
    SwipeRefreshLayout sw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        //show toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // contect adapter
        rvContacts = findViewById(R.id.rvContacts);
        contacts = initData();

        contactAdapter = new ContactAdapter(contacts, ContactActivity.this, ContactActivity.this);
        rvContacts.setAdapter(contactAdapter);

        rvContacts.setLayoutManager(new LinearLayoutManager(ContactActivity.this, LinearLayoutManager.VERTICAL, true));// nếu true thì sẽ lật lên trên cùng lại // lat nguoc layout lai
        rvContacts.addItemDecoration(new DividerItemDecoration(ContactActivity.this, LinearLayoutManager.VERTICAL));

        registerForContextMenu(rvContacts);

        /// set reload
        sw = findViewById(R.id.sw);
        sw.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Contact contact = new Contact("Minh Thu","0868990314");
                contacts.add(contact);
                contactAdapter.notifyDataSetChanged();
                sw.setRefreshing(false);// khoa vong tron lai
            }
        });

    }

    private ArrayList<Contact> initData() {
        ArrayList<Contact> tmp = new ArrayList<>();
        tmp.add(new Contact("Gary Hawkins", "0909090909"));
        tmp.add(new Contact("Mike Lasson", "0909090909"));
        tmp.add(new Contact("Jose Alexander", "0909090909"));
        tmp.add(new Contact("Stephanie Gardner", "0909090909"));
        tmp.add(new Contact("Nancy Greene ", "0909090909"));
        tmp.add(new Contact("Gary Hawkins", "0909090909"));
        tmp.add(new Contact("Mike Lasson", "0909090909"));
        tmp.add(new Contact("Jose Alexander", "0909090909"));
        tmp.add(new Contact("Stephanie Gardner", "0909090909"));
        tmp.add(new Contact("Nancy Greene ", "0909090909"));
        return tmp;
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnu_add:
                Contact contact = new Contact("Truong Tho", "0868990314");
                contacts.add(contact);
                //render and update
                contactAdapter.notifyDataSetChanged();
                Toast.makeText(this, "added new Contact", Toast.LENGTH_SHORT).show();
            case R.id.mnu_info:
                Toast.makeText(this, "show info", Toast.LENGTH_SHORT).show();


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setOnLongClick(Contact contact, int pos) {
        Toast.makeText(this, contact.toString(), Toast.LENGTH_SHORT).show();
        position = pos;
    }

    // long click cotext


//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.context_menu, menu);
//        super.onCreateContextMenu(menu, v, menuInfo);
//    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnu_delete:
                contacts.remove(position);
                contactAdapter.notifyDataSetChanged();
                break;

            case R.id.mnu_edit:
                Contact contact = new Contact("Minh Thu", "0977443577");
                contacts.set(position, contact);
                contactAdapter.notifyDataSetChanged();
                break;




        }
        return super.onContextItemSelected(item);
    }
}