# e-commerce


## 요구 사항

- 쇼핑몰의 상품 조회 주문을 ddd로 구현한다.

- 사용자
    - [ ] 사용자는 판매하고자하는 물품을 등록할 수 있다.
    - [ ] 사용자는 구매하고자하는 물품들을 구매할 수 있다.
    - [ ] 사용자는 구매한 물품을 받는 배송지를 관리할 수 있다.
- 물품
    - [ ] 물품을 등록할 때는 물품 재고 수, 상세 정보가 필요하다.
    - [ ] 물품은 상세 정보로 이름, 물품 단가, 이미지 URL을 갖고있다.
    - [ ] 물품 단가의 화폐 단위는 USD를 사용한다.
    - [ ] 물품은 판매자에 의해 물품상태를 변경할 수 있다.
    - [ ] 물품상태는 **판매 전**, **판매 중**, **매진**을 갖는다.
    - [ ] 물품은 재고가 0이 되면 자동으로 **매진**으로 상태가 변경된다.
    - [ ] 물품은 검색어를 통해서 검색할 수 있다.
    - [ ] 물품은 이름 순, 가격 순으로 정렬할 수 있다.
- 주문
    - [ ] **판매 중**인 물품을 주문할 수 있다.
    - [ ] 주문 시 배송지와 결제가 필요하다.
    - [ ] 결제 수단으로는 카드와 휴대전화가 있다.
    - [ ] 판매자는 본인이 등록한 물품의 주문상태를 변경 할 수 있다. (단, 주문 완료는 불가)
    - [ ] 구매자는 배송을 확인 한 후 주문상태를 **주문 완료**로 변경할 수 있다.
    - [ ] 주문상태는 **결제 완료**, **배송 전**, **배송 중**, **배송 완료**, **주문 완료**
    - [ ] 구매자는 주문한 모든 주문 내역을 확인할 수 있다. 
    - [ ] 주문한 모든 물품의 가격의 총합을 구할 수 있다.


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
- `User`는 물품을 등록할 수 있다.
- `User`는 등록된 물품을 주문할 수 있다.
- `User`는 배송지 주소를 관리할 수 있다.
- `Item`은 고유한 ID를 갖는다.
- `Item`은 물품의 물품명, 물품 단가, 이미지 URL, 재고, 물품상태를 갖는다.
- `Item`은 다음의 상태값을 갖는다. (BEFORE_SELLING: 판매 전, SELLING: 판매 중, SOLD_OUT: 재고 없음)
- `Item`은 조회 시 가격순, 이름순으로 정렬을 할 수 있다.
- `Order`는 고유한 ID를 갖는다.
- `Order`는 결제 정보, 배송지 주소, 주문상태를 갖는다.
- `Order`는 다음의 상태값을 갖는다. (PAY_DONE: 결제 완료, BEFORE_DELIVERY: 배송 전, DELIVERING: 배송 중, DELIVERY_DONE: 배송 완료, ORDER_DONE: 구매 완료)
