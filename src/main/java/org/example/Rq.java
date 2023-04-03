package org.example;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String actionCode; //삭제인지 목록인지를 결정하는 코드
    private Map<String, String> params = new HashMap<>();

    public Rq(String command) {
        String[] commandBits = command.split("\\?", 2); // 문자열 CommandBits는 commnad에 입력받은 것을 ? 기준으로 두개로 나눈다.
        //regex > 문자열을 구분하기 위한 정규표현
        //limit > 분류할 문자열의 수

        actionCode = commandBits[0]; // 문자 actionCode는 commandBits의 인덱스 0번
        //등록 혹은 종료일 경우 여기까지 실행 or ?옵션이 없으면 여기까지 실행.
        if (commandBits.length == 1) return; //if 커맨드 비츠에 배열이 1개면 리턴.
        params = new HashMap<>(); //HashMap parmas 선언 문자열과 문자열로 받을것.
        String[] paramsBits = commandBits[1].split("&"); //문자열 paramsBits는 commnadBit 인덱스1번을 & 기준으로 나눈다.

        for (String paramsStr : paramsBits) { //parpamsBits
            String[] paramsStrBits = paramsStr.split("=", 2);

            if (paramsStrBits.length == 1) continue; //안정성을 위해 작성된 코드

            String key = paramsStrBits[0];
            String value = paramsStrBits[1];
            params.put(key, value);
        }
    }

    public String getActionCode() {
        return this.actionCode;
    } //프리베이트로 선언한 인스턴스

    public String getParams(String name) {
        return params.get(name);
    }

    public int getIntParams(String name, int defaultValue) {
        try {
            return Integer.parseInt((getParams(name));
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닌 정수.");
        }

        return defaultValue;
    }

}