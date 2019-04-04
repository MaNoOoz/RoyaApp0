package com.example.myapplication.Fragments.sub;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.Adapters.CustomAdapter;
import com.example.myapplication.POJO.Bnood;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentShipping extends Fragment {
    int preSelectedIndex = -1;
    ListView listView;

    public FragmentShipping() {
    }

    // ==================================================   Spinner        =================================================================\\
    // // TODO: 4/4/2019
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_shipping, container, false);

        ListView listView = root.findViewById(R.id.listview);

        // Initiate listview data.
        final List<Bnood> initItemList = this.getInitViewItemDtoList();

        // Create a custom list view adapter with checkbox control.
        final CustomAdapter listViewDataAdapter = new CustomAdapter(getActivity(), initItemList);

        listViewDataAdapter.notifyDataSetChanged();

        // Set data adapter to list view.
        listView.setAdapter(listViewDataAdapter);

//        final List<Bnood> users = new ArrayList<>();
//        users.add(new Bnood(false, "Dharm"));
//        users.add(new Bnood(false, "Mark"));
//        users.add(new Bnood(false, "Singh"));
//        users.add(new Bnood(false, "The Mobile Era"));
//        final CustomAdapter adapter = new CustomAdapter(getActivity(), users);
//        listView.setAdapter(adapter);
        listView.setOnTouchListener(new ListView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Bnood model = initItemList.get(i);

                if (model.isSelected())
                    model.setSelected(false);

                else
                    model.setSelected(true);

                initItemList.set(i, model);

                //now update adapter
                listViewDataAdapter.updateRecords(initItemList);
            }
        });


        return root;
    }

    // Return an initialize list of ListViewItemDTO.
    private List<Bnood> getInitViewItemDtoList() {
        String itemTextArr[] = {"التجهيز النهائي", "مستودعات المنتج النهائي", "مستودعات المواد الخام ", "الإشتراطات الصحية الخاصة بالعاملين", "النظافة العامة ", "المواد الخام  ", "مراحل التجهيز التصنيع ", "الأسقف والجدران", "الأرضيات", "المورد المائي", "الصرف الصحي", "التهوية", "الإضاءة", "دورات المياه ومغاسل الأيدي", "أماكن تواجد الخضروات", "أماكن التشغيل والتجهيز"};

        List<Bnood> ret = new ArrayList<Bnood>();

        int length = itemTextArr.length;

        for (int i = 0; i < length; i++) {
            String itemText = itemTextArr[i];

            Bnood dto = new Bnood();
            dto.setSelected(false);
            dto.setUserName(itemText);

            ret.add(dto);
        }

        return ret;
    }


}