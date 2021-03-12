package com.example.weather_jitendera_arya_alogfocus

import android.graphics.Color.red
import android.graphics.drawable.AnimationDrawable
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.address
import kotlinx.android.synthetic.main.show_graph_value.*
import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*-------------------------------api service code------------------------------*/

      //  val CITY: String = "dhaka,bd"
       // val API: String = "06c921750b9a82d8f5d1294e1586276f" // Use API key

        //--------------------------spinner select city--------------------------------
        var CITY1: String = "yamunanagar,in"
        var CITY2: String = "Dhaka,bd"
        var CITY3: String = "Delhi,in"
        var CITY4: String = "Noida,in"
        val ct:Array<String> = arrayOf(CITY1,CITY2,CITY3,CITY4)
        val arrayAdapter = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,ct)

        // attach array to adpater
        spinner.adapter =arrayAdapter
        spinner.onItemSelectedListener = object :
         AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val text: String = parent?.getItemAtPosition(position).toString()
                //holdText.text=text // location is set from the spinner

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        //---------------------------end of city selection-----------------------------


        //weatherTask().execute()

        //-------------------------------end of api service code------------------------------

        /*----------------------------graph--------------------------------------------*/

        //Part1
        val entries = ArrayList<Entry>()

         //Part2
           entries.add(Entry(1f, 10f))
           entries.add(Entry(2f, 2f))
           entries.add(Entry(3f, 7f))
           entries.add(Entry(4f, 20f))
           entries.add(Entry(5f, 16f))

           //Part3
           val vl = LineDataSet(entries, "Today Temprature")

           //Part4
           vl.setDrawValues(false)
           vl.setDrawFilled(true)
           vl.lineWidth = 3f
           vl.fillColor = R.color.Brown
           vl.fillAlpha = R.color.DarkRed


           //Part5
           lineChart.xAxis.labelRotationAngle = 0f

           //Part6
           lineChart.data = LineData(vl)

           //Part7
           lineChart.axisRight.isEnabled = false
        val j:Int =5;
        lineChart.xAxis.axisMaximum = j+0.1f

           //Part8
           lineChart.setTouchEnabled(true)
           lineChart.setPinchZoom(true)

           //Part9
           lineChart.description.text = "Temp"
           lineChart.setNoDataText("No forex yet!")

           //Part10
           lineChart.animateX(4000, Easing.EaseInExpo)

           //Part11
           val markerView = CustomMarker(this@MainActivity, R.layout.show_graph_value)
           lineChart.marker = markerView

        //-----------------------end of graph--------------------------------------------

        /*------------------------------------ui code with components------------------- */

       /* val textF1 :List<String> = listOf("wind","prsessure","humidity","sunset","sunrise","status","address")
        val textF2 :List<String> = listOf("17 /","15 /","16 /","14 /","16 /","17 /","15 /")
        val textF3 :List<String> = listOf("32°C ","33°C ","34°C ","32°C ","35°C ","33°C ","32°C ")
        rcyview.adapter=adapter(textF1,textF2,textF3) */

        rcyview.layoutManager = LinearLayoutManager(this)

        BottomSheetBehavior.from(fmBottomSheet).apply {
            peekHeight=400
            this.state= BottomSheetBehavior.STATE_COLLAPSED
            //lnr.setBackgroundColor(255)
        }


        val img =img1.background as AnimationDrawable // use for image change by one by one
        img.start()

        actionOnImage()
        weatherTask().execute()

        //------------------------------------End of ui code with components-------------------

    }

    fun actionOnImage(){
        imgg1.animate().apply {
            duration=950
            alpha(.5f)
            scaleXBy(0.5f)
            scaleYBy(0.5f)
            rotationYBy(360f)
            translationYBy(200f)
        }.withEndAction{
            imgg1.animate().apply {
                duration=950
                alpha(1f)
                scaleXBy(-0.5f)
                scaleYBy(-0.5f)
                rotationXBy(360f)
                translationYBy(-200f)
            }
        }.start()



        //---------------------------------------------------------------------
        imgg2.animate().apply {
            duration=1100
            alpha(.5f)
            scaleXBy(0.5f)
            scaleYBy(0.5f)
            rotationYBy(360f)
            translationYBy(200f)
        }.withEndAction{
            imgg2.animate().apply {
                duration=1100
                alpha(1f)
                scaleXBy(-0.5f)
                scaleYBy(-0.5f)
                rotationXBy(360f)
                translationYBy(-200f)
            }
        }.start()

        //---------------------------------------------------------------------
        imgg3.animate().apply {
            duration=1200
            alpha(.5f)
            scaleXBy(0.5f)
            scaleYBy(0.5f)
            rotationYBy(360f)
            translationYBy(200f)
        }.withEndAction{
            imgg3.animate().apply {
                duration=1200
                alpha(1f)
                scaleXBy(-0.5f)
                scaleYBy(-0.5f)
                rotationXBy(360f)
                translationYBy(-200f)
            }
        }.start()

        //---------------------------------------------------------------------
        imgg4.animate().apply {
            duration=1300
            alpha(.5f)
            scaleXBy(0.5f)
            scaleYBy(0.5f)
            rotationYBy(360f)
            translationYBy(200f)
        }.withEndAction{
            imgg4.animate().apply {
                duration=1300
                alpha(1f)
                scaleXBy(-0.5f)
                scaleYBy(-0.5f)
                rotationXBy(360f)
                translationYBy(-200f)
            }
        }.start()

        //---------------------------------------------------------------------
        imgg5.animate().apply {
            duration=1400
            alpha(.5f)
            scaleXBy(0.5f)
            scaleYBy(0.5f)
            rotationYBy(360f)
            translationYBy(200f)
        }.withEndAction{
            imgg5.animate().apply {
                duration=1400
                alpha(1f)
                scaleXBy(-0.5f)
                scaleYBy(-0.5f)
                rotationXBy(360f)
                translationYBy(-200f)
            }
        }.start()

        //---------------------------------------------------------------------
        imgg6.animate().apply {
            duration=1500
            alpha(.5f)
            scaleXBy(0.5f)
            scaleYBy(0.5f)
            rotationYBy(360f)
            translationYBy(200f)
        }.withEndAction{
            imgg6.animate().apply {
                duration=1500
                alpha(1f)
                scaleXBy(-0.5f)
                scaleYBy(-0.5f)
                rotationXBy(360f)
                translationYBy(-200f)
            }
        }.start()

        //---------------------------------------------------------------------
        //---------------------------------------------------------------------

    }

   /*-----------------------Starting of inner function code--------------------------*/

    inner class weatherTask() : AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            /* Showing the ProgressBar, Making the main design GONE */
           // findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE
           // findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.GONE
           // findViewById<TextView>(R.id.errorText).visibility = View.GONE
        }

        override fun doInBackground(vararg params: String?): String? {
            var response:String?
            // var CITY:String=holdText.text.toString()

            var CITY: String = "yamunanagar,in" // in stand for india
            val API: String ="a1ceec6d5ba6e8300dc97985ddec79ad"

            //--------city type function----------
             //cityName(CITY)

            //-----------end----------------------

            try{
                response = URL("https://api.openweathermap.org/data/2.5/weather?q=$CITY&units=metric&appid=$API").readText(
                    Charsets.UTF_8
                )
            }catch (e: Exception){
                response = null
            }
            return response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {
                /* Extracting JSON returns from the API */
                val jsonObj = JSONObject(result)
                val main = jsonObj.getJSONObject("main")
                val sys = jsonObj.getJSONObject("sys")
                val wind = jsonObj.getJSONObject("wind")
                val weather = jsonObj.getJSONArray("weather").getJSONObject(0)

                val updatedAt:Long = jsonObj.getLong("dt")
                val updatedAtText = "Updated at: "+ SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(
                    Date(updatedAt*1000)
                )
                val temp = main.getString("temp")+"°C"
               // val tempMin = "Min Temp: " + main.getString("temp_min")+"°C"
                //  val tempMax = "Max Temp: " + main.getString("temp_max")+"°C"
                val pressure = main.getString("pressure")
                val humidity = main.getString("humidity")

                val sunrise:Long = sys.getLong("sunrise")
                val sunset:Long = sys.getLong("sunset")
                val windSpeed = wind.getString("speed")
                val weatherDescription = weather.getString("description")

                val address = jsonObj.getString("name")+", "+sys.getString("country")

                /* Populating extracted data into our views */
                findViewById<TextView>(R.id.address).text = address
                findViewById<TextView>(R.id.Date_Time).text =  updatedAtText
                findViewById<TextView>(R.id.statuss).text = weatherDescription.capitalize()
                findViewById<TextView>(R.id.temp).text = temp
                // findViewById<TextView>(R.id.txt6).text = tempMin
               // findViewById<TextView>(R.id.txt2).text = tempMax
                  findViewById<TextView>(R.id.txt1).text = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(
                     Date(sunrise*1000)
                 )
                 findViewById<TextView>(R.id.txt2).text = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(
                     Date(sunset*1000)
                 )
                findViewById<TextView>(R.id.txt3).text = windSpeed
                findViewById<TextView>(R.id.txt4).text = pressure
                findViewById<TextView>(R.id.txt5).text = humidity

                /* Views populated, Hiding the loader, Showing the main design */
               // findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
               // findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.VISIBLE

            } catch (e: Exception) {
                //findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
              //  findViewById<TextView>(R.id.errorText).visibility = View.VISIBLE
            }

     /*------------------adpater data------------------------------------*/
            //-------get text value from text1 to text 6---------------------
            val str1: String = txt1.text.toString()
            val str2: String = txt2.text.toString()
            val str3: String = txt3.text.toString()
            val str4: String = txt4.text.toString()
            val str5: String = txt5.text.toString()
            val strAddress: String = address.text.toString()
            val strStatus: String = statuss.text.toString()



            //------------end of this function --------------------------------------
            val textF1 :List<String> = listOf("Wind Speed","Prsessure","Humidity","Sunset","Sunrise","Status","Address")
            val textF2 :List<String> = listOf("17 /","15 /","16 /","14 /","16 /","17 /","15 /")
           // val textF3 :List<String> = listOf("32°C ","33°C ","34°C ","32°C ","35°C ","33°C ","32°C ")
            val textF3 :List<String> = listOf(str3,str4,str5,str2,str1,strStatus,strAddress)
            rcyview.adapter=adapter(textF1,textF2,textF3)


      //-----------------------------end of adapter data--------------------------------

        }
    }

   //---------------------------------------end of code---------------------------------------




}