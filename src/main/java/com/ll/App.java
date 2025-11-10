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
                        if (motivationList.get(i).getMotiv().length() > 7) {
                            System.out.printf("%d / %s / %s \n", motivationList.get(i).getId(), motivationList.get(i).getMotiv().substring(0,7) + "...", motivationList.get(i).getWriter());
                        }
                        else {
                            System.out.printf("%d / %s / %s \n", motivationList.get(i).getId(), motivationList.get(i).getMotiv(), motivationList.get(i).getWriter());
                        }
                    }
                }
            }
            else if(cmd.startsWith("delete")) {
                String[] deleteWords = cmd.split(" ");
                int deleteId = Integer.parseInt(deleteWords[1]);
                Motivation foundMotivation = null;
                for (Motivation motivation : motivationList) {
                    if (motivation.getId() == deleteId) {
                        foundMotivation = motivation;
                    }
                }
                if(foundMotivation == null) {
                    System.out.println("해당 명언은 없습니다!");
                    continue;
                }

                motivationList.remove(foundMotivation);
                System.out.println(deleteId + "번 명언이 삭제되었습니다");


            }
            else {
                System.out.println("해당 명령어는 없는 명령어입니다");
            }
        }
    }
}