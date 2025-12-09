// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     ScrabbleWordScorerData data = Converter.fromJsonString(jsonString);

package com.apiverve.scrabblescorer.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static ScrabbleWordScorerData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(ScrabbleWordScorerData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(ScrabbleWordScorerData.class);
        writer = mapper.writerFor(ScrabbleWordScorerData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// ScrabbleWordScorerData.java

package com.apiverve.scrabblescorer.data;

import com.fasterxml.jackson.annotation.*;

public class ScrabbleWordScorerData {
    private String word;
    private String language;
    private long totalScore;
    private long letterCount;
    private HighestScoringLetter[] letterScores;
    private HighestScoringLetter highestScoringLetter;
    private double averageLetterScore;
    private String note;

    @JsonProperty("word")
    public String getWord() { return word; }
    @JsonProperty("word")
    public void setWord(String value) { this.word = value; }

    @JsonProperty("language")
    public String getLanguage() { return language; }
    @JsonProperty("language")
    public void setLanguage(String value) { this.language = value; }

    @JsonProperty("total_score")
    public long getTotalScore() { return totalScore; }
    @JsonProperty("total_score")
    public void setTotalScore(long value) { this.totalScore = value; }

    @JsonProperty("letter_count")
    public long getLetterCount() { return letterCount; }
    @JsonProperty("letter_count")
    public void setLetterCount(long value) { this.letterCount = value; }

    @JsonProperty("letter_scores")
    public HighestScoringLetter[] getLetterScores() { return letterScores; }
    @JsonProperty("letter_scores")
    public void setLetterScores(HighestScoringLetter[] value) { this.letterScores = value; }

    @JsonProperty("highest_scoring_letter")
    public HighestScoringLetter getHighestScoringLetter() { return highestScoringLetter; }
    @JsonProperty("highest_scoring_letter")
    public void setHighestScoringLetter(HighestScoringLetter value) { this.highestScoringLetter = value; }

    @JsonProperty("average_letter_score")
    public double getAverageLetterScore() { return averageLetterScore; }
    @JsonProperty("average_letter_score")
    public void setAverageLetterScore(double value) { this.averageLetterScore = value; }

    @JsonProperty("note")
    public String getNote() { return note; }
    @JsonProperty("note")
    public void setNote(String value) { this.note = value; }
}

// HighestScoringLetter.java

package com.apiverve.scrabblescorer.data;

import com.fasterxml.jackson.annotation.*;

public class HighestScoringLetter {
    private String letter;
    private long score;

    @JsonProperty("letter")
    public String getLetter() { return letter; }
    @JsonProperty("letter")
    public void setLetter(String value) { this.letter = value; }

    @JsonProperty("score")
    public long getScore() { return score; }
    @JsonProperty("score")
    public void setScore(long value) { this.score = value; }
}