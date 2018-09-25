package dcom.citycabpart7;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BottomSheetRiderFragment  extends BottomSheetRiderFragment{

String mTag;

   public static BottomSheetRiderFragment newInstance(String tag)
   {

       BottomSheetRiderFragment f=new BottomSheetRiderFragment();
       Bundle args=new Bundle();
       args.putString("TAG",tag);
       f.setArguments(args);
       return  f;

   }

   //crt + O

    public  void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mTag= getArguments().getString("TAG");


    }

    public  view onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                              Bundle savedInstanceState){

       View view = inflater.inflate(R.layout.bottom_sheet_rider,container,false);
       return view;
    }



}
