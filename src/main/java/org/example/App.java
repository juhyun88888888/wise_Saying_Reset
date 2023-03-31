package org.example;
import org.example.System.controller.Systemcontroller;
import org.example.wiseSaying.controller.WiseSayingController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    public void run() {
        Systemcontroller systemController = new Systemcontroller(); //등록할지 종료할지를 만드는 컨드롤러
        WiseSayingController wiseSayingController = new WiseSayingController(); //작동시키는 컨트롤러

        System.out.println("== 명언 앱 ==");
        while (true) {
            String command = Container.getScannner().nextLine().trim(); //컨테이너 안에 있는 스캐너 가져옴
            //nextLine()쓰는 이유> 엔터치기 전까지 쓴 모든 문자열을 리턴하기 때문
            //next()> 공백을 기준으로 문자, 문자열 입력받음
            //trim > 종료 구문 넣을때 스페이스 공백 없애줄려고 씀
            //구문 해석> String 문장 ~을 한다. = Container 의 get.Scanner()의 문자, 문자열을 실행 할텐데, 공백을 없애줘라
            //command 패턴 예시 > 난 너를 사랑해 라는 구문이 있다면 command를 쓸때 (난 너를 사랑함)을 한다.
            if (command.equals("종료")) { //시스템 컨드롤러 작동하면 구문 종료
                systemController.exit();
                break;
            } else if (command.equals("등록")) {
                wiseSayingController.write();
            } else if (command.equals("목록")) {
                wiseSayingController.list();
            } else if (command.startsWith("삭제")) { //이퀄은 값이 동일하게 들어올 경우만 성립.
                // 삭제라는 명령이 들어왔는지 확인
                //startwiths>문자열이특정 문자나 문자열로 끝나는지 확인할 수 있는 함수
                String[] commandBits = command.split("\\?", 2);
                //regex > 문자열을 구분하기 위한 정규표현
                //limit > 분류할 문자열의 수

                String actionCode = commandBits[0];
                String[] paramsBits = commandBits[1].split("&");

                Map<String, String> params = new HashMap<>();

                for (String paramsStr : paramsBits) {
                    String[] paramsStrBits = paramsStr.split("=", 2);
                    String key = paramsStrBits[0];
                    String value = paramsStrBits[1];
                    System.out.println(key + value);
                }
                System.out.println(params);
                wiseSayingController.remove();
            }
        }
    }
}


