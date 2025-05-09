package bca.internship

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    var context: Context,
    var productImageArray: Array<Int>,
    var productNameArray: Array<String>,
    var productDescArray: Array<String>,
    var productPriceArray: Array<String>
) : RecyclerView.Adapter<ProductAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        //TODO("Not yet implemented")
        var view : View = LayoutInflater.from(parent.context).inflate(R.layout.custom_product,parent,false)
        return MyHolder(view)
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var productName : TextView = itemView.findViewById(R.id.custom_product_name)
        var productDesc : TextView = itemView.findViewById(R.id.custom_product_description)
        var productPrice : TextView = itemView.findViewById(R.id.custom_product_price)
        var productImage : ImageView = itemView.findViewById(R.id.custom_product_image)
    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return productNameArray.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        //TODO("Not yet implemented")
        holder.productName.setText(productNameArray[position])
        holder.productDesc.setText(productDescArray[position])
        holder.productPrice.setText(context.resources.getString(R.string.price_symbol)+productPriceArray[position])

        holder.productImage.setImageResource(productImageArray[position])

    }

}
