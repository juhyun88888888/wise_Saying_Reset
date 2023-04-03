package org.example;

import org.example.System.controller.Systemcontroller;
import org.example.wiseSaying.controller.WiseSayingController;

public class App {

    public void run() {
        Systemcontroller systemController = new Systemcontroller(); //등록할지 종료할지를 만드는 컨드롤러
        WiseSayingController wiseSayingController = new WiseSayingController(); //작동시키는 컨트롤러

        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.printf("명령)");
            String command = Container.getScannner().nextLine().trim(); //컨테이너 안에 있는 스캐너 가져옴
            //nextLine()쓰는 이유> 엔터치기 전까지 쓴 모든 문자열을 리턴하기 때문
            //next()> 공백을 기준으로 문자, 문자열 입력받음
            //trim > 종료 구문 넣을때 스페이스 공백 없애줄려고 씀
            //구문 해석> String 문장 ~을 한다. = Container 의 get.Scanner()의 문자, 문자열을 실행 할텐데, 공백을 없애줘라
            //command 패턴 예시 > 난 너를 사랑해 라는 구문이 있다면 command를 쓸때 (난 너를 사랑함)을 한다.
            Rq rq = new Rq(command);
            rq.getActionCode();
            rq.getParams("id");

            switch (rq.getActionCode()) { //if문이 3개 이상 넘어갈경우 swich문 사용
                case "종료":
                    systemController.exit(); //종료를 입력할때 실행될 구문
                    return; //swich문 자체에서 완전한 탈출시키는것은 retrun
                case "등록":
                    wiseSayingController.write();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.remove(rq);
                    break;
                case "수정":
                    wiseSayingController.modify(rq);
                    break;
            }
        }
    }
}


