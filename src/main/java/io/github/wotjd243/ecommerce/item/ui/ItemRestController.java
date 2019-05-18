package io.github.wotjd243.ecommerce.item.ui;

import io.github.wotjd243.ecommerce.item.application.ItemService;
import io.github.wotjd243.ecommerce.item.application.dto.ItemRequestDto;
import io.github.wotjd243.ecommerce.item.application.dto.ItemResponseDto;
import io.github.wotjd243.ecommerce.item.application.dto.PagingDto;
import io.github.wotjd243.ecommerce.item.domain.Seller;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemRestController {
    private final ItemService itemService;

    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{id}")
    public ItemResponseDto getItem(@PathVariable long id) {
        return this.itemService.findItem(id);
    }

    @GetMapping
    public List<ItemResponseDto> searchItems(String keyword, PagingDto paging) {
        if (StringUtils.isBlank(keyword)) {
            return this.itemService.searchAll(paging);
        }

        return this.itemService.searchItems(keyword, paging);
    }

    @GetMapping("/users/{userId}")
    public List<ItemResponseDto> getItemsOwned(@PathVariable String userId) {
        return this.itemService.findItemsOwned(new Seller(userId));
    }

    @PostMapping
    public ItemResponseDto registerItem(String userId, ItemRequestDto itemRequest) {
        return this.itemService.register(new Seller(userId), itemRequest);
    }

    @PutMapping("/{id}")
    public ItemResponseDto sold(@PathVariable long id, int quantity) {
        return this.itemService.sold(id, quantity);
    }

    @PutMapping("/{id}/users/{userId}")
    public ItemResponseDto startSelling(@PathVariable long id, @PathVariable  String userId) {
        return this.itemService.startSelling(new Seller(userId), id);
    }
}