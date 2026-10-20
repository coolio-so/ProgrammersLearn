package so.coolio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class 베스트_앨범_TEST {
    @Test
    public void BestAlbumTDD() {
        String[] genres = {"classic", "pop", "classic", "classic", "pop", "classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500, 504, 601, 130, 801, 2520};
        Map<String, Music> map = new HashMap<>();

        for(int idx = 0; idx < genres.length; idx++) {
            String gen = genres[idx];
            map.putIfAbsent(gen, new Music());
            map.get(gen).addItem(plays[idx], idx);
            map.get(gen).addTotalPlay(plays[idx]);
        }

        map.entrySet()
           .stream()
           .sorted(Map.Entry.comparingByValue((o1, o2) -> o2.getTotalPlay() - o1.getTotalPlay()))
           .findFirst()
           .ifPresent(item -> {
        	   System.err.println(item.getValue().getItems().subList(0, 2));
                System.err.println(item.getValue());
           });
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class Music {
        private int totalPlay = 0;
        private List<Item> items = new ArrayList<>();

        public void addTotalPlay(int totalPlay) {
            this.totalPlay += totalPlay;
        }

        public void addItem(int play, int idx) {
            this.items.add(new Item(play, idx));
        }
    }

    @Data
    public class Item {
        private final int play;
        private final int idx;

        public Item(int play, int idx) {
            this.play = play;
            this.idx = idx;
        }
    }
}
