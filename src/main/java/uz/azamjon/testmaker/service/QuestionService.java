package uz.azamjon.testmaker.service;

import org.springframework.stereotype.Service;
import uz.azamjon.testmaker.model.Answer;
import uz.azamjon.testmaker.model.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QuestionService {

   List<Question> questions = new ArrayList<>();

    {
        //1-savol
        Question q1 = new Question();
        q1.setText("Java dasturlash tili qaysi kompaniya tomonidan yaratilgan?");
        Answer a1 = new Answer("Microsoft", false);
        Answer a2 = new Answer("Sun Microsystems", true);
        Answer a3 = new Answer("Google", false);
        Answer a4 = new Answer("Apple", false);
        q1.setAnswers(List.of(a1, a2, a3, a4));
        questions.add(q1);
        //2-savol
        Question q2 = new Question();
        q2.setText("Java'da kalit so‘zlardan qaysi biri obyekt yaratish uchun ishlatiladi?");
        Answer a5 = new Answer("create", false);
        Answer a6 = new Answer("build", false);
        Answer a7 = new Answer("new", true);
        Answer a8 = new Answer("init", false);
        q2.setAnswers(List.of(a5, a6, a7, a8));
        questions.add(q2);
        //3-savol
        Question q3 = new Question();
        q3.setText("Java'da to‘plamlar (collections) qaysi paketda joylashgan?");
        Answer a9 = new Answer("java.io", false);
        Answer a10 = new Answer("java.sql", false);
        Answer a11 = new Answer("java.util", true);
        Answer a12 = new Answer("java.lang", false);
        q3.setAnswers(List.of(a9, a10, a11, a12));
        questions.add(q3);

        // 4-savol
        Question q4 = new Question();
        q4.setText("Java'da 'int' tipi necha bayt joy egallaydi?");
        Answer a13 = new Answer("2 bayt", false);
        Answer a14 = new Answer("4 bayt", true);
        Answer a15 = new Answer("8 bayt", false);
        Answer a16 = new Answer("1 bayt", false);
        q4.setAnswers(List.of(a13, a14, a15, a16));
        questions.add(q4);

        // 5-savol
        Question q5 = new Question();
        q5.setText("Java'da Exception'larni to‘g‘ri ushlash uchun qaysi konstruktsiya ishlatiladi?");
        Answer a17 = new Answer("try-catch", true);
        Answer a18 = new Answer("do-while", false);
        Answer a19 = new Answer("if-else", false);
        Answer a20 = new Answer("switch-case", false);
        q5.setAnswers(List.of(a17, a18, a19, a20));
        questions.add(q5);

        // 6-savol
        Question q6 = new Question();
        q6.setText("Java dasturida asosiy bajariladigan metod qaysi?");
        Answer a21 = new Answer("start()", false);
        Answer a22 = new Answer("main()", true);
        Answer a23 = new Answer("run()", false);
        Answer a24 = new Answer("execute()", false);
        q6.setAnswers(List.of(a21, a22, a23, a24));
        questions.add(q6);

        // 7-savol
        Question q7 = new Question();
        q7.setText("Java'da meros olish (inheritance) qaysi kalit so‘z orqali amalga oshiriladi?");
        Answer a25 = new Answer("extends", true);
        Answer a26 = new Answer("implements", false);
        Answer a27 = new Answer("inherits", false);
        Answer a28 = new Answer("super", false);
        q7.setAnswers(List.of(a25, a26, a27, a28));
        questions.add(q7);

        // 8-savol
        Question q8 = new Question();
        q8.setText("Java'da interfeyslarni amalga oshirish uchun qaysi kalit so‘z ishlatiladi?");
        Answer a29 = new Answer("extends", false);
        Answer a30 = new Answer("interface", false);
        Answer a31 = new Answer("implements", true);
        Answer a32 = new Answer("override", false);
        q8.setAnswers(List.of(a29, a30, a31, a32));
        questions.add(q8);

        // 9-savol
        Question q9 = new Question();
        q9.setText("Java'da String obyektlari qanday yaratiladi?");
        Answer a33 = new Answer("String s = 'text';", false);
        Answer a34 = new Answer("String s = new String(\"text\");", true);
        Answer a35 = new Answer("String s = text;", false);
        Answer a36 = new Answer("String s = String(text);", false);
        q9.setAnswers(List.of(a33, a34, a35, a36));
        questions.add(q9);

        // 10-savol
        Question q10 = new Question();
        q10.setText("Java'da static kalit so‘zining vazifasi nima?");
        Answer a37 = new Answer("O'zgaruvchi yoki metod obyektga bog‘liq bo‘lishini ta'minlaydi", false);
        Answer a38 = new Answer("O'zgaruvchi yoki metod klass darajasida bo‘lishini ta'minlaydi", true);
        Answer a39 = new Answer("Faqat obyekt ichida ishlaydi", false);
        Answer a40 = new Answer("Faqat metodlar uchun ishlatiladi", false);
        q10.setAnswers(List.of(a37, a38, a39, a40));
        questions.add(q10);

        // 11-savol
        Question q11 = new Question();
        q11.setText("Java'da polymorphism nima?");
        Answer a41 = new Answer("Bir obyektning bir nechta shaklda ishlay olishi", true);
        Answer a42 = new Answer("Faqat bitta obyekt yaratish imkoniyati", false);
        Answer a43 = new Answer("Klasslarni takroran yaratish jarayoni", false);
        Answer a44 = new Answer("O'zgaruvchilarni final qilish", false);
        q11.setAnswers(List.of(a41, a42, a43, a44));
        questions.add(q11);

        // 12-savol
        Question q12 = new Question();
        q12.setText("Java'da konstruktor nima uchun ishlatiladi?");
        Answer a45 = new Answer("Metodlarni chaqirish uchun", false);
        Answer a46 = new Answer("Obyekt yaratishda boshlang‘ich qiymat berish uchun", true);
        Answer a47 = new Answer("Faqat static o‘zgaruvchilarni e’lon qilish uchun", false);
        Answer a48 = new Answer("Jarayonni to‘xtatish uchun", false);
        q12.setAnswers(List.of(a45, a46, a47, a48));
        questions.add(q12);

        // 13-savol
        Question q13 = new Question();
        q13.setText("Java'da ArrayList qaysi paketda joylashgan?");
        Answer a49 = new Answer("java.sql", false);
        Answer a50 = new Answer("java.lang", false);
        Answer a51 = new Answer("java.util", true);
        Answer a52 = new Answer("java.io", false);
        q13.setAnswers(List.of(a49, a50, a51, a52));
        questions.add(q13);

        // 14-savol
        Question q14 = new Question();
        q14.setText("Java'da '==' va '.equals()' farqi nimada?");
        Answer a53 = new Answer("'==' obyektlarni qiymat bo‘yicha solishtiradi, '.equals()' esa xotira manzili bo‘yicha", false);
        Answer a54 = new Answer("'==' xotira manzilini solishtiradi, '.equals()' qiymatlarni solishtiradi", true);
        Answer a55 = new Answer("Ikkalasi ham bir xil ishlaydi", false);
        Answer a56 = new Answer("Faqat String tipida ishlaydi", false);
        q14.setAnswers(List.of(a53, a54, a55, a56));
        questions.add(q14);

        // 15-savol
        Question q15 = new Question();
        q15.setText("Java'da final kalit so‘zining vazifasi nima?");
        Answer a57 = new Answer("Klassni meros qilib bo‘lmaydi", false);
        Answer a58 = new Answer("Metodni override qilib bo‘lmaydi", false);
        Answer a59 = new Answer("O‘zgaruvchini o‘zgartirib bo‘lmaydi", false);
        Answer a60 = new Answer("Yuqoridagilarning hammasi to‘g‘ri", true);
        q15.setAnswers(List.of(a57, a58, a59, a60));
        questions.add(q15);

    }

   public void addQuestion(Question question){
       questions.add(question);
   }

   public List<Question> getQuestions(){
       return questions;
   }

   public List<Question> getRandomQuestions(){
       List<Question> randomQuestions = new ArrayList<>(questions);
       Collections.shuffle(randomQuestions);
       if (randomQuestions.size() > 10) {
           randomQuestions = randomQuestions.subList(0, 10);
       }

      return randomQuestions;
   }
}
