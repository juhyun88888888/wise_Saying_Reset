package org.example.wiseSaying.controller;

import org.example.wiseSaying.entity.WiseSaying;
import org.example.Container;
import java.util.ArrayList;
import java.util.Scanner;

public class WiseSayingController {
    private final Object lastWiseSayingId;
    Scanner sc;

    int count = 0;
    ArrayList<WiseSaying> wiseSayings = new ArrayList<WiseSaying>();

    public WiseSayingController() {
        this.sc = sc;
        this.lastWiseSayingId = 0;
        wiseSayings = new ArrayList<>();
    }

    public void write() {
        System.out.printf("명언 :");
        String content = Container.getScannner().nextLine().trim(); // 컨테이너에 있는 스캐너 데이터값으로 리턴
        System.out.println("작가: ");
        String authorName = Container.getScannner().nextLine().trim();
        int id = count + 1;

        WiseSaying wiseSaying;
        wiseSaying = new WiseSaying(id, content, authorName);
        wiseSayings.add(wiseSaying);
        System.out.printf( "%d번 명언이 등록되었습니다.\n", count);
        count = id;

    }

    public void list() {

        System.out.println("번호/ 작가/ 명언");
        System.out.println("-".repeat(30));

        for (int i = wiseSayings.size() -1; i >= 0; i--){
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthorName());
        }
        System.out.println("명언 수" + wiseSayings.size());
    }

    public void remove() {
    }
}
