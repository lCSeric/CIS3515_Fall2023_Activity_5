package edu.temple.simplerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// TODO(Step 1: Implement click behavior)

// TODO (Step 1a: Accept lambda in constructor)
class NumberDisplayAdapter(private val _numbers: Array<Int>, private val _callback: (Float) -> Unit) : RecyclerView.Adapter<NumberDisplayAdapter.NumberViewHolder>() {
    private val callback = _callback
    private val numbers = _numbers
    // TODO (Step 1b: Invoke lambda via onClickListener)
    inner class NumberViewHolder (layout: View) : RecyclerView.ViewHolder (layout) {
        // enumerate views inside layout
        val textView = layout.findViewById<TextView>(R.id.textView)

        init {
            layout.setOnClickListener{
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION)
                callback.invoke(numbers[adapterPosition].toFloat())

                }
            }
        }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {

        val layout = LayoutInflater.from(parent.context).inflate(R.layout.textview_layout, parent, false)
        return NumberViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return numbers.size
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.textView.text = numbers[position].toString()
    }

}