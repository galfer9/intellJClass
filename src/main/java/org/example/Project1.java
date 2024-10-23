package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Project1 {
    public static void main(String[] args) {
        /* 네이버 스포츠 해외축구 크롤링 */
        String url = "https://sports.news.naver.com/wfootball/index";
        Document doc = null; //html문서                //pom.xml에 추가한 jsoup 문서파서라이브러리의 Document 임포트 할 것

        try {
            doc = Jsoup.connect(url).get();  //예외처리 미루지 말고 바로 예외처리
        } catch (IOException e) {
            e.printStackTrace();

        }
        //System.out.println(doc);
        Elements elements = doc.select("div.home_news");
        //제목글자만 가져오기
        String title = elements.select("h2").text();  //쿼리셀렉터로 h2의 text 가져오라
        System.out.println("=========================================");
        System.out.println(title);
        System.out.println("=========================================");
        //모든 리스트의 li 내용을 출력
        for (Element el : elements.select("li")) {   //근데 45자이상은 줄이자 너무길다.
            if (el.text().length() >= 50) {
                System.out.println(el.text().substring(0, 50) + "...");
            } else {
                System.out.println(el.text());
            }
        }
        System.out.println("==================================================");
    }

}
