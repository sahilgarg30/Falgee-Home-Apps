package com.example.sahil.listviewandadapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView mListView;
    private EditText mNameEt;
    private EditText mScNameEt;
    private ArrayList<Animal> mAnimalArrayList;
    private MyAnimalAdapter mMyAnimalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView)findViewById(R.id.listView);
        mNameEt = (EditText)findViewById(R.id.editText);
        mScNameEt = (EditText)findViewById(R.id.editText2);
        mAnimalArrayList = new ArrayList<Animal>();

        addAnimal("Dog","Canis lupus");
        addAnimal("Housefly","Musca domestica");
        addAnimal("Tiger","Panthera tigris");
        addAnimal("Lepoard","Panther pardus");
        addAnimal("Lion","Panthera leo");
        addAnimal("Bear","Ursidae carnivora");
        addAnimal("Crow","Corvus splendens");
        addAnimal("Ant","Hymenopetrous formicidae");
        addAnimal("Bat","Chiroptera");
        addAnimal("Buffalo"	, "Bison bonasus");
        addAnimal("Cat","Felis catus");
        addAnimal("Cheetah","Acinonyx jubatus");
        addAnimal("Crocodile","Crocodilia niloticus");
        addAnimal("Elephant","Proboscidea elepahantidae");
        addAnimal("Dolphin","Delphinidae delphis");
        addAnimal("Goat","Capra hircus");
        addAnimal("Frog","Anura ranidae");
        addAnimal("Rabbit","Leoparidae cuniculas");
        addAnimal("Giraffe","Giraffa horridus");
        addAnimal("Fox","Cannis vulpes");
        addAnimal("Deer","Artiodactyl cervidae");
        addAnimal("Cobra","Elaphidae naja");
        addAnimal("Panda","Alurpoda melanoleuca");
        addAnimal("Ass","Equs asinus");
        addAnimal("Horse","Equus ferus caballus");

        mMyAnimalAdapter = new MyAnimalAdapter(MainActivity.this,mAnimalArrayList);
        mListView.setAdapter(mMyAnimalAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mAnimalArrayList.remove(position);
                mMyAnimalAdapter.setmAnimalList(mAnimalArrayList);
                mMyAnimalAdapter.notifyDataSetChanged();
            }
        });
    }

    public void addAnimal(View view) {
        Animal a1 = new Animal();
        a1.setName(mNameEt.getText().toString(),mScNameEt.getText().toString());
        mAnimalArrayList.add(a1);
        mMyAnimalAdapter.setmAnimalList(mAnimalArrayList);
        mMyAnimalAdapter.notifyDataSetChanged();
        mNameEt.setText("");
        mScNameEt.setText("");
    }

    public void addAnimal(String a1, String a2){
        Animal animal = new Animal();
        animal.setName(a1,a2);
        mAnimalArrayList.add(animal);
    }
}
