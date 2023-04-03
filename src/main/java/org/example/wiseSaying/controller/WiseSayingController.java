package org.example.wiseSaying.controller;

import org.example.Rq;
import org.example.wiseSaying.entity.WiseSaying;
import org.example.Container;

import javax.xml.namespace.QName;
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
        System.out.printf("%d번 명언이 등록되었습니다.\n", count);
        count = id;

    }

    public void list() {

        System.out.println("번호/ 작가/ 명언");
        System.out.println("-".repeat(30));

        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthorName());
        }
        System.out.println("명언 수" + wiseSayings.size());
    }

    public void remove(Rq rq) {
        int id = rq.getIntParams("id", -1);

        if (id == -1) {
            System.out.println("정수를 입력하세요.");
            return;
        }

        WiseSaying wiseSaying = findByid(id); // id 값으로 지정된 데이터를 가져온다.

        if (wiseSaying == null) {
            System.out.printf("삭제될 명언이 없습니다.");
        }

        wiseSayings.remove(wiseSaying);  // 저장된 데이터로 전체데이터에서 삭제하는 메서드를 이용해서 삭제
        System.out.printf("%d 명언이 삭제되었습니다.",id);

        /*int id = -1;
        try {
            id = Integer.parseInt(rq.getParams("id"));
            System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
            //id값이 정수 혹은 스트링인지 판별하는 예외문
        } catch (NumberFormatException e) {
            System.out.println("정수를 입력해주세요.");
            return;
        }
        */
        System.out.printf("%d번 명령이 삭제되었습니다.\n", id);
    }

    private WiseSaying findByid(int id) {
        for (WiseSaying wiseSaying : wiseSayings) { //같은 레벨에 있기 때문에 wiseSaying에 접근 가능
            if (wiseSaying.getId() == id) { // wiseSaying이라는 객체의 getId() 메소드를 호출하여 반환된 값이 id와 같은지를 검사하고, 만약 같으면 wiseSaying 객체를 반환하는 코드
                return wiseSaying;
            }
        }
        return null;
    }

    public void modify(Rq rq) {
        int id = rq.getIntParams("id", -1);

        if (id == -1) {
            System.out.println("정수를 입력하세요.");
            return;
        }

        WiseSaying wiseSaying = findByid(id); // id 값으로 지정된 데이터를 가져온다.

        if (wiseSaying == null) {
            System.out.printf("수정할 명언이 없습니다.");
        }
        System.out.printf("기존 명언 %s", wiseSaying.getContent());
        System.out.printf("수정할 명언)");

        String authorName = Container.getScannner().nextLine().trim();
        System.out.printf("기존 작가 %s", wiseSaying.getAuthorName());
        System.out.printf("수정할 작가이름)");

        String content = null;
        wiseSaying.setContent(content);
        wiseSaying.setAuthorName(authorName);
        System.out.printf("%d번 명언이 수정되었습니다.\n", id);
    }
}
