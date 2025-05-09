package bca.internship

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class DashboardActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    val productImageArray = arrayOf(R.drawable.biscuits,R.drawable.bounbon,R.drawable.cookies,R.drawable.jimjam)
    val productNameArray = arrayOf("Biscuits","BounBon","Cookies","Jimjam")
    val productPriceArray = arrayOf("45","20","80","10")
    val productDescArray = arrayOf(
        "A biscuit can refer to two main types of baked goods: a small, soft, quick bread, often raised with baking powder, and a hard, dry, flat cake, similar to a cracker or cookie",
        "Bourbon is a type of American whiskey that is defined by its mash bill (a mix of grains) containing at least 51% corn, distilled at 160 proof or less, and aged in charred new oak barrels. It's known for its distinctive flavors of vanilla, oak, caramel, and spice.",
        "Cookies and biscuits are both small, baked goods, but they differ in texture, ingredients, and how they are made. Cookies are often sweet, soft, and chewy, with a variety of flavors and inclusions like chocolate chips or nuts.",
        "Britannia Jim Jam biscuits are a popular Indian cream biscuit featuring a crispy biscuit base, sandwiched cream filling, and a dollop of jam, topped with sugar crystals."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.dashboard_recycler)
        //Display Data In List
        //recyclerView.layoutManager = LinearLayoutManager(this@DashboardActivity)

        //Display Data In Grid
        //recyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        //Display Data In Horizontal
        recyclerView.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)

        var proAdapter : ProductAdapter = ProductAdapter(this@DashboardActivity,productImageArray,productNameArray,productDescArray,productPriceArray)
        recyclerView.adapter = proAdapter

    }
}