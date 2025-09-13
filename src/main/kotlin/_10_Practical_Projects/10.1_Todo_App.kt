package _10_Practical_Projects

// 10.1 Todo App

// 10.1.1 Project overview
/*
    - A simple Todo app to manage tasks.
    - Features: Add, edit, delete, and mark tasks as complete.
    - Uses RecyclerView to display tasks.
    - Stores data in SharedPreferences for persistence.
    - Demonstrates basic Android development concepts.
*/

//Example:
// // Data class for Todo items
// data class TodoItem(
//     val id: Long,
//     val title: String,
//     val description: String,
//     val isCompleted: Boolean = false,
//     val createdAt: Long = System.currentTimeMillis()
// )
//
// // ViewHolder for RecyclerView
// class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//     val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
//     val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
//     val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
//     val deleteButton: Button = itemView.findViewById(R.id.deleteButton)
// }
//
// // Adapter for RecyclerView
// class TodoAdapter(
//     private var todos: MutableList<TodoItem>,
//     private val onItemClick: (TodoItem) -> Unit,
//     private val onItemDelete: (TodoItem) -> Unit,
//     private val onItemToggle: (TodoItem) -> Unit
// ) : RecyclerView.Adapter<TodoViewHolder>() {
//     
//     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
//         val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
//         return TodoViewHolder(view)
//     }
//     
//     override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
//         val todo = todos[position]
//         holder.titleTextView.text = todo.title
//         holder.descriptionTextView.text = todo.description
//         holder.checkBox.isChecked = todo.isCompleted
//         
//         // Set click listeners
//         holder.itemView.setOnClickListener { onItemClick(todo) }
//         holder.deleteButton.setOnClickListener { onItemDelete(todo) }
//         holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
//             if (isChecked != todo.isCompleted) {
//                 onItemToggle(todo)
//             }
//         }
//     }
//     
//     override fun getItemCount(): Int = todos.size
//     
//     fun updateTodos(newTodos: List<TodoItem>) {
//         todos.clear()
//         todos.addAll(newTodos)
//         notifyDataSetChanged()
//     }
// }
//
// // Main Activity
// class MainActivity : AppCompatActivity() {
//     private lateinit var recyclerView: RecyclerView
//     private lateinit var addButton: FloatingActionButton
//     private lateinit var todoAdapter: TodoAdapter
//     private lateinit var sharedPreferences: SharedPreferences
//     private var todos = mutableListOf<TodoItem>()
//     private var nextId = 1L
//     
//     override fun onCreate(savedInstanceState: Bundle?) {
//         super.onCreate(savedInstanceState)
//         setContentView(R.layout.activity_main)
//         
//         initializeViews()
//         setupRecyclerView()
//         loadTodos()
//         setupClickListeners()
//     }
//     
//     private fun initializeViews() {
//         recyclerView = findViewById(R.id.recyclerView)
//         addButton = findViewById(R.id.addButton)
//         sharedPreferences = getSharedPreferences("todos", Context.MODE_PRIVATE)
//     }
//     
//     private fun setupRecyclerView() {
//         todoAdapter = TodoAdapter(
//             todos = todos,
//             onItemClick = { todo -> editTodo(todo) },
//             onItemDelete = { todo -> deleteTodo(todo) },
//             onItemToggle = { todo -> toggleTodo(todo) }
//         )
//         recyclerView.adapter = todoAdapter
//         recyclerView.layoutManager = LinearLayoutManager(this)
//     }
//     
//     private fun setupClickListeners() {
//         addButton.setOnClickListener {
//             showAddTodoDialog()
//         }
//     }
//     
//     private fun showAddTodoDialog() {
//         val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_todo, null)
//         val titleEditText = dialogView.findViewById<EditText>(R.id.titleEditText)
//         val descriptionEditText = dialogView.findViewById<EditText>(R.id.descriptionEditText)
//         
//         AlertDialog.Builder(this)
//             .setTitle("Add Todo")
//             .setView(dialogView)
//             .setPositiveButton("Add") { _, _ ->
//                 val title = titleEditText.text.toString().trim()
//                 val description = descriptionEditText.text.toString().trim()
//                 if (title.isNotEmpty()) {
//                     addTodo(title, description)
//                 }
//             }
//             .setNegativeButton("Cancel", null)
//             .show()
//     }
//     
//     private fun addTodo(title: String, description: String) {
//         val todo = TodoItem(
//             id = nextId++,
//             title = title,
//             description = description
//         )
//         todos.add(todo)
//         todoAdapter.notifyItemInserted(todos.size - 1)
//         saveTodos()
//     }
//     
//     private fun editTodo(todo: TodoItem) {
//         val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_todo, null)
//         val titleEditText = dialogView.findViewById<EditText>(R.id.titleEditText)
//         val descriptionEditText = dialogView.findViewById<EditText>(R.id.descriptionEditText)
//         
//         titleEditText.setText(todo.title)
//         descriptionEditText.setText(todo.description)
//         
//         AlertDialog.Builder(this)
//             .setTitle("Edit Todo")
//             .setView(dialogView)
//             .setPositiveButton("Save") { _, _ ->
//                 val title = titleEditText.text.toString().trim()
//                 val description = descriptionEditText.text.toString().trim()
//                 if (title.isNotEmpty()) {
//                     updateTodo(todo, title, description)
//                 }
//             }
//             .setNegativeButton("Cancel", null)
//             .show()
//     }
//     
//     private fun updateTodo(todo: TodoItem, title: String, description: String) {
//         val index = todos.indexOfFirst { it.id == todo.id }
//         if (index != -1) {
//             todos[index] = todo.copy(title = title, description = description)
//             todoAdapter.notifyItemChanged(index)
//             saveTodos()
//         }
//     }
//     
//     private fun deleteTodo(todo: TodoItem) {
//         AlertDialog.Builder(this)
//             .setTitle("Delete Todo")
//             .setMessage("Are you sure you want to delete this todo?")
//             .setPositiveButton("Delete") { _, _ ->
//                 val index = todos.indexOfFirst { it.id == todo.id }
//                 if (index != -1) {
//                     todos.removeAt(index)
//                     todoAdapter.notifyItemRemoved(index)
//                     saveTodos()
//                 }
//             }
//             .setNegativeButton("Cancel", null)
//             .show()
//     }
//     
//     private fun toggleTodo(todo: TodoItem) {
//         val index = todos.indexOfFirst { it.id == todo.id }
//         if (index != -1) {
//             todos[index] = todo.copy(isCompleted = !todo.isCompleted)
//             todoAdapter.notifyItemChanged(index)
//             saveTodos()
//         }
//     }
//     
//     private fun saveTodos() {
//         val json = Gson().toJson(todos)
//         sharedPreferences.edit().putString("todos", json).apply()
//     }
//     
//     private fun loadTodos() {
//         val json = sharedPreferences.getString("todos", null)
//         if (json != null) {
//             val type = object : TypeToken<List<TodoItem>>() {}.type
//             todos = Gson().fromJson(json, type)
//             if (todos.isNotEmpty()) {
//                 nextId = todos.maxOf { it.id } + 1
//             }
//             todoAdapter.updateTodos(todos)
//         }
//     }
// }

// 10.1.2 Layout files
/*
    - activity_main.xml: Main activity layout with RecyclerView and FAB
    - item_todo.xml: Layout for individual todo items
    - dialog_add_todo.xml: Layout for add/edit todo dialog
*/

//Example:
// // activity_main.xml
// <?xml version="1.0" encoding="utf-8"?>
// <androidx.coordinatorlayout.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
//     xmlns:app="http://schemas.android.com/apk/res-auto"
//     android:layout_width="match_parent"
//     android:layout_height="match_parent">
//     
//     <androidx.recyclerview.widget.RecyclerView
//         android:id="@+id/recyclerView"
//         android:layout_width="match_parent"
//         android:layout_height="match_parent"
//         android:padding="8dp" />
//     
//     <com.google.android.material.floatingactionbutton.FloatingActionButton
//         android:id="@+id/addButton"
//         android:layout_width="wrap_content"
//         android:layout_height="wrap_content"
//         android:layout_gravity="bottom|end"
//         android:layout_margin="16dp"
//         android:src="@android:drawable/ic_input_add"
//         app:tint="@android:color/white" />
//     
// </androidx.coordinatorlayout.widget.CoordinatorLayout>
//
// // item_todo.xml
// <?xml version="1.0" encoding="utf-8"?>
// <androidx.cardview.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
//     xmlns:app="http://schemas.android.com/apk/res-auto"
//     android:layout_width="match_parent"
//     android:layout_height="wrap_content"
//     android:layout_margin="4dp"
//     app:cardCornerRadius="8dp"
//     app:cardElevation="4dp">
//     
//     <LinearLayout
//         android:layout_width="match_parent"
//         android:layout_height="wrap_content"
//         android:orientation="horizontal"
//         android:padding="16dp">
//         
//         <CheckBox
//             android:id="@+id/checkBox"
//             android:layout_width="wrap_content"
//             android:layout_height="wrap_content"
//             android:layout_gravity="center_vertical" />
//         
//         <LinearLayout
//             android:layout_width="0dp"
//             android:layout_height="wrap_content"
//             android:layout_weight="1"
//             android:orientation="vertical">
//             
//             <TextView
//                 android:id="@+id/titleTextView"
//                 android:layout_width="wrap_content"
//                 android:layout_height="wrap_content"
//                 android:textSize="16sp"
//                 android:textStyle="bold" />
//             
//             <TextView
//                 android:id="@+id/descriptionTextView"
//                 android:layout_width="wrap_content"
//                 android:layout_height="wrap_content"
//                 android:textSize="14sp"
//                 android:textColor="@android:color/darker_gray" />
//             
//         </LinearLayout>
//         
//         <Button
//             android:id="@+id/deleteButton"
//             android:layout_width="wrap_content"
//             android:layout_height="wrap_content"
//             android:text="Delete"
//             android:textColor="@android:color/white"
//             android:background="@android:color/holo_red_dark" />
//         
//     </LinearLayout>
//     
// </androidx.cardview.widget.CardView>
//
// // dialog_add_todo.xml
// <?xml version="1.0" encoding="utf-8"?>
// <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
//     android:layout_width="match_parent"
//     android:layout_height="wrap_content"
//     android:orientation="vertical"
//     android:padding="16dp">
//     
//     <EditText
//         android:id="@+id/titleEditText"
//         android:layout_width="match_parent"
//         android:layout_height="wrap_content"
//         android:hint="Title"
//         android:inputType="text" />
//     
//     <EditText
//         android:id="@+id/descriptionEditText"
//         android:layout_width="match_parent"
//         android:layout_height="wrap_content"
//         android:hint="Description"
//         android:inputType="textMultiLine"
//         android:minLines="3" />
//     
// </LinearLayout>

// 10.1.3 Key features implemented
/*
    - CRUD operations (Create, Read, Update, Delete)
    - Data persistence using SharedPreferences
    - RecyclerView for efficient list display
    - Material Design components
    - User-friendly dialogs for input
    - Confirmation dialogs for destructive actions
    - Checkbox functionality for task completion
*/
