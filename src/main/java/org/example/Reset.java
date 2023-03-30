package org.example;

import java.awt.event.WindowStateListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Reset {
    private final Scanner sc;
    public Reset(Scanner sc){
        this.sc = sc;
    }

    public void run() {

        int count = 0;
        ArrayList<WiseSaying> wiseSayings = new ArrayList<WiseSaying>();

        System.out.println("== 명언 앱 ==");
        while (true) {
            String command = sc.nextLine().trim();
            if(command.equals("종료")){
                break;
            } else if (command.equals("등록")) {
                System.out.printf("명언 :");
                String content = sc.nextLine().trim();
                System.out.println("현재를 사랑하라.");
                System.out.println("작가: ");
                String authorName = sc.nextLine().trim();

                int id = count + 1;
                WiseSaying wiseSaying = new WiseSaying(id, content, authorName);
                wiseSayings.add(wiseSaying);
                System.out.printf( "%d번 명언이 등록되었습니다.\n", count);
                count = id;

            } else if (command.equals("목록")) {
                System.out.println("번호/ 작가/ 명언");
                System.out.println("-".repeat(30));

                for (int i = wiseSayings.size() -1; i >= 0; i++){
                    WiseSaying wiseSaying = wiseSayings.get(i);
                    System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getcontent(), wiseSaying.getAuthorName());
                }
                System.out.println("명언 수" + wiseSayings.size());
            }
        }
    }
}



