package service.core;

public class DisplayMenu {

    public void displayMenu() {
        System.out.print(
                "========== 선택메뉴 ==========" + "\n" +
                        "0 : 종료" + "\n" +
                        "1 : 이용자 등록" + "\n" +
                        "2 : 서적 등록" + "\n" +
                        "3 : 대출가능서적 출력" + "\n" +
                        "4 : 대출중 서적 출력" + "\n" +
                        "5 : 대출" + "\n" +
                        "6 : 반납" + "\n" +
                        "==========================="  + "\n");
    }

    public void quit(){
        System.out.println("서비스를 종료합니다.");
        quit();
    }

}
