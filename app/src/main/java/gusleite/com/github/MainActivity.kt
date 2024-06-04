package gusleite.com.github

import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import gusleite.com.github.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val itemList = mutableListOf<ItemModel>()
    private lateinit var recyclerViewAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemList.add(ItemModel("Copacabana", "RJ", "Rio de Janeiro") { item ->
            itemList.remove(item)
            recyclerViewAdapter.notifyDataSetChanged()
        })

        recyclerViewAdapter = ItemAdapter(itemList)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = recyclerViewAdapter
        }

        recyclerViewAdapter.notifyDataSetChanged()
    }
}