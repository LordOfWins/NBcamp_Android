import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

// 1번을 누르면 방 예약을 진행하는 함수를 호출한다.
fun processReservation() {

    println("예약하시는 분의 성함을 입력해주세요:") // 이름을 입력받게 하는 메시지 출력
    val name = readlnOrNull() ?: "" // 이름을 입력받는다.
    if (name == "") { // 이름이 없으면
        println("예약자의 성함은 필수 입력 사항입니다.") // 메시지 출력
        processReservation() // 함수 다시 호출
    } else if (reservations.any { it.name == name }) { // 동일한 이름이 이미 예약되어 있으면
        println("이미 예약된 이름입니다.") // 메시지 출력
        reservations.forEachIndexed { index, it -> // 예약 목록을 출력
            println(
                "${index + 1}. 사용자: ${it.name}, 방 번호: ${it.roomNumber}, 체크인 날짜: ${it.checkInDate}, 체크아웃 날짜: ${
                    it.checkOutDate
                }"
            )
        }
        println("계속하시겠습니까? (Y/N)") // 계속하시겠습니까? (Y/N) 출력
        when (readlnOrNull()) {
            "Y", "y" -> { // Y 또는 y를 입력받으면c
                // 아무것도 하지 않는다.
            }

            "N", "n" -> { // N 또는 n을 입력받으면
                return // 함수 종료
            }

            else -> { // 그 외의 입력을 받으면
                println("잘못된 입력입니다.") // 메시지 출력
                processReservation() // 함수를 다시 호출
            }
        }
    }
    var roomNumber: Int
    while (true) {
        println("예약할 방 번호를 입력해주세요:") // 메시지 출력
        roomNumber = readlnOrNull()?.toIntOrNull() ?: 0 // 방 번호를 입력받는다.

        if (roomNumber in 100..999) { // 방 번호가 100~999 사이면
            break // while 문을 종료한다.
        } else {
            println("올바르지 않은 방번호 입니다. 방번호는 100~999 사이여야 합니다.") // 메시지 출력
        }
    } // 100~999 사이일 때까지 입력 받는다.

    val dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd") // 날짜 형식을 지정

    var checkInDate: LocalDate? // 체크인 날짜를 저장할 변수를 선언
    var checkOutDate: LocalDate? // 체크아웃 날짜를 저장할 변수를 선언
    while (true) {
        while (true) {
            try {
                println("체크인 날짜를 입력해주세요 (예: ${LocalDate.now().format(dateFormatter)}):") // 체크인 날짜를 입력 빋게 하는 메시지 출력
                checkInDate = LocalDate.parse(readlnOrNull(), dateFormatter) // 체크인 날짜를 입력받는다.
                if (checkInDate >= LocalDate.now()) { // 체크인 날짜가 오늘 이후일 때
                    val overlappingReservation = reservations.firstOrNull {// firstOrNull 은 해당하는 값이 없으면 null 을 반환
                        it.roomNumber == roomNumber // 방 번호가 같은 예약을 찾는다.
                                && ((it.checkInDate <= checkInDate && it.checkOutDate > checkInDate) // 체크인 날짜와 체크아웃 날짜 사이에 겹치는 예약을 찾는다.
                                || (it.checkInDate < checkInDate.plusDays(1) //체크인 날짜가 하루 뒤에 겹치는 예약을 찾는다.
                                && it.checkOutDate >= checkInDate.plusDays(1))) // 체크아웃 날짜가 겹치는 예약을 찾는다.
                    } // 체크인 날짜가 겹치는 예약을 찾는다.
                    if (overlappingReservation == null) { // 겹치는 예약이 없으면
                        break // while 문을 종료
                    } else { // 겹치는 예약이 있으면
                        println("해당 날짜에 이미 방을 사용 중입니다. 다른 날짜를 입력해주세요.") // 메시지 출력
                    }
                } else { // 체크인 날짜가 오늘 이전이면
                    println("체크인은 지난날은 선택할 수 없습니다.") // 메시지 출력
                }
            } catch (e: DateTimeParseException) { // 날짜 형식이 올바르지 않으면
                println("날짜 형식이 올바르지 않습니다.") // 메시지 출력
            }
        }

        while (true) {
            try {
                println("체크아웃 날짜를 입력해주세요 (예: ${LocalDate.now().plusDays(1).format(dateFormatter)}):")
                checkOutDate = LocalDate.parse(readlnOrNull(), dateFormatter) // 체크아웃 날짜를 입력받는다.

                if (checkOutDate > checkInDate) { // 체크인 날짜가 오늘 이후면
                    break // while 문을 종료한다.
                } else { // 체크인 날짜가 오늘 이전이면
                    println("체크아웃은 체크인 이후 날짜여야 합니다.") // 메시지 출력
                }
            } catch (e: DateTimeParseException) { // 날짜 형식이 올바르지 않으면
                println("날짜 형식이 올바르지 않습니다.") // 메시지 출력
            }
        }
        val reservation = checkInDate?.let {
            checkOutDate?.let { it1 ->
                Reservation(name, roomNumber, it, it1)
            } // checkOutDate 와 checkInDate 사이의 체크인 날짜가 null 이 아니면 Reservation 객체를 생성
        }
        if (reservation != null) {
            var isDateRangeOverlapping = false // 기간이 겹치는지 여부를 저장할 변수를 선언
            for (existingReservation in reservations) { // 예약 목록을 순회
                if (existingReservation.roomNumber == reservation.roomNumber && !((reservation.checkInDate >= existingReservation.checkOutDate) || (reservation.checkOutDate <= existingReservation.checkInDate))) {
                    // 방 번호가 같고, 기존 예약의 체크인 날짜와 체크아웃 날짜 사이에 겹치는 예약이 있으면
                    isDateRangeOverlapping = true// 기간이 겹친다고 표시
                    break
                }
            }
            if (!isDateRangeOverlapping) { // 기간이 겹치지 않으면
                reservations.add(reservation) // 예약 목록에 추가하고
                println("예약이 완료되었습니다.") // 메시지 출력
                break // while 문을 종료
            } else { // 기간이 겹치면
                println("해당 기간에 이미 방을 사용 중입니다. 다른 날짜를 입력해주세요.") // 메시지 출력
            } //
        } else { // 체크인 날짜가 null 이면
            println("체크인 및 체크아웃 날짜를 올바르게 입력해주세요.") // 메시지 출력
        }
    }
}