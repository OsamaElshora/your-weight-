package osama.com

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity(),View.OnClickListener {
     val marsgravity = 0.38f
     val zzgravity = 0.91f
     val moshgravity = 2.34f
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

        // var weg = edit_weight.text
         button_put.setOnClickListener {
            // var result = cal(weg.toString().toDouble())
            // text_View2.text = result.toString()
         }
         checkBox1.setOnClickListener(this)
         checkBox2.setOnClickListener(this)
         checkBox3.setOnClickListener(this)
     }

     override fun onClick(v: View?) {
         v as CheckBox
         var checked: Boolean = v.isChecked
         var weg = edit_weight.text
         when (v.id) {

             R.id.checkBox1 -> if (checked && !TextUtils.isEmpty(edit_weight.text))
             {cal(weg.toString().toDouble(),v)
                 checkBox2.isChecked = false
                 checkBox3.isChecked = false
             }

             R.id.checkBox2 -> if (checked&& !TextUtils.isEmpty(edit_weight.text)){
                 cal(weg.toString().toDouble(),v)
                 checkBox3.isChecked= false
                 checkBox1.isChecked = false
             }
             R.id.checkBox3 -> if (checked&& !TextUtils.isEmpty(edit_weight.text)){
                 cal(weg.toString().toDouble(),v)
                 checkBox1.isChecked=false
                 checkBox2.isChecked= false
             }

         }
     }
             fun cal(weg: Double,checkBox: CheckBox){
                 var result :Double?
                 when(checkBox.id){
                     R.id.checkBox1->result = weg*marsgravity
                     R.id.checkBox2->result = weg*zzgravity
                     R.id.checkBox3->result = weg*moshgravity
                     else -> result=weg*marsgravity
                 }
                  text_View2.text= result.format(2).toString()

             }
     fun Double.format(digits : Int) = java.lang.String.format("%.${digits}f", this)
 }
