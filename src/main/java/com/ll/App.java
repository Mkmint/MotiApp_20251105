package com.ll;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class App {

    Scanner sc;

    List<Motivation> motivationList = new ArrayList<>();

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run(){
        int lastId = 0;
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

            else if(cmd.equals("add")) {
                lastId++;
                System.out.print("내용 : ");
                String motiv = sc.nextLine().trim();
                System.out.print("저자 : ");
                String writer = sc.nextLine().trim();
                System.out.println((lastId) + "번 명언 생성 완료");

                Motivation motivation = new Motivation(lastId, motiv, writer);

                motivationList.add(motivation);

            }
            else if(cmd.equals("list")){
                System.out.println("번호 / 명언 / 저자 ");

                if(motivationList.isEmpty()) {
                    System.out.println("해당 사항이 없습니다");
                }
                else {
                    for (int i = motivationList.size() - 1; i >= 0; i--) {
                        System.out.printf("%d / %s / %s \n", motivationList.get(i).id,
                                motivationList.get(i).motiv.substring(0,7) + "...", motivationList.get(i).writer);
                    }
                }
            }
            else if(cmd.equals("delete")){
                System.out.println("삭제할 번호를 입력하세요");
                String id = sc.nextLine().trim();

            }
            else {
                System.out.println("해당 명령어는 없는 명령어입니다");
            }
        }
    }
}