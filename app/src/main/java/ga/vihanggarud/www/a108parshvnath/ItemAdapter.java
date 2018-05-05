package ga.vihanggarud.www.a108parshvnath;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import ga.vihanggarud.www.a108parshvnath.Entity.Temple;

public class ItemAdapter extends ArrayAdapter<Temple> {

    private Context context;

    ItemAdapter(@NonNull Context context, int resource, @NonNull List<Temple> objects) {

        super(context, resource, objects);
        this.context = context;
    }

    public class ViewHolder {

        ImageView templeImage;
        TextView templeName;
    }

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder = null;
        Temple temple = getItem(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            assert inflater != null;
            convertView = inflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();

            holder.templeName = convertView.findViewById(R.id.itemText);
            holder.templeImage = convertView.findViewById(R.id.itemImage);

            convertView.setTag(holder);
        }

        else
            holder = (ViewHolder) convertView.getTag();

        assert temple != null;
        holder.templeName.setText(temple.getTempleName());
        Glide.with(holder.templeImage.getContext())
                .load(temple.getTempleImageURI())
                .into(holder.templeImage);

        return convertView;
    }
}
