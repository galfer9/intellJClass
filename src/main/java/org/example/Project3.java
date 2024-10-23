package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

public class Project3 {
    public static void main(String[] args) {
        String input;
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();


        /* 네이버 증권 */
        String url = "https://finance.naver.com/item/main.naver?code=005930";
        Document doc = null;

        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //종목정보
        Elements todaylist = doc.select(".new_totalinfo dl>dd");   //.은 클래스.  >은 리스트에서 하위

        String time = todaylist.get(0).text();
        String name = todaylist.get(1).text().split(" ")[1]; //종목명 빼고 이름만 나오게끔 split(한칸빼기) 씀
        String juga = todaylist.get(3).text().split(" ")[1]; //현재 주가
        String dungRakrate = todaylist.get(3).text().split(" ")[6]; //퍼센트 등락률
        String siga = todaylist.get(5).text().split(" ")[1]; //시가
        String goga = todaylist.get(6).text().split(" ")[1]; //고가
        String zeoga = todaylist.get(8).text().split(" ")[1]; //저가
        String georaeryyang = todaylist.get(10).text().split(" ")[1]; //거래량
        String stype = todaylist.get(3).text().split(" ")[3]; //상한가, 상승,보합,하한가,하락 구분
        String vsYesterday = todaylist.get(3).text().split(" ")[4]; //어제가격비교 차이

        System.out.printf("===================%s========================\n",name); //종목명
        System.out.println("시간:" + time);
        System.out.println("주가:" + juga);
        System.out.println("등락률:" + dungRakrate + "%");
        System.out.println("시가:" + siga);
        System.out.println("고가:" + goga);
        System.out.println("저가:" + zeoga);
        System.out.println("거래량:" +  georaeryyang);
        System.out.println("타입:" + stype);
        System.out.println("전일대비:" + vsYesterday);
        System.out.println("가져오는시간:" + time);

    }
}
