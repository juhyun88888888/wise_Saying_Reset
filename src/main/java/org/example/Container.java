package org.example;

import java.util.Scanner;

public class Container {
    private static Scanner sc; //클래스 내부에서만 스캐너 접근

    public static void init() { //sc 초기값 = new Scanncer로 선언
        sc = new Scanner(System.in);
    }

    public static void close() {
        sc.close();
    }

    public static Scanner getScannner() { //static으로 Scanner가져옴
        return sc; // 위에서 받은 sc(new Scanner) 반환
    }
}

//스태틱의 구조적 표현
//