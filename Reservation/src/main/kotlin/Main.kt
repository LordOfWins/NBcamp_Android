import java.time.LocalDate

val reservations = mutableListOf<Reservation>()

fun main() {
    while (true) { // while 문으로 짠다.
        println("호텔 예약 프로그램입니다.")
        println("[메뉴]")
        println("1. 방 예약 2. 예약 목록 출력 3. 예약 목록 (정렬) 출력 4. 시스템 종료 5. 금액 입금-출금 내역 목록 출력 6.예약 변경/취소")
        when (readlnOrNull()
            ?: "") { // readLine()으로 입력받고 그 번호가 1이면 방예약, 2이면 예약목록 출력, 3. 예약목록 (정렬) 출력, 4. 시스템 종료, 5. 금액 입금-출금 내역 목록 출력 6. 예약 변경/출력
            "1" -> processReservation() // 1번을 선택하면 방예약을 진행한다.
            "2" -> printReservationList() // 예약 목록 출력
            "3" -> printSortedReservationList() // 예약 목록 (정렬) 출력
            "4" -> exitSystem() // 시스템 종료
            "5" -> printPaymentHistory() // 금액 입금-출금 내역 목록 출력
            "6" -> changeReservation() // 예약 변경/취소
            else -> println("잘못된 입력입니다.")
        }
    }
}


data class Reservation(
    val name: String, var roomNumber: Int, var checkInDate: LocalDate, var checkOutDate: LocalDate
)

