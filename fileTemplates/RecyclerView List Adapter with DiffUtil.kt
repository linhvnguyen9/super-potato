#parse("File Header.java")
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME}
#end

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ${NAME}ListAdapter : ListAdapter<${NAME}, ${NAME}ListAdapter.${NAME}ViewHolder>(${NAME}ListDiffUtil()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ${NAME}ViewHolder =
        ${NAME}ViewHolder.from(parent)
        
    override fun onBindViewHolder(holder: ${NAME}ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }
    
    class ${NAME}ViewHolder(private val binding: ${BINDING_CLASS_NAME}) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ${NAME}) {
            binding.item = item
            binding.executePendingBindings()
        }
        
    companion object {
            fun from(parent: ViewGroup): ${NAME}ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ${BINDING_CLASS_NAME}.inflate(inflater, parent, false)
                return ${NAME}ViewHolder(binding)
            }
        }
    }
}

class ${NAME}ListDiffUtil : DiffUtil.ItemCallback<${NAME}>() {
    override fun areItemsTheSame(oldItem: ${NAME}, newItem: ${NAME}) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: ${NAME}, newItem: ${NAME}) = oldItem == newItem
}