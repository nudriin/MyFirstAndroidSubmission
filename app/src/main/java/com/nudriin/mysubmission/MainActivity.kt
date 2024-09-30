package com.nudriin.mysubmission

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nudriin.mysubmission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val techList = ArrayList<Tech>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RVTech.setHasFixedSize(true)

        binding.includeCardAbout.aboutPage.setOnClickListener(this)
        techList.addAll(getTechList())
        showTechList()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    private fun getTechList(): ArrayList<Tech> {
        val titleArr = resources.getStringArray(R.array.data_tech)
        val descriptionArr = resources.getStringArray(R.array.data_tech_detail)
        val iconArr = resources.getStringArray(R.array.data_techIcon)
        val techList = ArrayList<Tech>()
        for(i in titleArr.indices){
            val tech = Tech(titleArr[i], descriptionArr[i], iconArr[i])
            techList.add(tech)
        }

        return techList
    }
    private fun showTechList(){
        binding.RVTech.layoutManager = LinearLayoutManager(this)
        val techListAdapter = ListTechAdapter(techList)
        binding.RVTech.adapter = techListAdapter

        techListAdapter.setOnItemClickCallback(object : ListTechAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Tech) {
                moveToTechDetail(data)
            }
        })
    }

    private fun moveToTechDetail(tech: Tech){
        val detailIntent = Intent(this@MainActivity, TechDetailActivity::class.java)
        detailIntent.putExtra(TechDetailActivity.DATA_DETAIl, tech)
        startActivity(detailIntent)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            binding.includeCardAbout.aboutPage.id -> {
                val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutIntent)
            }
                                         }
    }
}