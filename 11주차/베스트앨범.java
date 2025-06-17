import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreSum = new HashMap<>();
        Map<String, List<Song>> genreSongs  = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genreSum.put(genre, genreSum.getOrDefault(genre, 0) + play);
            genreSongs.putIfAbsent(genre, new ArrayList<>());
            genreSongs.get(genre).add(new Song(i, play));
        }

        //genreSum value 기준 내림차순
        ArrayList<String> sortedGenres = new ArrayList<>(genreSum.keySet());
        sortedGenres.sort((a, b) -> genreSum.get(b) - genreSum.get(a));

        //genreSongs value의 hashmap의 value 기준 내림차순, 같으면 key 기준 오름차순
        for (String genre : genreSongs.keySet()) {
            List<Song> songs = genreSongs.get(genre);

            songs.sort((a, b) -> {
                if (a.play != b.play) return b.play - a.play;
                else return a.index - b.index;
            });
        }

        //genreSum keyset순회하면서 map에서 인덱스 출력
        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            int genreCnt = 0;
            for (Song song : genreSongs.get(genre)) {
                if (genreCnt > 1) break;
                result.add(song.index);
                genreCnt++;
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    private static class Song {
        int index;
        int play;

        public Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }
}
