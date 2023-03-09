package com.example.databasekotlin3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

//import kotlin.coroutines.jvm.internal.CompletedContinuation.context
//import kotlinx.coroutines



class ActivityKotlin : AppCompatActivity() {
    //changed
    // references of buttons and other controls on the layout

    lateinit var et_username: EditText
    lateinit var et_password: EditText
    lateinit var btn_login: Button


    lateinit var btn_create_account: Button
    lateinit var btn_delete_account: Button
    lateinit var btn_user_info: Button
    lateinit var btn_class_testing: Button
    lateinit var btn_update_password: Button
    lateinit var btn_update_FTP: Button
    lateinit var btn_delete_tables: Button
    lateinit var btn_history_error_tables: Button
    lateinit var btn_view_history_error_tables: Button
    lateinit var btn_prediction: Button


    override fun onCreate(savedInstanceState: Bundle?) { //starts the application
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //find data in app
        et_username = findViewById(R.id.username)
        et_password = findViewById(R.id.password)
        btn_login = findViewById(R.id.btnLogin)
        btn_create_account = findViewById(R.id.btnCreateAccount)
        btn_delete_account = findViewById(R.id.btnDelete)
        btn_user_info = findViewById(R.id.btnUserInfo)
        btn_class_testing = findViewById(R.id.btnClassTesting)
        btn_update_password = findViewById(R.id.btnUpdatePassword)
        btn_update_FTP = findViewById(R.id.btnUpdateFTP)
        btn_delete_tables = findViewById(R.id.btnDeleteTables)
        btn_history_error_tables = findViewById(R.id.btnHistoryErrorTables)
        btn_view_history_error_tables = findViewById(R.id.btnViewHistoryErrorTables)
        btn_prediction = findViewById(R.id.btnPredictions)


        //Test Data
        val FTP = 1
        val pz_1 = 1
        val pz_2 = 2
        val pz_3 = 3
        val pz_4 = 4
        val pz_5 = 5
        val pz_6 = 6
        val pz_7 = 7
        val time_33 = 1.0
        val interval = 2
        val power = 3
        val total_cal = 4
        val split_pace = 5.0
        val split_power = 6
        val split_cal = 7.0
        val last_split_time = 8.0
        val last_split_dist = 9.0
        val time_35 = 10.0
        val dist = 11.0
        val drive_len = 12.0
        val drive_time = 13.0
        val stroke_rec_time = 14.0
        val stroke_dist = 15.0
        val peak_drive_force = 16.0
        val avg_drive_force = 17.0
        val work_per_stroke = 18.0
        val stroke_count = 19
        val workout_num = "workout1"
        val error = 1
        val avg_power = 2.3

        //testing

        //button listeners for the add and view all buttons
        btn_login.setOnClickListener(View.OnClickListener {
            val db = DatabaseHelper(this@ActivityKotlin) //making reference to database
            val usernameTXT = et_username.getText().toString()
            val passwordTXT = et_password.getText().toString()
            val user_exists = db.user_exists(usernameTXT)
            if (user_exists == true) {
                Toast.makeText(this@ActivityKotlin, "Username in System", Toast.LENGTH_SHORT).show()
                val password_match = passwordTXT == db.getPassword(usernameTXT)
                if (password_match) {
                    Toast.makeText(this@ActivityKotlin, "Password Matched", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(
                        this@ActivityKotlin,
                        "Password Does Not Matched",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(this@ActivityKotlin, "Username not in System", Toast.LENGTH_SHORT)
                    .show()
            }
        })
        btn_create_account.setOnClickListener(View.OnClickListener {
            val user: User
            user = try {
                User(
                    et_username.getText().toString(),
                    et_password.getText().toString(),
                    FTP,
                    pz_1,
                    pz_2,
                    pz_3,
                    pz_4,
                    pz_5,
                    pz_6,
                    pz_7
                ) // Fill in class constructor
                //Toast.makeText(MainActivity.this, user.toString(), Toast.LENGTH_SHORT).show(); //Testing
            } catch (e: Exception) {
                Toast.makeText(this@ActivityKotlin, "Error Creating Account", Toast.LENGTH_SHORT)
                    .show()
                User("error", "error", FTP, pz_1, pz_2, pz_3, pz_4, pz_5, pz_6, pz_7)
            }

            //add User information in table "User_Info"
            val databaseHelper = DatabaseHelper(this@ActivityKotlin) //making reference to database
            val success = databaseHelper.add_account(user)
            if (success == true) {
                Toast.makeText(this@ActivityKotlin, "Account Created", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@ActivityKotlin, "Account is not Created", Toast.LENGTH_SHORT)
                    .show()
            }
        })
        btn_delete_account.setOnClickListener(View.OnClickListener {
            val db = DatabaseHelper(this@ActivityKotlin) //making reference to database
            val usernameTXT = et_username.getText().toString()
            val passwordTXT = et_password.getText().toString()
            val checkdeletedata = db.delete_account(usernameTXT, passwordTXT)
            if (checkdeletedata == true) Toast.makeText(
                this@ActivityKotlin,
                "Account Deleted",
                Toast.LENGTH_SHORT
            ).show() else Toast.makeText(
                this@ActivityKotlin,
                "Account not Deleted ",
                Toast.LENGTH_SHORT
            ).show()
        })
        btn_user_info.setOnClickListener(
            View.OnClickListener
            //Display Information
            {
                val db = DatabaseHelper(this@ActivityKotlin) //making reference to database
                val usernameTXT = et_username.getText().toString()
                val passwordTXT = et_password.getText().toString()

                //Testing db's go getters
                val FTP = db.getFTP(usernameTXT)
                Toast.makeText(this@ActivityKotlin, "FTP: $FTP", Toast.LENGTH_SHORT).show()

                //testing user_info table go getters
                val pz1 = db.getPZ_1(usernameTXT)
                val pz2 = db.getPZ_2(usernameTXT)
                val pz3 = db.getPZ_3(usernameTXT)
                val pz4 = db.getPZ_4(usernameTXT)
                val pz5 = db.getPZ_5(usernameTXT)
                val pz6 = db.getPZ_6(usernameTXT)
                val pz7 = db.getPZ_7(usernameTXT)
                Toast.makeText(
                    this@ActivityKotlin,
                    "pz: $pz1 $pz2 $pz3 $pz4 $pz5 $pz6 $pz7",
                    Toast.LENGTH_SHORT
                ).show()

                //testing dataframe33_info table go getters
                //int interval = db.getInterval();
                val time33 = db.time_33
                val interval = db.interval
                val power = db.power
                val total_cal = db.total_cal
                val split_pace = db.split_pace
                val split_power = db.split_power
                val split_cal = db.split_cal
                val last_split_time = db.last_split_time
                val last_split_dist = db.last_split_dist
                Toast.makeText(
                    this@ActivityKotlin,
                    "dataframe33: $time33 $interval $power $total_cal $split_pace $split_power $split_cal $last_split_time $last_split_dist",
                    Toast.LENGTH_SHORT
                ).show()

                //testing dataframe35_info table go getters
                val time35 = db.time_35
                val dist = db.dist
                val drive_len = db.drive_len
                val drive_time = db.drive_time
                val stroke_dist = db.stroke_dist
                val peak_drive_force = db.peak_drive_force
                val avg_drive_force = db.avg_drive_force
                val work_per_stroke = db.work_per_stroke
                val stroke_count = db.stroke_count
                Toast.makeText(
                    this@ActivityKotlin,
                    "dataframe35: $time35 $dist $drive_len $drive_time $stroke_dist $peak_drive_force $avg_drive_force $work_per_stroke $stroke_count",
                    Toast.LENGTH_SHORT
                ).show()
            })
        btn_class_testing.setOnClickListener(View.OnClickListener {
            //Testing User class
            val user = User(
                et_username.getText().toString(),
                et_password.getText().toString(),
                FTP,
                pz_1,
                pz_2,
                pz_3,
                pz_4,
                pz_5,
                pz_6,
                pz_7
            ) // Fill in class constructor
            Toast.makeText(this@ActivityKotlin, user.toString(), Toast.LENGTH_SHORT).show()


            //Testing Real Time data classes
            val databaseHelper = DatabaseHelper(this@ActivityKotlin) //making reference to database

            //Testing dataframe33
            val realdata1 = data33(
                time_33,
                interval,
                power,
                total_cal,
                split_pace,
                split_power,
                split_cal,
                last_split_time,
                last_split_dist
            )
            Toast.makeText(this@ActivityKotlin, realdata1.toString(), Toast.LENGTH_SHORT)
                .show() //Testing
            val success1 = databaseHelper.add_dataframe33(realdata1)
            if (success1 == true) {
                Toast.makeText(this@ActivityKotlin, "Successfully entered table", Toast.LENGTH_SHORT)
                    .show() //Testing
            } else {
                Toast.makeText(this@ActivityKotlin, "Did not enter table", Toast.LENGTH_SHORT)
                    .show() //Testing
            }


            //Testing dataframe35
            val realdata2 = data35(
                time_35,
                dist,
                drive_len,
                drive_time,
                stroke_rec_time,
                stroke_dist,
                peak_drive_force,
                avg_drive_force,
                work_per_stroke,
                stroke_count
            )
            Toast.makeText(this@ActivityKotlin, realdata2.toString(), Toast.LENGTH_SHORT)
                .show() //Testing
            val success2 = databaseHelper.add_dataframe35(realdata2)
            if (success2 == true) {
                Toast.makeText(this@ActivityKotlin, "Successfully entered table", Toast.LENGTH_SHORT)
                    .show() //Testing
            } else {
                Toast.makeText(this@ActivityKotlin, "Did not enter table", Toast.LENGTH_SHORT)
                    .show() //Testing
            }
        })
        btn_update_password.setOnClickListener(View.OnClickListener {
            val db = DatabaseHelper(this@ActivityKotlin) //making reference to database
            val usernameTXT = et_username.getText().toString()
            val passwordTXT = et_password.getText().toString()

            //Testing update password
            val success = db.updateuserPassword(et_username.getText().toString(), passwordTXT)
            if (success == true) {
                Toast.makeText(this@ActivityKotlin, "Password Updated", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@ActivityKotlin, "Password is not Updated", Toast.LENGTH_SHORT)
                    .show()
            }
        })
        btn_update_FTP.setOnClickListener(View.OnClickListener {
            val db = DatabaseHelper(this@ActivityKotlin) //making reference to database
            val usernameTXT = et_username.getText().toString()
            val passwordTXT = et_password.getText().toString()

            //Testing Updating FTP
            val success2 =
                db.updateuserFTP(et_username.getText().toString(), 8, 9, 10, 11, 12, 13, 14, 15)
            if (success2 == true) {
                Toast.makeText(this@ActivityKotlin, "FTP Updated", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@ActivityKotlin, "FTP is not Updated", Toast.LENGTH_SHORT).show()
            }
        })
        btn_delete_tables.setOnClickListener(View.OnClickListener {
            val db = DatabaseHelper(this@ActivityKotlin) //making reference to database
            val success1 = db.delete_dataframe33_table()
            Toast.makeText(this@ActivityKotlin, "dataframe33 table Deleted", Toast.LENGTH_SHORT)
                .show()
            val success2 = db.delete_dataframe35_table()
            Toast.makeText(this@ActivityKotlin, "dataframe35 table Deleted", Toast.LENGTH_SHORT)
                .show()
        })


        btn_history_error_tables.setOnClickListener(View.OnClickListener {
            val db = DatabaseHelper(this@ActivityKotlin) //making reference to database
            val usernameTXT = et_username.text.toString()
            val passwordTXT = et_password.text.toString()

            //Testing adding to history table
            val success1 = db.add_history(usernameTXT, workout_num, error, avg_power)
            if (success1 == true) {
                Toast.makeText(
                    this@ActivityKotlin,
                    "workout added to history table",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this@ActivityKotlin,
                    "workout not added to history table",
                    Toast.LENGTH_SHORT
                ).show()
            }

            //Adding multiple workouts at once

            //Testing adding to history table
            val success2 = db.add_history(usernameTXT, "workout_1", error, avg_power)
            if (success2 == true) {
                Toast.makeText(
                    this@ActivityKotlin,
                    "workout added to history table",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this@ActivityKotlin,
                    "workout not added to history table",
                    Toast.LENGTH_SHORT
                ).show()
            }

            //Testing adding to history table
            val success3 = db.add_history(usernameTXT, "workout_2", error, avg_power)
            if (success3 == true) {
                Toast.makeText(
                    this@ActivityKotlin,
                    "workout added to history table",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this@ActivityKotlin,
                    "workout not added to history table",
                    Toast.LENGTH_SHORT
                ).show()
            }

            //Testing adding to history table
            val success4 = db.add_history(usernameTXT, "workout_1", error, avg_power)
            if (success4 == true) {
                Toast.makeText(
                    this@ActivityKotlin,
                    "workout added to history table",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this@ActivityKotlin,
                    "workout not added to history table",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })





        btn_prediction.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(view: View) {
                    val db = DatabaseHelper(this@ActivityKotlin) //making reference to database
                    val usernameTXT: String = et_username.getText().toString()
                    val workout_type = "workout_1"
                    val allPower: ArrayList<Double> = db.getAllPower(usernameTXT, workout_type) as ArrayList<Double>
                    //Toast.makeText(MainActivity.this, allPower, Toast.LENGTH_SHORT).show();
                    val buffer = StringBuffer()
                    for (i in allPower.indices) {
                        buffer.append(allPower[i].toString() + ' ')
                    }
                    val builder = AlertDialog.Builder(this@ActivityKotlin)
                    builder.setCancelable(true)
                    builder.setTitle(usernameTXT + "Past Power")
                    builder.setMessage(buffer.toString())
                    builder.show()
                }
            })



    }
}