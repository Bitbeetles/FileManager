package myfilemng.tang.myfilemng;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by admin on 2017/2/24.
 */
class RecyclerViewAdapter extends RecyclerView.Adapter {

    private ArrayList<File> filelist = MainActivity.getFilelist();
    private File path;

    class ViewHolder extends  RecyclerView.ViewHolder{

        private View root;

        private TextView name, tvContent;

        public ViewHolder(View root) {
            super(root);


            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    name = (TextView) v.findViewById(R.id.file_name);
//                    path = new File("/" + name.getText() + "/");
                    Toast.makeText(v.getContext(), "点击", Toast.LENGTH_SHORT).show();
                }
            });

            name = (TextView) root.findViewById(R.id.file_name);
            tvContent = (TextView) root.findViewById(R.id.file_size);

        }

        public TextView getTvContent() {
            return tvContent;
        }

        public TextView getName() {
            return name;
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.file_browser_item, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;

        vh.getName().setText(filelist.get(position).getName());
//        vh.getTvContent().setText(filelist.get(position).toString());

    }

    @Override
    public int getItemCount() {

//        path = new File("/");
//        getAllFiles(path);
        return filelist.size();
    }

    public File getPath() {
        return path;
    }
}
