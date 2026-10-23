package com.adkar.salah;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private LinearLayout list;
    private int green = Color.rgb(20, 92, 68);
    private int cream = Color.rgb(244, 248, 244);
    private int gold = Color.rgb(200, 163, 89);

    private String[] titles = {
        "الاستغفار",
        "دعاء بعد السلام",
        "الذكر بعد الصلاة",
        "التسبيح",
        "التحميد",
        "التكبير",
        "خاتمة التسبيح",
        "آية الكرسي",
        "سورة الإخلاص",
        "سورة الفلق",
        "سورة الناس",
        "دعاء الاستعانة على العبادة"
    };

    private String[] texts = {
        "أَسْتَغْفِرُ اللَّهَ",
        "أَسْتَغْفِرُ اللَّهَ",
        "أَسْتَغْفِرُ اللَّهَ",

        "اللَّهُمَّ أَنْتَ السَّلَامُ وَمِنْكَ السَّلَامُ، تَبَارَكْتَ يَا ذَا الْجَلَالِ وَالْإِكْرَامِ.",

        "لَا إِلَهَ إِلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ.",

        "اللَّهُمَّ لَا مَانِعَ لِمَا أَعْطَيْتَ، وَلَا مُعْطِيَ لِمَا مَنَعْتَ، وَلَا يَنْفَعُ ذَا الْجَدِّ مِنْكَ الْجَدُّ.",

        "سُبْحَانَ اللَّهِ",

        "الْحَمْدُ لِلَّهِ",

        "اللَّهُ أَكْبَرُ",

        "لَا إِلَهَ إِلَّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ.",

        "آية الكرسي: اللَّهُ لَا إِلَٰهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومُ، لَا تَأْخُذُهُ سِنَةٌ وَلَا نَوْمٌ، لَهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ، مَنْ ذَا الَّذِي يَشْفَعُ عِنْدَهُ إِلَّا بِإِذْنِهِ، يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ، وَلَا يُحِيطُونَ بِشَيْءٍ مِنْ عِلْمِهِ إِلَّا بِمَا شَاءَ، وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالْأَرْضَ، وَلَا يَئُودُهُ حِفْظُهُمَا، وَهُوَ الْعَلِيُّ الْعَظِيمُ.",

        "قُلْ هُوَ اللَّهُ أَحَدٌ ۝ اللَّهُ الصَّمَدُ ۝ لَمْ يَلِدْ وَلَمْ يُولَدْ ۝ وَلَمْ يَكُنْ لَهُ كُفُوًا أَحَدٌ.",

        "قُلْ أَعُوذُ بِرَبِّ الْفَلَقِ ۝ مِنْ شَرِّ مَا خَلَقَ ۝ وَمِنْ شَرِّ غَاسِقٍ إِذَا وَقَبَ ۝ وَمِنْ شَرِّ النَّفَّاثَاتِ فِي الْعُقَدِ ۝ وَمِنْ شَرِّ حَاسِدٍ إِذَا حَسَدَ.",

        "قُلْ أَعُوذُ بِرَبِّ النَّاسِ ۝ مَلِكِ النَّاسِ ۝ إِلَٰهِ النَّاسِ ۝ مِنْ شَرِّ الْوَسْوَاسِ الْخَنَّاسِ ۝ الَّذِي يُوَسْوِسُ فِي صُدُورِ النَّاسِ ۝ مِنَ الْجِنَّةِ وَالنَّاسِ.",

        "اللَّهُمَّ أَعِنِّي عَلَى ذِكْرِكَ وَشُكْرِكَ وَحُسْنِ عِبَادَتِكَ."
    };

    private int[] goals = {
        3, 1, 1, 1, 1, 1, 33, 33, 33, 1, 1, 1
    };

    private int[] counts = new int[texts.length];
    private TextView[] countViews = new TextView[texts.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showAdhkar();
    }

    private GradientDrawable shape(int color, int radius) {
        GradientDrawable d = new GradientDrawable();
        d.setColor(color);
        d.setCornerRadius(radius);
        return d;
    }

    private TextView text(String value, int size, int color) {
        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);
        t.setGravity(Gravity.CENTER);
        t.setPadding(14, 12, 14, 12);
        t.setTypeface(Typeface.create("sans-serif", Typeface.NORMAL));
        return t;
    }

    private void showAdhkar() {
        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);
        scroll.setBackgroundColor(cream);

        list = new LinearLayout(this);
        list.setOrientation(LinearLayout.VERTICAL);
        list.setPadding(14, 18, 14, 24);

        TextView header = text("أذكار ما بعد الصلاة", 27, Color.WHITE);
        header.setTypeface(null, Typeface.BOLD);
        header.setBackground(shape(green, 22));
        list.addView(header);

        TextView subtitle = text(
            "أذكار مكتوبة تقرؤها بعد الصلاة المفروضة",
            17, green
        );
        list.addView(subtitle);

        TextView reset = text("إعادة ضبط العدّادات", 17, Color.WHITE);
        reset.setBackground(shape(green, 16));

        LinearLayout.LayoutParams resetParams =
            new LinearLayout.LayoutParams(-1, -2);
        resetParams.setMargins(0, 8, 0, 14);
        list.addView(reset, resetParams);

        reset.setOnClickListener(v -> {
            for (int i = 0; i < counts.length; i++) {
                counts[i] = 0;
                updateCount(i);
            }
        });

        for (int i = 0; i < texts.length; i++) {
            final int index = i;

            LinearLayout card = new LinearLayout(this);
            card.setOrientation(LinearLayout.VERTICAL);
            card.setPadding(12, 12, 12, 12);
            card.setBackground(shape(Color.WHITE, 18));

            LinearLayout.LayoutParams cardParams =
                new LinearLayout.LayoutParams(-1, -2);
            cardParams.setMargins(0, 7, 0, 7);

            TextView title = text(
                titles[i], 19, green
            );
            title.setTypeface(null, Typeface.BOLD);
            card.addView(title);

            TextView body = text(
                texts[i], 22, Color.rgb(40, 48, 42)
            );
            body.setGravity(Gravity.CENTER);
            body.setLineSpacing(8, 1.15f);
            card.addView(body);

            TextView target = text(
                "عدد التكرارات المقترح: " + goals[i], 15, green
            );
            card.addView(target);

            countViews[i] = text(
                "تم التسبيح: 0", 17, green
            );
            card.addView(countViews[i]);

            TextView countButton = text(
                "اضغط للتسجيل", 18, Color.WHITE
            );
            countButton.setBackground(shape(green, 14));
            card.addView(countButton);

            countButton.setOnClickListener(v -> {
                counts[index]++;
                updateCount(index);
            });

            list.addView(card, cardParams);
        }

        scroll.addView(list);
        setContentView(scroll);
    }

    private void updateCount(int index) {
        if (countViews[index] != null) {
            countViews[index].setText(
                "تم التسبيح: " + counts[index] +
                " من " + goals[index]
            );
        }
    }
}