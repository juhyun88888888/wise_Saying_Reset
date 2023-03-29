package org.example;

import java.util.Scanner;

public class Reset {
    private final Scanner sc;
    public Reset(Scanner sc){
        this.sc = sc;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");
        int count = 1;
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
                System.out.println(count + "빈 명언이 등록되었습니다.");
                count++;
            }
        }
    }
}



