package app.jaydesigns.com.mycalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.FloatMath;


public class MainActivity extends Activity implements View.OnClickListener {


    Button bttn_plus, bttn_min, bttn_x, bttn_divide, bttn_eq, bttn_clear, bttn_ce, bttn_close, bttn_sqr;
    EditText textbox_input;
    TextView view,audit;


    int op1;
    int op2;
    String optr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bttn_plus = (Button) findViewById(R.id.bttn_plus);
        bttn_min = (Button) findViewById(R.id.bttn_min);
        bttn_x = (Button) findViewById(R.id.bttn_x);
        bttn_divide = (Button) findViewById(R.id.bttn_divide);
        bttn_eq = (Button) findViewById(R.id.bttn_eq);
        bttn_clear = (Button) findViewById(R.id.bttn_clear);
        bttn_ce = (Button) findViewById(R.id.bttn_ce);
        bttn_close = (Button) findViewById(R.id.bttn_close);
        //bttn_sqr = (Button) findViewById(R.id.bttn_sqr);

        textbox_input = (EditText) findViewById(R.id.textbox_input);


        view = (TextView) findViewById(R.id.total);
        audit = (TextView) findViewById(R.id.AuditTrail);

        try{
            bttn_plus.setOnClickListener(this);
            bttn_min.setOnClickListener(this);
            bttn_x.setOnClickListener(this);
            bttn_divide.setOnClickListener(this);
            bttn_eq.setOnClickListener(this);
            bttn_clear.setOnClickListener(this);
            bttn_ce.setOnClickListener(this);
            bttn_close.setOnClickListener(this);
            //bttn_sqr.setOnClickListener(this);

        } catch(Exception e){

        }
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




    public void operation() {
        if (optr.equals("+")) {
            op2 = Integer.parseInt(textbox_input.getText().toString());
            audit.setText(audit.getText() + optr + Integer.toString(op2) );
            op1 = op1 + op2;
            view.setText(Integer.toString(op1));
            textbox_input.setText("");
        } else if (optr.equals("-")) {
            op2 = Integer.parseInt(textbox_input.getText().toString());
            audit.setText(audit.getText() + optr + Integer.toString(op2) );
            op1 = op1 - op2;
            view.setText(Integer.toString(op1));
            textbox_input.setText("");
        } else if (optr.equals("*")) {
            op2 = Integer.parseInt(textbox_input.getText().toString());
            audit.setText(audit.getText() + optr + Integer.toString(op2) );
            op1 = op1 * op2;
            view.setText(Integer.toString(op1));
            textbox_input.setText("");
        } else if (optr.equals("/")) {
            op2 = Integer.parseInt(textbox_input.getText().toString());
            audit.setText(audit.getText() + optr + Integer.toString(op2) );
            op1 = op1 / op2;
            view.setText(Integer.toString(op1));
            textbox_input.setText("");
        }
    }



    @Override
    public void onClick(View arg0){
        Editable str =  textbox_input.getText();



        switch(arg0.getId()){
            case R.id.bttn_clear:
                op1 = 0;
                op2 = 0;
                textbox_input.setText("");
                textbox_input.setHint("");
                view.setText("0");
                audit.setText("");

                bttn_plus.setEnabled(true);
                bttn_min.setEnabled(true);
                bttn_x.setEnabled(true);
                bttn_divide.setEnabled(true);
                bttn_eq.setEnabled(true);
            break;
            case R.id.bttn_ce:
                textbox_input.setText("");
                textbox_input.setHint("");

            break;

            case R.id.bttn_plus:
                optr = "+";
                if (op1 == 0) {
                    op1 = Integer.parseInt(textbox_input.getText().toString());
                    view.setText(textbox_input.getText().toString());
                    audit.setText(audit.getText() + Integer.toString(op1) );
                    textbox_input.setText("");
                } else if (op2 != 0) {
                    op2 = 0;
                    view.setText(textbox_input.getText().toString());

                    textbox_input.setText("");
                } else {
                    op2 = Integer.parseInt(textbox_input.getText().toString());
                    textbox_input.setText("");
                    audit.setText(audit.getText() + optr + Integer.toString(op2) );
                    op1 = op1 + op2;
                    op2=0;
                    view.setText(Integer.toString(op1));
                }
            break;



            case R.id.bttn_min:
                optr = "-";
                if (op1 == 0) {
                    op1 = Integer.parseInt(textbox_input.getText().toString());
                    view.setText(textbox_input.getText().toString());
                    audit.setText(audit.getText() + Integer.toString(op1) );
                    textbox_input.setText("");
                } else if (op2 != 0) {
                    op2 = 0;
                    view.setText(textbox_input.getText().toString());

                    textbox_input.setText("");
                } else {
                    op2 = Integer.parseInt(textbox_input.getText().toString());
                    textbox_input.setText("");
                    audit.setText(audit.getText() + optr + Integer.toString(op2) );
                    op1 = op1 - op2;
                    op2=0;
                    view.setText(Integer.toString(op1));
                }
                break;

            case R.id.bttn_x:
                optr = "*";
                if (op1 == 0) {
                    op1 = Integer.parseInt(textbox_input.getText().toString());
                    view.setText(textbox_input.getText().toString());
                    audit.setText(audit.getText() + Integer.toString(op1) );
                    textbox_input.setText("");
                } else if (op2 != 0) {
                    op2 = 0;
                    view.setText(textbox_input.getText().toString());

                    textbox_input.setText("");
                } else {
                    op2 = Integer.parseInt(textbox_input.getText().toString());
                    textbox_input.setText("");
                    audit.setText(audit.getText() + optr + Integer.toString(op2) );
                    op1 = op1 * op2;
                    op2=0;
                    view.setText(Integer.toString(op1));
                }
                break;


            case R.id.bttn_divide:
                optr = "/";
                if (op1 == 0) {
                    op1 = Integer.parseInt(textbox_input.getText().toString());
                    view.setText(textbox_input.getText().toString());
                    audit.setText(audit.getText() + Integer.toString(op1) );
                    textbox_input.setText("");
                } else if (op2 != 0) {
                    op2 = 0;
                    view.setText(textbox_input.getText().toString());

                    textbox_input.setText("");
                } else {
                    op2 = Integer.parseInt(textbox_input.getText().toString());
                    textbox_input.setText("");
                    audit.setText(audit.getText() + optr + Integer.toString(op2) );
                    op1 = op1 / op2;
                    op2=0;
                    view.setText(Integer.toString(op1));
                }
                break;

            case R.id.bttn_eq:
                if (!optr.equals(null)) {
                    if (op2 != 0) {
                        if (optr.equals("+")) {
                            view.setText(Integer.toString(op1));
                        } else if (optr.equals("-")) {
                            view.setText(Integer.toString(op1));
                        } else if (optr.equals("*")) {
                            view.setText(Integer.toString(op1));
                        } else if (optr.equals("/")) {
                            view.setText(Integer.toString(op1));
                        }
                    } else {
                        bttn_plus.setEnabled(false);
                        bttn_min.setEnabled(false);
                        bttn_x.setEnabled(false);
                        bttn_divide.setEnabled(false);
                        bttn_eq.setEnabled(false);

                        operation();
                    }
                }
                break;

                case R.id.bttn_close:
                    System.exit(0);
                    break;


        }

    }


}
