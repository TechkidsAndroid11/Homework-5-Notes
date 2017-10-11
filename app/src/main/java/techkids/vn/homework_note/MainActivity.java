package techkids.vn.homework_note;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView lvNotes;
    private FloatingActionButton fbAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
        addListeners();
    }

    @Override
    protected void onStart() {
        super.onStart();

        loadData();
    }

    private void loadData() {
        NoteAdapter noteAdapter = new NoteAdapter(this, R.layout.item_list_note,
                DatabaseHandle.getInstance(this).getAllNote());
        lvNotes.setAdapter(noteAdapter);
    }

    private void addListeners() {
        fbAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NoteActivity.class));
            }
        });
    }

    private void setupUI() {
        lvNotes = (ListView) findViewById(R.id.lv_notes);
        fbAdd = (FloatingActionButton) findViewById(R.id.fb_add);
    }
}
