package io.github.wotjd243.ecommerce.item.domain;

import io.github.wotjd243.ecommerce.item.application.dto.ItemResponseDto;
import io.github.wotjd243.ecommerce.item.domain.search.QueryKeyword;
import lombok.Getter;

@Getter
public class Item {
    private Long id = 1L;
    private String sellerId;
    private ItemDetail detail;
    private SellingState sellingState;

    public Item(String sellerId, ItemDetail itemDetail) {
        this.sellerId = sellerId;
        this.detail = itemDetail;
        this.sellingState = SellingState.CANCELED;
    }

    public void activate() {
        this.sellingState = SellingState.ACTIVE;
    }

    public boolean isActive() {
        return sellingState.isActive();
    }

    public boolean contains(QueryKeyword keywords) {
        return this.detail.contains(keywords);
    }

    public ItemResponseDto toDto() {
        return new ItemResponseDto(detail.getTitle(), detail.getPrice(), detail.getGalleryUrl(), sellingState.value);
    }

    public String getTitle() {
        return detail.getTitle();
    }

    public boolean checkOwner(String sellerId) {
        return this.sellerId == sellerId;
    }

    @Getter
    public enum SellingState {
        ACTIVE("Active"),
        CANCELED("Canceled"),
        ENDED("Ended"),
        ENDED_WITH_SALES("EndedWithSales"),
        ENDED_WITHOUT_SALES("EndedWithoutSales");

        private final String value;

        SellingState(String value) {
            this.value = value;
        }

        public boolean isActive() {
            return (this == ACTIVE);
        }
    }
}
