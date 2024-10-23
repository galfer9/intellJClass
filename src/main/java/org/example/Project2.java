package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;

public class Project2 {
    public static void main(String[] args) {
        /* cgv 영화순위 */
        String url = "http://www.cgv.co.kr/movies/";
        Document doc = null;

        try {
            doc = Jsoup.connect(url).get(); //웹주소에 해당하는 문서를 받아온다.
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements elements = doc.select("div.sect-movie-chart");
        System.out.println(elements);
        System.out.println("===============================================================");

        //Iterator 를 사용해서 가져오기
        Iterator<Element> el1 = elements.select("strong.rank").iterator();
        Iterator<Element> el2 = elements.select("strong.title").iterator();

        while (el1.hasNext() && el2.hasNext()) { //hasNext()는 elements가 있는한 계속 루프돔(Iterator는 hasNext매소드 써서 while문 쓰게끔 만들어져있음. for는 안됨.
            System.out.println(el1.next().text() + "\t\t\t" + el2.next().text()); //next()매소드는 그 전거 출력하고 다음것으로 넘어가서 출력함        }

            System.out.println("=========================================================");
        }
    }
}
