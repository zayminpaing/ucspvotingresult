package zmp.ucsptn.ucspvotingresult;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    public String b1="Htet Lin Htike";
    public String b2="Aung Bhone Kyaw";
    public String b3="Kaung Htet Oo";
    public String b4="Khaing Min Khant";
    public String b5="Min Khant";
    public String b6="Wai Yan Min Htet";
    public String b7="Kaung Myat Kyaw";
    public String b8="Hein Htet Kyaw Zin";
    public String b9="Min Khant Ko";
    public String b10="Kaung Sithu Tun";
    public String b11="Kyaw Thet Hmue";
    public String g1="Phyu Sin Win Tint";
    public String g2="Shin Thant Kyaw";
    public String g3="Shoon Lae May Oo";
    public String g4="Zuu Mi Myat Noe";
    public String g5="Khin Yadana Aung";
    public String g6="Thazin Aung";
    public String g7="Win Lae Lae Aung";
    public String g8="Htet Myat Thant";
    public String g9="Khaing Wai Phyo";
    public String g10="Su Hlaing Bo";
    public String g11="San San Yadanar Htun";
    int b1r,b2r,b3r,b4r,b5r,b6r,b7r,b8r,b9r,b10r,b11r;
    int g1r,g2r,g3r,g4r,g5r,g6r,g7r,g8r,g9r,g10r,g11r;
    ArrayList<String> kings=new ArrayList<>(),style_boys=new ArrayList<>()
            ,innocent_boys=new ArrayList<>(),queens=new ArrayList<>()
            ,style_girls=new ArrayList<>()
            ,innocent_girls=new ArrayList<>();
    TextView txt;
    Spinner key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
        txt=findViewById(R.id.txt);
        key=findViewById(R.id.key);
        Spinner spinner = (Spinner) findViewById(R.id.key);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        readData(new MyCallBack() {
            @Override
            public void onCallBack(String value) {
                StringTokenizer st=new StringTokenizer(value,":");
                StringTokenizer st2=new StringTokenizer(st.nextToken(),",");
                st2.nextToken();
                kings.add(st2.nextToken());
                st2=new StringTokenizer(st.nextToken(),",");
                st2.nextToken();
                style_boys.add(st2.nextToken());
                st2=new StringTokenizer(st.nextToken(),",");
                st2.nextToken();
                innocent_boys.add(st2.nextToken());
                st2=new StringTokenizer(st.nextToken(),",");
                st2.nextToken();
                queens.add(st2.nextToken());
                st2=new StringTokenizer(st.nextToken(),",");
                st2.nextToken();
                style_girls.add(st2.nextToken());
                st2=new StringTokenizer(st.nextToken(),",");
                st2.nextToken();
                innocent_girls.add(st2.nextToken());
            }
        });
        key.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    clear();
                    showKings();
                }
                else if(position==1){
                    clear();
                    showStyleBoys();
                }
                else if(position==2){
                    clear();
                    showInnocentBoys();
                }
                else if(position==3){
                    clear();
                    showQueens();
                }
                else if(position==4){
                    clear();
                    showStyleGirls();
                }
                else if(position==5){
                    clear();
                    showInnocentGirls();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void readData(final MyCallBack myCallBack){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    String str = childSnapshot.getValue(String.class);
                    myCallBack.onCallBack(str);
                }
                showKings();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void clear(){
        b1r=0;
        b2r=0;
        b3r=0;
        b4r=0;
        b5r=0;
        b6r=0;
        b7r=0;
        b8r=0;
        b9r=0;
        b10r=0;
        b11r=0;
        g1r=0;
        g2r=0;
        g3r=0;
        g4r=0;
        g5r=0;
        g6r=0;
        g7r=0;
        g8r=0;
        g9r=0;
        g10r=0;
        g11r=0;

    }
    public void showKings(){
        for(String king:kings){
            if(king.equals(b1)){
                b1r++;
            }
            else if(king.equals(b2)){
                b2r++;
            }
            else if(king.equals(b3)){
                b3r++;
            }
            else if(king.equals(b4)){
                b4r++;
            }
            else if(king.equals(b5)){
                b5r++;
            }
            else if(king.equals(b6)){
                b6r++;
            }
            else if(king.equals(b7)){
                b7r++;
            }
            else if(king.equals(b8)){
                b8r++;
            }
            else if(king.equals(b9)){
                b9r++;
            }
            else if(king.equals(b10)){
                b10r++;
            }
            else if(king.equals(b11)){
                b11r++;
            }
        }
        txt.setText(b1+"=>"+b1r+"\n\n");
        txt.append(b2+"=>"+b2r+"\n\n");
        txt.append(b3+"=>"+b3r+"\n\n");
        txt.append(b4+"=>"+b4r+"\n\n");
        txt.append(b5+"=>"+b5r+"\n\n");
        txt.append(b6+"=>"+b6r+"\n\n");
        txt.append(b7+"=>"+b7r+"\n\n");
        txt.append(b8+"=>"+b8r+"\n\n");
        txt.append(b9+"=>"+b9r+"\n\n");
        txt.append(b10+"=>"+b10r+"\n\n");
        txt.append(b11+"=>"+b11r+"\n\n");
    }
    public void showStyleBoys(){
        for(String king:style_boys){
            Toast.makeText(MainActivity.this,king,Toast.LENGTH_LONG).show();
            if(king.equals(b1)){
                b1r++;
            }
            else if(king.equals(b2)){
                b2r++;
            }
            else if(king.equals(b3)){
                b3r++;
            }
            else if(king.equals(b4)){
                b4r++;
            }
            else if(king.equals(b5)){
                b5r++;
            }
            else if(king.equals(b6)){
                b6r++;
            }
            else if(king.equals(b7)){
                b7r++;
            }
            else if(king.equals(b8)){
                b8r++;
            }
            else if(king.equals(b9)){
                b9r++;
            }
            else if(king.equals(b10)){
                b10r++;
            }
            else if(king.equals(b11)){
                b11r++;
            }
        }
        txt.setText(b1+"=>"+b1r+"\n\n");
        txt.append(b2+"=>"+b2r+"\n\n");
        txt.append(b3+"=>"+b3r+"\n\n");
        txt.append(b4+"=>"+b4r+"\n\n");
        txt.append(b5+"=>"+b5r+"\n\n");
        txt.append(b6+"=>"+b6r+"\n\n");
        txt.append(b7+"=>"+b7r+"\n\n");
        txt.append(b8+"=>"+b8r+"\n\n");
        txt.append(b9+"=>"+b9r+"\n\n");
        txt.append(b10+"=>"+b10r+"\n\n");
        txt.append(b11+"=>"+b11r+"\n\n");
    }
    public void showInnocentBoys(){
        for(String king:innocent_boys){
            Toast.makeText(MainActivity.this,king,Toast.LENGTH_LONG).show();
            if(king.equals(b1)){
                b1r++;
            }
            else if(king.equals(b2)){
                b2r++;
            }
            else if(king.equals(b3)){
                b3r++;
            }
            else if(king.equals(b4)){
                b4r++;
            }
            else if(king.equals(b5)){
                b5r++;
            }
            else if(king.equals(b6)){
                b6r++;
            }
            else if(king.equals(b7)){
                b7r++;
            }
            else if(king.equals(b8)){
                b8r++;
            }
            else if(king.equals(b9)){
                b9r++;
            }
            else if(king.equals(b10)){
                b10r++;
            }
            else if(king.equals(b11)){
                b11r++;
            }
        }
        txt.setText(b1+"=>"+b1r+"\n\n");
        txt.append(b2+"=>"+b2r+"\n\n");
        txt.append(b3+"=>"+b3r+"\n\n");
        txt.append(b4+"=>"+b4r+"\n\n");
        txt.append(b5+"=>"+b5r+"\n\n");
        txt.append(b6+"=>"+b6r+"\n\n");
        txt.append(b7+"=>"+b7r+"\n\n");
        txt.append(b8+"=>"+b8r+"\n\n");
        txt.append(b9+"=>"+b9r+"\n\n");
        txt.append(b10+"=>"+b10r+"\n\n");
        txt.append(b11+"=>"+b11r+"\n\n");
    }
    public void showQueens(){
        for(String king:queens){
            Toast.makeText(MainActivity.this,king,Toast.LENGTH_LONG).show();
            if(king.equals(g1)){
                g1r++;
            }
            else if(king.equals(g2)){
                g2r++;
            }
            else if(king.equals(g3)){
                g3r++;
            }
            else if(king.equals(g4)){
                g4r++;
            }
            else if(king.equals(g5)){
                g5r++;
            }
            else if(king.equals(g6)){
                g6r++;
            }
            else if(king.equals(g7)){
                g7r++;
            }
            else if(king.equals(g8)){
                g8r++;
            }
            else if(king.equals(g9)){
                g9r++;
            }
            else if(king.equals(g10)){
                g10r++;
            }
            else if(king.equals(g11)){
                g11r++;
            }
        }
        txt.setText(g1+"=>"+g1r+"\n\n");
        txt.append(g2+"=>"+g2r+"\n\n");
        txt.append(g3+"=>"+g3r+"\n\n");
        txt.append(g4+"=>"+g4r+"\n\n");
        txt.append(g5+"=>"+g5r+"\n\n");
        txt.append(g6+"=>"+g6r+"\n\n");
        txt.append(g7+"=>"+g7r+"\n\n");
        txt.append(g8+"=>"+g8r+"\n\n");
        txt.append(g9+"=>"+g9r+"\n\n");
        txt.append(g10+"=>"+g10r+"\n\n");
        txt.append(g11+"=>"+g11r+"\n\n");
    }
    public void showStyleGirls(){
        for(String king:style_girls){
            Toast.makeText(MainActivity.this,king,Toast.LENGTH_LONG).show();
            if(king.equals(g1)){
                g1r++;
            }
            else if(king.equals(g2)){
                g2r++;
            }
            else if(king.equals(g3)){
                g3r++;
            }
            else if(king.equals(g4)){
                g4r++;
            }
            else if(king.equals(g5)){
                g5r++;
            }
            else if(king.equals(g6)){
                g6r++;
            }
            else if(king.equals(g7)){
                g7r++;
            }
            else if(king.equals(g8)){
                g8r++;
            }
            else if(king.equals(g9)){
                g9r++;
            }
            else if(king.equals(g10)){
                g10r++;
            }
            else if(king.equals(g11)){
                g11r++;
            }
        }
        txt.setText(g1+"=>"+g1r+"\n\n");
        txt.append(g2+"=>"+g2r+"\n\n");
        txt.append(g3+"=>"+g3r+"\n\n");
        txt.append(g4+"=>"+g4r+"\n\n");
        txt.append(g5+"=>"+g5r+"\n\n");
        txt.append(g6+"=>"+g6r+"\n\n");
        txt.append(g7+"=>"+g7r+"\n\n");
        txt.append(g8+"=>"+g8r+"\n\n");
        txt.append(g9+"=>"+g9r+"\n\n");
        txt.append(g10+"=>"+g10r+"\n\n");
        txt.append(g11+"=>"+g11r+"\n\n");
    }
    public void showInnocentGirls(){
        for(String king:innocent_girls){
            Toast.makeText(MainActivity.this,king,Toast.LENGTH_LONG).show();
            if(king.equals(g1)){
                g1r++;
            }
            else if(king.equals(g2)){
                g2r++;
            }
            else if(king.equals(g3)){
                g3r++;
            }
            else if(king.equals(g4)){
                g4r++;
            }
            else if(king.equals(g5)){
                g5r++;
            }
            else if(king.equals(g6)){
                g6r++;
            }
            else if(king.equals(g7)){
                g7r++;
            }
            else if(king.equals(g8)){
                g8r++;
            }
            else if(king.equals(g9)){
                g9r++;
            }
            else if(king.equals(g10)){
                g10r++;
            }
            else if(king.equals(g11)){
                g11r++;
            }
        }
        txt.setText(g1+"=>"+g1r+"\n\n");
        txt.append(g2+"=>"+g2r+"\n\n");
        txt.append(g3+"=>"+g3r+"\n\n");
        txt.append(g4+"=>"+g4r+"\n\n");
        txt.append(g5+"=>"+g5r+"\n\n");
        txt.append(g6+"=>"+g6r+"\n\n");
        txt.append(g7+"=>"+g7r+"\n\n");
        txt.append(g8+"=>"+g8r+"\n\n");
        txt.append(g9+"=>"+g9r+"\n\n");
        txt.append(g10+"=>"+g10r+"\n\n");
        txt.append(g11+"=>"+g11r+"\n\n");
    }
}
