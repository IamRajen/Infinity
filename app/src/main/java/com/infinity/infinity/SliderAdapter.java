package com.infinity.infinity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter  extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context)
    {
        this.context=context;
    }

    public int[] slide_image ={

            R.drawable.share_content,
            R.drawable.chatting,
            R.drawable.upload_code,
            R.drawable.internships,
            R.drawable.job_search
    };

    public String[] slide_heading ={

            "SHARE CONTENT",
            "PERSONAL CHATS",
            "UPLOAD CODES",
            "FIND INTERNSHIP",
            "OFF-CAMPUSING JOBS"
    };


    public String[] slide_descriptions ={

            "SHARE CONTENT",
            "PERSONAL CHATS",
            "UPLOAD CODES",
            "FIND INTERNSHIP",
            "OFF-CAMPUSING JOBS"
    };




    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }


    public Object instantiateItem(ViewGroup container , int position)
    {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescriptions = (TextView) view.findViewById(R.id.slide_descriptions);


        slideImageView.setImageResource(slide_image[position]);
        slideHeading.setText(slide_heading[position]);
        slideDescriptions.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries");

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
