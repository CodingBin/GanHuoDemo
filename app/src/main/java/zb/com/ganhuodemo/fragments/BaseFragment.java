package zb.com.ganhuodemo.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import zb.com.ganhuodemo.R;

/**
 * Created by Administrator on 2017/12/27.
 */

public class BaseFragment extends Fragment {

    private ImageView img;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.base_fragment,container,false);
        img = view.findViewById(R.id.base_img);
        return inflater.inflate(R.layout.base_fragment,container,false);
    }
}
