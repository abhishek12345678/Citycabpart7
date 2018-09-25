package dcom.citycabpart7.Helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Custominfowindow implements GoogleMap.InfoWindowAdapter {

    View myView;

    public CustomInfoWindow(Context context)
    {
        myView= LayoutInflater.from(context).inflate(R.layout.custom_rider_info_window,null);

    }

    getinfoWindow(Maker maker)
    {
        TextView txtPickupTitle = ((TextView)myView.findViewById(R.id.txtPickupInfo));
        txtPickupTitle.setText(maker.getTitle());

        TextView txtPickupSnippet = ((TextView)myView.findViewById(R.id.txtPickupSnippet));
        txtPickupSnippet.setText(maker.getSnippet());

        return myView;
    }

    public void  getInfor(Marker marker)
    {
        return null;
    }

}