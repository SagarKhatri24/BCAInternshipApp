package bca.internship

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.razorpay.Checkout
import com.razorpay.PaymentData
import com.razorpay.PaymentResultWithDataListener
import org.json.JSONObject

class ProductDetailActivity : AppCompatActivity(),PaymentResultWithDataListener {

    lateinit var name : TextView
    lateinit var desc : TextView
    lateinit var price : TextView
    lateinit var image : ImageView
    lateinit var buyNow : Button
    lateinit var productAmount : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_product_detail)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        name = findViewById(R.id.product_detail_name)
        desc = findViewById(R.id.product_detail_description)
        price = findViewById(R.id.product_detail_price)
        image = findViewById(R.id.product_detail_image)

        buyNow = findViewById(R.id.buy_now)

        var bundle: Bundle = intent.extras!!

        name.setText(bundle.getString("NAME"))
        desc.setText(bundle.getString("DESCRIPTION"))
        productAmount = bundle.getString("PRICE")!!
        price.setText(resources.getString(R.string.price_symbol)+productAmount)

        image.setImageResource(bundle.getInt("IMAGE"))

        buyNow.setOnClickListener {
            startPayment()
        }

    }

    private fun startPayment() {
        //TODO("Not yet implemented")
        var activity : Activity = this
        var co : Checkout = Checkout()
        co.setKeyID("rzp_test_xsiOz9lYtWKHgF")

        var jsonObject : JSONObject = JSONObject()
        jsonObject.put("name", resources.getString(R.string.app_name))
        jsonObject.put("description","Buy Now Product Description")
        jsonObject.put("send_sms_hash",true)
        jsonObject.put("allow_rotation",true)

        jsonObject.put("image",R.mipmap.ic_launcher)
        jsonObject.put("currency","INR")
        jsonObject.put("amount",(productAmount.toInt() * 100).toString())

        var preFill : JSONObject = JSONObject()
        preFill.put("email","sagar@gmail.com")
        preFill.put("contact","7433050707")

        jsonObject.put("prefill",preFill)
        co.open(activity,jsonObject)

    }

    override fun onPaymentSuccess(p0: String?, p1: PaymentData?) {
        //TODO("Not yet implemented")
        Toast.makeText(this@ProductDetailActivity,"Payment Successfull ${p0}",Toast.LENGTH_SHORT).show()
    }

    override fun onPaymentError(p0: Int, p1: String?, p2: PaymentData?) {
        //TODO("Not yet implemented")
        Toast.makeText(this@ProductDetailActivity,"Payment Fail ${p0}",Toast.LENGTH_SHORT).show()
    }
}