package com.ll;

import java.util.Scanner;

public class App {

    Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run(){
        System.out.println("==motivation App 실행==");

        while(true){
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if(cmd.equals("exit")){
                System.out.println("motivation App 종료");
                break;
            }

            else if (cmd.length() == 0) {
                System.out.println("명령어가 입력되지 않았습니다");
                continue;
            }

            if(cmd.equals("add")) {
                System.out.print("내용 : ");
                String motiv = sc.nextLine().trim();
                System.out.println("저자 : ");
                String writer = sc.nextLine().trim();
                System.out.println("명언 생성 완료");
            }
            if(cmd.equals("list")){
                System.out.println("번호 / 명언 / 저자 ");
                System.out.printf(" 1    / %s", "%^&*/ !^#\n");
            }


        }



    }

}