package com.example.clp;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Pipeline {
    private static Properties properties;
    private static String propertiesName = "tokenize,ssplit,pos,lemma,ner";
    private static StanfordCoreNLP stanfordCoreNLP;
    public static Map<String, String> tags = new HashMap();

    private Pipeline() {

    }

    static {
        properties = new Properties();
        properties.setProperty("annotators", propertiesName);
        properties.setProperty("tokenize.language", "es");
    }

    public static StanfordCoreNLP getPipeline() {
        if (stanfordCoreNLP == null) {
            return new StanfordCoreNLP(properties);
        }

        return stanfordCoreNLP;
    }

    static {
        tags.put("CC", " Coordinating conjunction");
        tags.put("CD", "Cardinal number");
        tags.put("DT", "Determiner");
        tags.put("EX", "Existential there");
        tags.put("FW", "Foreign word");
        tags.put("IN", "Preposition or subordinating conjunction");
        tags.put("JJ", "Adjective");
        tags.put("JJR", "Adjective, comparative");
        tags.put("JJS", "Adjective, superlative");
        tags.put("LS", "List item marker");
        tags.put("MD", "Modal");
        tags.put("NN", "Noun, singular or mass");
        tags.put("NNS", "Noun, plural");
        tags.put("NNP", "Proper noun, singular");
        tags.put("NNPS", "Proper noun, plural");
        tags.put("PDT", "Predeterminer");
        tags.put("POS", "Possessive ending");
        tags.put("PRP", "  Personal pronoun");
        tags.put("PRP$", "Possessive pronoun");
        tags.put("RB", "Adverb");
        tags.put("RBR", "Adverb, comparative");
        tags.put("RBS", "Adverb, superlative");
        tags.put("RP", "Particle");
        tags.put("SYM", "Symbol");
        tags.put("TO", "to");
        tags.put("UH", "Interjection");
        tags.put("VB", "Verb, base form");
        tags.put("VBD", "Verb, past tense");
        tags.put("VBG", "Verb, gerund or present participle");
        tags.put("VBN", "Verb, past participle");
        tags.put("VBP", "Verb, non-3rd person singular present");
        tags.put("VBZ", "Verb, 3rd person singular present");
        tags.put("WDT", "Wh-determiner");
        tags.put("WP", "Wh-pronoun");
        tags.put("WP$", "Possessive wh-pronoun");
        tags.put("WRB", "Wh-adverb");
    }
}
