package techkids.vn.homework_note;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admins on 10/11/2017.
 */

public class NoteAdapter extends ArrayAdapter<NoteModel> {
    private Context context;
    private int layoutID;
    private List<NoteModel> noteModelList;

    public NoteAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<NoteModel> objects) {
        super(context, resource, objects);

        this.context = context;
        this.layoutID = resource;
        this.noteModelList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(layoutID, parent, false);

        TextView tvTitle = convertView.findViewById(R.id.tv_title);
        TextView tvDes = convertView.findViewById(R.id.tv_description);

        tvTitle.setText(noteModelList.get(position).getTitle());
        tvDes.setText(noteModelList.get(position).getDescription());

        return convertView;
    }
}
