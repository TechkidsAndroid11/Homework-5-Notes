package techkids.vn.homework_note;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {
    private EditText etTitle;
    private EditText etDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        setupUI();
    }

    private void setupUI() {
        etTitle = (EditText) findViewById(R.id.et_title);
        etDes = (EditText) findViewById(R.id.et_description);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mn_done, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String title = etTitle.getText().toString();
        String des = etDes.getText().toString();

        if (TextUtils.isEmpty(title)) {
            etTitle.setError("Cannot be empty");
        } else if (TextUtils.isEmpty(des)){
            etDes.setError("Cannot be empty");
        } else {
            NoteModel noteModel = new NoteModel(title, des);
            DatabaseHandle.getInstance(this).addNote(noteModel);
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
