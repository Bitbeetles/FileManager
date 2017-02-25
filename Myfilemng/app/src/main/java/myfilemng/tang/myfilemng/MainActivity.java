package myfilemng.tang.myfilemng;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static ArrayList<File> filelist;
    private RecyclerView rv;
    private File path;
    private Button file;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rv = new RecyclerView(this);
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            path = new File("/");
        }else{
            Toast.makeText(this, "没有SD卡", Toast.LENGTH_LONG).show();
            finish();
        }

        setContentView(rv);

        getAllFiles(path);

        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new RecyclerViewAdapter());
    }

    // 遍历接收一个文件路径，然后把文件子目录中的所有文件遍历并输出来
    private void getAllFiles(File root){
        File[] files = root.listFiles();
        filelist = new ArrayList<>();
        if(files != null){
            for (File f : files){

                filelist.add(f);

            }
        }
    }

    public static ArrayList<File> getFilelist() {
        return filelist;
    }

    public void Update(){
        startActivity(new Intent(this, MainActivity.class));
    }
}
