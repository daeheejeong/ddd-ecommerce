package io.github.wotjd243.ecommerce.item.infra;

import io.github.wotjd243.ecommerce.item.domain.Item;
import io.github.wotjd243.ecommerce.item.domain.ItemRepository;
import io.github.wotjd243.ecommerce.item.domain.search.Page;
import io.github.wotjd243.ecommerce.item.domain.search.QueryKeyword;
import io.github.wotjd243.ecommerce.item.domain.search.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DummyItemRepository implements ItemRepository {

    private static List<Item> items = new ArrayList<>();

    static {
        Item item1 = new Item("DDD Start", 25.00, "http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/140.jpg");
        items.add(item1);

        Item item2 = new Item("도메인 주도 설계 구현", 23.00, "http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/139.jpg");
        items.add(item2);

        Item item3 = new Item("자바 성능 튜닝 이야기", 17.50, "http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/138.jpg");
        items.add(item3);

        Item item4 = new Item("자바 네트워크 소녀 Netty", 60.23, "http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/137.jpg");
        items.add(item4);
    }

    @Override
    public List<Item> findAll() {
        return items;
    }

    @Override
    public List<Item> findByQueryKeyword(QueryKeyword queryKeyword) {
        return items.stream()
                .filter(item -> item.match(queryKeyword))
                .collect(Collectors.toList());
    }

    @Override
    public List<List<Item>> findAll(Page page, Sort sort) {
        return null;
    }

    @Override
    public List<List<Item>> findByQueryKeyword(QueryKeyword queryKeyword, Page page, Sort sort) {
        return null;
    }

    @Override
    public Item save(Item item) {
        items.add(item);
        return item;
    }
}