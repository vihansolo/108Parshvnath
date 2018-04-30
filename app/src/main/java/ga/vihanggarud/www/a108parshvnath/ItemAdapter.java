package ga.vihanggarud.www.a108parshvnath;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ga.vihanggarud.www.a108parshvnath.Entity.Temple;

public class ItemAdapter extends ArrayAdapter<Temple> {

    public ItemAdapter(@NonNull Context context, int resource, @NonNull List<Temple> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {

            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.list_item, parent, false);
        }

        ImageView itemImage = convertView.findViewById(R.id.itemImage);
        TextView itemText = convertView.findViewById(R.id.itemText);

        Temple values = getItem(position);

        itemText.setVisibility(View.VISIBLE);
        itemImage.setVisibility(View.VISIBLE);

        assert values != null;
        itemText.setText(values.getTempleName());

        return convertView;
    }
}
