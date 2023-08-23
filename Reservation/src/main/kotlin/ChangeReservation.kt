import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoUnit

//6번을 누르면 예약을 변경/취소를 선택하는 함수를 호출
fun changeReservation() {
    while (true) {
        println("예약을 변경할 사용자 이름을 입력해주세요: (탈출은 exit)")
        val nameList = reservations.map { it.name }.distinct() // map은 리스트의 각 요소를 변환, distinct는 중복을 제거
        nameList.forEachIndexed { index, name -> // forEachIndexed는 index와 값을 함께 반환
            println("${index + 1}. $name") // 예약자 목록의 이름들을 출력
        }
        val name = readlnOrNull() ?: ""  // 사용자 이름을 입력받는다.

        if (name == "exit") { // exit를 입력하면
            break // while 문을 종료
        }

        val userReservations = reservations.filter { it.name == name } // filter는 조건에 맞는 요소들을 반환
        if (userReservations.isEmpty()) { // 이름이 같은 예약이 없으면
            println("해당 사용자의 예약이 없습니다.") // 메시지 출력
            continue // while 문의 처음으로 돌아간다.
        } else { // 이름이 같은 예약이 있으면
            while (true) {
                println("$name 님이 예약한 목록입니다. 변경하실 예약 번호를 입력해주세요") // 메시지 출력
                userReservations.forEachIndexed { index, reservation -> //이름이 같은 예약들을 출력
                    println("${index + 1}. 방번호: ${reservation.roomNumber}, 체크인 날짜: ${reservation.checkInDate}, 체크아웃 날짜: ${reservation.checkOutDate}")
                }

                val inputIndex = (readlnOrNull() ?: "") // 예약이 완료된 번호를 입력받는다.

                if (inputIndex == null || inputIndex < 1.toString() || inputIndex > userReservations.size.toString()) { // 예약 목록에 없는 번호를 입력하면
                    println("예약 목록에 없는 예약 번호입니다.") // 메시지 출력
                    continue // while 문의 처음으로 돌아간다.
                } else { // 예약 목록에 있는 번호를 입력하면
                    val selectedReservation =
                        userReservations[inputIndex.toInt() - 1] // 선택한 예약을 selectedReservation에 저장
                    println("해당 예약을 어떻게 하시겠습니까? 1. 변경 2. 취소 / 이외 번호. 메뉴로 돌아가기") // 해당 예약에 관해 선택할 수 있는 메뉴를 출력
                    val choice = (readlnOrNull() ?: "").toIntOrNull() ?: 0 // 선택한 번호를 choice에 저장한다. 만약 null이면 0을 저장
                    when (choice) { // 선택한 번호에 따라
                        1 -> { // 1번을 누르면
                            changeReservationDetails(selectedReservation) // 예약 변경 함수를 호출
                            break  // while 문을 종료
                        }

                        2 -> { // 2번을 누르면
                            cancelReservation(selectedReservation) // 예약 취소 함수를 호출
                            break // while 문을 종료
                        }

                        else -> break // 이외의 번호를 누르면 while 문을 종료한다. 번호를 다시 입력 받게한다.
                    }
                }
            }
        }
    }
}

// 예약 변경 함수
fun changeReservationDetails(reservation: Reservation) {
    println("방번호를 입력해주세요.")
    reservation.roomNumber =
        (readlnOrNull() ?: "").toIntOrNull() ?: reservation.roomNumber // 방 번호를 입력받는다. null이면 기존 방 번호를 저장

    val dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd") // 날짜 형식을 지정

    while (true) {
        while (true) {
            try {
                println("체크인 날짜를 입력해주세요 (예: ${LocalDate.now().format(dateFormatter)}):") // 체크인 날짜를 입력받는다.
                val inputCheckInDate = LocalDate.parse(readlnOrNull(), dateFormatter) // 입력한 체크인 날짜를 임시 변수에 저장

                if (inputCheckInDate >= LocalDate.now()) { // 입력한 체크인 날짜가 오늘 이후인지 확인
                    val overlappingReservation = reservations.firstOrNull { // 입력한 체크인 날짜와 체크아웃 날짜 사이에 예약이 있는지 확인
                        it.roomNumber == reservation.roomNumber // 같은 방 번호인지 확인
                                && ((it.checkInDate < inputCheckInDate && it.checkOutDate > inputCheckInDate) // 체크인 날짜가 겹치는지 확인
                                || (it.checkInDate < inputCheckInDate.plusDays(1) && it.checkOutDate >= inputCheckInDate.plusDays(
                            1
                        ))) // 체크아웃 날짜가 겹치는지 확인
                    } // firstOrNull은 조건에 맞는 첫 번째 요소를 반환. 없으면 null 을 반환.

                    if (overlappingReservation == null) { // 겹치는 예약이 없으면
                        reservation.checkInDate = inputCheckInDate // 겹치지 않는 경우에만 입력한 체크인 날짜를 저장
                        break // while 문을 종료
                    } else { // 겹치는 예약이 있으면
                        println("해당 날짜에 이미 방을 사용 중입니다. 다른 날짜를 입력해주세요.") // 메시지 출력
                    }
                } else { // 입력한 체크인 날짜가 오늘 이전이면
                    println("체크인은 지난날은 선택할 수 없습니다.")// 메시지 출력
                }
            } catch (e: DateTimeParseException) { // 날짜 형식이 올바르지 않으면
                println("날짜 형식이 올바르지 않습니다.") // 메시지 출력
            }
        }
        try {
            println("체크아웃 날짜를 입력해주세요 (예: ${LocalDate.now().plusDays(1).format(dateFormatter)}):") // 체크아웃 날짜를 입력받는다.
            reservation.checkOutDate = LocalDate.parse(readlnOrNull(), dateFormatter) // 입력한 체크아웃 날짜를 저장

            if (reservation.checkOutDate > reservation.checkInDate) { // 체크인 날짜가 오늘 이후면
                break // while 문을 종료
            } else { // 체크인 날짜가 오늘 이전이면
                println("체크아웃은 체크인 이후 날짜여야 합니다.") // 메시지 출력
            }
        } catch (e: DateTimeParseException) { // 날짜 형식이 올바르지 않으면
            println("날짜 형식이 올바르지 않습니다.") // 메시지 출력
        }

        var isDateRangeOverlapping = false // 날짜가 겹치는지 확인하는 변수를 선언

        for (existingReservation in reservations) { // 예약 목록을 순회하며
            if (existingReservation != reservation && existingReservation.roomNumber == reservation.roomNumber) { // 같은 방 번호인 경우에만
                if (!((reservation.checkInDate >= existingReservation.checkOutDate) || (reservation.checkOutDate <= existingReservation.checkInDate))) { // 날짜가 겹치는지 확인
                    isDateRangeOverlapping = true // 겹치면 true를 저장하고
                    break // for 문을 종료
                } // 날짜가 겹치지 않으면 false를 저장
            }
        }

        if (!isDateRangeOverlapping) { // 날짜가 겹치지 않으면
            println("예약 변경이 완료되었습니다.") // 메시지 출력
            break // while 문을 종료
        } else { // 날짜가 겹치면
            println("해당 기간에 이미 방을 사용 중입니다. 다른 날짜를 입력해주세요.") // 메시지 출력.
        } // while 문을 다시 반복
    }
}

// 예약 취소 함수
fun cancelReservation(reservation: Reservation) {
    println("[취소 유의사항]") // 취소 유의사항을 출력한다.
    println("3일 이전: 0%, 5일 이전: 30%, 7일 이전: 50%, 14일 이전: 80%, 30일 이전: 100% 환불") // 환불 규정을 출력.
    print("동의 하시겠습니까? (Y/N) : ") // 동의 여부를 묻는다.
    val choice = readlnOrNull() ?: "" // 동의 여부를 입력받는다. 입력이 없으면 빈 문자열을 반환.
    val refundPercentage = // 환불 비율을 계산.
        when (ChronoUnit.DAYS.between(LocalDate.now(), reservation.checkInDate)) { // between은 두 날짜 사이의 차이를 반환.
            in 30..Int.MAX_VALUE -> 100 // Int.MAX_VALUE는 Int의 최대값을 의미한다.
            in 14..29 -> 80 // 14부터 29일 차이는 80% 환불한다.
            in 7..13 -> 50 // 7부터 13일 차이는 50% 환불한다.
            in 5..6 -> 30 // 5부터 6일 차이는 30% 환불한다.
            in 3..4 -> 0 // 5부터 6일 차이는 30% 환불한다.
            else -> 0 // 그 외에는 0% 환불한다.
        }
    if (choice == "Y" || choice == "y") { // 동의하면
        reservations.remove(reservation) // 예약 목록에서 해당 예약을 삭제.
        println("예약이 취소되었으며, 취소된 예약에 대해 $refundPercentage% 환불 예정입니다.") // 메시지를 출력.
    } else { // 동의하지 않으면
        println("예약이 취소되지 않았습니다.") // 메시지를 출력.
    }

}