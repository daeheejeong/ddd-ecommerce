# e-commerce

## 요구 사항
- 쇼핑몰의 상품 조회 주문을 ddd로 구현한다.

- 사용자
    - [X]  사용자는 고유한 ID를 가지고 있다.

- 판매자
    - [X]  판매자는 자신의 사용자 ID를 가지고 있다. 
    - [X]  판매자는 판매할 물품을 등록할 수 있다
    - [X]  판매자는 자신이 등록한 물품 목록을 볼 수 있다.

- 구매자
    - [X]  구매자는 자신의 사용자 ID와 배송지 주소를 가지고 있다. 
    - [X]  구매자는 자신이 주문한 물품의 목록을 조회할 수 있다.
    - [ ]  구매자는 등록되어 있는 물품 중 선택하여 장바구니에 추가할 수 있다.
    - [ ]  구매자는 자신의 장바구니에 들어있는 물품의 목록을 조회할 수 있다.    
    - [ ]  구매자는 자신의 장바구니에 들어있는 물건을 구매할 수 있다.
    
- 물품
    - [X]  물품은 이름, 이미지, 가격정보, 상태정보를 가지고 있다. 
    - [X]  물품의 상태정보는 판매전, 판매중, 품절 등이 있다.
    - [ ]  물품은 판매중일 때 재고 범위 내에서 판매가 가능하다.
      
- 검색
    - [X]  검색이란 물품의 정보를 불러오는 기능이다
    - [X]  검색은 물품의 이름, 이미지, 가격정보, 상태정보 등을 불러올 수 있다.
    - [X]  검색은 QueryKeyword 가 필요하다.
    - [X]  검색 결과를 정렬한다.
    - [X]  검색 결과에 조건 필터를 한다.
    - [X]  검색 결과의 출력 갯수를 설정한다.
    
- 주문
    - [X] 주문을 하게되면 고유의 주문번호가 생성된다
    - [X] 주문번호를 통해 구매한 물품리스트를 확인할 수 있다
    - [X] 주문시 구매자정보, 결재수단, 장바구니가 필요하다.
    - [X] 주문금액 총합은 장바구니에 들어있는 물품들의 합계(단가 * 수량)를 통해 구할 수 있다. 

- 결제
    - [ ] 결제시 결제수단(Card, Hp)을 선택할 수 있다.
    - [ ] 결제시 할인율을 적용할 수 있다.
    - [ ] 결제시 포인트를 적용할 수 있다.

- 장바구니
    - [X] 장바구니는 고려중인 물품 리스트로 구성되어 있다.

## 용어 사전

| 한글명 | 영문명 | 설명  |
| --- | --- | --- |
| 사용자 | User | 상품을 판매, 구매하는 유저 |
| 판매자 | Seller | 쇼핑몰에 물품을 판매하는 사용자 |
| 구매자 | Buyer | 쇼핑몰에 물품을 구매하는 사용자 |
| 사용자 ID | UserId | 사용자의 고유 식별자 |
| 판매 | Sell | 판매자가 판매를 위해 물품을 쇼핑몰에 올려놓는 것 |
| 구매 | Buy | 구매자가 판매 중인 물품을 쇼핑몰에서 사는 것 |
| 배송지 주소 | ShippingAddress | 사용자가 물품을 배송받고자하는 주소 |
| 물품 | Item | 사용자가 판매를 위해 쇼핑몰에 올려놓은 상품 |
| 물품 상세 | ItemDetail | 판매와 관련되지 않은 물품에 대한 상세한 정보 : 물품명, 가격, 이미지 URL |
| 물품 ID | ItemId | 상품의 고유 식별자 |
| 물품 상태 | ItemState | 물품의 현재 판매 상태를 나타낸다 : 판매 전(before selling), 판매 중(selling), 매진(sold out) |
| 재고 | Stock | 판매 중인 물품의 남은 수량 |
| 물품 단가 | Price | 물품의 단가, USD를 사용한다. |
| 검색어 | QueryKeyword | 판매 중인 물품의 정보를 검색하기 위한 단어. 최소 3글자 이상을 사용한다. |
| 주문 | Order | 사용자가 쇼핑몰의 판매 물품을 구매하는 것 |
| 주문 ID | OrderId | 주문의 고유 식별자 |
| 주문 물품 | OrderItem | 사용자가 주문한 물품 |
| 주문 상태 | OrderState | 주문 현재 상태를 나타낸다 : 결제 완료(PAY_DONE), 배송 전(BEFORE_DELIVERY), 배송 중(DELIVERING), 배송 완료(DELIVERY_DONE), 구매 완료(ORDER_DONE) |
| 배송 | Delivery | 판매자가 구매자가 구매한 물품들을 배송지로 보내는 것 |
| 결제 | Pay | 주문 시 물품의 값을 지불하는 것 |
| 결제 수단 | PayMethod | 결제를 위한 수단 : 카드(card), 휴대전화(phone) |


## 모델링
- `User`는 고유한 ID를 갖는다.
- `Item`은 고유한 ID를 갖는다.
- `Item`은 물품의 이름, 가격, 수량, 상태를 갖는다.
- `Item`은 다음의 상태값을 갖는다. (BEFORE_SELLING: 판매 전, SELLING: 판매 중, SOLD_OUT: 재고 없음)
- `Item`은 조회 시 가격순, 이름순으로 정렬을 할 수 있다.
