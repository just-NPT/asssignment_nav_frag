package com.example.assignment_nav_frag.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.assignment_nav_frag.R;
import com.example.assignment_nav_frag.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;

    Double num1, num2;
    String input = "",op,output,res,fixed_output;
    boolean flag;
    private EditText result,calculationStandard;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_gallery,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button One = view.findViewById(R.id.One);
        Button Two = view.findViewById(R.id.Two);
        Button Three = view.findViewById(R.id.Three);
        Button Four = view.findViewById(R.id.Four);
        Button Five = view.findViewById(R.id.Five);
        Button Six = view.findViewById(R.id.Six);
        Button Seven = view.findViewById(R.id.Seven);
        Button Eight = view.findViewById(R.id.Eight);
        Button Nine = view.findViewById(R.id.Nine);
        Button Dot = view.findViewById(R.id.Dot);
        calculationStandard = view .findViewById(R.id.calculation_standard);
        result = view.findViewById(R.id.result);

        Button PlusBTN = view.findViewById(R.id.PlusBTN);
        Button MinusBTN = view.findViewById(R.id.MinusBTN);
        Button MultiBTN = view.findViewById(R.id.MultiBTN);
        Button DivBTN = view.findViewById(R.id.DivBTN);
        Button fraction = view.findViewById(R.id.fraction);
        Button root = view.findViewById(R.id.root);
        Button square = view.findViewById(R.id.square);
        Button ClearEntryBTN = view.findViewById(R.id.Clear_EntryBTN);
        Button Clear = view.findViewById(R.id.Clear);
        Button Equal = view.findViewById(R.id.Equal);
        ImageButton backSpace = view.findViewById(R.id.back_space);

        One.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("1");
            }
        });

        Two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("2");
            }
        });

        Three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("3");
            }
        });

        Four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("4");
            }
        });

        Five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("5");
            }
        });

        Six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("6");
            }
        });

        Seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("7");
            }
        });

        Eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("8");
            }
        });

        Nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput("9");
            }
        });

        Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumInput(".");
            }
        });

        PlusBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input.equals("")){
                    op = "+";
                    input = result.getText().toString();
                    String s = "";
                    s += input + " + " ;
                    calculationStandard.setText(s);
                    flag = true;
                }else{
                    solve();
                    op = "+";
                    String s = "";
                    s += input + " + " ;
                    calculationStandard.setText(s);
                    flag = true;
                }
            }
        });

        MinusBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!input.equals("")){
                    solve();
                    op = "-";
                    String s = "";
                    s += input + " - " ;
                    calculationStandard.setText(s);
                    flag = true;
                }else{
                    op = "-";
                    input = result.getText().toString();
                    String s = "";
                    s += input + " - " ;
                    calculationStandard.setText(s);;
                    flag = true;
                }
            }
        });

        MultiBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!input.equals("")){
                    solve();
                    op = "*";
                    String s = "";
                    s += input + " * " ;
                    calculationStandard.setText(s);
                    flag = true;
                }else{
                    op = "*";
                    input = result.getText().toString();
                    String s = "";
                    s += input + " * " ;
                    calculationStandard.setText(s);
                    flag = true;
                }
            }
        });

        DivBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!input.equals("")){
                    solve();
                    op = "/";
                    String s = "";
                    s += input + " / " ;
                    calculationStandard.setText(s);
                    flag = true;
                }else{
                    op = "/";
                    input = result.getText().toString();
                    String s = "";
                    s += input + " / " ;
                    calculationStandard.setText(s);
                    flag = true;
                }
            }
        });

        Equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = calculationStandard.getText().toString();
                calculationStandard.setText(temp + result.getText().toString());
                solve();
                flag = true;
            }
        });

        backSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(result != null){
                    result.setText(result.getText().toString().substring(0,result.getText().toString().length()-1));
                }
                if(result==null){
                    result.setText("0");
                }
            }
        });

        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(result != null){
                    String s = result.getText().toString();
                    calculationStandard.setText("pow("+ s + ")");
                    Double d = Double.parseDouble(result.getText().toString());
                    input = Double.toString(d*d);
                    result.setText(Double.toString(d*d));
                }
            }
        });

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(result != null){
                    String s = result.getText().toString();
                    calculationStandard.setText("rootof("+s+")");
                    Double d = Double.parseDouble(s);
                    input = Double.toString(Math.sqrt(d));
                    result.setText(Double.toString(Math.sqrt(d)));
                }
            }
        });

        fraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(result !=  null){
                    String s = result.getText().toString();
                    calculationStandard.setText("1/"+s);
                    Double d = Double.parseDouble(s);
                    input = Double.toString(1/d);
                    result.setText(Double.toString(1/d));
                }
            }
        });

        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = "";
                result.setText("0");
                calculationStandard.setText("");
            }
        });

        ClearEntryBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(result != null){
                    num2 = (double) 0;
                    result.setText("0");}
                else{ calculationStandard.setText("");
                    num2 = (double) 0;
                    result.setText("0");
                }
            }
        });
    }

    public void NumInput(String s){
        if(result.getText().toString().equals("0") || flag ){
            result.setText(s);
            flag = false;
        }else if(s.equals(".")){
            if(!result.getText().toString().contains(".")) {
                result.setText(result.getText().toString() + s);
            }
        }else{
            result.setText(result.getText().toString()+s);
        }
    }


    public void solve() {
        switch (op){
            case "+":
                output = Double.toString(Double.parseDouble(input) + Double.parseDouble(result.getText().toString()));
                break;
            case "-":
                output = Double.toString(Double.parseDouble(input) - Double.parseDouble(result.getText().toString()));
                break;
            case "/":
                output = Double.toString(Double.parseDouble(input) / Double.parseDouble(result.getText().toString()));
                break;
            case "*":
                output = Double.toString(Double.parseDouble(input) * Double.parseDouble(result.getText().toString()));
                break;

        }
        input = output;
        result.setText(output);
        op = "";
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}