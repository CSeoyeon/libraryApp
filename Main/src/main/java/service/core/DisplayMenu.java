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

    public void warning_showingText1(){
        System.out.println("잘못된 입력입니다.");
    }

    //0
    public void quit(){
        System.out.println("서비스를 종료합니다.");
        quit();
    }

    //1
    public void registerBorrower_showingText1(){
        System.out.println("등록 할 이용자의 아이디를 입력하세요.");
    }
    public void registerBorrower_showingText2(){
        System.out.println("등록 할 이용자의 이름을 입력하세요.");
    }

    //2
    public void registerBook_showingText1(){
        System.out.println("등록 할 책의 고유번호를 입력하세요");
    }
    public void registerBook_showingText2(){
        System.out.println("등록 할 책의 이름을 입력하세요.");
    }
    public void registerBook_showingText3(){
        System.out.println("등록 할 책의 저자를 입력하세요." + "\n" + "저자가 여러명인 경우 ,(쉼표)를 붙여주세요");

    }

    //3
    public void showingLoanPossibleBook_showingText1(int number){
        System.out.printf("대출 가능한 책은 %d건 입니다. %n",number);
    }

    //4
    public void showingLoanImpossibleBook_showingText1(int number)
    {
        System.out.printf("대출 가능한 책은 %d건 입니다. %n", number);
    }

    //5
    public void LoanBook_showingText1(){
        System.out.println("이용자의 아이디를 입력하세요");
    }
    public void LoanBook_showingText2(){
        System.out.println("등록되지 않은 이용자입니다.");
    }
    public void LoanBook_showingText3(){
        System.out.println("대출 가능한 권수(5권)을 모두 대출하셨습니다.");
    }
    public void LoanBook_showingText4(){
        System.out.println("대출할 책의 고유 번호를 입력하세요.");
    }
    public void LoanBook_showingText5(){
        System.out.println("대출이 완료되었습니다.");
    }


    //6
    public void ReturnBook_showingText1(){
        System.out.println("반납 할 책의 고유번호를 입력하세요.");
    }
    public void ReturnBook_showingText2(){
        System.out.println("반납 완료하였습니다");
    }






}
