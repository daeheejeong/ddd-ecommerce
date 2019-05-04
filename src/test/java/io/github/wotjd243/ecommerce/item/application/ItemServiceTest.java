package io.github.wotjd243.ecommerce.item.application;

import io.github.wotjd243.ecommerce.item.application.dto.ItemResponseDto;
import io.github.wotjd243.ecommerce.item.application.dto.ItemRequestDto;
import io.github.wotjd243.ecommerce.item.domain.Item;
import io.github.wotjd243.ecommerce.item.domain.search.*;
import io.github.wotjd243.ecommerce.item.infra.DummyItemRepository;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemServiceTest {
    ItemService service = new ItemService(new DummyItemRepository());

    @Test(expected = IllegalArgumentException.class)
    public void 키워드가_3글자_미만일_경우() {
        new QueryKeyword("DD");
    }

    @Test
    public void 물품_전체_검색() {
        List<ItemResponseDto> items = service.findAll();
        assertThat(items.size()).isNotNull();
    }

    @Test
    public void 키워드를_기준으로_검색한다() {
        ItemRequestDto request = new ItemRequestDto("DDD란", 12.3, "http://www.naver.com");
        ItemResponseDto response = service.register(request);
        List<ItemResponseDto> items = service.findItems("DDD");

        assertThat(items).contains(response);
    }

    @Test
    public void 물품을_등록한다() {
        int preSize = service.findAll().size();
        ItemRequestDto request = new ItemRequestDto("DDD란", 12.3, "http://www.naver.com");
        ItemResponseDto response = service.register(request);

        assertThat(service.findAll().size()).isEqualTo(preSize + 1);
        assertThat(request.getTitle()).isEqualTo(response.getTitle());
    }
}