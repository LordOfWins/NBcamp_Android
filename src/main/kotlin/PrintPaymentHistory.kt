//5번을 누르면 금액 입금-출금 내역을 출력하는 함수를 호출
fun printPaymentHistory() {
    println("금액 입금-출금 내역 목록 출력")
    println("조회하실 이름을 입력하세요:")
    val nameList = reservations.map { it.name }.distinct() // map은 리스트의 각 요소를 변환한다. distinct는 중복을 제거
    nameList.forEachIndexed { index, name -> // forEachIndexed는 index와 값을 함께 반환
        println("${index + 1}. $name")// 예약자 목록을 출력
    } // index는 0부터 시작하므로 1을 더한다.
    val inputName = readlnOrNull() ?: "" // 이름을 입력받는다.
    val foundReservation = reservations.find { it.name == inputName } // find 는 inputName 과 name 이 같은 값이 없으면 null 을 반환
    if (foundReservation == null) { // 예약자 목록에 없으면
        println("예약된 사용자를 찾을 수 없습니다.") // 메시지 출력
    } else { // 예약자 목록에 있으면
        println("1. 초기금액으로 163959원 입금되었습니다.") // 메시지 출력
        println("2. 예약금으로 40682원 출금되었습니다.")
    }
}