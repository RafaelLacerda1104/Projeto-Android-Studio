package com.example.p2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "Usuarios.db"
        private const val DATABASE_VERSION = 1

        private const val TABLE_NAME = "usuarios"
        private const val COLUMN_ID = "id"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_SENHA = "senha"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_EMAIL TEXT UNIQUE,
                $COLUMN_SENHA TEXT
            )
        """.trimIndent()
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun inserirUsuario(email: String, senha: String): Long {
        val values = ContentValues().apply {
            put(COLUMN_EMAIL, email)
            put(COLUMN_SENHA, senha)
        }
        val db = writableDatabase
        return db.insert(TABLE_NAME, null, values)
    }

    fun verificarUsuario(email: String, senha: String): Boolean {
        return try {
            val db = readableDatabase
            val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_EMAIL = ? AND $COLUMN_SENHA = ?"
            val cursor = db.rawQuery(query, arrayOf(email, senha))
            val existe = cursor.count > 0
            cursor.close()
            existe
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
}
