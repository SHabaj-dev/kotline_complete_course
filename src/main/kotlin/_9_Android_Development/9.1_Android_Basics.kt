package _9_Android_Development

// 9.1 Android Basics

// 9.1.1 Android project structure
/*
    - Android projects follow a specific structure for organization.
    - Main components include Activities, Fragments, Services, and Broadcast Receivers.
    - Resources are organized in res/ directory (layouts, strings, images, etc.).
    - AndroidManifest.xml defines app configuration and permissions.
*/

//Example:
// // MainActivity.kt
// class MainActivity : AppCompatActivity() {
//     override fun onCreate(savedInstanceState: Bundle?) {
//         super.onCreate(savedInstanceState)
//         setContentView(R.layout.activity_main)
//         
//         // Initialize UI components
//         val button = findViewById<Button>(R.id.button)
//         button.setOnClickListener {
//             Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show()
//         }
//     }
// }

// 9.1.2 Activities and lifecycle
/*
    - Activities represent a single screen in an Android app.
    - They have a lifecycle with different states (onCreate, onStart, onResume, etc.).
    - Understanding the lifecycle is crucial for proper resource management.
    - Activities can be destroyed and recreated during configuration changes.
*/

//Example:
// class MainActivity : AppCompatActivity() {
//     override fun onCreate(savedInstanceState: Bundle?) {
//         super.onCreate(savedInstanceState)
//         setContentView(R.layout.activity_main)
//         println("onCreate called")
//     }
//     
//     override fun onStart() {
//         super.onStart()
//         println("onStart called")
//     }
//     
//     override fun onResume() {
//         super.onResume()
//         println("onResume called")
//     }
//     
//     override fun onPause() {
//         super.onPause()
//         println("onPause called")
//     }
//     
//     override fun onStop() {
//         super.onStop()
//         println("onStop called")
//     }
//     
//     override fun onDestroy() {
//         super.onDestroy()
//         println("onDestroy called")
//     }
// }

// 9.1.3 Views and ViewGroups
/*
    - Views are the basic building blocks of Android UI.
    - ViewGroups are containers that hold other views.
    - Common views include TextView, Button, EditText, ImageView.
    - Common ViewGroups include LinearLayout, RelativeLayout, ConstraintLayout.
*/

//Example:
// class MainActivity : AppCompatActivity() {
//     override fun onCreate(savedInstanceState: Bundle?) {
//         super.onCreate(savedInstanceState)
//         setContentView(R.layout.activity_main)
//         
//         // Find views by ID
//         val textView = findViewById<TextView>(R.id.textView)
//         val button = findViewById<Button>(R.id.button)
//         val editText = findViewById<EditText>(R.id.editText)
//         
//         // Set up click listener
//         button.setOnClickListener {
//             val text = editText.text.toString()
//             textView.text = "Hello, $text!"
//         }
//     }
// }

// 9.1.4 Layouts
/*
    - Layouts define the structure and appearance of UI elements.
    - LinearLayout arranges views in a single direction (horizontal or vertical).
    - RelativeLayout positions views relative to each other or the parent.
    - ConstraintLayout is the most flexible and performant layout.
*/

//Example:
// // activity_main.xml
// <?xml version="1.0" encoding="utf-8"?>
// <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
//     android:layout_width="match_parent"
//     android:layout_height="match_parent"
//     android:orientation="vertical"
//     android:padding="16dp">
//     
//     <TextView
//         android:id="@+id/textView"
//         android:layout_width="wrap_content"
//         android:layout_height="wrap_content"
//         android:text="Hello World!"
//         android:textSize="18sp" />
//     
//     <EditText
//         android:id="@+id/editText"
//         android:layout_width="match_parent"
//         android:layout_height="wrap_content"
//         android:hint="Enter your name" />
//     
//     <Button
//         android:id="@+id/button"
//         android:layout_width="wrap_content"
//         android:layout_height="wrap_content"
//         android:text="Click Me" />
//     
// </LinearLayout>

// 9.1.5 Intents
/*
    - Intents are used for communication between components.
    - Explicit intents specify the exact component to start.
    - Implicit intents specify an action to be performed.
    - Intents can carry data between activities.
*/

//Example:
// class MainActivity : AppCompatActivity() {
//     override fun onCreate(savedInstanceState: Bundle?) {
//         super.onCreate(savedInstanceState)
//         setContentView(R.layout.activity_main)
//         
//         val button = findViewById<Button>(R.id.button)
//         button.setOnClickListener {
//             // Create explicit intent
//             val intent = Intent(this, SecondActivity::class.java)
//             intent.putExtra("message", "Hello from MainActivity!")
//             startActivity(intent)
//         }
//     }
// }
//
// class SecondActivity : AppCompatActivity() {
//     override fun onCreate(savedInstanceState: Bundle?) {
//         super.onCreate(savedInstanceState)
//         setContentView(R.layout.activity_second)
//         
//         // Get data from intent
//         val message = intent.getStringExtra("message")
//         val textView = findViewById<TextView>(R.id.textView)
//         textView.text = message
//     }
// }

// 9.1.6 SharedPreferences
/*
    - SharedPreferences is used for storing simple key-value pairs.
    - It's suitable for storing user preferences and settings.
    - Data persists across app sessions.
    - Use getSharedPreferences() or getPreferences() to access.
*/

//Example:
// class MainActivity : AppCompatActivity() {
//     private lateinit var sharedPreferences: SharedPreferences
//     
//     override fun onCreate(savedInstanceState: Bundle?) {
//         super.onCreate(savedInstanceState)
//         setContentView(R.layout.activity_main)
//         
//         sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
//         
//         val editText = findViewById<EditText>(R.id.editText)
//         val saveButton = findViewById<Button>(R.id.saveButton)
//         val loadButton = findViewById<Button>(R.id.loadButton)
//         
//         saveButton.setOnClickListener {
//             val text = editText.text.toString()
//             sharedPreferences.edit().putString("saved_text", text).apply()
//             Toast.makeText(this, "Text saved!", Toast.LENGTH_SHORT).show()
//         }
//         
//         loadButton.setOnClickListener {
//             val savedText = sharedPreferences.getString("saved_text", "")
//             editText.setText(savedText)
//         }
//     }
// }

// 9.1.7 RecyclerView
/*
    - RecyclerView is used for displaying large lists of data efficiently.
    - It recycles views to improve performance.
    - Requires an Adapter to provide data and a ViewHolder to hold views.
    - Supports different layout managers (Linear, Grid, Staggered).
*/

//Example:
// // Data class
// data class Item(val title: String, val description: String)
//
// // ViewHolder
// class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//     val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
//     val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
// }
//
// // Adapter
// class ItemAdapter(private val items: List<Item>) : RecyclerView.Adapter<ItemViewHolder>() {
//     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
//         val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
//         return ItemViewHolder(view)
//     }
//     
//     override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//         val item = items[position]
//         holder.titleTextView.text = item.title
//         holder.descriptionTextView.text = item.description
//     }
//     
//     override fun getItemCount(): Int = items.size
// }
//
// // Usage in Activity
// class MainActivity : AppCompatActivity() {
//     override fun onCreate(savedInstanceState: Bundle?) {
//         super.onCreate(savedInstanceState)
//         setContentView(R.layout.activity_main)
//         
//         val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
//         val items = listOf(
//             Item("Item 1", "Description 1"),
//             Item("Item 2", "Description 2"),
//             Item("Item 3", "Description 3")
//         )
//         
//         recyclerView.adapter = ItemAdapter(items)
//         recyclerView.layoutManager = LinearLayoutManager(this)
//     }
// }

// 9.1.8 Fragments
/*
    - Fragments represent a portion of UI in an Activity.
    - They have their own lifecycle and can be reused across activities.
    - Fragments are useful for creating flexible and responsive UIs.
    - Fragment transactions are used to add, remove, or replace fragments.
*/

//Example:
// class MainActivity : AppCompatActivity() {
//     override fun onCreate(savedInstanceState: Bundle?) {
//         super.onCreate(savedInstanceState)
//         setContentView(R.layout.activity_main)
//         
//         if (savedInstanceState == null) {
//             supportFragmentManager.beginTransaction()
//                 .add(R.id.fragmentContainer, MainFragment())
//                 .commit()
//         }
//     }
// }
//
// class MainFragment : Fragment() {
//     override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//         return inflater.inflate(R.layout.fragment_main, container, false)
//     }
//     
//     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//         super.onViewCreated(view, savedInstanceState)
//         
//         val button = view.findViewById<Button>(R.id.button)
//         button.setOnClickListener {
//             // Replace with another fragment
//             parentFragmentManager.beginTransaction()
//                 .replace(R.id.fragmentContainer, SecondFragment())
//                 .addToBackStack(null)
//                 .commit()
//         }
//     }
// }
