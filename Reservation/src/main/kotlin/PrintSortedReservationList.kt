//3번을 누르면 예약자 목록을 정렬하여 출력하는 함수를 호출
fun printSortedReservationList() {
    println("호텔 예약자 목록입니다. (정렬완료)") // 메시지 출력
    reservations.sortedBy { it.checkInDate }.forEach { // sortedBy는 정렬된 리스트를 반환
        println("이름: ${it.name}, 방 번호: ${it.roomNumber}, 체크인 날짜: ${it.checkInDate}, 체크아웃 날짜: ${it.checkOutDate}") // 예약자 목록을 출력
    }
}