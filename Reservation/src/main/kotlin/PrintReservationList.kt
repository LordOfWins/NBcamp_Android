//2번을 누르면 예약자 목록을 출력하는 함수를 호출
fun printReservationList() {
    println("호텔 예약자 목록입니다.") // 메시지 출력
    reservations.forEachIndexed { index, it -> // forEachIndexed는 index와 값을 함께 반환
        println( // 예약자 목록을 출력
            "${index + 1}. 사용자: ${it.name}, 방 번호: ${it.roomNumber}, 체크인 날짜: ${it.checkInDate}, 체크아웃 날짜: ${
                it.checkOutDate // index는 0부터 시작하므로 1을 더한다.
            }"
        )
    }
}