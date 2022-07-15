package com.example.ner;


import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class NERReader {

    public void ner() throws IOException {
        String paragraph = "El saldo de tu tarjeta Mastercard Banco Galicia **** 1234 no es suficiente";

        SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE;
        String[] tokens = simpleTokenizer.tokenize(paragraph);

        InputStream inputStreamNameFinder = getClass().getResourceAsStream("/models/es/es-ner-organization.bin");

        TokenNameFinderModel model = new TokenNameFinderModel(inputStreamNameFinder);
        NameFinderME nameFinderME = new NameFinderME(model);
        Span[] names = nameFinderME.find(tokens);

        System.out.println(Arrays.toString(Span.spansToStrings(names, tokens)));
    }


    public void tag() throws IOException {
        String paragraph = "Pagá 12646 peso argentino 86 centavos en Pago Fácil para terminar la compra";
        SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE;
        String[] tokens = simpleTokenizer.tokenize(paragraph);

        InputStream inputStreamNameFinder = getClass().getResourceAsStream("/models/es/es-pos-maxent-v2.bin");

        POSModel model = new POSModel(inputStreamNameFinder);
        POSTaggerME posTaggerME = new POSTaggerME(model);
        System.out.println(Arrays.toString(posTaggerME.getAllPosTags()));
        POSSample posSample = new POSSample(tokens, posTaggerME.tag(tokens));
        String posTokens[] = posSample.getSentence();
        String posTags[] = posSample.getTags();
        for (int i = 0; i < posTokens.length; i++) {
            System.out.println(posTokens[i] + " - " + posTags[i]);
        }
        // System.out.println(Arrays.toString(tags));
    }

    public void token() throws IOException {
        String paragraph = "El saldo de tu tarjeta Mastercard Banco Galicia **** 1234 no es suficiente";

        InputStream inputStreamNameFinder = getClass().getResourceAsStream("/models/es/es-token.bin");

        TokenizerModel model = new TokenizerModel(inputStreamNameFinder);
        TokenizerME tokenizerME = new TokenizerME(model);
        System.out.println(Arrays.toString(Span.spansToStrings(tokenizerME.tokenizePos(paragraph), paragraph)));
    }

    public static void main(String[] args) throws IOException {
        new NERReader().ner();
    }
}
