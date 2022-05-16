# Kotlin-lotto

## 코드 리뷰 과정

1. 자신의 아이디로 브랜치 생성을 요청한 후, 미션 저장소를 자신의 개인 저장소로 fork 합니다. 
2. 기능과 관련된 적절한 이름의 branch 를 생성 후 commit 합니다.
3. 2번의 과정이 끝나면 local 에만 변경사항이 반영되어 있으므로 본인의 remote 저장소에 push 합니다.
4. 다음 과정은 아래 링크의 코드 리뷰 2단계를 참고하며 진행합니다.

* [next-step 의 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

## Rules

- 모든 코드에 테스트 코드 작성
- depth 1
- First Collection 사용
- Immutable
- 모든 primitive 타입을 포장한다.
- (option) 애플리케이션은 항상 정상적으로 종료되어야 함

## 요구사항

- 구입 금액 입력
- 구입 금액에 따라 1장에 1000원씩 계산하여 로또 발급하기
- 로또 한장에는 6개의 숫자가 담겨있다
- 수동으로 구매한 로또 수 입력
  - 입력한 금액을 벗어나는 경우 예외 처리
- 수동 로또수에 따라 하나의 로또당 6개의 번호를 입력해야함
- 수동 로또를 제외하여 나머지는 자동 로또 발급
- 지난 주 당첨 번호와 보너스볼을 입력
- 당첨번호와 보너스볼과 일치하는 개수에 따라 통계를 내기
- 통계에는 3개 일치, 4개 일치, 5개 일치, 5개 일치 + 보너스볼 , 6개 일치하는 로또 개수를 보여주고, 수익률을 계산한다.(기준 1)
    - 수익률은 당첨 금액 / 원금 으로 계산한다.