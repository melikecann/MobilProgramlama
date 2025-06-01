package com.example.flagquizapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "quiz.db";
    private static final int DATABASE_VERSION = 4; // Versiyon arttırılmış

    public QuizDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS questions (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "category TEXT," +
                "question TEXT," +
                "option1 TEXT," +
                "option2 TEXT," +
                "option3 TEXT," +
                "option4 TEXT," +
                "answer TEXT," +
                "image TEXT)");

        // General Knowledge
        db.execSQL("INSERT INTO questions (category, question, option1, option2, option3, option4, answer) VALUES " +
                "('general_knowledge', 'Türkiye’nin başkenti neresidir?', 'İstanbul', 'Ankara', 'İzmir', 'Bursa', 'Ankara')," +
                "('general_knowledge', 'En büyük okyanus hangisidir?', 'Hint Okyanusu', 'Atlas Okyanusu', 'Arktik Okyanus', 'Pasifik Okyanusu', 'Pasifik Okyanusu')," +
                "('general_knowledge', 'İnsan vücudunda kaç kemik vardır?', '206', '201', '196', '210', '206')," +
                "('general_knowledge', 'Einstein’ın ünlü denklemi nedir?', 'E=mc²', 'F=ma', 'V=IR', 'P=VI', 'E=mc²')," +
                "('general_knowledge', 'Hangi gezegen Güneş’e en yakındır?', 'Venüs', 'Dünya', 'Merkür', 'Mars', 'Merkür')," +
                "('general_knowledge', 'Dünyanın en yüksek dağı hangisidir?', 'Everest', 'K2', 'Ararat', 'Alpler', 'Everest')," +
                "('general_knowledge', 'DNA’nın açılımı nedir?', 'Deoksiribonükleik Asit', 'Ribonükleik Asit', 'Nükleer Asit', 'Protein Zinciri', 'Deoksiribonükleik Asit')," +
                "('general_knowledge', 'Bir haftada kaç gün vardır?', '5', '6', '7', '8', '7')," +
                "('general_knowledge', 'Dünya Kupası’nı en çok kazanan ülke?', 'Brezilya', 'Almanya', 'Arjantin', 'Fransa', 'Brezilya')," +
                "('general_knowledge', 'Leonardo da Vinci’nin en ünlü tablosu hangisidir?', 'Çığlık', 'Gece Devriyesi', 'Mona Lisa', 'Yıldızlı Gece', 'Mona Lisa')");

        // Capitals
        db.execSQL("INSERT INTO questions (category, question, option1, option2, option3, option4, answer) VALUES " +
                "('capitals', 'Fransa’nın başkenti neresidir?', 'Berlin', 'Madrid', 'Paris', 'Roma', 'Paris')," +
                "('capitals', 'Japonya’nın başkenti neresidir?', 'Kyoto', 'Osaka', 'Tokyo', 'Hiroşima', 'Tokyo')," +
                "('capitals', 'Kanada’nın başkenti neresidir?', 'Toronto', 'Montreal', 'Vancouver', 'Ottawa', 'Ottawa')," +
                "('capitals', 'İtalya’nın başkenti neresidir?', 'Roma', 'Napoli', 'Milano', 'Floransa', 'Roma')," +
                "('capitals', 'Avustralya’nın başkenti neresidir?', 'Melbourne', 'Sidney', 'Canberra', 'Adelaide', 'Canberra')," +
                "('capitals', 'Mısır’ın başkenti neresidir?', 'Kahire', 'İskenderiye', 'Luksor', 'Asvan', 'Kahire')," +
                "('capitals', 'Brezilya’nın başkenti neresidir?', 'Rio de Janeiro', 'São Paulo', 'Brasília', 'Salvador', 'Brasília')," +
                "('capitals', 'Almanya’nın başkenti neresidir?', 'Berlin', 'Frankfurt', 'Hamburg', 'Stuttgart', 'Berlin')," +
                "('capitals', 'Hindistan’ın başkenti neresidir?', 'Mumbai', 'Yeni Delhi', 'Kalküta', 'Haydarabad', 'Yeni Delhi')," +
                "('capitals', 'İngiltere’nin başkenti neresidir?', 'Londra', 'Manchester', 'Liverpool', 'Oxford', 'Londra')");

        // Flags (1 Bayrak 4 Ülke - bayrak sorusu olarak varsayılmış)
        db.execSQL("INSERT INTO questions (category, question, option1, option2, option3, option4, answer, image) VALUES " +
                "('flags_1bayrak4ulke', 'Bu bayrak hangi ülkeye aittir? 🇯🇵', 'Japonya', 'Çin', 'Güney Kore', 'Tayland', 'Japonya', 'japan_flag')," +
                "('flags_1bayrak4ulke', 'Bu bayrak hangi ülkeye aittir? 🇫🇷', 'İtalya', 'Fransa', 'Hollanda', 'Yunanistan', 'Fransa', 'france_flag')," +
                "('flags_1bayrak4ulke', 'Bu bayrak hangi ülkeye aittir? 🇧🇷', 'Arjantin', 'Meksika', 'Brezilya', 'Peru', 'Brezilya', 'brazil_flag')," +
                "('flags_1bayrak4ulke', 'Bu bayrak hangi ülkeye aittir? 🇨🇦', 'ABD', 'Avustralya', 'Kanada', 'Yeni Zelanda', 'Kanada', 'canada_flag')," +
                "('flags_1bayrak4ulke', 'Bu bayrak hangi ülkeye aittir? 🇹🇷', 'Pakistan', 'Türkiye', 'Irak', 'İran', 'Türkiye', 'turkiye_flag')," +
                "('flags_1bayrak4ulke', 'Bu bayrak hangi ülkeye aittir? 🇧🇪', 'Kanada', 'İngiltere', 'Belçika', 'Meksika', 'Belçika', 'belgium_flag')," +
                "('flags_1bayrak4ulke', 'Bu bayrak hangi ülkeye aittir? 🇩🇪', 'Fransa', 'Belçika', 'Almanya', 'Avusturya', 'Almanya', 'germany_flag')," +
                "('flags_1bayrak4ulke', 'Bu bayrak hangi ülkeye aittir? 🇮🇳', 'Nepal', 'Pakistan', 'Hindistan', 'Bangladeş', 'Hindistan', 'india_flag')," +
                "('flags_1bayrak4ulke', 'Bu bayrak hangi ülkeye aittir? 🇮🇹', 'İspanya', 'İtalya', 'Yunanistan', 'Fransa', 'İtalya', 'italy_flag')," +
                "('flags_1bayrak4ulke', 'Bu bayrak hangi ülkeye aittir? 🇬🇧', 'İngiltere', 'İskoçya', 'İrlanda', 'Galler', 'İngiltere', 'unitedkingdom_flag')");

        // Map Quiz
        db.execSQL("INSERT INTO questions (category, question, option1, option2, option3, option4, answer) VALUES " +
                "('map_quiz', 'Türkiye hangi kıtada yer alır?', 'Asya', 'Avrupa', 'Her ikisi', 'Afrika', 'Her ikisi')," +
                "('map_quiz', 'Mısır hangi kıtadadır?', 'Asya', 'Afrika', 'Avrupa', 'Güney Amerika', 'Afrika')," +
                "('map_quiz', 'Avustralya’nın en büyük şehri hangisidir?', 'Melbourne', 'Sidney', 'Perth', 'Adelaide', 'Sidney')," +
                "('map_quiz', 'Atlas Okyanusu hangi iki kıta arasında bulunur?', 'Avrupa - Asya', 'Afrika - Güney Amerika', 'Avrupa - Amerika', 'Asya - Avustralya', 'Avrupa - Amerika')," +
                "('map_quiz', 'İsviçre hangi ülkelerle sınır komşusudur?', 'Fransa, İtalya, Almanya, Avusturya', 'Fransa, İspanya, Almanya', 'Almanya, Polonya, Macaristan', 'İtalya, Yunanistan, Türkiye', 'Fransa, İtalya, Almanya, Avusturya')," +
                "('map_quiz', 'Rusya hangi iki kıtada yer alır?', 'Asya ve Avrupa', 'Asya ve Afrika', 'Avrupa ve Amerika', 'Asya ve Avustralya', 'Asya ve Avrupa')," +
                "('map_quiz', 'Amerika Birleşik Devletleri kaç eyaletten oluşur?', '50', '48', '52', '45', '50')," +
                "('map_quiz', 'Dünyanın en büyük çölü hangisidir?', 'Gobi', 'Sahra', 'Atakama', 'Kalahari', 'Sahra')," +
                "('map_quiz', 'İstanbul hangi iki kıta arasında yer alır?', 'Asya - Avrupa', 'Avrupa - Afrika', 'Asya - Afrika', 'Avrupa - Avustralya', 'Asya - Avrupa')," +
                "('map_quiz', 'Nil Nehri hangi kıtadadır?', 'Asya', 'Afrika', 'Avrupa', 'Amerika', 'Afrika')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS questions");
        onCreate(db);
    }

    public List<Question> getQuestionsByCategory(String category) {
            List<Question> questionList = new ArrayList<>();
            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.rawQuery("SELECT * FROM questions WHERE category = ?", new String[]{category});

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    try {
                        String questionText = cursor.getString(cursor.getColumnIndexOrThrow("question"));
                        String option1 = cursor.getString(cursor.getColumnIndexOrThrow("option1"));
                        String option2 = cursor.getString(cursor.getColumnIndexOrThrow("option2"));
                        String option3 = cursor.getString(cursor.getColumnIndexOrThrow("option3"));
                        String option4 = cursor.getString(cursor.getColumnIndexOrThrow("option4"));
                        String answer = cursor.getString(cursor.getColumnIndexOrThrow("answer"));
                        String image = cursor.getString(cursor.getColumnIndexOrThrow("image"));

                        List<String> options = Arrays.asList(option1, option2, option3, option4);
                        questionList.add(new Question(questionText, options, answer, image));
                    } catch (Exception e) {
                        Log.e("QuizDatabaseHelper", "Hata oluştu: " + e.getMessage());
                    }
                } while (cursor.moveToNext());

                cursor.close();
            }

            db.close();
            return questionList;
        }

    }
