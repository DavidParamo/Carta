package tfg.davidparamo.carta;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.opengles.GL;


/**
 * A simple {@link Fragment} subclass.
 */
public class primerosFragment extends Fragment {


    public primerosFragment() {
        // Required empty public constructor
    }

    List<Item> lista = new ArrayList<>();
    ArrayList<String> imageUrls = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.postreslayout, container, false);
        lista.add(new Item(R.drawable.amazon,"http://amazon.es/"));
        lista.add(new Item(R.drawable.facebook,"http://www.facebook.com/"));
        lista.add(new Item(R.drawable.instagram,"http://www.instagram.com"));
        lista.add(new Item(R.drawable.google,"http://plus.google.com"));
        ItemAdapter adaptador = new ItemAdapter(getContext(),lista);
        GridView gridView = (GridView) view.findViewById(R.id.postresGrid);
        Log.d("ES NULLLLLLL",(GlobalSettings.platosPrimero == null)+"");
        for(Plato plato:GlobalSettings.platosPrimero){
                if (plato.getImageUrl() == null || plato.getImageUrl().isEmpty())
                    plato.setImageUrl("http://www.51allout.co.uk/wp-content/uploads/2012/02/Image-not-found.gif");
                imageUrls.add(plato.getImageUrl());
        }
        String[] imageArray = new String[imageUrls.size()];
        imageArray = imageUrls.toArray(imageArray);
        gridView.setAdapter(new ImageListAdapter(getContext(), getActivity(),imageArray, GlobalSettings.platosPrimero));


        return view;
    }

}
